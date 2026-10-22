package com.ss.android.lark.image.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f426451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f426452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f426453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f426454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f426455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f426456f;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "resultCode:" + this.f426451a + ",errorMsg:" + this.f426452b + ",latency:" + this.f426453c + ",size:" + this.f426454d + ",width:" + this.f426455e + ",height:" + this.f426456f;
    }

    public d(int r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        this.f426451a = r100;
        this.f426452b = r101;
        this.f426453c = 0;
        this.f426454d = 0;
        this.f426455e = 0;
        this.f426456f = 0;
    }
}
