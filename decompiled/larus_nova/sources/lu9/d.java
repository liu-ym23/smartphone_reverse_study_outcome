package lu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\nHÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u00063"}, d2 = {"Lcom/larus/settings/provider/disk/AppDiskScanConfig;", "", "enableScanDisk", "", "enableFullScanDiskFile", "scanDiskRadio", "", "diskScanInterval", "", "collectMaxDepth", "", "scanFileUploadTotalThreshold", "scanFileUploadThreshold", "scanFileUploadMaxCount", "enableScanLargeFile", "largeFileSizeThreshold", "largeFileUploadCount", "<init>", "(ZZFJIJJIZJI)V", "getEnableScanDisk", "()Z", "getEnableFullScanDiskFile", "getScanDiskRadio", "()F", "getDiskScanInterval", "()J", "getCollectMaxDepth", "()I", "getScanFileUploadTotalThreshold", "getScanFileUploadThreshold", "getScanFileUploadMaxCount", "getEnableScanLargeFile", "getLargeFileSizeThreshold", "getLargeFileUploadCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("collect_max_depth")
    private final int collectMaxDepth;

    @SerializedName("disk_scan_interval")
    private final long diskScanInterval;

    @SerializedName("enable_full_scan_disk_file")
    private final boolean enableFullScanDiskFile;

    @SerializedName("enable_scan_disk")
    private final boolean enableScanDisk;

    @SerializedName("enable_scan_large_file")
    private final boolean enableScanLargeFile;

    @SerializedName("large_file_size_threshold")
    private final long largeFileSizeThreshold;

    @SerializedName("large_file_upload_count")
    private final int largeFileUploadCount;

    @SerializedName("scan_disk_radio")
    private final float scanDiskRadio;

    @SerializedName("scan_file_upload_max_count")
    private final int scanFileUploadMaxCount;

    @SerializedName("scan_file_upload_threshold")
    private final long scanFileUploadThreshold;

    @SerializedName("scan_file_upload_total_threshold")
    private final long scanFileUploadTotalThreshold;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.enableScanDisk == r101.enableScanDisk) goto L12;
        return false;
    L12:
        if (this.enableFullScanDiskFile == r101.enableFullScanDiskFile) goto L15;
        return false;
    L15:
        if (Float.compare(this.scanDiskRadio, r101.scanDiskRadio) == 0) goto L18;
        return false;
    L18:
        if (this.diskScanInterval == r101.diskScanInterval) goto L21;
        return false;
    L21:
        if (this.collectMaxDepth == r101.collectMaxDepth) goto L24;
        return false;
    L24:
        if (this.scanFileUploadTotalThreshold == r101.scanFileUploadTotalThreshold) goto L27;
        return false;
    L27:
        if (this.scanFileUploadThreshold == r101.scanFileUploadThreshold) goto L30;
        return false;
    L30:
        if (this.scanFileUploadMaxCount == r101.scanFileUploadMaxCount) goto L33;
        return false;
    L33:
        if (this.enableScanLargeFile == r101.enableScanLargeFile) goto L36;
        return false;
    L36:
        if (this.largeFileSizeThreshold == r101.largeFileSizeThreshold) goto L39;
        return false;
    L39:
        if (this.largeFileUploadCount == r101.largeFileUploadCount) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableScanDisk == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableFullScanDiskFile == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + Float.floatToIntBits(this.scanDiskRadio)) * 31;
        long r105 = this.diskScanInterval;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.collectMaxDepth) * 31;
        long r107 = this.scanFileUploadTotalThreshold;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.scanFileUploadThreshold;
        int r110 = (((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.scanFileUploadMaxCount) * 31;
        if (this.enableScanLargeFile == true) goto L14;
        r100 = 1237;
    L14:
        int r111 = (r110 + r100) * 31;
        long r112 = this.largeFileSizeThreshold;
        return ((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.largeFileUploadCount;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppDiskScanConfig(enableScanDisk=" + this.enableScanDisk + ", enableFullScanDiskFile=" + this.enableFullScanDiskFile + ", scanDiskRadio=" + this.scanDiskRadio + ", diskScanInterval=" + this.diskScanInterval + ", collectMaxDepth=" + this.collectMaxDepth + ", scanFileUploadTotalThreshold=" + this.scanFileUploadTotalThreshold + ", scanFileUploadThreshold=" + this.scanFileUploadThreshold + ", scanFileUploadMaxCount=" + this.scanFileUploadMaxCount + ", enableScanLargeFile=" + this.enableScanLargeFile + ", largeFileSizeThreshold=" + this.largeFileSizeThreshold + ", largeFileUploadCount=" + this.largeFileUploadCount + ')';
    }

    public final int a() {
        return this.collectMaxDepth;
    }

    public final long b() {
        return this.diskScanInterval;
    }

    public final boolean c() {
        return this.enableFullScanDiskFile;
    }

    public final boolean d() {
        return this.enableScanDisk;
    }

    public final boolean e() {
        return this.enableScanLargeFile;
    }

    public final long f() {
        return this.largeFileSizeThreshold;
    }

    public final int g() {
        return this.largeFileUploadCount;
    }

    public final float h() {
        return this.scanDiskRadio;
    }

    public final int i() {
        return this.scanFileUploadMaxCount;
    }

    public final long j() {
        return this.scanFileUploadThreshold;
    }

    public final long k() {
        return this.scanFileUploadTotalThreshold;
    }

    public d(int r100) {
        this.enableScanDisk = true;
        this.enableFullScanDiskFile = true;
        this.scanDiskRadio = 1.0f;
        this.diskScanInterval = 86400000;
        this.collectMaxDepth = 2;
        this.scanFileUploadTotalThreshold = 50;
        this.scanFileUploadThreshold = 5;
        this.scanFileUploadMaxCount = 20;
        this.enableScanLargeFile = true;
        this.largeFileSizeThreshold = 10;
        this.largeFileUploadCount = 5;
    }
}
