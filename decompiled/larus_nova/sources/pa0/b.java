package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.incentive.balance.b.C1124b f528338b;

    public b() {
        this.f528338b = com.bytedance.android.live.incentive.balance.b.C1124b.f69333a;
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final com.bytedance.android.live.incentive.balance.b a() {
        return this.f528338b;
    }

    @Override // pa0.l
    public final Long d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "incomeInfo");
        k r101 = g.b(r100);
        if (r101 == null) goto L16;
        Intrinsics.checkNotNullParameter(r101, "$this$getEquivalentCashValue");
        long r102 = 0;
        if (r101.f528344a.getEquivalentCashValue() < 0) goto L7;
        long r103 = r101.f528344a.getEquivalentCashValue();
    L18:
        return Long.valueOf(r103);
    L7:
        Intrinsics.checkNotNullParameter(r101, "$this$cashBalanceOrZero");
        Long r104 = g.a(r101);
        if (r104 == null) goto L10;
        long r105 = r104.longValue();
    L11:
        long r106 = r105 + 0;
        Intrinsics.checkNotNullParameter(r101, "$this$goldBalanceOrZero");
        Long r107 = g.c(r101);
        if (r107 == null) goto L14;
        r102 = r107.longValue();
    L14:
        r103 = r106 + r102;
        goto L18
    L10:
        r105 = 0;
        goto L11
    L16:
        return null;
    }
}
