package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f268417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f268418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f268419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnnieXStatusFontMode f268420d;

    public final v1 a() {
        v1 r100 = new v1();
        r100.f268417a = this.f268417a;
        r100.f268419c = this.f268419c;
        g r101 = this.f268418b;
        Intrinsics.checkNotNullParameter(r101, "statusBarBgColor");
        r100.f268418b = r101;
        AnnieXStatusFontMode r102 = this.f268420d;
        Intrinsics.checkNotNullParameter(r102, "statusFontMode");
        r100.f268420d = r102;
        return r100;
    }

    public v1() {
        this.f268418b = new g();
        this.f268420d = AnnieXStatusFontMode.DEFAULT;
    }
}
