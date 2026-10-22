package qj7;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.utils.i;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f533363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f533364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f533365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f533366e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f533367a;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f533367a.f533366e;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onFailed(90004, "request_not_http");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(g r100) {
            this.f533367a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f533368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f533369b;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f533369b.f533366e;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSuccess(this.f533368a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(g r100, String r101) {
            this.f533369b = r100;
            this.f533368a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f533370a;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f533370a.f533366e;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onFailed(90001, "response_empty");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(g r100) {
            this.f533370a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f533371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f533372b;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f533372b.f533366e;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onFailed(90003, this.f533371a.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public d(g r100, Throwable r101) {
            this.f533372b = r100;
            this.f533371a = r101;
        }
    }

    public interface e {
        void onFailed(int r100, String r101);

        void onSuccess(String r100);
    }

    public final void a() {
        Handler r100 = new Handler(Looper.getMainLooper());
        String r101 = this.f533363b;     // Catch: Throwable -> L39
        String r102 = this.f533362a;     // Catch: Throwable -> L39
        String r103 = this.f533364c;     // Catch: Throwable -> L39
        if (i.f(r102) == true) goto L8;
        r100.post(new a(this));     // Catch: Throwable -> L39
        return;
    L8:
        if (i.f(r102) == false) goto L48;
        Uri r104 = UriProtector.parse(r102);     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r103) == true) goto L12;
        JSONObject r105 = new JSONObject(r103);     // Catch: Throwable -> L39
        new HashMap();     // Catch: Throwable -> L39
        Map r106 = com.bytedance.ug.sdk.luckycat.utils.e.d(r105);     // Catch: Throwable -> L39
    L14:
        if (r101.toLowerCase().equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L25;
        Uri.Builder r107 = r104.buildUpon();     // Catch: Throwable -> L39
        if (r106.isEmpty() == true) goto L23;
        Iterator r108 = r106.keySet().iterator();     // Catch: Throwable -> L39
    L19:
        if (r108.hasNext() == false) goto L23;
        String r109 = (String) r108.next();     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r109) == true) goto L19;
        r107.appendQueryParameter(r109, (String) r106.get(r109));     // Catch: Throwable -> L39
    L23:
        m r110 = m.a.f271349a;     // Catch: Throwable -> L39
        String r111 = r110.d(r110.b(r107.build().toString()));     // Catch: Throwable -> L39
    L35:
        if (TextUtils.isEmpty(r111) == true) goto L37;
        r100.post(new b(this, r111));     // Catch: Throwable -> L39
        return;
    L37:
        r100.post(new c(this));     // Catch: Throwable -> L39
        return;
    L25:
        if (r101.toLowerCase().equals(UGCMonitor.TYPE_POST) == true) goto L27;
    L33:
        r111 = null;
        goto L35
    L27:
        if ("json".equals(this.f533365d) == false) goto L33;
        if (TextUtils.isEmpty(r103) == false) goto L31;
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L39
    L32:
        m r113 = m.a.f271349a;     // Catch: Throwable -> L39
        r111 = r113.e(r113.b(r102), r112);     // Catch: Throwable -> L39
        goto L35
    L31:
        r112 = new JSONObject(r103);     // Catch: Throwable -> L39
        goto L32
    L12:
        r106 = new HashMap();     // Catch: Throwable -> L39
        goto L14
    L48:
        return;
    L39:
        th = move-exception;
        r100.post(new d(this, th));
    }

    @Override // java.lang.Runnable
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

    public g(String r100, String r101, String r102, String r103, e r104) {
        this.f533362a = r100;
        this.f533363b = r101;
        this.f533364c = r102;
        this.f533365d = r103;
        this.f533366e = r104;
    }
}
