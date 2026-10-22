package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoDetailAssigneeFragmentView f442720b;

    public g(TodoDetailAssigneeFragmentView r100) {
        this.f442720b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442719a;
        long r102 = System.currentTimeMillis();
        this.f442719a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f442720b.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.u3.f443779a);
    }
}
