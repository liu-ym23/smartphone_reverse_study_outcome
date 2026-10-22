package com.bytedance.falconx.statistic;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;

/* JADX INFO: loaded from: classes19.dex */
public class Common {

    @SerializedName("app_version")
    public String appVersion;

    @SerializedName("device_id")
    public String deviceId;

    @SerializedName("device_model")
    public String deviceModel;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @SerializedName("os")
    public int f243225os;

    @SerializedName(EffectConfiguration.KEY_REGION)
    public String region;

    @SerializedName("sdk_version")
    public String sdkVersion;

    public Common() {
        this.sdkVersion = "5.5.3";
        this.deviceModel = Build.MODEL;
        this.f243225os = 0;
    }
}
