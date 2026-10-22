package com.bytedance.awemeopen.apps.photo.pinch;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/ViewGroup$MarginLayoutParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class PinchStableView$exitInLandscape$3$1$1 extends Lambda implements Function1<ViewGroup.MarginLayoutParams, Unit> {
    final /* synthetic */ ValueAnimator $it;

    public PinchStableView$exitInLandscape$3$1$1(ValueAnimator r100) {
        this.$it = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewGroup.MarginLayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateLayoutParams");
        Object r101 = this.$it.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        r100.topMargin = ((Integer) r101).intValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
