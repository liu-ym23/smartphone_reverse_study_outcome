package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;
import com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class r0 implements MultiCompleteHelper.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f442090c;

    @Override // com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper.a
    public final void a() {
    }

    @Override // com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper.a
    public final void b() {
        t r100 = this.f442088a.f441925b;
        TaskItem r101 = this.f442089b;
        r100.j(r101.f441483a, r101.f441500r, this.f442090c);
    }

    public r0(TaskItemViewHolder r100, TaskItem r101, boolean r102) {
        this.f442088a = r100;
        this.f442089b = r101;
        this.f442090c = r102;
    }
}
