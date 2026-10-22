package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeAdapter f442714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AssigneeBean f442715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f442716c;

    public static final class a implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAssigneeAdapter f442717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssigneeBean f442718b;

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            this.f442717a.f442671a.b(this.f442718b.getId());
        }

        public a(TodoAssigneeAdapter r100, AssigneeBean r101) {
            this.f442717a = r100;
            this.f442718b = r101;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        if (r100 != 0) goto L5;
        TodoAssigneeAdapter r101 = this.f442714a;
        AssigneeBean r102 = this.f442715b;
        r101.f442671a.a(new com.ss.android.lark.todo.impl.features.detail.viewmodel.c(r102));
        return;
    L5:
        if (this.f442715b.getDeleteQuitWarning() == false) goto L7;
        TodoAssigneeAdapter r103 = this.f442714a;
        TodoAssigneeAdapter.z2(r103, this.f442716c, new a(r103, this.f442715b));
        return;
    L7:
        this.f442714a.f442671a.c(this.f442715b.getId());
    }

    public f(TodoAssigneeAdapter r100, AssigneeBean r101, Context r102) {
        this.f442714a = r100;
        this.f442715b = r101;
        this.f442716c = r102;
    }
}
