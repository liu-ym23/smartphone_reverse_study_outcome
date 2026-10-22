package com.larus.bmhome.auth;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/auth/BasicAttachLaunchInfo;", "", "attachFile", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "attachImgAlbum", "attachImgCamera", "attachSug", "attachmentArea", "previewImgCamera", "previewSug", "<init>", "(Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)V", "getAttachFile", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "getAttachImgAlbum", "getAttachImgCamera", "getAttachSug", "getAttachmentArea", "getPreviewImgCamera", "getPreviewSug", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d0 {

    @SerializedName("attach_file")
    private final FeatureDetail attachFile;

    @SerializedName("attach_img_album")
    private final FeatureDetail attachImgAlbum;

    @SerializedName("attach_img_camera")
    private final FeatureDetail attachImgCamera;

    @SerializedName("attach_sug")
    private final FeatureDetail attachSug;

    @SerializedName("attachment_area")
    private final FeatureDetail attachmentArea;

    @SerializedName("preview_img_camera")
    private final FeatureDetail previewImgCamera;

    @SerializedName("preview_sug")
    private final FeatureDetail previewSug;

    public d0() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.attachFile, r101.attachFile) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachImgAlbum, r101.attachImgAlbum) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.attachImgCamera, r101.attachImgCamera) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.attachSug, r101.attachSug) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attachmentArea, r101.attachmentArea) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.previewImgCamera, r101.previewImgCamera) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.previewSug, r101.previewSug) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        FeatureDetail r100 = this.attachFile;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FeatureDetail r104 = this.attachImgAlbum;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        FeatureDetail r107 = this.attachImgCamera;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FeatureDetail r110 = this.attachSug;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        FeatureDetail r113 = this.attachmentArea;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        FeatureDetail r116 = this.previewImgCamera;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        FeatureDetail r119 = this.previewSug;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BasicAttachLaunchInfo(attachFile=" + this.attachFile + ", attachImgAlbum=" + this.attachImgAlbum + ", attachImgCamera=" + this.attachImgCamera + ", attachSug=" + this.attachSug + ", attachmentArea=" + this.attachmentArea + ", previewImgCamera=" + this.previewImgCamera + ", previewSug=" + this.previewSug + ')';
    }

    public final FeatureDetail a() {
        return this.attachFile;
    }

    public final FeatureDetail b() {
        return this.attachImgAlbum;
    }

    public final FeatureDetail c() {
        return this.attachImgCamera;
    }

    public final FeatureDetail d() {
        return this.attachSug;
    }

    public final FeatureDetail e() {
        return this.attachmentArea;
    }

    public final FeatureDetail f() {
        return this.previewImgCamera;
    }

    public final FeatureDetail g() {
        return this.previewSug;
    }

    public d0(FeatureDetail r100, FeatureDetail r101, FeatureDetail r102, FeatureDetail r103, FeatureDetail r104, FeatureDetail r105, FeatureDetail r106) {
        this.attachFile = r100;
        this.attachImgAlbum = r101;
        this.attachImgCamera = r102;
        this.attachSug = r103;
        this.attachmentArea = r104;
        this.previewImgCamera = r105;
        this.previewSug = r106;
    }
}
