package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lq9.m;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/StrategyData;", "", ControlRule.KEY_STRATEGY_TYPE, "", "timeoutDuration", DBDefinition.RETRY_COUNT, "isRetryEnabled", "", "<init>", "(IIIZ)V", "getStrategyType", "()I", "getTimeoutDuration", "getRetryCount", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StrategyData {

    @SerializedName("is_retry_enable")
    private final boolean isRetryEnabled;

    @SerializedName("retry_count")
    private final int retryCount;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE)
    private final int strategyType;

    @SerializedName("timeout_duration")
    private final int timeoutDuration;

    public StrategyData() {
        this(0, 0, 0, false, 15, null);
    }

    public static /* synthetic */ StrategyData copy$default(StrategyData r100, int r101, int r102, int r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.strategyType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.timeoutDuration;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.retryCount;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isRetryEnabled;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.strategyType;
    }

    public final int component2() {
        return this.timeoutDuration;
    }

    public final int component3() {
        return this.retryCount;
    }

    public final boolean component4() {
        return this.isRetryEnabled;
    }

    public final StrategyData copy(int r100, int r101, int r102, boolean r103) {
        return new StrategyData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StrategyData) == true) goto L8;
        return false;
    L8:
        StrategyData r101 = (StrategyData) r100;
        if (this.strategyType == r101.strategyType) goto L12;
        return false;
    L12:
        if (this.timeoutDuration == r101.timeoutDuration) goto L15;
        return false;
    L15:
        if (this.retryCount == r101.retryCount) goto L18;
        return false;
    L18:
        if (this.isRetryEnabled == r101.isRetryEnabled) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.strategyType * 31) + this.timeoutDuration) * 31) + this.retryCount) * 31;
        if (this.isRetryEnabled == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "StrategyData(strategyType=" + this.strategyType + ", timeoutDuration=" + this.timeoutDuration + ", retryCount=" + this.retryCount + ", isRetryEnabled=" + this.isRetryEnabled + ')';
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final int getStrategyType() {
        return this.strategyType;
    }

    public final int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public final boolean isRetryEnabled() {
        return this.isRetryEnabled;
    }

    public StrategyData(int r100, int r101, int r102, boolean r103) {
        this.strategyType = r100;
        this.timeoutDuration = r101;
        this.retryCount = r102;
        this.isRetryEnabled = r103;
    }

    public /* synthetic */ StrategyData(int r100, int r101, int r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        int r106 = m.f510339a;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        int r107 = m.f510339a;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        int r108 = m.f510339a;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
