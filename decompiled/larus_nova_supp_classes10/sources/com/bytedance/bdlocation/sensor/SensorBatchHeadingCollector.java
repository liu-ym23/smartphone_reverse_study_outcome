package com.bytedance.bdlocation.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
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
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L16;
        Sensor r3 = this.registeredSensor;
        if (r3 != null) goto L18;
        return;
    L18:
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r1, this.sensorListener, r3);     // Catch: Throwable -> L8
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

    public static final /* synthetic */ SensorBatchHeadingCallback access$getCallback$p(SensorBatchHeadingCollector r0) {
        return r0.callback;
    }

    public static final /* synthetic */ Function0 access$getMagneticDeclinationProvider$p(SensorBatchHeadingCollector r0) {
        return r0.magneticDeclinationProvider;
    }

    private final boolean isFinite(double r2) {
        if (Double.isNaN(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isInfinite(r2) == true) goto L7;
        return true;
    }

    private final float normalizeDegrees(float r2) {
        return MathKt.roundToInt((((r2 % 360.0f) + 360.0f) % 360.0f) * 100.0f) / 100.0f;
    }

    private final float getHeadingDegrees(float[] r24, float r25) {
        if (r24.length < 3) goto L38;
        double r4 = r24[0];
        double r6 = r24[1];
        double r8 = r24[2];
        if (isFinite(r4) == false) goto L36;
        if (isFinite(r6) == false) goto L36;
        if (isFinite(r8) == false) goto L36;
        if (r24.length < 4) goto L13;
        double r1 = r24[3];
    L15:
        if (isFinite(r1) == false) goto L34;
        double r13 = Math.sqrt((((r1 * r1) + (r4 * r4)) + (r6 * r6)) + (r8 * r8));
        if (r13 < 1.0E-12d) goto L32;
        double r2 = r1 / r13;
        double r5 = r4 / r13;
        double r7 = r6 / r13;
        double r9 = r8 / r13;
        double r14 = ((r5 * r7) - (r2 * r9)) * 2.0d;
        double r11 = ((r5 * r9) + (r2 * r7)) * 2.0d;
        double r17 = 1.0d - (((r5 * r5) + (r9 * r9)) * 2.0d);
        double r10 = r7 * r9;
        double r3 = r2 * r5;
        double r12 = (r10 - r3) * 2.0d;
        double r15 = Math.asin(Math.max(-1.0d, Math.min(1.0d, (r10 + r3) * 2.0d)));
        double r16 = Math.toRadians(45.0d);
        if (r15 <= r16) goto L22;
        double r18 = -r11;
        double r19 = -r12;
    L26:
        if (Math.hypot(r18, r19) < 1.0E-9d) goto L30;
        return normalizeDegrees(-((float) Math.toDegrees(Math.atan2(-r18, r19) - Math.toRadians(r25))));
    L30:
        throw new IllegalArgumentException("rotation vector cannot provide stable horizontal heading");
    L22:
        if (r15 >= (-r16)) goto L24;
        r19 = r12;
        r18 = r11;
        goto L26
    L24:
        r19 = r17;
        r18 = r14;
        goto L26
    L32:
        throw new IllegalArgumentException("rotation vector quaternion norm is too small");
    L34:
        throw new IllegalArgumentException("rotation vector w is invalid");
    L13:
        r1 = Math.sqrt(Math.max(0.0d, ((1.0d - (r4 * r4)) - (r6 * r6)) - (r8 * r8)));
    L36:
        throw new IllegalArgumentException("rotation vector contains NaN or infinity");
    L38:
        throw new IllegalArgumentException("rotation vector requires at least x, y and z");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.bdlocation.sensor.SensorBatchHeadingCollector$sensorListener$1] */
    public SensorBatchHeadingCollector(SensorManager r1, Function0<Float> r2, SensorBatchHeadingCallback r3) {
        this.sensorManager = r1;
        this.magneticDeclinationProvider = r2;
        this.callback = r3;
        this.sensorListener = new SensorBatchHeadingCollector$sensorListener$1(this);
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2, Sensor r3) {
        if (g.d() == true) goto L6;
        r1.unregisterListener(r2, r3);
        return;
    L6:
        r1.unregisterListener(r2, r3);
        int r0 = 0;
        if (r2 == null) goto L9;
        int r4 = r2.hashCode();
    L10:
        if (r3 == null) goto L12;
        r0 = r3.hashCode();
    L12:
        b.c(new a(r4, Integer.valueOf(r0)));
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public static final /* synthetic */ float access$getHeadingDegrees(SensorBatchHeadingCollector r0, float[] r1, float r2) {
        return r0.getHeadingDegrees(r1, r2);
    }

    public final void start(int r6, Handler r7, Object r8) {
        SensorManager r1 = this.sensorManager;
        if (r1 != null) goto L17;
        Logger.w(TAG, "start: sensorManager is null");
        return;
    L17:
        Sensor r9 = BDLocationExtrasService.getBPEAManager().getDefaultSensor(r1, 11, r8);     // Catch: Throwable -> L12
        if (r9 != null) goto L8;
        Logger.w(TAG, "start: TYPE_ROTATION_VECTOR sensor not found");     // Catch: Throwable -> L12
        return;
    L8:
        boolean r10 = INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(r1, this.sensorListener, r9, r6, r7);     // Catch: Throwable -> L12
        Logger.i(TAG, "start: registered=" + r10 + ", name=" + r9.getName() + ", vendor=" + r9.getVendor());     // Catch: Throwable -> L12
        if (r10 == false) goto L18;
        this.registeredSensor = r9;     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        Logger.e(TAG, "start: register TYPE_ROTATION_VECTOR failed", th);
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchHeadingCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r2, SensorEventListener r3, Sensor r4, int r5, Handler r6) {
        if (g.d() == true) goto L6;
        Boolean r7 = Boolean.valueOf(r2.registerListener(r3, r4, r5, r6));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        return r7.booleanValue();
    L6:
        Boolean r8 = Boolean.valueOf(r2.registerListener(r3, r4, r5, r6));
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r9 = r8.booleanValue();
        int r10 = 0;
        if (r3 == null) goto L9;
        int r11 = r3.hashCode();
    L10:
        if (r4 == null) goto L12;
        r10 = r4.hashCode();
    L12:
        b.a(new a(r11, Integer.valueOf(r10)));
        return r9;
    L9:
        r11 = 0;
        goto L10
    }
}
