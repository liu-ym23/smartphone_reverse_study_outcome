package com.larus.business.multitask_management.impl.component;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ll9.t;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<t> f320812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f320814c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f320812a, r101.f320812a) == true) goto L12;
        return false;
    L12:
        if (this.f320813b == r101.f320813b) goto L15;
        return false;
    L15:
        if (this.f320814c == r101.f320814c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f320812a.hashCode() * 31) + this.f320813b) * 31;
        if (this.f320814c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "QuickAccessListData(items=" + this.f320812a + ", foldThreshold=" + this.f320813b + ", hasMore=" + this.f320814c + ')';
    }

    public i(List<t> r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f320812a = r100;
        this.f320813b = r101;
        this.f320814c = r102;
    }

    public static i a(i r100, List r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f320812a;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f320813b;
    L9:
        if ((r103 & 4) == 0) goto L11;
        boolean r104 = r100.f320814c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "items");
        return new i(r101, r102, r104);
    L11:
        r104 = false;
        goto L12
    }
}
