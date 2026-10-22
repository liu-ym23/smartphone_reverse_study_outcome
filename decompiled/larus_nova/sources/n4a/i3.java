package n4a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i3 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f517379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Sensor f517380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Sensor f517381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Sensor f517382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f517383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f517384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f517385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f517386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f517387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f517388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f517389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f517390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double[] f517391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile double f517392n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f517393o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f517394p;

    public i3(Context r100) {
        this.f517379a = null;
        this.f517380b = null;
        this.f517381c = null;
        this.f517382d = null;
        this.f517383e = false;
        this.f517384f = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517385g = 0.0f;
        this.f517386h = new Handler();
        this.f517387i = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517388j = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517389k = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517390l = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517391m = new double[3];
        this.f517392n = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517393o = 0;
        this.f517394p = 0;
    L10:
        th = move-exception;
        c4.g(th, "AMapSensorManager", "<init>");
        return;
    L4:
        if (this.f517379a != null) goto L18;
        this.f517379a = (SensorManager) r100.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);     // Catch: Throwable -> L10
    L18:
        this.f517380b = this.f517379a.getDefaultSensor(6);     // Catch: Throwable -> L13
    L16:
        this.f517381c = this.f517379a.getDefaultSensor(11);     // Catch: Throwable -> L14
    L20:
        this.f517382d = this.f517379a.getDefaultSensor(1);     // Catch: Throwable -> L15
        return;
    }

    public final void c(float[] r110) {
        double[] r100 = this.f517391m;
        double r101 = r100[0] * 0.800000011920929d;
        float r102 = r110[0];
        double r103 = r101 + ((double) (r102 * 0.19999999f));
        r100[0] = r103;
        double r104 = r100[1] * 0.800000011920929d;
        float r111 = r110[1];
        double r105 = r104 + ((double) (r111 * 0.19999999f));
        r100[1] = r105;
        double r112 = r100[2] * 0.800000011920929d;
        float r113 = r110[2];
        double r114 = r112 + ((double) (0.19999999f * r113));
        r100[2] = r114;
        this.f517387i = ((double) r102) - r103;
        this.f517388j = ((double) r111) - r105;
        this.f517389k = ((double) r113) - r114;
        long r106 = System.currentTimeMillis();
        if ((r106 - this.f517393o) >= 100) goto L5;
        return;
    L5:
        double r107 = this.f517387i;
        double r108 = this.f517388j;
        double r109 = (r107 * r107) + (r108 * r108);
        double r115 = this.f517389k;
        double r116 = Math.sqrt(r109 + (r115 * r115));
        this.f517394p++;
        this.f517393o = r106;
        this.f517392n += r116;
        if (this.f517394p < 30) goto L9;
        this.f517390l = this.f517392n / this.f517394p;
        this.f517392n = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517394p = 0;
        return;
    }

    public final void d() {
        SensorManager r100 = this.f517379a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f517383e == false) goto L27;
        this.f517383e = false;
        Sensor r101 = this.f517380b;     // Catch: Throwable -> L17
        if (r101 == null) goto L24;
        b(r100, this, r101);     // Catch: Throwable -> L17
    L24:
        Sensor r102 = this.f517381c;     // Catch: Throwable -> L18
        if (r102 == null) goto L22;
        b(this.f517379a, this, r102);     // Catch: Throwable -> L18
    L22:
        Sensor r103 = this.f517382d;     // Catch: Throwable -> L19
        if (r103 == null) goto L28;
        b(this.f517379a, this, r103);     // Catch: Throwable -> L19
        return;
    L28:
        return;
    L29:
        return;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r100) {
        if (r100 != null) goto L35;
        return;
    L35:
        int r101 = r100.sensor.getType();     // Catch: Throwable -> L30
        if (r101 == 1) goto L25;
        if (r101 != 6) goto L10;
        if (this.f517380b == null) goto L39;
        this.f517384f = (float) (((long) (((double) SensorManager.getAltitude(1013.25f, ((float[]) r100.values.clone())[0])) * 100.0d)) / 100.0d);     // Catch: Throwable -> L29
        return;
    L39:
        return;
    L40:
        return;
    L10:
        if (r101 != 11) goto L42;
        if (this.f517381c == null) goto L37;
        float[] r102 = new float[9];     // Catch: Throwable -> L28
        SensorManager.getRotationMatrixFromVector(r102, (float[]) r100.values.clone());     // Catch: Throwable -> L28
        float[] r103 = new float[3];     // Catch: Throwable -> L28
        SensorManager.getOrientation(r102, r103);     // Catch: Throwable -> L28
        float r104 = (float) Math.toDegrees(r103[0]);     // Catch: Throwable -> L28
        this.f517385g = r104;     // Catch: Throwable -> L28
        if (r104 > 0.0f) goto L18;
        r104 = r104 + 360.0f;     // Catch: Throwable -> L28
    L18:
        this.f517385g = (float) Math.floor(r104);     // Catch: Throwable -> L28
        return;
    L37:
        return;
    L38:
        return;
    L42:
        return;
    L25:
        if (this.f517382d == null) goto L41;
        c((float[]) r100.values.clone());     // Catch: Throwable -> L30
        return;
    L41:
        return;
    }

    public static void b(SensorManager r100, SensorEventListener r101, Sensor r102) {
        if (fna.g.d() == true) goto L6;
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
        ona.b.c(new ona.a(r104, Integer.valueOf(r103)));
        return;
    L9:
        r104 = 0;
        goto L10
    }

    public static void a(SensorManager r100, i3 r101, Sensor r102, Handler r103) {
        if (fna.g.d() == true) goto L6;
        Boolean r104 = Boolean.valueOf(r100.registerListener(r101, r102, 3, r103));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        r104.booleanValue();
        return;
    L6:
        Boolean r105 = Boolean.valueOf(r100.registerListener(r101, r102, 3, r103));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        r105.booleanValue();
        int r106 = r101.hashCode();
        if (r102 == null) goto L9;
        int r107 = r102.hashCode();
    L10:
        ona.b.a(new ona.a(r106, Integer.valueOf(r107)));
        return;
    L9:
        r107 = 0;
        goto L10
    }
}
