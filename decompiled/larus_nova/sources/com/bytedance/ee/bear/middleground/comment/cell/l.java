package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p f231071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f231072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f231074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f231075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f231076f;

    public l(com.bytedance.ee.bear.middleground.comment.uitls.p r100, String r101, com.bytedance.ee.bear.middleground.comment.control.t r102, j r103, int r104, boolean r105) {
        this.f231071a = r100;
        this.f231072b = r101;
        this.f231073c = r102;
        this.f231074d = r103;
        this.f231075e = r104;
        this.f231076f = r105;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (sbb.e.f541301l.getType().equals(this.f231071a.f232235k.getType()) == false) goto L15;
        com.bytedance.ee.bear.middleground.comment.uitls.p r101 = this.f231071a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r102 = r101.f232225d0;
        String r103 = this.f231072b;
        Pair[] r104 = new Pair[2];
        if (r101.V == false) goto L7;
        String r105 = "discussion";
    L8:
        r104[0] = TuplesKt.to("type", r105);
        CommentBean r106 = this.f231073c.N(this.f231072b);
        if (r106 == null) goto L13;
        CommentBean.Extra r107 = r106.getExtra();
        if (r107 == null) goto L13;
        String r108 = r107.getReportVisibility();
    L14:
        r104[1] = TuplesKt.to("comment_visible_range", r108);
        r102.g("finish_click", r103, null, MapsKt.mapOf(r104));
    L13:
        r108 = null;
        goto L14
    L7:
        r105 = "comment";
    L15:
        j r109 = this.f231074d;
        com.bytedance.ee.bear.middleground.comment.control.t r110 = this.f231073c;
        String r111 = this.f231072b;
        int r112 = this.f231075e;
        boolean r113 = this.f231076f;
        r109.getClass();
        j.a(r110, r111, r112, r113);
    }
}
