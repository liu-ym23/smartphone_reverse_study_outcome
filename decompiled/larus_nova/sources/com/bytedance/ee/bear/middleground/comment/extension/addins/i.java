package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements ReactionFlowLayout.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardAdapterAddin.CardAdapterActionEventHandler f231481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactionViewHolder f231482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommentBean.CommentDetail f231483c;

    public i(CardAdapterAddin.CardAdapterActionEventHandler r100, ReactionViewHolder r101, CommentBean.CommentDetail r102) {
        this.f231481a = r100;
        this.f231482b = r101;
        this.f231483c = r102;
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout.e
    public final void a() {
        this.f231481a.d(this.f231482b, this.f231483c);
    }
}
