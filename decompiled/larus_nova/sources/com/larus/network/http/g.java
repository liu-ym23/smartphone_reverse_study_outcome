package com.larus.network.http;

import java.io.BufferedReader;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f360159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f360160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f360161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f360162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f360163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BufferedReader f360164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Throwable f360165g;

    public g() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f360159a, r101.f360159a) == true) goto L12;
        return false;
    L12:
        if (this.f360160b == r101.f360160b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f360161c, r101.f360161c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f360162d, r101.f360162d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f360163e, r101.f360163e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f360164f, r101.f360164f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f360165g, r101.f360165g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f360159a.hashCode() * 31) + this.f360160b) * 31;
        Map<String, String> r101 = this.f360161c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f360162d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f360163e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        BufferedReader r111 = this.f360164f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Throwable r114 = this.f360165g;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "FlowNetResult(url=" + this.f360159a + ", status=" + this.f360160b + ", headers=" + this.f360161c + ", body=" + this.f360162d + ", message=" + this.f360163e + ", stream=" + this.f360164f + ", exception=" + this.f360165g + ')';
    }

    public g(String r100, int r101, Map r102, String r103, String r104, BufferedReader r105, Throwable r106, int r110) {
        if ((r110 & 32) == 0) goto L6;
        r105 = null;
    L6:
        if ((r110 & 64) == 0) goto L8;
        r106 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f360159a = r100;
        this.f360160b = r101;
        this.f360161c = r102;
        this.f360162d = r103;
        this.f360163e = r104;
        this.f360164f = r105;
        this.f360165g = r106;
    }
}
