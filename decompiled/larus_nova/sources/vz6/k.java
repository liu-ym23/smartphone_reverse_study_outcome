package vz6;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f557729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f557730b;

    public k() {
    }

    static {
        f557729a = new LinearInterpolator();
    }

    public static void b(int r100, WeakReference<Interpolator> r101) {
        monitor-enter(k.class);
        f557730b.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(k.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static <T> xz6.a<T> a(JsonReader r110, com.bytedance.lottie.d r111, float r112, s<T> r210, boolean r211) throws IOException {
        if (r211 == false) goto L81;
        r110.beginObject();
        Interpolator r100 = null;
        PointF r101 = null;
        PointF r102 = null;
        T r103 = null;
        T r104 = null;
        PointF r113 = null;
        PointF r114 = null;
        boolean r105 = false;
        float r115 = 0.0f;
    L6:
        if (r110.hasNext() == false) goto L55;
        String r116 = r110.nextName();
        r116.getClass();
        byte r117 = -1;
        switch(r116.hashCode()) {
            case 101: goto L39;
            case 104: goto L35;
            case 105: goto L31;
            case 111: goto L27;
            case 115: goto L23;
            case 116: goto L19;
            case 3701: goto L15;
            case 3707: goto L11;
            default: goto L42;
        };
    L42:
        switch(r117) {
            case 0: goto L54;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L45;
            case 7: goto L44;
            default: goto L43;
        };
    L44:
        r113 = j.b(r110, r112);
        goto L6
    L45:
        r114 = j.b(r110, r112);
        goto L6
    L46:
        r115 = (float) r110.nextDouble();
        goto L6
    L47:
        r103 = r210.a(r110, r112);
        goto L6
    L48:
        r101 = j.b(r110, r112);
        goto L6
    L49:
        r102 = j.b(r110, r112);
        goto L6
    L51:
        if (r110.nextInt() == 1) goto L52;
        r105 = false;
        goto L6
    L52:
        r105 = true;
        goto L6
    L54:
        r104 = r210.a(r110, r112);
        goto L6
    L43:
        r110.skipValue();
        goto L6
    L11:
        if (r116.equals(RemoteMessageConst.TO) == false) goto L42;
        r117 = 7;
        goto L42
    L15:
        if (r116.equals("ti") == false) goto L42;
        r117 = 6;
        goto L42
    L19:
        if (r116.equals("t") == false) goto L42;
        r117 = 5;
        goto L42
    L23:
        if (r116.equals("s") == false) goto L42;
        r117 = 4;
        goto L42
    L27:
        if (r116.equals("o") == false) goto L42;
        r117 = 3;
        goto L42
    L31:
        if (r116.equals(RXScreenCaptureService.KEY_INDEX) == false) goto L42;
        r117 = 2;
        goto L42
    L35:
        if (r116.equals("h") == false) goto L42;
        r117 = 1;
        goto L42
    L39:
        if (r116.equals("e") == false) goto L42;
        r117 = 0;
        goto L42
    L55:
        r110.endObject();
        if (r105 == false) goto L58;
        Interpolator r118 = f557729a;
        r104 = r103;
    L78:
        xz6.a<T> r106 = new xz6.a(r111, r103, r104, r118, r115, null);
        r106.f565534i = r113;
        r106.f565535j = r114;
        return r106;
    L58:
        if (r101 == null) goto L77;
        if (r102 == null) goto L77;
        float r107 = -r112;
        r101.x = wz6.f.b(r101.x, r107, r112);
        r101.y = wz6.f.b(r101.y, -100.0f, 100.0f);
        r102.x = wz6.f.b(r102.x, r107, r112);
        float r108 = wz6.f.b(r102.y, -100.0f, 100.0f);
        r102.y = r108;
        float r109 = r101.x;
        float r119 = r101.y;
        float r120 = r102.x;
        PathMeasure r121 = wz6.h.f561956a;
        int r122 = (int) (((((int) (((((int) (((((int) ((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER * (r109 + 1.0f)) + 1.0f)) * 31) * (r119 + 2.0f)) + 1.0f)) * 31) * (r120 + 3.0f)) + 1.0f)) * 31) * (r108 + 4.0f)) + 1.0f);
        monitor-enter(k.class);
    L74:
        th = move-exception;
        throw th;
    L63:
        if (f557730b != null) goto L65;
        f557730b = new SparseArrayCompat();     // Catch: Throwable -> L74
    L65:
        WeakReference<Interpolator> r123 = f557730b.get(r122);     // Catch: Throwable -> L74
        monitor-exit(k.class);     // Catch: Throwable -> L74
        if (r123 == null) goto L69;
        r100 = r123.get();
    L69:
        if (r123 == null) goto L71;
        if (r100 == null) goto L71;
    L73:
        r118 = r100;
    L71:
        r100 = PathInterpolatorCompat.create(r101.x / r112, r101.y / r112, r102.x / r112, r102.y / r112);
        b(r122, new WeakReference(r100));     // Catch: ArrayIndexOutOfBoundsException -> L82
    L77:
        r118 = f557729a;
        goto L78
    L81:
        return new xz6.a(r210.a(r110, r112));
    }
}
