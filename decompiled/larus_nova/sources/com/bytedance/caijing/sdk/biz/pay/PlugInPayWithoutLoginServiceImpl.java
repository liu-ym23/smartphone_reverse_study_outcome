package com.bytedance.caijing.sdk.biz.pay;

import android.util.Base64;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.ktextension.CJStringExtensionKt;
import com.android.ttcjpaysdk.base.paynologin.CJBDPayWithoutLoginUtils;
import com.bytedance.caijing.sdk.infra.base.api.abtest.ABTestService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PluginPayWithoutLoginService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import java.security.SecureRandom;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;
import xc4.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/PlugInPayWithoutLoginServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PluginPayWithoutLoginService;", "()V", "getPayWithoutLoginHeaders", "", "", "isPayWithoutLoginEnv", "", "cjpay-se-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlugInPayWithoutLoginServiceImpl implements PluginPayWithoutLoginService {
    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PluginPayWithoutLoginService
    public Map<String, String> getPayWithoutLoginHeaders() {
        a.f554342a.getClass();
        ABTestService r100 = (ABTestService) a.a(ABTestService.class);
        if (r100 == null) goto L5;
        String r101 = (String) r100.experimentKeyGetValue("cj_no_login_risk_fix_enable", String.class, "0", true);
    L6:
        boolean r102 = Intrinsics.areEqual(r101, "1");
        f r103 = CJBDPayWithoutLoginUtils.INSTANCE.getHostUserInfo();
        if (r103 == null) goto L10;
        String r104 = r103.f563210c;
        if (r104 == null) goto L10;
    L12:
        if (r102 == false) goto L30;
        String r105 = CJEnv.c();
        if (r104.length() <= 0) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L30;
        if (r105.length() <= 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L30;
        byte[] r108 = Base64.decode("MzhkNDdjMDllN2E5YTgzNTg0ZjhlMmYy", 2);
        byte[] r109 = new byte[16];
        new SecureRandom().nextBytes(r109);
        String r110 = CJPayEncryptHelper.Companion.aesEncrypt("{\"sec_uid\":\"" + r104 + "\",\"device_id\":\"" + r105 + "\"}", r108, r109);
        if (CJStringExtensionKt.isNotNullOrEmpty(r110) == false) goto L28;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("is-no-login-pay-condition", "true"), TuplesKt.to("Nl-Sec-Info", r110), TuplesKt.to("Nl-Is-Enhance-Condition", "true")});
    L28:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("is-no-login-pay-condition", "true"), TuplesKt.to("sec-uid", r104)});
    L21:
        r107 = false;
        goto L22
    L16:
        r106 = false;
    L30:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("is-no-login-pay-condition", "true"), TuplesKt.to("sec-uid", r104)});
    L10:
        r104 = "";
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PluginPayWithoutLoginService
    public boolean isPayWithoutLoginEnv() {
        return CJBDPayWithoutLoginUtils.INSTANCE.isPayWithoutLogin();
    }

    public PlugInPayWithoutLoginServiceImpl() {
    }
}
