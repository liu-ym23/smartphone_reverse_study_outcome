package fsb;

import android.text.TextUtils;
import android.view.View;
import androidx.camera.core.RetryPolicy;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static f f478730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f478731f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static com.ss.android.lark.monitor.c f478732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static c f478733h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f478735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ct3.b f478736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fsb.a f478737d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f478738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f478739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f478740c;

        public static void a(a r100) {
            if (r100.f478738a.getViewTreeObserver().isAlive() == false) goto L5;
            r100.f478738a.getViewTreeObserver().removeOnPreDrawListener(r100.f478740c);
        L5:
            r100.f478738a.removeOnAttachStateChangeListener(r100.f478739b);
        }

        public a(String r100, RecyclerView r101) {
            this.f478738a = r101;
            d r102 = new d(this);
            this.f478739b = r102;
            e r103 = new e(this, r100);
            this.f478740c = r103;
            r101.getViewTreeObserver().addOnPreDrawListener(r103);
            r101.addOnAttachStateChangeListener(r102);
        }
    }

    static {
        f478731f = new f("");
        f478732g = null;
    }

    public static synchronized void a() {
        monitor-enter(f.class);
        f r100 = f478730e;     // Catch: Throwable -> L12
        if (r100 == null) goto L7;
        r100.f478736c = null;     // Catch: Throwable -> L12
        r100.f478737d = null;     // Catch: Throwable -> L12
    L7:
        f478730e = null;     // Catch: Throwable -> L12
        if (f478733h == null) goto L10;
        CoreThreadPool.getNonblockingHandler().removeCallbacks(f478733h);     // Catch: Throwable -> L12
        f478733h = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(f.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized f b() {
        monitor-enter(f.class);
        f r100 = f478730e;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        f r101 = f478731f;     // Catch: Throwable -> L11
        monitor-exit(f.class);
        return r101;
    L9:
        monitor-exit(f.class);
        return r100;
    L11:
        th = move-exception;
        throw th;
    }

    public final void d() {
        ct3.b r100 = this.f478736c;
        if (r100 == null) goto L7;
        ct3.f r101 = r100.f465314a;
        if (r101 == null) goto L7;
        r101.f465342c.clear();
        r100.f465314a = null;
    L7:
        a();
    }

    public final void e() {
        Log.i("PageLoadMonitor", "pageComplete: " + this.f478734a);
        ct3.b r100 = this.f478736c;
        if (r100 == null) goto L5;
        r100.a(2, 10000);
    L5:
        fsb.a r101 = this.f478737d;
        if (r101 == null) goto L9;
        r101.f478719d = ((int) (System.nanoTime() - r101.f478717b)) / 1000000;
    L9:
        if (((System.nanoTime() - this.f478735b) / 1000000) < 10000) goto L11;
    L16:
        a();
        return;
    L11:
        if (f478732g == null) goto L16;
        fsb.a r102 = this.f478737d;
        if (r102 == null) goto L16;
        Log.i("PageLoadMonitor", "local ee_lark_android_page_load: " + r102.a());
        goto L16
    }

    public final void g() {
        fsb.a r100 = this.f478737d;
        if (r100 == null) goto L6;
        r100.getClass();
        r100.f478718c = ((int) (System.nanoTime() - r100.f478717b)) / 1000000;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [fsb.c] */
    public final void j() {
        if (TextUtils.isEmpty(this.f478734a) == false) goto L5;
        return;
    L5:
        f478733h = new c(this);
        CoreThreadPool.getNonblockingHandler().postDelayed(f478733h, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        this.f478735b = System.nanoTime();
        ct3.b r100 = new ct3.b(this.f478734a);
        this.f478736c = r100;
        r100.b();
        fsb.a r101 = new fsb.a();
        this.f478737d = r101;
        String r102 = this.f478734a;
        r101.f478717b = System.nanoTime();
        r101.f478716a = r102;
    }

    public f(String r100) {
        this.f478735b = -1;
        this.f478736c = null;
        this.f478737d = null;
        this.f478734a = r100;
    }

    public static synchronized f c(String r100) {
        monitor-enter(f.class);
        Log.i("PageLoadMonitor", "obtain: ".concat(r100));     // Catch: Throwable -> L12
        f r101 = f478730e;     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
    L8:
        a();     // Catch: Throwable -> L12
        f478730e = new f(r100);     // Catch: Throwable -> L12
    L9:
        f r102 = f478730e;     // Catch: Throwable -> L12
        monitor-exit(f.class);
        return r102;
    L7:
        if (r100.equals(r101.f478734a) == true) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public final void f(RecyclerView r100) {
        if (r100 != null) goto L6;
        Log.w("PageLoadMonitor", "Trying to monitor a null view", new Exception());
        return;
    L6:
        Log.i("PageLoadMonitor", "pageComplete: " + this.f478734a + " view:" + r100);
        if (TextUtils.isEmpty(this.f478734a) == false) goto L9;
        return;
    L9:
        new a(this.f478734a, r100);
    }

    public final void h(String r100) {
        ct3.b r101 = this.f478736c;
        if (r101 == null) goto L7;
        ct3.f r102 = r101.f465314a;
        if (r102 == null) goto L7;
        r102.a("", r100);
    L7:
        fsb.a r103 = this.f478737d;
        if (r103 == null) goto L26;
        Iterator<fsb.a.C5948a> r104 = r103.f478720e.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        fsb.a.C5948a r105 = r104.next();
        if (r105.f478721a.equals(r100) == false) goto L11;
    L17:
        if (r105 != null) goto L19;
        Log.d("PageLoadMonitor", "Trying to end a span which not started: " + r103.f478716a + HTTP.URL_DEFAULT + r100);
        return;
    L19:
        r105.f478723c = ((int) (System.nanoTime() - r105.f478722b)) / 1000000;
        if (r105.f478724d.equals(ThreadMethodProxy.currentThread().getName()) == true) goto L28;
        Log.d("PageLoadMonitor", "Trying to end a span in different thread against pageSpanStart: " + ThreadMethodProxy.currentThread().getName() + HTTP.URL_DEFAULT + r105.f478724d);
        return;
    L28:
        return;
    L15:
        r105 = null;
        goto L17
    }

    public final void i(String r100) {
        ct3.b r101 = this.f478736c;
        if (r101 == null) goto L7;
        ct3.f r102 = r101.f465314a;
        if (r102 == null) goto L7;
        r102.d("", r100);
    L7:
        fsb.a r103 = this.f478737d;
        if (r103 == null) goto L20;
        Iterator<fsb.a.C5948a> r104 = r103.f478720e.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        if (r104.next().f478721a.equals(r100) == false) goto L11;
        return;
    L15:
        fsb.a.C5948a r105 = new fsb.a.C5948a();
        r105.f478721a = r100;
        r105.f478722b = System.nanoTime();
        r105.f478724d = ThreadMethodProxy.currentThread().getName();
        r103.f478720e.offer(r105);
        return;
    }
}
