package com.bytedance.ee.bear.document.more;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p0 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ i b;

    public p0(boolean r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        if (this.a == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).s(this.b.a);
    }
}
