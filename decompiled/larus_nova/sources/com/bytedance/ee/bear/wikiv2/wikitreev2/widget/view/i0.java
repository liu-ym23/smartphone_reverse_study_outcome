package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i0 implements gp5.a.InterfaceC6049a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f242491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f242492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f242493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242494d;

    @Override // gp5.a.InterfaceC6049a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (this.f242491a == false) goto L5;
        r100 = r100 + com.bytedance.ee.util.io.a.b(this.f242492b);
    L5:
        this.f242493c.f242420e.rename(this.f242494d.f241914b, r100);
    }

    public i0(boolean r100, String r101, c0 r102, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r103) {
        this.f242491a = r100;
        this.f242492b = r101;
        this.f242493c = r102;
        this.f242494d = r103;
    }
}
