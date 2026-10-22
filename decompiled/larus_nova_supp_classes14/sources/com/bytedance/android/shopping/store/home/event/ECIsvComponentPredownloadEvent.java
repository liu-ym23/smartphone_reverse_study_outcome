package com.bytedance.android.shopping.store.home.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/store/home/event/ECIsvComponentPredownloadEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "cdnUrl", "", "getCdnUrl", "()Ljava/lang/String;", "setCdnUrl", "(Ljava/lang/String;)V", "errorMsg", "getErrorMsg", "setErrorMsg", "hasCache", "", "getHasCache", "()Ljava/lang/Integer;", "setHasCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "success", "", "getSuccess", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "timeCost", "", "getTimeCost", "()Ljava/lang/Long;", "setTimeCost", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "version", "getVersion", "setVersion", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECIsvComponentPredownloadEvent extends BaseMetricsEvent2 {

    @EventKey("cdnUrl")
    private String cdnUrl;

    @EventKey("errorMsg")
    private String errorMsg;

    @EventKey("hasCache")
    private Integer hasCache;

    @EventKey("success")
    private Boolean success;

    @EventKey("timeCost")
    private Long timeCost;

    @EventKey("version")
    private String version;

    public ECIsvComponentPredownloadEvent() {
        super("ec_isv_component_predownload");
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Integer getHasCache() {
        return this.hasCache;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final Long getTimeCost() {
        return this.timeCost;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setCdnUrl(String r1) {
        this.cdnUrl = r1;
    }

    public final void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public final void setHasCache(Integer r1) {
        this.hasCache = r1;
    }

    public final void setSuccess(Boolean r1) {
        this.success = r1;
    }

    public final void setTimeCost(Long r1) {
        this.timeCost = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }
}
