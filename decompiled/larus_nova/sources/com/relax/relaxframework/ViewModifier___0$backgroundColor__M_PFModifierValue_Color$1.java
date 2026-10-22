package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ViewModifier___0$backgroundColor__M_PFModifierValue_Color$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Function0<ModifierValue_Color> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModifier___0$backgroundColor__M_PFModifierValue_Color$1(Function0<? extends ModifierValue_Color> r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        int r100 = com.bytedance.rts.foundation.e.f267578a;
        return Integer.valueOf((int) this.$value.invoke().getValue());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
