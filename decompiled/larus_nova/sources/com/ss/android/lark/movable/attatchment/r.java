package com.ss.android.lark.movable.attatchment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f432651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f432652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f432653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f432654d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f432651a, r101.f432651a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f432652b, r101.f432652b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f432653c, r101.f432653c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f432654d, r101.f432654d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f432651a.hashCode() * 31) + this.f432652b.hashCode()) * 31) + Float.floatToIntBits(this.f432653c)) * 31) + Float.floatToIntBits(this.f432654d);
    }

    public final String toString() {
        return "PhotoWithSize(key=" + this.f432651a + ", type=" + this.f432652b + ", width=" + this.f432653c + ", height=" + this.f432654d + ')';
    }

    public final String getType() {
        return this.f432652b;
    }

    public r(String r100, String r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f432651a = r100;
        this.f432652b = r101;
        this.f432653c = r102;
        this.f432654d = r103;
    }
}
