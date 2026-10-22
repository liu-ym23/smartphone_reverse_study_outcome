package v19;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j7 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f552573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k7 f552574b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        View r101 = this.f552573a;
        k7 r102 = this.f552574b;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        if (r101.getViewTreeObserver().isAlive() == false) goto L6;
        r101.getViewTreeObserver().removeOnGlobalLayoutListener(r102);     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public j7(View r100, k7 r101) {
        this.f552573a = r100;
        this.f552574b = r101;
    }
}
