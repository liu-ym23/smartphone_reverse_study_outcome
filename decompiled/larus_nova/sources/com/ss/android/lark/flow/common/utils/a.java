package com.ss.android.lark.flow.common.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowTagType f423192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f423193b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f423192a == r101.f423192a) goto L12;
        return false;
    L12:
        if (this.f423193b == r101.f423193b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f423192a.hashCode() * 31) + this.f423193b;
    }

    public final String toString() {
        return "FlowTagCandidate(type=" + this.f423192a + ", sequence=" + this.f423193b + ')';
    }

    public final FlowTagType getType() {
        return this.f423192a;
    }

    public a(FlowTagType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f423192a = r100;
        this.f423193b = r101;
    }
}
