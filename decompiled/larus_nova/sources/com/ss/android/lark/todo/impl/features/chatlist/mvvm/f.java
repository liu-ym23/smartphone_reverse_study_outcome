package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.text.Editable;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersFragment f442384a;

    public f(TaskListMembersFragment r100) {
        this.f442384a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        TaskListMembersFragment r101 = this.f442384a;
        int r102 = TaskListMembersFragment.f442289v;
        TaskListMembersViewModel r103 = r101.Y90();
        if (r100 == null) goto L6;
        String r104 = r100.toString();
        if (r104 == null) goto L6;
    L7:
        r103.setNote(r104);
        return;
    L6:
        r104 = "";
        goto L7
    }
}
