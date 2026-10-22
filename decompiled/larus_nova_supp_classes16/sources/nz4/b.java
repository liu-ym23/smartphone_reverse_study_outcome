package nz4;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Function0<Unit> c;

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
        this.b.element = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        k.a.remove(this.a);
        if (this.b.element == true) goto L11;
        ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
        if (r3 == null) goto L7;
        r3.width = 0;
        this.a.setLayoutParams(r3);
    L7:
        Function0<Unit> r4 = this.c;
        if (r4 == null) goto L12;
        r4.invoke();
        return;
    L12:
        return;
    }

    public b(View r1, Ref.BooleanRef r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
