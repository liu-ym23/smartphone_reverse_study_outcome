package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(CommentBean r13, String r14, p r15, z r16, String r17) {
        Intrinsics.checkNotNullParameter(r13, "commentBean");
        Intrinsics.checkNotNullParameter(r15, "config");
        Intrinsics.checkNotNullParameter(r16, "commentListeners");
        if (r14 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        tt5.a.k("CommentInputUtils", "editComment: replyId is null");
        return;
    L13:
        Iterator<T> r5 = r13.getComment_list().iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        ((CommentBean.CommentDetail) r5.next()).setEditStatus(false);
        goto L15
    L17:
        Iterator<T> r6 = r13.getComment_list().iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        Object r7 = r6.next();
        if (TextUtils.equals(((CommentBean.CommentDetail) r7).getReply_id(), r14) == false) goto L19;
    L24:
        CommentBean.CommentDetail r0 = (CommentBean.CommentDetail) r7;
        if (r0 != null) goto L28;
        tt5.a.k("CommentInputUtils", "editComment: commentDetail replyId not found");
        return;
    L28:
        CommentInputRequest r2 = b.a(r13, r15, 1, r0, null, null, null, r17, 240);
        r2.isShowAreaSelectBtn = false;
        r0.setEditStatus(true);
        r16.T().a.invoke(r2);
        return;
    L23:
        r7 = null;
        goto L24
    L5:
        if (r14.length() == 0) goto L8;
        r4 = false;
        goto L10
    }
}
