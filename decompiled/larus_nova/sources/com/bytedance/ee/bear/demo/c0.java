package com.bytedance.ee.bear.demo;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class c0 implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_OfficeFolderDetailDemoActivity f217541a;

    public c0(Hilt_OfficeFolderDetailDemoActivity r100) {
        this.f217541a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_OfficeFolderDetailDemoActivity r101 = this.f217541a;
        if (r101.f217513c == true) goto L6;
        r101.f217513c = true;
        ((d1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).n((OfficeFolderDetailDemoActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
