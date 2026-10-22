package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ FeedItemComment a;
    public final /* synthetic */ FeedCommentDetailBean b;

    public h(FeedItemComment r1, FeedCommentDetailBean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Function2<String, Boolean, Unit> r5 = this.a.e;
        String r0 = this.b.getMessageId();
        boolean r2 = true;
        if (this.b.getIs_whole() == 1) goto L6;
        r2 = false;
    L6:
        r5.invoke(r0, Boolean.valueOf(r2));
    }
}
