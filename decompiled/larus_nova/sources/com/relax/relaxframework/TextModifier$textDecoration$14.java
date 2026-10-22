package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TextModifier$textDecoration$14 extends Lambda implements Function0<Integer> {
    final /* synthetic */ Function0<ModifierValue_TextDecorationStyle> $style;

    /* JADX WARN: Multi-variable type inference failed */
    public TextModifier$textDecoration$14(Function0<? extends ModifierValue_TextDecorationStyle> r100) {
        this.$style = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        return Integer.valueOf(this.$style.invoke().getValue());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
