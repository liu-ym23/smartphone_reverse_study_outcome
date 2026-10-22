package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeAdapter f442704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f442705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AssigneeBean f442706c;

    public d(TodoAssigneeAdapter r100, LinearLayout r101, AssigneeBean r102) {
        this.f442704a = r100;
        this.f442705b = r101;
        this.f442706c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoAssigneeAdapter r101 = this.f442704a;
        Context r102 = this.f442705b.getContext();
        AssigneeBean r103 = this.f442706c;
        r101.getClass();
        if (r103.isComplete() == false) goto L5;
        String r104 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_CollabTask_MarkAsNotComplete);
    L6:
        com.ss.android.lark.todo.impl.utils.i r105 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        String r106 = r105.g(R.string.Todo_RemoveOwner_Button);
        ((UDActionPanelBuilder) new UDActionPanelBuilder(r102).items(CollectionsKt.listOf(new String[]{r104, r106})).itemClickListener(new f(r101, r103, r102)).addActionButton(R.id.ud_dialog_btn_cancel, r105.g(R.string.Todo_Common_Cancel), null)).show();
        return;
    L5:
        r104 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_CollabTask_MarkAsComplete);
        goto L6
    }
}
