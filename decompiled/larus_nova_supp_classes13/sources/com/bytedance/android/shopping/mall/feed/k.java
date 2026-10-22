package com.bytedance.android.shopping.mall.feed;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements k93.f {
    public final /* synthetic */ ECMallFeed.a a;

    public k(ECMallFeed.a r1) {
        this.a = r1;
    }

    @Override // k93.f
    public final void a(String r2, boolean r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "lastActionInfo");
        this.a.b.X(r2, r3, r4);
    }
}
