package com.ss.android.lark.feed.shared.page.binder2;

import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements bw7.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedCommonViewHolder f421369a;

    @Override // bw7.b.c
    public final void a() {
    }

    public k(FeedCommonViewHolder r100) {
        this.f421369a = r100;
    }

    @Override // bw7.b.c
    public final void b(int r100) {
        if (r100 != 0) goto L4;
    L6:
        FeedCommonViewHolder r101 = this.f421369a;
        r101.f276058e = 0.0f;
        UIFeedCard r102 = r101.H;
        if (r102 == null) goto L10;
        r102.setSwipeRightPinned(false);
        return;
    L10:
        return;
    L4:
        if (r100 == 1) goto L6;
    }
}
