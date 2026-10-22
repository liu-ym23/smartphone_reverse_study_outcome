package fy6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lfy6/a;", "", "", "poiName", "Ljava/lang/String;", "getPoiName", "()Ljava/lang/String;", "", "naviFirst", "Ljava/lang/Integer;", "getNaviFirst", "()Ljava/lang/Integer;", "naviInfo", "getNaviInfo", "showNavi", "getShowNavi", "", "poiLatitude", "Ljava/lang/Double;", "getPoiLatitude", "()Ljava/lang/Double;", "poiLongitude", "getPoiLongitude", "poiLatitudeGcj", "getPoiLatitudeGcj", "poiLongitudeGcj", "getPoiLongitudeGcj", "Lfy6/d;", "poiAddress", "Lfy6/d;", "getPoiAddress", "()Lfy6/d;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("navi_first")
    private final Integer naviFirst;

    @SerializedName("navi_info")
    private final String naviInfo;

    @SerializedName("poi_address")
    private final d poiAddress;

    @SerializedName("poi_latitude")
    private final Double poiLatitude;

    @SerializedName("poi_latitude_gcj02")
    private final Double poiLatitudeGcj;

    @SerializedName("poi_longitude")
    private final Double poiLongitude;

    @SerializedName("poi_longitude_gcj02")
    private final Double poiLongitudeGcj;

    @SerializedName("poi_name")
    private final String poiName;

    @SerializedName("show_navi")
    private final String showNavi;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.poiName, r101.poiName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.naviFirst, r101.naviFirst) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.naviInfo, r101.naviInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showNavi, r101.showNavi) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiLatitude, r101.poiLatitude) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.poiLongitude, r101.poiLongitude) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.poiLatitudeGcj, r101.poiLatitudeGcj) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.poiLongitudeGcj, r101.poiLongitudeGcj) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.poiAddress, r101.poiAddress) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.poiName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.naviFirst;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.naviInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.showNavi;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.poiLatitude;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.poiLongitude;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.poiLatitudeGcj;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Double r122 = this.poiLongitudeGcj;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        d r125 = this.poiAddress;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "AddressIntro(poiName=" + this.poiName + ", naviFirst=" + this.naviFirst + ", naviInfo=" + this.naviInfo + ", showNavi=" + this.showNavi + ", poiLatitude=" + this.poiLatitude + ", poiLongitude=" + this.poiLongitude + ", poiLatitudeGcj=" + this.poiLatitudeGcj + ", poiLongitudeGcj=" + this.poiLongitudeGcj + ", poiAddress=" + this.poiAddress + ')';
    }

    public a() {
        this.poiName = null;
        this.naviFirst = null;
        this.naviInfo = null;
        this.showNavi = null;
        this.poiLatitude = null;
        this.poiLongitude = null;
        this.poiLatitudeGcj = null;
        this.poiLongitudeGcj = null;
        this.poiAddress = null;
    }
}
