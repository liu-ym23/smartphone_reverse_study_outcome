package com.ss.android.lark.todo.impl.features.detail.description;

import com.ss.android.lark.todo.impl.features.detail.viewmodel.r;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoDetailDescriptionFragmentView f443103a;

    public b(TodoDetailDescriptionFragmentView r100) {
        this.f443103a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L5;
        CharSequence r104 = r100.subSequence(r101, r103 + r101);
        if (r104 == null) goto L5;
    L6:
        this.f443103a.b().c(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.h2.f443707a, new r(r104.toString()));
        return;
    L5:
        r104 = "";
        goto L6
    }
}
