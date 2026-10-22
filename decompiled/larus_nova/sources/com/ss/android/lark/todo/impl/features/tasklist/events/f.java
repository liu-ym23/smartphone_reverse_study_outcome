package com.ss.android.lark.todo.impl.features.tasklist.events;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListEventsFragment f444071a;

    public f(TaskListEventsFragment r100) {
        this.f444071a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        zab.a.a(this.f444071a);
    }
}
