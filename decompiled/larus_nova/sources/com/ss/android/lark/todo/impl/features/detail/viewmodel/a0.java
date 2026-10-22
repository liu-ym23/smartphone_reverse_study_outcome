package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f443805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f443807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f443808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f443809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f443810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f443811g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f443805a == r101.f443805a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443806b, r101.f443806b) == true) goto L15;
        return false;
    L15:
        if (this.f443807c == r101.f443807c) goto L18;
        return false;
    L18:
        if (this.f443808d == r101.f443808d) goto L21;
        return false;
    L21:
        if (this.f443809e == r101.f443809e) goto L24;
        return false;
    L24:
        if (this.f443810f == r101.f443810f) goto L27;
        return false;
    L27:
        if (this.f443811g == r101.f443811g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f443805a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f443806b.hashCode()) * 31) + this.f443807c) * 31;
        if (this.f443808d == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f443809e == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f443810f) * 31;
        if (this.f443811g == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TimeInfo(hasDueTime=" + this.f443805a + ", timeStr=" + this.f443806b + ", timeColor=" + this.f443807c + ", hasReminder=" + this.f443808d + ", showDelete=" + this.f443809e + ", editState=" + this.f443810f + ", isRepeat=" + this.f443811g + ')';
    }

    public a0(boolean r100, String r101, int r102, boolean r103, boolean r104, int r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "timeStr");
        this.f443805a = r100;
        this.f443806b = r101;
        this.f443807c = r102;
        this.f443808d = r103;
        this.f443809e = r104;
        this.f443810f = r105;
        this.f443811g = r106;
    }
}
