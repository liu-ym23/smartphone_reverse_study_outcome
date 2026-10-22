package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final Function1<String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        this.a = r2;
    }
}
