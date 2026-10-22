package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssigneeBean f442697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeAdapter f442698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f442699c;

    public static final class a implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAssigneeAdapter f442700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssigneeBean f442701b;

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            this.f442700a.f442671a.b(this.f442701b.getId());
        }

        public a(TodoAssigneeAdapter r100, AssigneeBean r101) {
            this.f442700a = r100;
            this.f442701b = r101;
        }
    }

    public static final class b implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAssigneeAdapter f442702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssigneeBean f442703b;

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            this.f442702a.f442671a.c(this.f442703b.getId());
        }

        public b(TodoAssigneeAdapter r100, AssigneeBean r101) {
            this.f442702a = r100;
            this.f442703b = r101;
        }
    }

    public c(AssigneeBean r100, TodoAssigneeAdapter r101, ImageView r102) {
        this.f442697a = r100;
        this.f442698b = r101;
        this.f442699c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f442697a.getDeleteDirect() == false) goto L6;
        this.f442698b.f442671a.c(this.f442697a.getId());
        return;
    L6:
        if (this.f442697a.getDeleteQuitWarning() == false) goto L8;
        TodoAssigneeAdapter.z2(this.f442698b, this.f442699c.getContext(), new a(this.f442698b, this.f442697a));
        return;
    L8:
        TodoAssigneeAdapter.y2(this.f442698b, this.f442699c.getContext(), new b(this.f442698b, this.f442697a));
    }
}
