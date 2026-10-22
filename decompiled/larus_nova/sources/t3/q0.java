package t3;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import androidx.camera.video.AudioStats;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q0 extends c {
    public q0(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        super(r100, 11, "doubao.onDeviceMotionChange", "device motion is not available");
    }

    @Override // t3.c
    public final JsonObject c(SensorEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float[] r101 = new float[9];
        float[] r102 = new float[3];
        SensorManager.getRotationMatrixFromVector(r101, r100.values);
        SensorManager.getOrientation(r101, r102);
        JsonObject r103 = new JsonObject();
        double r104 = ((double) r102[0]) % 6.283185307179586d;
        if (r104 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        r104 = r104 + 6.283185307179586d;
    L5:
        r103.addProperty("alpha", Double.valueOf(r104));
        r103.addProperty("beta", Double.valueOf(r102[1]));
        r103.addProperty("gamma", Double.valueOf(r102[2]));
        return r103;
    }
}
