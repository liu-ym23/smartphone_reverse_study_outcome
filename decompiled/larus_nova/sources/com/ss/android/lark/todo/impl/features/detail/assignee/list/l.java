package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoDetailFollowerFragmentView f442729a;

    public l(TodoDetailFollowerFragmentView r100) {
        this.f442729a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f442729a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.p0.f443751a);
    }
}
