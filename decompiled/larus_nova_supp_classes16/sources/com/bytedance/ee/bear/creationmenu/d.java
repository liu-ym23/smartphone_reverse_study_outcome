package com.bytedance.ee.bear.creationmenu;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements f {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.creationmenu.f
    public final void a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "menuItem");
        hac.b.a.b("CreationMenuItemView", "setWikiMenuItemClickListener onMenuClick " + r4.c);
        f r0 = this.a.B;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        Dialog r5 = this.a.n;
        if (r5 == null) goto L9;
        r5.cancel();
        return;
    }
}
