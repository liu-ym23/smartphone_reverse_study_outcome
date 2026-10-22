package com.ss.android.lark.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f444732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f444733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f444734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f444735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f444736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f444737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f444738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f444739h;

    @Override // com.ss.android.lark.utils.k
    public final int a() {
        return this.f444733b;
    }

    @Override // com.ss.android.lark.utils.k
    public final int b() {
        return this.f444735d;
    }

    @Override // com.ss.android.lark.utils.k
    public final String c() {
        return this.f444737f;
    }

    @Override // com.ss.android.lark.utils.k
    public final String d() {
        return this.f444739h;
    }

    @Override // com.ss.android.lark.utils.k
    public final int e() {
        return this.f444732a;
    }

    @Override // com.ss.android.lark.utils.k
    public final String f() {
        return this.f444736e;
    }

    @Override // com.ss.android.lark.utils.k
    public final String g() {
        return this.f444738g;
    }

    @Override // com.ss.android.lark.utils.k
    public final int h() {
        return this.f444734c;
    }

    public l(int r100, int r101, int r102, int r103, String r104, String r110, int r111) {
        if ((r111 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r111 & 8) == 0) goto L8;
        r103 = 0;
    L8:
        String r105 = null;
        if ((r111 & 16) == 0) goto L11;
        String r106 = "";
    L13:
        if ((r111 & 32) == 0) goto L16;
        r105 = "";
    L16:
        if ((r111 & 64) == 0) goto L19;
        r104 = "";
    L19:
        if ((r111 & 128) == 0) goto L21;
        r110 = "";
    L21:
        Intrinsics.checkNotNullParameter(r106, "rationaleTitleString");
        Intrinsics.checkNotNullParameter(r105, "rationaleDescriptionString");
        Intrinsics.checkNotNullParameter(r104, "floatingTipTitleString");
        Intrinsics.checkNotNullParameter(r110, "floatingTipDescriptionString");
        this.f444732a = r100;
        this.f444733b = r101;
        this.f444734c = r102;
        this.f444735d = r103;
        this.f444736e = r106;
        this.f444737f = r105;
        this.f444738g = r104;
        this.f444739h = r110;
        return;
    L11:
        r106 = null;
        goto L13
    }
}
