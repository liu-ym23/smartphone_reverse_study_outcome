package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import androidx.lifecycle.Observer;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersFragment f442392a;

    public k(TaskListMembersFragment r100) {
        this.f442392a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        this.f442392a.X90().setMode(LKUIPtrFrameLayout.Mode.LOAD_MORE);
        return;
    L5:
        this.f442392a.X90().setMode(LKUIPtrFrameLayout.Mode.NONE);
    }
}
