package rv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/perf_degrade/DiskOccupancyDegradeConfig;", "", "enable", "", "occupySizeMb", "", "triggerDelayMs", "minFreeSpaceMb", "<init>", "(ZJJJ)V", "getEnable", "()Z", "getOccupySizeMb", "()J", "getTriggerDelayMs", "getMinFreeSpaceMb", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("min_free_space_mb")
    private final long minFreeSpaceMb;

    @SerializedName("occupy_size_mb")
    private final long occupySizeMb;

    @SerializedName("trigger_delay_ms")
    private final long triggerDelayMs;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.occupySizeMb == r101.occupySizeMb) goto L15;
        return false;
    L15:
        if (this.triggerDelayMs == r101.triggerDelayMs) goto L18;
        return false;
    L18:
        if (this.minFreeSpaceMb == r101.minFreeSpaceMb) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.occupySizeMb;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.triggerDelayMs;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.minFreeSpaceMb;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DiskOccupancyDegradeConfig(enable=" + this.enable + ", occupySizeMb=" + this.occupySizeMb + ", triggerDelayMs=" + this.triggerDelayMs + ", minFreeSpaceMb=" + this.minFreeSpaceMb + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.minFreeSpaceMb;
    }

    public final long c() {
        return this.occupySizeMb;
    }

    public final long d() {
        return this.triggerDelayMs;
    }

    public /* synthetic */ a(int r100) {
        this(false, 0, 30000, 100);
    }

    public a(boolean r100, long r101, long r102, long r103) {
        this.enable = r100;
        this.occupySizeMb = r101;
        this.triggerDelayMs = r102;
        this.minFreeSpaceMb = r103;
    }
}
