package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements i24.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r14.c f196717a;

    public e(r14.c r100) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        this.f196717a = r100;
    }

    @Override // i24.b
    public final void a(final n48.e r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        d14.a r101 = b14.a.f16924a;
        ((i34.a) b14.a.a(i34.a.class)).g2(this.f196717a, new ShareHelper$getShortLinkShare$1(r100, this));
    }
}
