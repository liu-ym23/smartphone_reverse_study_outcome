package com.larus.settings.performance;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Settings(storageKey = "perf_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/larus/settings/performance/IPerfSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "systemBatteryRecorderConfig", "Lcom/larus/settings/performance/SystemBatteryRecorderConfig;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPerfSettings extends ISettings {
    SystemBatteryRecorderConfig systemBatteryRecorderConfig();
}
