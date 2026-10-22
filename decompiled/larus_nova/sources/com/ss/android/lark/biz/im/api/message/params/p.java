package com.ss.android.lark.biz.im.api.message.params;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f410374a;

    public p() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f410374a, ((p) r100).f410374a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f410374a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "MultiSelectBlockParam(unCheckedBorderColor=" + this.f410374a + ')';
    }

    public p(Integer r100) {
        this.f410374a = r100;
    }
}
