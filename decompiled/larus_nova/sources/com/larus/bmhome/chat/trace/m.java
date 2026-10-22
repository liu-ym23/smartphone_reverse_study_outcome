package com.larus.bmhome.chat.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f310234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f310235b;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f310234a, r101.f310234a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310235b, r101.f310235b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f310234a.hashCode() * 31) + this.f310235b.hashCode();
    }

    public final String toString() {
        return "ChatControlTraceInfo(beforeEditMsg=" + this.f310234a + ", afterEditMsg=" + this.f310235b + ')';
    }

    public m(int r100) {
        Intrinsics.checkNotNullParameter("", "beforeEditMsg");
        Intrinsics.checkNotNullParameter("", "afterEditMsg");
        this.f310234a = "";
        this.f310235b = "";
    }
}
