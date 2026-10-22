package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218887c;

    public a0(r r100, AlertModel r101, tb5.m r102) {
        this.f218885a = r100;
        this.f218886b = r101;
        this.f218887c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        r.c(this.f218885a, ((AlertModel.ButtonsBean) ListProtector.get(this.f218886b.getButtons(), 2)).getId(), null, this.f218887c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218886b.getButtons(), 2)).isAutoDismiss(), null, null, 48);
    }
}
