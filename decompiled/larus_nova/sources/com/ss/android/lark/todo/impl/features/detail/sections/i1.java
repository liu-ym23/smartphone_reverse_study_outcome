package com.ss.android.lark.todo.impl.features.detail.sections;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class i1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SummarySection f443372a;

    public i1(SummarySection r100) {
        this.f443372a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f443372a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.u2.f443778a);
    }
}
