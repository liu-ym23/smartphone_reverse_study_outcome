package rv3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/NavigationPageWaypoint;", "", "lat", "", "lon", "name", "", "poiId", "poiIdType", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLat", "()D", "getLon", "getName", "()Ljava/lang/String;", "getPoiId", "getPoiIdType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("lat")
    private final double lat;

    @SerializedName("lon")
    private final double lon;

    @SerializedName("name")
    private final String name;

    @SerializedName("poiId")
    private final String poiId;

    @SerializedName("poiIdType")
    private final String poiIdType;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (Double.compare(this.lat, r9.lat) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.lon, r9.lon) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.poiId, r9.poiId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiIdType, r9.poiIdType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.lat);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.lon);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.name;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.poiId;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.poiIdType;
        if (r11 == null) goto L15;
        r5 = r11.hashCode();
    L15:
        return r10 + r5;
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationPageWaypoint(lat=" + this.lat + ", lon=" + this.lon + ", name=" + this.name + ", poiId=" + this.poiId + ", poiIdType=" + this.poiIdType + ')';
    }

    public l() {
        this(0.0d, 0.0d, null, null, null);
    }

    public l(double r1, double r3, String r5, String r6, String r7) {
        this.lat = r1;
        this.lon = r3;
        this.name = r5;
        this.poiId = r6;
        this.poiIdType = r7;
    }
}
