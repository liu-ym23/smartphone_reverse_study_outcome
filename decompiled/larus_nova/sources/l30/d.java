package l30;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SensorManager f507212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Sensor f507213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f507214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f507215d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float[] f507216e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float[] f507217f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Disposable f507218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f507219h = null;

    public d() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    static {
        f507219h = new d();
        float[] r100 = new float[3];
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= 3) goto L6;
        r100[r102] = 0.0f;
        r102 = r102 + 1;
        goto L4
    L6:
        f507215d = r100;
        float[] r103 = new float[3];
        int r104 = 0;
    L7:
        if (r104 >= 3) goto L9;
        r103[r104] = 0.0f;
        r104 = r104 + 1;
        goto L7
    L9:
        f507216e = r103;
        float[] r105 = new float[3];
    L10:
        if (r101 >= 3) goto L12;
        r105[r101] = 0.0f;
        r101 = r101 + 1;
        goto L10
    L12:
        f507217f = r105;
    }

    public static final String a() {
        JsonObject r100 = new JsonObject();
        float[] r101 = f507217f;
        r100.addProperty("x", Float.valueOf(r101[0]));
        r100.addProperty("y", Float.valueOf(r101[1]));
        r100.addProperty(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, Float.valueOf(r101[2]));
        return r100.toString();
    }

    public final void c() {
        SensorManager r100 = f507212a;
        if (r100 == null) goto L12;
        Sensor r101 = f507213b;
        if (fna.g.d() == true) goto L7;
        r100.unregisterListener(this, r101);
        goto L12
    L7:
        r100.unregisterListener(this, r101);
        int r102 = hashCode();
        if (r101 == null) goto L10;
        int r103 = r101.hashCode();
    L11:
        ona.b.c(new ona.a(r102, Integer.valueOf(r103)));
        goto L12
    L10:
        r103 = 0;
    L12:
        f507214c = 0;
        f507212a = null;
        f507213b = null;
        Disposable r104 = f507218g;
        if (r104 != null) goto L15;
    L19:
        f507218g = null;
        return;
    L15:
        if (r104.isDisposed() == true) goto L19;
        Disposable r105 = f507218g;
        if (r105 == null) goto L19;
        r105.dispose();
        goto L19
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r110) {
        if (r110 == null) goto L20;
        Sensor r100 = r110.sensor;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getType() != 15) goto L22;
        float[] r101 = r110.values;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.length < 4) goto L25;
        int r102 = f507214c;
        float[] r111 = f507215d;
        if (r102 == 2) goto L17;
        b(r111, r101[0], r101[1], r101[2], r101[3]);
        f507214c++;
    L17:
        if (f507214c != 2) goto L24;
        float[] r103 = f507216e;
        float[] r104 = r110.values;
        b(r103, r104[0], r104[1], r104[2], r104[3]);
        float[] r105 = f507217f;
        r105[0] = r103[0] - r111[0];
        r105[1] = r103[1] - r111[1];
        r105[2] = r103[2] - r111[2];
        return;
    L24:
        return;
    L25:
        return;
    L22:
        return;
    }

    public static void b(float[] r110, double r111, double r112, double r113, double r210) {
        double r100 = 2;
        double r101 = 1;
        double r114 = r112 * r112;
        r110[0] = (float) Math.atan2((((-r210) * r111) + (r112 * r113)) * r100, r101 - (((r111 * r111) + r114) * r100));
        r110[1] = (float) Math.asin(((r210 * r112) - (r111 * r113)) * r100);
        r110[2] = (float) Math.atan2(((r210 * r113) - (r112 * r111)) * r100, r101 - (r100 * (r114 + (r113 * r113))));
    }
}
