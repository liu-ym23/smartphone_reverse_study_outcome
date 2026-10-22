package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import androidx.lifecycle.Observer;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class z<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoChatListFragment f442412a;

    public z(TodoChatListFragment r100) {
        this.f442412a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LKUIPtrClassicFrameLayout r101 = this.f442412a.Y90();
        if (((Boolean) r100).booleanValue() == false) goto L5;
        LKUIPtrFrameLayout.Mode r102 = LKUIPtrFrameLayout.Mode.LOAD_MORE;
    L6:
        r101.setMode(r102);
        return;
    L5:
        r102 = LKUIPtrFrameLayout.Mode.NONE;
        goto L6
    }
}
