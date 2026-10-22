package oq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/camera/AttachmentAlbumDetectConfig;", "", "enableDetect", "", "detectTimeoutMs", "", "resizeShortSide", "", "imageCompressQuality", "", "<init>", "(ZJFI)V", "getEnableDetect", "()Z", "getDetectTimeoutMs", "()J", "getResizeShortSide", "()F", "getImageCompressQuality", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("detect_timeout_ms")
    private final long detectTimeoutMs;

    @SerializedName("enable_detect")
    private final boolean enableDetect;

    @SerializedName("image_compress_quality")
    private final int imageCompressQuality;

    @SerializedName("resize_short_side")
    private final float resizeShortSide;

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
        if (this.enableDetect == r101.enableDetect) goto L12;
        return false;
    L12:
        if (this.detectTimeoutMs == r101.detectTimeoutMs) goto L15;
        return false;
    L15:
        if (Float.compare(this.resizeShortSide, r101.resizeShortSide) == 0) goto L18;
        return false;
    L18:
        if (this.imageCompressQuality == r101.imageCompressQuality) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.enableDetect == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.detectTimeoutMs;
        return (((((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Float.floatToIntBits(this.resizeShortSide)) * 31) + this.imageCompressQuality;
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AttachmentAlbumDetectConfig(enableDetect=" + this.enableDetect + ", detectTimeoutMs=" + this.detectTimeoutMs + ", resizeShortSide=" + this.resizeShortSide + ", imageCompressQuality=" + this.imageCompressQuality + ')';
    }

    public final long a() {
        return this.detectTimeoutMs;
    }

    public final boolean b() {
        return this.enableDetect;
    }

    public final int c() {
        return this.imageCompressQuality;
    }

    public final float d() {
        return this.resizeShortSide;
    }

    public c(int r100) {
        this.enableDetect = false;
        this.detectTimeoutMs = 1800;
        this.resizeShortSide = 720.0f;
        this.imageCompressQuality = 70;
    }
}
