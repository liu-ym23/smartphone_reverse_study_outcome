package com.larus.update.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Settings(storageKey = "nova_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/larus/update/settings/IUpdateSdkSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getUpdateSdkConfig", "Lcom/google/gson/JsonObject;", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUpdateSdkSettings extends ISettings {
    JsonObject getUpdateSdkConfig();
}
