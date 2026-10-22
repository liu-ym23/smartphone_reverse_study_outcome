package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.core.view.ViewCompat;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y1 implements koa.a {
    public final /* synthetic */ WikiTreeView a;

    public final void b() {
        this.a.getStickyHeadContainerFromXml().c = Integer.MIN_VALUE;
        this.a.getStickyHeadContainerFromXml().setVisibility(4);
    }

    public y1(WikiTreeView r1) {
        this.a = r1;
    }

    public final void a(int r5) {
        StickyHeadContainer r0 = this.a.getStickyHeadContainerFromXml();
        if (r0.b == r5) goto L5;
        r0.a = r5;
        ViewCompat.offsetTopAndBottom(r0.getChildAt(0), r0.a - r0.b);
    L5:
        r0.b = r0.a;
        this.a.getStickyHeadContainerFromXml().setVisibility(0);
    }
}
