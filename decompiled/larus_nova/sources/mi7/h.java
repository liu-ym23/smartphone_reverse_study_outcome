package mi7;

import android.os.Handler;
import android.os.Looper;
import ci7.z;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f514096a;

    public static Handler c() {
        if (f514096a != null) goto L6;
        f514096a = new Handler(Looper.getMainLooper());
    L6:
        return f514096a;
    }

    public static boolean d() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(Runnable r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        b(r100);
        return;
    L5:
        r100.run();
    }

    public static void b(Runnable r100) {
        IExecutor r101 = (IExecutor) z.a(IExecutor.class);
        if (r101 == null) goto L11;
        r101.execute(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void e(Runnable r100) {
        c().post(r100);
    }

    public static void f(Runnable r100) {
        if (d() == false) goto L5;
        r100.run();
        return;
    L5:
        e(r100);
    }
}
