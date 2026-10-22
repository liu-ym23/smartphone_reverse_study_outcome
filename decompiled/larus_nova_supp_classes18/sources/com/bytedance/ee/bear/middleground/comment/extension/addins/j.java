package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements ReactionFlowLayout.f {
    public final /* synthetic */ CardAdapterAddin a;
    public final /* synthetic */ CommentBean.CommentDetail b;
    public final /* synthetic */ ReactionViewHolder c;

    public j(CardAdapterAddin r1, CommentBean.CommentDetail r2, ReactionViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(String r4) {
        if (this.a.d().q.getComment() == false) goto L8;
        com.bytedance.ee.bear.middleground.comment.control.y r0 = this.a.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r0 = null;
    L7:
        Intrinsics.checkNotNull(r4);
        r0.s(r4, this.b, ((RecyclerView.ViewHolder) this.c).itemView);
        return;
    L8:
        tt5.a.h("Comment#CardAdapterAddin", "click reaction but no comment permission, so do nothing");
    }
}
