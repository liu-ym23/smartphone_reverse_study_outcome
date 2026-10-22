package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class s implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f218948d;

    public s(r r100, AlertModel r101, tb5.m r102, Ref.BooleanRef r103) {
        this.f218945a = r100;
        this.f218946b = r101;
        this.f218947c = r102;
        this.f218948d = r103;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        r.c(this.f218945a, ((AlertModel.ButtonsBean) ListProtector.get(this.f218946b.getButtons(), 0)).getId(), null, this.f218947c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218946b.getButtons(), 0)).isAutoDismiss(), Boolean.valueOf(this.f218948d.element), null, 32);
    }
}
