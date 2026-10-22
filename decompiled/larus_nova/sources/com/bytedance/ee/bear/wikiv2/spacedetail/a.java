package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f241325a;

    public a(b r100) {
        this.f241325a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        b r101 = this.f241325a;
        if (r101.f241326c == true) goto L6;
        r101.f241326c = true;
        ((g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).h((WikiSpaceDetailActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
