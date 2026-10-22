package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q0 implements com.ss.android.lark.todo.impl.features.common.helper.a.InterfaceC5344a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442086a;

    public q0(TaskItemViewHolder r100) {
        this.f442086a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.common.helper.a.InterfaceC5344a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tipsStr");
        OperationToastHelper r101 = OperationToastHelper.f442443a;
        OperationToastHelper.c(this.f442086a.f441924a.getContext(), 0, r100, 56);
    }
}
