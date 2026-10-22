package sh3;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ WindowManager c;

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
        Function0 r3 = this.b;
        if (r3 == null) goto L14;
        Unit r4 = (Unit) r3.invoke();
    L14:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        WindowManager r6 = this.c;     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        r6.removeView(this.a);     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r7);     // Catch: Throwable -> L11
        return;
    L8:
        r7 = null;
    L11:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setVisibility(8);
        Function0 r3 = this.b;
        if (r3 == null) goto L14;
        Unit r4 = (Unit) r3.invoke();
    L14:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        WindowManager r6 = this.c;     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        r6.removeView(this.a);     // Catch: Throwable -> L11
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r7);     // Catch: Throwable -> L11
        return;
    L8:
        r7 = null;
    L11:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public b(View r1, Function0 r2, WindowManager r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
