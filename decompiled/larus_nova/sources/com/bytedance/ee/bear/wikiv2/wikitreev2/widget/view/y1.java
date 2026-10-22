package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.core.view.ViewCompat;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;

/* JADX INFO: loaded from: classes18.dex */
public final class y1 implements koa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTreeView f242614a;

    @Override // koa.a
    public final void b() {
        this.f242614a.getStickyHeadContainerFromXml().f404339c = Integer.MIN_VALUE;
        this.f242614a.getStickyHeadContainerFromXml().setVisibility(4);
    }

    public y1(WikiTreeView r100) {
        this.f242614a = r100;
    }

    @Override // koa.a
    public final void a(int r100) {
        StickyHeadContainer r101 = this.f242614a.getStickyHeadContainerFromXml();
        if (r101.f404338b == r100) goto L5;
        r101.f404337a = r100;
        ViewCompat.offsetTopAndBottom(r101.getChildAt(0), r101.f404337a - r101.f404338b);
    L5:
        r101.f404338b = r101.f404337a;
        this.f242614a.getStickyHeadContainerFromXml().setVisibility(0);
    }
}
