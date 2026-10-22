package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements nz3.a {
    public final /* synthetic */ PhotoFeedPagerPresenter a;

    @Override // nz3.a
    public final boolean a() {
        if (this.a.v != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // nz3.a
    public final boolean b() {
        PhotoFeedPagerPresenter r0 = this.a;
        int r1 = r0.v;
        r14.c r2 = r0.t;
        if (r2 == null) goto L7;
        List r3 = r2.v();
        if (r3 == null) goto L7;
        int r4 = r3.size();
    L9:
        if (r1 != (r4 - 1)) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = 0;
        goto L9
    }

    public n(PhotoFeedPagerPresenter r1) {
        this.a = r1;
    }
}
