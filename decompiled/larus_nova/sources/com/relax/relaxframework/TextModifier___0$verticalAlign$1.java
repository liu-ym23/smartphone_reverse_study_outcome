package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/y3;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/relax/relaxframework/y3;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class TextModifier___0$verticalAlign$1 extends Lambda implements Function0<y3> {
    final /* synthetic */ e3 $value;
    final /* synthetic */ TextModifier___0 this$0;

    public TextModifier___0$verticalAlign$1(TextModifier___0 r100, e3 r101) {
        this.this$0 = r100;
        this.$value = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y3 invoke() {
        return TextModifier___0.v(this.this$0, this.$value);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y3 invoke() {
        return invoke();
    }
}
