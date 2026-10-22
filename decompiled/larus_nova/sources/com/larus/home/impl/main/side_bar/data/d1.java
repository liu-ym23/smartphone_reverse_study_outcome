package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f344491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f344492c;

    /* JADX WARN: Multi-variable type inference failed */
    public d1() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (Intrinsics.areEqual(this.f344490a, r101.f344490a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344491b, r101.f344491b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f344492c, r101.f344492c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f344490a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f344491b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f344492c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SideBarTabInfo(tabName=" + this.f344490a + ", tabPosition=" + this.f344491b + ", maxCount=" + this.f344492c + ')';
    }

    public /* synthetic */ d1(String r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null);
    }

    public d1(String r100, Integer r101, Integer r102) {
        this.f344490a = r100;
        this.f344491b = r101;
        this.f344492c = r102;
    }
}
