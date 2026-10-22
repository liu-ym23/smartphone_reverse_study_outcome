package com.ss.android.lark.audio.voiceinput;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f409198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f409199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f409201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f409202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f409203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f409204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f409205h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f409198a == r101.f409198a) goto L12;
        return false;
    L12:
        if (this.f409199b == r101.f409199b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409200c, r101.f409200c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409201d, r101.f409201d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409202e, r101.f409202e) == true) goto L24;
        return false;
    L24:
        if (this.f409203f == r101.f409203f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f409204g, r101.f409204g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f409205h, r101.f409205h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f409198a * 31) + this.f409199b) * 31) + this.f409200c.hashCode()) * 31;
        String r101 = this.f409201d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f409202e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f409203f) * 31;
        String r108 = this.f409204g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.f409205h;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrNerInfo(startIndex=" + this.f409198a + ", endIndex=" + this.f409199b + ", name=" + this.f409200c + ", pinyin=" + this.f409201d + ", strategyCategory=" + this.f409202e + ", rankIndex=" + this.f409203f + ", userId=" + this.f409204g + ", userInChat=" + this.f409205h + ')';
    }

    public a(int r100, int r101, String r102, String r103, String r104, int r105, String r106, Boolean r107) {
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f409198a = r100;
        this.f409199b = r101;
        this.f409200c = r102;
        this.f409201d = r103;
        this.f409202e = r104;
        this.f409203f = r105;
        this.f409204g = r106;
        this.f409205h = r107;
    }
}
