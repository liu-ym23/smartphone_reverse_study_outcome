package com.bytedance.ee.android.file.picker.lib.v2.ui;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_ConfirmActivity f206141a;

    public n(Hilt_ConfirmActivity r100) {
        this.f206141a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_ConfirmActivity r101 = this.f206141a;
        if (r101.f206077c == true) goto L6;
        r101.f206077c = true;
        ((c) r101.generatedComponent()).d((ConfirmActivity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
