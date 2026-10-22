package com.larus.settings.protector;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Settings(storageKey = "nova_protector_settings")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/larus/settings/protector/IProtectorSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getDefaultProtectorConfig", "Lcom/larus/settings/protector/DefaultProtectorConfig;", "getRunnableProtectorConfig", "Lcom/larus/settings/protector/RunnableProtectorConfig;", "getGsonFilterNotNullConfig", "Lcom/larus/settings/protector/GsonFilterNotNullConfig;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IProtectorSettings extends ISettings {
    DefaultProtectorConfig getDefaultProtectorConfig();

    GsonFilterNotNullConfig getGsonFilterNotNullConfig();

    RunnableProtectorConfig getRunnableProtectorConfig();
}
