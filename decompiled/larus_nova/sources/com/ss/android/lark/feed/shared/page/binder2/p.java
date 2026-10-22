package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aeb.d f421372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIFeedCard f421373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ aeb.a f421374c;

    public p(aeb.d r100, UIFeedCard r101, e r102) {
        this.f421372a = r100;
        this.f421373b = r101;
        this.f421374c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f421372a.o(this.f421373b, FeedActionEvent.RIGHT_SWIPE_SHORT, this.f421374c);
        Log.i("FeedSharedModule_FeedCommonViewHolder", "click done view, feedId=" + this.f421373b.getId());
    }
}
