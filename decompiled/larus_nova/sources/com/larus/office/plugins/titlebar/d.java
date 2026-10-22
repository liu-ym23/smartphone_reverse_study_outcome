package com.larus.office.plugins.titlebar;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f363506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f363507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f363508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f363509d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f363506a == r101.f363506a) goto L12;
        return false;
    L12:
        if (this.f363507b == r101.f363507b) goto L15;
        return false;
    L15:
        if (this.f363508c == r101.f363508c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f363509d, r101.f363509d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f363506a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f363507b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f363508c == true) goto L15;
        r100 = 1237;
    L15:
        return ((r104 + r100) * 31) + this.f363509d.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ActionBarVisibilityState(titleBarVisible=" + this.f363506a + ", capsuleVisible=" + this.f363507b + ", customViewFullscreen=" + this.f363508c + ", fullscreenFragments=" + this.f363509d + ')';
    }

    public /* synthetic */ d(int r100) {
        this(true, true, false, SetsKt.emptySet());
    }

    public d(boolean r100, boolean r101, boolean r102, Set<String> r103) {
        Intrinsics.checkNotNullParameter(r103, "fullscreenFragments");
        this.f363506a = r100;
        this.f363507b = r101;
        this.f363508c = r102;
        this.f363509d = r103;
    }

    public static d a(d r100, boolean r101, boolean r102, boolean r103, Set r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f363506a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f363507b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f363508c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f363509d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "fullscreenFragments");
        return new d(r101, r102, r103, r104);
    }
}
