package com.larus.settings.btm;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Settings(storageKey = "btm_sdk_config")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'¨\u0006\u0005"}, d2 = {"Lcom/larus/settings/btm/IBtmSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getBtmSdkConfig", "Lorg/json/JSONObject;", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBtmSettings extends ISettings {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0097\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/larus/settings/btm/IBtmSettings$Companion;", "Lcom/larus/settings/btm/IBtmSettings;", "<init>", "()V", "getBtmSdkConfig", "Lorg/json/JSONObject;", "updateSettings", "", "p0", "Lcom/bytedance/news/common/settings/api/SettingsData;", "kotlin.jvm.PlatformType", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBtmSettings {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private final /* synthetic */ IBtmSettings $$delegate_0;

        static {
            $$INSTANCE = new Companion();
        }

        @Override // com.larus.settings.btm.IBtmSettings
        public JSONObject getBtmSdkConfig() {
            return this.$$delegate_0.getBtmSdkConfig();
        }

        @Override // com.bytedance.news.common.settings.api.annotation.ISettings
        public void updateSettings(SettingsData r100) {
            this.$$delegate_0.updateSettings(r100);
        }

        private Companion() {
            this.$$delegate_0 = (IBtmSettings) SettingsManager.obtain(IBtmSettings.class);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    JSONObject getBtmSdkConfig();
}
