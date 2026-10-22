package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;

/* JADX INFO: loaded from: classes38.dex */
public final class m0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442063c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442061a;
        long r102 = System.currentTimeMillis();
        this.f442061a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f442062b.f441925b.h(this.f442063c.f441483a);
    }

    public m0(TaskItemViewHolder r100, TaskItem r101) {
        this.f442062b = r100;
        this.f442063c = r101;
    }
}
