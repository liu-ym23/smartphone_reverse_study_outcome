package com.ss.android.lark.hobby;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "client_dynamic_brand")
public class HobbySettingConfig implements Serializable {

    @SerializedName("pull_interval")
    public int mPullInterval;

    public HobbySettingConfig() {
    }
}
