package com.ss.android.lark.todo.impl.features.tasklist.events;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListsEventLoadingFragment f444076a;

    public i(TaskListsEventLoadingFragment r100) {
        this.f444076a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f444076a.S90().setVisibility(8);
        this.f444076a.U90().setVisibility(0);
        this.f444076a.T90().playAnimation();
        this.f444076a.f444062d.reload();
    }
}
