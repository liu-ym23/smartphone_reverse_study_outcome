package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentAttachmentAdapter f442974a;

    public p(CommentAttachmentAdapter r100) {
        this.f442974a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommentAttachmentAdapter r101 = this.f442974a;
        r101.f442838a = true;
        r101.f442839b.invoke();
        this.f442974a.notifyDataSetChanged();
    }
}
