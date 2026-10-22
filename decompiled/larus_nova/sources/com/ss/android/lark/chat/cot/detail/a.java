package com.ss.android.lark.chat.cot.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.c f414849a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f414849a, ((a) r100).f414849a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        com.ss.android.lark.chat.cot.c r100 = this.f414849a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CotActionDetailExtra(iconSpec=" + this.f414849a + ')';
    }

    public a(com.ss.android.lark.chat.cot.c r100) {
        this.f414849a = r100;
    }
}
