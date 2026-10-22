package com.bytedance.bdlocation.continuous;

import android.location.Location;
import android.os.Build;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.bridge.LocationOutput;
import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.network.model.InputSystemGpsInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¨\u0006\u001f"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionLocationOutputMapper;", "", "()V", "buildAndroidLocation", "Landroid/location/Location;", "fusionLocation", "Lcom/bytedance/bdlocation/bridge/LocationOutput$FusionLocation;", "glf", "Lcom/bytedance/bdlocation/bridge/LocationOutput$GuideLocationFix;", "gcj02Point", "Lcom/bytedance/bdlocation/client/BDPoint;", "finiteDouble", "", "value", "defaultValue", "(Ljava/lang/Double;D)D", "finiteFloat", "", "(Ljava/lang/Double;F)F", "(Ljava/lang/Float;F)F", "toBDLocation", "Lcom/bytedance/bdlocation/BDLocation;", "output", "Lcom/bytedance/bdlocation/bridge/LocationOutput;", "toBDPoint", "latLng", "Lcom/bytedance/bdlocation/bridge/LocationOutput$LatLng;", "toInputSystemGpsInfo", "Lcom/bytedance/bdlocation/network/model/InputSystemGpsInfo;", "gps", "Lcom/bytedance/bdlocation/bridge/SensorBatch$GpsStruct;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionLocationOutputMapper {
    public static final ByteFusionLocationOutputMapper INSTANCE = null;

    private ByteFusionLocationOutputMapper() {
    }

    static {
        INSTANCE = new ByteFusionLocationOutputMapper();
    }

    private final BDPoint toBDPoint(LocationOutput.LatLng r9) {
        double r0 = 0.0d;
        if (r9 == null) goto L5;
        double r2 = r9.lat;
    L6:
        if (r9 == null) goto L9;
        r0 = r9.lon;
    L9:
        return new BDPoint(r2, r0, LocationInfoConst.BYTE_FUSION_CONTINUOUS, LocationInfoConst.GCJ_O2);
    L5:
        r2 = 0.0d;
        goto L6
    }

    private final InputSystemGpsInfo toInputSystemGpsInfo(SensorBatch.GpsStruct r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8.timestampMs > 0) goto L7;
        return null;
    L7:
        InputSystemGpsInfo r0 = new InputSystemGpsInfo();
        r0.timestampMs = r8.timestampMs;
        ByteFusionLocationOutputMapper r1 = INSTANCE;
        r0.lat = r1.finiteDouble(Double.valueOf(r8.lat), 0.0d);
        r0.lon = r1.finiteDouble(Double.valueOf(r8.lon), 0.0d);
        r0.locationAccuracy = r1.finiteFloat(Float.valueOf(r8.locationAccuracy), 0.0f);
        r0.speed = r1.finiteFloat(Float.valueOf(r8.speed), 0.0f);
        r0.speedAccuracy = r1.finiteFloat(Float.valueOf(r8.speedAccuracy), 0.0f);
        r0.bearing = r1.finiteFloat(Float.valueOf(r8.bearing), 0.0f);
        r0.bearingAccuracy = r1.finiteFloat(Float.valueOf(r8.bearingAccuracy), 0.0f);
        r0.sourceType = r8.sourceType;
        return r0;
    }

    public final BDLocation toBDLocation(LocationOutput r6) {
        LocationOutput.FusionLocation r0 = r6.fusion;
        LocationOutput.GuideLocationFix r1 = r6.glf;
        if (r1 == null) goto L5;
        LocationOutput.LatLng r2 = r1.shownLocation;
    L6:
        BDPoint r3 = toBDPoint(r2);
        Location r4 = buildAndroidLocation(r0, r1, r3);
        BDLocation r5 = new BDLocation(r4, LocationInfoConst.BYTE_FUSION_CONTINUOUS);
        boolean r7 = false;
        if (r1 == null) goto L9;
        int r8 = r1.locationType;
    L10:
        r5.setLocationType(r8);
        r5.setLocationMs(r4.getTime());
        r5.setTrustedLevel(1);
        r5.setCoordinateSystem(LocationInfoConst.GCJ_O2);
        LocationOutput.FusionLocation r9 = r6.fusion;
        if (r9 == null) goto L13;
        r7 = r9.inputHasLatlng;
    L13:
        r5.setInputHasLatlng(r7);
        r5.setGCJ02(r3);
        r5.setInputSystemGpsInfo(INSTANCE.toInputSystemGpsInfo(r6.gps));
        return r5;
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final double finiteDouble(Double r3, double r4) {
        if (r3 != null) goto L4;
        return r4;
    L4:
        if (Double.isNaN(r3.doubleValue()) == false) goto L6;
        return r4;
    L6:
        if (Double.isInfinite(r3.doubleValue()) == false) goto L8;
        return r4;
    L8:
        return r3.doubleValue();
    }

    private final float finiteFloat(Double r3, float r4) {
        if (r3 != null) goto L4;
        return r4;
    L4:
        if (Double.isNaN(r3.doubleValue()) == false) goto L6;
        return r4;
    L6:
        if (Double.isInfinite(r3.doubleValue()) == false) goto L8;
        return r4;
    L8:
        return (float) r3.doubleValue();
    }

    private final float finiteFloat(Float r2, float r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (Float.isNaN(r2.floatValue()) == false) goto L6;
        return r3;
    L6:
        if (Float.isInfinite(r2.floatValue()) == false) goto L8;
        return r3;
    L8:
        return r2.floatValue();
    }

    private final Location buildAndroidLocation(LocationOutput.FusionLocation r7, LocationOutput.GuideLocationFix r8, BDPoint r9) {
        Location r0 = new Location(LocationInfoConst.BYTE_FUSION_CONTINUOUS);
        if (r8 == null) goto L5;
        long r1 = r8.locationTimestampMs;
    L6:
        r0.setTime(r1);
        r0.setLatitude(r9.getLatitude());
        r0.setLongitude(r9.getLongitude());
        ByteFusionLocationOutputMapper r10 = INSTANCE;
        Float r2 = null;
        if (r8 == null) goto L9;
        Float r3 = Float.valueOf(r8.accuracy);
    L10:
        r0.setAccuracy(r10.finiteFloat(r3, 0.0f));
        if (r8 == null) goto L13;
        Double r4 = Double.valueOf(r8.speed);
    L14:
        r0.setSpeed(r10.finiteFloat(r4, 0.0f));
        if (r8 == null) goto L17;
        Double r5 = Double.valueOf(r8.heading);
    L18:
        r0.setBearing(r10.finiteFloat(r5, 0.0f));
        if (r8 == null) goto L21;
        Double r11 = Double.valueOf(r8.altitude);
    L22:
        r0.setAltitude(r10.finiteDouble(r11, 0.0d));
        if (Build.VERSION.SDK_INT < 26) goto L31;
        if (r7 == null) goto L26;
        Float r12 = Float.valueOf(r7.speedAccuracy);
    L27:
        r0.setSpeedAccuracyMetersPerSecond(r10.finiteFloat(r12, 0.0f));
        if (r7 == null) goto L30;
        r2 = Float.valueOf(r7.bearingAccuracy);
    L30:
        r0.setBearingAccuracyDegrees(r10.finiteFloat(r2, 0.0f));
        goto L31
    L26:
        r12 = null;
    L31:
        return r0;
    L21:
        r11 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }
}
