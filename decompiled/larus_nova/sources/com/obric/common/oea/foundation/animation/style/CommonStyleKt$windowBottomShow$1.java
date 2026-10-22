package com.obric.common.oea.foundation.animation.style;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.common.oea.foundation.animation.easy.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/obric/common/oea/foundation/animation/easy/a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/common/oea/foundation/animation/easy/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CommonStyleKt$windowBottomShow$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ Ref.IntRef $initOffset;

    public CommonStyleKt$windowBottomShow$1(Ref.IntRef r100) {
        this.$initOffset = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.getClass();
        int r101 = this.$initOffset.element;
    }
}
