package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ FeedItemComment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ FeedCommentDetailBean c;

    public f(FeedItemComment r1, int r2, FeedCommentDetailBean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r8) {
        Function5<View, Integer, String, String, String, Unit> r1 = this.a.d;
        Intrinsics.checkNotNull(r8);
        r1.invoke(r8, Integer.valueOf(this.b), this.c.getMessageId(), this.c.getComment_id(), this.c.getReply_id());
        return true;
    }
}
