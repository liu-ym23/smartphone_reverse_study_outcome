package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DescriptionSection f443407a;

    public o(DescriptionSection r100) {
        this.f443407a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443407a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.t2.f443773a);
    }
}
