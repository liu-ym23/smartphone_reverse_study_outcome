package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements ReactionFlowLayout.f {
    public final /* synthetic */ CardAdapterAddin a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ CommentBean.CommentDetail c;

    public m(CardAdapterAddin r1, RecyclerView r2, CommentBean.CommentDetail r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(String r5) {
        if (this.a.d().q.getComment() == false) goto L12;
        com.bytedance.ee.bear.middleground.comment.control.y r0 = this.a.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r0 = null;
    L7:
        RecyclerView r2 = this.b;
        if (r2 == null) goto L10;
        RecyclerView.Adapter r3 = r2.getAdapter();
    L11:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
        Intrinsics.checkNotNull(r5);
        r0.B((ICardAdapter) r3, r5, this.c, null);
        return;
    L10:
        r3 = null;
        goto L11
    L12:
        tt5.a.h("Comment#CardAdapterAddin", "click reaction but no comment permission, so do nothing");
    }
}
