package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/AutoIncreaseDelayedTimeConfig;", "", "autoIncreaseDelayedTime", "", "autoIncreaseDelayedTimeSeed", "<init>", "(JJ)V", "getAutoIncreaseDelayedTime", "()J", "getAutoIncreaseDelayedTimeSeed", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoIncreaseDelayedTimeConfig {

    @SerializedName("auto_increase_delayed_time")
    private final long autoIncreaseDelayedTime;

    @SerializedName("auto_increase_delayed_time_seed")
    private final long autoIncreaseDelayedTimeSeed;

    public AutoIncreaseDelayedTimeConfig() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ AutoIncreaseDelayedTimeConfig copy$default(AutoIncreaseDelayedTimeConfig r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.autoIncreaseDelayedTime;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.autoIncreaseDelayedTimeSeed;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.autoIncreaseDelayedTime;
    }

    public final long component2() {
        return this.autoIncreaseDelayedTimeSeed;
    }

    public final AutoIncreaseDelayedTimeConfig copy(long r100, long r101) {
        return new AutoIncreaseDelayedTimeConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoIncreaseDelayedTimeConfig) == true) goto L8;
        return false;
    L8:
        AutoIncreaseDelayedTimeConfig r101 = (AutoIncreaseDelayedTimeConfig) r100;
        if (this.autoIncreaseDelayedTime == r101.autoIncreaseDelayedTime) goto L12;
        return false;
    L12:
        if (this.autoIncreaseDelayedTimeSeed == r101.autoIncreaseDelayedTimeSeed) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.autoIncreaseDelayedTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.autoIncreaseDelayedTimeSeed;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "AutoIncreaseDelayedTimeConfig(autoIncreaseDelayedTime=" + this.autoIncreaseDelayedTime + ", autoIncreaseDelayedTimeSeed=" + this.autoIncreaseDelayedTimeSeed + ')';
    }

    public final long getAutoIncreaseDelayedTime() {
        return this.autoIncreaseDelayedTime;
    }

    public final long getAutoIncreaseDelayedTimeSeed() {
        return this.autoIncreaseDelayedTimeSeed;
    }

    public AutoIncreaseDelayedTimeConfig(long r100, long r101) {
        this.autoIncreaseDelayedTime = r100;
        this.autoIncreaseDelayedTimeSeed = r101;
    }

    public /* synthetic */ AutoIncreaseDelayedTimeConfig(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1500;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 1500;
    L8:
        this(r100, r101);
    }
}
