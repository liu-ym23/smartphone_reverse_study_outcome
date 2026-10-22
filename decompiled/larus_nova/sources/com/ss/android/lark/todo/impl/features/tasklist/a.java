package com.ss.android.lark.todo.impl.features.tasklist;

import androidx.lifecycle.Observer;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListNameFragment f444016a;

    public a(TaskListNameFragment r100) {
        this.f444016a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        CommonTitleBar r102 = this.f444016a.U90();
        if (r101.booleanValue() == false) goto L5;
        int r103 = R.string.Todo_List_Rename_MenuItem;
    L6:
        r102.setTitle(r103);
        TaskListNameFragment r104 = this.f444016a;
        Intrinsics.checkNotNull(r101);
        TaskListNameFragment.S90(r104, false, r101.booleanValue());
        return;
    L5:
        r103 = R.string.Todo_CreateNewList_Title;
        goto L6
    }
}
