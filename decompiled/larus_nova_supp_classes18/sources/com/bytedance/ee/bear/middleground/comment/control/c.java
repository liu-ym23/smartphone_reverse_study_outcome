package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final /* synthetic */ CommentBean.CommentDetail a;
    public final /* synthetic */ CommentFunction b;
    public final /* synthetic */ String c;

    public c(CommentBean.CommentDetail r1, CommentFunction r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(View r10) {
        boolean r2 = true;
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
        r11.g("copy_link", r5, null, MapsKt.mapOf(r6));
    L16:
        this.b.b.V0().invoke("COPY_LINK", MapsKt.mapOf(new Pair[]{TuplesKt.to("commentId", this.a.getComment_id()), TuplesKt.to("commentType", Integer.valueOf(this.a.getCommentType()))}));
        com.bytedance.ee.bear.middleground.comment.uitls.h r13 = this.b.a.d0;
        if (this.a.getCommentType() == 1) goto L20;
        r2 = false;
    L20:
        Map<String, Object> r0 = r13.b();
        HashMap r1 = (HashMap) r0;
        r1.put("target", "none");
        if (r2 == false) goto L24;
        String r3 = "reaction";
    L27:
        r1.put("card_type", r3);
        tt5.a.b("Comment#CommentAnalytic", "reportCopyLinkSuccess params = " + r0);
        r13.g.a("ccm_comment_copy_link_success_click", r0);
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(this.c, false, new Token("LARK-PSDA-ccm_android_comment_out_more_copy_link")) == false) goto L31;
        UDToast.show(this.b.a.getActivity(), 2131889343);
        return;
    L31:
        return;
    L24:
        if (r13.c == false) goto L26;
        r3 = "full_comment";
        goto L27
    L26:
        r3 = "part_comment";
    L13:
        r12 = null;
        goto L14
    L7:
        r7 = "comment";
        goto L8
    L15:
        this.b.a.d0.o("copy_link", this.a.getComment_id(), null);
        goto L16
    }
}
