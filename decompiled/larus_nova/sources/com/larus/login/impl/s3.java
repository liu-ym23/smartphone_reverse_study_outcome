package com.larus.login.impl;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.router.SmartRouter;
import com.larus.network.HttpConst;
import com.larus.nova.R;
import com.larus.search.api.IBrowserService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s3 implements n38.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f358222b;

    @Override // n38.s
    public final void onFailed() {
        FragmentActivity r100 = this.f358221a.getActivity();
        if (r100 == null) goto L7;
        IBrowserService r101 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r101 == null) goto L7;
        HttpConst.f359979a.getClass();
        r101.j(r100, HttpConst.I);
    L7:
        VerificationCodeFragment r102 = this.f358221a;
        r102.da0(r102.getActivity(), this.f358221a.f357226g);
    }

    @Override // n38.s
    public final void onSuccess(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "platforms");
        if (r100.isEmpty() == false) goto L9;
        FragmentActivity r101 = this.f358221a.getActivity();
        if (r101 == null) goto L15;
        IBrowserService r102 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r102 == null) goto L15;
        HttpConst.f359979a.getClass();
        r102.j(r101, HttpConst.I);
    L15:
        VerificationCodeFragment r103 = this.f358221a;
        r103.da0(r103.getActivity(), this.f358221a.f357226g);
        return;
    L9:
        com.bytedance.router.i r104 = SmartRouter.buildRoute(this.f358221a.getContext(), "//flow/auth_verify");
        String r105 = this.f358222b;
        r104.f267554c.putExtra("phoneTicket", r105);
        String[] r106 = (String[]) r100.toArray(new String[0]);
        r104.f267554c.putExtra("key_bind_phone_auth_platform_list", r106);
        this.f358221a.getClass();
        r104.f267554c.putExtra("account_previous_page", DyVerifyEventConstants.EventParam.VERIFY_CODE);
        r104.f267555d = R.anim.larus_router_slide_in_right;
        r104.f267556e = R.anim.larus_router_no_anim;
        Bundle r107 = BundleKt.bundleOf();
        by7.h.k(r107, this.f358221a);
        r104.f267554c.putExtras(r107);
        Bundle r108 = this.f358221a.getArguments();
        if (r108 == null) goto L13;
        String r109 = r108.getString("key_trigger_app_id");
        if (r109 == null) goto L13;
    L14:
        r104.f267554c.putExtra("key_trigger_app_id", r109);
        boolean r110 = this.f358221a.f357238s;
        r104.f267554c.putExtra("key_bind_phone_from_h5", r110);
        r104.d();
    L13:
        r109 = "";
        goto L14
    }

    public s3(VerificationCodeFragment r100, String r101) {
        this.f358221a = r100;
        this.f358222b = r101;
    }
}
