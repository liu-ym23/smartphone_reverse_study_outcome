package com.larus.bmhome.double_post.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f311629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f311630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f311631c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f311629a == r101.f311629a) goto L12;
        return false;
    L12:
        if (this.f311630b == r101.f311630b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f311631c, r101.f311631c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f311629a * 31) + this.f311630b) * 31) + this.f311631c.hashCode();
    }

    public final String toString() {
        return "AwemeRecommendFeedbackData(itemId=" + this.f311629a + ", itemIcon=" + this.f311630b + ", itemText=" + this.f311631c + ')';
    }

    public i(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "itemText");
        this.f311629a = r100;
        this.f311630b = r101;
        this.f311631c = r102;
    }
}
