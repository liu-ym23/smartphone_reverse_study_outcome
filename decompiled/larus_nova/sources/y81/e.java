package y81;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f566750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f566751b;

    public e(ValueAnimator r100, c r101) {
        this.f566750a = r100;
        this.f566751b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        Object r101 = this.f566750a.getAnimatedValue();
        if (r101 == null) goto L9;
        float r102 = ((Float) r101).floatValue();
        ViewGroup r103 = this.f566751b.f566681q;
        if (r103 == null) goto L10;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.width = (int) (UtilityKotlinExtentionsKt.h(50) * r102);
        r103.setLayoutParams(r104);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
