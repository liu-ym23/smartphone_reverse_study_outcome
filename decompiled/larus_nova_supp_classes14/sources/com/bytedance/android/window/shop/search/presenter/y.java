package com.bytedance.android.window.shop.search.presenter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements TextWatcher {
    public final /* synthetic */ WindowSearchTitlePresenter a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public y(WindowSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        EditText r3 = this.a.g;
        if (r3 == null) goto L11;
        if (r3 == null) goto L8;
        Editable r0 = r3.getText();
        if (r0 == null) goto L8;
        int r1 = r0.length();
    L9:
        r3.setSelection(r1);
        return;
    L8:
        r1 = 0;
        goto L9
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (TextUtils.isEmpty(r1) == true) goto L12;
        ImageView r5 = this.a.h;
        if (r5 == null) goto L12;
        if (r5.getVisibility() != 8) goto L12;
        ImageView r6 = this.a.h;
        if (r6 == null) goto L21;
        r6.setVisibility(0);
    L21:
        if ((!Intrinsics.areEqual(String.valueOf(r1), (String) WindowSearchTitlePresenter.E(this.a).getSearchContent().a())) == false) goto L23;
        WindowSearchTitlePresenter r7 = this.a;
        r7.k = true;
        WindowSearchTitlePresenter.E(r7).getSearchContent().g(String.valueOf(r1));
    L23:
        WindowSearchTitlePresenter.E(this.a).getSugRequestParam().getClass();
        return;
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L21;
        ImageView r8 = this.a.h;
        if (r8 == null) goto L21;
        if (r8.getVisibility() != 0) goto L21;
        ImageView r9 = this.a.h;
        if (r9 == null) goto L21;
        r9.setVisibility(8);
        goto L21
    }
}
