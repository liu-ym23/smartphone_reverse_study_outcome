package com.ss.android.lark.flow.chat.creategroup.page;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowGroupCreateActivity f422102a;

    public i(Hilt_FlowGroupCreateActivity r100) {
        this.f422102a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowGroupCreateActivity r101 = this.f422102a;
        if (r101.f422093a == true) goto L6;
        r101.f422093a = true;
        d r102 = (d) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowGroupCreateActivity r103 = (FlowGroupCreateActivity) UnsafeCasts.unsafeCast(r101);
        r102.O();
        return;
    }
}
