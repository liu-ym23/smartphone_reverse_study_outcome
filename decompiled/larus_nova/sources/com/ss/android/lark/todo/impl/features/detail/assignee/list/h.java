package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoDetailAssigneeFragmentView f442722b;

    public h(TodoDetailAssigneeFragmentView r100) {
        this.f442722b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442721a;
        long r102 = System.currentTimeMillis();
        this.f442721a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f442722b.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.C5354a.f443662a);
    }
}
