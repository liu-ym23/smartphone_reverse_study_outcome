package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443852a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443852a, ((c) r100).f443852a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f443852a.hashCode();
    }

    public final String toString() {
        return "DatetimeFieldValue(text=" + this.f443852a + ')';
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f443852a = r100;
    }
}
