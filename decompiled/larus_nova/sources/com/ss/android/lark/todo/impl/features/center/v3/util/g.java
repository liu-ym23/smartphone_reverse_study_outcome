package com.ss.android.lark.todo.impl.features.center.v3.util;

import android.content.Context;
import android.content.DialogInterface;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f441796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListDialogUtils.d f441797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f441798c;

    public g(Context r100, TaskListDialogUtils.d r101, Ref.ObjectRef<String> r102) {
        this.f441796a = r100;
        this.f441797b = r101;
        this.f441798c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = TaskListDialogUtils.f441775a;
        TaskListDialogUtils.a(this.f441796a, r100);
        this.f441797b.b(this.f441798c.element);
    }
}
