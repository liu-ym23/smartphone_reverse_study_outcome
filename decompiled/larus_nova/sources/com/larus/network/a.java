package com.larus.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f360099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f360100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f360101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f360102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f360103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f360104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f360105g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f360099a, r101.f360099a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f360100b, r101.f360100b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f360101c, r101.f360101c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f360102d, r101.f360102d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f360103e, r101.f360103e) == true) goto L24;
        return false;
    L24:
        if (this.f360104f == r101.f360104f) goto L27;
        return false;
    L27:
        if (this.f360105g == r101.f360105g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f360099a.hashCode() * 31) + this.f360100b.hashCode()) * 31;
        String r101 = this.f360101c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f360102d.hashCode()) * 31) + this.f360103e.hashCode()) * 31;
        if (this.f360104f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        long r106 = this.f360105g;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccessControlAction(code=" + this.f360099a + ", rawActions=" + this.f360100b + ", logId=" + this.f360101c + ", host=" + this.f360102d + ", path=" + this.f360103e + ", isPendingAction=" + this.f360104f + ", timestampMs=" + this.f360105g + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, boolean r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "rawActions");
        Intrinsics.checkNotNullParameter(r103, "host");
        Intrinsics.checkNotNullParameter(r104, "path");
        this.f360099a = r100;
        this.f360100b = r101;
        this.f360101c = r102;
        this.f360102d = r103;
        this.f360103e = r104;
        this.f360104f = r105;
        this.f360105g = r106;
    }
}
