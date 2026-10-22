package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.amap.api.services.district.DistrictSearchQuery;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0085\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0010HÆ\u0003J\t\u0010\"\u001a\u00020\u0010HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0089\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J'\u00102\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000201H\u0010¢\u0006\u0002\b7J\t\u00108\u001a\u00020\u0006HÖ\u0001J\u0018\u00109\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u000201H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", DistrictSearchQuery.KEYWORDS_COUNTRY, "", "stateOrProvince", "administrativeArea", "locality", "subLocality", "thoroughfare", "subThoroughfare", "namedLocation", "fullAddress", "longitude", "", "latitude", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)V", "getAdministrativeArea", "()Ljava/lang/String;", "getCountry", "getFullAddress", "getLatitude", "()D", "getLocality", "getLongitude", "getNamedLocation", "getStateOrProvince", "getSubLocality", "getSubThoroughfare", "getThoroughfare", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaLocation extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String administrativeArea;
    private final String country;
    private final String fullAddress;
    private final double latitude;
    private final String locality;
    private final double longitude;
    private final String namedLocation;
    private final String stateOrProvince;
    private final String subLocality;
    private final String subThoroughfare;
    private final String thoroughfare;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaLocation$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaLocation> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaLocation createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MetaLocation(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaLocation createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaLocation[] newArray(int r100) {
            return new MetaLocation[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaLocation[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaLocation() {
        this(null, null, null, null, null, null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 2047, null);
    }

    public MetaLocation(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readDouble(), r110.readDouble());
        readMetaValueExtensionField$capabilitykitcommon_release(r110, 0, r110.readInt());
    }

    public MetaLocation(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, double r111, double r112) {
        super(10020);
        this.country = r100;
        this.stateOrProvince = r101;
        this.administrativeArea = r102;
        this.locality = r103;
        this.subLocality = r104;
        this.thoroughfare = r105;
        this.subThoroughfare = r106;
        this.namedLocation = r107;
        this.fullAddress = r110;
        this.longitude = r111;
        this.latitude = r112;
    }

    public /* synthetic */ MetaLocation(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, double r215, double r216, int r217, DefaultConstructorMarker r310) {
        String r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r217 & 256) != 0) goto L38;
        r100 = r214;
    L38:
        int r114 = r217 & 512;
        double r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r114 == 0) goto L41;
        double r116 = 0.0d;
    L43:
        if ((r217 & 1024) != 0) goto L46;
        r115 = r216;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r116, r115);
        return;
    L41:
        r116 = r215;
        goto L43
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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

    public static /* synthetic */ MetaLocation copy$default(MetaLocation r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, double r215, double r216, int r217, Object r310) {
        if ((r217 & 1) == 0) goto L5;
        String r100 = r110.country;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r101 = r110.stateOrProvince;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r102 = r110.administrativeArea;
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r103 = r110.locality;
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r104 = r110.subLocality;
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r105 = r110.thoroughfare;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r106 = r110.subThoroughfare;
    L31:
        if ((r217 & 128) == 0) goto L33;
        String r107 = r110.namedLocation;
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r115 = r110.fullAddress;
    L39:
        if ((r217 & 512) == 0) goto L41;
        double r116 = r110.longitude;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        double r117 = r110.latitude;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117);
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.country;
    }

    public final double component10() {
        return this.longitude;
    }

    public final double component11() {
        return this.latitude;
    }

    public final String component2() {
        return this.stateOrProvince;
    }

    public final String component3() {
        return this.administrativeArea;
    }

    public final String component4() {
        return this.locality;
    }

    public final String component5() {
        return this.subLocality;
    }

    public final String component6() {
        return this.thoroughfare;
    }

    public final String component7() {
        return this.subThoroughfare;
    }

    public final String component8() {
        return this.namedLocation;
    }

    public final String component9() {
        return this.fullAddress;
    }

    public final MetaLocation copy(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, double r215, double r216) {
        return new MetaLocation(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MetaLocation) == true) goto L8;
        return false;
    L8:
        MetaLocation r101 = (MetaLocation) r100;
        if (Intrinsics.areEqual(this.country, r101.country) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stateOrProvince, r101.stateOrProvince) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.administrativeArea, r101.administrativeArea) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.locality, r101.locality) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subLocality, r101.subLocality) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.thoroughfare, r101.thoroughfare) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subThoroughfare, r101.subThoroughfare) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.namedLocation, r101.namedLocation) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fullAddress, r101.fullAddress) == true) goto L36;
        return false;
    L36:
        if (Double.compare(this.longitude, r101.longitude) == 0) goto L39;
        return false;
    L39:
        if (Double.compare(this.latitude, r101.latitude) == 0) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getAdministrativeArea() {
        return this.administrativeArea;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getNamedLocation() {
        return this.namedLocation;
    }

    public final String getStateOrProvince() {
        return this.stateOrProvince;
    }

    public final String getSubLocality() {
        return this.subLocality;
    }

    public final String getSubThoroughfare() {
        return this.subThoroughfare;
    }

    public final String getThoroughfare() {
        return this.thoroughfare;
    }

    public int hashCode() {
        String r100 = this.country;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.stateOrProvince;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.administrativeArea;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.locality;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.subLocality;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.thoroughfare;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.subThoroughfare;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.namedLocation;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.fullAddress;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (r124 + r101) * 31;
        long r127 = Double.doubleToLongBits(this.longitude);
        int r128 = (r126 + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        long r129 = Double.doubleToLongBits(this.latitude);
        return r128 + ((int) (r129 ^ (r129 >>> 32)));
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

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaLocation(country=" + this.country + ", stateOrProvince=" + this.stateOrProvince + ", administrativeArea=" + this.administrativeArea + ", locality=" + this.locality + ", subLocality=" + this.subLocality + ", thoroughfare=" + this.thoroughfare + ", subThoroughfare=" + this.subThoroughfare + ", namedLocation=" + this.namedLocation + ", fullAddress=" + this.fullAddress + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.country);
        r100.writeString(this.stateOrProvince);
        r100.writeString(this.administrativeArea);
        r100.writeString(this.locality);
        r100.writeString(this.subLocality);
        r100.writeString(this.thoroughfare);
        r100.writeString(this.subThoroughfare);
        r100.writeString(this.namedLocation);
        r100.writeString(this.fullAddress);
        r100.writeDouble(this.longitude);
        r100.writeDouble(this.latitude);
        r100.writeInt(0);
    }
}
