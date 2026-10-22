package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import com.ss.android.lark.todo.impl.features.chatlist.item.TodoDisplayItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements TodoChatListAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoDisplayItem f442235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoChatListAdapter f442236b;

    @Override // com.ss.android.lark.todo.impl.features.chatlist.adapter.TodoChatListAdapter.b
    public final void a(TodoDisplayItem.ChatListTitleType r100) {
        Intrinsics.checkNotNullParameter(r100, "titleType");
        TodoDisplayItem r101 = this.f442235a;
        if (r101.f442255r == true) goto L5;
        return;
    L5:
        TodoChatListAdapter.c r102 = this.f442236b.f442206d;
        if (r102 == null) goto L9;
        r102.a(r100, !r101.f442258u);
        return;
    }

    public j(TodoDisplayItem r100, TodoChatListAdapter r101) {
        this.f442235a = r100;
        this.f442236b = r101;
    }
}
