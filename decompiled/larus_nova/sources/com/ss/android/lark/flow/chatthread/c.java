package com.ss.android.lark.flow.chatthread;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowChatThreadActivity f423164a;

    public c(Hilt_FlowChatThreadActivity r100) {
        this.f423164a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowChatThreadActivity r101 = this.f423164a;
        if (r101.f423161a == true) goto L6;
        r101.f423161a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowChatThreadActivity r103 = (FlowChatThreadActivity) UnsafeCasts.unsafeCast(r101);
        r102.Y();
        return;
    }
}
