package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.ee.bear.middleground.comment.uitls.p r9, com.bytedance.ee.bear.middleground.comment.control.t r10, CommentBean.CommentDetail r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r10, "dataControl");
        Intrinsics.checkNotNullParameter(r11, "commentDetail");
        Intrinsics.checkNotNullParameter(r12, "replyId");
        String r0 = r11.getComment_id();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        com.bytedance.ee.bear.middleground.comment.uitls.h r2 = r9.d0;
        SmartReplyData r13 = r11.getSmartReplyData();
        if (r13 == null) goto L8;
        String r14 = r13.getAiReplyId();
    L9:
        if (r14 != null) goto L11;
        String r4 = "";
    L12:
        SmartReplyData r15 = r11.getSmartReplyData();
        if (r15 == null) goto L15;
        String r16 = r15.getCommentId();
    L16:
        if (r16 != null) goto L18;
        String r5 = "";
    L19:
        SmartReplyData r17 = r11.getSmartReplyData();
        if (r17 == null) goto L22;
        String r18 = r17.getReplyId();
    L23:
        if (r18 != null) goto L25;
        String r6 = "";
    L26:
        SmartReplyData r19 = r11.getSmartReplyData();
        if (r19 == null) goto L31;
        SmartReplyData.AiReplyUserType r20 = r19.getAiReplyUserType();
        if (r20 == null) goto L31;
        String r21 = r20.getValue();
    L32:
        if (r21 != null) goto L34;
        String r7 = "";
    L35:
        r2.c("close_ai_reply", r4, r5, r6, r7);
        r11.setSmartReplyData(null);
        r10.h(r0, r12);
        return;
    L34:
        r7 = r21;
    L31:
        r21 = null;
        goto L32
    L25:
        r6 = r18;
        goto L26
    L22:
        r18 = null;
        goto L23
    L18:
        r5 = r16;
        goto L19
    L15:
        r16 = null;
        goto L16
    L11:
        r4 = r14;
        goto L12
    L8:
        r14 = null;
        goto L9
    }
}
