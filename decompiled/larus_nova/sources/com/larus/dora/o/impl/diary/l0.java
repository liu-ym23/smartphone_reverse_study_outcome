package com.larus.dora.o.impl.diary;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f338558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f338559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f338560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f338561d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (this.f338558a == r101.f338558a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f338559b, r101.f338559b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f338560c, r101.f338560c) == true) goto L18;
        return false;
    L18:
        if (this.f338561d == r101.f338561d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f338558a * 31) + this.f338559b.hashCode()) * 31) + this.f338560c.hashCode()) * 31) + this.f338561d;
    }

    public final String toString() {
        return "ODiaryFeedbackTarget(targetType=" + this.f338558a + ", targetId=" + this.f338559b + ", snapshotJson=" + this.f338560c + ", diaryVersion=" + this.f338561d + ')';
    }

    public l0(int r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "targetId");
        Intrinsics.checkNotNullParameter(r102, "snapshotJson");
        this.f338558a = r100;
        this.f338559b = r101;
        this.f338560c = r102;
        this.f338561d = r103;
    }
}
