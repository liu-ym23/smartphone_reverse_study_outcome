package com.bytedance.ug.sdk.luckydog.api.drill;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
class a {

    @SerializedName("appLogEvent")
    public String appLogEvent;

    @SerializedName("appLogWithDataTags")
    public String appLogWithDataTags;

    @SerializedName("crashMsg")
    public String crashMsg;

    @SerializedName("crashStack")
    public String crashStack;

    @SerializedName("crashType")
    public String crashType;

    @SerializedName("customerDataTags")
    public String customerDataTags;

    @SerializedName("customerFilters")
    public String customerFilters;

    @SerializedName("drillPath")
    public String drillPath;

    @SerializedName("logType")
    public String logType;

    @SerializedName("syncWithException")
    public boolean syncWithException;

    @SerializedName("testTriggerDelay")
    public long testTriggerDelay;

    @SerializedName("testTriggerProbability")
    public long testTriggerProbability;

    @SerializedName("testTriggerRange")
    public int testTriggerRange;

    public final String toString() {
        return "PublishTestSupportConfig{crashType='" + this.crashType + "', crashStack='" + this.crashStack + "', testTriggerDelay=" + this.testTriggerDelay + ", testTriggerProbability=" + this.testTriggerProbability + ", testTriggerRange=" + this.testTriggerRange + ", crashMsg='" + this.crashMsg + "', customerDataTags='" + this.customerDataTags + "', customerFilters='" + this.customerFilters + "', logType='" + this.logType + "', appLogEvent='" + this.appLogEvent + "', drillPath='" + this.drillPath + "', syncWithException=" + this.syncWithException + '}';
    }

    public a() {
        this.crashType = "java";
        this.crashStack = "";
        this.testTriggerDelay = -1;
        this.testTriggerProbability = 0;
        this.testTriggerRange = 0;
        this.crashMsg = "PUBLISH_FUSED_TEST_EXCEPTION";
        this.customerDataTags = "";
        this.customerFilters = "";
        this.logType = "LOG_TYPE_PUBLISH_FUSED_TEST";
        this.appLogEvent = "publish_test_drill";
        this.appLogWithDataTags = "";
        this.drillPath = "";
        this.syncWithException = true;
    }
}
