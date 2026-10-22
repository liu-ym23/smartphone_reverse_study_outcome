package com.larus.chat.job.impl.page.edit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f325275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f325276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f325277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f325278d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f325275a == r101.f325275a) goto L12;
        return false;
    L12:
        if (this.f325276b == r101.f325276b) goto L15;
        return false;
    L15:
        if (this.f325277c == r101.f325277c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325278d, r101.f325278d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f325275a * 31) + this.f325276b) * 31) + this.f325277c) * 31) + this.f325278d.hashCode();
    }

    public final String toString() {
        return "ChatJobEditDate(year=" + this.f325275a + ", month=" + this.f325276b + ", dayOfMonth=" + this.f325277c + ", weekdayLabel=" + this.f325278d + ')';
    }

    public h(int r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "weekdayLabel");
        this.f325275a = r100;
        this.f325276b = r101;
        this.f325277c = r102;
        this.f325278d = r103;
    }
}
