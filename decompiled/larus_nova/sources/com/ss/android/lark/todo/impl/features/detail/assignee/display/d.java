package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeDisplayFragment f442658b;

    public d(TodoAssigneeDisplayFragment r100) {
        this.f442658b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442657a;
        long r102 = System.currentTimeMillis();
        this.f442657a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        Context r103 = this.f442658b.getContext();
        if (r103 == null) goto L16;
        UDActionPanelBuilder r104 = new UDActionPanelBuilder(r103);
        ArrayList r105 = new ArrayList();
        i r106 = i.f444291a;
        UDBaseListDialogBuilder.ListItemBuilder r107 = new UDBaseListDialogBuilder.ListItemBuilder(r106.g(R.string.Todo_MultiOwners_RequireAnyoneComplete_Option));
        boolean r108 = this.f442658b.f442646p;
        int r109 = R.color.primary_content_default;
        if (r108 == false) goto L10;
        int r110 = R.color.primary_content_default;
    L11:
        r105.add(r107.textColorRes(r110).build());
        UDBaseListDialogBuilder.ListItemBuilder r111 = new UDBaseListDialogBuilder.ListItemBuilder(r106.g(R.string.Todo_MultiOwners_RequireEveryoneComplete_Option));
        if (this.f442658b.f442646p == false) goto L14;
        r109 = R.color.text_title;
    L14:
        r105.add(r111.textColorRes(r109).build());
        ((UDActionPanelBuilder) ((UDActionPanelBuilder) r104.itemList(r105)).itemClickListener(new e(this.f442658b)).addActionButton(R.id.ud_dialog_btn_cancel, r106.g(R.string.Todo_Common_Cancel), null)).show();
        return;
    L10:
        r110 = R.color.text_title;
        goto L11
    }
}
