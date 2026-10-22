package com.bytedance.caijing.sdk.infra.base.api.localtest;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/localtest/CJPayDebugSwitchOverrideService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getCashierLargeScreenAdaptOverrideState", "", "getDoubleConfirmIsPageOverrideState", "getForceDisablePbLinkOverrideState", "getHitSdkCashierCoreMergeOverrideState", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayDebugSwitchOverrideService extends ICJService {
    int getCashierLargeScreenAdaptOverrideState();

    int getDoubleConfirmIsPageOverrideState();

    int getForceDisablePbLinkOverrideState();

    int getHitSdkCashierCoreMergeOverrideState();
}
