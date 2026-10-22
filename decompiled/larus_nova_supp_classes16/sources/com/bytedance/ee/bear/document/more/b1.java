package com.bytedance.ee.bear.document.more;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b1 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public b1(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r3, com.bytedance.ee.bear.more.protocol3.panel.e r4) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        com.bytedance.ee.bear.contract.route.parcelable.a r5 = (com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6);
        DocumentPluginHost r6 = this.a.a;
        return r5.c(r6, r6.a().getDocTitle(), Boolean.TRUE);
    }
}
