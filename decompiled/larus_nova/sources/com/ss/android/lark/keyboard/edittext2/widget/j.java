package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichTextFunctionEditText f429275a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public j(RichTextFunctionEditText r100) {
        this.f429275a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Editable r101 = this.f429275a.getText();
        if ((r101 instanceof Spanned) == false) goto L7;
        int r102 = 0;
        Object[] r103 = r101.getSpans(0, r101.length(), com.ss.android.lark.keyboard.edittext2.span.l.class);
        int r104 = r103.length;
    L5:
        if (r102 >= r104) goto L9;
        ((com.ss.android.lark.keyboard.edittext2.span.l) r103[r102]).b(r101);
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }
}
