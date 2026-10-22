package xr9;

import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import kotlin.jvm.internal.Intrinsics;
import wr9.k;
import wr9.l;

/* JADX INFO: loaded from: classes31.dex */
public final class g {
    public static final wr9.d a(wr9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("unitm_status_unavailable", "reason");
        if (r100.f560886a != 0) goto L7;
        int r101 = wr9.d.f560885f;
        return wr9.d.a.a(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, r100.f560888c, r100.f560889d, "unitm_status_unavailable");
    L7:
        return wr9.d.a(r100, PowerMetricAvailability.STALE, "unitm_status_unavailable", 13);
    }

    public static final wr9.j b(long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "reason");
        return new wr9.j(r110, new l(c(r110, r111), c(r110, r111), c(r110, r111), c(r110, r111), c(r110, r111)), new wr9.b(c(r110, r111), c(r110, r111)), new wr9.c(c(r110, r111), c(r110, r111), c(r110, r111), c(r110, r111)), new wr9.a(c(r110, r111), c(r110, r111), c(r110, r111)), new k(c(r110, r111), c(r110, r111), c(r110, r111), c(r110, r111)));
    }

    public static final <T> wr9.d<T> c(long r100, String r101) {
        int r102 = wr9.d.f560885f;
        return wr9.d.a.a(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, PowerMetricSource.UNKNOWN, r100, r101);
    }
}
