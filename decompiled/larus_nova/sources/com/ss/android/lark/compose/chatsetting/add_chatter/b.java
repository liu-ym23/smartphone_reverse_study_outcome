package com.ss.android.lark.compose.chatsetting.add_chatter;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowAddMemberActivity f417356a;

    public b(Hilt_FlowAddMemberActivity r100) {
        this.f417356a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowAddMemberActivity r101 = this.f417356a;
        if (r101.f417355a == true) goto L6;
        r101.f417355a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowAddMemberActivity r103 = (FlowAddMemberActivity) UnsafeCasts.unsafeCast(r101);
        r102.B();
        return;
    }
}
