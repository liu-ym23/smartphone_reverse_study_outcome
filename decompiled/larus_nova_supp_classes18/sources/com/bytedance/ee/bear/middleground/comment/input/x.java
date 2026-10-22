package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ BaseInputComment a;

    public x(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r2 = this.a.M();
        if (r2 == null) goto L5;
        r2.g();
    L5:
        this.a.d0();
    }
}
