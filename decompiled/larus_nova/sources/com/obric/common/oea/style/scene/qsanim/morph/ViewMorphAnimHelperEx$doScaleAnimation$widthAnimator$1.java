package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ View $this_doScaleAnimation;

    public ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1(View r100) {
        this.$this_doScaleAnimation = r100;
        super(1);
    }

    public final void invoke(float r100) {
        View r101 = this.$this_doScaleAnimation;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.width = MathKt.roundToInt(r100);
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r100) {
        invoke(r100.floatValue());
        return Unit.INSTANCE;
    }
}
