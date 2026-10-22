package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.rename.RenameItemV2;
import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements e0 {
    public final /* synthetic */ a a;

    public j(a r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        FragmentActivity r4 = a.b(this.a);
        if (r4 != null) goto L7;
        d0 r5 = d0.c;
        tt5.a.k("DriveBaselineMoreItemFactories", "rename noop, activity is null");
        return r5;
    L7:
        return new RenameItemV2(r4, this.a.a);
    }
}
