package com.ss.android.lark.jsruntime.vmsdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements tnb.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f428187a;

    public l(j r100) {
        this.f428187a = r100;
    }

    @Override // tnb.f
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        e r101 = this.f428187a.f428184k;
        if (r101 == null) goto L6;
        r101.prompt(r100);
        return;
    }

    @Override // tnb.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataString");
        e r101 = this.f428187a.f428184k;
        if (r101 == null) goto L6;
        r101.prompt(r100);
        return;
    }
}
