package u3;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonObject;
import com.lynx.canvas.KryptonCamera;
import e3.d;
import kotlin.jvm.internal.Intrinsics;
import t3.c;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends c {

    /* JADX INFO: renamed from: u3.a$a, reason: collision with other inner class name */
    public static final class C7824a {
    }

    static {
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        super(r100, 11, "doubao.onCompassChange", "compass is not available");
    }

    @Override // t3.c
    public final JsonObject c(SensorEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        float[] r100 = new float[9];
        float[] r101 = new float[3];
        SensorManager.getRotationMatrixFromVector(r100, r110.values);
        SensorManager.getOrientation(r100, r101);
        JsonObject r102 = new JsonObject();
        double r103 = Math.toDegrees(r101[0]) % 360.0d;
        if (r103 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        r103 = r103 + 360.0d;
    L5:
        r102.addProperty("direction", Double.valueOf(r103));
        int r111 = r110.accuracy;
        if (r111 == (-1)) goto L18;
        if (r111 != 0) goto L9;
        String r112 = "unreliable";
    L19:
        r102.addProperty(LocationMonitorConst.ACCURACY, r112);
        return r102;
    L9:
        if (r111 != 1) goto L11;
        r112 = "low";
        goto L19
    L11:
        if (r111 == 2) goto L15;
        if (r111 == 3) goto L14;
        r112 = "unknow " + r111;
        goto L19
    L14:
        r112 = "high";
        goto L19
    L15:
        r112 = KryptonCamera.Config.RESOLUTION_MEDIUM;
        goto L19
    L18:
        r112 = "no-contact";
        goto L19
    }
}
