package com.ss.android.lark.compose.chatsetting.remove_chatter;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowRemoveGroupMemberActivity f417483a;

    public b(Hilt_FlowRemoveGroupMemberActivity r100) {
        this.f417483a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowRemoveGroupMemberActivity r101 = this.f417483a;
        if (r101.f417480a == true) goto L6;
        r101.f417480a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowRemoveGroupMemberActivity r103 = (FlowRemoveGroupMemberActivity) UnsafeCasts.unsafeCast(r101);
        r102.B0();
        return;
    }
}
