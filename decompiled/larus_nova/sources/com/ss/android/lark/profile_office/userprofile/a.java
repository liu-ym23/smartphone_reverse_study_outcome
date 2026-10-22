package com.ss.android.lark.profile_office.userprofile;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_OfficeProfileActivity f438909a;

    public a(Hilt_OfficeProfileActivity r100) {
        this.f438909a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_OfficeProfileActivity r101 = this.f438909a;
        if (r101.f438873c == true) goto L6;
        r101.f438873c = true;
        c r102 = (c) r101.generatedComponent();
        OfficeProfileActivity r103 = (OfficeProfileActivity) UnsafeCasts.unsafeCast(r101);
        r102.b();
        return;
    }
}
