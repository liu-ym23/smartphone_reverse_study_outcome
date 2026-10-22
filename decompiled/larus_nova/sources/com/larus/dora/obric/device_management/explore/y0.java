package com.larus.dora.obric.device_management.explore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f339619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f339620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraObricGlassesExploreActionStateType f339621e;

    public y0() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f339617a, r101.f339617a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339618b, r101.f339618b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f339619c, r101.f339619c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f339620d, r101.f339620d) == true) goto L21;
        return false;
    L21:
        if (this.f339621e == r101.f339621e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f339617a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f339618b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f339619c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f339620d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DoraObricGlassesExploreActionStateType r113 = this.f339621e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricGlassesIntroductionButton(title=" + this.f339617a + ", enabledTitle=" + this.f339618b + ", url=" + this.f339619c + ", extras=" + this.f339620d + ", stateType=" + this.f339621e + ')';
    }

    public y0(String r100, String r101, String r102, Map<String, String> r103, DoraObricGlassesExploreActionStateType r104) {
        this.f339617a = r100;
        this.f339618b = r101;
        this.f339619c = r102;
        this.f339620d = r103;
        this.f339621e = r104;
    }
}
