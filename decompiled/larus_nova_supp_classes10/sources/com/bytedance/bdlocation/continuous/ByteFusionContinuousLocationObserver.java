package com.bytedance.bdlocation.continuous;

import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.bridge.WalkingCyclingNavigationHint;
import com.bytedance.bdlocation.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationObserver;", "", "()V", "formatDop", "", "batch", "Lcom/bytedance/bdlocation/bridge/SensorBatch;", "formatGnssMeasurement", "formatGpsWithoutLatLng", "formatImu", "formatNavigationHint", "formatTimestamp", "timestampMs", "", "formatWheel", "logKeyNode", "", "stage", "navInstanceId", "message", "throwable", "", "logSensorBatchPush", "pushResult", "", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionContinuousLocationObserver {
    public static final Companion Companion = null;
    private static final String TAG = "ByteFusionContinuous";
    private static final SimpleDateFormat TIME_FORMAT = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationObserver$Companion;", "", "()V", "TAG", "", "TIME_FORMAT", "Ljava/text/SimpleDateFormat;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public ByteFusionContinuousLocationObserver() {
    }

    static {
        Companion = new Companion(null);
        TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
    }

    private final String formatDop(SensorBatch r3) {
        SensorBatch.DopInfo r4 = r3.dopInfo;
        if (r4 != null) goto L5;
        return "null";
    L5:
        return "pdop=" + r4.pdop + ", hdop=" + r4.hdop + ", vdop=" + r4.vdop;
    }

    private final String formatGnssMeasurement(SensorBatch r4) {
        SensorBatch.GnssMeasurement r5 = r4.meas;
        if (r5 == null) goto L57;
        StringBuilder r0 = new StringBuilder("svidSize=");
        int[] r1 = r5.svid;
        int r2 = 0;
        if (r1 == null) goto L7;
        int r3 = r1.length;
    L8:
        r0.append(r3);
        r0.append(", constellationTypeSize=");
        int[] r6 = r5.constellationType;
        if (r6 == null) goto L11;
        int r7 = r6.length;
    L12:
        r0.append(r7);
        r0.append(", pseudorangeSize=");
        double[] r8 = r5.pseudorangeM;
        if (r8 == null) goto L15;
        int r9 = r8.length;
    L16:
        r0.append(r9);
        r0.append(", carrierPhaseSize=");
        double[] r10 = r5.carrierPhaseCycles;
        if (r10 == null) goto L19;
        int r11 = r10.length;
    L20:
        r0.append(r11);
        r0.append(", dopplerSize=");
        double[] r12 = r5.dopplerHz;
        if (r12 == null) goto L23;
        int r13 = r12.length;
    L24:
        r0.append(r13);
        r0.append(", cn0Size=");
        float[] r14 = r5.cn0Dbhz;
        if (r14 == null) goto L27;
        int r15 = r14.length;
    L28:
        r0.append(r15);
        r0.append(", gnssTimeSize=");
        long[] r16 = r5.gnssTimeNs;
        if (r16 == null) goto L31;
        int r17 = r16.length;
    L32:
        r0.append(r17);
        r0.append(", systemTimeSize=");
        long[] r18 = r5.systemTimeNs;
        if (r18 == null) goto L35;
        int r19 = r18.length;
    L36:
        r0.append(r19);
        r0.append(", signalSyncStateSize=");
        int[] r20 = r5.signalSyncState;
        if (r20 == null) goto L39;
        int r21 = r20.length;
    L40:
        r0.append(r21);
        r0.append(", adrStateSize=");
        int[] r22 = r5.adrState;
        if (r22 == null) goto L43;
        int r23 = r22.length;
    L44:
        r0.append(r23);
        r0.append(", elevationSize=");
        float[] r24 = r5.elevationDeg;
        if (r24 == null) goto L47;
        int r25 = r24.length;
    L48:
        r0.append(r25);
        r0.append(", azimuthSize=");
        float[] r26 = r5.azimuthDeg;
        if (r26 == null) goto L51;
        int r27 = r26.length;
    L52:
        r0.append(r27);
        r0.append(", usedInFixSize=");
        boolean[] r28 = r5.usedInFix;
        if (r28 == null) goto L55;
        r2 = r28.length;
    L55:
        r0.append(r2);
        return r0.toString();
    L51:
        r27 = 0;
        goto L52
    L47:
        r25 = 0;
        goto L48
    L43:
        r23 = 0;
        goto L44
    L39:
        r21 = 0;
        goto L40
    L35:
        r19 = 0;
        goto L36
    L31:
        r17 = 0;
        goto L32
    L27:
        r15 = 0;
        goto L28
    L23:
        r13 = 0;
        goto L24
    L19:
        r11 = 0;
        goto L20
    L15:
        r9 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r3 = 0;
        goto L8
    L57:
        return "null";
    }

    private final String formatGpsWithoutLatLng(SensorBatch r4) {
        SensorBatch.GpsStruct r5 = r4.gps;
        if (r5 != null) goto L5;
        return "null";
    L5:
        return "locationTimestampMs=" + r5.locationTimestampMs + ", timestampMs=" + r5.timestampMs + ", accuracy=" + r5.locationAccuracy + ", speed=" + r5.speed + ", speedAccuracy=" + r5.speedAccuracy + ", bearing=" + r5.bearing + ", bearingAccuracy=" + r5.bearingAccuracy + ", sourceType=" + r5.sourceType;
    }

    private final String formatImu(SensorBatch r4) {
        SensorBatch.ImuStruct r5 = r4.imu;
        if (r5 == null) goto L23;
        StringBuilder r0 = new StringBuilder("accelerometer=");
        SensorBatch.AxisSamples r1 = r5.accelerometer;
        int r2 = 0;
        if (r1 == null) goto L9;
        long[] r3 = r1.timestampMs;
        if (r3 == null) goto L9;
        int r6 = r3.length;
    L10:
        r0.append(r6);
        r0.append(", gyroscope=");
        SensorBatch.AxisSamples r7 = r5.gyroscope;
        if (r7 == null) goto L15;
        long[] r8 = r7.timestampMs;
        if (r8 == null) goto L15;
        int r9 = r8.length;
    L16:
        r0.append(r9);
        r0.append(", magnetometer=");
        SensorBatch.AxisSamples r10 = r5.magnetometer;
        if (r10 == null) goto L21;
        long[] r11 = r10.timestampMs;
        if (r11 == null) goto L21;
        r2 = r11.length;
    L21:
        r0.append(r2);
        return r0.toString();
    L15:
        r9 = 0;
    L9:
        r6 = 0;
        goto L10
    L23:
        return "null";
    }

    private final String formatNavigationHint(SensorBatch r3) {
        WalkingCyclingNavigationHint r4 = r3.walkingCyclingNavigationHint;
        if (r4 != null) goto L5;
        return "null";
    L5:
        return "valid=" + r4.valid + ", navigationCode=" + r4.navigationCode + ", projectionBearing=" + r4.projectionBearing;
    }

    private final String formatTimestamp(long r3) {
        SimpleDateFormat r0 = TIME_FORMAT;
        monitor-enter(r0);
        String r4 = r0.format(new Date(r3));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private final String formatWheel(SensorBatch r4) {
        SensorBatch.WheelTick r5 = r4.wheel;
        if (r5 != null) goto L5;
        return "null";
    L5:
        return "timestampMs=" + r5.timestampMs + ", ticks=" + r5.ticks + ", wheelId=" + r5.wheelId;
    }

    public final void logSensorBatchPush(String r5, boolean r6, SensorBatch r7) {
        StringBuilder r0 = new StringBuilder("BYTE_FUSION_CONTINUOUS_CHAIN pushSensorBatch: navInstanceId=");
        r0.append(r5);
        r0.append(", sourceFunction=pushSensorBatch, timestamp=");
        r0.append(formatTimestamp$default(this, 0, 1, null));
        r0.append(", result=");
        r0.append(r6);
        r0.append(", begin=");
        r0.append(r7.tBegin);
        r0.append(", end=");
        r0.append(r7.tEnd);
        r0.append(", imu=");
        r0.append(formatImu(r7));
        r0.append(", gps=");
        r0.append(formatGpsWithoutLatLng(r7));
        r0.append(", sensorHeading=");
        r0.append(r7.sensorHeading);
        r0.append(", magneticDeclination=");
        r0.append(r7.magneticDeclination);
        r0.append(", meas=");
        r0.append(formatGnssMeasurement(r7));
        r0.append(", baroSize=");
        SensorBatch.BarometerData r8 = r7.baro;
        int r9 = 0;
        if (r8 == null) goto L7;
        long[] r10 = r8.timestampMs;
        if (r10 == null) goto L7;
        int r11 = r10.length;
    L8:
        r0.append(r11);
        r0.append(", lightSize=");
        SensorBatch.LightData r12 = r7.light;
        if (r12 == null) goto L13;
        long[] r13 = r12.timestampMs;
        if (r13 == null) goto L13;
        int r14 = r13.length;
    L14:
        r0.append(r14);
        r0.append(", tempSize=");
        SensorBatch.TempData r15 = r7.temp;
        if (r15 == null) goto L19;
        long[] r16 = r15.timestampMs;
        if (r16 == null) goto L19;
        r9 = r16.length;
    L19:
        r0.append(r9);
        r0.append(", wheel=");
        r0.append(formatWheel(r7));
        r0.append(", dop=");
        r0.append(formatDop(r7));
        r0.append(", satelliteCount=");
        r0.append(r7.satelliteCount);
        r0.append(", navigationHint=");
        r0.append(formatNavigationHint(r7));
        Logger.i(TAG, r0.toString());
        return;
    L13:
        r14 = 0;
    L7:
        r11 = 0;
        goto L8
    }

    public static /* synthetic */ String formatTimestamp$default(ByteFusionContinuousLocationObserver r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis();
    L6:
        return r0.formatTimestamp(r1);
    }

    public final void logKeyNode(String r3, String r4, String r5, Throwable r6) {
        String r7 = "BYTE_FUSION_CONTINUOUS_CHAIN stage=" + r3 + ", navInstanceId=" + r4 + ", " + r5;
        if (r6 != null) goto L5;
        Logger.i(TAG, r7);
        return;
    L5:
        Logger.e(TAG, r7, r6);
    }

    public static /* synthetic */ void logKeyNode$default(ByteFusionContinuousLocationObserver r0, String r1, String r2, String r3, Throwable r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.logKeyNode(r1, r2, r3, r4);
    }
}
