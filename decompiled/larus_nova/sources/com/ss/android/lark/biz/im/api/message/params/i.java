package com.ss.android.lark.biz.im.api.message.params;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f410353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f410354b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f410353a, r101.f410353a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410354b, r101.f410354b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f410353a.hashCode() * 31) + this.f410354b.hashCode();
    }

    public final String toString() {
        return "MarkdownQuoteCellParam(textColorConfig=" + this.f410353a + ", barColorConfig=" + this.f410354b + ')';
    }

    public i(o r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "textColorConfig");
        Intrinsics.checkNotNullParameter(r101, "barColorConfig");
        this.f410353a = r100;
        this.f410354b = r101;
    }
}
