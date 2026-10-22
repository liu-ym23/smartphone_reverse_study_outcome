package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f365140h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365147g;

    public static final class a {
    }

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f365141a, r101.f365141a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365142b, r101.f365142b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365143c, r101.f365143c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365144d, r101.f365144d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365145e, r101.f365145e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365146f, r101.f365146f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365147g, r101.f365147g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f365141a.hashCode() * 31) + this.f365142b.hashCode()) * 31) + this.f365143c.hashCode()) * 31) + this.f365144d.hashCode()) * 31) + this.f365145e.hashCode()) * 31) + this.f365146f.hashCode()) * 31) + this.f365147g.hashCode();
    }

    public final String toString() {
        return "BoeDomainConfig(wwwOnlineHost=" + this.f365141a + ", wwwBoeHost=" + this.f365142b + ", wssNormalHost=" + this.f365143c + ", wss100NormalHost=" + this.f365144d + ", wssNormalBoeHost=" + this.f365145e + ", wsSamanthaHost=" + this.f365146f + ", wsSamanthaBoeHost=" + this.f365147g + ')';
    }

    static {
        f365140h = new i(0);
    }

    public /* synthetic */ i(int r100) {
        this("", "", "", "", "", "", "");
    }

    public i(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "wwwOnlineHost");
        Intrinsics.checkNotNullParameter(r101, "wwwBoeHost");
        Intrinsics.checkNotNullParameter(r102, "wssNormalHost");
        Intrinsics.checkNotNullParameter(r103, "wss100NormalHost");
        Intrinsics.checkNotNullParameter(r104, "wssNormalBoeHost");
        Intrinsics.checkNotNullParameter(r105, "wsSamanthaHost");
        Intrinsics.checkNotNullParameter(r106, "wsSamanthaBoeHost");
        this.f365141a = r100;
        this.f365142b = r101;
        this.f365143c = r102;
        this.f365144d = r103;
        this.f365145e = r104;
        this.f365146f = r105;
        this.f365147g = r106;
    }
}
