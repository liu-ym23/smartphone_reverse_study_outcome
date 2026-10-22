package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes35.dex */
public class EmptyGoneTextView extends TextView {
    public EmptyGoneTextView(Context r100) {
        this(r100, null);
    }

    public EmptyGoneTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setVisibility(8);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }
}
