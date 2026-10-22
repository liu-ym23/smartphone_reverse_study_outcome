package com.larus.home.impl.main.side_bar.view.group.render;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f345674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eb9.e f345675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f345676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f345677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s0 f345678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GroupSortPolicy f345679f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f345674a == r101.f345674a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345675b, r101.f345675b) == true) goto L15;
        return false;
    L15:
        if (this.f345676c == r101.f345676c) goto L18;
        return false;
    L18:
        if (this.f345677d == r101.f345677d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f345678e, r101.f345678e) == true) goto L24;
        return false;
    L24:
        if (this.f345679f == r101.f345679f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f345674a * 31) + this.f345675b.hashCode()) * 31;
        if (this.f345676c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f345677d) * 31;
        s0 r103 = this.f345678e;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((r102 + r104) * 31) + this.f345679f.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DateHeaderItem(bucketIndex=" + this.f345674a + ", title=" + this.f345675b + ", isExpanded=" + this.f345676c + ", unreadCount=" + this.f345677d + ", archiveRange=" + this.f345678e + ", sortPolicy=" + this.f345679f + ')';
    }

    public final String a() {
        int r100 = r0.f345708a;
        int r101 = this.f345674a;
        if (r101 != 0) goto L5;
        return "time_today";
    L5:
        if (r101 != 1) goto L7;
        return "time_yesterday";
    L7:
        if (r101 != 7) goto L13;
        return "time_earlier";
    L13:
        return "time_day_" + r101;
    }

    public l(int r100, eb9.e r101, boolean r102, int r103, s0 r104, GroupSortPolicy r105) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r105, "sortPolicy");
        this.f345674a = r100;
        this.f345675b = r101;
        this.f345676c = r102;
        this.f345677d = r103;
        this.f345678e = r104;
        this.f345679f = r105;
    }
}
