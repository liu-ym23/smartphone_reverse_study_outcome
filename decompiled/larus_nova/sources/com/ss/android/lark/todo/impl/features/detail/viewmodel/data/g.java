package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443857a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443857a, ((g) r100).f443857a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f443857a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "NumberFieldValue(text=" + this.f443857a + ')';
    }

    public g(String r100) {
        this.f443857a = r100;
    }
}
