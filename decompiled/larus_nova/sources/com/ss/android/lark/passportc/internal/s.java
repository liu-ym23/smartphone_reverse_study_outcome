package com.ss.android.lark.passportc.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0c.b f438481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0c.b f438482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f438483c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f438481a, r101.f438481a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f438482b, r101.f438482b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f438483c, r101.f438483c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f438481a.hashCode() * 31) + this.f438482b.hashCode()) * 31) + this.f438483c.hashCode();
    }

    public final String toString() {
        return "NotifyData(prev=" + this.f438481a + ", current=" + this.f438482b + ", toBeNotified=" + this.f438483c + ')';
    }

    public s(f0c.b r100, f0c.b r101, List<h> r102) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, "toBeNotified");
        this.f438481a = r100;
        this.f438482b = r101;
        this.f438483c = r102;
    }
}
