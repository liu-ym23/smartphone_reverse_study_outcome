package com.ss.android.ugc.aweme.poi.coi;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/CoiCellTypeInfo;", "Ljava/io/Serializable;", "type", "", "textContent", "styleType", "iconUrl", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "getIconUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getStyleType", "()Ljava/lang/String;", "getTextContent", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CoiCellTypeInfo implements Serializable {

    @SerializedName("icon_url")
    private final PoiImageUrlModel iconUrl;

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private final String styleType;

    @SerializedName("content")
    private final String textContent;

    @SerializedName("type")
    private final String type;

    public CoiCellTypeInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CoiCellTypeInfo copy$default(CoiCellTypeInfo r100, String r101, String r102, String r103, PoiImageUrlModel r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.textContent;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.styleType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.iconUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.textContent;
    }

    public final String component3() {
        return this.styleType;
    }

    public final PoiImageUrlModel component4() {
        return this.iconUrl;
    }

    public final CoiCellTypeInfo copy(String r100, String r101, String r102, PoiImageUrlModel r103) {
        return new CoiCellTypeInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoiCellTypeInfo) == true) goto L8;
        return false;
    L8:
        CoiCellTypeInfo r101 = (CoiCellTypeInfo) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textContent, r101.textContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.styleType, r101.styleType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.textContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.styleType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        PoiImageUrlModel r110 = this.iconUrl;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "CoiCellTypeInfo(type=" + this.type + ", textContent=" + this.textContent + ", styleType=" + this.styleType + ", iconUrl=" + this.iconUrl + ')';
    }

    public final PoiImageUrlModel getIconUrl() {
        return this.iconUrl;
    }

    public final String getStyleType() {
        return this.styleType;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final String getType() {
        return this.type;
    }

    public CoiCellTypeInfo(String r100, String r101, String r102, PoiImageUrlModel r103) {
        this.type = r100;
        this.textContent = r101;
        this.styleType = r102;
        this.iconUrl = r103;
    }

    public /* synthetic */ CoiCellTypeInfo(String r100, String r101, String r102, PoiImageUrlModel r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
