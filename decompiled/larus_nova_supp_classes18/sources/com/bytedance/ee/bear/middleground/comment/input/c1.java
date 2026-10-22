package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c1 implements View.OnClickListener {
    public final /* synthetic */ InputComment a;

    public c1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r2 = this.a.I();
        if (r2 == null) goto L6;
        r2.g();
        return;
    }
}
