package com.larus.platform.model;

import com.bytedance.ai.api.navi.AppletNaviType;
import hq9.b3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u000eHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u001cHÆ\u0003J\t\u0010S\u001a\u00020\u001cHÆ\u0003J\t\u0010T\u001a\u00020\u001cHÆ\u0003Jú\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\tHÖ\u0001J\t\u0010[\u001a\u00020\u000bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u0017\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b9\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001d\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0011\u0010\u001e\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010=¨\u0006\\"}, d2 = {"Lcom/larus/platform/model/GeoLocationInfo;", "Ljava/io/Serializable;", "gpsDir", "", "longitude", "", "latitude", "altitude", "accuracyLevel", "", "city", "", "speed", "gpsTime", "", "satelliteCount", "radius", "locationType", "extraInfo", "Lcom/larus/platform/model/LocationExtraInfo;", "cityCode", "districtCode", "provinceCode", "locationTime", "bearing", "naviAccuracy", AppletNaviType.POI, "poiUseFallback", "", "validLatlng", "isLightLocation", "<init>", "(Ljava/lang/Float;DDDILjava/lang/String;FJIFILcom/larus/platform/model/LocationExtraInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;FLjava/lang/String;ZZZ)V", "getGpsDir", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLongitude", "()D", "getLatitude", "getAltitude", "getAccuracyLevel", "()I", "getCity", "()Ljava/lang/String;", "getSpeed", "()F", "getGpsTime", "()J", "getSatelliteCount", "getRadius", "getLocationType", "getExtraInfo", "()Lcom/larus/platform/model/LocationExtraInfo;", "getCityCode", "getDistrictCode", "getProvinceCode", "getLocationTime", "getBearing", "getNaviAccuracy", "getPoi", "getPoiUseFallback", "()Z", "getValidLatlng", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/Float;DDDILjava/lang/String;FJIFILcom/larus/platform/model/LocationExtraInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;FLjava/lang/String;ZZZ)Lcom/larus/platform/model/GeoLocationInfo;", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeoLocationInfo implements Serializable {
    private final int accuracyLevel;
    private final double altitude;
    private final Float bearing;
    private final String city;
    private final String cityCode;
    private final String districtCode;
    private final transient b3 extraInfo;
    private final Float gpsDir;
    private final long gpsTime;
    private final boolean isLightLocation;
    private final double latitude;
    private final long locationTime;
    private final int locationType;
    private final double longitude;
    private final float naviAccuracy;
    private final String poi;
    private final boolean poiUseFallback;
    private final String provinceCode;
    private final float radius;
    private final int satelliteCount;
    private final float speed;
    private final boolean validLatlng;

    public static /* synthetic */ GeoLocationInfo copy$default(GeoLocationInfo r110, Float r111, double r112, double r210, double r211, int r212, String r213, float r214, long r215, int r310, float r311, int r312, b3 r313, String r314, String r315, String r316, long r317, Float r318, float r410, String r411, boolean r412, boolean r413, boolean r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        Float r100 = r110.gpsDir;
    L7:
        if ((r415 & 2) == 0) goto L9;
        double r101 = r110.longitude;
    L11:
        if ((r415 & 4) == 0) goto L13;
        double r102 = r110.latitude;
    L15:
        if ((r415 & 8) == 0) goto L17;
        double r103 = r110.altitude;
    L19:
        if ((r415 & 16) == 0) goto L21;
        int r104 = r110.accuracyLevel;
    L23:
        if ((r415 & 32) == 0) goto L25;
        String r113 = r110.city;
    L27:
        if ((r415 & 64) == 0) goto L29;
        float r114 = r110.speed;
    L31:
        if ((r415 & 128) == 0) goto L33;
        long r115 = r110.gpsTime;
    L35:
        if ((r415 & 256) == 0) goto L37;
        int r116 = r110.satelliteCount;
    L39:
        if ((r415 & 512) == 0) goto L41;
        float r117 = r110.radius;
    L42:
        float r319 = r117;
        if ((r415 & 1024) == 0) goto L45;
        int r118 = r110.locationType;
    L46:
        int r320 = r118;
        if ((r415 & 2048) == 0) goto L49;
        b3 r119 = r110.extraInfo;
    L50:
        b3 r321 = r119;
        if ((r415 & 4096) == 0) goto L53;
        String r120 = r110.cityCode;
    L54:
        String r322 = r120;
        if ((r415 & 8192) == 0) goto L57;
        String r121 = r110.districtCode;
    L58:
        String r323 = r121;
        if ((r415 & 16384) == 0) goto L61;
        String r122 = r110.provinceCode;
    L62:
        int r324 = r116;
        String r325 = r122;
        if ((r415 & 32768) == 0) goto L65;
        long r123 = r110.locationTime;
    L66:
        long r326 = r123;
        if ((r415 & 65536) == 0) goto L69;
        Float r124 = r110.bearing;
    L71:
        if ((131072 & r415) == 0) goto L73;
        float r125 = r110.naviAccuracy;
    L74:
        float r417 = r125;
        if ((r415 & 262144) == 0) goto L77;
        String r126 = r110.poi;
    L78:
        String r418 = r126;
        if ((r415 & 524288) == 0) goto L81;
        boolean r127 = r110.poiUseFallback;
    L82:
        boolean r419 = r127;
        if ((r415 & 1048576) == 0) goto L85;
        boolean r128 = r110.validLatlng;
    L87:
        if ((r415 & 2097152) == 0) goto L89;
        boolean r105 = r110.isLightLocation;
    L91:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r115, r324, r319, r320, r321, r322, r323, r325, r326, r124, r417, r418, r419, r128, r105);
    L89:
        r105 = r414;
        goto L91
    L85:
        r128 = r413;
        goto L87
    L81:
        r127 = r412;
        goto L82
    L77:
        r126 = r411;
        goto L78
    L73:
        r125 = r410;
        goto L74
    L69:
        r124 = r318;
        goto L71
    L65:
        r123 = r317;
        goto L66
    L61:
        r122 = r316;
        goto L62
    L57:
        r121 = r315;
        goto L58
    L53:
        r120 = r314;
        goto L54
    L49:
        r119 = r313;
        goto L50
    L45:
        r118 = r312;
        goto L46
    L41:
        r117 = r311;
        goto L42
    L37:
        r116 = r310;
        goto L39
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Float component1() {
        return this.gpsDir;
    }

    public final float component10() {
        return this.radius;
    }

    public final int component11() {
        return this.locationType;
    }

    public final b3 component12() {
        return this.extraInfo;
    }

    public final String component13() {
        return this.cityCode;
    }

    public final String component14() {
        return this.districtCode;
    }

    public final String component15() {
        return this.provinceCode;
    }

    public final long component16() {
        return this.locationTime;
    }

    public final Float component17() {
        return this.bearing;
    }

    public final float component18() {
        return this.naviAccuracy;
    }

    public final String component19() {
        return this.poi;
    }

    public final double component2() {
        return this.longitude;
    }

    public final boolean component20() {
        return this.poiUseFallback;
    }

    public final boolean component21() {
        return this.validLatlng;
    }

    public final boolean component22() {
        return this.isLightLocation;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.altitude;
    }

    public final int component5() {
        return this.accuracyLevel;
    }

    public final String component6() {
        return this.city;
    }

    public final float component7() {
        return this.speed;
    }

    public final long component8() {
        return this.gpsTime;
    }

    public final int component9() {
        return this.satelliteCount;
    }

    public final GeoLocationInfo copy(Float r310, double r311, double r312, double r313, int r314, String r315, float r316, long r410, int r411, float r412, int r413, b3 r414, String r415, String r416, String r417, long r418, Float r510, float r511, String r512, boolean r513, boolean r514, boolean r515) {
        return new GeoLocationInfo(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GeoLocationInfo) == true) goto L8;
        return false;
    L8:
        GeoLocationInfo r101 = (GeoLocationInfo) r100;
        if (Intrinsics.areEqual(this.gpsDir, r101.gpsDir) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.longitude, r101.longitude) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.latitude, r101.latitude) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.altitude, r101.altitude) == 0) goto L21;
        return false;
    L21:
        if (this.accuracyLevel == r101.accuracyLevel) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.city, r101.city) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.speed, r101.speed) == 0) goto L30;
        return false;
    L30:
        if (this.gpsTime == r101.gpsTime) goto L33;
        return false;
    L33:
        if (this.satelliteCount == r101.satelliteCount) goto L36;
        return false;
    L36:
        if (Float.compare(this.radius, r101.radius) == 0) goto L39;
        return false;
    L39:
        if (this.locationType == r101.locationType) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.cityCode, r101.cityCode) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.districtCode, r101.districtCode) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.provinceCode, r101.provinceCode) == true) goto L54;
        return false;
    L54:
        if (this.locationTime == r101.locationTime) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bearing, r101.bearing) == true) goto L60;
        return false;
    L60:
        if (Float.compare(this.naviAccuracy, r101.naviAccuracy) == 0) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.poi, r101.poi) == true) goto L66;
        return false;
    L66:
        if (this.poiUseFallback == r101.poiUseFallback) goto L69;
        return false;
    L69:
        if (this.validLatlng == r101.validLatlng) goto L72;
        return false;
    L72:
        if (this.isLightLocation == r101.isLightLocation) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        Float r100 = this.gpsDir;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = Double.doubleToLongBits(this.longitude);
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.latitude);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = Double.doubleToLongBits(this.altitude);
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.accuracyLevel) * 31;
        String r109 = this.city;
        if (r109 != null) goto L9;
        int r110 = 0;
    L10:
        int r111 = (((r108 + r110) * 31) + Float.floatToIntBits(this.speed)) * 31;
        long r112 = this.gpsTime;
        int r113 = (((((((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.satelliteCount) * 31) + Float.floatToIntBits(this.radius)) * 31) + this.locationType) * 31;
        b3 r114 = this.extraInfo;
        if (r114 != null) goto L13;
        int r115 = 0;
    L14:
        int r116 = (r113 + r115) * 31;
        String r117 = this.cityCode;
        if (r117 != null) goto L17;
        int r118 = 0;
    L18:
        int r119 = (r116 + r118) * 31;
        String r120 = this.districtCode;
        if (r120 != null) goto L21;
        int r121 = 0;
    L22:
        int r122 = (r119 + r121) * 31;
        String r123 = this.provinceCode;
        if (r123 != null) goto L25;
        int r124 = 0;
    L26:
        int r125 = (r122 + r124) * 31;
        long r126 = this.locationTime;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        Float r128 = this.bearing;
        if (r128 != null) goto L29;
        int r129 = 0;
    L30:
        int r130 = (((r127 + r129) * 31) + Float.floatToIntBits(this.naviAccuracy)) * 31;
        String r131 = this.poi;
        if (r131 == null) goto L34;
        r101 = r131.hashCode();
    L34:
        int r132 = (r130 + r101) * 31;
        int r133 = 1231;
        if (this.poiUseFallback == false) goto L37;
        int r134 = 1231;
    L38:
        int r135 = (r132 + r134) * 31;
        if (this.validLatlng == false) goto L41;
        int r136 = 1231;
    L42:
        int r137 = (r135 + r136) * 31;
        if (this.isLightLocation == true) goto L47;
        r133 = 1237;
    L47:
        return r137 + r133;
    L41:
        r136 = 1237;
        goto L42
    L37:
        r134 = 1237;
        goto L38
    L29:
        r129 = r128.hashCode();
        goto L30
    L25:
        r124 = r123.hashCode();
        goto L26
    L21:
        r121 = r120.hashCode();
        goto L22
    L17:
        r118 = r117.hashCode();
        goto L18
    L13:
        r115 = r114.hashCode();
        goto L14
    L9:
        r110 = r109.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GeoLocationInfo(gpsDir=" + this.gpsDir + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", altitude=" + this.altitude + ", accuracyLevel=" + this.accuracyLevel + ", city=" + this.city + ", speed=" + this.speed + ", gpsTime=" + this.gpsTime + ", satelliteCount=" + this.satelliteCount + ", radius=" + this.radius + ", locationType=" + this.locationType + ", extraInfo=" + this.extraInfo + ", cityCode=" + this.cityCode + ", districtCode=" + this.districtCode + ", provinceCode=" + this.provinceCode + ", locationTime=" + this.locationTime + ", bearing=" + this.bearing + ", naviAccuracy=" + this.naviAccuracy + ", poi=" + this.poi + ", poiUseFallback=" + this.poiUseFallback + ", validLatlng=" + this.validLatlng + ", isLightLocation=" + this.isLightLocation + ')';
    }

    public final int getAccuracyLevel() {
        return this.accuracyLevel;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final Float getBearing() {
        return this.bearing;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCityCode() {
        return this.cityCode;
    }

    public final String getDistrictCode() {
        return this.districtCode;
    }

    public final b3 getExtraInfo() {
        return this.extraInfo;
    }

    public final Float getGpsDir() {
        return this.gpsDir;
    }

    public final long getGpsTime() {
        return this.gpsTime;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final long getLocationTime() {
        return this.locationTime;
    }

    public final int getLocationType() {
        return this.locationType;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final float getNaviAccuracy() {
        return this.naviAccuracy;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final boolean getPoiUseFallback() {
        return this.poiUseFallback;
    }

    public final String getProvinceCode() {
        return this.provinceCode;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getSatelliteCount() {
        return this.satelliteCount;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final boolean getValidLatlng() {
        return this.validLatlng;
    }

    public final boolean isLightLocation() {
        return this.isLightLocation;
    }

    public GeoLocationInfo(Float r100, double r101, double r102, double r103, int r110, String r111, float r112, long r113, int r114, float r115, int r116, b3 r117, String r210, String r211, String r212, long r213, Float r214, float r215, String r216, boolean r217, boolean r218, boolean r310) {
        this.gpsDir = r100;
        this.longitude = r101;
        this.latitude = r102;
        this.altitude = r103;
        this.accuracyLevel = r110;
        this.city = r111;
        this.speed = r112;
        this.gpsTime = r113;
        this.satelliteCount = r114;
        this.radius = r115;
        this.locationType = r116;
        this.extraInfo = r117;
        this.cityCode = r210;
        this.districtCode = r211;
        this.provinceCode = r212;
        this.locationTime = r213;
        this.bearing = r214;
        this.naviAccuracy = r215;
        this.poi = r216;
        this.poiUseFallback = r217;
        this.validLatlng = r218;
        this.isLightLocation = r310;
    }

    public /* synthetic */ GeoLocationInfo(Float r310, double r311, double r312, double r313, int r314, String r315, float r410, long r411, int r412, float r413, int r414, b3 r415, String r416, String r417, String r418, long r510, Float r511, float r512, String r513, boolean r514, boolean r515, boolean r516, int r517, DefaultConstructorMarker r518) {
        if ((r517 & 32) == 0) goto L5;
        String r110 = "";
    L7:
        if ((r517 & 256) == 0) goto L9;
        int r111 = 0;
    L11:
        if ((r517 & 2048) == 0) goto L13;
        b3 r112 = null;
    L15:
        if ((r517 & 4096) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r517 & 8192) == 0) goto L21;
        String r210 = null;
    L23:
        if ((r517 & 16384) == 0) goto L25;
        String r211 = null;
    L27:
        if ((32768 & r517) == 0) goto L29;
        long r212 = 0;
    L31:
        if ((65536 & r517) == 0) goto L33;
        Float r213 = null;
    L35:
        if ((131072 & r517) == 0) goto L37;
        float r214 = 0.0f;
    L39:
        if ((262144 & r517) == 0) goto L41;
        String r215 = null;
    L43:
        if ((524288 & r517) == 0) goto L45;
        boolean r216 = false;
    L47:
        if ((1048576 & r517) == 0) goto L49;
        boolean r217 = false;
    L51:
        if ((r517 & 2097152) == 0) goto L53;
        boolean r218 = false;
    L54:
        this(r310, r311, r312, r313, r314, r110, r410, r411, r111, r413, r414, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        return;
    L53:
        r218 = r516;
        goto L54
    L49:
        r217 = r515;
        goto L51
    L45:
        r216 = r514;
        goto L47
    L41:
        r215 = r513;
        goto L43
    L37:
        r214 = r512;
        goto L39
    L33:
        r213 = r511;
        goto L35
    L29:
        r212 = r510;
        goto L31
    L25:
        r211 = r418;
        goto L27
    L21:
        r210 = r417;
        goto L23
    L17:
        r113 = r416;
        goto L19
    L13:
        r112 = r415;
        goto L15
    L9:
        r111 = r412;
        goto L11
    L5:
        r110 = r315;
        goto L7
    }
}
