package psa;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f530502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f530503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f530504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f530505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f530506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f530507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f530508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ psa.a f530510j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CertResponse f530511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f530512b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530512b.f530509i.onRequestFinish(new BDResponse(this.f530511a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, CertResponse r101) {
            this.f530512b = r100;
            this.f530511a = r101;
        }
    }

    /* JADX INFO: renamed from: psa.b$b, reason: collision with other inner class name */
    public class RunnableC7242b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f530513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f530514b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530514b.f530509i.onRequestFinish(new BDResponse(this.f530513a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7242b(b r100, Pair r101) {
            this.f530514b = r100;
            this.f530513a = r101;
        }
    }

    public final void a() {
        Map<String, String> r100 = this.f530501a;     // Catch: Exception -> L38
        if (r100 != null) goto L8;
        r100 = new HashMap();     // Catch: Exception -> L38
    L8:
        if (TextUtils.isEmpty(this.f530502b) == true) goto L11;
        r100.put(BytedCertConstant.CertKey.IDENTITY_CODE, this.f530502b);     // Catch: Exception -> L38
    L11:
        if (TextUtils.isEmpty(this.f530503c) == true) goto L14;
        r100.put(BytedCertConstant.CertKey.IDENTITY_NAME, this.f530503c);     // Catch: Exception -> L38
    L14:
        if (TextUtils.isEmpty(this.f530504d) == true) goto L17;
        r100.put("identity_type", this.f530504d);     // Catch: Exception -> L38
    L17:
        if (TextUtils.isEmpty(this.f530505e) == true) goto L19;
        r100.put("type", this.f530505e);     // Catch: Exception -> L38
    L19:
        boolean r101 = "3".equals(this.f530505e);     // Catch: Exception -> L38
        HashMap r102 = new HashMap();     // Catch: Exception -> L38
        if (r101 == true) goto L36;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Exception -> L38
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: Exception -> L38
        int r105 = this.f530506f;     // Catch: Exception -> L38
        if (r105 != 0) goto L24;
        r105 = 85;
    L24:
        Map<String, osa.c> r106 = gsa.a.f482481a;     // Catch: Exception -> L38
        osa.c r107 = (osa.c) ((HashMap) r106).get(NewBroadcastMonitor.CAPTURE.FRONT);     // Catch: Exception -> L38
        byte[] r110 = null;
        if (r107 != null) goto L27;
    L29:
        byte[] r108 = null;
    L30:
        osa.c r109 = (osa.c) ((HashMap) r106).get("hold");     // Catch: Exception -> L38
        if (r109 == null) goto L35;
        Bitmap r111 = r109.f526593a;     // Catch: Exception -> L38
        if (r111 == null) goto L35;
        r111.compress(Bitmap.CompressFormat.JPEG, r105, r104);     // Catch: Exception -> L38
        r110 = psa.a.a(this.f530510j, this.f530507g, r109.f526594b, r104.toByteArray());     // Catch: Exception -> L38
    L35:
        Pair r112 = new Pair("front_image", r108);     // Catch: Exception -> L38
        Pair r113 = new Pair("real_person_image", r110);     // Catch: Exception -> L38
        r102.put("front_image", r112);     // Catch: Exception -> L38
        r102.put("real_person_image", r113);     // Catch: Exception -> L38
        goto L36
    L27:
        if (r107.f526593a == null) goto L29;
        ((osa.c) ((HashMap) r106).get(NewBroadcastMonitor.CAPTURE.FRONT)).f526593a.compress(Bitmap.CompressFormat.JPEG, r105, r103);     // Catch: Exception -> L38
        r108 = psa.a.a(this.f530510j, this.f530507g, r107.f526594b, r103.toByteArray());     // Catch: Exception -> L38
    L36:
        BytedCertManager.getInstance().executeInMainThread(new a(this, this.f530510j.f530473a.postMultiPart(UrlConstant.getManualCheckPath(this.f530508h), r100, r102)));     // Catch: Exception -> L38
        return;
    L38:
        e = move-exception;
        e.printStackTrace();
        int r114 = ErrorConstant.checkClientException(e);
        this.f530510j.f530473a.onExceptionEvent(e, r114);
        BytedCertManager.getInstance().executeInMainThread(new RunnableC7242b(this, new Pair(Integer.valueOf(r114), CertLog.getStackTraceString(e))));
    }

    @Override // com.ss.android.cert.manager.utils.thread.BCThread, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(psa.a r100, Map r101, String r102, String r103, String r104, String r105, int r106, Context r107, boolean r108, SDKCallBack.CommonRequestCallback r110) {
        this.f530510j = r100;
        this.f530501a = r101;
        this.f530502b = r102;
        this.f530503c = r103;
        this.f530504d = r104;
        this.f530505e = r105;
        this.f530506f = r106;
        this.f530507g = r107;
        this.f530508h = r108;
        this.f530509i = r110;
    }
}
