package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f442696a = null;

    static {
        f442696a = new b();
    }

    public b() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OperationToastHelper r101 = OperationToastHelper.f442443a;
        OperationToastHelper.c(r100.getContext(), R.string.Todo_Task_UnableEditTaskFromDocs, null, 60);
    }
}
