package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ModifierEngine$Companion$setModifierBackgroundOriginValue__M_I32_Int32Enum_PFArrayModifierValue_BackgroundOrigin$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $modifier;
    final /* synthetic */ g2 $property;
    final /* synthetic */ Function0<ArrayList<ModifierValue_BackgroundOrigin>> $values;

    /* JADX WARN: Multi-variable type inference failed */
    public ModifierEngine$Companion$setModifierBackgroundOriginValue__M_I32_Int32Enum_PFArrayModifierValue_BackgroundOrigin$1(Function0<? extends ArrayList<ModifierValue_BackgroundOrigin>> r100, int r101, g2 r102) {
        this.$values = r100;
        this.$modifier = r101;
        this.$property = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ArrayList<ModifierValue_BackgroundOrigin> r100 = this.$values.invoke();
        ModifierEngine.Companion r101 = ModifierEngine.f404789a;
        int r102 = this.$modifier;
        g2 r103 = this.$property;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r100, "values");
        int r104 = 0;
        ArrayList r105 = com.bytedance.rts.foundation.j.k(new Double[0]);
        ArrayList r106 = com.bytedance.rts.foundation.j.k(new Integer[0]);
        IntCompanionObject r107 = IntCompanionObject.INSTANCE;
        int r108 = com.bytedance.rts.foundation.j.d(r100);
        com.bytedance.rts.foundation.k.c(r107, r108);
    L3:
        if (r104 >= r108) goto L5;
        int r109 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r105, Double.valueOf(((ModifierValue_BackgroundOrigin) ListProtector.get(r100, r104)).getValue()));
        com.bytedance.rts.foundation.j.j(r106, Integer.valueOf(ModifierValuePattern.ENUM.getValue()));
        r104 = r104 + 1;
        goto L3
    L5:
        ModifierEngine.f404789a.getClass();
        ModifierEngine.Companion.l(r102, r103, r105, r106);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
