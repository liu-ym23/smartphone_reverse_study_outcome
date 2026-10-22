package com.larus.dora.impl.alive;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f332008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f332009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<j> f332010c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f332008a, r101.f332008a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f332009b, r101.f332009b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f332010c, r101.f332010c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f332008a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f332009b.hashCode()) * 31) + this.f332010c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraKeepAliveEntry(manufacturer=" + this.f332008a + ", lockAppItems=" + this.f332009b + ", autoStartItems=" + this.f332010c + ')';
    }

    public i(String r100, List<j> r101, List<j> r102) {
        Intrinsics.checkNotNullParameter(r101, "lockAppItems");
        Intrinsics.checkNotNullParameter(r102, "autoStartItems");
        this.f332008a = r100;
        this.f332009b = r101;
        this.f332010c = r102;
    }
}
