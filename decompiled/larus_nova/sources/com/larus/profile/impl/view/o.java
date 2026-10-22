package com.larus.profile.impl.view;

import com.larus.account.base.api.IAccountService;
import com.larus.profile.impl.databinding.LarusItemProfileInfoHeaderBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class o implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusItemProfileInfoHeaderBinding f366927a;

    public /* synthetic */ o(LarusItemProfileInfoHeaderBinding r100) {
        this.f366927a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LarusItemProfileInfoHeaderBinding r100 = this.f366927a;
        int r101 = ProfileHeaderUserInfoView.f366889b;
        r38.b r102 = IAccountService.f286094a.getUserInfo();
        if (r102 == null) goto L7;
        r38.a r103 = r102.e();
        if (r103 == null) goto L7;
        String r104 = r103.b();
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        r100.f366484i.setVisibility(8);
    L19:
        return Unit.INSTANCE;
    L17:
        r100.f366484i.setText(r104);
        r100.f366484i.setVisibility(0);
        goto L19
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
    L7:
        r104 = null;
        goto L9
    }
}
