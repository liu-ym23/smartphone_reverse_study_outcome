package com.bytedance.bdlocation.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import fna.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchScalarCollector;", "", "sensorManager", "Landroid/hardware/SensorManager;", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchScalarCallback;", "(Landroid/hardware/SensorManager;Lcom/bytedance/bdlocation/sensor/SensorBatchScalarCallback;)V", "registeredSensors", "", "Landroid/hardware/Sensor;", "sensorListener", "com/bytedance/bdlocation/sensor/SensorBatchScalarCollector$sensorListener$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchScalarCollector$sensorListener$1;", "registerSensor", "", "manager", "sensorType", "", "samplingPeriodUs", "handler", "Landroid/os/Handler;", "bpeaCert", "start", "startBarometer", "startLight", "startTemperature", "stop", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchScalarCollector {
    public static final Companion Companion = null;
    public static final String TAG = "SSS-ScalarCollector";
    private final SensorBatchScalarCallback callback;
    private final List<Sensor> registeredSensors;
    private final SensorBatchScalarCollector$sensorListener$1 sensorListener;
    private final SensorManager sensorManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchScalarCollector$Companion;", "", "()V", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
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

    public final void stop() {
        Logger.i(TAG, "stop: registeredSensors=" + this.registeredSensors.size());
        SensorManager r0 = this.sensorManager;
        if (r0 != null) goto L20;
        Logger.w(TAG, "stop: sensorManager is null");
        this.registeredSensors.clear();
        return;
    L20:
        Iterator<Sensor> r2 = this.registeredSensors.iterator();     // Catch: Throwable -> L9
    L6:
        if (r2.hasNext() == false) goto L11;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r0, this.sensorListener, r2.next());     // Catch: Throwable -> L9
    L11:
        this.registeredSensors.clear();
        return;
    L9:
        th = move-exception;
        Logger.e(TAG, "stop: unregisterListener failed", th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.registeredSensors.clear();
        throw th;
    }

    public static final /* synthetic */ SensorBatchScalarCallback access$getCallback$p(SensorBatchScalarCollector r0) {
        return r0.callback;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.bdlocation.sensor.SensorBatchScalarCollector$sensorListener$1] */
    public SensorBatchScalarCollector(SensorManager r1, SensorBatchScalarCallback r2) {
        this.sensorManager = r1;
        this.callback = r2;
        this.registeredSensors = new ArrayList();
        this.sensorListener = new SensorBatchScalarCollector$sensorListener$1(this);
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2, Sensor r3) {
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

    public final void start(int r9, Handler r10, Object r11) {
        Logger.i(TAG, "start: samplingPeriodUs=" + r9);
        SensorManager r0 = this.sensorManager;
        if (r0 == null) goto L6;
        registerSensor(r0, 6, r9, r10, r11);
        registerSensor(r0, 5, r9, r10, r11);
        registerSensor(r0, 13, r9, r10, r11);
        return;
    L6:
        Logger.w(TAG, "start: sensorManager is null");
    }

    public final void startBarometer(int r7, Handler r8, Object r9) {
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L6;
        registerSensor(r1, 6, r7, r8, r9);
        return;
    L6:
        Logger.w(TAG, "startBarometer: sensorManager is null");
    }

    public final void startLight(int r7, Handler r8, Object r9) {
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L6;
        registerSensor(r1, 5, r7, r8, r9);
        return;
    L6:
        Logger.w(TAG, "startLight: sensorManager is null");
    }

    public final void startTemperature(int r7, Handler r8, Object r9) {
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L6;
        registerSensor(r1, 13, r7, r8, r9);
        return;
    L6:
        Logger.w(TAG, "startTemperature: sensorManager is null");
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r2, SensorEventListener r3, Sensor r4, int r5, Handler r6) {
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

    private final void registerSensor(SensorManager r6, int r7, int r8, Handler r9, Object r10) {
        Sensor r11 = BDLocationExtrasService.getBPEAManager().getDefaultSensor(r6, r7, r10);     // Catch: Throwable -> L12
        if (r11 != null) goto L7;
        Logger.w(TAG, "registerSensorIfNeeded: sensor not found, type=" + r7);     // Catch: Throwable -> L12
        return;
    L7:
        Logger.i(TAG, "registerSensorIfNeeded: type=" + r7 + ", name=" + r11.getName() + ", vendor=" + r11.getVendor() + ", minDelay=" + r11.getMinDelay() + ", power=" + r11.getPower());     // Catch: Throwable -> L12
        boolean r12 = INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(r6, this.sensorListener, r11, r8, r9);     // Catch: Throwable -> L12
        StringBuilder r13 = new StringBuilder("registerSensorIfNeeded: type=");     // Catch: Throwable -> L12
        r13.append(r7);     // Catch: Throwable -> L12
        r13.append(", registered=");     // Catch: Throwable -> L12
        r13.append(r12);     // Catch: Throwable -> L12
        Logger.i(TAG, r13.toString());     // Catch: Throwable -> L12
        if (r12 == false) goto L10;
        this.registeredSensors.add(r11);     // Catch: Throwable -> L12
        return;
    L10:
        Logger.w(TAG, "registerSensorIfNeeded: register failed, type=" + r7);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Logger.e(TAG, "registerSensorIfNeeded failed, type=" + r7, th);
    }
}
