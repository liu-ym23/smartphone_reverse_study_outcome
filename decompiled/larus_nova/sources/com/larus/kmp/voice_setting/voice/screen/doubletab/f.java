package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f354301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f354302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f354303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f354304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f354305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f354306f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f354301a, r101.f354301a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354302b, r101.f354302b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354303c, r101.f354303c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f354304d, r101.f354304d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f354305e, r101.f354305e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f354306f, r101.f354306f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f354301a.hashCode() * 31) + this.f354302b.hashCode()) * 31) + this.f354303c.hashCode()) * 31) + this.f354304d.hashCode()) * 31) + this.f354305e.hashCode()) * 31) + this.f354306f.hashCode();
    }

    public final String toString() {
        return "DoubleTabCollapseBridgeContext(expandedEditArea=" + this.f354301a + ", collapsedSingleBar=" + this.f354302b + ", collapsedMixBar=" + this.f354303c + ", callbacks=" + this.f354304d + ", onCollapseRequested=" + this.f354305e + ", onExpandRequested=" + this.f354306f + ')';
    }

    public f(k1 r100, i r101, h r102, h0 r103, Function0<Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "expandedEditArea");
        Intrinsics.checkNotNullParameter(r101, "collapsedSingleBar");
        Intrinsics.checkNotNullParameter(r102, "collapsedMixBar");
        Intrinsics.checkNotNullParameter(r103, "callbacks");
        Intrinsics.checkNotNullParameter(r104, "onCollapseRequested");
        Intrinsics.checkNotNullParameter(r105, "onExpandRequested");
        this.f354301a = r100;
        this.f354302b = r101;
        this.f354303c = r102;
        this.f354304d = r103;
        this.f354305e = r104;
        this.f354306f = r105;
    }
}
