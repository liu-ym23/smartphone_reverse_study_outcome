package com.larus.settings.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/settings/model/HelloTriggerConfig;", "", "<init>", "()V", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "", "getWaitTime", "()I", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HelloTriggerConfig {

    @SerializedName("wait_time")
    private final int waitTime;

    public HelloTriggerConfig() {
        this.waitTime = -1;
    }

    public final int getWaitTime() {
        return this.waitTime;
    }
}
