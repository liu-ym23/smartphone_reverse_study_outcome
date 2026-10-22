package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import android.widget.LinearLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssigneeSection f443327a;

    public a(AssigneeSection r100) {
        this.f443327a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443327a.b().e(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.x.f443790a, true);
        ((LinearLayout) this.f443327a.f443119c.findViewById(R.id.layout_revoke_assignee)).setVisibility(8);
        a9c.c.a("todo_revoke_click");
    }
}
