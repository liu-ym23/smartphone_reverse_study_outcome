package com.bytedance.android.shopping.store.home.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/home/event/ECIsvComponentLoadEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "cdnUrl", "", "getCdnUrl", "()Ljava/lang/String;", "setCdnUrl", "(Ljava/lang/String;)V", "expired", "", "getExpired", "()Ljava/lang/Boolean;", "setExpired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hitVersion", "getHitVersion", "setHitVersion", "logIsvExtra", "getLogIsvExtra", "setLogIsvExtra", "timeCost", "", "getTimeCost", "()Ljava/lang/Long;", "setTimeCost", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECIsvComponentLoadEvent extends BaseMetricsEvent2 {

    @EventKey("cdnUrl")
    private String cdnUrl;

    @EventKey("expired")
    private Boolean expired;

    @EventKey("hitVersion")
    private String hitVersion;

    @EventKey("log_isv_extra")
    private String logIsvExtra;

    @EventKey("timeCost")
    private Long timeCost;

    public ECIsvComponentLoadEvent() {
        super("ec_isv_component_load");
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final Boolean getExpired() {
        return this.expired;
    }

    public final String getHitVersion() {
        return this.hitVersion;
    }

    public final String getLogIsvExtra() {
        return this.logIsvExtra;
    }

    public final Long getTimeCost() {
        return this.timeCost;
    }

    public final void setCdnUrl(String r1) {
        this.cdnUrl = r1;
    }

    public final void setExpired(Boolean r1) {
        this.expired = r1;
    }

    public final void setHitVersion(String r1) {
        this.hitVersion = r1;
    }

    public final void setLogIsvExtra(String r1) {
        this.logIsvExtra = r1;
    }

    public final void setTimeCost(Long r1) {
        this.timeCost = r1;
    }
}
