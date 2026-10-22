package com.bytedance.ee.bear.middleground.permission.secret.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234046c;

    public a() {
        this(null, false, false, 7);
    }

    public a(String r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f234044a = r100;
        this.f234045b = r101;
        this.f234046c = r102;
    }
}
