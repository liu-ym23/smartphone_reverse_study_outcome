package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218955b;

    public v(r r100, tb5.m r101) {
        this.f218954a = r100;
        this.f218955b = r101;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        r.c(this.f218954a, "cancel_by_touch_outside", null, this.f218955b, true, Boolean.FALSE, null, 32);
    }
}
