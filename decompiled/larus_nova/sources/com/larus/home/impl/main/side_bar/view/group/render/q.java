package com.larus.home.impl.main.side_bar.view.group.render;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f345702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<ITEM> f345703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zb9.l<ITEM> f345704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Map<String, Object>> f345705d;

    public q() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f345702a, r101.f345702a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345703b, r101.f345703b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f345704c, r101.f345704c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f345705d, r101.f345705d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f345702a.hashCode() * 31) + this.f345703b.hashCode()) * 31) + this.f345704c.hashCode()) * 31) + this.f345705d.hashCode();
    }

    public final String toString() {
        return "GroupContentConfig(pagingConfig=" + this.f345702a + ", displayPolicy=" + this.f345703b + ", mergePolicy=" + this.f345704c + ", loadRequestExtProvider=" + this.f345705d + ')';
    }

    public q(z r100, n r101, zb9.l r102) {
        Function0<Map<String, Object>> r103 = new p();
        Intrinsics.checkNotNullParameter(r100, "pagingConfig");
        Intrinsics.checkNotNullParameter(r101, "displayPolicy");
        Intrinsics.checkNotNullParameter(r102, "mergePolicy");
        Intrinsics.checkNotNullParameter(r103, "loadRequestExtProvider");
        this.f345702a = r100;
        this.f345703b = r101;
        this.f345704c = r102;
        this.f345705d = r103;
    }
}
