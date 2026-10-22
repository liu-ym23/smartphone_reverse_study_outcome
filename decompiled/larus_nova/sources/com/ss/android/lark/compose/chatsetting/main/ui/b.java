package com.ss.android.lark.compose.chatsetting.main.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowChatSettingActivity f417439a;

    public b(Hilt_FlowChatSettingActivity r100) {
        this.f417439a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowChatSettingActivity r101 = this.f417439a;
        if (r101.f417438a == true) goto L6;
        r101.f417438a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowChatSettingActivity r103 = (FlowChatSettingActivity) UnsafeCasts.unsafeCast(r101);
        r102.D();
        return;
    }
}
