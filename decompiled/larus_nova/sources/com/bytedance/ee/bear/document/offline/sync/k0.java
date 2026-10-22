package com.bytedance.ee.bear.document.offline.sync;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f220611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f220612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f220613c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f220611a, r101.f220611a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f220612b, r101.f220612b) == true) goto L15;
        return false;
    L15:
        if (this.f220613c == r101.f220613c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f220611a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f220612b.hashCode()) * 31) + this.f220613c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PreloadStrategyJSONObjParams(type=" + this.f220611a + ", data=" + this.f220612b + ", version=" + this.f220613c + ')';
    }

    public final String getType() {
        return this.f220611a;
    }

    public k0(String r100, r r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f220611a = r100;
        this.f220612b = r101;
        this.f220613c = 2;
    }
}
