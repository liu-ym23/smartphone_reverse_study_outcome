package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/settings/SppLinkRetryConfig;", "", "enable", "", "delayMs", "", "<init>", "(ZJ)V", "getEnable", "()Z", "getDelayMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SppLinkRetryConfig {

    @SerializedName("delay_ms")
    private final long delayMs;

    @SerializedName("enable")
    private final boolean enable;

    public SppLinkRetryConfig() {
        this(false, 0, 3, null);
    }

    public static /* synthetic */ SppLinkRetryConfig copy$default(SppLinkRetryConfig r100, boolean r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.delayMs;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final long component2() {
        return this.delayMs;
    }

    public final SppLinkRetryConfig copy(boolean r100, long r101) {
        return new SppLinkRetryConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SppLinkRetryConfig) == true) goto L8;
        return false;
    L8:
        SppLinkRetryConfig r101 = (SppLinkRetryConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.delayMs == r101.delayMs) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.delayMs;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "SppLinkRetryConfig(enable=" + this.enable + ", delayMs=" + this.delayMs + ')';
    }

    public final long getDelayMs() {
        return this.delayMs;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public SppLinkRetryConfig(boolean r100, long r101) {
        this.enable = r100;
        this.delayMs = r101;
    }

    public /* synthetic */ SppLinkRetryConfig(boolean r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 1500;
    L8:
        this(r100, r101);
    }
}
