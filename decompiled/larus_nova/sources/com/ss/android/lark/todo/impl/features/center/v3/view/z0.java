package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;

/* JADX INFO: loaded from: classes38.dex */
public final class z0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListFilterSectionView f442159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskContainerFilter.TabFilter.TaskContainerTabCategory f442160c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442158a;
        long r102 = System.currentTimeMillis();
        this.f442158a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TaskListFilterSectionView r103 = this.f442159b;
        TaskContainerFilter.TabFilter.TaskContainerTabCategory r104 = this.f442160c;
        int r105 = TaskListFilterSectionView.f441971e;
        r103.a(r104);
        this.f442159b.f441974c.handleAction(m7c.d.f.f512397a, this.f442160c);
    }

    public z0(TaskListFilterSectionView r100, TaskContainerFilter.TabFilter.TaskContainerTabCategory r101) {
        this.f442159b = r100;
        this.f442160c = r101;
    }
}
