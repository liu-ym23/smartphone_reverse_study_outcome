package rv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/larus/settings/provider/perf_degrade/JankDegradeConfig;", "", "enable", "", "triggerDelayMs", "", "triggerProbability", "", "triggerRange", "blockDurationMs", "triggerCount", "triggerIntervalMs", "<init>", "(ZJIIJIJ)V", "getEnable", "()Z", "getTriggerDelayMs", "()J", "getTriggerProbability", "()I", "getTriggerRange", "getBlockDurationMs", "getTriggerCount", "getTriggerIntervalMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("block_duration_ms")
    private final long blockDurationMs;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("trigger_count")
    private final int triggerCount;

    @SerializedName("trigger_delay_ms")
    private final long triggerDelayMs;

    @SerializedName("trigger_interval_ms")
    private final long triggerIntervalMs;

    @SerializedName("trigger_probability")
    private final int triggerProbability;

    @SerializedName("trigger_range")
    private final int triggerRange;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.triggerDelayMs == r101.triggerDelayMs) goto L15;
        return false;
    L15:
        if (this.triggerProbability == r101.triggerProbability) goto L18;
        return false;
    L18:
        if (this.triggerRange == r101.triggerRange) goto L21;
        return false;
    L21:
        if (this.blockDurationMs == r101.blockDurationMs) goto L24;
        return false;
    L24:
        if (this.triggerCount == r101.triggerCount) goto L27;
        return false;
    L27:
        if (this.triggerIntervalMs == r101.triggerIntervalMs) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.triggerDelayMs;
        int r102 = ((((((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.triggerProbability) * 31) + this.triggerRange) * 31;
        long r103 = this.blockDurationMs;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.triggerCount) * 31;
        long r105 = this.triggerIntervalMs;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "JankDegradeConfig(enable=" + this.enable + ", triggerDelayMs=" + this.triggerDelayMs + ", triggerProbability=" + this.triggerProbability + ", triggerRange=" + this.triggerRange + ", blockDurationMs=" + this.blockDurationMs + ", triggerCount=" + this.triggerCount + ", triggerIntervalMs=" + this.triggerIntervalMs + ')';
    }

    public final long a() {
        return this.blockDurationMs;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.triggerCount;
    }

    public final long d() {
        return this.triggerDelayMs;
    }

    public final long e() {
        return this.triggerIntervalMs;
    }

    public final int f() {
        return this.triggerProbability;
    }

    public final int g() {
        return this.triggerRange;
    }

    public /* synthetic */ c(int r110) {
        this(false, 1000, 1, 1000, 3000, 1, 10000);
    }

    public c(boolean r100, long r101, int r102, int r103, long r104, int r105, long r106) {
        this.enable = r100;
        this.triggerDelayMs = r101;
        this.triggerProbability = r102;
        this.triggerRange = r103;
        this.blockDurationMs = r104;
        this.triggerCount = r105;
        this.triggerIntervalMs = r106;
    }
}
