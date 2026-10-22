package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.ss.android.lark.todo.impl.features.center.v3.util.TaskListDialogUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements TaskListDialogUtils.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CenterContainerTabView f442019a;

    @Override // com.ss.android.lark.todo.impl.features.center.v3.util.TaskListDialogUtils.b
    public final void a() {
        this.f442019a.f441813d.handleAction(m7c.b.f.f512385a, null);
    }

    public e(CenterContainerTabView r100) {
        this.f442019a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.util.TaskListDialogUtils.b
    public final void b(boolean r100) {
        this.f442019a.f441813d.handleAction(m7c.b.e.f512384a, Boolean.valueOf(r100));
    }
}
