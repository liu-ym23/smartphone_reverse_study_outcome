package com.ss.android.lark.chat.base.model.dispatch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreprocessParams f411776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f411777b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f411776a, r101.f411776a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f411777b, r101.f411777b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f411776a.hashCode() * 31) + this.f411777b.hashCode();
    }

    public final String toString() {
        return "{ " + this.f411776a + ", preprocessKey: " + this.f411777b + ", contextId: null }";
    }

    public g(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "preKey");
        this.f411776a = r100;
        this.f411777b = r101;
    }
}
