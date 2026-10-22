package com.bytedance.ee.bear.profile;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_HalfProfileActivity f236296a;

    public o(Hilt_HalfProfileActivity r100) {
        this.f236296a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_HalfProfileActivity r101 = this.f236296a;
        if (r101.f236277e == true) goto L6;
        r101.f236277e = true;
        i r102 = (i) r101.generatedComponent();
        HalfProfileActivity r103 = (HalfProfileActivity) UnsafeCasts.unsafeCast(r101);
        r102.c();
        return;
    }
}
