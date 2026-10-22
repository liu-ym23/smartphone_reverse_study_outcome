package gn5;

import android.graphics.Point;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void a() {
        Point r0 = c.e;
        if (c.e != null) goto L29;
        c r1 = this.a;
        r1.getClass();
        Integer r2 = null;
        Point r3 = new Point();     // Catch: Exception -> L10
        Object r4 = r1.a.getSystemService("window");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L8
        ((WindowManager) r4).getDefaultDisplay().getRealSize(r3);     // Catch: Exception -> L8
    L13:
        c.e = r3;
        Point r5 = c.e;
        if (c.e == null) goto L23;
        StringBuilder r6 = new StringBuilder("Screen Real Size: ");
        Point r7 = c.e;
        if (r7 == null) goto L18;
        Integer r8 = Integer.valueOf(r7.x);
    L19:
        r6.append(r8);
        r6.append(" * ");
        Point r9 = c.e;
        if (r9 == null) goto L22;
        r2 = Integer.valueOf(r9.y);
    L22:
        r6.append(r2);
        tt5.a.b("ScreenshotChecker", r6.toString());
        return;
    L18:
        r8 = null;
        goto L19
    L23:
        tt5.a.d("ScreenshotChecker", "Get screen real size failed.");
        return;
    L8:
        e = e;
    L12:
        e.printStackTrace();
    L10:
        e = e;
        r3 = null;
        goto L12
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
}
