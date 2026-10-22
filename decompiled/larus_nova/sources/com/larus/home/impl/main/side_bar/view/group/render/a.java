package com.larus.home.impl.main.side_bar.view.group.render;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeZone f345602d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f345603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f345604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f345605c;

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.group.render.a$a, reason: collision with other inner class name */
    public static final class C4327a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f345603a == r101.f345603a) goto L12;
        return false;
    L12:
        if (this.f345604b == r101.f345604b) goto L15;
        return false;
    L15:
        if (this.f345605c == r101.f345605c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f345603a * 31) + this.f345604b) * 31) + this.f345605c;
    }

    public final String toString() {
        return "CalendarDay(year=" + this.f345603a + ", month=" + this.f345604b + ", dayOfMonth=" + this.f345605c + ')';
    }

    static {
        f345602d = TimeZone.getTimeZone("UTC");
    }

    public a(int r100, int r101, int r102) {
        this.f345603a = r100;
        this.f345604b = r101;
        this.f345605c = r102;
    }
}
