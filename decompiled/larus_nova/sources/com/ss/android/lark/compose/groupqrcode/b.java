package com.ss.android.lark.compose.groupqrcode;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowGroupQrCodeActivity f417728a;

    public b(Hilt_FlowGroupQrCodeActivity r100) {
        this.f417728a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowGroupQrCodeActivity r101 = this.f417728a;
        if (r101.f417727a == true) goto L6;
        r101.f417727a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowGroupQrCodeActivity r103 = (FlowGroupQrCodeActivity) UnsafeCasts.unsafeCast(r101);
        r102.A();
        return;
    }
}
