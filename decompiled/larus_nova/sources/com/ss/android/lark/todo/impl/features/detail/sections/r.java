package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAttachmentData f443426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DetailAttachmentAdapter f443427b;

    public r(TodoAttachmentData r100, DetailAttachmentAdapter r101) {
        this.f443426a = r100;
        this.f443427b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f443426a.getFileToken();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        this.f443427b.f443172a.c().d(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.l2.f443731a, new com.ss.android.lark.todo.impl.features.detail.viewmodel.s(this.f443426a.getFileToken(), this.f443426a.getName()));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
