package com.larus.chat.job.impl.page;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f325402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f325403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f325404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f325405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f325406e;

    public y() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f325402a, r101.f325402a) == true) goto L12;
        return false;
    L12:
        if (this.f325403b == r101.f325403b) goto L15;
        return false;
    L15:
        if (this.f325404c == r101.f325404c) goto L18;
        return false;
    L18:
        if (this.f325405d == r101.f325405d) goto L21;
        return false;
    L21:
        if (this.f325406e == r101.f325406e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325402a.hashCode() * 31;
        int r101 = 1231;
        if (this.f325403b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f325404c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f325405d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f325406e == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatJobListUiState(items=" + this.f325402a + ", loading=" + this.f325403b + ", failure=" + this.f325404c + ", empty=" + this.f325405d + ", refreshing=" + this.f325406e + ')';
    }

    public /* synthetic */ y(int r100) {
        this(CollectionsKt.emptyList(), true, false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(List<? extends i> r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f325402a = r100;
        this.f325403b = r101;
        this.f325404c = r102;
        this.f325405d = r103;
        this.f325406e = r104;
    }
}
