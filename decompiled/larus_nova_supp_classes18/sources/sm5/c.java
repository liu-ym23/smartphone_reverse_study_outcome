package sm5;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ ScreenshotImageAlertFragment a;

    public c(ScreenshotImageAlertFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout r0 = this.a.q;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
