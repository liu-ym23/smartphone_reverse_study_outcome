package com.bytedance.bdlocation.continuous;

import android.location.Location;
import android.os.Build;
import androidx.camera.video.AudioStats;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.bridge.LocationOutput;
import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.network.model.InputSystemGpsInfo;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¨\u0006\u001f"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionLocationOutputMapper;", "", "()V", "buildAndroidLocation", "Landroid/location/Location;", "fusionLocation", "Lcom/bytedance/bdlocation/bridge/LocationOutput$FusionLocation;", "glf", "Lcom/bytedance/bdlocation/bridge/LocationOutput$GuideLocationFix;", "gcj02Point", "Lcom/bytedance/bdlocation/client/BDPoint;", "finiteDouble", "", "value", "defaultValue", "(Ljava/lang/Double;D)D", "finiteFloat", "", "(Ljava/lang/Double;F)F", "(Ljava/lang/Float;F)F", "toBDLocation", "Lcom/bytedance/bdlocation/BDLocation;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/bytedance/bdlocation/bridge/LocationOutput;", "toBDPoint", "latLng", "Lcom/bytedance/bdlocation/bridge/LocationOutput$LatLng;", "toInputSystemGpsInfo", "Lcom/bytedance/bdlocation/network/model/InputSystemGpsInfo;", GeocodeSearch.GPS, "Lcom/bytedance/bdlocation/bridge/SensorBatch$GpsStruct;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionLocationOutputMapper {
    public static final ByteFusionLocationOutputMapper INSTANCE = null;

    private ByteFusionLocationOutputMapper() {
    }

    static {
        INSTANCE = new ByteFusionLocationOutputMapper();
    }

    private final BDPoint toBDPoint(LocationOutput.LatLng r100) {
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L5;
        double r102 = r100.lat;
    L6:
        if (r100 == null) goto L9;
        r101 = r100.lon;
    L9:
        return new BDPoint(r102, r101, LocationInfoConst.BYTE_FUSION_CONTINUOUS, "gcj02");
    L5:
        r102 = 0.0d;
        goto L6
    }

    private final InputSystemGpsInfo toInputSystemGpsInfo(SensorBatch.GpsStruct r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.timestampMs > 0) goto L7;
        return null;
    L7:
        InputSystemGpsInfo r101 = new InputSystemGpsInfo();
        r101.timestampMs = r100.timestampMs;
        ByteFusionLocationOutputMapper r102 = INSTANCE;
        r101.lat = r102.finiteDouble(Double.valueOf(r100.lat), AudioStats.AUDIO_AMPLITUDE_NONE);
        r101.lon = r102.finiteDouble(Double.valueOf(r100.lon), AudioStats.AUDIO_AMPLITUDE_NONE);
        r101.locationAccuracy = r102.finiteFloat(Float.valueOf(r100.locationAccuracy), 0.0f);
        r101.speed = r102.finiteFloat(Float.valueOf(r100.speed), 0.0f);
        r101.speedAccuracy = r102.finiteFloat(Float.valueOf(r100.speedAccuracy), 0.0f);
        r101.bearing = r102.finiteFloat(Float.valueOf(r100.bearing), 0.0f);
        r101.bearingAccuracy = r102.finiteFloat(Float.valueOf(r100.bearingAccuracy), 0.0f);
        r101.sourceType = r100.sourceType;
        return r101;
    }

    public final BDLocation toBDLocation(LocationOutput r100) {
        LocationOutput.FusionLocation r101 = r100.fusion;
        LocationOutput.GuideLocationFix r102 = r100.glf;
        if (r102 == null) goto L5;
        LocationOutput.LatLng r103 = r102.shownLocation;
    L6:
        BDPoint r104 = toBDPoint(r103);
        Location r105 = buildAndroidLocation(r101, r102, r104);
        BDLocation r106 = new BDLocation(r105, LocationInfoConst.BYTE_FUSION_CONTINUOUS);
        boolean r107 = false;
        if (r102 == null) goto L9;
        int r108 = r102.locationType;
    L10:
        r106.setLocationType(r108);
        r106.setLocationMs(r105.getTime());
        r106.setTrustedLevel(1);
        r106.setCoordinateSystem("gcj02");
        LocationOutput.FusionLocation r109 = r100.fusion;
        if (r109 == null) goto L13;
        r107 = r109.inputHasLatlng;
    L13:
        r106.setInputHasLatlng(r107);
        r106.setGCJ02(r104);
        r106.setInputSystemGpsInfo(INSTANCE.toInputSystemGpsInfo(r100.gps));
        return r106;
    L9:
        r108 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    private final double finiteDouble(Double r100, double r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (Double.isNaN(r100.doubleValue()) == false) goto L6;
        return r101;
    L6:
        if (Double.isInfinite(r100.doubleValue()) == false) goto L8;
        return r101;
    L8:
        return r100.doubleValue();
    }

    private final float finiteFloat(Double r100, float r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (Double.isNaN(r100.doubleValue()) == false) goto L6;
        return r101;
    L6:
        if (Double.isInfinite(r100.doubleValue()) == false) goto L8;
        return r101;
    L8:
        return (float) r100.doubleValue();
    }

    private final float finiteFloat(Float r100, float r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (Float.isNaN(r100.floatValue()) == false) goto L6;
        return r101;
    L6:
        if (Float.isInfinite(r100.floatValue()) == false) goto L8;
        return r101;
    L8:
        return r100.floatValue();
    }

    private final Location buildAndroidLocation(LocationOutput.FusionLocation r100, LocationOutput.GuideLocationFix r101, BDPoint r102) {
        Location r103 = new Location(LocationInfoConst.BYTE_FUSION_CONTINUOUS);
        if (r101 == null) goto L5;
        long r104 = r101.locationTimestampMs;
    L6:
        r103.setTime(r104);
        r103.setLatitude(r102.getLatitude());
        r103.setLongitude(r102.getLongitude());
        ByteFusionLocationOutputMapper r105 = INSTANCE;
        Float r106 = null;
        if (r101 == null) goto L9;
        Float r107 = Float.valueOf(r101.accuracy);
    L10:
        r103.setAccuracy(r105.finiteFloat(r107, 0.0f));
        if (r101 == null) goto L13;
        Double r108 = Double.valueOf(r101.speed);
    L14:
        r103.setSpeed(r105.finiteFloat(r108, 0.0f));
        if (r101 == null) goto L17;
        Double r109 = Double.valueOf(r101.heading);
    L18:
        r103.setBearing(r105.finiteFloat(r109, 0.0f));
        if (r101 == null) goto L21;
        Double r110 = Double.valueOf(r101.altitude);
    L22:
        r103.setAltitude(r105.finiteDouble(r110, AudioStats.AUDIO_AMPLITUDE_NONE));
        if (Build.VERSION.SDK_INT < 26) goto L31;
        if (r100 == null) goto L26;
        Float r111 = Float.valueOf(r100.speedAccuracy);
    L27:
        r103.setSpeedAccuracyMetersPerSecond(r105.finiteFloat(r111, 0.0f));
        if (r100 == null) goto L30;
        r106 = Float.valueOf(r100.bearingAccuracy);
    L30:
        r103.setBearingAccuracyDegrees(r105.finiteFloat(r106, 0.0f));
        goto L31
    L26:
        r111 = null;
    L31:
        return r103;
    L21:
        r110 = null;
        goto L22
    L17:
        r109 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }
}
