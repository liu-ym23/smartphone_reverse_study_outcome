package com.larus.avlink.env.diary.calendar;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f291950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f291951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a.C3989a> f291952c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f291950a == r101.f291950a) goto L12;
        return false;
    L12:
        if (this.f291951b == r101.f291951b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291952c, r101.f291952c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f291950a * 31) + this.f291951b) * 31) + this.f291952c.hashCode();
    }

    public final String toString() {
        return "MonthCalendarData(year=" + this.f291950a + ", month=" + this.f291951b + ", days=" + this.f291952c + ')';
    }

    public static n a(n r100, List r101) {
        int r102 = r100.f291950a;
        int r103 = r100.f291951b;
        Intrinsics.checkNotNullParameter(r101, "days");
        return new n(r102, r103, r101);
    }

    public n(int r100, int r101, List<a.C3989a> r102) {
        Intrinsics.checkNotNullParameter(r102, "days");
        this.f291950a = r100;
        this.f291951b = r101;
        this.f291952c = r102;
    }
}
