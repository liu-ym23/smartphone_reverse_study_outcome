package com.bytedance.ee.bear.list.create;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f227733a;

    public h(m r100) {
        this.f227733a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        e.b(this.f227733a, "cancel");
    }
}
