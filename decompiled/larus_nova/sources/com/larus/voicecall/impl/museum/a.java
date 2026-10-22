package com.larus.voicecall.impl.museum;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f378373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f378374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f378375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f378376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f378377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f378378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f378379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f378380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f378381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f378382j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f378373a, r101.f378373a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f378374b, r101.f378374b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f378375c, r101.f378375c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f378376d, r101.f378376d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f378377e, r101.f378377e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f378378f, r101.f378378f) == true) goto L27;
        return false;
    L27:
        if (this.f378379g == r101.f378379g) goto L30;
        return false;
    L30:
        if (this.f378380h == r101.f378380h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f378381i, r101.f378381i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f378382j, r101.f378382j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f378373a.hashCode() * 31) + this.f378374b.hashCode()) * 31) + this.f378375c.hashCode()) * 31) + this.f378376d.hashCode()) * 31) + this.f378377e.hashCode()) * 31) + this.f378378f.hashCode()) * 31) + this.f378379g) * 31;
        long r101 = this.f378380h;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f378381i;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f378382j;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MuseumExtensionBanner(title=" + this.f378373a + ", content=" + this.f378374b + ", icon=" + this.f378375c + ", museum=" + this.f378376d + ", stage=" + this.f378377e + ", buttonText=" + this.f378378f + ", priority=" + this.f378379g + ", autoDismissSeconds=" + this.f378380h + ", conversationId=" + this.f378381i + ", callId=" + this.f378382j + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105, int r106, long r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "icon");
        Intrinsics.checkNotNullParameter(r103, "museum");
        Intrinsics.checkNotNullParameter(r104, "stage");
        Intrinsics.checkNotNullParameter(r105, "buttonText");
        this.f378373a = r100;
        this.f378374b = r101;
        this.f378375c = r102;
        this.f378376d = r103;
        this.f378377e = r104;
        this.f378378f = r105;
        this.f378379g = r106;
        this.f378380h = r107;
        this.f378381i = r110;
        this.f378382j = r111;
    }
}
