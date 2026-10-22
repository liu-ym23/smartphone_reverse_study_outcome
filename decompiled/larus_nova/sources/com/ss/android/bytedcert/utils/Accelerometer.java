package com.ss.android.bytedcert.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import faceverify.w;
import fna.g;
import ona.b;

/* JADX INFO: loaded from: classes34.dex */
public final class Accelerometer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CLOCKWISE_ANGLE f407643d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SensorManager f407644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f407645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f407646c;

    public static final enum CLOCKWISE_ANGLE extends Enum<CLOCKWISE_ANGLE> {
        public static final CLOCKWISE_ANGLE Deg0 = null;
        public static final CLOCKWISE_ANGLE Deg180 = null;
        public static final CLOCKWISE_ANGLE Deg270 = null;
        public static final CLOCKWISE_ANGLE Deg90 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CLOCKWISE_ANGLE[] f407647a = null;
        private final int value;

        static {
            CLOCKWISE_ANGLE r100 = new CLOCKWISE_ANGLE("Deg0", 0, 0);
            Deg0 = r100;
            CLOCKWISE_ANGLE r101 = new CLOCKWISE_ANGLE("Deg90", 1, 1);
            Deg90 = r101;
            CLOCKWISE_ANGLE r102 = new CLOCKWISE_ANGLE("Deg180", 2, 2);
            Deg180 = r102;
            CLOCKWISE_ANGLE r103 = new CLOCKWISE_ANGLE("Deg270", 3, 3);
            Deg270 = r103;
            f407647a = new CLOCKWISE_ANGLE[]{r100, r101, r102, r103};
        }

        public static CLOCKWISE_ANGLE[] values() {
            return (CLOCKWISE_ANGLE[]) f407647a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static CLOCKWISE_ANGLE valueOf(String r100) {
            return (CLOCKWISE_ANGLE) r27.a.a(CLOCKWISE_ANGLE.class, r100);
        }

        public CLOCKWISE_ANGLE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
        }

        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r100) {
            if (r100.sensor.getType() != 1) goto L19;
            float[] r101 = r100.values;
            float r102 = r101[0];
            float r103 = r101[1];
            float r104 = r101[2];
            if (Math.abs(r102) > 3.0f) goto L9;
            if (Math.abs(r103) > 3.0f) goto L9;
            return;
        L9:
            if (Math.abs(r102) <= Math.abs(r103)) goto L15;
            if (r102 <= 0.0f) goto L13;
            Accelerometer.f407643d = CLOCKWISE_ANGLE.Deg0;
            return;
        L13:
            Accelerometer.f407643d = CLOCKWISE_ANGLE.Deg180;
            return;
        L15:
            if (r103 <= 0.0f) goto L17;
            Accelerometer.f407643d = CLOCKWISE_ANGLE.Deg90;
            return;
        L17:
            Accelerometer.f407643d = CLOCKWISE_ANGLE.Deg270;
            return;
        }
    }

    public final void a() {
        if (this.f407645b == false) goto L5;
        return;
    L5:
        this.f407645b = true;
        f407643d = CLOCKWISE_ANGLE.Deg90;
        ICertCompliance r100 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L15
        if (r100 == null) goto L14;
        Sensor r101 = r100.getDefaultSensor(this.f407644a, 1);     // Catch: Exception -> L15
        if (r101 == null) goto L12;
        this.f407644a.registerListener(this.f407646c, r101, 3);     // Catch: Exception -> L15
        return;
    L12:
        throw new NullPointerException("manager or sensor is null");     // Catch: Exception -> L15
    L14:
        throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b() {
        if (this.f407645b == true) goto L5;
        return;
    L5:
        int r100 = 0;
        this.f407645b = false;
        SensorManager r101 = this.f407644a;
        a r102 = this.f407646c;
        if (g.d() == true) goto L8;
        r101.unregisterListener(r102);
        return;
    L8:
        r101.unregisterListener(r102);
        if (r102 == null) goto L11;
        r100 = r102.hashCode();
    L11:
        b.c(new ona.a(r100, null));
    }

    public Accelerometer(Context r100) {
        this.f407645b = false;
        this.f407646c = new a();
        this.f407644a = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        f407643d = CLOCKWISE_ANGLE.Deg90;
    }
}
