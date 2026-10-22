package com.larus.avlink.gallery.processor;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f292690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f292691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f292692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f292693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f292694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f292695f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f292690a == r101.f292690a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f292691b, r101.f292691b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f292692c, r101.f292692c) == true) goto L18;
        return false;
    L18:
        if (this.f292693d == r101.f292693d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f292694e, r101.f292694e) == true) goto L24;
        return false;
    L24:
        if (this.f292695f == r101.f292695f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f292690a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f292691b.hashCode()) * 31) + this.f292692c.hashCode()) * 31;
        long r103 = this.f292693d;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f292694e.hashCode()) * 31;
        if (this.f292695f == true) goto L11;
        r100 = 1237;
    L11:
        return r104 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProcessResult(success=" + this.f292690a + ", outputPath=" + this.f292691b + ", error=" + this.f292692c + ", durationMs=" + this.f292693d + ", extras=" + this.f292694e + ", isFallback=" + this.f292695f + ')';
    }

    public final long a() {
        return this.f292693d;
    }

    public final String b() {
        return this.f292692c;
    }

    public final Map<String, Object> c() {
        return this.f292694e;
    }

    public final String d() {
        return this.f292691b;
    }

    public final boolean e() {
        return this.f292690a;
    }

    public final boolean f() {
        return this.f292695f;
    }

    public k(boolean r100, String r101, String r102, long r103, Map<String, ? extends Object> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "outputPath");
        Intrinsics.checkNotNullParameter(r102, "error");
        Intrinsics.checkNotNullParameter(r104, "extras");
        this.f292690a = r100;
        this.f292691b = r101;
        this.f292692c = r102;
        this.f292693d = r103;
        this.f292694e = r104;
        this.f292695f = r105;
    }

    public /* synthetic */ k(boolean r110, String r111, String r112, long r113, Map r114, boolean r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r116 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r116 & 8) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r116 & 16) == 0) goto L17;
        Map r103 = MapsKt.emptyMap();
    L19:
        if ((r116 & 32) == 0) goto L21;
        boolean r104 = false;
    L22:
        this(r110, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
