package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class b0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218890b;

    public b0(r r100, tb5.m r101) {
        this.f218889a = r100;
        this.f218890b = r101;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        r.c(this.f218889a, "cancel_by_touch_outside", null, this.f218890b, true, Boolean.FALSE, null, 32);
    }
}
