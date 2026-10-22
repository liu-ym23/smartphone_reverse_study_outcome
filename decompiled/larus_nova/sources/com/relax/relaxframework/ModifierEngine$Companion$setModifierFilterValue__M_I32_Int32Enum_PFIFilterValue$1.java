package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierFilterValue__M_I32_Int32Enum_PFIFilterValue$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $modifier;
    final /* synthetic */ g2 $property;
    final /* synthetic */ Function0<r1> $value;

    /* JADX WARN: Multi-variable type inference failed */
    public ModifierEngine$Companion$setModifierFilterValue__M_I32_Int32Enum_PFIFilterValue$1(Function0<? extends r1> r100, int r101, g2 r102) {
        this.$value = r100;
        this.$modifier = r101;
        this.$property = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        r1 r100 = this.$value.invoke();
        ModifierEngine.Companion r101 = ModifierEngine.f404789a;
        int r102 = this.$modifier;
        g2 r103 = this.$property;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r100, "value");
        d1 r104 = r100.b();
        int r105 = r103.f405102a;
        ArrayList<Integer> r106 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r104.getType())});
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
        ArrayList<ArrayList<Double>> r107 = com.bytedance.rts.foundation.j.k(new ArrayList[]{null});
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Double>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }> }");
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().r0(r102, r105, r106, r107);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
