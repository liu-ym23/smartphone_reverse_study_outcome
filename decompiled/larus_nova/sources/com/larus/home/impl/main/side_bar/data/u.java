package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class u implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f344539a;

    public /* synthetic */ u(boolean r100) {
        this.f344539a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        boolean r101 = this.f344539a;
        p r102 = (p) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        b r103 = r102.c();
        if (r103 == null) goto L5;
        int r104 = r103.b();
    L6:
        if (r101 == false) goto L8;
        int r105 = r104 + 1;
    L9:
        b r106 = r102.c();
        if (r106 == null) goto L12;
        b r107 = b.a(r106, r105);
    L14:
        return p.a(r102, null, r107, null, 49151);
    L12:
        r107 = null;
        goto L14
    L8:
        r105 = r104 - 1;
        goto L9
    L5:
        r104 = 0;
        goto L6
    }
}
