package op3;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements e {
    public final Map<Pair<d, d>, Integer> a;

    public h() {
        d r0 = g.a;
        d r1 = g.a;
        d r2 = g.c;
        d r3 = g.d;
        d r4 = g.e;
        d r5 = g.f;
        d r6 = g.g;
        d r7 = g.h;
        d r8 = g.i;
        d r9 = g.b;
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(TuplesKt.to(r1, r2), 0), TuplesKt.to(TuplesKt.to(r2, r3), 6), TuplesKt.to(TuplesKt.to(r2, r4), 6), TuplesKt.to(TuplesKt.to(r2, r5), 6), TuplesKt.to(TuplesKt.to(r3, r5), 4), TuplesKt.to(TuplesKt.to(r4, r5), 4), TuplesKt.to(TuplesKt.to(r5, r6), 3), TuplesKt.to(TuplesKt.to(r5, r7), 4), TuplesKt.to(TuplesKt.to(r6, r7), 3), TuplesKt.to(TuplesKt.to(r7, r8), 4), TuplesKt.to(TuplesKt.to(r8, r9), 6), TuplesKt.to(TuplesKt.to(r7, r9), 6)});
    }

    @Override // op3.e
    public final int a(d r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        Integer r4 = this.a.get(TuplesKt.to(r2, r3));
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.intValue();
    }
}
