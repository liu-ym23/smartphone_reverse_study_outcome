package jc4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class h extends a {
    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "twice_verify";
    }

    @Override // jc4.a
    public final String g() {
        return "info_verify";
    }

    @Override // jc4.a
    public int getType() {
        return 10;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.c(r100, "decision_config", "block-info_verify");
        hc4.f.b(r100, "use_turing_bridge", 1);
    }
}
