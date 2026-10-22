package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class d0 implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_OfficeSpaceDemoActivity f217543a;

    public d0(Hilt_OfficeSpaceDemoActivity r100) {
        this.f217543a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_OfficeSpaceDemoActivity r101 = this.f217543a;
        if (r101.f217514c == true) goto L6;
        r101.f217514c = true;
        ((e1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).l1((OfficeSpaceDemoActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
