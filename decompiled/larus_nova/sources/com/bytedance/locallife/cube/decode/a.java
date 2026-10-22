package com.bytedance.locallife.cube.decode;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f257196b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f257195a, r101.f257195a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257196b, r101.f257196b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f257195a.hashCode() * 31) + this.f257196b.hashCode();
    }

    public final String toString() {
        return "DynamicComponentDecodeRequest(scene=" + this.f257195a + ", url=" + this.f257196b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f257195a = r100;
        this.f257196b = r101;
    }
}
