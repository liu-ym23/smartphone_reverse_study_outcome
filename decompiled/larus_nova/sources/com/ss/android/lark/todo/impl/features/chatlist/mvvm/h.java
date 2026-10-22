package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersFragment f442389b;

    public h(TaskListMembersFragment r100) {
        this.f442389b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442388a;
        long r102 = System.currentTimeMillis();
        this.f442388a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TaskListMembersFragment r103 = this.f442389b;
        int r104 = TaskListMembersFragment.f442289v;
        TaskListMembersViewModel.loadMembers$default(r103.Y90(), false, 1, null);
    }
}
