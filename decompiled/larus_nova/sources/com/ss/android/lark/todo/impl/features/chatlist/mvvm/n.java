package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersFragment f442396a;

    public n(TaskListMembersFragment r100) {
        this.f442396a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KeyboardUtils.hideKeyboard(this.f442396a.S90().getContext());
        zab.a.a(this.f442396a);
    }
}
