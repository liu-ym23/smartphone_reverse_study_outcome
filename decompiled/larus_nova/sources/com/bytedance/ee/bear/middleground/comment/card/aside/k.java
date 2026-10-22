package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f230950a = 0;

    static {
    }

    public static void a(List r100, String r101, int r102, CommentBean r103) {
        CommentBean.CommentDetail r104 = new CommentBean.CommentDetail();
        r104.setComment_id(r101);
        r104.setReply_id(r103.getQuote() + r103.isUnSubmitComment());
        r104.setContent(r103.getQuote());
        r104.setCommentType(r102);
        r104.setUser_id(r103.getUserId());
        r104.setReplyType(-1);
        CommentBean.CommentDetail r105 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r100);
        if (r105 == null) goto L5;
        ErrorBean r106 = r105.getError();
    L6:
        r104.setError(r106);
        ListProtector.add(r100, 0, r104);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
