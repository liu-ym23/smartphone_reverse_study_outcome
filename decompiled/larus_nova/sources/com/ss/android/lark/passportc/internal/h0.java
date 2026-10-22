package com.ss.android.lark.passportc.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0c.h f438468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0c.h f438469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e0> f438470c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f438468a, r101.f438468a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f438469b, r101.f438469b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f438470c, r101.f438470c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f438468a.hashCode() * 31) + this.f438469b.hashCode()) * 31) + this.f438470c.hashCode();
    }

    public final String toString() {
        return "UserNotifyData(prev=" + this.f438468a + ", current=" + this.f438469b + ", toBeNotified=" + this.f438470c + ')';
    }

    public h0(f0c.h r100, f0c.h r101, List<e0> r102) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, "toBeNotified");
        this.f438468a = r100;
        this.f438469b = r101;
        this.f438470c = r102;
    }
}
