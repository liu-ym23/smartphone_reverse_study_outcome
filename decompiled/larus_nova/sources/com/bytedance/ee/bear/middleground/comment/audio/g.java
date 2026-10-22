package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordPanelView f230339a;

    public g(RecordPanelView r100) {
        this.f230339a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.middleground.comment.uitls.h r101 = this.f230339a.getCommentAnalytic();
        if (r101 == null) goto L5;
        r101.m("send");
    L5:
        RecordPanelView.b r102 = this.f230339a.f230312m;
        if (r102 == null) goto L8;
        r102.a();
    L8:
        this.f230339a.h(false);
    }
}
