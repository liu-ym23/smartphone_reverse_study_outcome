package com.bytedance.caijing.sdk.infra.base.api.plugin.settings;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import ke4.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/settings/IPluginSettingsHelper;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lke4/a;", "getReportConfig", "", "isVip", "isDegradeExperimentUpload", "isDegradeOuterCounterRebuildOpt", "isDegradeIntegratedCounterRebuildSuccessRecovery", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IPluginSettingsHelper extends ICJService {
    a getReportConfig();

    boolean isDegradeExperimentUpload();

    boolean isDegradeIntegratedCounterRebuildSuccessRecovery();

    boolean isDegradeOuterCounterRebuildOpt();

    boolean isVip();
}
