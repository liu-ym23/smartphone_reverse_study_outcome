package com.suite.lark.platform.component.cta;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f460483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f460484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ goc.b f460485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ goc.b.d f460486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ goc.a f460487e;

    public d(b r100, Context r101, goc.b r102, goc.b.d r103, goc.a r104) {
        this.f460483a = r100;
        this.f460484b = r101;
        this.f460485c = r102;
        this.f460486d = r103;
        this.f460487e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        b.a(this.f460483a, this.f460484b, this.f460485c, this.f460486d, this.f460487e);
    }
}
