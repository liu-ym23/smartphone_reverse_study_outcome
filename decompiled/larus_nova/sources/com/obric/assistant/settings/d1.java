package com.obric.assistant.settings;

/* JADX INFO: loaded from: classes33.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f392019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f392020b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (this.f392019a == r101.f392019a) goto L12;
        return false;
    L12:
        if (this.f392020b == r101.f392020b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f392019a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f392020b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReferenceMemorySyncSnapshot(referenceMemory=" + this.f392019a + ", personalInfo=" + this.f392020b + ')';
    }

    public d1(boolean r100, boolean r101) {
        this.f392019a = r100;
        this.f392020b = r101;
    }
}
