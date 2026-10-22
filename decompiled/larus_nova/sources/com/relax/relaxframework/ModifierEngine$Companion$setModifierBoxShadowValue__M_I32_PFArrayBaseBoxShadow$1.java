package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierBoxShadowValue__M_I32_PFArrayBaseBoxShadow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $modifier;
    final /* synthetic */ Function0<ArrayList<s>> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public ModifierEngine$Companion$setModifierBoxShadowValue__M_I32_PFArrayBaseBoxShadow$1(Function0<? extends ArrayList<s>> r100, int r101) {
        this.$value = r100;
        this.$modifier = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ArrayList<s> r100 = this.$value.invoke();
        ModifierEngine.Companion r101 = ModifierEngine.f404789a;
        int r102 = this.$modifier;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        int r103 = 0;
        ArrayList r104 = com.bytedance.rts.foundation.j.k(new ArrayList[0]);
        ArrayList r105 = com.bytedance.rts.foundation.j.k(new ArrayList[0]);
        ArrayList r106 = com.bytedance.rts.foundation.j.k(new Double[0]);
        ArrayList r107 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        ArrayList r108 = com.bytedance.rts.foundation.j.k(new Double[0]);
        ArrayList r109 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        ArrayList r110 = com.bytedance.rts.foundation.j.k(new Long[0]);
        ArrayList r111 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        IntCompanionObject r112 = IntCompanionObject.INSTANCE;
        int r113 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r112, r113);
    L3:
        if (r103 >= r113) goto L5;
        int r114 = com.bytedance.rts.foundation.d.f267577a;
        g0 r115 = ((s) ListProtector.get(r100, r103)).a();
        com.bytedance.rts.foundation.j.j(r104, r115.f405092a);
        com.bytedance.rts.foundation.j.j(r105, r115.f405093b);
        com.bytedance.rts.foundation.j.j(r106, Double.valueOf(r115.f405094c));
        com.bytedance.rts.foundation.j.j(r107, Integer.valueOf(r115.f405095d));
        com.bytedance.rts.foundation.j.j(r108, Double.valueOf(r115.f405096e));
        com.bytedance.rts.foundation.j.j(r110, Long.valueOf(r115.f405098g));
        com.bytedance.rts.foundation.j.j(r111, Integer.valueOf(r115.f405099h));
        r103 = r103 + 1;
        goto L3
    L5:
        qpa.d.f(r102, r104, r105, r106, r107, r108, r109, r110, r111);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
