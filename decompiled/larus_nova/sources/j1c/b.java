package j1c;

import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends g1c.a<Map<String, ? extends Double>> implements i1c.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f496894d;

    public static final class a {
    }

    static {
    }

    @Override // g1c.b
    public final boolean isValid() {
        return true;
    }

    public b() {
        super(new HashMap());
        this.f496894d = com.ss.android.lark.preload.c.a().getHitRateDisableValue();
    }

    @Override // g1c.b
    public final Class<k1c.b<Map<String, Double>>> b() {
        return l1c.b.class;
    }

    @Override // g1c.a, g1c.b
    public final void e(o1c.c<?, ?> r110) {
        Intrinsics.checkNotNullParameter(r110, "task");
        Intrinsics.checkNotNullParameter(r110, "task");
        Map r100 = (Map) this.f479633c;
        if (r100 == null) goto L28;
        Double r101 = (Double) r100.get(r110.getClass().getSimpleName());
        if (r101 == null) goto L29;
        double r102 = r101.doubleValue();
        if (r102 <= 0.9d) goto L11;
        int r103 = 8;
    L9:
        boolean r104 = true;
    L23:
        Log.d("PreloadHitRate", "checkCondition PreloadHitRate:" + r110 + " / " + r102 + " / " + r103 + " / " + r104 + " / " + this.f496894d);
        r110.setPriority(r110.getPriority() + (r103 * 10));
        if (r104 == false) goto L26;
        d r111 = r110.R();
        r111.f521750a = true;
        r111.f521751b = null;
        r111.f521752c = null;
        return;
    L26:
        d r112 = r110.R();
        Map<String, ? extends Object> r105 = MapsKt.mapOf(TuplesKt.to("frequency", Double.valueOf(r102)));
        r112.f521750a = false;
        r112.f521751b = "PreloadHitRate";
        r112.f521752c = r105;
        return;
    L11:
        if (r102 <= 0.7d) goto L14;
        r103 = 6;
        goto L9
    L14:
        if (r102 <= 0.5d) goto L17;
        r103 = 2;
        goto L9
    L17:
        if (r102 <= 0.3d) goto L20;
        r103 = -2;
        goto L9
    L20:
        if (r102 <= this.f496894d) goto L22;
        r103 = -4;
        goto L9
    L22:
        r103 = -6;
        r104 = false;
        goto L23
    L29:
        return;
    }
}
