package com.larus.dora.obric.onboarding;

import com.larus.dora.impl.databinding.ObricDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.obric.oui.button.OButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class w {
    public static final String b(int r100) {
        int r101 = com.larus.utils.j0.f375426a;
        return com.larus.utils.j0.d(r100);
    }

    public static final void a(ObricDoraGOnboardingFragmentV2Binding r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ObricDoraGOnboardingBottomBtnLayoutBinding r103 = r100.f333427d;
        com.larus.utils.e1.x(r103.f333415a);
        com.larus.utils.e1.x(r103.f333417c);
        OButton r104 = r103.f333418d;
        if (r101 == null) goto L5;
        r104.setText(r101);
    L5:
        if (r102 == false) goto L7;
        Intrinsics.checkNotNull(r104);
        d69.a.a(r104);
    L8:
        com.larus.utils.e1.x(r103.f333420f);
        j19.c.d(r103.f333416b);
        return;
    L7:
        Intrinsics.checkNotNull(r104);
        d69.a.b(r104, false);
        goto L8
    }
}
