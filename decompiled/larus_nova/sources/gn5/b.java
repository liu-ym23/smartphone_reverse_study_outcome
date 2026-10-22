package gn5;

import android.graphics.Point;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f481804a;

    public b(c r100) {
        this.f481804a = r100;
    }

    public final void a() {
        Point r100 = c.f481805e;
        if (c.f481805e != null) goto L29;
        c r101 = this.f481804a;
        r101.getClass();
        Integer r102 = null;
        Point r103 = new Point();     // Catch: Exception -> L10
        Object r104 = r101.f481806a.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L8
        ((WindowManager) r104).getDefaultDisplay().getRealSize(r103);     // Catch: Exception -> L8
    L13:
        c.f481805e = r103;
        Point r105 = c.f481805e;
        if (c.f481805e == null) goto L23;
        StringBuilder r106 = new StringBuilder("Screen Real Size: ");
        Point r107 = c.f481805e;
        if (r107 == null) goto L18;
        Integer r108 = Integer.valueOf(r107.x);
    L19:
        r106.append(r108);
        r106.append(" * ");
        Point r109 = c.f481805e;
        if (r109 == null) goto L22;
        r102 = Integer.valueOf(r109.y);
    L22:
        r106.append(r102);
        tt5.a.b("ScreenshotChecker", r106.toString());
        return;
    L18:
        r108 = null;
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
        r103 = null;
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
