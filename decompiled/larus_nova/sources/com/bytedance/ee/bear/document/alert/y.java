package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class y implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218964c;

    public y(r r100, AlertModel r101, tb5.m r102) {
        this.f218962a = r100;
        this.f218963b = r101;
        this.f218964c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        r r101 = this.f218962a;
        String r102 = ((AlertModel.ButtonsBean) ListProtector.get(this.f218963b.getButtons(), 0)).getId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r.c(r101, r102, null, this.f218964c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218963b.getButtons(), 0)).isAutoDismiss(), null, null, 48);
    }
}
