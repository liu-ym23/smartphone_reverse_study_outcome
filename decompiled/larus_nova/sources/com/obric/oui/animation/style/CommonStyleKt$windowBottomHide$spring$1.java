package com.obric.oui.animation.style;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/obric/oui/animation/easy/a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/oui/animation/easy/a;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class CommonStyleKt$windowBottomHide$spring$1 extends Lambda implements Function1<com.obric.oui.animation.easy.a, Unit> {
    public static final CommonStyleKt$windowBottomHide$spring$1 INSTANCE = null;

    static {
        INSTANCE = new CommonStyleKt$windowBottomHide$spring$1();
    }

    public CommonStyleKt$windowBottomHide$spring$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.obric.oui.animation.easy.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$translationY");
        r100.f398732e = true;
        r100.f398734g = 1.0f;
        r100.f398735h = true;
        r100.f398737j = 480.0f;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.obric.oui.animation.easy.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
