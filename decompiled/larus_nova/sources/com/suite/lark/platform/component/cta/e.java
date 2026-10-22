package com.suite.lark.platform.component.cta;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f460509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f460510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ goc.b f460511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ goc.b.d f460512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ goc.a f460513e;

    public e(b r100, Context r101, goc.b r102, goc.b.d r103, goc.a r104) {
        this.f460509a = r100;
        this.f460510b = r101;
        this.f460511c = r102;
        this.f460512d = r103;
        this.f460513e = r104;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        b.a(this.f460509a, this.f460510b, this.f460511c, this.f460512d, this.f460513e);
    }
}
