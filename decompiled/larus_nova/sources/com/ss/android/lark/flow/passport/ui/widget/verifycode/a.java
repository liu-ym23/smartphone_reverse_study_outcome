package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeEditText f423921a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public a(VerifyCodeEditText r100) {
        this.f423921a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        this.f423921a.a(r100);
        String r101 = r100.toString().trim();
        int r102 = r101.length();
        VerifyCodeEditText r103 = this.f423921a;
        int r104 = r103.f423917e;
        if (r102 <= r104) goto L6;
        String r105 = r101.substring(0, r104);
        this.f423921a.f423913a.setText(r105);
        return;
    L6:
        VerifyCodeEditText.e r106 = r103.f423919g;
        if (r106 == null) goto L9;
        r106.a(r101);
    L9:
        int r107 = r100.length();
        VerifyCodeEditText r108 = this.f423921a;
        if (r107 != r108.f423917e) goto L14;
        VerifyCodeEditText.f r109 = r108.f423918f;
        if (r109 == null) goto L14;
        r109.onFinish();
    L14:
        this.f423921a.getClass();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Editable r104 = this.f423921a.f423913a.getText();
        Selection.setSelection(r104, r104.length());
    }
}
