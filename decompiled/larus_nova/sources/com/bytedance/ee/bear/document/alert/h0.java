package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class h0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218921b;

    public h0(r r100, tb5.m r101) {
        this.f218920a = r100;
        this.f218921b = r101;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        r.c(this.f218920a, "cancel_by_touch_outside", null, this.f218921b, true, Boolean.FALSE, null, 32);
    }
}
