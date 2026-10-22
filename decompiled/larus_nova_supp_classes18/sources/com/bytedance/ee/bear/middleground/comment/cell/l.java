package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t c;
    public final /* synthetic */ j d;
    public final /* synthetic */ int e;
    public final /* synthetic */ boolean f;

    public l(com.bytedance.ee.bear.middleground.comment.uitls.p r1, String r2, com.bytedance.ee.bear.middleground.comment.control.t r3, j r4, int r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (sbb.e.l.getType().equals(this.a.k.getType()) == false) goto L15;
        com.bytedance.ee.bear.middleground.comment.uitls.p r7 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = r7.d0;
        String r1 = this.b;
        Pair[] r2 = new Pair[2];
        if (r7.V == false) goto L7;
        String r8 = "discussion";
    L8:
        r2[0] = TuplesKt.to(ResourceData.KEY_TYPE, r8);
        CommentBean r9 = this.c.N(this.b);
        if (r9 == null) goto L13;
        CommentBean.Extra r10 = r9.getExtra();
        if (r10 == null) goto L13;
        String r11 = r10.getReportVisibility();
    L14:
        r2[1] = TuplesKt.to("comment_visible_range", r11);
        r0.g("finish_click", r1, null, MapsKt.mapOf(r2));
    L13:
        r11 = null;
        goto L14
    L7:
        r8 = "comment";
    L15:
        j r12 = this.d;
        com.bytedance.ee.bear.middleground.comment.control.t r3 = this.c;
        String r4 = this.b;
        int r5 = this.e;
        boolean r13 = this.f;
        r12.getClass();
        j.a(r3, r4, r5, r13);
    }
}
