package jc4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class l extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498120n;

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "qa";
    }

    @Override // jc4.a
    public final String g() {
        return "qa";
    }

    @Override // jc4.a
    public int getType() {
        return 3;
    }

    public l() {
        this.f498120n = null;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.b(r100, "isPop", !this.f498090a ? 1 : 0);
        hc4.f.c(r100, "uid", this.f498120n);
        com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
        hc4.f.b(r100, "use_dialog_size_v2", com.bytedance.bdturing.setting.e.h());
    }
}
