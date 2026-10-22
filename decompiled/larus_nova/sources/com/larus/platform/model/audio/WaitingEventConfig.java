package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/audio/WaitingEventConfig;", "", "enable", "", "frequency", "", "limitStart", "", "limitEnd", "<init>", "(ZFII)V", "getEnable", "()Z", "getFrequency", "()F", "getLimitStart", "()I", "getLimitEnd", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WaitingEventConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("frequency")
    private final float frequency;

    @SerializedName("time_limit_end")
    private final int limitEnd;

    @SerializedName("time_limit_start")
    private final int limitStart;

    public WaitingEventConfig() {
        this(false, 0.0f, 0, 0, 15, null);
    }

    public static /* synthetic */ WaitingEventConfig copy$default(WaitingEventConfig r100, boolean r101, float r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.frequency;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.limitStart;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.limitEnd;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final float component2() {
        return this.frequency;
    }

    public final int component3() {
        return this.limitStart;
    }

    public final int component4() {
        return this.limitEnd;
    }

    public final WaitingEventConfig copy(boolean r100, float r101, int r102, int r103) {
        return new WaitingEventConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WaitingEventConfig) == true) goto L8;
        return false;
    L8:
        WaitingEventConfig r101 = (WaitingEventConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Float.compare(this.frequency, r101.frequency) == 0) goto L15;
        return false;
    L15:
        if (this.limitStart == r101.limitStart) goto L18;
        return false;
    L18:
        if (this.limitEnd == r101.limitEnd) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((r100 * 31) + Float.floatToIntBits(this.frequency)) * 31) + this.limitStart) * 31) + this.limitEnd;
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "WaitingEventConfig(enable=" + this.enable + ", frequency=" + this.frequency + ", limitStart=" + this.limitStart + ", limitEnd=" + this.limitEnd + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getFrequency() {
        return this.frequency;
    }

    public final int getLimitEnd() {
        return this.limitEnd;
    }

    public final int getLimitStart() {
        return this.limitStart;
    }

    public WaitingEventConfig(boolean r100, float r101, int r102, int r103) {
        this.enable = r100;
        this.frequency = r101;
        this.limitStart = r102;
        this.limitEnd = r103;
    }

    public /* synthetic */ WaitingEventConfig(boolean r100, float r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
