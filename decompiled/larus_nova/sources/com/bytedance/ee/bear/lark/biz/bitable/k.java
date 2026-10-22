package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_BitableHomeActivity f227330a;

    public k(Hilt_BitableHomeActivity r100) {
        this.f227330a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_BitableHomeActivity r101 = this.f227330a;
        if (r101.f227313h == true) goto L6;
        r101.f227313h = true;
        b r102 = (b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        BitableHomeActivity r103 = (BitableHomeActivity) UnsafeCasts.unsafeCast(r101);
        r102.H0();
        return;
    }
}
