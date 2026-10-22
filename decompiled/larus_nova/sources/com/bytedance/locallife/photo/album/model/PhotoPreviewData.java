package com.bytedance.locallife.photo.album.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/PhotoPreviewData;", "", "photos", "", "Lcom/bytedance/locallife/photo/album/model/PoiPreviewPhotoModel;", "headerContainer", "Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;", "bottomContainer", "(Ljava/util/List;Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;)V", "getBottomContainer", "()Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;", "getHeaderContainer", "getPhotos", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PhotoPreviewData {

    @SerializedName("bottom_container")
    private final PoiPhotoPreviewLynxData bottomContainer;

    @SerializedName("header_container")
    private final PoiPhotoPreviewLynxData headerContainer;
    private final List<PoiPreviewPhotoModel> photos;

    public PhotoPreviewData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PhotoPreviewData copy$default(PhotoPreviewData r100, List r101, PoiPhotoPreviewLynxData r102, PoiPhotoPreviewLynxData r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.photos;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.headerContainer;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.bottomContainer;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<PoiPreviewPhotoModel> component1() {
        return this.photos;
    }

    public final PoiPhotoPreviewLynxData component2() {
        return this.headerContainer;
    }

    public final PoiPhotoPreviewLynxData component3() {
        return this.bottomContainer;
    }

    public final PhotoPreviewData copy(List<PoiPreviewPhotoModel> r100, PoiPhotoPreviewLynxData r101, PoiPhotoPreviewLynxData r102) {
        Intrinsics.checkNotNullParameter(r100, "photos");
        return new PhotoPreviewData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoPreviewData) == true) goto L8;
        return false;
    L8:
        PhotoPreviewData r101 = (PhotoPreviewData) r100;
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headerContainer, r101.headerContainer) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottomContainer, r101.bottomContainer) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.photos.hashCode() * 31;
        PoiPhotoPreviewLynxData r101 = this.headerContainer;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        PoiPhotoPreviewLynxData r105 = this.bottomContainer;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoPreviewData(photos=" + this.photos + ", headerContainer=" + this.headerContainer + ", bottomContainer=" + this.bottomContainer + ')';
    }

    public final PoiPhotoPreviewLynxData getBottomContainer() {
        return this.bottomContainer;
    }

    public final PoiPhotoPreviewLynxData getHeaderContainer() {
        return this.headerContainer;
    }

    public final List<PoiPreviewPhotoModel> getPhotos() {
        return this.photos;
    }

    public PhotoPreviewData(List<PoiPreviewPhotoModel> r100, PoiPhotoPreviewLynxData r101, PoiPhotoPreviewLynxData r102) {
        Intrinsics.checkNotNullParameter(r100, "photos");
        this.photos = r100;
        this.headerContainer = r101;
        this.bottomContainer = r102;
    }

    public /* synthetic */ PhotoPreviewData(List r100, PoiPhotoPreviewLynxData r101, PoiPhotoPreviewLynxData r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
