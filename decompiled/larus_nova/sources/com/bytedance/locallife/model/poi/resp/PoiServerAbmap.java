package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006."}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiServerAbmap;", "Ljava/io/Serializable;", "poiDetailHeadOptV2", "", "headerPhotoStyle", "noMargin", "smallImage", "uiEfficientOpt", "showPillArrow", "jumpAlbumPageMode", "nameOpt", "(IIIIIIII)V", "getHeaderPhotoStyle", "()I", "setHeaderPhotoStyle", "(I)V", "getJumpAlbumPageMode", "setJumpAlbumPageMode", "getNameOpt", "setNameOpt", "getNoMargin", "setNoMargin", "getPoiDetailHeadOptV2", "setPoiDetailHeadOptV2", "getShowPillArrow", "setShowPillArrow", "getSmallImage", "setSmallImage", "getUiEfficientOpt", "setUiEfficientOpt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiServerAbmap implements Serializable {

    @SerializedName("header_photo_style")
    private int headerPhotoStyle;

    @SerializedName("jump_album_middle_page_mode")
    private int jumpAlbumPageMode;

    @SerializedName("name_opt")
    private int nameOpt;

    @SerializedName("poi_detail_no_margin")
    private int noMargin;

    @SerializedName("poi_detail_head_opt_v2")
    private int poiDetailHeadOptV2;

    @SerializedName("show_album_middle_page_arrow")
    private int showPillArrow;

    @SerializedName("small_image")
    private int smallImage;

    @SerializedName("ui_efficient_opt")
    private int uiEfficientOpt;

    public PoiServerAbmap() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public static /* synthetic */ PoiServerAbmap copy$default(PoiServerAbmap r100, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.poiDetailHeadOptV2;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.headerPhotoStyle;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.noMargin;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.smallImage;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.uiEfficientOpt;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.showPillArrow;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.jumpAlbumPageMode;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.nameOpt;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
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
        r101 = r110;
        goto L7
    }

    public final int component1() {
        return this.poiDetailHeadOptV2;
    }

    public final int component2() {
        return this.headerPhotoStyle;
    }

    public final int component3() {
        return this.noMargin;
    }

    public final int component4() {
        return this.smallImage;
    }

    public final int component5() {
        return this.uiEfficientOpt;
    }

    public final int component6() {
        return this.showPillArrow;
    }

    public final int component7() {
        return this.jumpAlbumPageMode;
    }

    public final int component8() {
        return this.nameOpt;
    }

    public final PoiServerAbmap copy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117) {
        return new PoiServerAbmap(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiServerAbmap) == true) goto L8;
        return false;
    L8:
        PoiServerAbmap r101 = (PoiServerAbmap) r100;
        if (this.poiDetailHeadOptV2 == r101.poiDetailHeadOptV2) goto L12;
        return false;
    L12:
        if (this.headerPhotoStyle == r101.headerPhotoStyle) goto L15;
        return false;
    L15:
        if (this.noMargin == r101.noMargin) goto L18;
        return false;
    L18:
        if (this.smallImage == r101.smallImage) goto L21;
        return false;
    L21:
        if (this.uiEfficientOpt == r101.uiEfficientOpt) goto L24;
        return false;
    L24:
        if (this.showPillArrow == r101.showPillArrow) goto L27;
        return false;
    L27:
        if (this.jumpAlbumPageMode == r101.jumpAlbumPageMode) goto L30;
        return false;
    L30:
        if (this.nameOpt == r101.nameOpt) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.poiDetailHeadOptV2 * 31) + this.headerPhotoStyle) * 31) + this.noMargin) * 31) + this.smallImage) * 31) + this.uiEfficientOpt) * 31) + this.showPillArrow) * 31) + this.jumpAlbumPageMode) * 31) + this.nameOpt;
    }

    public String toString() {
        return "PoiServerAbmap(poiDetailHeadOptV2=" + this.poiDetailHeadOptV2 + ", headerPhotoStyle=" + this.headerPhotoStyle + ", noMargin=" + this.noMargin + ", smallImage=" + this.smallImage + ", uiEfficientOpt=" + this.uiEfficientOpt + ", showPillArrow=" + this.showPillArrow + ", jumpAlbumPageMode=" + this.jumpAlbumPageMode + ", nameOpt=" + this.nameOpt + ')';
    }

    public final int getHeaderPhotoStyle() {
        return this.headerPhotoStyle;
    }

    public final int getJumpAlbumPageMode() {
        return this.jumpAlbumPageMode;
    }

    public final int getNameOpt() {
        return this.nameOpt;
    }

    public final int getNoMargin() {
        return this.noMargin;
    }

    public final int getPoiDetailHeadOptV2() {
        return this.poiDetailHeadOptV2;
    }

    public final int getShowPillArrow() {
        return this.showPillArrow;
    }

    public final int getSmallImage() {
        return this.smallImage;
    }

    public final int getUiEfficientOpt() {
        return this.uiEfficientOpt;
    }

    public final void setHeaderPhotoStyle(int r100) {
        this.headerPhotoStyle = r100;
    }

    public final void setJumpAlbumPageMode(int r100) {
        this.jumpAlbumPageMode = r100;
    }

    public final void setNameOpt(int r100) {
        this.nameOpt = r100;
    }

    public final void setNoMargin(int r100) {
        this.noMargin = r100;
    }

    public final void setPoiDetailHeadOptV2(int r100) {
        this.poiDetailHeadOptV2 = r100;
    }

    public final void setShowPillArrow(int r100) {
        this.showPillArrow = r100;
    }

    public final void setSmallImage(int r100) {
        this.smallImage = r100;
    }

    public final void setUiEfficientOpt(int r100) {
        this.uiEfficientOpt = r100;
    }

    public PoiServerAbmap(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.poiDetailHeadOptV2 = r100;
        this.headerPhotoStyle = r101;
        this.noMargin = r102;
        this.smallImage = r103;
        this.uiEfficientOpt = r104;
        this.showPillArrow = r105;
        this.jumpAlbumPageMode = r106;
        this.nameOpt = r107;
    }

    public /* synthetic */ PoiServerAbmap(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, DefaultConstructorMarker r119) {
        int r100 = 0;
        if ((r118 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
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
        r101 = r110;
        goto L7
    }
}
