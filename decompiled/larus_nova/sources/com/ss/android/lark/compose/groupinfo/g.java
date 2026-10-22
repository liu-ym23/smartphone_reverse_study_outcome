package com.ss.android.lark.compose.groupinfo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowGroupInfoActivity f417720a;

    public g(Hilt_FlowGroupInfoActivity r100) {
        this.f417720a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowGroupInfoActivity r101 = this.f417720a;
        if (r101.f417706a == true) goto L6;
        r101.f417706a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowGroupInfoActivity r103 = (FlowGroupInfoActivity) UnsafeCasts.unsafeCast(r101);
        r102.A0();
        return;
    }
}
