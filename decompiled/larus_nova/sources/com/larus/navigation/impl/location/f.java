package com.larus.navigation.impl.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import faceverify.w;
import fna.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359887a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f359888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f359889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f359890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f359891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f359892e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f359893f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f359894g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f359895h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f359896i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final b f359897j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final C4428a f359898k;

        /* JADX INFO: renamed from: com.larus.navigation.impl.location.f$a$a, reason: collision with other inner class name */
        public static final class C4428a implements SensorEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f359899a;

            public C4428a(a r100) {
                this.f359899a = r100;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                int r101 = r100.sensor.getType();
                if (r101 != 1) goto L5;
                System.arraycopy(r100.values, 0, this.f359899a.f359891d, 0, 3);
                a r102 = this.f359899a;
                r102.f359893f = true;
                r102.f359895h = r100.timestamp;
            L9:
                a r103 = this.f359899a;
                if (r103.f359893f == true) goto L12;
                return;
            L12:
                if (r103.f359894g == true) goto L15;
                return;
            L15:
                if (Math.abs(r103.f359895h - r103.f359896i) <= 100000000) goto L17;
                return;
            L17:
                a r104 = this.f359899a;
                if (SensorManager.getRotationMatrix(r104.f359889b, null, r104.f359891d, r104.f359892e) == false) goto L29;
                a r105 = this.f359899a;
                SensorManager.getOrientation(r105.f359889b, r105.f359890c);
                float r106 = ((float) Math.toDegrees(this.f359899a.f359890c[0])) % 360.0f;
                if (r106 >= 0.0f) goto L22;
                r106 = r106 + 360.0f;
            L22:
                a r107 = this.f359899a;
                if (Float.isNaN(r107.f359888a) == false) goto L25;
            L26:
                r107.f359888a = r106;
                r107.a(r106);
                return;
            L25:
                if (Math.abs(r107.f359888a - r106) >= 1.0f) goto L26;
                return;
            L29:
                return;
            L5:
                if (r101 != 2) goto L9;
                System.arraycopy(r100.values, 0, this.f359899a.f359892e, 0, 3);
                a r108 = this.f359899a;
                r108.f359894g = true;
                r108.f359896i = r100.timestamp;
                goto L9
            }

            @Override // android.hardware.SensorEventListener
            public final void onAccuracyChanged(Sensor r100, int r101) {
                int r102 = com.larus.navigation.api.c.f359656a;
                StringBuilder r103 = new StringBuilder("onAccuracyChanged:[");
                if (r100 == null) goto L5;
                Integer r104 = Integer.valueOf(r100.getType());
            L6:
                r103.append(r104);
                r103.append("][");
                r103.append(r101);
                r103.append(']');
                com.larus.navigation.api.c.d(w.BLOB_ELEM_TYPE_SENSOR, r103.toString());
                return;
            L5:
                r104 = null;
                goto L6
            }
        }

        public static final class b implements SensorEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f359900a;

            public b(a r100) {
                this.f359900a = r100;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                if (r100.sensor.getType() == 11) goto L5;
                return;
            L5:
                SensorManager.getRotationMatrixFromVector(this.f359900a.f359889b, r100.values);
                a r101 = this.f359900a;
                SensorManager.getOrientation(r101.f359889b, r101.f359890c);
                float r102 = ((float) Math.toDegrees(this.f359900a.f359890c[0])) % 360.0f;
                if (r102 >= 0.0f) goto L8;
                r102 = r102 + 360.0f;
            L8:
                a r103 = this.f359900a;
                if (Float.isNaN(r103.f359888a) == false) goto L11;
            L12:
                r103.f359888a = r102;
                r103.a(r102);
                return;
            L11:
                if (Math.abs(r103.f359888a - r102) >= 1.0f) goto L12;
            }

            @Override // android.hardware.SensorEventListener
            public final void onAccuracyChanged(Sensor r100, int r101) {
                int r102 = com.larus.navigation.api.c.f359656a;
                StringBuilder r103 = new StringBuilder("onAccuracyChanged:[");
                if (r100 == null) goto L5;
                Integer r104 = Integer.valueOf(r100.getType());
            L6:
                r103.append(r104);
                r103.append("][");
                r103.append(r101);
                r103.append(']');
                com.larus.navigation.api.c.d(w.BLOB_ELEM_TYPE_SENSOR, r103.toString());
                return;
            L5:
                r104 = null;
                goto L6
            }
        }

        public abstract void a(float r100);

        public a() {
            this.f359888a = Float.NaN;
            this.f359889b = new float[9];
            this.f359890c = new float[3];
            this.f359891d = new float[3];
            this.f359892e = new float[3];
            this.f359895h = Long.MIN_VALUE;
            this.f359896i = Long.MIN_VALUE;
            this.f359897j = new b(this);
            this.f359898k = new C4428a(this);
        }
    }

    static {
    }

    public static void a(SensorManager r100, SensorEventListener r101) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        ona.b.c(new ona.a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }
}
