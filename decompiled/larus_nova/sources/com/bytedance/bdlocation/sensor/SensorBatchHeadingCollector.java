package com.bytedance.bdlocation.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import fna.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u0018\u0000 !2\u00020\u0001:\u0001!B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0006\u0010 \u001a\u00020\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchHeadingCollector;", "", "sensorManager", "Landroid/hardware/SensorManager;", "magneticDeclinationProvider", "Lkotlin/Function0;", "", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchHeadingCallback;", "(Landroid/hardware/SensorManager;Lkotlin/jvm/functions/Function0;Lcom/bytedance/bdlocation/sensor/SensorBatchHeadingCallback;)V", "registeredSensor", "Landroid/hardware/Sensor;", "sensorListener", "com/bytedance/bdlocation/sensor/SensorBatchHeadingCollector$sensorListener$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchHeadingCollector$sensorListener$1;", "getHeadingDegrees", "values", "", "magneticDeclinationDeg", "isFinite", "", "value", "", "normalizeDegrees", "degrees", "start", "", "samplingPeriodUs", "", "handler", "Landroid/os/Handler;", "bpeaCert", "stop", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchHeadingCollector {
    public static final Companion Companion = null;
    public static final double MIN_HEADING_PROJECTION_NORM = 1.0E-9d;
    public static final double MIN_QUATERNION_NORM = 1.0E-12d;
    public static final String TAG = "SSS-HeadingCollector";
    private final SensorBatchHeadingCallback callback;
    private final Function0<Float> magneticDeclinationProvider;
    private Sensor registeredSensor;
    private final SensorBatchHeadingCollector$sensorListener$1 sensorListener;
    private final SensorManager sensorManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchHeadingCollector$Companion;", "", "()V", "MIN_HEADING_PROJECTION_NORM", "", "MIN_QUATERNION_NORM", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public final void stop() {
        SensorManager r100 = this.sensorManager;
        if (r100 == null) goto L16;
        Sensor r101 = this.registeredSensor;
        if (r101 != null) goto L18;
        return;
    L18:
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r100, this.sensorListener, r101);     // Catch: Throwable -> L8
        Logger.i(TAG, "stop");     // Catch: Throwable -> L8
    L10:
        this.registeredSensor = null;
        return;
    L8:
        th = move-exception;
        Logger.e(TAG, "stop: unregister TYPE_ROTATION_VECTOR failed", th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.registeredSensor = null;
        throw th;
    L16:
        this.registeredSensor = null;
    }

    public static final /* synthetic */ SensorBatchHeadingCallback access$getCallback$p(SensorBatchHeadingCollector r100) {
        return r100.callback;
    }

    public static final /* synthetic */ Function0 access$getMagneticDeclinationProvider$p(SensorBatchHeadingCollector r100) {
        return r100.magneticDeclinationProvider;
    }

    private final boolean isFinite(double r100) {
        if (Double.isNaN(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isInfinite(r100) == true) goto L7;
        return true;
    }

    private final float normalizeDegrees(float r100) {
        return MathKt.roundToInt((((r100 % 360.0f) + 360.0f) % 360.0f) * 100.0f) / 100.0f;
    }

    private final float getHeadingDegrees(float[] r210, float r211) {
        if (r210.length < 3) goto L38;
        double r100 = r210[0];
        double r101 = r210[1];
        double r102 = r210[2];
        if (isFinite(r100) == false) goto L36;
        if (isFinite(r101) == false) goto L36;
        if (isFinite(r102) == false) goto L36;
        if (r210.length < 4) goto L13;
        double r103 = r210[3];
    L15:
        if (isFinite(r103) == false) goto L34;
        double r110 = Math.sqrt((((r103 * r103) + (r100 * r100)) + (r101 * r101)) + (r102 * r102));
        if (r110 < 1.0E-12d) goto L32;
        double r104 = r103 / r110;
        double r105 = r100 / r110;
        double r106 = r101 / r110;
        double r107 = r102 / r110;
        double r111 = ((r105 * r106) - (r104 * r107)) * 2.0d;
        double r112 = ((r105 * r107) + (r104 * r106)) * 2.0d;
        double r113 = 1.0d - (((r105 * r105) + (r107 * r107)) * 2.0d);
        double r108 = r106 * r107;
        double r109 = r104 * r105;
        double r114 = (r108 - r109) * 2.0d;
        double r115 = Math.asin(Math.max(-1.0d, Math.min(1.0d, (r108 + r109) * 2.0d)));
        double r116 = Math.toRadians(45.0d);
        if (r115 <= r116) goto L22;
        double r117 = -r112;
        double r118 = -r114;
    L26:
        if (Math.hypot(r117, r118) < 1.0E-9d) goto L30;
        return normalizeDegrees(-((float) Math.toDegrees(Math.atan2(-r117, r118) - Math.toRadians(r211))));
    L30:
        throw new IllegalArgumentException("rotation vector cannot provide stable horizontal heading");
    L22:
        if (r115 >= (-r116)) goto L24;
        r118 = r114;
        r117 = r112;
        goto L26
    L24:
        r118 = r113;
        r117 = r111;
        goto L26
    L32:
        throw new IllegalArgumentException("rotation vector quaternion norm is too small");
    L34:
        throw new IllegalArgumentException("rotation vector w is invalid");
    L13:
        r103 = Math.sqrt(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, ((1.0d - (r100 * r100)) - (r101 * r101)) - (r102 * r102)));
    L36:
        throw new IllegalArgumentException("rotation vector contains NaN or infinity");
    L38:
        throw new IllegalArgumentException("rotation vector requires at least x, y and z");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.bdlocation.sensor.SensorBatchHeadingCollector$sensorListener$1] */
    public SensorBatchHeadingCollector(SensorManager r100, Function0<Float> r101, SensorBatchHeadingCallback r102) {
        this.sensorManager = r100;
        this.magneticDeclinationProvider = r101;
        this.callback = r102;
        this.sensorListener = new SensorBatchHeadingCollector$sensorListener$1(this);
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101, Sensor r102) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101, r102);
        return;
    L6:
        r100.unregisterListener(r101, r102);
        int r103 = 0;
        if (r101 == null) goto L9;
        int r104 = r101.hashCode();
    L10:
        if (r102 == null) goto L12;
        r103 = r102.hashCode();
    L12:
        b.c(new a(r104, Integer.valueOf(r103)));
        return;
    L9:
        r104 = 0;
        goto L10
    }

    public static final /* synthetic */ float access$getHeadingDegrees(SensorBatchHeadingCollector r100, float[] r101, float r102) {
        return r100.getHeadingDegrees(r101, r102);
    }

    public final void start(int r100, Handler r101, Object r102) {
        SensorManager r103 = this.sensorManager;
        if (r103 != null) goto L17;
        Logger.w(TAG, "start: sensorManager is null");
        return;
    L17:
        Sensor r104 = BDLocationExtrasService.getBPEAManager().getDefaultSensor(r103, 11, r102);     // Catch: Throwable -> L12
        if (r104 != null) goto L8;
        Logger.w(TAG, "start: TYPE_ROTATION_VECTOR sensor not found");     // Catch: Throwable -> L12
        return;
    L8:
        boolean r105 = INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(r103, this.sensorListener, r104, r100, r101);     // Catch: Throwable -> L12
        Logger.i(TAG, "start: registered=" + r105 + ", name=" + r104.getName() + ", vendor=" + r104.getVendor());     // Catch: Throwable -> L12
        if (r105 == false) goto L18;
        this.registeredSensor = r104;     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        Logger.e(TAG, "start: register TYPE_ROTATION_VECTOR failed", th);
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r100, SensorEventListener r101, Sensor r102, int r103, Handler r104) {
        if (g.d() == true) goto L6;
        Boolean r105 = Boolean.valueOf(r100.registerListener(r101, r102, r103, r104));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        return r105.booleanValue();
    L6:
        Boolean r106 = Boolean.valueOf(r100.registerListener(r101, r102, r103, r104));
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r107 = r106.booleanValue();
        int r108 = 0;
        if (r101 == null) goto L9;
        int r109 = r101.hashCode();
    L10:
        if (r102 == null) goto L12;
        r108 = r102.hashCode();
    L12:
        b.a(new a(r109, Integer.valueOf(r108)));
        return r107;
    L9:
        r109 = 0;
        goto L10
    }
}
