package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.todo.v1.TaskItemMember;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import g7c.o;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersAdapter.ViewHolder f442209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskListMember f442210c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442208a;
        long r102 = System.currentTimeMillis();
        this.f442208a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        o r103 = TodoDependencyHolder.a().messengerModuleDependency();
        Context r104 = this.f442209b.f442191a.getContext();
        TaskItemMember r105 = this.f442210c.member;
        if (r105 == null) goto L11;
        TodoUser r106 = r105.user;
        if (r106 == null) goto L11;
        String r107 = r106.user_id;
        if (r107 == null) goto L11;
    L12:
        r103.a(r104, r107);
        return;
    L11:
        r107 = "";
        goto L12
    }

    public a(TaskListMembersAdapter.ViewHolder r100, TaskListMember r101) {
        this.f442209b = r100;
        this.f442210c = r101;
    }
}
