package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.Editable;
import android.widget.EditText;

/* JADX INFO: loaded from: classes38.dex */
public final class c1 extends com.ss.android.lark.utils.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummaryInlineSection f443347a;

    public c1(SummaryInlineSection r100) {
        this.f443347a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        SummaryInlineSection r101 = this.f443347a;
        if (r101.f443262f == true) goto L5;
        EditText r102 = r101.f443260d;
        r102.post(new d1(r101, r102));
    L5:
        r101.f443262f = true;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L5;
        CharSequence r104 = r100.subSequence(r101, r103 + r101);
        if (r104 == null) goto L5;
    L6:
        this.f443347a.b().c(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.i2.f443713a, new com.ss.android.lark.todo.impl.features.detail.viewmodel.r(r104.toString()));
        return;
    L5:
        r104 = "";
        goto L6
    }
}
