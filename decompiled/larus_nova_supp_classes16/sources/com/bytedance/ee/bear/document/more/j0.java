package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j0 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public j0(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        FragmentActivity r4 = i.a(this.a);
        if (r4 != null) goto L6;
        return null;
    L6:
        c25.b r5 = new c25.b();
        com.bytedance.ee.bear.more.protocol3.g r0 = r5.a(r4, this.a.a);
        if (r0 == null) goto L9;
        return r0;
    L9:
        return r5.c(r4);
    }
}
