package com.ss.android.lark.compose.chatsetting.groupmanage;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowGroupManageActivity f417429a;

    public b(Hilt_FlowGroupManageActivity r100) {
        this.f417429a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowGroupManageActivity r101 = this.f417429a;
        if (r101.f417428a == true) goto L6;
        r101.f417428a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowGroupManageActivity r103 = (FlowGroupManageActivity) UnsafeCasts.unsafeCast(r101);
        r102.i0();
        return;
    }
}
