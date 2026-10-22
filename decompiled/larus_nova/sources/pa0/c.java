package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.incentive.balance.b.e f528339b;

    public c() {
        this.f528339b = com.bytedance.android.live.incentive.balance.b.e.f69336a;
    }

    @Override // com.bytedance.android.live.incentive.balance.c
    public final com.bytedance.android.live.incentive.balance.b a() {
        return this.f528339b;
    }

    @Override // pa0.l
    public final Long d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "incomeInfo");
        Integer r101 = Integer.valueOf(r100.a().getExchangeBalance());
        if (r101.intValue() < 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L12;
        return null;
    L12:
        return Long.valueOf(r101.intValue());
    L5:
        r102 = false;
        goto L7
    }
}
