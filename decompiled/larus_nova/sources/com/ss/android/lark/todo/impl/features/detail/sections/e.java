package com.ss.android.lark.todo.impl.features.detail.sections;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomContainerSection f443353a;

    public e(BottomContainerSection r100) {
        this.f443353a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f443353a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.r.f443760a);
    }
}
