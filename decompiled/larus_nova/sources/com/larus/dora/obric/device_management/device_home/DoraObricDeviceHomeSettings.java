package com.larus.dora.obric.device_management.device_home;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Settings(storageKey = "dora_obric_device_home_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "doraObricDeviceHomeQuickActionConfig", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraObricDeviceHomeSettings extends ISettings {
    DoraObricDeviceHomeQuickActionConfig doraObricDeviceHomeQuickActionConfig();
}
