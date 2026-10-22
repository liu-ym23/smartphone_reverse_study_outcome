package com.bytedance.caijing.sdk.infra.base.api.phone;

import ce4.a;
import ce4.b;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/phone/PhoneCarrierService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "getCurrentPhoneCarrier", "Lce4/b;", "callback", "", "getMaskedPhoneInfo", "Lce4/a;", "getAuthToken", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface PhoneCarrierService extends ICJService {
    void getAuthToken(a r100);

    String getCurrentPhoneCarrier();

    void getMaskedPhoneInfo(b r100);
}
