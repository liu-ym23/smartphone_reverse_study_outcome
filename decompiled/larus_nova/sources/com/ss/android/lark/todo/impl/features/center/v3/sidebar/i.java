package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes38.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSidebarFragment f441719a;

    public i(TodoSidebarFragment r100) {
        this.f441719a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f441719a.V90().setSelected(false);
        this.f441719a.aa0().getPaint().setFakeBoldText(false);
        this.f441719a.U90().setSelected(false);
        this.f441719a.Z90().getPaint().setFakeBoldText(false);
        this.f441719a.T90().setSelected(false);
        this.f441719a.Y90().getPaint().setFakeBoldText(false);
        ContainerAdapter r101 = this.f441719a.W90();
        r101.y2(null, (String) r100);
    }
}
