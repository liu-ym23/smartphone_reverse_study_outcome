package com.ss.android.lark.flow.threadwindow;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes36.dex */
public final class u implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowThreadWindowActivity f424292a;

    public u(Hilt_FlowThreadWindowActivity r100) {
        this.f424292a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowThreadWindowActivity r101 = this.f424292a;
        if (r101.f424227a == true) goto L6;
        r101.f424227a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowThreadWindowActivity r103 = (FlowThreadWindowActivity) UnsafeCasts.unsafeCast(r101);
        r102.o0();
        return;
    }
}
