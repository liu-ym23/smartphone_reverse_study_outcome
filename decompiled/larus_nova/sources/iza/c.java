package iza;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f496721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f496722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f496723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f496724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f496725f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f496720a, r101.f496720a) == true) goto L12;
        return false;
    L12:
        if (this.f496721b == r101.f496721b) goto L15;
        return false;
    L15:
        if (this.f496722c == r101.f496722c) goto L18;
        return false;
    L18:
        if (this.f496723d == r101.f496723d) goto L21;
        return false;
    L21:
        if (this.f496724e == r101.f496724e) goto L24;
        return false;
    L24:
        if (this.f496725f == r101.f496725f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f496720a.hashCode() * 31;
        long r101 = this.f496721b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f496722c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f496723d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        if (this.f496724e == false) goto L5;
        int r107 = 1231;
    L7:
        return ((r106 + r107) * 31) + this.f496725f;
    L5:
        r107 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeSidebarFeedMeta(id=" + this.f496720a + ", onTopRankTimeMillis=" + this.f496721b + ", rankTimeMillis=" + this.f496722c + ", contentVersion=" + this.f496723d + ", isRemoved=" + this.f496724e + ", badgeCount=" + this.f496725f + ')';
    }

    public static c a(c r110) {
        String r100 = r110.f496720a;
        long r101 = r110.f496721b;
        long r102 = r110.f496722c;
        long r103 = r110.f496723d;
        int r104 = r110.f496725f;
        Intrinsics.checkNotNullParameter(r100, "id");
        return new c(r100, r101, r102, r103, true, r104);
    }

    public c(String r100, long r101, long r102, long r103, boolean r104, int r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f496720a = r100;
        this.f496721b = r101;
        this.f496722c = r102;
        this.f496723d = r103;
        this.f496724e = r104;
        this.f496725f = r110;
    }
}
