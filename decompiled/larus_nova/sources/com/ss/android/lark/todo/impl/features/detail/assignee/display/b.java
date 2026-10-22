package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeDisplayAdapter f442654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserBean f442655b;

    public b(TodoAssigneeDisplayAdapter r100, UserBean r101) {
        this.f442654a = r100;
        this.f442655b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoAssigneeDisplayAdapter.a r101 = this.f442654a.f442630b;
        UserBean r102 = this.f442655b;
        Intrinsics.checkNotNull(r100);
        r101.b(r102, r100);
    }
}
