package com.bytedance.ee.bear.document.alert;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements gp5.a.InterfaceC6049a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f218917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertModel f218918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb5.m f218919c;

    @Override // gp5.a.InterfaceC6049a
    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        e.e(this.f218917a, ((AlertModel.ButtonsBean) ListProtector.get(this.f218918b.getButtons(), 1)).getId(), r110, this.f218919c, ((AlertModel.ButtonsBean) ListProtector.get(this.f218918b.getButtons(), 1)).isAutoDismiss(), null, null, 48);
    }

    public h(e r100, AlertModel r101, tb5.m r102) {
        this.f218917a = r100;
        this.f218918b = r101;
        this.f218919c = r102;
    }
}
