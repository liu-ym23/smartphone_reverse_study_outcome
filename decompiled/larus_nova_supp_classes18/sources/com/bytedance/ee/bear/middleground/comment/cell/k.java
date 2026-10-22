package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ j c;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t d;
    public final /* synthetic */ int e;

    public k(com.bytedance.ee.bear.middleground.comment.uitls.p r1, String r2, j r3, com.bytedance.ee.bear.middleground.comment.control.t r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        HashMap r5 = new HashMap();
        this.a.d0.o("solve_and_hide", this.b, r5);
        j r6 = this.c;
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.d;
        String r1 = this.b;
        int r2 = this.e;
        r6.getClass();
        j.a(r0, r1, r2, false);
    }
}
