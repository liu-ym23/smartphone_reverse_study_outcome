package com.ss.android.token;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f449740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f449741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f449742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<o> f449743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<o> f449744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f449745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f449746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f449747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f449748i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L38:
        return true;
    L5:
        if ((r100 instanceof g) == false) goto L37;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f449740a, r101.f449740a) == false) goto L37;
        if (Intrinsics.areEqual(this.f449741b, r101.f449741b) == false) goto L37;
        if (this.f449742c != r101.f449742c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L37;
        if (Intrinsics.areEqual(this.f449743d, r101.f449743d) == false) goto L37;
        if (Intrinsics.areEqual(this.f449744e, r101.f449744e) == false) goto L37;
        if (this.f449745f != r101.f449745f) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L37;
        if (this.f449746g != r101.f449746g) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L37;
        if (Intrinsics.areEqual(this.f449747h, r101.f449747h) == false) goto L37;
        if (this.f449748i != r101.f449748i) goto L34;
        boolean r105 = true;
    L35:
        if (r105 == false) goto L37;
    L34:
        r105 = false;
        goto L35
    L27:
        r104 = false;
        goto L28
    L22:
        r103 = false;
        goto L23
    L13:
        r102 = false;
    L37:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        String r100 = this.f449740a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f449741b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f449742c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        List<o> r109 = this.f449743d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        List<o> r112 = this.f449744e;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        boolean r115 = this.f449745f;
        ?? r116 = 1;
        ?? r117 = r115;
        if (r115 == false) goto L21;
        r117 = 1;
    L21:
        int r118 = (((r114 + r117) * 31) + this.f449746g) * 31;
        Object r119 = this.f449747h;
        if (r119 == null) goto L24;
        r101 = r119.hashCode();
    L24:
        int r120 = (r118 + r101) * 31;
        boolean r121 = this.f449748i;
        if (r121 == true) goto L29;
        r116 = r121;
    L29:
        return r120 + r116;
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResponseData(url=" + this.f449740a + ", path=" + this.f449741b + ", requestStartTime=" + this.f449742c + ", originalRequestHeaders=" + this.f449743d + ", responseHeaders=" + this.f449744e + ", isSuccess=" + this.f449745f + ", responseCode=" + this.f449746g + ", body=" + this.f449747h + ", isMainProcess=" + this.f449748i + ")";
    }

    public g(String r100, String r101, long r102, List<o> r103, List<o> r104, boolean r105, int r106, Object r107, boolean r110) {
        this.f449740a = r100;
        this.f449741b = r101;
        this.f449742c = r102;
        this.f449743d = r103;
        this.f449744e = r104;
        this.f449745f = r105;
        this.f449746g = r106;
        this.f449747h = r107;
        this.f449748i = r110;
    }
}
