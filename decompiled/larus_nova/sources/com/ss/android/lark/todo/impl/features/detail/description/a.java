package com.ss.android.lark.todo.impl.features.detail.description;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoDetailDescriptionFragmentView f443102a;

    public a(TodoDetailDescriptionFragmentView r100) {
        this.f443102a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoDetailDescriptionFragmentView r101 = this.f443102a;
        Context r102 = r101.getContext();
        if (r102 == null) goto L5;
        KeyboardUtils.hideKeyboard(r102, r101.f443099g);
    L5:
        this.f443102a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.p0.f443751a);
    }
}
