package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class b0 implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_OfficeDoubaoUiDemoActivity f217539a;

    public b0(Hilt_OfficeDoubaoUiDemoActivity r100) {
        this.f217539a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_OfficeDoubaoUiDemoActivity r101 = this.f217539a;
        if (r101.f217512c == true) goto L6;
        r101.f217512c = true;
        c1 r102 = (c1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        OfficeDoubaoUiDemoActivity r103 = (OfficeDoubaoUiDemoActivity) UnsafeCasts.unsafeCast(r101);
        r102.G0();
        return;
    }
}
