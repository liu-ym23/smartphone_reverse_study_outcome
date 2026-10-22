package com.bytedance.awemeopen.apps.photo.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements o24.a {
    public final /* synthetic */ c0 a;

    public b0(c0 r1) {
        this.a = r1;
    }

    public final void onChange(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "aid");
        if (Intrinsics.areEqual(r1, this.a.d.a.c()) == false) goto L6;
        this.a.m();
        return;
    }
}
