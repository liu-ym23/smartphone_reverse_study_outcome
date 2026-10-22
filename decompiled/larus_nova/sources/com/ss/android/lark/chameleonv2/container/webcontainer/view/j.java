package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_ModelChameleonActivity f411363a;

    public j(Hilt_ModelChameleonActivity r100) {
        this.f411363a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_ModelChameleonActivity r101 = this.f411363a;
        if (r101.f411341a == true) goto L6;
        r101.f411341a = true;
        k r102 = (k) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        ModelChameleonActivity r103 = (ModelChameleonActivity) UnsafeCasts.unsafeCast(r101);
        r102.E();
        return;
    }
}
