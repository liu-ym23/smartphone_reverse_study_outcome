package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/audio/EventConfig;", "", "enable", "", "frequency", "", "<init>", "(ZF)V", "getEnable", "()Z", "getFrequency", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("frequency")
    private final float frequency;

    public EventConfig() {
        boolean r100 = false;
        float r101 = 0.0f;
        this(r100, r101, 3, null);
    }

    public static /* synthetic */ EventConfig copy$default(EventConfig r100, boolean r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.frequency;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final float component2() {
        return this.frequency;
    }

    public final EventConfig copy(boolean r100, float r101) {
        return new EventConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EventConfig) == true) goto L8;
        return false;
    L8:
        EventConfig r101 = (EventConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Float.compare(this.frequency, r101.frequency) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + Float.floatToIntBits(this.frequency);
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "EventConfig(enable=" + this.enable + ", frequency=" + this.frequency + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getFrequency() {
        return this.frequency;
    }

    public EventConfig(boolean r100, float r101) {
        this.enable = r100;
        this.frequency = r101;
    }

    public /* synthetic */ EventConfig(boolean r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.0f;
    L8:
        this(r100, r101);
    }
}
