package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import androidx.lifecycle.Observer;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;

/* JADX INFO: loaded from: classes38.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSidebarFragment f441721a;

    public k(TodoSidebarFragment r100) {
        this.f441721a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L7;
        this.f441721a.V90().setSelected(false);
        this.f441721a.aa0().getPaint().setFakeBoldText(false);
        this.f441721a.U90().setSelected(false);
        this.f441721a.Z90().getPaint().setFakeBoldText(false);
        this.f441721a.T90().setSelected(false);
        this.f441721a.Y90().getPaint().setFakeBoldText(false);
        this.f441721a.W90().y2(ContainerType.TASK_LIST_MANAGE, null);
        return;
    }
}
