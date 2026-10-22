package com.larus.login.impl;

import android.app.Application;
import android.content.Context;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.larus.account.base.model.LoginPlatform;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.SeparatedEditText;
import com.larus.login.api.TouristManager;
import com.larus.login.impl.databinding.LarusAccountVerificationCodePageBinding;
import com.larus.nova.R;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class u3 implements n38.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f358301a;

    public u3(VerificationCodeFragment r100) {
        this.f358301a = r100;
    }

    @Override // n38.h
    public final void b(LoginPlatform r100, String r101, Boolean r102) {
        AccountUtils r103 = AccountUtils.f357130a;
        AccountUtils.s("WeixinBindLogin");
        TouristManager.f357001a.g();
        VerificationCodeFragment.X90(this.f358301a, "wechat");
        this.f358301a.ba0(true, null);
    }

    @Override // n38.h
    public final void a(LoginPlatform r100, int r101, String r102, String r110, String r111, Integer r112, String r113, Map r114) {
        VerificationCodeFragment r103 = this.f358301a;
        r103.da0(r103.getActivity(), this.f358301a.f357226g);
        AccountUtils r104 = AccountUtils.f357130a;
        if (AccountUtils.e(this.f358301a) == true) goto L5;
        return;
    L5:
        LarusAccountVerificationCodePageBinding r105 = this.f358301a.f357224e;
        if (r105 == null) goto L10;
        SeparatedEditText r106 = r105.f357472c;
        if (r106 == null) goto L10;
        r106.c();
    L10:
        boolean r115 = true;
        if (r101 != (-1009)) goto L33;
        com.larus.platform.service.z2 r116 = com.larus.platform.service.z2.f365865a;
        FlowDowngradeToastConfig r117 = r116.getFlowDowngradeToastConfig();
        String r118 = null;
        if (r117 == null) goto L15;
        String r119 = r117.getTrafficDegradationLogInDisableCn();
    L16:
        if (r119 != null) goto L18;
    L21:
        if (r115 == false) goto L27;
        Context r120 = this.f358301a.getContext();
        if (r120 == null) goto L26;
        String r121 = r120.getString(R.string.larus_trafficDegradation_logInDisable_cn);
        if (r121 == null) goto L26;
    L31:
        t19.s.j(t19.s.f544207a, AppHost.f326268a.getApplication(), r121, null, false, 28);
        IApplog.Companion r122 = IApplog.f287053a;
        JSONObject r123 = new JSONObject();
        this.f358301a.getClass();
        r123.put("current_page", DyVerifyEventConstants.EventParam.VERIFY_CODE);
        Unit r124 = Unit.INSTANCE;
        r122.reportEvent("login_error_toast", r123);
    L44:
        VerificationCodeFragment.W90(this.f358301a, Integer.valueOf(r101), r102);
        this.f358301a.ba0(false, String.valueOf(r101));
        return;
    L26:
        r121 = "";
        goto L31
    L27:
        FlowDowngradeToastConfig r125 = r116.getFlowDowngradeToastConfig();
        if (r125 == null) goto L30;
        r118 = r125.getTrafficDegradationLogInDisableCn();
    L30:
        r121 = String.valueOf(r118);
        goto L31
    L18:
        if (r119.length() == 0) goto L21;
        r115 = false;
        goto L21
    L15:
        r119 = null;
        goto L16
    L33:
        if (r101 == (-1008)) goto L44;
        t19.s r126 = t19.s.f544207a;
        Application r127 = AppHost.f326268a.getApplication();
        if (r102 != null) goto L37;
    L40:
        if (r115 == false) goto L42;
        String r128 = this.f358301a.getString(R.string.larus_log_in_internet_error);
    L43:
        Intrinsics.checkNotNull(r128);
        r126.getClass();
        t19.s.c(r127, r128);
        goto L44
    L42:
        r128 = r102;
        goto L43
    L37:
        if (r102.length() == 0) goto L40;
        r115 = false;
        goto L40
    }
}
