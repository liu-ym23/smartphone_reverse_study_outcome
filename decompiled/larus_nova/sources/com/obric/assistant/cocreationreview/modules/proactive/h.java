package com.obric.assistant.cocreationreview.modules.proactive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387481b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f387480a, r101.f387480a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387481b, r101.f387481b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f387480a.hashCode() * 31) + this.f387481b.hashCode();
    }

    public final String toString() {
        return "ProactiveAgentMeasure(name=" + this.f387480a + ", value=" + this.f387481b + ')';
    }

    public h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f387480a = r100;
        this.f387481b = r101;
    }
}
