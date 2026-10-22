package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.view.View;
import com.ss.android.lark.todo.impl.features.chatlist.item.TodoDisplayItem;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoChatItemViewHolder f442218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoDisplayItem f442219b;

    public d(TodoChatItemViewHolder r100, TodoDisplayItem r101) {
        this.f442218a = r100;
        this.f442219b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TodoChatListAdapter.b r101 = this.f442218a.f442201c;
        if (r101 == null) goto L6;
        r101.a(this.f442219b.f442257t);
        return;
    }
}
