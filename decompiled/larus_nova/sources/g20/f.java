package g20;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f479663a;

    public f(FrameLayout r100) {
        this.f479663a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams r100 = this.f479663a.getLayoutParams();     // Catch: Throwable -> L7
        if (r100 == null) goto L6;
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) r100;     // Catch: Throwable -> L7
        r101.weight = 1.0f;     // Catch: Throwable -> L7
        r101.width = 0;     // Catch: Throwable -> L7
        this.f479663a.setLayoutParams(r101);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
