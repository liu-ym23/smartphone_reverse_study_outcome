package com.bytedance.ee.bear.creationmenu;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f217321a;

    public d(c r100) {
        this.f217321a = r100;
    }

    @Override // com.bytedance.ee.bear.creationmenu.f
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItem");
        hac.b.f484427a.b("CreationMenuItemView", "setWikiMenuItemClickListener onMenuClick " + r100.f217324c);
        f r101 = this.f217321a.B;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        Dialog r102 = this.f217321a.f217304n;
        if (r102 == null) goto L9;
        r102.cancel();
        return;
    }
}
