package com.bytedance.ee.bear.wikiv2.home2;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f240854a;

    public l(k r100) {
        this.f240854a = r100;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout r100, int r101) {
        k r102 = this.f240854a;
        if (r102.f240852l != r101) goto L5;
        return;
    L5:
        r102.f240852l = r101;
        if (r101 != 0) goto L11;
        com.bytedance.ee.bear.list.homepage.title.b r103 = r102.f240843c;
        if (r103 == null) goto L12;
        r103.b();
        return;
    L12:
        return;
    }
}
