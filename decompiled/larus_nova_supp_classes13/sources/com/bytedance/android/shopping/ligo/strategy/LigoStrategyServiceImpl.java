package com.bytedance.android.shopping.ligo.strategy;

import b93.b;
import b93.c;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.livesdk.livecommerce.eventcenter.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LigoStrategyServiceImpl implements c {
    public final Lazy a;

    public LigoStrategyServiceImpl() {
        this.a = LazyKt.lazy(LigoStrategyServiceImpl$realSerivce$2.INSTANCE);
    }

    @Override // b93.c
    public final b b() {
        if (ECSettingKeys.z() == true) goto L7;
        return null;
    L7:
        return ((LigoStrategyService) this.a.getValue()).b();
    }

    @Override // b93.c
    public final void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        if (ECSettingKeys.z() == true) goto L5;
        return;
    L5:
        ((LigoStrategyService) this.a.getValue()).a(r2);
    }
}
