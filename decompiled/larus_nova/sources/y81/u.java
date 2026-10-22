package y81;

import android.animation.ValueAnimator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f566835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f566836b;

    public u(ValueAnimator r100, l r101) {
        this.f566835a = r100;
        this.f566836b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = this.f566835a.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        l r103 = this.f566836b;
        l.k(r103, r103.f566777l, ColorProtector.parseColor("#26000000"), r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
