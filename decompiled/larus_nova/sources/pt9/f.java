package pt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/opt/launch/JatoConfig;", "", "blockGcDuration", "", "boostDuration", "boostDurationList", "boostDurationPager", "<init>", "(JJJJ)V", "getBlockGcDuration", "()J", "getBoostDuration", "getBoostDurationList", "getBoostDurationPager", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("block_gc_duration")
    private final long blockGcDuration;

    @SerializedName("boost_duration")
    private final long boostDuration;

    @SerializedName("boost_duration_list")
    private final long boostDurationList;

    @SerializedName("boost_duration_pager")
    private final long boostDurationPager;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.blockGcDuration == r101.blockGcDuration) goto L12;
        return false;
    L12:
        if (this.boostDuration == r101.boostDuration) goto L15;
        return false;
    L15:
        if (this.boostDurationList == r101.boostDurationList) goto L18;
        return false;
    L18:
        if (this.boostDurationPager == r101.boostDurationPager) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.blockGcDuration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.boostDuration;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.boostDurationList;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.boostDurationPager;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "JatoConfig(blockGcDuration=" + this.blockGcDuration + ", boostDuration=" + this.boostDuration + ", boostDurationList=" + this.boostDurationList + ", boostDurationPager=" + this.boostDurationPager + ')';
    }

    public final long a() {
        return this.blockGcDuration;
    }

    public final long b() {
        return this.boostDuration;
    }

    public final long c() {
        return this.boostDurationList;
    }

    public final long d() {
        return this.boostDurationPager;
    }

    public f(int r100) {
        this.blockGcDuration = 2000;
        this.boostDuration = 2000;
        this.boostDurationList = 2000;
        this.boostDurationPager = 2000;
    }
}
