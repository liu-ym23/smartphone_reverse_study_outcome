package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends c0 {
    public final /* synthetic */ CommentBean.CommentDetail c;
    public final /* synthetic */ ICardAdapter d;
    public final /* synthetic */ CommentFunction e;

    @Override // com.bytedance.ee.bear.middleground.comment.control.c0
    public final void a(View r30) {
        Intrinsics.checkNotNullParameter(r30, "view");
        super.a(r30);
        String r1 = "@" + this.c.getName();
        bo4.a r2 = new bo4.a(0, r1.length(), 0, -1, this.c.getUser_id(), null, r1, null, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0);
        StringBuilder r3 = new StringBuilder();
        bo4.a[] r5 = {r2};
        StringBuilder r4 = new StringBuilder(r1);
        int r6 = 1;
    L3:
        r6 = r6 - 1;
        if (r6 < 0) goto L6;
        db5.f.c(r4, r5[r6]);
        goto L3
    L6:
        r3.append(r4.toString());
        r3.append(' ');
        String r7 = r3.toString();
        CommentInputRequest r8 = new CommentInputRequest();
        r8.comment_id = this.c.getComment_id();
        r8.setCommentType(this.c.getCommentType());
        r8.is_whole = this.c.isWholeComment();
        com.bytedance.ee.bear.middleground.comment.uitls.p r9 = this.a;
        r8.show_comment_image = r9.F;
        r8.show_insert_image = r9.E;
        r8.doc_url = r9.j;
        r8.keyboard_pop = true;
        r8.show_voice = true;
        if (this.c.isWholeComment() == false) goto L9;
        int r10 = 0;
    L10:
        r8.type = r10;
        r8.canUseBlankContent = true;
        r8.directional_reply_id = this.c.getReply_id();
        r8.content = r7;
        r8.bizParams = this.d.getBizParam();
        r8.visibilityBean = new VisibilityBean(this.d.getCommentVisibility(this.c));
        com.bytedance.ee.bear.middleground.comment.uitls.h r11 = this.a.d0;
        String r12 = this.c.getComment_id();
        String r13 = this.c.getReply_id();
        Pair[] r14 = new Pair[2];
        if (this.a.V == false) goto L13;
        String r15 = "discussion";
    L14:
        r14[0] = TuplesKt.to(ResourceData.KEY_TYPE, r15);
        CommentBean r16 = this.e.c.N(r8.comment_id);
        if (r16 == null) goto L19;
        CommentBean.Extra r17 = r16.getExtra();
        if (r17 == null) goto L19;
        String r18 = r17.getReportVisibility();
    L20:
        r14[1] = TuplesKt.to("comment_visible_range", r18);
        r11.g("addition_click", r12, r13, MapsKt.mapOf(r14));
        this.e.b.T().b.invoke(r8);
        return;
    L19:
        r18 = null;
        goto L20
    L13:
        r15 = "comment";
        goto L14
    L9:
        r10 = 2;
        goto L10
    }

    public f(CommentBean.CommentDetail r1, ICardAdapter r2, CommentFunction r3, com.bytedance.ee.bear.middleground.comment.uitls.p r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super(r4, "REPLY");
    }
}
