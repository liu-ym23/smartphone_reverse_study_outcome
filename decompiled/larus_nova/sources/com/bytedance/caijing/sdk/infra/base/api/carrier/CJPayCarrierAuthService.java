package com.bytedance.caijing.sdk.infra.base.api.carrier;

import ad4.a;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/carrier/CJPayCarrierAuthService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "token", "from", "providerAppId", "Lad4/a;", "callback", "", "getAuthTicket", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJPayCarrierAuthService extends ICJService {
    void getAuthTicket(String r100, String r101, String r102, a r103);
}
