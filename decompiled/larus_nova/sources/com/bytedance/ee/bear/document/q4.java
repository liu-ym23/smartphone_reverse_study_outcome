package com.bytedance.ee.bear.document;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f221237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f221238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f221239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f221240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f221241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f221242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f221243g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q4) == true) goto L8;
        return false;
    L8:
        q4 r101 = (q4) r100;
        if (Intrinsics.areEqual(this.f221237a, r101.f221237a) == true) goto L12;
        return false;
    L12:
        if (this.f221238b == r101.f221238b) goto L15;
        return false;
    L15:
        if (this.f221239c == r101.f221239c) goto L18;
        return false;
    L18:
        if (this.f221240d == r101.f221240d) goto L21;
        return false;
    L21:
        if (this.f221241e == r101.f221241e) goto L24;
        return false;
    L24:
        if (this.f221242f == r101.f221242f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f221243g, r101.f221243g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f221237a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f221238b) * 31;
        int r103 = 1231;
        if (this.f221239c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f221240d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f221241e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f221242f == true) goto L23;
        r103 = 1237;
    L23:
        return ((r109 + r103) * 31) + this.f221243g.hashCode();
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FetchDocObjInfoParams(objToken=" + this.f221237a + ", type=" + this.f221238b + ", pin=" + this.f221239c + ", star=" + this.f221240d + ", subscribe=" + this.f221241e + ", subscribeComment=" + this.f221242f + ", scene=" + this.f221243g + ')';
    }

    public final int getType() {
        return this.f221238b;
    }

    public q4(String r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r106, "scene");
        this.f221237a = r100;
        this.f221238b = r101;
        this.f221239c = r102;
        this.f221240d = r103;
        this.f221241e = r104;
        this.f221242f = r105;
        this.f221243g = r106;
    }
}
