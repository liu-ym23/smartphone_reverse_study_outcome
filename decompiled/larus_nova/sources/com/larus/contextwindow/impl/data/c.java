package com.larus.contextwindow.impl.data;

import com.larus.contextwindow.api.ContextWindowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContextWindowMode f330319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f330320b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f330319a == r101.f330319a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330320b, r101.f330320b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330319a.hashCode() * 31;
        Long r101 = this.f330320b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ContextWindowModelContext(mode=" + this.f330319a + ", currentModelTotal=" + this.f330320b + ')';
    }

    public c(ContextWindowMode r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f330319a = r100;
        this.f330320b = r101;
    }
}
