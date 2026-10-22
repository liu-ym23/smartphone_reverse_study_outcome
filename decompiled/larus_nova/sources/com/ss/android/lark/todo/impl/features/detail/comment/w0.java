package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class w0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAttachmentData f443002a;

    public w0(TodoAttachmentData r100) {
        this.f443002a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ArrayList<g8c.b> r101 = g8c.c.f480461a;
        g8c.c.d(this.f443002a.getGuid());
    }
}
