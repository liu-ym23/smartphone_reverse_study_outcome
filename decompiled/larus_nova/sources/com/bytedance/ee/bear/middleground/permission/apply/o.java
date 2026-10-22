package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f233047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Spanned f233048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f233050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f233051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f233052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f233053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f233054h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f233047a, r101.f233047a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f233048b, r101.f233048b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f233049c, r101.f233049c) == true) goto L18;
        return false;
    L18:
        if (this.f233050d == r101.f233050d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f233051e, r101.f233051e) == true) goto L24;
        return false;
    L24:
        if (this.f233052f == r101.f233052f) goto L27;
        return false;
    L27:
        if (this.f233053g == r101.f233053g) goto L30;
        return false;
    L30:
        if (this.f233054h == r101.f233054h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f233047a.hashCode() * 31) + this.f233048b.hashCode()) * 31) + this.f233049c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f233050d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f233051e.hashCode()) * 31) + this.f233052f) * 31;
        if (this.f233053g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f233054h == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ApplyPermissionPageState(title=" + this.f233047a + ", description=" + this.f233048b + ", ownerName=" + this.f233049c + ", showPermissionType=" + this.f233050d + ", permissionTypeText=" + this.f233051e + ", submitTextRes=" + this.f233052f + ", backVisible=" + this.f233053g + ", hideTitleBar=" + this.f233054h + ')';
    }

    public o(CharSequence r100, Spanned r101, String r102, boolean r103, String r104, int r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "ownerName");
        Intrinsics.checkNotNullParameter(r104, "permissionTypeText");
        this.f233047a = r100;
        this.f233048b = r101;
        this.f233049c = r102;
        this.f233050d = r103;
        this.f233051e = r104;
        this.f233052f = r105;
        this.f233053g = r106;
        this.f233054h = r107;
    }
}
