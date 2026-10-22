package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/ObricMemoryMonitorConfig;", "", "memoryMonitorEnabled", "", "killTimeThresholdMinutes", "", "memoryJvmLeakThresholdInPercent", "", "memoryPssLeakThresholdInMb", "", "<init>", "(ZJFI)V", "getMemoryMonitorEnabled", "()Z", "getKillTimeThresholdMinutes", "()J", "getMemoryJvmLeakThresholdInPercent", "()F", "getMemoryPssLeakThresholdInMb", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryMonitorConfig {

    @SerializedName("kill_time_threshold_in_minutes")
    private final long killTimeThresholdMinutes;

    @SerializedName("memory_jvm_leak_threshold_in_percent")
    private final float memoryJvmLeakThresholdInPercent;

    @SerializedName("enable_obric_memory_monitor")
    private final boolean memoryMonitorEnabled;

    @SerializedName("memory_pss_leak_threshold_in_mb")
    private final int memoryPssLeakThresholdInMb;

    public ObricMemoryMonitorConfig() {
        this(false, 0, 0.0f, 0, 15, null);
    }

    public static /* synthetic */ ObricMemoryMonitorConfig copy$default(ObricMemoryMonitorConfig r100, boolean r101, long r102, float r103, int r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.memoryMonitorEnabled;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.killTimeThresholdMinutes;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.memoryJvmLeakThresholdInPercent;
    L11:
        float r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.memoryPssLeakThresholdInMb;
    L14:
        boolean r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final boolean component1() {
        return this.memoryMonitorEnabled;
    }

    public final long component2() {
        return this.killTimeThresholdMinutes;
    }

    public final float component3() {
        return this.memoryJvmLeakThresholdInPercent;
    }

    public final int component4() {
        return this.memoryPssLeakThresholdInMb;
    }

    public final ObricMemoryMonitorConfig copy(boolean r100, long r101, float r110, int r111) {
        return new ObricMemoryMonitorConfig(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricMemoryMonitorConfig) == true) goto L8;
        return false;
    L8:
        ObricMemoryMonitorConfig r101 = (ObricMemoryMonitorConfig) r100;
        if (this.memoryMonitorEnabled == r101.memoryMonitorEnabled) goto L12;
        return false;
    L12:
        if (this.killTimeThresholdMinutes == r101.killTimeThresholdMinutes) goto L15;
        return false;
    L15:
        if (Float.compare(this.memoryJvmLeakThresholdInPercent, r101.memoryJvmLeakThresholdInPercent) == 0) goto L18;
        return false;
    L18:
        if (this.memoryPssLeakThresholdInMb == r101.memoryPssLeakThresholdInMb) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.memoryMonitorEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.killTimeThresholdMinutes;
        return (((((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Float.floatToIntBits(this.memoryJvmLeakThresholdInPercent)) * 31) + this.memoryPssLeakThresholdInMb;
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricMemoryMonitorConfig(memoryMonitorEnabled=" + this.memoryMonitorEnabled + ", killTimeThresholdMinutes=" + this.killTimeThresholdMinutes + ", memoryJvmLeakThresholdInPercent=" + this.memoryJvmLeakThresholdInPercent + ", memoryPssLeakThresholdInMb=" + this.memoryPssLeakThresholdInMb + ')';
    }

    public final long getKillTimeThresholdMinutes() {
        return this.killTimeThresholdMinutes;
    }

    public final float getMemoryJvmLeakThresholdInPercent() {
        return this.memoryJvmLeakThresholdInPercent;
    }

    public final boolean getMemoryMonitorEnabled() {
        return this.memoryMonitorEnabled;
    }

    public final int getMemoryPssLeakThresholdInMb() {
        return this.memoryPssLeakThresholdInMb;
    }

    public ObricMemoryMonitorConfig(boolean r100, long r101, float r102, int r103) {
        this.memoryMonitorEnabled = r100;
        this.killTimeThresholdMinutes = r101;
        this.memoryJvmLeakThresholdInPercent = r102;
        this.memoryPssLeakThresholdInMb = r103;
    }

    public /* synthetic */ ObricMemoryMonitorConfig(boolean r100, long r101, float r102, int r103, int r104, DefaultConstructorMarker r110) {
        if ((r104 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r101 = 180;
    L8:
        long r105 = r101;
        if ((r104 & 4) == 0) goto L11;
        float r111 = 0.6f;
    L13:
        if ((r104 & 8) == 0) goto L15;
        int r106 = 800;
    L16:
        this(r100, r105, r111, r106);
        return;
    L15:
        r106 = r103;
        goto L16
    L11:
        r111 = r102;
        goto L13
    }
}
