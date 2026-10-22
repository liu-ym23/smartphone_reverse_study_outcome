package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SmartReplyPreview extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PreviewTextView f232310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f232311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f232312c;

    public CommentTextView getPreviewContentTv() {
        return this.f232310a;
    }

    public SmartReplyPreview(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.comment_smart_reply_preview, this, true);
        this.f232310a = (PreviewTextView) findViewById(R.id.smart_reply_textview);
        this.f232311b = (TextView) findViewById(R.id.see_more_textview);
        this.f232312c = findViewById(R.id.close);
        this.f232310a.setClickable(false);
        this.f232310a.setFocusable(false);
        this.f232311b.setClickable(false);
        this.f232311b.setFocusable(false);
    }

    public void setCloseBtnClickListener(View.OnClickListener r100) {
        View r101 = this.f232312c;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setCloseBtnVisible(boolean r100) {
        View r101 = this.f232312c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public SmartReplyPreview(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public SmartReplyPreview(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
