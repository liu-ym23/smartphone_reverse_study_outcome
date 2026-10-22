package uk7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Long> f550538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f550539b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f550540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<String> f550541d = null;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Random f550542a;

        public a(Looper r100) {
            super(r100);
            this.f550542a = new Random(System.currentTimeMillis());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            int r100 = r110.what;
            if (r100 != 101) goto L17;
            StringBuilder r101 = new StringBuilder();
            b r111 = (b) r110.obj;
            Long r102 = (Long) ((HashMap) l.f550538a).get(r111.f550543a);
            if (r102 == null) goto L16;
            long r103 = r111.f550544b - r102.longValue();
            com.bytedance.ug.sdk.luckydog.api.settings.b.C3804b r104 = r111.f550545c;
            if (r103 >= r104.f271605b) goto L16;
            r101.append(" tooFreq(");
            r101.append(r103);
            r101.append("<");
            r101.append(r104.f271605b);
            r101.append(")");
            long r105 = l.f550540c;
            if (r105 < r104.f271606c) goto L13;
            r101.append(" tooMuchReport(");
            r101.append(l.f550540c);
            r101.append(",");
            r101.append(r104.f271606c);
            r101.append(") hasMessages=");
            a r106 = l.f550539b;
            boolean r107 = r106.hasMessages(102);
            r101.append(r107);
            if (r107 == true) goto L16;
            int r108 = this.f550542a.nextInt(Math.max(10, r104.f271608e - r104.f271607d)) + Math.max(r104.f271607d, 10);
            r106.sendEmptyMessageDelayed(102, TimeUnit.SECONDS.toMillis(r108));
            r101.append(" setTimeoutMsgDelay=");
            r101.append(r108);
            goto L16
        L13:
            l.f550540c = r105 + 1;
            JSONObject r109 = new JSONObject();
            r109.put("duration", r103);     // Catch: JSONException -> L21
            r109.put("path", r111.f550543a);     // Catch: JSONException -> L21
        L15:
            com.bytedance.ug.sdk.luckydog.api.log.b.a("ug_sdk_luckydog_network_freq_warning", r109);
            r101.append(" onAppLogEvent reportCount=");
            r101.append(l.f550540c);
        L16:
            ((HashMap) l.f550538a).put(r111.f550543a, Long.valueOf(r111.f550544b));
            r101.append(" lastReqMillis=");
            r101.append(r102);
            r101.append(", path=");
            r101.append(r111.f550543a);
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NetworkFreqCheckInterceptor", r101.toString());
        L19:
            Map<String, Long> r112 = l.f550538a;
            return;
        L17:
            if (r100 != 102) goto L19;
            com.bytedance.ug.sdk.luckydog.api.log.d.a("NetworkFreqCheckInterceptor", "reset reportCount=" + l.f550540c);
            l.f550540c = 0;
            goto L19
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f550543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f550544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ug.sdk.luckydog.api.settings.b.C3804b f550545c;

        public b(String r100, long r101, com.bytedance.ug.sdk.luckydog.api.settings.b.C3804b r102) {
            this.f550543a = r100;
            this.f550544b = r101;
            this.f550545c = r102;
        }
    }

    public l() {
    }

    static {
        f550538a = new HashMap();
        f550540c = 0;
        new MutableLiveData();
        new MutableLiveData();
        new MutableLiveData();
        f550541d = new ArrayList();
        new MutableLiveData();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("luckydog-network");
        ThreadMethodProxy.start(r100);
        f550539b = new a(r100.getLooper());
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        if (r101 == null) goto L5;
        com.bytedance.ug.sdk.luckydog.api.settings.b.C3804b r102 = com.bytedance.ug.sdk.luckydog.api.settings.b.f271598c;
        if (r102 == null) goto L17;
        if (r102.f271604a == false) goto L17;
        String r103 = r101.getPath();
        if (uk7.b.a(r103) == false) goto L15;
        b r104 = new b(r103, SystemClock.elapsedRealtime(), r102);
        a r105 = f550539b;
        Message r106 = r105.obtainMessage(101);
        r106.obj = r104;
        r105.sendMessage(r106);
    L15:
        return r100.proceed(r101);
    L17:
        return r100.proceed(r101);
    L5:
        return r100.proceed(null);
    }
}
