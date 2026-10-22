package com.bytedance.applet.aibridge.baidunavi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.larus.utils.logger.FLogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static abstract class a {
        public float a;
        public final C0045a b;

        /* JADX INFO: renamed from: com.bytedance.applet.aibridge.baidunavi.h$a$a, reason: collision with other inner class name */
        public static final class C0045a implements SensorEventListener {
            public final /* synthetic */ a a;

            public C0045a(a r1) {
                this.a = r1;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent r4) {
                Intrinsics.checkNotNullParameter(r4, "event");
                FLogger.a.i("sensor_util", "onSensorChanged:[" + r4.values + ']');
                Float r5 = ArraysKt.firstOrNull(r4.values);
                if (r5 == null) goto L8;
                float r6 = r5.floatValue();
                if (Math.abs(this.a.a - r6) < 1.0f) goto L9;
                a r0 = this.a;
                r0.a = r6;
                r0.a(r6);
                return;
            L9:
                return;
            }

            @Override // android.hardware.SensorEventListener
            public final void onAccuracyChanged(Sensor r4, int r5) {
                FLogger r0 = FLogger.a;
                StringBuilder r1 = new StringBuilder("onAccuracyChanged:[");
                if (r4 == null) goto L5;
                Integer r6 = Integer.valueOf(r4.getType());
            L6:
                r1.append(r6);
                r1.append("][");
                r1.append(r5);
                r1.append(']');
                r0.i("sensor_util", r1.toString());
                return;
            L5:
                r6 = null;
                goto L6
            }
        }

        public abstract void a(float r1);

        public a() {
            this.b = new C0045a(this);
        }
    }

    static {
    }

    public static boolean a(Context r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Object r6 = r4.getSystemService("sensor");
        if ((r6 instanceof SensorManager) == false) goto L5;
        SensorManager r7 = (SensorManager) r6;
    L6:
        boolean r0 = false;
        if (r7 != null) goto L10;
        FLogger.a.e("sensor_util", "no sensor mgr");
        return false;
    L10:
        Sensor r2 = r7.getDefaultSensor(3);
        if (r2 == null) goto L13;
        r7.registerListener(r5.b, r2, 2);
    L13:
        if (r2 == null) goto L15;
        r0 = true;
    L15:
        FLogger.a.i("sensor_util", "register:" + r0);
        return r0;
    L5:
        r7 = null;
        goto L6
    }

    public static void b(Context r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "callback");
        FLogger r0 = FLogger.a;
        r0.e("sensor_util", "unregister");
        Object r6 = r4.getSystemService("sensor");
        if ((r6 instanceof SensorManager) == false) goto L5;
        SensorManager r7 = (SensorManager) r6;
    L6:
        if (r7 != null) goto L9;
        r0.e("sensor_util", "no sensor mgr");
        return;
    L9:
        a.C0045a r8 = r5.b;
        if (fna.g.d() == true) goto L12;
        r7.unregisterListener(r8);
        return;
    L12:
        r7.unregisterListener(r8);
        if (r8 == null) goto L15;
        int r9 = r8.hashCode();
    L16:
        ona.b.c(new ona.a(r9, null));
        return;
    L15:
        r9 = 0;
        goto L16
    L5:
        r7 = null;
        goto L6
    }
}
