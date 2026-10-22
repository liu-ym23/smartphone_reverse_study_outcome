package com.ss.android.lark.todo.impl.features.center.v3.util;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f441799a;

    public h(Context r100) {
        this.f441799a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = TaskListDialogUtils.f441775a;
        TaskListDialogUtils.a(this.f441799a, r100);
    }
}
