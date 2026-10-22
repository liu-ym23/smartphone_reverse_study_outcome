package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabConfig;", "Ljava/io/Serializable;", "()V", "apiExtraParams", "", "getApiExtraParams", "()Ljava/lang/String;", "setApiExtraParams", "(Ljava/lang/String;)V", "apiPath", "getApiPath", "setApiPath", "eventExtraParams", "getEventExtraParams", "setEventExtraParams", "eventName", "getEventName", "setEventName", "needDynamicData", "", "getNeedDynamicData", "()Z", "setNeedDynamicData", "(Z)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreDynamicTabConfig implements Serializable {

    @SerializedName("tab_api_extra_params")
    private String apiExtraParams;

    @SerializedName("tab_api_path")
    private String apiPath;

    @SerializedName("tab_event_extra_params")
    private String eventExtraParams;

    @SerializedName("tab_event_name")
    private String eventName;

    @SerializedName("need_dynamic_data")
    private boolean needDynamicData;

    public ECStoreDynamicTabConfig() {
    }

    public final String getApiExtraParams() {
        return this.apiExtraParams;
    }

    public final String getApiPath() {
        return this.apiPath;
    }

    public final String getEventExtraParams() {
        return this.eventExtraParams;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final boolean getNeedDynamicData() {
        return this.needDynamicData;
    }

    public final void setApiExtraParams(String r1) {
        this.apiExtraParams = r1;
    }

    public final void setApiPath(String r1) {
        this.apiPath = r1;
    }

    public final void setEventExtraParams(String r1) {
        this.eventExtraParams = r1;
    }

    public final void setEventName(String r1) {
        this.eventName = r1;
    }

    public final void setNeedDynamicData(boolean r1) {
        this.needDynamicData = r1;
    }
}
