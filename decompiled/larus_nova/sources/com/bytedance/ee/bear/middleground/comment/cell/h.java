package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f231056a = 0;

    static {
    }

    public static void a(com.bytedance.ee.bear.middleground.comment.uitls.p r100, com.bytedance.ee.bear.middleground.comment.control.t r110, CommentBean.CommentDetail r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r110, "dataControl");
        Intrinsics.checkNotNullParameter(r111, "commentDetail");
        Intrinsics.checkNotNullParameter(r112, "replyId");
        String r101 = r111.getComment_id();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        com.bytedance.ee.bear.middleground.comment.uitls.h r102 = r100.f232225d0;
        SmartReplyData r103 = r111.getSmartReplyData();
        if (r103 == null) goto L8;
        String r104 = r103.getAiReplyId();
    L9:
        if (r104 != null) goto L11;
        String r105 = "";
    L12:
        SmartReplyData r106 = r111.getSmartReplyData();
        if (r106 == null) goto L15;
        String r107 = r106.getCommentId();
    L16:
        if (r107 != null) goto L18;
        String r108 = "";
    L19:
        SmartReplyData r109 = r111.getSmartReplyData();
        if (r109 == null) goto L22;
        String r113 = r109.getReplyId();
    L23:
        if (r113 != null) goto L25;
        String r114 = "";
    L26:
        SmartReplyData r115 = r111.getSmartReplyData();
        if (r115 == null) goto L31;
        SmartReplyData.AiReplyUserType r116 = r115.getAiReplyUserType();
        if (r116 == null) goto L31;
        String r117 = r116.getValue();
    L32:
        if (r117 != null) goto L34;
        String r118 = "";
    L35:
        r102.c("close_ai_reply", r105, r108, r114, r118);
        r111.setSmartReplyData(null);
        r110.h(r101, r112);
        return;
    L34:
        r118 = r117;
    L31:
        r117 = null;
        goto L32
    L25:
        r114 = r113;
        goto L26
    L22:
        r113 = null;
        goto L23
    L18:
        r108 = r107;
        goto L19
    L15:
        r107 = null;
        goto L16
    L11:
        r105 = r104;
        goto L12
    L8:
        r104 = null;
        goto L9
    }
}
