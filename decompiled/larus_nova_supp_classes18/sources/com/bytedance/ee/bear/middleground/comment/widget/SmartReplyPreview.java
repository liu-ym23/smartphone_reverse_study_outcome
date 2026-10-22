package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SmartReplyPreview extends FrameLayout {
    public PreviewTextView a;
    public TextView b;
    public View c;

    public CommentTextView getPreviewContentTv() {
        return this.a;
    }

    public SmartReplyPreview(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        LayoutInflater.from(r3).inflate(2131559871, this, true);
        this.a = (PreviewTextView) findViewById(2131386954);
        this.b = (TextView) findViewById(2131385748);
        this.c = findViewById(2131366972);
        this.a.setClickable(false);
        this.a.setFocusable(false);
        this.b.setClickable(false);
        this.b.setFocusable(false);
    }

    public void setCloseBtnClickListener(View.OnClickListener r2) {
        View r0 = this.c;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setCloseBtnVisible(boolean r2) {
        View r0 = this.c;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public SmartReplyPreview(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public SmartReplyPreview(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
