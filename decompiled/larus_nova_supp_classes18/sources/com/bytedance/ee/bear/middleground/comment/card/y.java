package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public y(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (((Boolean) this.a.j.invoke()).booleanValue() == true) goto L6;
        this.a.Ni(false);
        return;
    }
}
