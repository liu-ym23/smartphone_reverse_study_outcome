package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f268539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f268540c;

    public z4(String r100) {
        int r101 = x4.f268501d;
        this(r100, 0, "");
    }

    public z4(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        this.f268540c = "";
        this.f268538a = r100;
        this.f268539b = r101;
        this.f268540c = r102;
    }
}
