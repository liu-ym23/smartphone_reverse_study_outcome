package com.larus.paging;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f363857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f363858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f363859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f363860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f363861e;

    public final int hashCode() {
        int r100 = ((((((this.f363857a.hashCode() * 31) + this.f363858b.hashCode()) * 31) + this.f363859c.hashCode()) * 31) + this.f363860d.hashCode()) * 31;
        v r101 = this.f363861e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "CombinedLoadStates(refresh=" + this.f363857a + ", prepend=" + this.f363858b + ", append=" + this.f363859c + ", source=" + this.f363860d + ", mediator=" + this.f363861e + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(i.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.paging.CombinedLoadStates");
        i r102 = (i) r100;
        if (Intrinsics.areEqual(this.f363857a, r102.f363857a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f363858b, r102.f363858b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f363859c, r102.f363859c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f363860d, r102.f363860d) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.f363861e, r102.f363861e) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public i(u r100, u r101, u r102, v r103, v r104) {
        Intrinsics.checkNotNullParameter(r100, "refresh");
        Intrinsics.checkNotNullParameter(r101, "prepend");
        Intrinsics.checkNotNullParameter(r102, "append");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.f363857a = r100;
        this.f363858b = r101;
        this.f363859c = r102;
        this.f363860d = r103;
        this.f363861e = r104;
    }
}
