package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements i24.b {
    public final r14.c a;

    public e(r14.c r2) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        this.a = r2;
    }

    public final void a(final n48.e r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        d14.a r0 = b14.a.a;
        b14.a.a(i34.a.class).g2(this.a, new ShareHelper$getShortLinkShare$1(r4, this));
    }
}
