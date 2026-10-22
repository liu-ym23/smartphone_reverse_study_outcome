package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.b f216549a;

    public /* synthetic */ g(h.b r100) {
        this.f216549a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f216549a.onDismiss();
    }
}
