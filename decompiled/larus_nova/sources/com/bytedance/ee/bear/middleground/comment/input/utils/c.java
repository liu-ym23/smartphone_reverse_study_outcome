package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f232007a = 0;

    static {
    }

    public static void a(CommentBean r110, String r111, p r112, z r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "commentBean");
        Intrinsics.checkNotNullParameter(r112, "config");
        Intrinsics.checkNotNullParameter(r113, "commentListeners");
        if (r111 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L13;
        tt5.a.k("CommentInputUtils", "editComment: replyId is null");
        return;
    L13:
        Iterator<T> r101 = r110.getComment_list().iterator();
    L15:
        if (r101.hasNext() == false) goto L17;
        ((CommentBean.CommentDetail) r101.next()).setEditStatus(false);
        goto L15
    L17:
        Iterator<T> r102 = r110.getComment_list().iterator();
    L19:
        if (r102.hasNext() == false) goto L23;
        Object r103 = r102.next();
        if (TextUtils.equals(((CommentBean.CommentDetail) r103).getReply_id(), r111) == false) goto L19;
    L24:
        CommentBean.CommentDetail r104 = (CommentBean.CommentDetail) r103;
        if (r104 != null) goto L28;
        tt5.a.k("CommentInputUtils", "editComment: commentDetail replyId not found");
        return;
    L28:
        CommentInputRequest r105 = b.a(r110, r112, 1, r104, null, null, null, r114, 240);
        r105.isShowAreaSelectBtn = false;
        r104.setEditStatus(true);
        r113.T().f230083a.invoke(r105);
        return;
    L23:
        r103 = null;
        goto L24
    L5:
        if (r111.length() == 0) goto L8;
        r100 = false;
        goto L10
    }
}
