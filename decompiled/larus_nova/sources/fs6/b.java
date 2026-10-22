package fs6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lfs6/b;", "", "", "cityName", "Ljava/lang/String;", "getCityName", "()Ljava/lang/String;", "cityCode", "getCityCode", "", "isCurLocationCity", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("code")
    private final String cityCode;

    @SerializedName("name")
    private final String cityName;

    @SerializedName("isCurLocationCity")
    private final Boolean isCurLocationCity;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.cityName, r101.cityName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cityCode, r101.cityCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isCurLocationCity, r101.isCurLocationCity) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.cityName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.cityCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isCurLocationCity;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiCityInfo(cityName=" + this.cityName + ", cityCode=" + this.cityCode + ", isCurLocationCity=" + this.isCurLocationCity + ')';
    }

    public b() {
        this.cityName = null;
        this.cityCode = null;
        this.isCurLocationCity = null;
    }
}
