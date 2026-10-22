package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.input.AsideInputComment;
import com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements CommentCollaboratorControlFragmentV2.b {
    public final /* synthetic */ AsidePageAdapter.ViewHolder a;

    @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2.b
    public final void onDismiss() {
        AsideInputComment r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.l();
        return;
    }

    public g(AsidePageAdapter.ViewHolder r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2.b
    public final void a(int r3) {
        AsideInputComment r0 = this.a.g;
        if (r0 == null) goto L9;
        VisibilityBean r1 = r0.j.visibilityBean;
        if (r1 == null) goto L7;
        r1.setType(r3);
    L7:
        r0.T();
        return;
    }
}
