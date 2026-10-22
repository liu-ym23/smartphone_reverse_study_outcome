package com.bytedance.ee.bear.wikiv2.home2;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements AppBarLayout.OnOffsetChangedListener {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    public final void onOffsetChanged(AppBarLayout r2, int r3) {
        k r4 = this.a;
        if (r4.l != r3) goto L5;
        return;
    L5:
        r4.l = r3;
        if (r3 != 0) goto L11;
        com.bytedance.ee.bear.list.homepage.title.b r5 = r4.c;
        if (r5 == null) goto L12;
        r5.b();
        return;
    L12:
        return;
    }
}
