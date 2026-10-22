package com.ss.android.lark.biz.im.api.message.params;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class s implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f410378a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f410378a, ((s) r100).f410378a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f410378a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "NormalBubbleParam(bgColor=" + this.f410378a + ')';
    }

    public s() {
        this.f410378a = null;
    }
}
