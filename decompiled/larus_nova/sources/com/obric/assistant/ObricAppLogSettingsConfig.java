package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/ObricAppLogSettingsConfig;", "", "reinstallTimeoutMs", "", "minRetryDelayMs", "maxRetryDelayMs", "maxSelfLoopRetryCount", "", "<init>", "(JJJI)V", "getReinstallTimeoutMs", "()J", "getMinRetryDelayMs", "getMaxRetryDelayMs", "getMaxSelfLoopRetryCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppLogSettingsConfig {

    @SerializedName("max_retry_delay_ms")
    private final long maxRetryDelayMs;

    @SerializedName("max_self_loop_retry_count")
    private final int maxSelfLoopRetryCount;

    @SerializedName("min_retry_delay_ms")
    private final long minRetryDelayMs;

    @SerializedName("reinstall_timeout_ms")
    private final long reinstallTimeoutMs;

    public ObricAppLogSettingsConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ObricAppLogSettingsConfig copy$default(ObricAppLogSettingsConfig r100, long r101, long r110, long r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        long r102 = r100.reinstallTimeoutMs;
    L7:
        if ((r113 & 2) == 0) goto L9;
        long r103 = r100.minRetryDelayMs;
    L11:
        if ((r113 & 4) == 0) goto L13;
        long r104 = r100.maxRetryDelayMs;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r105 = r100.maxSelfLoopRetryCount;
    L19:
        return r100.copy(r102, r103, r104, r105);
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.reinstallTimeoutMs;
    }

    public final long component2() {
        return this.minRetryDelayMs;
    }

    public final long component3() {
        return this.maxRetryDelayMs;
    }

    public final int component4() {
        return this.maxSelfLoopRetryCount;
    }

    public final ObricAppLogSettingsConfig copy(long r110, long r111, long r112, int r113) {
        return new ObricAppLogSettingsConfig(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricAppLogSettingsConfig) == true) goto L8;
        return false;
    L8:
        ObricAppLogSettingsConfig r101 = (ObricAppLogSettingsConfig) r100;
        if (this.reinstallTimeoutMs == r101.reinstallTimeoutMs) goto L12;
        return false;
    L12:
        if (this.minRetryDelayMs == r101.minRetryDelayMs) goto L15;
        return false;
    L15:
        if (this.maxRetryDelayMs == r101.maxRetryDelayMs) goto L18;
        return false;
    L18:
        if (this.maxSelfLoopRetryCount == r101.maxSelfLoopRetryCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.reinstallTimeoutMs;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.minRetryDelayMs;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.maxRetryDelayMs;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.maxSelfLoopRetryCount;
    }

    public String toString() {
        return "ObricAppLogSettingsConfig(reinstallTimeoutMs=" + this.reinstallTimeoutMs + ", minRetryDelayMs=" + this.minRetryDelayMs + ", maxRetryDelayMs=" + this.maxRetryDelayMs + ", maxSelfLoopRetryCount=" + this.maxSelfLoopRetryCount + ')';
    }

    public final long getMaxRetryDelayMs() {
        return this.maxRetryDelayMs;
    }

    public final int getMaxSelfLoopRetryCount() {
        return this.maxSelfLoopRetryCount;
    }

    public final long getMinRetryDelayMs() {
        return this.minRetryDelayMs;
    }

    public final long getReinstallTimeoutMs() {
        return this.reinstallTimeoutMs;
    }

    public ObricAppLogSettingsConfig(long r100, long r101, long r102, int r103) {
        this.reinstallTimeoutMs = r100;
        this.minRetryDelayMs = r101;
        this.maxRetryDelayMs = r102;
        this.maxSelfLoopRetryCount = r103;
    }

    public /* synthetic */ ObricAppLogSettingsConfig(long r100, long r110, long r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        long r101 = 5000;
    L7:
        if ((r113 & 2) == 0) goto L9;
        long r102 = 1000;
    L11:
        if ((r113 & 4) == 0) goto L13;
        long r103 = 20000;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r104 = 10;
    L18:
        this(r101, r102, r103, r104);
        return;
    L17:
        r104 = r112;
        goto L18
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }
}
