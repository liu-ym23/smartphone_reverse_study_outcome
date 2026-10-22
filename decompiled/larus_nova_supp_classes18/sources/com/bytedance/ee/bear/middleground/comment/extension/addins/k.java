package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements ReactionFlowLayout.b {
    public final /* synthetic */ CardAdapterAddin a;
    public final /* synthetic */ CommentBean.CommentDetail b;

    public k(CardAdapterAddin r1, CommentBean.CommentDetail r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r5) {
        HashMap r0 = new HashMap();
        r0.put("emoji_type", r5);
        this.a.d().d0.o("user_name", this.b.getComment_id(), r0);
        com.bytedance.ee.bear.middleground.comment.control.y r1 = this.a.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r1 = null;
    L5:
        FragmentManager r2 = this.a.d().getActivity().getSupportFragmentManager();
        CommentBean.CommentDetail r3 = this.b;
        Intrinsics.checkNotNull(r5);
        r1.G(r2, r3, r5);
    }
}
