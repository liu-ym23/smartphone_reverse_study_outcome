package com.bytedance.ee.bear.middleground.comment.control;

import android.net.Uri;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends c0 {
    public final /* synthetic */ ICardAdapter c;
    public final /* synthetic */ CommentBean.CommentDetail d;

    @Override // com.bytedance.ee.bear.middleground.comment.control.c0
    public final void a(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.a(r7);
        if (this.c.getData().getCommentAnchorId() == null) goto L5;
        String r8 = this.c.getData().getCommentAnchorId();
    L6:
        int r0 = q.a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r1 = this.a;
        String r2 = r1.i;
        int r3 = r1.k.b;
        Intrinsics.checkNotNull(r8);
        CommentBean.CommentDetail r4 = this.d;
        Intrinsics.checkNotNullParameter(r2, "docToken");
        Intrinsics.checkNotNullParameter(r8, "commentId");
        Intrinsics.checkNotNullParameter(r4, "commentDetail");
        JSONObject r5 = new JSONObject();
        r5.put("scene", "ccm_comment_report");
        r5.put("entity_id", r2);
        r5.put("entity_type", String.valueOf(r3));
        JSONObject r6 = new JSONObject();
        r6.put("comment_id", r8);
        r6.put("reply_id", r4.getReply_id());
        r6.put("reply_user_id", r4.getUser_id());
        Unit r9 = Unit.INSTANCE;
        r5.put("extra", r6.toJSONString());
        Uri.Builder r10 = ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class, null, null, 6)).getReportHost();
        r10.appendQueryParameter(ResourceData.KEY_TYPE, "common");
        r10.appendQueryParameter("params", r5.toJSONString());
        tt5.a.h("ReportCommentUtils", "reportComment uri: " + r10);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r10.toString());
        return;
    L5:
        r8 = this.d.getComment_id();
        goto L6
    }

    public g(ICardAdapter r1, CommentBean.CommentDetail r2, com.bytedance.ee.bear.middleground.comment.uitls.p r3) {
        this.c = r1;
        this.d = r2;
        super(r3, "REPORT");
    }
}
