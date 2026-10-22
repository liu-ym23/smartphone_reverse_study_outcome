package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAttachmentData f442969a;

    public o(TodoAttachmentData r100) {
        this.f442969a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f442969a.getFileToken();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        String r103 = this.f442969a.getFileToken();
        if (r103 == null) goto L15;
        TodoAttachmentData r104 = this.f442969a;
        ArrayList<g8c.b> r105 = g8c.c.f480461a;
        g8c.c.c(r100.getContext(), r103, r104.getName());
        return;
    L15:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
