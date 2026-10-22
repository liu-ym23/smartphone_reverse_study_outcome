package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;
import com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class s0 implements MultiCompleteHelper.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskItem f442093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f442094c;

    @Override // com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper.a
    public final void a() {
    }

    @Override // com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper.a
    public final void b() {
        t r100 = this.f442092a.f441925b;
        TaskItem r101 = this.f442093b;
        r100.j(r101.f441483a, r101.f441500r, this.f442094c);
    }

    public s0(TaskItemViewHolder r100, TaskItem r101, boolean r102) {
        this.f442092a = r100;
        this.f442093b = r101;
        this.f442094c = r102;
    }
}
