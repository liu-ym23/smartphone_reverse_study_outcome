package com.ss.android.lark.flow.mergeforward;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowMergeForwardActivity f423726a;

    public d(Hilt_FlowMergeForwardActivity r100) {
        this.f423726a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowMergeForwardActivity r101 = this.f423726a;
        if (r101.f423722a == true) goto L6;
        r101.f423722a = true;
        ((a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).k1((FlowMergeForwardActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
