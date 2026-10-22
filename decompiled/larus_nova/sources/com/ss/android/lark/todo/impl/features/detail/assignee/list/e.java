package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssigneeBean f442707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeAdapter f442708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f442709c;

    public static final class a implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAssigneeAdapter f442710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssigneeBean f442711b;

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            this.f442710a.f442671a.b(this.f442711b.getId());
        }

        public a(TodoAssigneeAdapter r100, AssigneeBean r101) {
            this.f442710a = r100;
            this.f442711b = r101;
        }
    }

    public static final class b implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAssigneeAdapter f442712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssigneeBean f442713b;

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            this.f442712a.f442671a.c(this.f442713b.getId());
        }

        public b(TodoAssigneeAdapter r100, AssigneeBean r101) {
            this.f442712a = r100;
            this.f442713b = r101;
        }
    }

    public e(AssigneeBean r100, TodoAssigneeAdapter r101, LinearLayout r102) {
        this.f442707a = r100;
        this.f442708b = r101;
        this.f442709c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f442707a.getDeleteQuitWarning() == false) goto L5;
        TodoAssigneeAdapter.z2(this.f442708b, this.f442709c.getContext(), new a(this.f442708b, this.f442707a));
        return;
    L5:
        TodoAssigneeAdapter.y2(this.f442708b, this.f442709c.getContext(), new b(this.f442708b, this.f442707a));
    }
}
