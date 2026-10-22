package com.bytedance.caijing.sdk.infra.base.api.router;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/router/CJHostRouterService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getOpenSchemeWithContextInterface", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeWithContextInterface;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJHostRouterService extends ICJService {
    TTCJPayOpenSchemeWithContextInterface getOpenSchemeWithContextInterface();
}
