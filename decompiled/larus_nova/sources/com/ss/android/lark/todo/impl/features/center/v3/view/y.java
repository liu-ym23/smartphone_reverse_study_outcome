package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class y implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f442135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SectionItemViewHolder f442136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SectionHeaderItem f442137c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f442135a;
        long r102 = System.currentTimeMillis();
        this.f442135a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        ArrayList r103 = new ArrayList();
        com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r103.add(new UDBaseListDialogBuilder.ListItemBuilder(r104.g(R.string.Todo_New_Section_RenameSection_Button)).build());
        r103.add(new UDBaseListDialogBuilder.ListItemBuilder(r104.g(R.string.Todo_New_Section_AddSectionAbove_Button)).build());
        r103.add(new UDBaseListDialogBuilder.ListItemBuilder(r104.g(R.string.Todo_New_Section_AddSectionBelow_Button)).build());
        r103.add(new UDBaseListDialogBuilder.ListItemBuilder(r104.g(R.string.Todo_ManageSectionSorting_Button)).build());
        if (this.f442137c.f441444j == true) goto L8;
        r103.add(new UDBaseListDialogBuilder.ListItemBuilder(r104.g(R.string.Todo_New_Section_DeleteSection_Button)).build());
    L8:
        UDActionPanelBuilder r105 = new UDActionPanelBuilder(this.f442136b.f441893a.getContext()).itemList(r103).itemClickListener(new z(this.f442137c, this.f442136b));
        r105.addActionButton(R.id.ud_dialog_btn_cancel, R.string.Todo_Common_Cancel, null);
        r105.show();
    }

    public y(SectionItemViewHolder r100, SectionHeaderItem r101) {
        this.f442136b = r100;
        this.f442137c = r101;
    }
}
