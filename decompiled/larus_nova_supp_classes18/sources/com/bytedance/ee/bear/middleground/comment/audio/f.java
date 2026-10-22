package com.bytedance.ee.bear.middleground.comment.audio;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ RecordPanelView a;

    public f(RecordPanelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.ee.bear.middleground.comment.uitls.h r3 = this.a.getCommentAnalytic();
        if (r3 == null) goto L5;
        r3.m("text_clear");
    L5:
        CommentEditText r4 = this.a.i;
        if (r4 == null) goto L10;
        Editable r5 = r4.getText();
        if (r5 == null) goto L10;
        r5.clear();
    L10:
        this.a.h(false);
    }
}
