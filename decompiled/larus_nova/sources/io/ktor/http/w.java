package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f491909d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w f491910e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f491911f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w f491912g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f491914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f491915c;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f491913a, r101.f491913a) == true) goto L12;
        return false;
    L12:
        if (this.f491914b == r101.f491914b) goto L15;
        return false;
    L15:
        if (this.f491915c == r101.f491915c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f491913a.hashCode() * 31) + this.f491914b) * 31) + this.f491915c;
    }

    static {
        f491909d = new a();
        f491910e = new w("HTTP", 2, 0);
        f491911f = new w("HTTP", 1, 1);
        f491912g = new w("HTTP", 1, 0);
        new w("SPDY", 3, 0);
        new w("QUIC", 1, 0);
    }

    public final String toString() {
        return this.f491913a + '/' + this.f491914b + '.' + this.f491915c;
    }

    public w(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f491913a = r100;
        this.f491914b = r101;
        this.f491915c = r102;
    }
}
