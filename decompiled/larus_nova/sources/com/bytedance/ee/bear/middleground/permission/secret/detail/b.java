package com.bytedance.ee.bear.middleground.permission.secret.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f234061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f234064d;

    public b() {
        this(0, false, null, 15);
    }

    public b(int r100, boolean r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f234061a = r100;
        this.f234062b = r101;
        this.f234063c = r102;
        this.f234064d = 0;
    }
}
