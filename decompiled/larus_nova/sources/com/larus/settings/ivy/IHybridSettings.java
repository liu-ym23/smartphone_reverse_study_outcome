package com.larus.settings.ivy;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Settings(storageKey = "nova_settings")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/larus/settings/ivy/IHybridSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "hybridCommonConfig", "Lcom/larus/settings/ivy/HybridCommonConfig;", "hybridExperimentConfig", "Lcom/larus/settings/ivy/HybridExperimentConfig;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHybridSettings extends ISettings {
    a hybridCommonConfig();

    c hybridExperimentConfig();
}
