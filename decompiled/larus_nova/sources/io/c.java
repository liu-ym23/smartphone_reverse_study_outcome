package io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f490654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f490655d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f490652a, r101.f490652a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f490653b, r101.f490653b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f490654c, r101.f490654c) == true) goto L12;
        return false;
    L12:
        if (this.f490655d == r101.f490655d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f490652a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f490653b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f490654c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f490655d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowExitInterceptorEntity(userId=" + this.f490652a + ", secAuthorId=" + this.f490653b + ", componentName=" + this.f490654c + ", showTime=" + this.f490655d + ")";
    }

    public c(String r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "secAuthorId");
        Intrinsics.checkNotNullParameter(r102, "componentName");
        this.f490652a = r100;
        this.f490653b = r101;
        this.f490654c = r102;
        this.f490655d = r103;
    }
}
