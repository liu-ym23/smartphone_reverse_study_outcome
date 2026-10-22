package z27;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import bv5.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f569800a;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    public c(b r100) {
        this.f569800a = r100;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r110.sensor.getType() == 11) goto L5;
        return;
    L5:
        float[] r100 = new float[4];
        SensorManager.getQuaternionFromVector(r100, r110.values);
        double[] r111 = {r100[0], r100[1], r100[2], r100[3]};
        b r101 = this.f569800a;
        com.bytedance.navigation.kmp.listener.b r102 = r101.f569794e;
        if (r102 == null) goto L16;
        long r103 = SystemClock.elapsedRealtime();
        if ((r103 - r101.f569797h) < r101.f569796g) goto L17;
        Intrinsics.checkNotNullParameter(r111, "qWxyz");
        int r104 = e.f20864a;
        double r105 = ((Math.toDegrees(e.b(r111)[0]) % 360.0d) + 360.0d) % 360.0d;
        boolean r112 = r101.f569799j;
        if (r112 == false) goto L14;
        r105 = ((r105 - ((double) r101.f569798i)) + 360.0d) % 360.0d;
    L14:
        r101.f569797h = r103;
        r102.a((float) r105, (float) ((360.0d - r105) % 360.0d), r112);
        return;
    L17:
        return;
    }
}
