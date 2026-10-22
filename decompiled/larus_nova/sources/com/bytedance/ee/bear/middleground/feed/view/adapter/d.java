package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedCommentDetailBean f232667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter<?> f232668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f232669c;

    public d(FeedCommentDetailBean r100, RecyclerView.Adapter<?> r101, int r102) {
        this.f232667a = r100;
        this.f232668b = r101;
        this.f232669c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().put(this.f232667a.getReply_id(), Boolean.valueOf(!Intrinsics.areEqual(((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h().get(this.f232667a.getReply_id()), Boolean.TRUE)));
        this.f232668b.notifyItemChanged(this.f232669c);
    }
}
