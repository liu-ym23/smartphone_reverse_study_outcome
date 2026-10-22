package com.bytedance.caijing.sdk.infra.base.api.env;

import com.android.ttcjpaysdk.base.service.ICJPayService;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/env/ICJPayToutiaoHostService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getSaasAccessToken", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayToutiaoHostService extends ICJPayService, ICJService {
    String getSaasAccessToken();
}
