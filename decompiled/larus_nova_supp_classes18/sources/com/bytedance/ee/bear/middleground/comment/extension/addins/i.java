package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements ReactionFlowLayout.e {
    public final /* synthetic */ CardAdapterAddin.CardAdapterActionEventHandler a;
    public final /* synthetic */ ReactionViewHolder b;
    public final /* synthetic */ CommentBean.CommentDetail c;

    public i(CardAdapterAddin.CardAdapterActionEventHandler r1, ReactionViewHolder r2, CommentBean.CommentDetail r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        this.a.d(this.b, this.c);
    }
}
