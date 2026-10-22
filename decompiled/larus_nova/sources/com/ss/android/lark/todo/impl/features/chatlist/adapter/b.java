package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.todo.v1.TaskItemMember;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TodoDoc;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersAdapter.ViewHolder f442212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskListMember f442213c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442211a;
        long r102 = System.currentTimeMillis();
        this.f442211a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        g7c.d r103 = TodoDependencyHolder.a().browserDependency();
        Context r104 = this.f442212b.f442191a.getContext();
        TaskItemMember r105 = this.f442213c.member;
        if (r105 == null) goto L10;
        TodoDoc r106 = r105.f253777doc;
        if (r106 == null) goto L10;
        String r107 = r106.url;
    L11:
        r103.openUrl(r104, r107);
        return;
    L10:
        r107 = null;
        goto L11
    }

    public b(TaskListMembersAdapter.ViewHolder r100, TaskListMember r101) {
        this.f442212b = r100;
        this.f442213c = r101;
    }
}
