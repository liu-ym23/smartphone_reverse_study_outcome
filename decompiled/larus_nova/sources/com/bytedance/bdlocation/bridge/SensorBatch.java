package com.bytedance.bdlocation.bridge;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes10.dex */
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

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final float[] f199827x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final float[] f199828y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final float[] f199829z;

        public AxisSamples(long[] r100, float[] r101, float[] r102, float[] r103) {
            if (r100 != null) goto L5;
            long[] r104 = new long[0];
        L6:
            this.timestampMs = r104;
            if (r101 != null) goto L9;
            float[] r105 = new float[0];
        L10:
            this.f199827x = r105;
            if (r102 != null) goto L13;
            float[] r106 = new float[0];
        L14:
            this.f199828y = r106;
            if (r103 != null) goto L17;
            float[] r107 = new float[0];
        L18:
            this.f199829z = r107;
            return;
        L17:
            r107 = (float[]) r103.clone();
            goto L18
        L13:
            r106 = (float[]) r102.clone();
            goto L14
        L9:
            r105 = (float[]) r101.clone();
            goto L10
        L5:
            r104 = (long[]) r100.clone();
            goto L6
        }
    }

    public static final class BarometerData {
        public final float[] pressureHpa;
        public final long[] timestampMs;

        public static BarometerData empty() {
            return new BarometerData(null, null);
        }

        public BarometerData(long[] r100, float[] r101) {
            if (r100 != null) goto L5;
            long[] r102 = new long[0];
        L6:
            this.timestampMs = r102;
            if (r101 != null) goto L9;
            float[] r103 = new float[0];
        L10:
            this.pressureHpa = r103;
            return;
        L9:
            r103 = (float[]) r101.clone();
            goto L10
        L5:
            r102 = (long[]) r100.clone();
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

        public DopInfo(long r100, float r101, float r102, float r103) {
            this.timestampMs = r100;
            this.hdop = r101;
            this.vdop = r102;
            this.pdop = r103;
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

        public GnssMeasurement(int[] r100, int[] r101, double[] r102, double[] r103, double[] r104, float[] r105, long[] r106, long[] r107, int[] r110, int[] r111, float[] r112, float[] r113, boolean[] r114) {
            if (r100 != null) goto L5;
            int[] r108 = new int[0];
        L6:
            this.svid = r108;
            if (r101 != null) goto L9;
            int[] r109 = new int[0];
        L10:
            this.constellationType = r109;
            if (r102 != null) goto L13;
            double[] r115 = new double[0];
        L14:
            this.pseudorangeM = r115;
            if (r103 != null) goto L17;
            double[] r116 = new double[0];
        L18:
            this.carrierPhaseCycles = r116;
            if (r104 != null) goto L21;
            double[] r117 = new double[0];
        L22:
            this.dopplerHz = r117;
            if (r105 != null) goto L25;
            float[] r118 = new float[0];
        L26:
            this.cn0Dbhz = r118;
            if (r106 != null) goto L29;
            long[] r119 = new long[0];
        L30:
            this.gnssTimeNs = r119;
            if (r107 != null) goto L33;
            long[] r120 = new long[0];
        L34:
            this.systemTimeNs = r120;
            if (r110 != null) goto L37;
            int[] r121 = new int[0];
        L38:
            this.signalSyncState = r121;
            if (r111 != null) goto L41;
            int[] r122 = new int[0];
        L42:
            this.adrState = r122;
            if (r112 != null) goto L45;
            float[] r123 = new float[0];
        L46:
            this.elevationDeg = r123;
            if (r113 != null) goto L49;
            float[] r124 = new float[0];
        L50:
            this.azimuthDeg = r124;
            if (r114 != null) goto L53;
            boolean[] r125 = new boolean[0];
        L54:
            this.usedInFix = r125;
            return;
        L53:
            r125 = (boolean[]) r114.clone();
            goto L54
        L49:
            r124 = (float[]) r113.clone();
            goto L50
        L45:
            r123 = (float[]) r112.clone();
            goto L46
        L41:
            r122 = (int[]) r111.clone();
            goto L42
        L37:
            r121 = (int[]) r110.clone();
            goto L38
        L33:
            r120 = (long[]) r107.clone();
            goto L34
        L29:
            r119 = (long[]) r106.clone();
            goto L30
        L25:
            r118 = (float[]) r105.clone();
            goto L26
        L21:
            r117 = (double[]) r104.clone();
            goto L22
        L17:
            r116 = (double[]) r103.clone();
            goto L18
        L13:
            r115 = (double[]) r102.clone();
            goto L14
        L9:
            r109 = (int[]) r101.clone();
            goto L10
        L5:
            r108 = (int[]) r100.clone();
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
            return new GpsStruct(0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1);
        }

        public GpsStruct(long r100, long r101, double r102, double r103, float r104, float r110, float r111, float r112, float r113, int r114) {
            this.locationTimestampMs = r100;
            this.timestampMs = r101;
            this.lat = r102;
            this.lon = r103;
            this.locationAccuracy = r104;
            this.speed = r110;
            this.speedAccuracy = r111;
            this.bearing = r112;
            this.bearingAccuracy = r113;
            this.sourceType = r114;
        }
    }

    public static final class ImuStruct {
        public final AxisSamples accelerometer;
        public final AxisSamples gyroscope;
        public final AxisSamples magnetometer;

        public ImuStruct(AxisSamples r100, AxisSamples r101, AxisSamples r102) {
            this.accelerometer = r100;
            this.gyroscope = r101;
            this.magnetometer = r102;
        }
    }

    public static final class LightData {
        public final float[] lux;
        public final long[] timestampMs;

        public static LightData empty() {
            return new LightData(null, null);
        }

        public LightData(long[] r100, float[] r101) {
            if (r100 != null) goto L5;
            long[] r102 = new long[0];
        L6:
            this.timestampMs = r102;
            if (r101 != null) goto L9;
            float[] r103 = new float[0];
        L10:
            this.lux = r103;
            return;
        L9:
            r103 = (float[]) r101.clone();
            goto L10
        L5:
            r102 = (long[]) r100.clone();
            goto L6
        }
    }

    public static final class TempData {
        public final float[] tempCelsius;
        public final long[] timestampMs;

        public static TempData empty() {
            return new TempData(null, null);
        }

        public TempData(long[] r100, float[] r101) {
            if (r100 != null) goto L5;
            long[] r102 = new long[0];
        L6:
            this.timestampMs = r102;
            if (r101 != null) goto L9;
            float[] r103 = new float[0];
        L10:
            this.tempCelsius = r103;
            return;
        L9:
            r103 = (float[]) r101.clone();
            goto L10
        L5:
            r102 = (long[]) r100.clone();
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

        public WheelTick(long r100, int r101, int r102) {
            this.timestampMs = r100;
            this.ticks = r101;
            this.wheelId = r102;
        }
    }

    public SensorBatch(long r110, long r111, ImuStruct r112, GpsStruct r210, WheelTick r211, GnssMeasurement r212, BarometerData r213, LightData r214, TempData r215) {
        this(r110, r111, r112, r210, 0.0f, 0.0f, r211, r212, r213, r214, r215);
    }

    public SensorBatch(long r110, long r111, ImuStruct r210, GpsStruct r211, float r212, float r213, WheelTick r214, GnssMeasurement r215, BarometerData r216, LightData r217, TempData r218) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, null);
    }

    public SensorBatch(long r110, long r210, ImuStruct r211, GpsStruct r212, float r213, float r214, WheelTick r215, GnssMeasurement r216, BarometerData r217, LightData r218, TempData r310, DopInfo r311) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, -1, null);
    }

    public SensorBatch(long r110, long r210, ImuStruct r211, GpsStruct r212, float r213, float r214, WheelTick r215, GnssMeasurement r216, BarometerData r217, LightData r218, TempData r310, DopInfo r311, int r312) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, null);
    }

    public SensorBatch(long r100, long r101, ImuStruct r102, GpsStruct r103, float r110, float r111, WheelTick r112, GnssMeasurement r113, BarometerData r114, LightData r115, TempData r116, DopInfo r117, int r118, WalkingCyclingNavigationHint r119) {
        this.tBegin = r100;
        this.tEnd = r101;
        this.imu = r102;
        this.gps = r103;
        this.sensorHeading = r110;
        this.magneticDeclination = r111;
        this.wheel = r112;
        this.meas = r113;
        this.baro = r114;
        this.light = r115;
        this.temp = r116;
        this.dopInfo = r117;
        this.satelliteCount = r118;
        this.walkingCyclingNavigationHint = r119;
    }
}
