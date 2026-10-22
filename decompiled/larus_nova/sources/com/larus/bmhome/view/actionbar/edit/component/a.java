package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f316254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f316255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f316256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f316257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f316258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f316259g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f316253a == r101.f316253a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316254b, r101.f316254b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316255c, r101.f316255c) == true) goto L18;
        return false;
    L18:
        if (this.f316256d == r101.f316256d) goto L21;
        return false;
    L21:
        if (this.f316257e == r101.f316257e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f316258f, r101.f316258f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f316259g, r101.f316259g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316253a * 31;
        String r101 = this.f316254b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f316255c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f316256d) * 31) + this.f316257e) * 31;
        Integer r108 = this.f316258f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f316259g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarOptionTagBadge(type=" + this.f316253a + ", text=" + this.f316254b + ", iconUrl=" + this.f316255c + ", widthDp=" + this.f316256d + ", heightDp=" + this.f316257e + ", radiusDp=" + this.f316258f + ", backgroundColor=" + this.f316259g + ')';
    }

    public final int getType() {
        return this.f316253a;
    }

    public a(int r100, String r101, String r102, int r103, int r104, Integer r105, Integer r106) {
        this.f316253a = r100;
        this.f316254b = r101;
        this.f316255c = r102;
        this.f316256d = r103;
        this.f316257e = r104;
        this.f316258f = r105;
        this.f316259g = r106;
    }
}
