package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f344488b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f344487a, r101.f344487a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344488b, r101.f344488b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f344487a.hashCode() * 31) + this.f344488b.hashCode();
    }

    public final String toString() {
        return "ConversationGroupConfigState(userId=" + this.f344487a + ", config=" + this.f344488b + ')';
    }

    public d(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f344487a = r100;
        this.f344488b = r101;
    }
}
