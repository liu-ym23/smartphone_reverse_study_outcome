package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;

/* JADX INFO: loaded from: classes35.dex */
@AppConfig(key = "npth_optimization")
public class MessageResourceLoadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f413363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f413364b;

    @SerializedName("min_enable_preload_app_score")
    public double minEnablePreloadAppScore;

    @SerializedName("min_enable_preload_doc_score")
    public double minEnablePreloadDocScore;

    public final String toString() {
        return "FeedPreloadConfig{minEnablePreloadDocScore=" + this.minEnablePreloadDocScore + ", minEnablePreloadAppScore=" + this.minEnablePreloadAppScore + '}';
    }

    public MessageResourceLoadConfig() {
        this.minEnablePreloadDocScore = 8.0d;
        this.minEnablePreloadAppScore = 8.0d;
        this.f413363a = true;
        this.f413364b = true;
    }

    public static MessageResourceLoadConfig a() {
        MessageResourceLoadConfig r100 = (MessageResourceLoadConfig) SettingManager.getInstance().get(MessageResourceLoadConfig.class);
        DevicePerfUtils.a r101 = DevicePerfUtils.e();
        if (r101 == null) goto L13;
        double r102 = r101.f460576e;
        double r103 = r100.minEnablePreloadDocScore;
        boolean r104 = true;
        if (r102 <= r103) goto L7;
        boolean r105 = true;
    L8:
        r100.f413363a = r105;
        if (r102 > r103) goto L12;
        r104 = false;
    L12:
        r100.f413363a = r104;
        goto L13
    L7:
        r105 = false;
    L13:
        return r100;
    }
}
