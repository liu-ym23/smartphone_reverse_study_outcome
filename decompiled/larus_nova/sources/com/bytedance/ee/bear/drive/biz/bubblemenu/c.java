package com.bytedance.ee.bear.drive.biz.bubblemenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f222605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f222606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f222607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Boolean> f222608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, Unit> f222609e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f222605a, r101.f222605a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f222606b, r101.f222606b) == true) goto L15;
        return false;
    L15:
        if (this.f222607c == r101.f222607c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f222608d, r101.f222608d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f222609e, r101.f222609e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f222605a.hashCode() * 31) + this.f222606b.hashCode()) * 31) + this.f222607c) * 31) + this.f222608d.hashCode()) * 31) + this.f222609e.hashCode();
    }

    public final String toString() {
        return "BubbleMenuItem(id='" + this.f222605a + "', text='" + this.f222606b + "', order=" + this.f222607c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, String r101, int r102, Function1<? super String, Boolean> r103, Function1<? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r103, "canShow");
        Intrinsics.checkNotNullParameter(r104, "callback");
        this.f222605a = r100;
        this.f222606b = r101;
        this.f222607c = r102;
        this.f222608d = r103;
        this.f222609e = r104;
    }
}
