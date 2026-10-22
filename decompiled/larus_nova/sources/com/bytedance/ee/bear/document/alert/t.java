package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class t implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f218949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f218952d;

    public t(r r100, AlertModel r101, tb5.m r102, Ref.BooleanRef r103) {
        this.f218949a = r100;
        this.f218950b = r101;
        this.f218951c = r102;
        this.f218952d = r103;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        r.c(this.f218949a, ((AlertModel.ButtonsBean) ListProtector.get(this.f218950b.getButtons(), 1)).getId(), null, this.f218951c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218950b.getButtons(), 1)).isAutoDismiss(), Boolean.valueOf(this.f218952d.element), null, 32);
    }
}
