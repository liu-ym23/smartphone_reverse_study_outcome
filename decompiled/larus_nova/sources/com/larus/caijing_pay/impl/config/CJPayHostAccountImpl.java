package com.larus.caijing_pay.impl.config;

import com.bytedance.caijing.sdk.infra.base.api.env.ICJPayToutiaoHostService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import n38.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJPayHostAccountImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/env/ICJPayToutiaoHostService;", "<init>", "()V", "getSaasAccessToken", "", "getPackageName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJPayHostAccountImpl implements ICJPayToutiaoHostService {
    public CJPayHostAccountImpl() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return AppHost.f326268a.getApplication().getPackageName();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.env.ICJPayToutiaoHostService
    public String getSaasAccessToken() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L7;
        e r101 = r100.Y(LoginPlatform.DOUYIN);
        if (r101 == null) goto L7;
        String r102 = r101.f516997a;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }
}
