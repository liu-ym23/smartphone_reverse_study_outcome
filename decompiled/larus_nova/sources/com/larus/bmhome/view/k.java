package com.larus.bmhome.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f316992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f316993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f316994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f316995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f316996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<View, Unit> f316997f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f316992a, r101.f316992a) == true) goto L12;
        return false;
    L12:
        if (this.f316993b == r101.f316993b) goto L15;
        return false;
    L15:
        if (this.f316994c == r101.f316994c) goto L18;
        return false;
    L18:
        if (this.f316995d == r101.f316995d) goto L21;
        return false;
    L21:
        if (this.f316996e == r101.f316996e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f316997f, r101.f316997f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f316992a.hashCode() * 31) + this.f316993b) * 31) + this.f316994c) * 31;
        int r101 = 1231;
        if (this.f316995d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f316996e == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Function1<View, Unit> r105 = this.f316997f;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "BottomMenuItem(id=" + this.f316992a + ", iconRes=" + this.f316993b + ", nameRes=" + this.f316994c + ", enabled=" + this.f316995d + ", visible=" + this.f316996e + ", onClick=" + this.f316997f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String r100, int r101, int r102, boolean r103, boolean r104, Function1<? super View, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f316992a = r100;
        this.f316993b = r101;
        this.f316994c = r102;
        this.f316995d = r103;
        this.f316996e = r104;
        this.f316997f = r105;
    }
}
