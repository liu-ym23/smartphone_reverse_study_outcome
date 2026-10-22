package trc;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f547335a = null;

    static {
        f547335a = LazyKt.lazy(new c());
    }

    public static final double a(double r100, int r101) {
        if (r101 <= 0) goto L4;
        Double r102 = (Double) ((Map) f547335a.getValue()).get(Integer.valueOf(r101 - 1));
        if (r102 == null) goto L9;
        double r103 = r102.doubleValue();
        return ((double) MathKt.roundToInt(r100 * r103)) / r103;
    L9:
        return r100;
    L4:
        return MathKt.roundToLong(r100);
    }
}
