package com.larus.camera.impl.ui.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f322671a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f322671a, ((p0) r100).f322671a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f322671a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ToResultPageConfig(clickFrom=" + this.f322671a + ')';
    }

    public p0(String r100) {
        this.f322671a = r100;
    }
}
