package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FeedCommentDetailBean a;
    public final /* synthetic */ RecyclerView.Adapter<?> b;
    public final /* synthetic */ int c;

    public d(FeedCommentDetailBean r1, RecyclerView.Adapter<?> r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().put(this.a.getReply_id(), Boolean.valueOf(!Intrinsics.areEqual(((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().get(this.a.getReply_id()), Boolean.TRUE)));
        this.b.notifyItemChanged(this.c);
    }
}
