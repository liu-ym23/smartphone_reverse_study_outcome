package com.ss.android.lark.todo.impl.features.detail.sections;

import android.content.DialogInterface;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DetailAttachmentAdapter f443449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoAttachmentData f443450b;

    public u(DetailAttachmentAdapter r100, TodoAttachmentData r101) {
        this.f443449a = r100;
        this.f443450b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f443449a.f443172a.c().d(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.z0.f443801a, this.f443450b);
    }
}
