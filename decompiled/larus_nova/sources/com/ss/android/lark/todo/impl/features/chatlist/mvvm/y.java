package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.UICallbackExecutor;

/* JADX INFO: loaded from: classes38.dex */
public final class y<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoChatListFragment f442411a;

    public y(TodoChatListFragment r100) {
        this.f442411a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        UICallbackExecutor.executeDelayed(this.f442411a.f442339r, 100);
    }
}
