package com.bytedance.salamander.anniex;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXContainerUIService implements k3 {
    public AnnieXContainerUIService() {
    }

    public static j0 a(final AnnieXCommonUIViewModel r100) {
        String r101 = AnnieXNavBarItemName.BACK.getValue();
        int r102 = y.f268510a;
        Function0<? extends i0> r103 = r100.i().f267833a;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r103 = null;
    L6:
        return new j0(r101, "sl://raw/ic_arrowleft_outlined", r103.invoke().f268111g, new AnnieXContainerUIService$backItem$1(r100));
    }
}
