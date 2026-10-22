package com.larus.bmhome.taskskill.service;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f314449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f314450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f314451c;

    public i() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f314449a, r101.f314449a) == true) goto L12;
        return false;
    L12:
        if (this.f314450b == r101.f314450b) goto L15;
        return false;
    L15:
        if (this.f314451c == r101.f314451c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f314449a.hashCode() * 31;
        int r101 = 1231;
        if (this.f314450b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f314451c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProjectListSnapshot(items=" + this.f314449a + ", hasMore=" + this.f314450b + ", isInitialized=" + this.f314451c + ')';
    }

    public /* synthetic */ i(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        List r102 = CollectionsKt.emptyList();
    L7:
        if ((r101 & 2) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r101 & 4) == 0) goto L13;
        r100 = false;
    L13:
        this(r102, r103, r100);
        return;
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = null;
        goto L7
    }

    public static i a(i r100, List r101) {
        boolean r102 = r100.f314450b;
        boolean r103 = r100.f314451c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "items");
        return new i(r101, r102, r103);
    }

    public i(List<h> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f314449a = r100;
        this.f314450b = r101;
        this.f314451c = r102;
    }
}
