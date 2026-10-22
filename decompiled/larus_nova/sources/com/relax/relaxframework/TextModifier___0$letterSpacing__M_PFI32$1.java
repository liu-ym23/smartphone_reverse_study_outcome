package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Double;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TextModifier___0$letterSpacing__M_PFI32$1 extends Lambda implements Function0<Double> {
    final /* synthetic */ Function0<Integer> $value;

    public TextModifier___0$letterSpacing__M_PFI32$1(Function0<Integer> r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Double invoke() {
        int r100 = com.bytedance.rts.foundation.d.f267577a;
        return Double.valueOf(this.$value.invoke().intValue());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Double invoke() {
        return invoke();
    }
}
