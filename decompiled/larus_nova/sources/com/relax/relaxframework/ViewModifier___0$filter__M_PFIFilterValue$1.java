package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/y3;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/relax/relaxframework/y3;", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class ViewModifier___0$filter__M_PFIFilterValue$1 extends Lambda implements Function0<y3> {
    final /* synthetic */ Function0<r1> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModifier___0$filter__M_PFIFilterValue$1(Function0<? extends r1> r100) {
        this.$value = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y3 invoke() {
        ArrayList r100 = com.bytedance.rts.foundation.j.k(new Object[0]);
        com.bytedance.rts.foundation.j.j(r100, this.$value.invoke().a());
        int r101 = y3.f405359e;
        return y3.a.b(r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y3 invoke() {
        return invoke();
    }
}
