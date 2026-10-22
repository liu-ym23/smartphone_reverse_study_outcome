package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends c0 {
    public final /* synthetic */ CommentFunction c;
    public final /* synthetic */ CommentBean.CommentDetail d;

    @Override // com.bytedance.ee.bear.middleground.comment.control.c0
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.a(r4);
        CommentFunction r0 = this.c;
        CommentBean.CommentDetail r1 = this.d;
        r0.w(r1, r1.getReply_id(), r4);
    }

    public d(CommentFunction r1, CommentBean.CommentDetail r2, com.bytedance.ee.bear.middleground.comment.uitls.p r3) {
        this.c = r1;
        this.d = r2;
        super(r3, "DELETE");
    }
}
