package s0;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f539998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f539999b;

    public k() {
    }

    static {
        f539998a = new LinearInterpolator();
    }

    public static void b(int r100, WeakReference<Interpolator> r101) {
        monitor-enter(k.class);
        f539999b.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(k.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static <T> v0.a<T> a(JsonReader r110, LottieComposition r111, float r112, s<T> r210, boolean r211) throws IOException {
        if (r211 == false) goto L95;
        r110.beginObject();
        Interpolator r100 = null;
        PointF r101 = null;
        PointF r102 = null;
        T r103 = null;
        T r113 = null;
        PointF r114 = null;
        PointF r115 = null;
        boolean r104 = false;
        float r116 = 0.0f;
    L6:
        if (r110.hasNext() == false) goto L55;
        String r117 = r110.nextName();
        r117.getClass();
        byte r118 = -1;
        switch(r117.hashCode()) {
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
        switch(r118) {
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
        r115 = j.b(r110, r112);
        goto L6
    L45:
        r114 = j.b(r110, r112);
        goto L6
    L46:
        r116 = (float) r110.nextDouble();
        goto L6
    L47:
        r113 = r210.a(r110, r112);
        goto L6
    L48:
        r101 = j.b(r110, r112);
        goto L6
    L49:
        r102 = j.b(r110, r112);
        goto L6
    L51:
        if (r110.nextInt() == 1) goto L52;
        r104 = false;
        goto L6
    L52:
        r104 = true;
        goto L6
    L54:
        r103 = r210.a(r110, r112);
        goto L6
    L43:
        r110.skipValue();
        goto L6
    L11:
        if (r117.equals(RemoteMessageConst.TO) == false) goto L42;
        r118 = 7;
        goto L42
    L15:
        if (r117.equals("ti") == false) goto L42;
        r118 = 6;
        goto L42
    L19:
        if (r117.equals("t") == false) goto L42;
        r118 = 5;
        goto L42
    L23:
        if (r117.equals("s") == false) goto L42;
        r118 = 4;
        goto L42
    L27:
        if (r117.equals("o") == false) goto L42;
        r118 = 3;
        goto L42
    L31:
        if (r117.equals(RXScreenCaptureService.KEY_INDEX) == false) goto L42;
        r118 = 2;
        goto L42
    L35:
        if (r117.equals("h") == false) goto L42;
        r118 = 1;
        goto L42
    L39:
        if (r117.equals("e") == false) goto L42;
        r118 = 0;
        goto L42
    L55:
        r110.endObject();
        if (r104 == false) goto L58;
        Interpolator r119 = f539998a;
        T r120 = r113;
    L92:
        v0.a<T> r105 = new v0.a(r111, r113, r120, r119, r116, null);
        r105.f552286m = r115;
        r105.f552287n = r114;
        return r105;
    L58:
        if (r101 == null) goto L90;
        if (r102 == null) goto L90;
        float r106 = -r112;
        r101.x = u0.e.b(r101.x, r106, r112);
        r101.y = u0.e.b(r101.y, -100.0f, 100.0f);
        r102.x = u0.e.b(r102.x, r106, r112);
        float r107 = u0.e.b(r102.y, -100.0f, 100.0f);
        r102.y = r107;
        float r108 = r101.x;
        float r109 = r101.y;
        float r121 = r102.x;
        u0.f.a r122 = u0.f.f548112a;
        if (r108 == 0.0f) goto L63;
        int r123 = (int) (TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER * r108);
    L65:
        if (r109 == 0.0f) goto L68;
        r123 = (int) ((r123 * 31) * r109);
    L68:
        if (r121 == 0.0f) goto L71;
        r123 = (int) ((r123 * 31) * r121);
    L71:
        if (r107 == 0.0f) goto L74;
        r123 = (int) ((r123 * 31) * r107);
    L74:
        monitor-enter(k.class);
    L87:
        th = move-exception;
        throw th;
    L76:
        if (f539999b != null) goto L78;
        f539999b = new SparseArrayCompat();     // Catch: Throwable -> L87
    L78:
        WeakReference<Interpolator> r124 = f539999b.get(r123);     // Catch: Throwable -> L87
        monitor-exit(k.class);     // Catch: Throwable -> L87
        if (r124 == null) goto L82;
        r100 = r124.get();
    L82:
        if (r124 == null) goto L84;
        if (r100 == null) goto L84;
    L91:
        r119 = r100;
        r120 = r103;
    L84:
        r100 = PathInterpolatorCompat.create(r101.x / r112, r101.y / r112, r102.x / r112, r102.y / r112);
        b(r123, new WeakReference(r100));     // Catch: ArrayIndexOutOfBoundsException -> L96
        goto L91
    L63:
        r123 = 17;
    L90:
        r100 = f539998a;
        goto L91
    L95:
        return new v0.a(r210.a(r110, r112));
    }
}
