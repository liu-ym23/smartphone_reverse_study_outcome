package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class z implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_OfficeCCMDemoActivity f217590a;

    public z(Hilt_OfficeCCMDemoActivity r100) {
        this.f217590a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_OfficeCCMDemoActivity r101 = this.f217590a;
        if (r101.f217510c == true) goto L6;
        r101.f217510c = true;
        ((z0) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).g0((OfficeCCMDemoActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
