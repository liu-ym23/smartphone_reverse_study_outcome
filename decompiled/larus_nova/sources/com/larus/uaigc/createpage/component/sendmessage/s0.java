package com.larus.uaigc.createpage.component.sendmessage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s0 f372420c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationPendingResourceInputType f372421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f372422b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (this.f372421a == r101.f372421a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f372422b, r101.f372422b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f372421a.hashCode() * 31) + this.f372422b.hashCode();
    }

    public final String toString() {
        return "CreationPendingResourceInput(type=" + this.f372421a + ", value=" + this.f372422b + ')';
    }

    static {
        f372420c = new s0(CreationPendingResourceInputType.INVALID, "");
    }

    public final CreationPendingResourceInputType getType() {
        return this.f372421a;
    }

    public s0(CreationPendingResourceInputType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f372421a = r100;
        this.f372422b = r101;
    }
}
