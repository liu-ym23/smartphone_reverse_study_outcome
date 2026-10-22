package com.ss.android.lark.conditional.access.web.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_UserScopeBindDeviceWebActivity f418509a;

    public a(Hilt_UserScopeBindDeviceWebActivity r100) {
        this.f418509a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_UserScopeBindDeviceWebActivity r101 = this.f418509a;
        if (r101.f418494a == true) goto L6;
        r101.f418494a = true;
        c r102 = (c) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        UserScopeBindDeviceWebActivity r103 = (UserScopeBindDeviceWebActivity) UnsafeCasts.unsafeCast(r101);
        r102.N0();
        return;
    }
}
