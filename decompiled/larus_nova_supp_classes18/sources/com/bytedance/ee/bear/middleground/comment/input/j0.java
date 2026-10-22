package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 implements View.OnClickListener {
    public final /* synthetic */ BaseInputComment a;

    public j0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        BaseInputComment.u(this.a);
        tt5.a.h(this.a.L(), "input click");
    }
}
