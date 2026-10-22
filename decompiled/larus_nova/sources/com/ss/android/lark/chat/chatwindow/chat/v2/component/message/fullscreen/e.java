package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_MessageFullScreenActivity f413963a;

    public e(Hilt_MessageFullScreenActivity r100) {
        this.f413963a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_MessageFullScreenActivity r101 = this.f413963a;
        if (r101.f413935a == true) goto L6;
        r101.f413935a = true;
        g r102 = (g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        MessageFullScreenActivity r103 = (MessageFullScreenActivity) UnsafeCasts.unsafeCast(r101);
        r102.W0();
        return;
    }
}
