package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f441691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f441692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f441693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f441694d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f441691a, r101.f441691a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441692b, r101.f441692b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f441693c, r101.f441693c) == true) goto L18;
        return false;
    L18:
        if (this.f441694d == r101.f441694d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f441691a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.f441692b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f441693c.hashCode()) * 31;
        if (this.f441694d == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerDisplayData(ownerItem=" + this.f441691a + ", followerItem=" + this.f441692b + ", list=" + this.f441693c + ", hasMore=" + this.f441694d + ')';
    }

    public b(c r100, c r101, List<c> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "list");
        this.f441691a = r100;
        this.f441692b = r101;
        this.f441693c = r102;
        this.f441694d = r103;
    }
}
