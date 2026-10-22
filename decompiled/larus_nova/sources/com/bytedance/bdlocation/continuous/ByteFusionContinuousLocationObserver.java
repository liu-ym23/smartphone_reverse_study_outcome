package com.bytedance.bdlocation.continuous;

import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.bridge.WalkingCyclingNavigationHint;
import com.bytedance.bdlocation.log.Logger;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationObserver;", "", "()V", "formatDop", "", OPTrace.BATCH_DATA_KEY, "Lcom/bytedance/bdlocation/bridge/SensorBatch;", "formatGnssMeasurement", "formatGpsWithoutLatLng", "formatImu", "formatNavigationHint", "formatTimestamp", "timestampMs", "", "formatWheel", "logKeyNode", "", "stage", "navInstanceId", "message", LynxError.LYNX_THROWABLE, "", "logSensorBatchPush", "pushResult", "", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionContinuousLocationObserver {
    public static final Companion Companion = null;
    private static final String TAG = "ByteFusionContinuous";
    private static final SimpleDateFormat TIME_FORMAT = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationObserver$Companion;", "", "()V", "TAG", "", "TIME_FORMAT", "Ljava/text/SimpleDateFormat;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public ByteFusionContinuousLocationObserver() {
    }

    static {
        Companion = new Companion(null);
        TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
    }

    private final String formatDop(SensorBatch r100) {
        SensorBatch.DopInfo r101 = r100.dopInfo;
        if (r101 != null) goto L5;
        return "null";
    L5:
        return "pdop=" + r101.pdop + ", hdop=" + r101.hdop + ", vdop=" + r101.vdop;
    }

    private final String formatGnssMeasurement(SensorBatch r100) {
        SensorBatch.GnssMeasurement r101 = r100.meas;
        if (r101 == null) goto L57;
        StringBuilder r102 = new StringBuilder("svidSize=");
        int[] r103 = r101.svid;
        int r104 = 0;
        if (r103 == null) goto L7;
        int r105 = r103.length;
    L8:
        r102.append(r105);
        r102.append(", constellationTypeSize=");
        int[] r106 = r101.constellationType;
        if (r106 == null) goto L11;
        int r107 = r106.length;
    L12:
        r102.append(r107);
        r102.append(", pseudorangeSize=");
        double[] r108 = r101.pseudorangeM;
        if (r108 == null) goto L15;
        int r109 = r108.length;
    L16:
        r102.append(r109);
        r102.append(", carrierPhaseSize=");
        double[] r110 = r101.carrierPhaseCycles;
        if (r110 == null) goto L19;
        int r111 = r110.length;
    L20:
        r102.append(r111);
        r102.append(", dopplerSize=");
        double[] r112 = r101.dopplerHz;
        if (r112 == null) goto L23;
        int r113 = r112.length;
    L24:
        r102.append(r113);
        r102.append(", cn0Size=");
        float[] r114 = r101.cn0Dbhz;
        if (r114 == null) goto L27;
        int r115 = r114.length;
    L28:
        r102.append(r115);
        r102.append(", gnssTimeSize=");
        long[] r116 = r101.gnssTimeNs;
        if (r116 == null) goto L31;
        int r117 = r116.length;
    L32:
        r102.append(r117);
        r102.append(", systemTimeSize=");
        long[] r118 = r101.systemTimeNs;
        if (r118 == null) goto L35;
        int r119 = r118.length;
    L36:
        r102.append(r119);
        r102.append(", signalSyncStateSize=");
        int[] r120 = r101.signalSyncState;
        if (r120 == null) goto L39;
        int r121 = r120.length;
    L40:
        r102.append(r121);
        r102.append(", adrStateSize=");
        int[] r122 = r101.adrState;
        if (r122 == null) goto L43;
        int r123 = r122.length;
    L44:
        r102.append(r123);
        r102.append(", elevationSize=");
        float[] r124 = r101.elevationDeg;
        if (r124 == null) goto L47;
        int r125 = r124.length;
    L48:
        r102.append(r125);
        r102.append(", azimuthSize=");
        float[] r126 = r101.azimuthDeg;
        if (r126 == null) goto L51;
        int r127 = r126.length;
    L52:
        r102.append(r127);
        r102.append(", usedInFixSize=");
        boolean[] r128 = r101.usedInFix;
        if (r128 == null) goto L55;
        r104 = r128.length;
    L55:
        r102.append(r104);
        return r102.toString();
    L51:
        r127 = 0;
        goto L52
    L47:
        r125 = 0;
        goto L48
    L43:
        r123 = 0;
        goto L44
    L39:
        r121 = 0;
        goto L40
    L35:
        r119 = 0;
        goto L36
    L31:
        r117 = 0;
        goto L32
    L27:
        r115 = 0;
        goto L28
    L23:
        r113 = 0;
        goto L24
    L19:
        r111 = 0;
        goto L20
    L15:
        r109 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r105 = 0;
        goto L8
    L57:
        return "null";
    }

    private final String formatGpsWithoutLatLng(SensorBatch r100) {
        SensorBatch.GpsStruct r101 = r100.gps;
        if (r101 != null) goto L5;
        return "null";
    L5:
        return "locationTimestampMs=" + r101.locationTimestampMs + ", timestampMs=" + r101.timestampMs + ", accuracy=" + r101.locationAccuracy + ", speed=" + r101.speed + ", speedAccuracy=" + r101.speedAccuracy + ", bearing=" + r101.bearing + ", bearingAccuracy=" + r101.bearingAccuracy + ", sourceType=" + r101.sourceType;
    }

    private final String formatImu(SensorBatch r100) {
        SensorBatch.ImuStruct r101 = r100.imu;
        if (r101 == null) goto L23;
        StringBuilder r102 = new StringBuilder("accelerometer=");
        SensorBatch.AxisSamples r103 = r101.accelerometer;
        int r104 = 0;
        if (r103 == null) goto L9;
        long[] r105 = r103.timestampMs;
        if (r105 == null) goto L9;
        int r106 = r105.length;
    L10:
        r102.append(r106);
        r102.append(", gyroscope=");
        SensorBatch.AxisSamples r107 = r101.gyroscope;
        if (r107 == null) goto L15;
        long[] r108 = r107.timestampMs;
        if (r108 == null) goto L15;
        int r109 = r108.length;
    L16:
        r102.append(r109);
        r102.append(", magnetometer=");
        SensorBatch.AxisSamples r110 = r101.magnetometer;
        if (r110 == null) goto L21;
        long[] r111 = r110.timestampMs;
        if (r111 == null) goto L21;
        r104 = r111.length;
    L21:
        r102.append(r104);
        return r102.toString();
    L15:
        r109 = 0;
    L9:
        r106 = 0;
        goto L10
    L23:
        return "null";
    }

    private final String formatNavigationHint(SensorBatch r100) {
        WalkingCyclingNavigationHint r101 = r100.walkingCyclingNavigationHint;
        if (r101 != null) goto L5;
        return "null";
    L5:
        return "valid=" + r101.valid + ", navigationCode=" + r101.navigationCode + ", projectionBearing=" + r101.projectionBearing;
    }

    private final String formatTimestamp(long r100) {
        SimpleDateFormat r101 = TIME_FORMAT;
        monitor-enter(r101);
        String r102 = r101.format(new Date(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    private final String formatWheel(SensorBatch r100) {
        SensorBatch.WheelTick r101 = r100.wheel;
        if (r101 != null) goto L5;
        return "null";
    L5:
        return "timestampMs=" + r101.timestampMs + ", ticks=" + r101.ticks + ", wheelId=" + r101.wheelId;
    }

    public final void logSensorBatchPush(String r100, boolean r101, SensorBatch r102) {
        StringBuilder r103 = new StringBuilder("BYTE_FUSION_CONTINUOUS_CHAIN pushSensorBatch: navInstanceId=");
        r103.append(r100);
        r103.append(", sourceFunction=pushSensorBatch, timestamp=");
        r103.append(formatTimestamp$default(this, 0, 1, null));
        r103.append(", result=");
        r103.append(r101);
        r103.append(", begin=");
        r103.append(r102.tBegin);
        r103.append(", end=");
        r103.append(r102.tEnd);
        r103.append(", imu=");
        r103.append(formatImu(r102));
        r103.append(", gps=");
        r103.append(formatGpsWithoutLatLng(r102));
        r103.append(", sensorHeading=");
        r103.append(r102.sensorHeading);
        r103.append(", magneticDeclination=");
        r103.append(r102.magneticDeclination);
        r103.append(", meas=");
        r103.append(formatGnssMeasurement(r102));
        r103.append(", baroSize=");
        SensorBatch.BarometerData r104 = r102.baro;
        int r105 = 0;
        if (r104 == null) goto L7;
        long[] r106 = r104.timestampMs;
        if (r106 == null) goto L7;
        int r107 = r106.length;
    L8:
        r103.append(r107);
        r103.append(", lightSize=");
        SensorBatch.LightData r108 = r102.light;
        if (r108 == null) goto L13;
        long[] r109 = r108.timestampMs;
        if (r109 == null) goto L13;
        int r110 = r109.length;
    L14:
        r103.append(r110);
        r103.append(", tempSize=");
        SensorBatch.TempData r111 = r102.temp;
        if (r111 == null) goto L19;
        long[] r112 = r111.timestampMs;
        if (r112 == null) goto L19;
        r105 = r112.length;
    L19:
        r103.append(r105);
        r103.append(", wheel=");
        r103.append(formatWheel(r102));
        r103.append(", dop=");
        r103.append(formatDop(r102));
        r103.append(", satelliteCount=");
        r103.append(r102.satelliteCount);
        r103.append(", navigationHint=");
        r103.append(formatNavigationHint(r102));
        Logger.i(TAG, r103.toString());
        return;
    L13:
        r110 = 0;
    L7:
        r107 = 0;
        goto L8
    }

    public static /* synthetic */ String formatTimestamp$default(ByteFusionContinuousLocationObserver r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = System.currentTimeMillis();
    L6:
        return r100.formatTimestamp(r101);
    }

    public final void logKeyNode(String r100, String r101, String r102, Throwable r103) {
        String r104 = "BYTE_FUSION_CONTINUOUS_CHAIN stage=" + r100 + ", navInstanceId=" + r101 + ", " + r102;
        if (r103 != null) goto L5;
        Logger.i(TAG, r104);
        return;
    L5:
        Logger.e(TAG, r104, r103);
    }

    public static /* synthetic */ void logKeyNode$default(ByteFusionContinuousLocationObserver r100, String r101, String r102, String r103, Throwable r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = null;
    L5:
        r100.logKeyNode(r101, r102, r103, r104);
    }
}
