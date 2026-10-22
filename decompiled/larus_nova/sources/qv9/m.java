package qv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/settings/provider/perf/HeapExpandV4Config;", "", "enable", "", "targetRegionSizeMb", "", "<init>", "(ZJ)V", "getEnable", "()Z", "getTargetRegionSizeMb", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("target_region_size_mb")
    private final long targetRegionSizeMb;

    public m() {
        this(false, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.targetRegionSizeMb == r101.targetRegionSizeMb) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.targetRegionSizeMb;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "HeapExpandV4Config(enable=" + this.enable + ", targetRegionSizeMb=" + this.targetRegionSizeMb + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.targetRegionSizeMb;
    }

    public m(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r101 & 2) == 0) goto L8;
        long r102 = 2048;
    L9:
        this.enable = r100;
        this.targetRegionSizeMb = r102;
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
