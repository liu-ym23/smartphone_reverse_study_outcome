package com.larus.voicecall.impl.video;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f379584a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f379584a, ((b) r100).f379584a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f379584a.hashCode();
    }

    public final String toString() {
        return "BrushPath(dotList=" + this.f379584a + ')';
    }

    public b(Object r100) {
        ArrayList r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "dotList");
        this.f379584a = r101;
    }
}
