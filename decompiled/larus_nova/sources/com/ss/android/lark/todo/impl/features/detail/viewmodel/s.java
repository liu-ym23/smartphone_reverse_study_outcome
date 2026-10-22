package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443894b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f443893a, r101.f443893a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443894b, r101.f443894b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f443893a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f443894b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewAttachment(fileToken=" + this.f443893a + ", name=" + this.f443894b + ')';
    }

    public s(String r100, String r101) {
        this.f443893a = r100;
        this.f443894b = r101;
    }
}
