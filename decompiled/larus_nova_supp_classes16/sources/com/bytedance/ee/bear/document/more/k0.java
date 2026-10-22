package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k0 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public k0(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        FragmentActivity r4 = i.a(this.a);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new c25.b().c(r4);
    }
}
