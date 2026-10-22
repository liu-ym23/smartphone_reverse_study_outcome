package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J^\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\nHÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nHÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006/"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/LocationCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "mode", "", "type", "longitude", "", "latitude", "radius", "", "addrName", "addrType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAddrName", "()Ljava/lang/String;", "getAddrType", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getMode", "getRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/LocationCondition;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocationCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<LocationCondition> CREATOR = null;
    private final String addrName;
    private final String addrType;
    private final Double latitude;
    private final Double longitude;
    private final String mode;
    private final Integer radius;
    private final String type;

    public static final class a implements Parcelable.Creator<LocationCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationCondition createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Double r103 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Double r104 = null;
        L11:
            if (r110.readInt() != 0) goto L13;
            Integer r105 = null;
        L14:
            LocationCondition r106 = new LocationCondition(r101, r102, r103, r104, r105, r110.readString(), r110.readString());
            int r107 = Math.min(r100, 0);
            ClassLoader r108 = a.class.getClassLoader();
            int r109 = 1;
        L15:
            if (r109 > r107) goto L17;
            r109 = r109 + 1;
        L17:
            if (r109 > r100) goto L19;
            joa.a.d(r110, r108);
            r109 = r109 + 1;
            goto L17
        L19:
            return r106;
        L13:
            r105 = Integer.valueOf(r110.readInt());
            goto L14
        L9:
            r104 = Double.valueOf(r110.readDouble());
            goto L11
        L5:
            r103 = Double.valueOf(r110.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LocationCondition[] newArray(int r100) {
            return new LocationCondition[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public LocationCondition(@LocationMode String r100, @LocationType String r101, Double r102, Double r103, Integer r104, String r105, @AddrType String r106) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.mode = r100;
        this.type = r101;
        this.longitude = r102;
        this.latitude = r103;
        this.radius = r104;
        this.addrName = r105;
        this.addrType = r106;
    }

    public /* synthetic */ LocationCondition(String r110, String r111, Double r112, Double r113, Integer r114, String r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        Double r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        Double r101 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r117 & 64) == 0) goto L21;
        String r104 = null;
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static /* synthetic */ LocationCondition copy$default(LocationCondition r100, String r101, String r102, Double r103, Double r104, Integer r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.mode;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.longitude;
    L11:
        Double r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.latitude;
    L14:
        Double r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.radius;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.addrName;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.addrType;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.mode;
    }

    public final String component2() {
        return this.type;
    }

    public final Double component3() {
        return this.longitude;
    }

    public final Double component4() {
        return this.latitude;
    }

    public final Integer component5() {
        return this.radius;
    }

    public final String component6() {
        return this.addrName;
    }

    public final String component7() {
        return this.addrType;
    }

    public final LocationCondition copy(@LocationMode String r110, @LocationType String r111, Double r112, Double r113, Integer r114, String r115, @AddrType String r116) {
        Intrinsics.checkNotNullParameter(r110, "mode");
        Intrinsics.checkNotNullParameter(r111, "type");
        return new LocationCondition(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocationCondition) == true) goto L8;
        return false;
    L8:
        LocationCondition r101 = (LocationCondition) r100;
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.longitude, r101.longitude) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.latitude, r101.latitude) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.addrName, r101.addrName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.addrType, r101.addrType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAddrName() {
        return this.addrName;
    }

    public final String getAddrType() {
        return this.addrType;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r100 = ((this.mode.hashCode() * 31) + this.type.hashCode()) * 31;
        Double r101 = this.longitude;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Double r105 = this.latitude;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.radius;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.addrName;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.addrType;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationCondition(mode=" + this.mode + ", type=" + this.type + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", radius=" + this.radius + ", addrName=" + this.addrName + ", addrType=" + this.addrType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.mode);
        r100.writeString(this.type);
        Double r103 = this.longitude;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Double r104 = this.latitude;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r105 = this.radius;
        if (r105 == null) goto L14;
        r100.writeInt(1);
        r102 = r105.intValue();
    L14:
        r100.writeInt(r102);
        r100.writeString(this.addrName);
        r100.writeString(this.addrType);
        return;
    L9:
        r100.writeInt(1);
        r100.writeDouble(r104.doubleValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeDouble(r103.doubleValue());
        goto L6
    }
}
