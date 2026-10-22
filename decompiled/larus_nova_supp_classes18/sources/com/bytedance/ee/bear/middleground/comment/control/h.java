package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final /* synthetic */ CommentBean.CommentDetail a;
    public final /* synthetic */ CommentFunction b;
    public final /* synthetic */ String c;

    public h(CommentBean.CommentDetail r1, CommentFunction r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(View r10) {
        boolean r2 = false;
        if (this.a.getCommentType() != 0) goto L15;
        com.bytedance.ee.bear.middleground.comment.uitls.h r11 = this.b.a.d0;
        String r5 = this.a.getComment_id();
        Pair[] r6 = new Pair[2];
        if (this.b.a.V == false) goto L7;
        String r7 = "discussion";
    L8:
        r6[0] = TuplesKt.to(ResourceData.KEY_TYPE, r7);
        CommentBean r8 = this.b.c.N(this.a.getComment_id());
        if (r8 == null) goto L13;
        CommentBean.Extra r9 = r8.getExtra();
        if (r9 == null) goto L13;
        String r12 = r9.getReportVisibility();
    L14:
        r6[1] = TuplesKt.to("comment_visible_range", r12);
        r11.g("send_to_chat", r5, null, MapsKt.mapOf(r6));
    L16:
        this.b.b.V0().invoke("SEND_IM", MapsKt.mapOf(new Pair[]{TuplesKt.to("commentId", this.a.getComment_id()), TuplesKt.to("commentType", Integer.valueOf(this.a.getCommentType()))}));
        this.b.b.l1().invoke(this.c);
        com.bytedance.ee.bear.middleground.comment.uitls.h r13 = this.b.a.d0;
        if (this.a.getCommentType() != 1) goto L19;
        r2 = true;
    L19:
        Map<String, Object> r0 = r13.b();
        HashMap r1 = (HashMap) r0;
        r1.put("target", "none");
        if (r2 == false) goto L22;
        String r3 = "reaction";
    L23:
        r1.put("card_type", r3);
        tt5.a.b("Comment#CommentAnalytic", "reportShareLarkView params = " + r0);
        r13.g.a("ccm_permission_share_lark_view", r0);
        return;
    L22:
        r3 = "part_comment";
    L13:
        r12 = null;
        goto L14
    L7:
        r7 = "comment";
        goto L8
    L15:
        this.b.a.d0.o("send_to_chat", this.a.getComment_id(), null);
        goto L16
    }
}
