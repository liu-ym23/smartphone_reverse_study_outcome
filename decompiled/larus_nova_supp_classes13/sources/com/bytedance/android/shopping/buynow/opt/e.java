package com.bytedance.android.shopping.buynow.opt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final Lazy a;
    public final Class<?> b;
    public final String c;

    public e(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter("assetsSeq", "name");
        this.b = r3;
        this.c = "assetsSeq";
        this.a = LazyKt.lazy(new Field$field$2(this));
    }
}
