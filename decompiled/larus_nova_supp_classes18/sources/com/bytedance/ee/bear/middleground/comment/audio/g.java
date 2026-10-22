package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ RecordPanelView a;

    public g(RecordPanelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.ee.bear.middleground.comment.uitls.h r3 = this.a.getCommentAnalytic();
        if (r3 == null) goto L5;
        r3.m("send");
    L5:
        RecordPanelView.b r4 = this.a.m;
        if (r4 == null) goto L8;
        r4.a();
    L8:
        this.a.h(false);
    }
}
