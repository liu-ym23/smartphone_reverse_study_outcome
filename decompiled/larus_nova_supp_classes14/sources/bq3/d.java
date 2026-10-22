package bq3;

import android.view.View;
import aq3.e;
import aq3.f;
import aq3.g;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends b {
    public final cq3.a n;

    public final List<aq3.a> i() {
        vp.c r0 = new vp.c();
        return CollectionsKt.listOf(new aq3.a[]{new g(this.m.findViewById(2131370919), this.n.c, r0), new aq3.d(this.m.findViewById(2131370911)), new aq3.c(this.m.findViewById(2131370908), this.n.d), new aq3.b(this.m.findViewById(2131370904), r0), new e(this.m.findViewById(2131370912)), new f(this.m.findViewById(2131370917))});
    }

    public d(View r2, vp.c r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "proxy");
        super(r2);
        cq3.a r4 = new cq3.a();
        r3.a = r4;
        Unit r5 = Unit.INSTANCE;
        this.n = r4;
    }
}
