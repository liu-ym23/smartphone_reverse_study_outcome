package com.bytedance.android.shopping.mall.feed;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements k93.b {
    public final /* synthetic */ ECMallFeed.a a;

    public f(ECMallFeed.a r1) {
        this.a = r1;
    }

    @Override // k93.b
    public final void a(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.b.u0(r2);
    }
}
