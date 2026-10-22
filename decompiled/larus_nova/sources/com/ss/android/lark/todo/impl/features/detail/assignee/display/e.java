package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAssigneeDisplayFragment f442659a;

    public e(TodoAssigneeDisplayFragment r100) {
        this.f442659a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        if (r100 == 0) goto L5;
        boolean r101 = this.f442659a.f442646p;
    L9:
        if (r101 == false) goto L23;
        TodoAssigneeDisplayFragment r102 = this.f442659a;
        boolean r103 = !r102.f442646p;
        r102.f442646p = r103;
        a9c.b r104 = a9c.b.f2313a;
        a9c.b.r("", true, true, !r103);
        TodoAssigneeDisplayFragment r105 = this.f442659a;
        View r106 = r105.f442637g;
        if (r106 != null) goto L17;
        View r107 = r105.getView();
        if (r107 == null) goto L15;
        r106 = r107.findViewById(R.id.text_task_mode);
    L16:
        r105.f442637g = (TextView) r106;
        goto L17
    L15:
        r106 = null;
    L17:
        TextView r108 = (TextView) r106;
        if (this.f442659a.f442646p == false) goto L20;
        i r109 = i.f444291a;
        int r110 = R.string.Todo_MultiOwners_RequireAnyoneComplete_Option;
    L21:
        r108.setText(r109.g(r110));
        return;
    L20:
        r109 = i.f444291a;
        r110 = R.string.Todo_MultiOwners_RequireEveryoneComplete_Option;
        goto L21
    L23:
        return;
    L5:
        if (this.f442659a.f442646p == true) goto L7;
        r101 = true;
        goto L9
    L7:
        r101 = false;
        goto L9
    }
}
