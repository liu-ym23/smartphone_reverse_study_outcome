package ti2;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ WindowManager b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        WindowManager r4 = this.b;     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        r4.removeView(this.a);     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r5);     // Catch: Throwable -> L9
        return;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setVisibility(8);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        WindowManager r4 = this.b;     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        r4.removeView(this.a);     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r5);     // Catch: Throwable -> L9
        return;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public d(View r1, WindowManager r2) {
        this.a = r1;
        this.b = r2;
    }
}
