package com.ss.android.lark.custom.repeat;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends oab.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChooseCustomRepeatFragment f420295b;

    public d(ChooseCustomRepeatFragment r100) {
        this.f420295b = r100;
    }

    @Override // oab.b
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ChooseCustomRepeatFragment r101 = this.f420295b;
        ChooseCustomRepeatFragment.b r102 = r101.f420260m;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customRepeatAction");
        r102 = null;
    L5:
        r102.onBackPressed();
        r101.f420265r.clearRule();
        r101.T90().c();
    }
}
