package com.bytedance.ee.bear.document.alert;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements gp5.a.InterfaceC6049a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f218922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218924c;

    @Override // gp5.a.InterfaceC6049a
    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        e.e(this.f218922a, ((AlertModel.ButtonsBean) ListProtector.get(this.f218923b.getButtons(), 0)).getId(), r110, this.f218924c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218923b.getButtons(), 0)).isAutoDismiss(), null, null, 48);
    }

    public i(e r100, AlertModel r101, tb5.m r102) {
        this.f218922a = r100;
        this.f218923b = r101;
        this.f218924c = r102;
    }
}
