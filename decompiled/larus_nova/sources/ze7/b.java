package ze7;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.ss.texturerender.TextureRenderKeys;
import faceverify.w;
import fna.g;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f571549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SensorManager f571550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f571551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f571552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<String, ? extends Object> f571553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float[] f571554f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float[] f571555g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float[] f571556h = null;

    public b() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, w.BLOB_ELEM_TYPE_SENSOR);
    }

    static {
        f571549a = new b();
        f571553e = MapsKt.emptyMap();
        f571554f = new float[4];
        f571555g = new float[9];
        f571556h = new float[3];
    }

    public final void a() {
        SensorManager r100 = f571550b;
        if (r100 != null) goto L5;
    L8:
        a r101 = f571552d;
        if (r101 == null) goto L13;
        Handler r102 = f571551c;
        if (r102 == null) goto L13;
        r102.removeCallbacks(r101);
    L13:
        f571550b = null;
        f571551c = null;
        f571552d = null;
        f571553e = MapsKt.emptyMap();
        return;
    L5:
        if (g.d() == true) goto L7;
        r100.unregisterListener(this);
        goto L8
    L7:
        r100.unregisterListener(this);
        ona.b.c(new ona.a(hashCode(), null));
        goto L8
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.sensor.getType() != 15) goto L6;
        float[] r101 = r100.values;
        float[] r102 = f571554f;
        System.arraycopy(r101, 0, r102, 0, r102.length);
        float[] r103 = f571555g;
        SensorManager.getRotationMatrixFromVector(r103, r102);
        float[] r104 = f571556h;
        SensorManager.getOrientation(r103, r104);
        f571553e = MapsKt.mapOf(new Pair[]{TuplesKt.to(TextureRenderKeys.KEY_IS_YAW, Float.valueOf(-r104[0])), TuplesKt.to(TextureRenderKeys.KEY_IS_PITCH, Float.valueOf(-r104[1])), TuplesKt.to("roll", Float.valueOf(r104[2]))});
        return;
    }
}
