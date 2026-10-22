package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/y3;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/relax/relaxframework/y3;", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class ViewModifier___0$boxShadow__M_PFArrayBaseBoxShadow$1 extends Lambda implements Function0<y3> {
    final /* synthetic */ Function0<ArrayList<s>> $value;
    final /* synthetic */ ViewModifier___0 this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModifier___0$boxShadow__M_PFArrayBaseBoxShadow$1(Function0<? extends ArrayList<s>> r100, ViewModifier___0 r101) {
        this.$value = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y3 invoke() {
        int r100 = 0;
        ArrayList r101 = com.bytedance.rts.foundation.j.k(new ArrayList[0]);
        ArrayList<s> r102 = this.$value.invoke();
    L3:
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        ArrayList<s> r104 = r102;
        int r105 = com.bytedance.rts.foundation.j.d(r104);
        com.bytedance.rts.foundation.k.c(r103, r105);
        if (r100 >= r105) goto L6;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        ((s) ListProtector.get(r104, r100)).getClass();
        com.bytedance.rts.foundation.j.j(r101, new ArrayList());
        r100 = r100 + 1;
        goto L3
    L6:
        int r107 = y3.f405359e;
        return y3.a.b(r101);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y3 invoke() {
        return invoke();
    }
}
