package com.bytedance.caijing.sdk.infra.base.api.localtest;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import pd4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000e\u001a\u00020\u0004H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/localtest/CJLocalTestService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "showPluginNotReadyEnvTip", "", "isAlogDebugEnv", "showCJH5DeprecatedTip", "showCJH5JSBRegisterFailMsg", "showCJH5OverrideFailMsg", "", "pageType", "showCJAnnieXToast", "Lpd4/a;", "getContainerLocalTestConfig", "useNewEnvAk", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJLocalTestService extends ICJService {
    a getContainerLocalTestConfig();

    boolean isAlogDebugEnv();

    void showCJAnnieXToast(String r100);

    void showCJH5DeprecatedTip();

    void showCJH5JSBRegisterFailMsg();

    void showCJH5OverrideFailMsg();

    void showPluginNotReadyEnvTip();

    boolean useNewEnvAk();
}
