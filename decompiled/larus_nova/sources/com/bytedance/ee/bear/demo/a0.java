package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class a0 implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_OfficeCCMDemoContainerActivity f217536a;

    public a0(Hilt_OfficeCCMDemoContainerActivity r100) {
        this.f217536a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_OfficeCCMDemoContainerActivity r101 = this.f217536a;
        if (r101.f217511c == true) goto L6;
        r101.f217511c = true;
        ((b1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).Z((OfficeCCMDemoContainerActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
