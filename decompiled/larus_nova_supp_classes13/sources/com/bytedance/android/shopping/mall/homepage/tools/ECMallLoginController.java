package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallLoginController {
    public final Lazy a;
    public final Context b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.shopping.mall.utils.a a() {
        return (com.bytedance.android.shopping.mall.utils.a) this.a.getValue();
    }

    public ECMallLoginController(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.a = LazyKt.lazy(new ECMallLoginController$localStorage$2(this));
    }
}
