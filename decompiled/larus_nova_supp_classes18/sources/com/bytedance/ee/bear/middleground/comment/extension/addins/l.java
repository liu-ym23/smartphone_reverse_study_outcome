package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements View.OnLongClickListener {
    public final /* synthetic */ CardAdapterAddin.CardAdapterActionEventHandler a;
    public final /* synthetic */ ReactionViewHolder b;
    public final /* synthetic */ CommentBean.CommentDetail c;

    public l(CardAdapterAddin.CardAdapterActionEventHandler r1, ReactionViewHolder r2, CommentBean.CommentDetail r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        this.a.d(this.b, this.c);
        return true;
    }
}
