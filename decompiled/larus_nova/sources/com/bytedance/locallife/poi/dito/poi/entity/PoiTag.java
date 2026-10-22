package com.bytedance.locallife.poi.dito.poi.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/entity/PoiTag;", "Ljava/io/Serializable;", "displayText", "", "count", "", "optionType", "poiBackendType", "unSelectedImage", "selectedImage", "tabId", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCount", "()I", "getDisplayText", "()Ljava/lang/String;", "getOptionType", "getPoiBackendType", "getSelectedImage", "getTabId", "getUnSelectedImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiTag implements Serializable {

    @SerializedName("count")
    private final int count;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("option_type")
    private final int optionType;

    @SerializedName("poi_backend_type")
    private final String poiBackendType;

    @SerializedName("selected_image")
    private final String selectedImage;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName("unselected_image")
    private final String unSelectedImage;

    public PoiTag() {
        this(null, 0, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PoiTag copy$default(PoiTag r100, String r101, int r102, int r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.displayText;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.count;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.optionType;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.poiBackendType;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.unSelectedImage;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.selectedImage;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.tabId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.displayText;
    }

    public final int component2() {
        return this.count;
    }

    public final int component3() {
        return this.optionType;
    }

    public final String component4() {
        return this.poiBackendType;
    }

    public final String component5() {
        return this.unSelectedImage;
    }

    public final String component6() {
        return this.selectedImage;
    }

    public final String component7() {
        return this.tabId;
    }

    public final PoiTag copy(String r110, int r111, int r112, String r113, String r114, String r115, String r116) {
        return new PoiTag(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiTag) == true) goto L8;
        return false;
    L8:
        PoiTag r101 = (PoiTag) r100;
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L12;
        return false;
    L12:
        if (this.count == r101.count) goto L15;
        return false;
    L15:
        if (this.optionType == r101.optionType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.poiBackendType, r101.poiBackendType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.unSelectedImage, r101.unSelectedImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectedImage, r101.selectedImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.displayText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.count) * 31) + this.optionType) * 31;
        String r104 = this.poiBackendType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.unSelectedImage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.selectedImage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tabId;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public String toString() {
        return "PoiTag(displayText=" + this.displayText + ", count=" + this.count + ", optionType=" + this.optionType + ", poiBackendType=" + this.poiBackendType + ", unSelectedImage=" + this.unSelectedImage + ", selectedImage=" + this.selectedImage + ", tabId=" + this.tabId + ')';
    }

    public final int getCount() {
        return this.count;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final int getOptionType() {
        return this.optionType;
    }

    public final String getPoiBackendType() {
        return this.poiBackendType;
    }

    public final String getSelectedImage() {
        return this.selectedImage;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getUnSelectedImage() {
        return this.unSelectedImage;
    }

    public PoiTag(String r100, int r101, int r102, String r103, String r104, String r105, String r106) {
        this.displayText = r100;
        this.count = r101;
        this.optionType = r102;
        this.poiBackendType = r103;
        this.unSelectedImage = r104;
        this.selectedImage = r105;
        this.tabId = r106;
    }

    public /* synthetic */ PoiTag(String r100, int r101, int r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r103 = -1;
    L11:
        if ((r114 & 4) == 0) goto L13;
        r102 = PoiTagOptionType.All.getValue();
    L13:
        int r104 = r102;
        if ((r114 & 8) == 0) goto L16;
        String r105 = null;
    L18:
        if ((r114 & 16) == 0) goto L20;
        String r106 = null;
    L22:
        if ((r114 & 32) == 0) goto L24;
        String r107 = null;
    L26:
        if ((r114 & 64) == 0) goto L28;
        String r117 = null;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L24:
        r107 = r112;
        goto L26
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = r110;
        goto L18
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
