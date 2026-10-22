package com.ss.android.lark.widget.linked_emojicon.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.larus.nova.R;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;

/* JADX INFO: loaded from: classes38.dex */
public class EmojiconEditText extends SCAppCompatEditText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f446360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f446361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f446362d;

    public void setUseSystemDefault(boolean r100) {
    }

    public EmojiconEditText(Context r100) {
        super(r100);
        this.f446360b = (int) getTextSize();
        this.f446362d = (int) getTextSize();
    }

    public final void c(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.emojiconAlignment, R.attr.emojiconSize, R.attr.emojiconTextLength, R.attr.emojiconTextStart, R.attr.emojiconUseSystemDefault});
        this.f446360b = (int) r101.getDimension(1, getTextSize());
        this.f446361c = r101.getInt(0, 1);
        r101.getBoolean(4, false);
        r101.recycle();
        this.f446362d = (int) getTextSize();
        setText(getText());
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public void setEmojiconSize(int r100) {
        this.f446360b = r100;
        EmojiHandler.a(getContext(), getText(), this.f446360b, this.f446361c, this.f446362d, 0, -1);
    }

    public EmojiconEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        c(r101);
    }

    public EmojiconEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c(r101);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r110, int r111) {
        EmojiHandler.a(getContext(), getText(), this.f446360b, this.f446361c, this.f446362d, 0, -1);
    }
}
