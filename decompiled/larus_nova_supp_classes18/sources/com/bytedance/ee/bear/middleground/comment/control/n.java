package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends CommentFunction.a {
    public final /* synthetic */ CommentFunction a;
    public final /* synthetic */ ICardAdapter b;
    public final /* synthetic */ CommentBean.CommentDetail c;
    public final /* synthetic */ View d;

    public final void a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        this.a.B(this.b, r4, this.c, this.d);
    }

    public n(CommentFunction r1, ICardAdapter r2, CommentBean.CommentDetail r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
