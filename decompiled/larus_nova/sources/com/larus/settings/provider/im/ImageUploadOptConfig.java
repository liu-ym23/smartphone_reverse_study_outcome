package com.larus.settings.provider.im;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/settings/provider/im/ImageUploadOptConfig;", "", "albumResize", "", "albumQuality", "cameraResize", "cameraQuality", "<init>", "(IIII)V", "getAlbumResize", "()I", "getAlbumQuality", "getCameraResize", "getCameraQuality", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadOptConfig {

    @SerializedName("album_quality")
    private final int albumQuality;

    @SerializedName("album_resize")
    private final int albumResize;

    @SerializedName("camera_quality")
    private final int cameraQuality;

    @SerializedName("camera_resize")
    private final int cameraResize;

    public ImageUploadOptConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ImageUploadOptConfig copy$default(ImageUploadOptConfig r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.albumResize;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.albumQuality;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.cameraResize;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.cameraQuality;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.albumResize;
    }

    public final int component2() {
        return this.albumQuality;
    }

    public final int component3() {
        return this.cameraResize;
    }

    public final int component4() {
        return this.cameraQuality;
    }

    public final ImageUploadOptConfig copy(int r100, int r101, int r102, int r103) {
        return new ImageUploadOptConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageUploadOptConfig) == true) goto L8;
        return false;
    L8:
        ImageUploadOptConfig r101 = (ImageUploadOptConfig) r100;
        if (this.albumResize == r101.albumResize) goto L12;
        return false;
    L12:
        if (this.albumQuality == r101.albumQuality) goto L15;
        return false;
    L15:
        if (this.cameraResize == r101.cameraResize) goto L18;
        return false;
    L18:
        if (this.cameraQuality == r101.cameraQuality) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.albumResize * 31) + this.albumQuality) * 31) + this.cameraResize) * 31) + this.cameraQuality;
    }

    public String toString() {
        return "ImageUploadOptConfig(albumResize=" + this.albumResize + ", albumQuality=" + this.albumQuality + ", cameraResize=" + this.cameraResize + ", cameraQuality=" + this.cameraQuality + ')';
    }

    public final int getAlbumQuality() {
        return this.albumQuality;
    }

    public final int getAlbumResize() {
        return this.albumResize;
    }

    public final int getCameraQuality() {
        return this.cameraQuality;
    }

    public final int getCameraResize() {
        return this.cameraResize;
    }

    public ImageUploadOptConfig(int r100, int r101, int r102, int r103) {
        this.albumResize = r100;
        this.albumQuality = r101;
        this.cameraResize = r102;
        this.cameraQuality = r103;
    }

    public /* synthetic */ ImageUploadOptConfig(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1080;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 95;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 95;
    L14:
        this(r100, r101, r102, r103);
    }
}
