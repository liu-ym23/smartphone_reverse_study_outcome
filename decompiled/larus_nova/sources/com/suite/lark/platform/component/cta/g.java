package com.suite.lark.platform.component.cta;

import android.content.DialogInterface;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ goc.b.g f460517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f460518b;

    public g(goc.b.g r100, b r101) {
        this.f460517a = r100;
        this.f460518b = r101;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        goc.b.h r101 = this.f460517a.b();
        if (r101 != null) goto L5;
        r101 = new goc.b.h(0);
    L5:
        int r102 = moc.a.f514621a;
        b r103 = this.f460518b;
        String r104 = r103.f460476a;
        String r105 = r103.f460477b;
        String r106 = r101.b();
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        moc.a.a(r104, r105, r106, r101.a(), r101.d(), r.f570325h);
    }
}
