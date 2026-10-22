package com.ss.android.lark.widget.linked_emojicon.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class EmojiconTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f446366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f446367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f446368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f446369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f446370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f446371f;

    public void setUseSystemDefault(boolean r100) {
    }

    public int getEmojiconAlignment() {
        return this.f446368c;
    }

    public int getEmojiconSize() {
        return this.f446367b;
    }

    public int getEmojiconTextSize() {
        return this.f446369d;
    }

    public EmojiconTextView(Context r100) {
        super(r100);
        this.f446366a = false;
        this.f446370e = 0;
        this.f446371f = -1;
        x(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void setEmojiText(CharSequence r100) {
        setText(r100);
    }

    public void setEmojiconSize(int r100) {
        this.f446367b = r100;
        super.setText(getText());
    }

    public void setEmojiconTextSize(int r100) {
        this.f446369d = r100;
        super.setText(getText());
    }

    public void setTranslateEmojiCode(boolean r100) {
        this.f446366a = r100;
    }

    public final void x(AttributeSet r100) {
        this.f446369d = (int) getTextSize();
        if (r100 != null) goto L5;
        this.f446367b = (int) getTextSize();
        this.f446368c = 1;
    L6:
        setText(getText());
        return;
    L5:
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.emojiconAlignment, R.attr.emojiconSize, R.attr.emojiconTextLength, R.attr.emojiconTextStart, R.attr.emojiconUseSystemDefault});
        this.f446367b = (int) r101.getDimension(1, getTextSize());
        this.f446368c = r101.getInt(0, 1);
        this.f446370e = r101.getInteger(3, 0);
        this.f446371f = r101.getInteger(2, -1);
        r101.getBoolean(4, false);
        r101.recycle();
        goto L6
    }

    public EmojiconTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f446366a = false;
        this.f446370e = 0;
        this.f446371f = -1;
        x(r101);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r110) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        super.setText(r100, r110);
        return;
    L5:
        if (this.f446366a == false) goto L7;
        SpannableStringBuilder r101 = new SpannableStringBuilder(r100);
        EmojiHandler.a(getContext(), r101, this.f446367b, this.f446368c, this.f446369d, this.f446370e, this.f446371f);
        r100 = r101;
        goto L7
    }

    public EmojiconTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f446366a = false;
        this.f446370e = 0;
        this.f446371f = -1;
        x(r101);
    }
}
