package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443816b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f443815a, r101.f443815a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443816b, r101.f443816b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f443815a.hashCode() * 31) + this.f443816b.hashCode();
    }

    public final String toString() {
        return "TitleNumber(numberId=" + this.f443815a + ", url=" + this.f443816b + ')';
    }

    public b0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "numberId");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f443815a = r100;
        this.f443816b = r101;
    }
}
