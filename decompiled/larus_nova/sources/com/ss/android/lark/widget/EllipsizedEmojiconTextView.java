package com.ss.android.lark.widget;

import android.R;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiconTextView;

/* JADX INFO: loaded from: classes38.dex */
public class EllipsizedEmojiconTextView extends EmojiconTextView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f445613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f445614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f445615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextUtils.TruncateAt f445616j;

    public String getContentText() {
        return super.getText().toString();
    }

    public EllipsizedEmojiconTextView(Context r100) {
        this(r100, null);
    }

    public void setShouldEllipsized(boolean r100) {
        this.f445613g = r100;
    }

    public EllipsizedEmojiconTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textViewStyle);
    }

    @Override // com.ss.android.lark.widget.linked_emojicon.base.EmojiconTextView, android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r110) {
        if (r100 != null) goto L4;
        SpannableStringBuilder r101 = null;
    L5:
        this.f445615i = r101;
        if (this.f445613g == true) goto L10;
        super.setText(r100, r110);
        return;
    L10:
        if (this.f445614h == false) goto L13;
        this.f445614h = false;
    L15:
        int r102 = getMaxLines();
        if (getWidth() != 0) goto L18;
    L21:
        super.setText(r100, r110);
        requestLayout();
        return;
    L18:
        if (r102 > 1000) goto L21;
        r100 = TextUtils.ellipsize(r100, getPaint(), getWidth() * r102, this.f445616j, false, null);
        goto L21
    L13:
        if (getMeasuredWidth() == 0) goto L15;
        layout(0, 0, 0, getMeasuredHeight());
        goto L15
    L4:
        r101 = new SpannableStringBuilder(r100);
        goto L5
    }

    public EllipsizedEmojiconTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445613g = true;
        this.f445614h = false;
        this.f445615i = "";
        this.f445616j = TextUtils.TruncateAt.END;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (this.f445613g == true) goto L6;
        super.onSizeChanged(r100, r101, r102, r103);
        return;
    L6:
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L10;
        if (r102 == r100) goto L10;
        this.f445614h = true;
        setText(this.f445615i);
        requestLayout();
        return;
    L10:
        if (r100 != 0) goto L15;
        if (r102 != 0) goto L16;
        Log.e("EllipsizedTextView", "onSizeChanged, width == 0 and oldWidth == 0");
        return;
    L16:
        return;
    }
}
