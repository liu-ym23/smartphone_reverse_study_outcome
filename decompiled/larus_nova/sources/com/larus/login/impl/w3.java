package com.larus.login.impl;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w3 implements n38.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358373a;

    public w3(VerificationCodeFragment r100) {
        this.f358373a = r100;
    }

    @Override // n38.m
    public final void onSuccess(String r100) {
        VerificationCodeFragment r101 = this.f358373a;
        if (r101.f357238s == true) goto L12;
        Bundle r102 = r101.getArguments();
        if (r102 == null) goto L7;
        String r103 = r102.getString(CJOuterPayManager.KEY_BINDPHONE);
    L9:
        if (Intrinsics.areEqual(r103, this.f358373a.getString(R.string.larus_bind_phone_enter_number)) == false) goto L11;
        t19.s r104 = t19.s.f544207a;
        Context r105 = this.f358373a.getContext();
        String r106 = this.f358373a.getString(R.string.larus_account_toast_linked);
        r104.getClass();
        t19.s.p(r105, r106);
        goto L12
    L11:
        t19.s r107 = t19.s.f544207a;
        Context r108 = this.f358373a.getContext();
        String r109 = this.f358373a.getString(R.string.larus_change_phone_success);
        r107.getClass();
        t19.s.p(r108, r109);
        goto L12
    L7:
        r103 = null;
    L12:
        VerificationCodeFragment r110 = this.f358373a;
        if (r110.f357237r == false) goto L16;
        com.bytedance.router.i r111 = SmartRouter.buildRoute(r110.getContext(), "//main_page");
        r111.f267554c.addFlags(67108864);
        r111.f267554c.putExtra("key_hook_main_activity_on_new_intent", true);
        r111.f267554c.addFlags(335544320);
        r111.d();
    L19:
        ILoginService.f286097a.z();
        IAccountService.f286094a.i(null);
        VerificationCodeFragment r112 = this.f358373a;
        r112.da0(r112.getActivity(), this.f358373a.f357226g);
        this.f358373a.ba0(true, null);
        return;
    L16:
        if (r110.f357238s == false) goto L18;
        AccountUtils r113 = AccountUtils.f357130a;
        AccountUtils.c();
        goto L19
    L18:
        com.bytedance.router.i r114 = SmartRouter.buildRoute(r110.getContext(), "//flow/setting_account_info_activity");
        r114.f267554c.addFlags(67108864);
        r114.f267555d = R.anim.larus_router_slide_in_right;
        r114.f267556e = R.anim.larus_router_no_anim;
        r114.d();
        goto L19
    }

    @Override // n38.m
    public final void a(int r100, String r101, String r102, String r103) {
        VerificationCodeFragment r104 = this.f358373a;
        r104.da0(r104.getActivity(), this.f358373a.f357226g);
        t19.s r105 = t19.s.f544207a;
        Application r106 = AppHost.f326268a.getApplication();
        if (r101 != null) goto L5;
        r101 = this.f358373a.getString(R.string.larus_log_in_internet_error);
    L5:
        r105.getClass();
        t19.s.t(r106, r101);
        this.f358373a.ba0(false, String.valueOf(r100));
    }
}
