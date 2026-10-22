package com.ss.android.lark.conditional.access.device.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_UserScopeDeviceDeclareActivity f418030a;

    public a(Hilt_UserScopeDeviceDeclareActivity r100) {
        this.f418030a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_UserScopeDeviceDeclareActivity r101 = this.f418030a;
        if (r101.f418011a == true) goto L6;
        r101.f418011a = true;
        d r102 = (d) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        UserScopeDeviceDeclareActivity r103 = (UserScopeDeviceDeclareActivity) UnsafeCasts.unsafeCast(r101);
        r102.F0();
        return;
    }
}
