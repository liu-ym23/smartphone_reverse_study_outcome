package com.ss.android.lark.todo.impl.features.tasklist;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListNameFragment f444019a;

    public d(TaskListNameFragment r100) {
        this.f444019a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        OperationToastHelper r102 = OperationToastHelper.f442443a;
        Context r103 = this.f444019a.getContext();
        Intrinsics.checkNotNull(r101);
        OperationToastHelper.f(r103, r101.intValue(), null, null, null, 124);
    }
}
