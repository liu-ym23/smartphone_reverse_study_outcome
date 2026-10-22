package com.ss.android.lark.integrator.ccm.dependency;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "client_frontier_config")
public class FrontierAppKeyConfig {

    @SerializedName("docs_frontier_app_key")
    public String mDocAppKey;

    @SerializedName("lark_frontier_app_key")
    public String mLarkAppKey;

    public FrontierAppKeyConfig() {
    }
}
