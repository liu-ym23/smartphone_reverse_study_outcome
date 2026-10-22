package com.ss.android.lark.todo.impl.features.setting;

import androidx.lifecycle.Observer;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoBadgeSettingFragment f443984a;

    public f(TodoBadgeSettingFragment r100) {
        this.f443984a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        OperationToastHelper r102 = OperationToastHelper.f442443a;
        OperationToastHelper.b(this.f443984a.getContext(), R.string.Todo_Task_FailedToSet, null, null, null, 60);
    }
}
