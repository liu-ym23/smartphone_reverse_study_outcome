package com.ss.android.lark.compose.chat_member_list;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowChatMembersListActivity f417350a;

    public h(Hilt_FlowChatMembersListActivity r100) {
        this.f417350a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowChatMembersListActivity r101 = this.f417350a;
        if (r101.f417329a == true) goto L6;
        r101.f417329a = true;
        g r102 = (g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowChatMembersListActivity r103 = (FlowChatMembersListActivity) UnsafeCasts.unsafeCast(r101);
        r102.F();
        return;
    }
}
