package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.Editable;
import android.widget.EditText;

/* JADX INFO: loaded from: classes38.dex */
public final class g1 extends com.ss.android.lark.utils.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummarySection f443362a;

    public g1(SummarySection r100) {
        this.f443362a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        SummarySection r101 = this.f443362a;
        if (r101.f443276m == true) goto L5;
        EditText r102 = r101.f443273j;
        r102.post(new j1(r101, r102));
    L5:
        r101.f443276m = true;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L5;
        CharSequence r104 = r100.subSequence(r101, r103 + r101);
        if (r104 == null) goto L5;
    L6:
        this.f443362a.b().c(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j2.f443719a, new com.ss.android.lark.todo.impl.features.detail.viewmodel.r(r104.toString()));
        return;
    L5:
        r104 = "";
        goto L6
    }
}
