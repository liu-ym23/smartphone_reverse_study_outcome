package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class z implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218967c;

    public z(r r100, AlertModel r101, tb5.m r102) {
        this.f218965a = r100;
        this.f218966b = r101;
        this.f218967c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        r.c(this.f218965a, ((AlertModel.ButtonsBean) ListProtector.get(this.f218966b.getButtons(), 1)).getId(), null, this.f218967c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218966b.getButtons(), 1)).isAutoDismiss(), null, null, 48);
    }
}
