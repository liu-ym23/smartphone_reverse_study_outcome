package com.bytedance.ug.sdk.luckydog.base.pagerelease;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f271790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f271791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f271792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f271793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f271794e;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L30:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L29;
        a r101 = (a) r100;
        if (this.f271790a != r101.f271790a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L29;
        if (this.f271791b != r101.f271791b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L29;
        if (this.f271792c != r101.f271792c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L29;
        if (this.f271793d != r101.f271793d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L29;
        if (Intrinsics.areEqual(this.f271794e, r101.f271794e) == false) goto L29;
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L29:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.f271790a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f271791b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f271792c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f271793d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.f271794e;
        if (r108 == null) goto L8;
        int r109 = r108.hashCode();
    L10:
        return r107 + r109;
    L8:
        r109 = 0;
        goto L10
    }

    public final String toString() {
        return "CheckReleaseResult(needRelease=" + this.f271790a + ", javaFreeMemorySize=" + this.f271791b + ", physicsFreeMemorySize=" + this.f271792c + ", virtualFreeMemorySize=" + this.f271793d + ", releaseReason=" + this.f271794e + ")";
    }

    public a(int r100) {
        this.f271790a = false;
        this.f271791b = -1;
        this.f271792c = -1;
        this.f271793d = -1;
        this.f271794e = "";
    }
}
