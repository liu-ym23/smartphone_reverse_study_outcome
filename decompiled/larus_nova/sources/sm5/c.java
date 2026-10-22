package sm5;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotImageAlertFragment f542576a;

    public c(ScreenshotImageAlertFragment r100) {
        this.f542576a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout r100 = this.f542576a.f237488q;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
