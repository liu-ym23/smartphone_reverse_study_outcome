package ly2;

import android.os.Looper;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.webview.g;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.monitor.webview.a f511291a;

    /* JADX INFO: renamed from: ly2.a$a, reason: collision with other inner class name */
    public class RunnableC6750a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ py2.d f511292a;

        @Override // java.lang.Runnable
        public final void run() {
            c.b(this.f511292a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6750a(py2.d r100) {
            this.f511292a = r100;
        }
    }

    public a() {
        this.f511291a = new g();
    }

    public static void b(py2.d r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        ExecutorService r101 = ry2.b.a();
        AbstractExecutorService r102 = (AbstractExecutorService) r101;
        r102.submit(new RunnableC6750a(r100));
        return;
    L5:
        c.b(r100);
    }

    public static void a(String r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, boolean r107, com.bytedance.android.monitor.webview.a r108) {
        py2.d r109 = new py2.d();
        r109.f530983c = r102;
        r109.f530981a = r100;
        r109.f530982b = r101;
        r109.f530984d = r103;
        r109.f530985e = r104;
        if (r105 != null) goto L6;
        r105 = new JSONObject();
    L6:
        r109.f530986f = r105;
        r109.f530987g = null;
        if (r106 != null) goto L10;
        r106 = new JSONObject();
    L10:
        r109.f530988h = r106;
        r109.f530990j = r107;
        r109.f530989i = null;
        if (r108 != null) goto L14;
        r108 = HybridMonitor.getInstance().getCustomReportMonitor();
    L14:
        r109.f530991k = r108;
        b(r109);
    }
}
