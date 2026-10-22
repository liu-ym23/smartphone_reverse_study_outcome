package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.layout.AosRecommendFeedLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final Function1<r14.c, Boolean> f;
    public final Function1<r14.c, Boolean> g;
    public boolean h;
    public boolean i;

    @Override // g04.a
    public final void g() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.i == true) goto L11;
        LifecycleOwner r0 = this.e.e.d;
        if ((r0 instanceof AosRecommendFeedLayout) == false) goto L12;
        ((AosRecommendFeedLayout) r0).setCanScroll2Profile(false);
        return;
    L12:
        return;
    }

    @Override // g04.a
    public final void i() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.i == true) goto L11;
        LifecycleOwner r0 = this.e.e.d;
        if ((r0 instanceof AosRecommendFeedLayout) == false) goto L12;
        ((AosRecommendFeedLayout) r0).setCanScroll2Profile(true);
        return;
    L12:
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        boolean r0 = ((Boolean) this.f.invoke(r4.a)).booleanValue();
        this.h = r0;
        if (r0 == false) goto L6;
        this.i = ((Boolean) this.g.invoke(r4.a)).booleanValue();
        return;
    }

    public a(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2, Function1<? super r14.c, Boolean> r3, Function1<? super r14.c, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r3, "isAdCallback");
        Intrinsics.checkNotNullParameter(r4, "canScroll2ProfileCallback");
        super(r2.a);
        this.e = r2;
        this.f = r3;
        this.g = r4;
    }
}
