package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f405226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f405227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f405228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f405229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f405230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Double f405231f;

    public q2(String r100, String r101, Boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 16) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        this.f405226a = r100;
        this.f405227b = r101;
        this.f405228c = null;
        this.f405229d = null;
        this.f405230e = r102;
        this.f405231f = null;
    }
}
