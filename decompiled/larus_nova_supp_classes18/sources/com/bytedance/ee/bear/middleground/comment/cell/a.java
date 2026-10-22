package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t b;
    public final /* synthetic */ CommentBean.CommentDetail c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public a(com.bytedance.ee.bear.middleground.comment.uitls.p r1, com.bytedance.ee.bear.middleground.comment.control.t r2, CommentBean.CommentDetail r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        int r10 = e.a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r11 = this.a;
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.b;
        CommentBean.CommentDetail r1 = this.c;
        String r2 = this.d;
        String r3 = this.e;
        if (sbb.e.l.getType().equals(r11.k.getType()) == false) goto L15;
        com.bytedance.ee.bear.middleground.comment.uitls.h r4 = r11.d0;
        Pair[] r6 = new Pair[2];
        if (r11.V == false) goto L7;
        String r12 = "discussion";
    L8:
        r6[0] = TuplesKt.to(ResourceData.KEY_TYPE, r12);
        CommentBean r13 = r0.N(r2);
        if (r13 == null) goto L13;
        CommentBean.Extra r14 = r13.getExtra();
        if (r14 == null) goto L13;
        String r15 = r14.getReportVisibility();
    L14:
        r6[1] = TuplesKt.to("comment_visible_range", r15);
        r4.g("delete_click", r2, r3, MapsKt.mapOf(r6));
    L13:
        r15 = null;
        goto L14
    L7:
        r12 = "comment";
    L15:
        Flowable<String> r16 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r0.R(r2, r1.getCommentType(), r3), null);
        if (r16 == null) goto L19;
        r16.subscribe(new b(r0), new c(r0));
        return;
    }
}
