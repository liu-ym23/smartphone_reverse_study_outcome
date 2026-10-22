package com.bytedance.awemeopen.apps.photo.presenter;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m0 implements nz3.a {
    public final /* synthetic */ PhotoPagerPresenter a;

    @Override // nz3.a
    public final boolean a() {
        if (this.a.A != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // nz3.a
    public final boolean b() {
        PhotoPagerPresenter r0 = this.a;
        int r1 = r0.A;
        r14.c r2 = r0.y;
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

    public m0(PhotoPagerPresenter r1) {
        this.a = r1;
    }
}
