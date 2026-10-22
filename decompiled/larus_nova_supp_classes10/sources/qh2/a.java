package qh2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class a extends AnimatorListenerAdapter {
    public final Function3<Integer, Integer, Float, Unit> a;
    public final Function0<Integer> b;
    public final int c;

    /* JADX INFO: renamed from: qh2.a$a, reason: collision with other inner class name */
    public static final class C0162a {
    }

    static {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationCancel(r4);
        int r5 = this.c;
        if (r5 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r6 = this.a;
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke(120, 0, Float.valueOf(0.0f));
        return;
    L16:
        return;
    L5:
        if (r5 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r8 = this.a;
        if (r8 == null) goto L14;
        Unit r9 = (Unit) r8.invoke(220, this.b.invoke(), Float.valueOf(1.0f));
        return;
    L14:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationEnd(r4);
        int r5 = this.c;
        if (r5 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r6 = this.a;
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke(120, this.b.invoke(), Float.valueOf(1.0f));
        return;
    L16:
        return;
    L5:
        if (r5 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r8 = this.a;
        if (r8 == null) goto L14;
        Unit r9 = (Unit) r8.invoke(220, 0, Float.valueOf(0.0f));
        return;
    L14:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        super.onAnimationStart(r4);
        int r5 = this.c;
        if (r5 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r6 = this.a;
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke(100, 0, Float.valueOf(0.0f));
        return;
    L16:
        return;
    L5:
        if (r5 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r8 = this.a;
        if (r8 == null) goto L14;
        Unit r9 = (Unit) r8.invoke(200, this.b.invoke(), Float.valueOf(1.0f));
        return;
    L14:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationEnd(r3, r4);
        int r5 = this.c;
        if (r5 != 1) goto L5;
        Function3<Integer, Integer, Float, Unit> r6 = this.a;
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke(120, this.b.invoke(), Float.valueOf(1.0f));
        return;
    L16:
        return;
    L5:
        if (r5 != 2) goto L17;
        Function3<Integer, Integer, Float, Unit> r8 = this.a;
        if (r8 == null) goto L14;
        Unit r9 = (Unit) r8.invoke(220, 0, Float.valueOf(0.0f));
        return;
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function3<? super Integer, ? super Integer, ? super Float, Unit> r2, Function0<Integer> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewHeight");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
