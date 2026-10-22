package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t b;
    public final /* synthetic */ CommentBean.CommentDetail c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function0<Unit> e;

    public g(com.bytedance.ee.bear.middleground.comment.uitls.p r1, com.bytedance.ee.bear.middleground.comment.control.t r2, CommentBean.CommentDetail r3, String r4, Function0<Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = h.a;
        h.a(this.a, this.b, this.c, this.d);
        Function0<Unit> r6 = this.e;
        if (r6 == null) goto L6;
        r6.invoke();
        return;
    }
}
