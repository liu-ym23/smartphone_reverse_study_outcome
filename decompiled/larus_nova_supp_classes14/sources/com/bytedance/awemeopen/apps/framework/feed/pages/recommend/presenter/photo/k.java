package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements nz3.d {
    public final /* synthetic */ PhotoFeedPagerPresenter a;

    @Override // nz3.d
    public final void a() {
        nz3.d r0 = this.a.O;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // nz3.d
    public final boolean b() {
        nz3.d r0 = this.a.O;
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        if (r1 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.a.v != 0) goto L10;
        return true;
    L5:
        r1 = true;
        goto L6
    }

    @Override // nz3.d
    public final void c() {
        nz3.d r0 = this.a.O;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // nz3.d
    public final boolean d() {
        nz3.d r0 = this.a.O;
        if (r0 == null) goto L5;
        boolean r1 = r0.d();
    L6:
        if (r1 == false) goto L10;
        PhotoFeedPagerPresenter r2 = this.a;
        if (r2.v != (r2.o() - 1)) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = true;
        goto L6
    }

    public k(PhotoFeedPagerPresenter r1) {
        this.a = r1;
    }
}
