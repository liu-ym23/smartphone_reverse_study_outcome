package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;

/* JADX INFO: loaded from: classes38.dex */
public final class p0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442081c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442079a;
        long r102 = System.currentTimeMillis();
        this.f442079a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        t r103 = this.f442080b.f441925b;
        TaskItem r104 = this.f442081c;
        r103.d(r104.f441483a, r104.f441485c.toString());
    }

    public p0(TaskItemViewHolder r100, TaskItem r101) {
        this.f442080b = r100;
        this.f442081c = r101;
    }
}
