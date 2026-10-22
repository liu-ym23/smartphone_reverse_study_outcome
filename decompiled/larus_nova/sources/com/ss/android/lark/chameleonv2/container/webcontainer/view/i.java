package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_ChameleonActivity f411362a;

    public i(Hilt_ChameleonActivity r100) {
        this.f411362a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_ChameleonActivity r101 = this.f411362a;
        if (r101.f411338a == true) goto L6;
        r101.f411338a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        ChameleonActivity r103 = (ChameleonActivity) UnsafeCasts.unsafeCast(r101);
        r102.y();
        return;
    }
}
