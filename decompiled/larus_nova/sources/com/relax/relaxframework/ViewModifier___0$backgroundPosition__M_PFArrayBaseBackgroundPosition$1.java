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
final class ViewModifier___0$backgroundPosition__M_PFArrayBaseBackgroundPosition$1 extends Lambda implements Function0<y3> {
    final /* synthetic */ Function0<ArrayList<o>> $value;
    final /* synthetic */ ViewModifier___0 this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModifier___0$backgroundPosition__M_PFArrayBaseBackgroundPosition$1(Function0<? extends ArrayList<o>> r100, ViewModifier___0 r101) {
        this.$value = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final y3 invoke() {
        ArrayList<o> r100 = this.$value.invoke();
        ArrayList r101 = com.bytedance.rts.foundation.j.k(new Object[0]);
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        ArrayList<o> r103 = r100;
        int r104 = com.bytedance.rts.foundation.j.d(r103);
        com.bytedance.rts.foundation.k.c(r102, r104);
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        ((o) ListProtector.get(r103, r105)).getClass();
        ArrayList r107 = new ArrayList();
        com.bytedance.rts.foundation.j.j(r101, ListProtector.get(r107, 0));
        com.bytedance.rts.foundation.j.j(r101, ListProtector.get(r107, 1));
        com.bytedance.rts.foundation.j.j(r101, ListProtector.get(r107, 2));
        com.bytedance.rts.foundation.j.j(r101, ListProtector.get(r107, 3));
        r105 = r105 + 1;
        goto L3
    L5:
        int r108 = y3.f405359e;
        return y3.a.b(r101);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ y3 invoke() {
        return invoke();
    }
}
