package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class b1 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummaryInlineSection f443341a;

    public b1(SummaryInlineSection r100) {
        this.f443341a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == true) goto L5;
        this.f443341a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.l4.f443733a);
        return;
    }
}
