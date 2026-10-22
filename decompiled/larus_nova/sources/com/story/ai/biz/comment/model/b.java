package com.story.ai.biz.comment.model;

import com.larus.platform.model.comment.CommentInfo;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static final boolean a(CommentSection r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BaseComment) == false) goto L11;
        CommentInfo r102 = ((BaseComment) r100).getCommentData();
        if (r102 == null) goto L7;
        String r103 = r102.c();
    L9:
        if (Intrinsics.areEqual(r103, r101) == false) goto L11;
        return true;
    L7:
        r103 = null;
    L11:
        return false;
    }

    public static final boolean b(CommentSection r100, BaseComment r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BaseComment) == false) goto L22;
        CommentInfo r102 = ((BaseComment) r100).getCommentData();
        String r103 = null;
        if (r102 == null) goto L7;
        String r104 = r102.c();
    L8:
        if (r101 == null) goto L12;
        CommentInfo r105 = r101.getCommentData();
        if (r105 == null) goto L12;
        String r106 = r105.c();
    L14:
        if (Intrinsics.areEqual(r104, r106) == false) goto L22;
        if (r101 == null) goto L20;
        CommentInfo r107 = r101.getCommentData();
        if (r107 == null) goto L20;
        r103 = r107.c();
    L20:
        if (o0.d(r103) == false) goto L22;
        return true;
    L12:
        r106 = null;
        goto L14
    L7:
        r104 = null;
    L22:
        return false;
    }

    public static final boolean c(CommentSection r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BaseComment) == false) goto L11;
        CommentInfo r102 = ((BaseComment) r100).getCommentData();
        if (r102 == null) goto L7;
        String r103 = r102.d();
    L9:
        if (Intrinsics.areEqual(r103, r101) == false) goto L11;
        return true;
    L7:
        r103 = null;
    L11:
        return false;
    }
}
