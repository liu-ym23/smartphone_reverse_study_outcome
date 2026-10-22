package com.bytedance.ee.bear.middleground.comment.audio;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordPanelView f230338a;

    public f(RecordPanelView r100) {
        this.f230338a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.middleground.comment.uitls.h r101 = this.f230338a.getCommentAnalytic();
        if (r101 == null) goto L5;
        r101.m("text_clear");
    L5:
        CommentEditText r102 = this.f230338a.f230308i;
        if (r102 == null) goto L10;
        Editable r103 = r102.getText();
        if (r103 == null) goto L10;
        r103.clear();
    L10:
        this.f230338a.h(false);
    }
}
