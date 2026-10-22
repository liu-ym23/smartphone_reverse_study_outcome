package com.google.android.material.textfield;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class TextInputEditText extends AppCompatEditText {
    private CharSequence getHintFromLayout() {
        TextInputLayout r100 = getTextInputLayout();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHint();
    }

    private TextInputLayout getTextInputLayout() {
        ViewParent r100 = getParent();
    L4:
        if ((r100 instanceof View) == false) goto L10;
        if ((r100 instanceof TextInputLayout) == true) goto L8;
        r100 = r100.getParent();
        goto L4
    L8:
        return (TextInputLayout) r100;
    L10:
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout r100 = getTextInputLayout();
        if (r100 == null) goto L9;
        if (r100.isProvidingHint() == false) goto L9;
        return r100.getHint();
    L9:
        return super.getHint();
    }

    public TextInputEditText(Context r100) {
        this(r100, null);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L5;
    L7:
        return r101;
    L5:
        if (r100.hintText != null) goto L7;
        r100.hintText = getHintFromLayout();
        goto L7
    }

    public TextInputEditText(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.editTextStyle);
    }

    public TextInputEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
