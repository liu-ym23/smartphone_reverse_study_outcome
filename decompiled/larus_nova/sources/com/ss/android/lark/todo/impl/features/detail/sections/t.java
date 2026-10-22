package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;

/* JADX INFO: loaded from: classes38.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DetailAttachmentAdapter f443442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoAttachmentData f443443b;

    public t(DetailAttachmentAdapter r100, TodoAttachmentData r101) {
        this.f443442a = r100;
        this.f443443b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443442a.f443172a.c().d(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.o2.f443748a, this.f443443b);
    }
}
