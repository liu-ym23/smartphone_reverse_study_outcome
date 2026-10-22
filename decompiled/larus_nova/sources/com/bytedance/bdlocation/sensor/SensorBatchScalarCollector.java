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

/* JADX INFO: loaded from: classes10.dex */
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

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void stop() {
        Logger.i(TAG, "stop: registeredSensors=" + this.registeredSensors.size());
        SensorManager r100 = this.sensorManager;
        if (r100 != null) goto L20;
        Logger.w(TAG, "stop: sensorManager is null");
        this.registeredSensors.clear();
        return;
    L20:
        Iterator<Sensor> r101 = this.registeredSensors.iterator();     // Catch: Throwable -> L9
    L6:
        if (r101.hasNext() == false) goto L11;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r100, this.sensorListener, r101.next());     // Catch: Throwable -> L9
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

    public static final /* synthetic */ SensorBatchScalarCallback access$getCallback$p(SensorBatchScalarCollector r100) {
        return r100.callback;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.bdlocation.sensor.SensorBatchScalarCollector$sensorListener$1] */
    public SensorBatchScalarCollector(SensorManager r100, SensorBatchScalarCallback r101) {
        this.sensorManager = r100;
        this.callback = r101;
        this.registeredSensors = new ArrayList();
        this.sensorListener = new SensorBatchScalarCollector$sensorListener$1(this);
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101, Sensor r102) {
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

    public final void start(int r100, Handler r110, Object r111) {
        Logger.i(TAG, "start: samplingPeriodUs=" + r100);
        SensorManager r101 = this.sensorManager;
        if (r101 == null) goto L6;
        registerSensor(r101, 6, r100, r110, r111);
        registerSensor(r101, 5, r100, r110, r111);
        registerSensor(r101, 13, r100, r110, r111);
        return;
    L6:
        Logger.w(TAG, "start: sensorManager is null");
    }

    public final void startBarometer(int r100, Handler r101, Object r102) {
        SensorManager r103 = this.sensorManager;
        if (r103 == null) goto L6;
        registerSensor(r103, 6, r100, r101, r102);
        return;
    L6:
        Logger.w(TAG, "startBarometer: sensorManager is null");
    }

    public final void startLight(int r100, Handler r101, Object r102) {
        SensorManager r103 = this.sensorManager;
        if (r103 == null) goto L6;
        registerSensor(r103, 5, r100, r101, r102);
        return;
    L6:
        Logger.w(TAG, "startLight: sensorManager is null");
    }

    public final void startTemperature(int r100, Handler r101, Object r102) {
        SensorManager r103 = this.sensorManager;
        if (r103 == null) goto L6;
        registerSensor(r103, 13, r100, r101, r102);
        return;
    L6:
        Logger.w(TAG, "startTemperature: sensorManager is null");
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r100, SensorEventListener r101, Sensor r102, int r103, Handler r104) {
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

    private final void registerSensor(SensorManager r100, int r101, int r102, Handler r103, Object r110) {
        Sensor r111 = BDLocationExtrasService.getBPEAManager().getDefaultSensor(r100, r101, r110);     // Catch: Throwable -> L12
        if (r111 != null) goto L7;
        Logger.w(TAG, "registerSensorIfNeeded: sensor not found, type=" + r101);     // Catch: Throwable -> L12
        return;
    L7:
        Logger.i(TAG, "registerSensorIfNeeded: type=" + r101 + ", name=" + r111.getName() + ", vendor=" + r111.getVendor() + ", minDelay=" + r111.getMinDelay() + ", power=" + r111.getPower());     // Catch: Throwable -> L12
        boolean r104 = INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchScalarCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(r100, this.sensorListener, r111, r102, r103);     // Catch: Throwable -> L12
        StringBuilder r105 = new StringBuilder("registerSensorIfNeeded: type=");     // Catch: Throwable -> L12
        r105.append(r101);     // Catch: Throwable -> L12
        r105.append(", registered=");     // Catch: Throwable -> L12
        r105.append(r104);     // Catch: Throwable -> L12
        Logger.i(TAG, r105.toString());     // Catch: Throwable -> L12
        if (r104 == false) goto L10;
        this.registeredSensors.add(r111);     // Catch: Throwable -> L12
        return;
    L10:
        Logger.w(TAG, "registerSensorIfNeeded: register failed, type=" + r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Logger.e(TAG, "registerSensorIfNeeded failed, type=" + r101, th);
    }
}
