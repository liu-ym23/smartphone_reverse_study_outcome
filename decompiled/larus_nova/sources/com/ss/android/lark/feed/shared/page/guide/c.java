package com.ss.android.lark.feed.shared.page.guide;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import ujb.d;
import ujb.f;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements d.a {
    public c(a.InterfaceC4967a r100) {
    }

    @Override // ujb.d.a
    public final void a(View r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        heb.a.f484903a.getGuideDependency().c();
        r101.close();
    }
}
