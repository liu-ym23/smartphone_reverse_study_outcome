package ou1;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Iterator;
import java.util.Map;
import ju1.h;
import ju1.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import lu1.m;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements nu1.f<ju1.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu1.b f526721a;

    public static final class a {
    }

    static {
    }

    public d() {
        nu1.a r100 = nu1.a.f520601a;
        Intrinsics.checkNotNullParameter(r100, "expressionExecutor");
        this.f526721a = r100;
    }

    public static double b(double r100, ju1.d r101) {
        return Math.pow(r101.h() + (r100 * r101.e()), r101.a());
    }

    public static double c(String r100, Map r101) {
        Object r102 = r101.get(r100);
        if ((r102 instanceof Number) == true) goto L5;
        r102 = null;
    L5:
        Number r103 = (Number) r102;
        if (r103 != null) goto L10;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L10:
        return r103.doubleValue();
    }

    @Override // nu1.f
    public final n a(h r210, Map r211) {
        ju1.f r100 = (ju1.f) r210;
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r211, "stateMap");
        Iterator r101 = CollectionsKt.filterNotNull(r100.j()).iterator();
        double r102 = 1.0d;
    L4:
        if (r101.hasNext() == false) goto L40;
        ju1.d r103 = (ju1.d) r101.next();
        String r104 = r103.d();
        switch(r104.hashCode()) {
            case -1795452264: goto L27;
            case 107332: goto L19;
            case 3526476: goto L16;
            case 102977278: goto L9;
            default: goto L33;
        };
    L33:
        double r105 = 1.0d;
    L35:
        if (r103.i() == true) goto L36;
        if (r105 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L4;
        r102 = r102 / r105;
        goto L4
    L36:
        r102 = r102 * r105;
        goto L4
    L9:
        if (r104.equals("liner") == false) goto L33;
        double r106 = c(r103.c(), r211);
        int r110 = m.f510824a;
        double r111 = r103.f();
        double r112 = r103.g();
        if (r111 != r112) goto L13;
        ALogger.e("LinearNormalization", "pMax==pMin, divide zero exception");
        double r107 = 0.0d;
    L14:
        double r108 = b(r107, r103);
    L25:
        r105 = r108;
        goto L35
    L13:
        r107 = (Math.min(r106, r111) - r112) / (r111 - r112);
        goto L14
    L16:
        if (r104.equals("self") == false) goto L33;
        r108 = b(c(r103.c(), r211), r103);
        goto L25
    L19:
        if (r104.equals("log") == false) goto L33;
        double r109 = c(r103.c(), r211);
        int r113 = m.f510824a;
        double r114 = MathKt.log2(Math.max(1.0d, r109));
        double r115 = r103.f();
        double r116 = r103.g();
        if (r115 != r116) goto L23;
        ALogger.e("LinearNormalization", "pMax==pMin, divide zero exception");
        double r117 = 0.0d;
    L24:
        r108 = b(r117, r103);
        goto L25
    L23:
        r117 = (Math.min(r114, r115) - r116) / (r115 - r116);
        goto L24
    L27:
        if (r104.equals("expression") == false) goto L33;
        if (Intrinsics.areEqual(this.f526721a.a(r103.b(), r211), Boolean.TRUE) == false) goto L31;
        double r118 = 1.0d;
    L32:
        r105 = b(r118, r103);
        goto L35
    L31:
        r118 = 0.0d;
        goto L32
    L40:
        Iterator r119 = CollectionsKt.filterNotNull(r100.k()).iterator();
    L41:
        Integer r120 = null;
        if (r119.hasNext() == false) goto L49;
        Object r121 = r119.next();
        if (r102 < ((ju1.e) r121).b()) goto L46;
        boolean r122 = true;
    L47:
        if (r122 == false) goto L41;
    L50:
        ju1.e r123 = (ju1.e) r121;
        if (r123 == null) goto L53;
        r120 = Integer.valueOf(r123.a());
    L53:
        if (r120 == null) goto L56;
        r120.intValue();
        return new ju1.g(r120.intValue(), false, r211, r100.i());
    L56:
        return new ju1.g(r100.g(), true, r211, r100.i());
    L46:
        r122 = false;
        goto L47
    L49:
        r121 = null;
        goto L50
    }
}
