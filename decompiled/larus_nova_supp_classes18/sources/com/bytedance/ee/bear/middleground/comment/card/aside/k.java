package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(List r2, String r3, int r4, CommentBean r5) {
        CommentBean.CommentDetail r0 = new CommentBean.CommentDetail();
        r0.setComment_id(r3);
        r0.setReply_id(r5.getQuote() + r5.isUnSubmitComment());
        r0.setContent(r5.getQuote());
        r0.setCommentType(r4);
        r0.setUser_id(r5.getUserId());
        r0.setReplyType(-1);
        CommentBean.CommentDetail r6 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r2);
        if (r6 == null) goto L5;
        ErrorBean r7 = r6.getError();
    L6:
        r0.setError(r7);
        ListProtector.add(r2, 0, r0);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
