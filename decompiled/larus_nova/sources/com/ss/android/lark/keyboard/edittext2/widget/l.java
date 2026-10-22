package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements TextWatcher {
    public l() {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if ((r100 instanceof Spanned) == false) goto L7;
        Spanned r104 = (Spanned) r100;
        int r105 = 0;
        Object[] r106 = r104.getSpans(0, r104.length(), com.ss.android.lark.keyboard.edittext2.span.l.class);
        int r107 = r106.length;
    L5:
        if (r105 >= r107) goto L9;
        ((com.ss.android.lark.keyboard.edittext2.span.l) r106[r105]).c(r100);
        r105 = r105 + 1;
        goto L5
    L9:
        return;
    }
}
