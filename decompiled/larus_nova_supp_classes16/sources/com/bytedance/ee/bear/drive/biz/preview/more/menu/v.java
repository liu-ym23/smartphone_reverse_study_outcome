package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements e0 {
    public final /* synthetic */ a a;

    public v(a r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        FragmentActivity r4 = a.b(this.a);
        if (r4 != null) goto L6;
        d0 r5 = d0.c;
        tt5.a.k("DriveBaselineMoreItemFactories", "floating window noop, activity is null");
        return r5;
    L6:
        f65.a r0 = new f65.a(new f65.b(), r4);
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).F(r0);
    }
}
