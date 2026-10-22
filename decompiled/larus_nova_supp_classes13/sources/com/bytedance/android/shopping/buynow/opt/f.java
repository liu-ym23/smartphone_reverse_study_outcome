package com.bytedance.android.shopping.buynow.opt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public final Lazy a;
    public final Class<?> b;
    public final String c;

    public f(Class r3, final Class... r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter("getThemeResId", "name");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.b = r3;
        this.c = "getThemeResId";
        this.a = LazyKt.lazy(new Method$method$2(this, r4));
    }
}
