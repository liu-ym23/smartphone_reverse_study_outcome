package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes38.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSidebarFragment f441720a;

    public j(TodoSidebarFragment r100) {
        this.f441720a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L7;
        this.f441720a.V90().setSelected(false);
        this.f441720a.aa0().getPaint().setFakeBoldText(false);
        this.f441720a.U90().setSelected(false);
        this.f441720a.Z90().getPaint().setFakeBoldText(false);
        this.f441720a.T90().setSelected(true);
        this.f441720a.Y90().getPaint().setFakeBoldText(true);
        this.f441720a.W90().y2(null, null);
        return;
    }
}
