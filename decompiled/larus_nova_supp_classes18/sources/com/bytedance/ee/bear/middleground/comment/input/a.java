package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnFocusChangeListener {
    public final /* synthetic */ AsideInputComment a;
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.z b;

    public a(AsideInputComment r1, com.bytedance.ee.bear.middleground.comment.control.z r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        this.a.H.setSelected(r2);
        this.b.D0().invoke(Boolean.valueOf(r2));
    }
}
