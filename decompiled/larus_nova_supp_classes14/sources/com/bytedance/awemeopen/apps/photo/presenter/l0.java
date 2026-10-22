package com.bytedance.awemeopen.apps.photo.presenter;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 implements nz3.e {
    public final /* synthetic */ PhotoPagerPresenter a;

    @Override // nz3.e
    public final void a() {
    }

    @Override // nz3.e
    public final boolean b() {
        PhotoPagerPresenter r0 = this.a;
        int r1 = r0.A;
        r14.c r2 = r0.y;
        if (r2 == null) goto L7;
        List r3 = r2.v();
        if (r3 == null) goto L7;
        int r4 = r3.size();
    L9:
        if (r1 == (r4 - 1)) goto L19;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.o r5 = this.a.C;
        r5.getClass();
        long r6 = System.currentTimeMillis();
        if ((r6 - r5.b) >= 1000) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        r5.b = r6;
    L16:
        if (r7 == true) goto L19;
        return false;
    L13:
        r7 = false;
    L19:
        return true;
    L7:
        r4 = 0;
        goto L9
    }

    @Override // nz3.e
    public final boolean intercept() {
        PhotoPagerPresenter r0 = this.a;
        int r1 = r0.A;
        if (r1 != 0) goto L5;
        return true;
    L5:
        if (r1 == (r0.o() - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    public l0(PhotoPagerPresenter r1) {
        this.a = r1;
    }
}
