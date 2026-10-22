package com.ss.android.lark.bottomsheet;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes34.dex */
public final class s implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_BottomSheetContainerActivity f410725a;

    public s(Hilt_BottomSheetContainerActivity r100) {
        this.f410725a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_BottomSheetContainerActivity r101 = this.f410725a;
        if (r101.f410687d == true) goto L6;
        r101.f410687d = true;
        ((l) r101.generatedComponent()).e((BottomSheetContainerActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
