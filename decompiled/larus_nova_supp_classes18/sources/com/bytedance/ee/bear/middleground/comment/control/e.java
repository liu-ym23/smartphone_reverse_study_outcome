package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends c0 {
    public final /* synthetic */ CommentBean.CommentDetail c;
    public final /* synthetic */ CommentFunction d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    @Override // com.bytedance.ee.bear.middleground.comment.control.c0
    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.a(r5);
        tt5.a.h("Comment#CommentFunction", "smartReply click related knowledge on more panel");
        this.a.d0.g("ask_ccm_ai", this.c.getComment_id(), this.c.getReply_id(), MapsKt.mapOf(TuplesKt.to("target", "none")));
        this.d.c.i(this.e, this.f);
    }

    public e(CommentBean.CommentDetail r1, CommentFunction r2, String r3, String r4, com.bytedance.ee.bear.middleground.comment.uitls.p r5) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        super(r5, "RELATED_KNOWLEDGE");
    }
}
