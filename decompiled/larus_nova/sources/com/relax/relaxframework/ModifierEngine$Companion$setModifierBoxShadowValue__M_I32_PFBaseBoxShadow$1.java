package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierBoxShadowValue__M_I32_PFBaseBoxShadow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $modifier;
    final /* synthetic */ Function0<s> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public ModifierEngine$Companion$setModifierBoxShadowValue__M_I32_PFBaseBoxShadow$1(Function0<? extends s> r100, int r101) {
        this.$value = r100;
        this.$modifier = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        s r100 = this.$value.invoke();
        ModifierEngine.Companion r101 = ModifierEngine.f404789a;
        int r102 = this.$modifier;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        g0 r103 = r100.a();
        ArrayList r104 = com.bytedance.rts.foundation.j.k(new ArrayList[]{r103.f405092a});
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Double>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }> }");
        ArrayList r105 = com.bytedance.rts.foundation.j.k(new ArrayList[]{r103.f405093b});
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Int>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }> }");
        ArrayList r106 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r103.f405094c)});
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
        ArrayList r107 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r103.f405095d)});
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
        ArrayList r110 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r103.f405096e)});
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
        ArrayList r111 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r103.f405097f)});
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
        ArrayList r112 = com.bytedance.rts.foundation.j.k(new Long[]{Long.valueOf(r103.f405098g)});
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Long> }");
        ArrayList r108 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r103.f405099h)});
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
        qpa.d.f(r102, r104, r105, r106, r107, r110, r111, r112, r108);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
