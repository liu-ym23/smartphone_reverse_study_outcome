package com.ss.android.lark.todo.impl.features.detail.sections;

import com.larksuite.component.universe_design.dialog.UDListDialogController;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomContainerSection f443356a;

    public f(BottomContainerSection r100) {
        this.f443356a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        if (r100 != 0) goto L4;
        this.f443356a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.u.f443775a);
        return;
    L4:
        if (r100 != 1) goto L10;
        this.f443356a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.w.f443785a);
        return;
    }
}
