package com.bytedance.ee.bear.wikiv2.home2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements gqa.d {
    public final /* synthetic */ k a;

    public n(k r1) {
        this.a = r1;
    }

    public final void d2(cqa.h r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        k.b r3 = this.a.m;
        if (r3 == null) goto L6;
        r3.onRefresh();
        return;
    }
}
