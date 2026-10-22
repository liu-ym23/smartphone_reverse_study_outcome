package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;

/* JADX INFO: loaded from: classes38.dex */
public final class l0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442056c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442054a;
        long r102 = System.currentTimeMillis();
        this.f442054a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f442055b.f441925b.k(this.f442056c.f441483a);
    }

    public l0(TaskItemViewHolder r100, TaskItem r101) {
        this.f442055b = r100;
        this.f442056c = r101;
    }
}
