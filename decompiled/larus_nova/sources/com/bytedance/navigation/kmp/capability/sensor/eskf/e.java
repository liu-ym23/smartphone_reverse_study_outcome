package com.bytedance.navigation.kmp.capability.sensor.eskf;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import bv5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EskfDeviceHeadingSensor f265822a;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    public e(EskfDeviceHeadingSensor r100) {
        this.f265822a = r100;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
    L11:
        th = move-exception;
        this.f265822a.c("sensor:".concat(th.getClass().getSimpleName()));
        return;
    L4:
        if (r110.sensor.getType() != 11) goto L8;
        float[] r100 = new float[4];     // Catch: Throwable -> L11
        SensorManager.getQuaternionFromVector(r100, r110.values);     // Catch: Throwable -> L11
        j r101 = this.f265822a.f265810g;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.f20917s = new double[]{r100[0], r100[1], r100[2], r100[3]};     // Catch: Throwable -> L11
    L9:
        EskfDeviceHeadingSensor.b(this.f265822a, r110);     // Catch: Throwable -> L11
        return;
    L8:
        i.a(this.f265822a.f265816m, r110.sensor.getType(), r110.values, r110.timestamp);     // Catch: Throwable -> L11
        goto L9
    }
}
