package com.bytedance.forest.model;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f244348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f244349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f244350c;

    public final String toString() {
        return "GeckoModel(accessKey=" + this.f244348a + ", channel=" + this.f244349b + ", bundle=" + this.f244350c + ")";
    }

    public final boolean a() {
        if (StringsKt.isBlank(this.f244349b) == false) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.isBlank(this.f244350c) == true) goto L8;
        return false;
    }

    public final int hashCode() {
        return (((this.f244348a.hashCode() * 31) + this.f244349b.hashCode()) * 31) + this.f244350c.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if ((!Intrinsics.areEqual(this.f244348a, r101.f244348a)) == false) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(this.f244349b, r101.f244349b)) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(this.f244350c, r101.f244350c)) == false) goto L17;
        return false;
    L17:
        return true;
    }

    public j(String r100, String r101, String r102) {
        this.f244348a = r100;
        this.f244349b = r101;
        this.f244350c = r102;
    }
}
