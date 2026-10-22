package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f267941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f267943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f267944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f267945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f267946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f267947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f267948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f267949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f267950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f267951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Double f267952l;

    public a4(String r100, String r101, Object r102, Object r103, Boolean r104, Boolean r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 32) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 64) == 0) goto L14;
        r105 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f267941a = "";
        this.f267942b = "";
        Boolean r107 = Boolean.FALSE;
        this.f267946f = r107;
        Boolean r108 = Boolean.TRUE;
        this.f267947g = r108;
        this.f267948h = r107;
        this.f267949i = r107;
        this.f267941a = r100;
        this.f267942b = r101;
        this.f267943c = r102;
        this.f267944d = r103;
        this.f267945e = null;
        if (r104 != null) goto L17;
        r104 = r107;
    L17:
        this.f267946f = r104;
        if (r105 != null) goto L20;
        r105 = r108;
    L20:
        this.f267947g = r105;
        this.f267948h = r107;
        this.f267949i = r107;
        this.f267950j = null;
        this.f267951k = null;
        this.f267952l = null;
    }
}
