package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class r8 implements o1 {
    public r8() {
    }

    @Override // com.relax.relaxframework.o1
    public final String type() {
        return "TransitionModifierApplier";
    }

    @Override // com.relax.relaxframework.o1
    public final void a(p6 r110) {
        Intrinsics.checkNotNullParameter(r110, "m");
        if ((r110 instanceof q8) == true) goto L5;
        return;
    L5:
        BuiltinModifierState r100 = r110.f405219f;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("state");
        r100 = null;
    L9:
        BuiltinModifierState r101 = BuiltinModifierState.Locked;
        if (r100 != r101) goto L12;
        return;
    L12:
        q8 r111 = (q8) r110;
        if (r111.f405240i != null) goto L16;
        r111.f405240i = new h8(TimingFunctionType___0.Linear, null);
    L16:
        if (r111.f405238g != null) goto L19;
        int r112 = l6.f405180a;
        l6.a.a(new String[]{"The `property` attribute of the transition modifier is not set"});
        return;
    L19:
        ModifierEngine.f404789a.getClass();
        int r102 = ModifierEngine.Companion.e();
        h8 r103 = r111.f405240i;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getType().getValue();
        h8 r105 = r111.f405240i;
        Intrinsics.checkNotNull(r105);
        ArrayList<Double> r106 = r105.f405120b;
        if (r106 != null) goto L22;
        r106 = com.bytedance.rts.foundation.j.k(new Double[0]);
    L22:
        RelaxInstance.a r107 = RelaxInstance.Companion;
        r107.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().T(r102, r104, r106);
        int r108 = r111.f405241j;
        Integer r109 = r111.f405238g;
        Intrinsics.checkNotNull(r109);
        int r113 = r109.intValue();
        double r114 = r111.f405239h;
        r107.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().U(r108, r113, r114, r102);
        r111.d(r101);
    }
}
