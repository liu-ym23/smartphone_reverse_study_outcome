package com.ss.android.lark.todo.impl.features.detail.sections;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class r1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleBarSection f443433a;

    public r1(TitleBarSection r100) {
        this.f443433a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f443433a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.a1.f443664a);
    }
}
