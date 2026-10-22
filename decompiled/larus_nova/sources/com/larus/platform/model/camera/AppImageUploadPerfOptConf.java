package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JY\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/camera/AppImageUploadPerfOptConf;", "", "lowQualityProfiles", "", "Lcom/larus/platform/model/camera/ImageUploadProfile;", "normalQualityProfiles", "highQualityProfiles", "enableCameraOpt", "", "enableAlbumOpt", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZ)V", "getLowQualityProfiles", "()Ljava/util/List;", "getNormalQualityProfiles", "getHighQualityProfiles", "getEnableCameraOpt", "()Z", "getEnableAlbumOpt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppImageUploadPerfOptConf {

    @SerializedName("enable_album_opt")
    private final boolean enableAlbumOpt;

    @SerializedName("enable_camera_opt")
    private final boolean enableCameraOpt;

    @SerializedName("high_profiles")
    private final List<ImageUploadProfile> highQualityProfiles;

    @SerializedName("low_profiles")
    private final List<ImageUploadProfile> lowQualityProfiles;

    @SerializedName("normal_profiles")
    private final List<ImageUploadProfile> normalQualityProfiles;

    public AppImageUploadPerfOptConf() {
        this(null, null, null, false, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppImageUploadPerfOptConf copy$default(AppImageUploadPerfOptConf r100, List r101, List r102, List r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.lowQualityProfiles;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.normalQualityProfiles;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.highQualityProfiles;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.enableCameraOpt;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableAlbumOpt;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<ImageUploadProfile> component1() {
        return this.lowQualityProfiles;
    }

    public final List<ImageUploadProfile> component2() {
        return this.normalQualityProfiles;
    }

    public final List<ImageUploadProfile> component3() {
        return this.highQualityProfiles;
    }

    public final boolean component4() {
        return this.enableCameraOpt;
    }

    public final boolean component5() {
        return this.enableAlbumOpt;
    }

    public final AppImageUploadPerfOptConf copy(List<ImageUploadProfile> r100, List<ImageUploadProfile> r101, List<ImageUploadProfile> r110, boolean r111, boolean r112) {
        return new AppImageUploadPerfOptConf(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppImageUploadPerfOptConf) == true) goto L8;
        return false;
    L8:
        AppImageUploadPerfOptConf r101 = (AppImageUploadPerfOptConf) r100;
        if (Intrinsics.areEqual(this.lowQualityProfiles, r101.lowQualityProfiles) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.normalQualityProfiles, r101.normalQualityProfiles) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.highQualityProfiles, r101.highQualityProfiles) == true) goto L18;
        return false;
    L18:
        if (this.enableCameraOpt == r101.enableCameraOpt) goto L21;
        return false;
    L21:
        if (this.enableAlbumOpt == r101.enableAlbumOpt) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<ImageUploadProfile> r100 = this.lowQualityProfiles;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<ImageUploadProfile> r104 = this.normalQualityProfiles;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<ImageUploadProfile> r107 = this.highQualityProfiles;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        int r109 = 1231;
        if (this.enableCameraOpt == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.enableAlbumOpt == true) goto L23;
        r109 = 1237;
    L23:
        return r111 + r109;
    L17:
        r110 = 1237;
        goto L18
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppImageUploadPerfOptConf(lowQualityProfiles=" + this.lowQualityProfiles + ", normalQualityProfiles=" + this.normalQualityProfiles + ", highQualityProfiles=" + this.highQualityProfiles + ", enableCameraOpt=" + this.enableCameraOpt + ", enableAlbumOpt=" + this.enableAlbumOpt + ')';
    }

    public final boolean getEnableAlbumOpt() {
        return this.enableAlbumOpt;
    }

    public final boolean getEnableCameraOpt() {
        return this.enableCameraOpt;
    }

    public final List<ImageUploadProfile> getHighQualityProfiles() {
        return this.highQualityProfiles;
    }

    public final List<ImageUploadProfile> getLowQualityProfiles() {
        return this.lowQualityProfiles;
    }

    public final List<ImageUploadProfile> getNormalQualityProfiles() {
        return this.normalQualityProfiles;
    }

    public AppImageUploadPerfOptConf(List<ImageUploadProfile> r100, List<ImageUploadProfile> r101, List<ImageUploadProfile> r102, boolean r103, boolean r104) {
        this.lowQualityProfiles = r100;
        this.normalQualityProfiles = r101;
        this.highQualityProfiles = r102;
        this.enableCameraOpt = r103;
        this.enableAlbumOpt = r104;
    }

    public /* synthetic */ AppImageUploadPerfOptConf(List r100, List r101, List r102, boolean r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        List r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        boolean r107 = false;
    L16:
        if ((r105 & 16) == 0) goto L18;
        boolean r108 = false;
    L19:
        this(r100, r111, r106, r107, r108);
        return;
    L18:
        r108 = r104;
        goto L19
    L14:
        r107 = r103;
        goto L16
    }
}
