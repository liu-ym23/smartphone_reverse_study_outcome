package com.bytedance.ee.bear.document.more;

import com.bytedance.ee.bear.document.bitable.BitableProMoreItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public p(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        return new BitableProMoreItem(this.a.a);
    }
}
