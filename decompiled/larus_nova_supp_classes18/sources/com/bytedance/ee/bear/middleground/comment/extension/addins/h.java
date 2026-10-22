package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ f a;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p b;

    public h(f r1, com.bytedance.ee.bear.middleground.comment.uitls.p r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r6) {
        if (((Boolean) r6).booleanValue() == false) goto L16;
        p1 r7 = this.a.getContext().c();
        if (r7 == null) goto L14;
        q1 r8 = r7.jV();
        if (r8 == null) goto L14;
        RecyclerView r9 = this.a.d(r8);
        if (r9 == null) goto L17;
        com.bytedance.ee.bear.middleground.comment.uitls.p r1 = this.b;
        f r2 = this.a;
        tt5.a.h("Comment#CalcScrollInfoAddin", "become presenter, send scroll info, RecyclerView isAttachedToWindow = " + r9.isAttachedToWindow());
        if (r9.isAttachedToWindow() == false) goto L18;
        com.bytedance.ee.util.ui.j.d(new g(r1, r9, r2), 1000);
        return;
    L18:
        return;
    L17:
        return;
    L14:
        tt5.a.k("Comment#CalcScrollInfoAddin", "pagerAdapter is null!");
        return;
    }
}
