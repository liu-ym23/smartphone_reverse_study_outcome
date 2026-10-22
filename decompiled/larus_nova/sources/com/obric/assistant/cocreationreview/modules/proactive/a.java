package com.obric.assistant.cocreationreview.modules.proactive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f387466b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f387465a, r101.f387465a) == true) goto L12;
        return false;
    L12:
        if (this.f387466b == r101.f387466b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f387465a.hashCode() * 31;
        if (this.f387466b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProactiveAgentAction(title=" + this.f387465a + ", executed=" + this.f387466b + ')';
    }

    public a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f387465a = r100;
        this.f387466b = r101;
    }
}
