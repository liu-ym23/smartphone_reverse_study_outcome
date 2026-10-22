package com.bytedance.ee.bear.facade.common.empty;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static final Config a(Function1<? super Config, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        Config r101 = new Config();
        r100.invoke(r101);
        return r101;
    }
}
