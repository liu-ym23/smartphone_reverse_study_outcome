package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.incentive.balance.b.d f528340b;

    public d() {
        this.f528340b = com.bytedance.android.live.incentive.balance.b.d.f69335a;
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final com.bytedance.android.live.incentive.balance.b a() {
        return this.f528340b;
    }

    @Override // pa0.l
    public final Long d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "incomeInfo");
        k r101 = g.b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return g.c(r101);
    }
}
