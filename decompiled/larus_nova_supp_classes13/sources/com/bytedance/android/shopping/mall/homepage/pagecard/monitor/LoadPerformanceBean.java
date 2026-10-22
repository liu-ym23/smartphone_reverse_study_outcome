package com.bytedance.android.shopping.mall.homepage.pagecard.monitor;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR \u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010%\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R\"\u0010(\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\"\u0010+\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 ¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/pagecard/monitor/LoadPerformanceBean;", "Ljava/io/Serializable;", "()V", "errorCode", "", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "isFirstLoad", "setFirstLoad", "resourceType", "getResourceType", "setResourceType", "schemaType", "getSchemaType", "setSchemaType", "status", "getStatus", "setStatus", "tEventSubscribeFinish", "", "getTEventSubscribeFinish", "()Ljava/lang/Long;", "setTEventSubscribeFinish", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "tLoadFailed", "getTLoadFailed", "setTLoadFailed", "tLoadFinish", "getTLoadFinish", "setTLoadFinish", "tLoadStart", "getTLoadStart", "setTLoadStart", "tNativeLoadFinish", "getTNativeLoadFinish", "setTNativeLoadFinish", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadPerformanceBean implements Serializable {

    @SerializedName("error_code")
    private Integer errorCode;

    @SerializedName("error_msg")
    private String errorMsg;

    @SerializedName("is_first_load")
    private Integer isFirstLoad;

    @SerializedName("resource_type")
    private String resourceType;

    @SerializedName("schema_type")
    private String schemaType;

    @SerializedName("status")
    private Integer status;

    @SerializedName("t_event_subscribe_finish")
    private Long tEventSubscribeFinish;

    @SerializedName("t_load_failed")
    private Long tLoadFailed;

    @SerializedName("t_load_finish")
    private Long tLoadFinish;

    @SerializedName("t_load_start")
    private Long tLoadStart;

    @SerializedName("t_native_load_finish")
    private Long tNativeLoadFinish;

    public LoadPerformanceBean() {
        this.schemaType = "";
        this.resourceType = "";
        this.tLoadStart = 0L;
        this.tNativeLoadFinish = 0L;
        this.tLoadFinish = 0L;
        this.tLoadFailed = 0L;
        this.tEventSubscribeFinish = 0L;
        this.isFirstLoad = 0;
        this.status = 0;
        this.errorCode = 0;
        this.errorMsg = "";
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final String getSchemaType() {
        return this.schemaType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getTEventSubscribeFinish() {
        return this.tEventSubscribeFinish;
    }

    public final Long getTLoadFailed() {
        return this.tLoadFailed;
    }

    public final Long getTLoadFinish() {
        return this.tLoadFinish;
    }

    public final Long getTLoadStart() {
        return this.tLoadStart;
    }

    public final Long getTNativeLoadFinish() {
        return this.tNativeLoadFinish;
    }

    public final Integer isFirstLoad() {
        return this.isFirstLoad;
    }

    public final void setErrorCode(Integer r1) {
        this.errorCode = r1;
    }

    public final void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public final void setFirstLoad(Integer r1) {
        this.isFirstLoad = r1;
    }

    public final void setResourceType(String r1) {
        this.resourceType = r1;
    }

    public final void setSchemaType(String r1) {
        this.schemaType = r1;
    }

    public final void setStatus(Integer r1) {
        this.status = r1;
    }

    public final void setTEventSubscribeFinish(Long r1) {
        this.tEventSubscribeFinish = r1;
    }

    public final void setTLoadFailed(Long r1) {
        this.tLoadFailed = r1;
    }

    public final void setTLoadFinish(Long r1) {
        this.tLoadFinish = r1;
    }

    public final void setTLoadStart(Long r1) {
        this.tLoadStart = r1;
    }

    public final void setTNativeLoadFinish(Long r1) {
        this.tNativeLoadFinish = r1;
    }
}
