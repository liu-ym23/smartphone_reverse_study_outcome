package com.ss.android.lark.widget.linked_emojicon.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class EmojiconMultiAutoCompleteTextView extends AppCompatMultiAutoCompleteTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f446363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f446364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f446365c;

    public void setUseSystemDefault(boolean r100) {
    }

    public EmojiconMultiAutoCompleteTextView(Context r100) {
        super(r100);
        this.f446363a = (int) getTextSize();
        this.f446365c = (int) getTextSize();
    }

    public final void a(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.emojiconAlignment, R.attr.emojiconSize, R.attr.emojiconTextLength, R.attr.emojiconTextStart, R.attr.emojiconUseSystemDefault});
        this.f446363a = (int) r101.getDimension(1, getTextSize());
        this.f446364b = r101.getInt(0, 1);
        r101.getBoolean(4, false);
        r101.recycle();
        this.f446365c = (int) getTextSize();
        setText(getText());
    }

    public void setEmojiconSize(int r100) {
        this.f446363a = r100;
        EmojiHandler.a(getContext(), getText(), this.f446363a, this.f446364b, this.f446365c, 0, -1);
    }

    public EmojiconMultiAutoCompleteTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r101);
    }

    public EmojiconMultiAutoCompleteTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r101);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r110, int r111) {
        EmojiHandler.a(getContext(), getText(), this.f446363a, this.f446364b, this.f446365c, 0, -1);
    }
}
