package com.bytedance.ee.bear.pathnavigationview;

import android.view.View;
import kl5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PathNavigationAdapter<kl5.a> b;
    public final /* synthetic */ int c;
    public final /* synthetic */ kl5.a d;

    public a(boolean r1, PathNavigationAdapter<kl5.a> r2, int r3, kl5.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a == true) goto L8;
        PathNavigationAdapter<kl5.a> r5 = this.b;
        r5.setNewData(r5.getData().subList(0, this.c + 1));
        b<M> r6 = this.b.a;
        if (r6 == 0) goto L9;
        r6.T(this.d);
        return;
    L9:
        return;
    }
}
