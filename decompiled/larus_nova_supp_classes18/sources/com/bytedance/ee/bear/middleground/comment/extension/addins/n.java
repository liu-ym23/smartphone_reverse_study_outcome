package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements ReactionFlowLayout.b {
    public final /* synthetic */ CardAdapterAddin a;
    public final /* synthetic */ CommentBean.CommentDetail b;

    public n(CardAdapterAddin r1, CommentBean.CommentDetail r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r4) {
        com.bytedance.ee.bear.middleground.comment.control.y r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r0 = null;
    L5:
        FragmentManager r1 = this.a.d().getActivity().getSupportFragmentManager();
        CommentBean.CommentDetail r2 = this.b;
        Intrinsics.checkNotNull(r4);
        r0.G(r1, r2, r4);
    }
}
