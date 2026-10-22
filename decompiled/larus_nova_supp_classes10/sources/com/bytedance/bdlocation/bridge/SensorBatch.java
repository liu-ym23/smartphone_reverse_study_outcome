package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class SensorBatch {
    public final BarometerData baro;
    public final DopInfo dopInfo;
    public final GpsStruct gps;
    public final ImuStruct imu;
    public final LightData light;
    public final float magneticDeclination;
    public final GnssMeasurement meas;
    public final int satelliteCount;
    public final float sensorHeading;
    public final long tBegin;
    public final long tEnd;
    public final TempData temp;
    public final WalkingCyclingNavigationHint walkingCyclingNavigationHint;
    public final WheelTick wheel;

    public static final class AxisSamples {
        public final long[] timestampMs;
        public final float[] x;
        public final float[] y;
        public final float[] z;

        public AxisSamples(long[] r2, float[] r3, float[] r4, float[] r5) {
            if (r2 != null) goto L5;
            long[] r6 = new long[0];
        L6:
            this.timestampMs = r6;
            if (r3 != null) goto L9;
            float[] r7 = new float[0];
        L10:
            this.x = r7;
            if (r4 != null) goto L13;
            float[] r8 = new float[0];
        L14:
            this.y = r8;
            if (r5 != null) goto L17;
            float[] r9 = new float[0];
        L18:
            this.z = r9;
            return;
        L17:
            r9 = (float[]) r5.clone();
            goto L18
        L13:
            r8 = (float[]) r4.clone();
            goto L14
        L9:
            r7 = (float[]) r3.clone();
            goto L10
        L5:
            r6 = (long[]) r2.clone();
            goto L6
        }
    }

    public static final class BarometerData {
        public final float[] pressureHpa;
        public final long[] timestampMs;

        public static BarometerData empty() {
            return new BarometerData(null, null);
        }

        public BarometerData(long[] r2, float[] r3) {
            if (r2 != null) goto L5;
            long[] r4 = new long[0];
        L6:
            this.timestampMs = r4;
            if (r3 != null) goto L9;
            float[] r5 = new float[0];
        L10:
            this.pressureHpa = r5;
            return;
        L9:
            r5 = (float[]) r3.clone();
            goto L10
        L5:
            r4 = (long[]) r2.clone();
            goto L6
        }
    }

    public static final class DopInfo {
        public final float hdop;
        public final float pdop;
        public final long timestampMs;
        public final float vdop;

        public static DopInfo empty() {
            return new DopInfo(0, 0.0f, 0.0f, 0.0f);
        }

        public DopInfo(long r1, float r3, float r4, float r5) {
            this.timestampMs = r1;
            this.hdop = r3;
            this.vdop = r4;
            this.pdop = r5;
        }
    }

    public static final class GnssMeasurement {
        public final int[] adrState;
        public final float[] azimuthDeg;
        public final double[] carrierPhaseCycles;
        public final float[] cn0Dbhz;
        public final int[] constellationType;
        public final double[] dopplerHz;
        public final float[] elevationDeg;
        public final long[] gnssTimeNs;
        public final double[] pseudorangeM;
        public final int[] signalSyncState;
        public final int[] svid;
        public final long[] systemTimeNs;
        public final boolean[] usedInFix;

        public static GnssMeasurement empty() {
            return new GnssMeasurement(null, null, null, null, null, null, null, null, null, null, null, null, null);
        }

        public GnssMeasurement(int[] r2, int[] r3, double[] r4, double[] r5, double[] r6, float[] r7, long[] r8, long[] r9, int[] r10, int[] r11, float[] r12, float[] r13, boolean[] r14) {
            if (r2 != null) goto L5;
            int[] r15 = new int[0];
        L6:
            this.svid = r15;
            if (r3 != null) goto L9;
            int[] r16 = new int[0];
        L10:
            this.constellationType = r16;
            if (r4 != null) goto L13;
            double[] r17 = new double[0];
        L14:
            this.pseudorangeM = r17;
            if (r5 != null) goto L17;
            double[] r18 = new double[0];
        L18:
            this.carrierPhaseCycles = r18;
            if (r6 != null) goto L21;
            double[] r19 = new double[0];
        L22:
            this.dopplerHz = r19;
            if (r7 != null) goto L25;
            float[] r20 = new float[0];
        L26:
            this.cn0Dbhz = r20;
            if (r8 != null) goto L29;
            long[] r21 = new long[0];
        L30:
            this.gnssTimeNs = r21;
            if (r9 != null) goto L33;
            long[] r22 = new long[0];
        L34:
            this.systemTimeNs = r22;
            if (r10 != null) goto L37;
            int[] r23 = new int[0];
        L38:
            this.signalSyncState = r23;
            if (r11 != null) goto L41;
            int[] r24 = new int[0];
        L42:
            this.adrState = r24;
            if (r12 != null) goto L45;
            float[] r25 = new float[0];
        L46:
            this.elevationDeg = r25;
            if (r13 != null) goto L49;
            float[] r26 = new float[0];
        L50:
            this.azimuthDeg = r26;
            if (r14 != null) goto L53;
            boolean[] r27 = new boolean[0];
        L54:
            this.usedInFix = r27;
            return;
        L53:
            r27 = (boolean[]) r14.clone();
            goto L54
        L49:
            r26 = (float[]) r13.clone();
            goto L50
        L45:
            r25 = (float[]) r12.clone();
            goto L46
        L41:
            r24 = (int[]) r11.clone();
            goto L42
        L37:
            r23 = (int[]) r10.clone();
            goto L38
        L33:
            r22 = (long[]) r9.clone();
            goto L34
        L29:
            r21 = (long[]) r8.clone();
            goto L30
        L25:
            r20 = (float[]) r7.clone();
            goto L26
        L21:
            r19 = (double[]) r6.clone();
            goto L22
        L17:
            r18 = (double[]) r5.clone();
            goto L18
        L13:
            r17 = (double[]) r4.clone();
            goto L14
        L9:
            r16 = (int[]) r3.clone();
            goto L10
        L5:
            r15 = (int[]) r2.clone();
            goto L6
        }
    }

    public static final class GpsStruct {
        public static final int BASE_STATION = 3;
        public static final int CACHE = 5;
        public static final int COARSE = 11;
        public static final int FUSION_DR = 14;
        public static final int FUSION_GPS = 13;
        public static final int GPS = 1;
        public static final int IP = 6;
        public static final int LAST_CACHE = 10;
        public static final int MCC = 7;
        public static final int NETWORK = 4;
        public static final int OFFLINE = 9;
        public static final int PREVIOUS = 8;
        public static final int WIFI = 2;
        public final float bearing;
        public final float bearingAccuracy;
        public final double lat;
        public final float locationAccuracy;
        public final long locationTimestampMs;
        public final double lon;
        public final int sourceType;
        public final float speed;
        public final float speedAccuracy;
        public final long timestampMs;

        public static GpsStruct empty() {
            return new GpsStruct(0, 0, 0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1);
        }

        public GpsStruct(long r1, long r3, double r5, double r7, float r9, float r10, float r11, float r12, float r13, int r14) {
            this.locationTimestampMs = r1;
            this.timestampMs = r3;
            this.lat = r5;
            this.lon = r7;
            this.locationAccuracy = r9;
            this.speed = r10;
            this.speedAccuracy = r11;
            this.bearing = r12;
            this.bearingAccuracy = r13;
            this.sourceType = r14;
        }
    }

    public static final class ImuStruct {
        public final AxisSamples accelerometer;
        public final AxisSamples gyroscope;
        public final AxisSamples magnetometer;

        public ImuStruct(AxisSamples r1, AxisSamples r2, AxisSamples r3) {
            this.accelerometer = r1;
            this.gyroscope = r2;
            this.magnetometer = r3;
        }
    }

    public static final class LightData {
        public final float[] lux;
        public final long[] timestampMs;

        public static LightData empty() {
            return new LightData(null, null);
        }

        public LightData(long[] r2, float[] r3) {
            if (r2 != null) goto L5;
            long[] r4 = new long[0];
        L6:
            this.timestampMs = r4;
            if (r3 != null) goto L9;
            float[] r5 = new float[0];
        L10:
            this.lux = r5;
            return;
        L9:
            r5 = (float[]) r3.clone();
            goto L10
        L5:
            r4 = (long[]) r2.clone();
            goto L6
        }
    }

    public static final class TempData {
        public final float[] tempCelsius;
        public final long[] timestampMs;

        public static TempData empty() {
            return new TempData(null, null);
        }

        public TempData(long[] r2, float[] r3) {
            if (r2 != null) goto L5;
            long[] r4 = new long[0];
        L6:
            this.timestampMs = r4;
            if (r3 != null) goto L9;
            float[] r5 = new float[0];
        L10:
            this.tempCelsius = r5;
            return;
        L9:
            r5 = (float[]) r3.clone();
            goto L10
        L5:
            r4 = (long[]) r2.clone();
            goto L6
        }
    }

    public static final class WheelTick {
        public final int ticks;
        public final long timestampMs;
        public final int wheelId;

        public static WheelTick empty() {
            return new WheelTick(0, 0, 0);
        }

        public WheelTick(long r1, int r3, int r4) {
            this.timestampMs = r1;
            this.ticks = r3;
            this.wheelId = r4;
        }
    }

    public SensorBatch(long r15, long r17, ImuStruct r19, GpsStruct r20, WheelTick r21, GnssMeasurement r22, BarometerData r23, LightData r24, TempData r25) {
        this(r15, r17, r19, r20, 0.0f, 0.0f, r21, r22, r23, r24, r25);
    }

    public SensorBatch(long r16, long r18, ImuStruct r20, GpsStruct r21, float r22, float r23, WheelTick r24, GnssMeasurement r25, BarometerData r26, LightData r27, TempData r28) {
        this(r16, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, null);
    }

    public SensorBatch(long r18, long r20, ImuStruct r22, GpsStruct r23, float r24, float r25, WheelTick r26, GnssMeasurement r27, BarometerData r28, LightData r29, TempData r30, DopInfo r31) {
        this(r18, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, -1, null);
    }

    public SensorBatch(long r18, long r20, ImuStruct r22, GpsStruct r23, float r24, float r25, WheelTick r26, GnssMeasurement r27, BarometerData r28, LightData r29, TempData r30, DopInfo r31, int r32) {
        this(r18, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, null);
    }

    public SensorBatch(long r4, long r6, ImuStruct r8, GpsStruct r9, float r10, float r11, WheelTick r12, GnssMeasurement r13, BarometerData r14, LightData r15, TempData r16, DopInfo r17, int r18, WalkingCyclingNavigationHint r19) {
        this.tBegin = r4;
        this.tEnd = r6;
        this.imu = r8;
        this.gps = r9;
        this.sensorHeading = r10;
        this.magneticDeclination = r11;
        this.wheel = r12;
        this.meas = r13;
        this.baro = r14;
        this.light = r15;
        this.temp = r16;
        this.dopInfo = r17;
        this.satelliteCount = r18;
        this.walkingCyclingNavigationHint = r19;
    }
}
