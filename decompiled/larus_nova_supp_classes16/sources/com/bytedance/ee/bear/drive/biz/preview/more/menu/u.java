package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements e0 {
    public final /* synthetic */ a a;

    public u(a r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        FragmentActivity r4 = a.b(this.a);
        if (r4 != null) goto L6;
        d0 r5 = d0.c;
        tt5.a.k("DriveBaselineMoreItemFactories", "add to nav noop, activity is null");
        return r5;
    L6:
        com.bytedance.ee.bear.more.protocol3.g r6 = new f65.b().a(r4, this.a.a);
        if (r6 == null) goto L9;
        return r6;
    L9:
        return d0.c;
    }
}
