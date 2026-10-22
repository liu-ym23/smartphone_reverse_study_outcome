package com.larus.dora.impl.device.settings.lab.headdown;

import h49.m;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f334785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f334786b;

    public i() {
        this(false, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f334785a, r101.f334785a) == true) goto L12;
        return false;
    L12:
        if (this.f334786b == r101.f334786b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f334785a.hashCode() * 31;
        if (this.f334786b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "HeadDownDetectionUiState(page=" + this.f334785a + ", isWearing=" + this.f334786b + ')';
    }

    public final boolean b() {
        a r100 = this.f334785a;
        if ((r100 instanceof a.c) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r100 instanceof a.d) == true) goto L14;
        if ((r100 instanceof a.C4232a) == true) goto L14;
        if ((r100 instanceof a.e) == true) goto L14;
        if ((r100 instanceof a.b) == true) goto L14;
        return false;
    }

    public /* synthetic */ i(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        a.c r102 = a.c.f334772a;
    L7:
        if ((r101 & 2) == 0) goto L9;
        CopyOnWriteArraySet<m> r103 = t69.g.f544683a;
        r100 = t69.g.b();
    L9:
        this(r102, r100);
        return;
    L5:
        r102 = null;
        goto L7
    }

    public i(a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        this.f334785a = r100;
        this.f334786b = r101;
    }

    public static i a(i r100, a r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f334785a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f334786b;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "page");
        return new i(r101, r102);
    }
}
