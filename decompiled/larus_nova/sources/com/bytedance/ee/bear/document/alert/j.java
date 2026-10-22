package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f218925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218926b;

    public j(e r100, tb5.m r101) {
        this.f218925a = r100;
        this.f218926b = r101;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        e.e(this.f218925a, "cancel_by_touch_outside", null, this.f218926b, true, Boolean.FALSE, null, 32);
    }
}
