package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TextModifier$fontWeight$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Function0<ModifierValue_FontWeight> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public TextModifier$fontWeight$1(Function0<? extends ModifierValue_FontWeight> r100) {
        this.$value = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Integer.valueOf(this.$value.invoke().getValue());
    }
}
