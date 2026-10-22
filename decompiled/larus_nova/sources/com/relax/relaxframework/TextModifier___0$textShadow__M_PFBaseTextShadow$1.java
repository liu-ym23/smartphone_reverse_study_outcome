package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/y3;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/relax/relaxframework/y3;", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class TextModifier___0$textShadow__M_PFBaseTextShadow$1 extends Lambda implements Function0<y3> {
    final /* synthetic */ Function0<z> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public TextModifier___0$textShadow__M_PFBaseTextShadow$1(Function0<? extends z> r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y3 invoke() {
        int r100 = y3.f405359e;
        ArrayList r101 = com.bytedance.rts.foundation.j.k(new ArrayList[]{this.$value.invoke().a()});
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Any>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Any>{ com.relax.relaxframework.RelaxFrameworkKt.TextShadowParameterArray }> }");
        return y3.a.b(r101);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y3 invoke() {
        return invoke();
    }
}
