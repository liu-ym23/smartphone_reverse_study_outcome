package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "passport_onekey_login")
public class OneKeyLoginConfig implements Serializable {

    @SerializedName("channel")
    public String channel;

    /* JADX INFO: renamed from: cm, reason: collision with root package name */
    @SerializedName("cm")
    public OneKeyLoginConfigBean f438074cm;

    /* JADX INFO: renamed from: ct, reason: collision with root package name */
    @SerializedName("ct")
    public OneKeyLoginConfigBean f438075ct;

    /* JADX INFO: renamed from: cu, reason: collision with root package name */
    @SerializedName(Segment.JsonKey.CURRENT)
    public OneKeyLoginConfigBean f438076cu;

    public static class OneKeyLoginConfigBean implements Serializable {

        @SerializedName("app_id")
        public String appId;

        @SerializedName("app_key")
        public String appKey;

        public OneKeyLoginConfigBean() {
        }
    }

    public OneKeyLoginConfig() {
    }
}
