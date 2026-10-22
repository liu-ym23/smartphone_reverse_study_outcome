package com.bytedance.locallife.photo.album.model;

import com.bytedance.locallife.host.model.UrlModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JM\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/PoiPreviewPhotoModel;", "", "url", "Lcom/bytedance/locallife/host/model/UrlModel;", "meidaType", "", "headerContainerUpdate", "Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;", "bottomContainerUpdate", "trakerData", "Lcom/google/gson/JsonObject;", "hasMob", "", "(Lcom/bytedance/locallife/host/model/UrlModel;ILcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;Lcom/google/gson/JsonObject;Z)V", "getBottomContainerUpdate", "()Lcom/bytedance/locallife/photo/album/model/PoiPhotoPreviewLynxData;", "getHasMob", "()Z", "setHasMob", "(Z)V", "getHeaderContainerUpdate", "getMeidaType", "()I", "getTrakerData", "()Lcom/google/gson/JsonObject;", "getUrl", "()Lcom/bytedance/locallife/host/model/UrlModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiPreviewPhotoModel {

    @SerializedName("bottom_container_update")
    private final PoiPhotoPreviewLynxData bottomContainerUpdate;
    private boolean hasMob;

    @SerializedName("header_container_update")
    private final PoiPhotoPreviewLynxData headerContainerUpdate;

    @SerializedName("meida_type")
    private final int meidaType;

    @SerializedName("traker_data")
    private final JsonObject trakerData;
    private final UrlModel url;

    public PoiPreviewPhotoModel() {
        this(null, 0, null, null, null, false, 63, null);
    }

    public static /* synthetic */ PoiPreviewPhotoModel copy$default(PoiPreviewPhotoModel r100, UrlModel r101, int r102, PoiPhotoPreviewLynxData r103, PoiPhotoPreviewLynxData r104, JsonObject r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.meidaType;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.headerContainerUpdate;
    L11:
        PoiPhotoPreviewLynxData r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.bottomContainerUpdate;
    L14:
        PoiPhotoPreviewLynxData r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.trakerData;
    L17:
        JsonObject r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.hasMob;
    L20:
        UrlModel r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final UrlModel component1() {
        return this.url;
    }

    public final int component2() {
        return this.meidaType;
    }

    public final PoiPhotoPreviewLynxData component3() {
        return this.headerContainerUpdate;
    }

    public final PoiPhotoPreviewLynxData component4() {
        return this.bottomContainerUpdate;
    }

    public final JsonObject component5() {
        return this.trakerData;
    }

    public final boolean component6() {
        return this.hasMob;
    }

    public final PoiPreviewPhotoModel copy(UrlModel r100, int r110, PoiPhotoPreviewLynxData r111, PoiPhotoPreviewLynxData r112, JsonObject r113, boolean r114) {
        return new PoiPreviewPhotoModel(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiPreviewPhotoModel) == true) goto L8;
        return false;
    L8:
        PoiPreviewPhotoModel r101 = (PoiPreviewPhotoModel) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.meidaType == r101.meidaType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headerContainerUpdate, r101.headerContainerUpdate) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomContainerUpdate, r101.bottomContainerUpdate) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.trakerData, r101.trakerData) == true) goto L24;
        return false;
    L24:
        if (this.hasMob == r101.hasMob) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        UrlModel r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.meidaType) * 31;
        PoiPhotoPreviewLynxData r104 = this.headerContainerUpdate;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PoiPhotoPreviewLynxData r107 = this.bottomContainerUpdate;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JsonObject r110 = this.trakerData;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.hasMob == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
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

    public String toString() {
        return "PoiPreviewPhotoModel(url=" + this.url + ", meidaType=" + this.meidaType + ", headerContainerUpdate=" + this.headerContainerUpdate + ", bottomContainerUpdate=" + this.bottomContainerUpdate + ", trakerData=" + this.trakerData + ", hasMob=" + this.hasMob + ')';
    }

    public final PoiPhotoPreviewLynxData getBottomContainerUpdate() {
        return this.bottomContainerUpdate;
    }

    public final boolean getHasMob() {
        return this.hasMob;
    }

    public final PoiPhotoPreviewLynxData getHeaderContainerUpdate() {
        return this.headerContainerUpdate;
    }

    public final int getMeidaType() {
        return this.meidaType;
    }

    public final JsonObject getTrakerData() {
        return this.trakerData;
    }

    public final UrlModel getUrl() {
        return this.url;
    }

    public final void setHasMob(boolean r100) {
        this.hasMob = r100;
    }

    public PoiPreviewPhotoModel(UrlModel r100, int r101, PoiPhotoPreviewLynxData r102, PoiPhotoPreviewLynxData r103, JsonObject r104, boolean r105) {
        this.url = r100;
        this.meidaType = r101;
        this.headerContainerUpdate = r102;
        this.bottomContainerUpdate = r103;
        this.trakerData = r104;
        this.hasMob = r105;
    }

    public /* synthetic */ PoiPreviewPhotoModel(UrlModel r100, int r101, PoiPhotoPreviewLynxData r102, PoiPhotoPreviewLynxData r103, JsonObject r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        JsonObject r104 = null;
        if ((r112 & 1) == 0) goto L5;
        UrlModel r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        PoiPhotoPreviewLynxData r106 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        PoiPhotoPreviewLynxData r107 = null;
    L19:
        if ((r112 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r115 = false;
    L26:
        this(r114, r105, r106, r107, r104, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
