package com.ss.android.lark.todo.impl.features.center.v3.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListDialogUtils.d f441785a;

    public b(TaskListDialogUtils.d r100) {
        this.f441785a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f441785a.a();
    }
}
