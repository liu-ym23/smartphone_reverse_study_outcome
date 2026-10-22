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
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J2\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001J \u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001f\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchImuCollector;", "", "sensorManager", "Landroid/hardware/SensorManager;", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchImuCallback;", "(Landroid/hardware/SensorManager;Lcom/bytedance/bdlocation/sensor/SensorBatchImuCallback;)V", "registeredSensors", "", "Landroid/hardware/Sensor;", "sensorListener", "com/bytedance/bdlocation/sensor/SensorBatchImuCollector$sensorListener$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchImuCollector$sensorListener$1;", "finiteAxisValue", "", "values", "", "index", "", "registerSensor", "", "manager", "sensorType", "samplingPeriodUs", "handler", "Landroid/os/Handler;", "bpeaCert", "start", "startAccelerometer", "startGyroscope", "startMagnetometer", "stop", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchImuCollector {
    public static final Companion Companion = null;
    public static final String TAG = "SSS-ImuCollector";
    private final SensorBatchImuCallback callback;
    private final List<Sensor> registeredSensors;
    private final SensorBatchImuCollector$sensorListener$1 sensorListener;
    private final SensorManager sensorManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchImuCollector$Companion;", "", "()V", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
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
        SensorManager r0 = this.sensorManager;
        if (r0 != null) goto L20;
        this.registeredSensors.clear();
        return;
    L20:
        Iterator<Sensor> r1 = this.registeredSensors.iterator();     // Catch: Throwable -> L9
    L6:
        if (r1.hasNext() == false) goto L11;
        Sensor r2 = r1.next();     // Catch: Throwable -> L9
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchImuCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r0, this.sensorListener, r2);     // Catch: Throwable -> L9
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

    public static final /* synthetic */ SensorBatchImuCallback access$getCallback$p(SensorBatchImuCollector r0) {
        return r0.callback;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.bdlocation.sensor.SensorBatchImuCollector$sensorListener$1] */
    public SensorBatchImuCollector(SensorManager r1, SensorBatchImuCallback r2) {
        this.sensorManager = r1;
        this.callback = r2;
        this.registeredSensors = new ArrayList();
        this.sensorListener = new SensorBatchImuCollector$sensorListener$1(this);
    }

    private final float finiteAxisValue(float[] r4, int r5) {
        SensorBatchValueUtils r0 = SensorBatchValueUtils.INSTANCE;
        if (r5 >= 0) goto L5;
    L7:
        float r6 = 0.0f;
    L9:
        return SensorBatchValueUtils.finiteFloat$default(r0, r6, 0.0f, 2, null);
    L5:
        if (r5 > ArraysKt.getLastIndex(r4)) goto L7;
        r6 = r4[r5];
        goto L9
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchImuCollector_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2, Sensor r3) {
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

    public static final /* synthetic */ float access$finiteAxisValue(SensorBatchImuCollector r0, float[] r1, int r2) {
        return r0.finiteAxisValue(r1, r2);
    }

    public final void start(int r8, Handler r9, Object r10) {
        SensorManager r6 = this.sensorManager;
        if (r6 == null) goto L6;
        registerSensor(r6, 1, r8, r9, r10);
        registerSensor(r6, 4, r8, r9, r10);
        registerSensor(r6, 2, r8, r9, r10);
        return;
    }

    public final void startAccelerometer(int r7, Handler r8, Object r9) {
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L6;
        registerSensor(r1, 1, r7, r8, r9);
        return;
    }

    public final void startGyroscope(int r7, Handler r8, Object r9) {
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L6;
        registerSensor(r1, 4, r7, r8, r9);
        return;
    }

    public final void startMagnetometer(int r7, Handler r8, Object r9) {
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L6;
        registerSensor(r1, 2, r7, r8, r9);
        return;
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchImuCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r2, SensorEventListener r3, Sensor r4, int r5, Handler r6) {
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

    private final void registerSensor(SensorManager r2, int r3, int r4, Handler r5, Object r6) {
        Sensor r7 = BDLocationExtrasService.getBPEAManager().getDefaultSensor(r2, r3, r6);     // Catch: Throwable -> L9
        if (r7 != null) goto L5;
        return;
    L5:
        if (INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchImuCollector_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(r2, this.sensorListener, r7, r4, r5) == false) goto L14;
        this.registeredSensors.add(r7);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(TAG, "registerSensor failed, type=" + r3, th);
    }
}
