package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedCommentDetailBean f232676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedItemComment f232677b;

    public g(FeedCommentDetailBean r100, FeedItemComment r101) {
        this.f232676a = r100;
        this.f232677b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (TextUtils.isEmpty(this.f232676a.getUser_id()) == true) goto L6;
        this.f232677b.f232624f.invoke(this.f232676a.getUser_id());
        return;
    }
}
