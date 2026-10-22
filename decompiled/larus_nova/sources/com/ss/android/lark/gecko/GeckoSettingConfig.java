package com.ss.android.lark.gecko;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "gecko_config")
public class GeckoSettingConfig implements Serializable {

    @SerializedName("global")
    public GeckoSettingConfigBean mGlobal;

    @SerializedName("ka_dynamic_resource")
    public GeckoSettingConfigBean mKaDynamicResource;

    public static class GeckoSettingConfigBean implements Serializable {

        @SerializedName("access_key")
        public String mAccessKey;

        @SerializedName("aid")
        public String mAid;

        @SerializedName("domain_key")
        public String mDomainKey;

        @SerializedName("name")
        public String mName;

        @SerializedName(EffectConfiguration.KEY_REGION)
        public String mRegion;

        public GeckoSettingConfigBean() {
        }
    }

    public GeckoSettingConfig() {
    }
}
