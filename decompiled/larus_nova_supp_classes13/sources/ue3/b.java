package ue3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ DragRelativeLayout a;

    public b(DragRelativeLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Function0<Unit> r3 = this.a.getOnViewPositionChanged();
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }
}
