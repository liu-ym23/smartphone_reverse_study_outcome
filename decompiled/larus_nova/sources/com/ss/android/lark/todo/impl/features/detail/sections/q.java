package com.ss.android.lark.todo.impl.features.detail.sections;

import androidx.lifecycle.Observer;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;

/* JADX INFO: loaded from: classes38.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DetailAttachmentAdapter f443423a;

    public q(DetailAttachmentAdapter r100) {
        this.f443423a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        DetailAttachmentAdapter r101 = this.f443423a;
        ((TodoData) r100).isCreateTodo();
        r101.getClass();
    }
}
