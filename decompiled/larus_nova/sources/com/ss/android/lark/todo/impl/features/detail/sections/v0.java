package com.ss.android.lark.todo.impl.features.detail.sections;

import com.larksuite.component.universe_design.dialog.UDListDialogController;

/* JADX INFO: loaded from: classes38.dex */
public final class v0 implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FollowerSection f443456a;

    public v0(FollowerSection r100) {
        this.f443456a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        if (r100 != 0) goto L5;
        this.f443456a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j4.f443721a);
        return;
    }
}
