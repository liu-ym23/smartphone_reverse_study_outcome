package com.larus.login.impl;

import android.app.Application;
import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class r3 implements n38.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358208a;

    public r3(VerificationCodeFragment r100) {
        this.f358208a = r100;
    }

    @Override // n38.m
    public final void onSuccess(String r100) {
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f358208a.getContext();
        String r103 = this.f358208a.getString(R.string.larus_change_phone_success);
        r101.getClass();
        t19.s.p(r102, r103);
        VerificationCodeFragment r104 = this.f358208a;
        if (r104.f357238s == false) goto L5;
        AccountUtils r105 = AccountUtils.f357130a;
        AccountUtils.c();
    L6:
        ILoginService.f286097a.z();
        IAccountService.f286094a.i(null);
        VerificationCodeFragment r106 = this.f358208a;
        r106.da0(r106.getActivity(), this.f358208a.f357226g);
        this.f358208a.ba0(true, null);
        return;
    L5:
        com.bytedance.router.i r107 = SmartRouter.buildRoute(r104.getContext(), "//flow/setting_account_info_activity");
        r107.f267554c.addFlags(67108864);
        r107.f267555d = R.anim.larus_router_slide_in_right;
        r107.f267556e = R.anim.larus_router_no_anim;
        r107.d();
        goto L6
    }

    @Override // n38.m
    public final void a(int r100, String r101, String r102, String r103) {
        t19.s r104 = t19.s.f544207a;
        Application r105 = AppHost.f326268a.getApplication();
        if (r101 != null) goto L5;
        r101 = this.f358208a.getString(R.string.larus_log_in_internet_error);
    L5:
        r104.getClass();
        t19.s.t(r105, r101);
        VerificationCodeFragment r106 = this.f358208a;
        r106.da0(r106.getActivity(), this.f358208a.f357226g);
        this.f358208a.ba0(false, String.valueOf(r100));
    }
}
