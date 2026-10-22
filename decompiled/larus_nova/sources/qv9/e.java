package qv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/settings/provider/perf/DiskCacheConfig;", "", "maxCacheSize", "", "maxCacheSizeOnLowDiskSpace", "maxCacheSizeOnVeryLowDiskSpace", "maxImCacheSize", "maxImCacheSizeOnLowDiskSpace", "maxImCacheSizeOnVeryLowDiskSpace", "<init>", "(IIIIII)V", "getMaxCacheSize", "()I", "getMaxCacheSizeOnLowDiskSpace", "getMaxCacheSizeOnVeryLowDiskSpace", "getMaxImCacheSize", "getMaxImCacheSizeOnLowDiskSpace", "getMaxImCacheSizeOnVeryLowDiskSpace", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("max_cache_size_mb")
    private final int maxCacheSize;

    @SerializedName("max_cache_size_on_low_disk_space_mb")
    private final int maxCacheSizeOnLowDiskSpace;

    @SerializedName("max_cache_size_on_very_low_disk_space_mb")
    private final int maxCacheSizeOnVeryLowDiskSpace;

    @SerializedName("max_im_cache_size_mb")
    private final int maxImCacheSize;

    @SerializedName("max_im_cache_size_on_low_disk_space_mb")
    private final int maxImCacheSizeOnLowDiskSpace;

    @SerializedName("max_im_cache_size_on_very_low_disk_space_mb")
    private final int maxImCacheSizeOnVeryLowDiskSpace;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.maxCacheSize == r101.maxCacheSize) goto L12;
        return false;
    L12:
        if (this.maxCacheSizeOnLowDiskSpace == r101.maxCacheSizeOnLowDiskSpace) goto L15;
        return false;
    L15:
        if (this.maxCacheSizeOnVeryLowDiskSpace == r101.maxCacheSizeOnVeryLowDiskSpace) goto L18;
        return false;
    L18:
        if (this.maxImCacheSize == r101.maxImCacheSize) goto L21;
        return false;
    L21:
        if (this.maxImCacheSizeOnLowDiskSpace == r101.maxImCacheSizeOnLowDiskSpace) goto L24;
        return false;
    L24:
        if (this.maxImCacheSizeOnVeryLowDiskSpace == r101.maxImCacheSizeOnVeryLowDiskSpace) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.maxCacheSize * 31) + this.maxCacheSizeOnLowDiskSpace) * 31) + this.maxCacheSizeOnVeryLowDiskSpace) * 31) + this.maxImCacheSize) * 31) + this.maxImCacheSizeOnLowDiskSpace) * 31) + this.maxImCacheSizeOnVeryLowDiskSpace;
    }

    public final String toString() {
        return "DiskCacheConfig(maxCacheSize=" + this.maxCacheSize + ", maxCacheSizeOnLowDiskSpace=" + this.maxCacheSizeOnLowDiskSpace + ", maxCacheSizeOnVeryLowDiskSpace=" + this.maxCacheSizeOnVeryLowDiskSpace + ", maxImCacheSize=" + this.maxImCacheSize + ", maxImCacheSizeOnLowDiskSpace=" + this.maxImCacheSizeOnLowDiskSpace + ", maxImCacheSizeOnVeryLowDiskSpace=" + this.maxImCacheSizeOnVeryLowDiskSpace + ')';
    }

    public e() {
        this.maxCacheSize = 250;
        this.maxCacheSizeOnLowDiskSpace = 80;
        this.maxCacheSizeOnVeryLowDiskSpace = 16;
        this.maxImCacheSize = 10;
        this.maxImCacheSizeOnLowDiskSpace = 5;
        this.maxImCacheSizeOnVeryLowDiskSpace = 1;
    }

    public final int a() {
        return this.maxCacheSize;
    }

    public final int b() {
        return this.maxCacheSizeOnLowDiskSpace;
    }

    public final int c() {
        return this.maxCacheSizeOnVeryLowDiskSpace;
    }

    public final int d() {
        return this.maxImCacheSize;
    }

    public final int e() {
        return this.maxImCacheSizeOnLowDiskSpace;
    }

    public final int f() {
        return this.maxImCacheSizeOnVeryLowDiskSpace;
    }
}
