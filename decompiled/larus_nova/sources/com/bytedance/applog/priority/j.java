package com.bytedance.applog.priority;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f192628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f192629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f192630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f192631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f192632f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f192627a, r101.f192627a) == true) goto L12;
        return false;
    L12:
        if (this.f192628b == r101.f192628b) goto L15;
        return false;
    L15:
        if (this.f192629c == r101.f192629c) goto L18;
        return false;
    L18:
        if (this.f192630d == r101.f192630d) goto L21;
        return false;
    L21:
        if (this.f192631e == r101.f192631e) goto L24;
        return false;
    L24:
        if (this.f192632f == r101.f192632f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f192627a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f192628b;
        int r103 = ((((((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f192629c) * 31) + this.f192630d) * 31) + this.f192631e) * 31;
        long r104 = this.f192632f;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PriorityUser(uuid=" + this.f192627a + ", userId=" + this.f192628b + ", userIsLogin=" + this.f192629c + ", userIsAuth=" + this.f192630d + ", userType=" + this.f192631e + ", uid=" + this.f192632f + ')';
    }

    public j(String r100, long r101, int r102, int r103, int r104, long r105) {
        this.f192627a = r100;
        this.f192628b = r101;
        this.f192629c = r102;
        this.f192630d = r103;
        this.f192631e = r104;
        this.f192632f = r105;
    }
}
