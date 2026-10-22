package com.bytedance.ee.bear.widgets.menuconfig;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f240250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f240251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f240252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g> f240253d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f240250a, r101.f240250a) == true) goto L12;
        return false;
    L12:
        if (this.f240251b == r101.f240251b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f240252c, r101.f240252c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f240253d, r101.f240253d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f240250a.hashCode() * 31;
        if (this.f240251b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f240252c.hashCode()) * 31) + this.f240253d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeSpaceMenuDefinition(key=" + this.f240250a + ", enabled=" + this.f240251b + ", groups=" + this.f240252c + ", items=" + this.f240253d + ')';
    }

    public e(String r100, boolean r101, List<f> r102, List<g> r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "groups");
        Intrinsics.checkNotNullParameter(r103, "items");
        this.f240250a = r100;
        this.f240251b = r101;
        this.f240252c = r102;
        this.f240253d = r103;
    }
}
