package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ FeedCommentDetailBean a;
    public final /* synthetic */ FeedItemComment b;

    public g(FeedCommentDetailBean r1, FeedItemComment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (TextUtils.isEmpty(this.a.getUser_id()) == true) goto L6;
        this.b.f.invoke(this.a.getUser_id());
        return;
    }
}
