package xbc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.ZoomInScrollView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f563191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ZoomInScrollView f563192b;

    public e(View r100, ZoomInScrollView r101) {
        this.f563191a = r100;
        this.f563192b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f563191a.getMeasuredHeight();     // Catch: Throwable -> L7
        View r101 = this.f563192b.f445649b;     // Catch: Throwable -> L7
        if (r101 == null) goto L10;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");     // Catch: Throwable -> L7
        r101.setMinimumHeight(MathKt.roundToInt(((ZoomInScrollView.f445646j - r100) - ((LinearLayout.LayoutParams) r102).topMargin) + (80 * ZoomInScrollView.f445647k)));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
