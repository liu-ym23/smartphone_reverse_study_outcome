package com.bytedance.ee.bear.widgets.menuconfig;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f240246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f240247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f240248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, e> f240249d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f240246a == r101.f240246a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f240247b, r101.f240247b) == true) goto L15;
        return false;
    L15:
        if (this.f240248c == r101.f240248c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f240249d, r101.f240249d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f240246a * 31) + this.f240247b.hashCode()) * 31) + this.f240248c) * 31) + this.f240249d.hashCode();
    }

    public final String toString() {
        return "OfficeSpaceMenuConfigSnapshot(schemaVersion=" + this.f240246a + ", configVersion=" + this.f240247b + ", runtimeIdHash=" + this.f240248c + ", menus=" + this.f240249d + ')';
    }

    public final e a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f240249d.get(r100);
    }

    public d(int r100, String r101, int r102, Map<String, e> r103) {
        Intrinsics.checkNotNullParameter(r101, "configVersion");
        Intrinsics.checkNotNullParameter(r103, "menus");
        this.f240246a = r100;
        this.f240247b = r101;
        this.f240248c = r102;
        this.f240249d = r103;
    }
}
