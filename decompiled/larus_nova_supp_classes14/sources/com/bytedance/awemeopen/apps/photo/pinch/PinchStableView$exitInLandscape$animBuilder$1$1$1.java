package com.bytedance.awemeopen.apps.photo.pinch;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/ViewGroup$MarginLayoutParams;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class PinchStableView$exitInLandscape$animBuilder$1$1$1 extends Lambda implements Function1<ViewGroup.MarginLayoutParams, Unit> {
    final /* synthetic */ ValueAnimator $it;

    public PinchStableView$exitInLandscape$animBuilder$1$1$1(ValueAnimator r1) {
        this.$it = r1;
        super(1);
    }

    public final void invoke(ViewGroup.MarginLayoutParams r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$updateLayoutParams");
        Object r0 = this.$it.getAnimatedValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        r3.height = ((Integer) r0).intValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ViewGroup.MarginLayoutParams) r1);
        return Unit.INSTANCE;
    }
}
