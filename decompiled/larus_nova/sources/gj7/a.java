package gj7;

import android.widget.ProgressBar;
import com.bytedance.ug.sdk.luckycat.impl.browser.LuckyCatBrowserFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LuckyCatBrowserFragment f481506a;

    @Override // java.lang.Runnable
    public final void run() {
        LuckyCatBrowserFragment r100 = this.f481506a;     // Catch: Throwable -> L9
        ProgressBar r101 = r100.f271097e;     // Catch: Throwable -> L9
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L16;
        r100.f271097e.setVisibility(8);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }

    public a(LuckyCatBrowserFragment r100) {
        this.f481506a = r100;
    }
}
