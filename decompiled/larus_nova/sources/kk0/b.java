package kk0;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f503742a;

    public b(HSImageView r100) {
        this.f503742a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        PointF r102 = (PointF) r101;
        this.f503742a.setX(r102.x);
        this.f503742a.setY(r102.y);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
