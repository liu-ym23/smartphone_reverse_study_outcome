package com.larus.office.base;

import androidx.autofill.HintConstants;
import androidx.fragment.app.FragmentManager;
import com.larus.home.api.main.HomeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 implements dza.a {
    public l0() {
    }

    @Override // dza.a
    public final void r1(String r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        HomeService.f344094a.b0(r100, r101);
    }
}
