package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003Je\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006,"}, d2 = {"Lcom/larus/platform/model/camera/ImageUploadProfile;", "", "scene", "", "maxShortSize", "", "maxBytes", "", "minQuality", "maxQuality", "enablePreUpload", "", "enableWeakNetworkCompress", "weakNetworkQualityLevel", "weakNetworkCompressQuality", "<init>", "(Ljava/lang/String;IJIIZZII)V", "getScene", "()Ljava/lang/String;", "getMaxShortSize", "()I", "getMaxBytes", "()J", "getMinQuality", "getMaxQuality", "getEnablePreUpload", "()Z", "getEnableWeakNetworkCompress", "getWeakNetworkQualityLevel", "getWeakNetworkCompressQuality", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadProfile {

    @SerializedName("enable_pre_upload")
    private final boolean enablePreUpload;

    @SerializedName("enable_weak_network_compress")
    private final boolean enableWeakNetworkCompress;

    @SerializedName("max_long_size")
    private final long maxBytes;

    @SerializedName("max_quality")
    private final int maxQuality;

    @SerializedName("max_short_size")
    private final int maxShortSize;

    @SerializedName("min_quality")
    private final int minQuality;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("weak_network_quality")
    private final int weakNetworkCompressQuality;

    @SerializedName("weak_network_quality_level")
    private final int weakNetworkQualityLevel;

    public ImageUploadProfile() {
        this(null, 0, 0, 0, 0, false, false, 0, 0, 511, null);
    }

    public static /* synthetic */ ImageUploadProfile copy$default(ImageUploadProfile r110, String r111, int r112, long r113, int r114, int r115, boolean r116, boolean r117, int r210, int r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.scene;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.maxShortSize;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.maxBytes;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.minQuality;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.maxQuality;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.enablePreUpload;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.enableWeakNetworkCompress;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r118 = r110.weakNetworkQualityLevel;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r107 = r110.weakNetworkCompressQuality;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.scene;
    }

    public final int component2() {
        return this.maxShortSize;
    }

    public final long component3() {
        return this.maxBytes;
    }

    public final int component4() {
        return this.minQuality;
    }

    public final int component5() {
        return this.maxQuality;
    }

    public final boolean component6() {
        return this.enablePreUpload;
    }

    public final boolean component7() {
        return this.enableWeakNetworkCompress;
    }

    public final int component8() {
        return this.weakNetworkQualityLevel;
    }

    public final int component9() {
        return this.weakNetworkCompressQuality;
    }

    public final ImageUploadProfile copy(String r110, int r111, long r112, int r113, int r114, boolean r115, boolean r210, int r211, int r212) {
        return new ImageUploadProfile(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageUploadProfile) == true) goto L8;
        return false;
    L8:
        ImageUploadProfile r101 = (ImageUploadProfile) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (this.maxShortSize == r101.maxShortSize) goto L15;
        return false;
    L15:
        if (this.maxBytes == r101.maxBytes) goto L18;
        return false;
    L18:
        if (this.minQuality == r101.minQuality) goto L21;
        return false;
    L21:
        if (this.maxQuality == r101.maxQuality) goto L24;
        return false;
    L24:
        if (this.enablePreUpload == r101.enablePreUpload) goto L27;
        return false;
    L27:
        if (this.enableWeakNetworkCompress == r101.enableWeakNetworkCompress) goto L30;
        return false;
    L30:
        if (this.weakNetworkQualityLevel == r101.weakNetworkQualityLevel) goto L33;
        return false;
    L33:
        if (this.weakNetworkCompressQuality == r101.weakNetworkCompressQuality) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.scene;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.maxShortSize) * 31;
        long r103 = this.maxBytes;
        int r104 = (((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.minQuality) * 31) + this.maxQuality) * 31;
        int r105 = 1231;
        if (this.enablePreUpload == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.enableWeakNetworkCompress == true) goto L15;
        r105 = 1237;
    L15:
        return ((((r107 + r105) * 31) + this.weakNetworkQualityLevel) * 31) + this.weakNetworkCompressQuality;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageUploadProfile(scene=" + this.scene + ", maxShortSize=" + this.maxShortSize + ", maxBytes=" + this.maxBytes + ", minQuality=" + this.minQuality + ", maxQuality=" + this.maxQuality + ", enablePreUpload=" + this.enablePreUpload + ", enableWeakNetworkCompress=" + this.enableWeakNetworkCompress + ", weakNetworkQualityLevel=" + this.weakNetworkQualityLevel + ", weakNetworkCompressQuality=" + this.weakNetworkCompressQuality + ')';
    }

    public final boolean getEnablePreUpload() {
        return this.enablePreUpload;
    }

    public final boolean getEnableWeakNetworkCompress() {
        return this.enableWeakNetworkCompress;
    }

    public final long getMaxBytes() {
        return this.maxBytes;
    }

    public final int getMaxQuality() {
        return this.maxQuality;
    }

    public final int getMaxShortSize() {
        return this.maxShortSize;
    }

    public final int getMinQuality() {
        return this.minQuality;
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getWeakNetworkCompressQuality() {
        return this.weakNetworkCompressQuality;
    }

    public final int getWeakNetworkQualityLevel() {
        return this.weakNetworkQualityLevel;
    }

    public ImageUploadProfile(String r100, int r101, long r102, int r103, int r104, boolean r105, boolean r106, int r107, int r110) {
        this.scene = r100;
        this.maxShortSize = r101;
        this.maxBytes = r102;
        this.minQuality = r103;
        this.maxQuality = r104;
        this.enablePreUpload = r105;
        this.enableWeakNetworkCompress = r106;
        this.weakNetworkQualityLevel = r107;
        this.weakNetworkCompressQuality = r110;
    }

    public /* synthetic */ ImageUploadProfile(String r110, int r111, long r112, int r113, int r114, boolean r115, boolean r116, int r117, int r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = null;
    L6:
        boolean r101 = false;
        if ((r211 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        int r104 = 95;
    L19:
        if ((r211 & 16) == 0) goto L21;
        int r105 = 100;
    L23:
        if ((r211 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r211 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r211 & 128) == 0) goto L33;
        int r107 = 3;
    L35:
        if ((r211 & 256) == 0) goto L37;
        int r108 = 50;
    L38:
        this(r100, r102, r103, r104, r105, r106, r101, r107, r108);
        return;
    L37:
        r108 = r210;
        goto L38
    L33:
        r107 = r117;
        goto L35
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
