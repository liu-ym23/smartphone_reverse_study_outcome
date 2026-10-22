package com.bytedance.android.shopping.store.tabkit.container;

import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T, R> implements Function {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2) {
        ECStorePreloadInfoResponse r3 = (ECStorePreloadInfoResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        return r3;
    }
}
