package com.bytedance.ee.bear.facade.common.empty;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final Config a(Function1<? super Config, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "build");
        Config r0 = new Config();
        r1.invoke(r0);
        return r0;
    }
}
