package com.ss.android.lark.todo.impl.features.detail.sections;

import com.larksuite.component.universe_design.dialog.UDListDialogController;

/* JADX INFO: loaded from: classes38.dex */
public final class t1 implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleBarSection f443448a;

    public t1(TitleBarSection r100) {
        this.f443448a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        this.f443448a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.m2.f443737a);
    }
}
