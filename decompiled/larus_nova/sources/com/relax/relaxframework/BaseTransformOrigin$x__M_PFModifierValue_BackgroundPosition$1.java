package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", AbsMethodDelegate.TAG_INVOKE, "()[Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class BaseTransformOrigin$x__M_PFModifierValue_BackgroundPosition$1 extends Lambda implements Function0<Object[]> {
    final /* synthetic */ Function0<ModifierValue_BackgroundPosition> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseTransformOrigin$x__M_PFModifierValue_BackgroundPosition$1(Function0<? extends ModifierValue_BackgroundPosition> r100) {
        this.$value = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object[] invoke2() {
        int r100 = com.bytedance.rts.foundation.d.f267577a;
        return new Object[]{Double.valueOf(this.$value.invoke().getValue()), ModifierValuePattern.ENUM};
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object[] invoke() {
        return invoke2();
    }
}
