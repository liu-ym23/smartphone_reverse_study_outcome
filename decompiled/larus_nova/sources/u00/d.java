package u00;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lu00/d;", "", "Lu00/e;", "continent", "Lu00/e;", "getContinent", "()Lu00/e;", DistrictSearchQuery.KEYWORDS_COUNTRY, "getCountry", "", "subdivisions", "Ljava/util/List;", "getSubdivisions", "()Ljava/util/List;", "city", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, DistrictSearchQuery.KEYWORDS_DISTRICT, "getDistrict", "GPS", "getGPS", "town", "getTown", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("GPS")
    private final e GPS;

    @SerializedName("City")
    private final e city;

    @SerializedName("Continent")
    private final e continent;

    @SerializedName("Country")
    private final e country;

    @SerializedName("District")
    private final e district;

    @SerializedName("Subdivisions")
    private final List<e> subdivisions;

    @SerializedName("Town")
    private final e town;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.continent, r101.continent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.country, r101.country) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subdivisions, r101.subdivisions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.city, r101.city) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.district, r101.district) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.GPS, r101.GPS) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.town, r101.town) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        e r100 = this.continent;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.country;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<e> r107 = this.subdivisions;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        e r110 = this.city;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        e r113 = this.district;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        e r116 = this.GPS;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        e r119 = this.town;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveLocation(continent=" + this.continent + ", country=" + this.country + ", subdivisions=" + this.subdivisions + ", city=" + this.city + ", district=" + this.district + ", GPS=" + this.GPS + ", town=" + this.town + ")";
    }

    public d() {
        this.continent = null;
        this.country = null;
        this.subdivisions = null;
        this.city = null;
        this.district = null;
        this.GPS = null;
        this.town = null;
    }

    public final e a() {
        return this.city;
    }
}
