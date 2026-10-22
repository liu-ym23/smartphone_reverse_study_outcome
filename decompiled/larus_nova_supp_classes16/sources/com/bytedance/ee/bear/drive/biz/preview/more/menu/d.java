package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements e0 {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.more.fresh_content") == false) goto L6;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).G();
    L6:
        return d0.c;
    }
}
