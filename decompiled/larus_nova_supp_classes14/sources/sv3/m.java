package sv3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/picker/Waypoint;", "", "name", "", "lat", "", "lon", "poiId", "poiIdType", "<init>", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getLat", "()D", "getLon", "getPoiId", "getPoiIdType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

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
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.lat, r9.lat) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.lon, r9.lon) == 0) goto L18;
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
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        long r3 = Double.doubleToLongBits(this.lat);
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = Double.doubleToLongBits(this.lon);
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.poiId;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.poiIdType;
        if (r10 == null) goto L15;
        r1 = r10.hashCode();
    L15:
        return r9 + r1;
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Waypoint(name=" + this.name + ", lat=" + this.lat + ", lon=" + this.lon + ", poiId=" + this.poiId + ", poiIdType=" + this.poiIdType + ')';
    }

    public m() {
        this.name = null;
        this.lat = 0.0d;
        this.lon = 0.0d;
        this.poiId = null;
        this.poiIdType = null;
    }

    public final double a() {
        return this.lat;
    }

    public final double b() {
        return this.lon;
    }

    public final String c() {
        return this.name;
    }

    public final String d() {
        return this.poiId;
    }

    public final String e() {
        return this.poiIdType;
    }
}
