package com.larus.community.impl.component;

/* JADX INFO: loaded from: classes27.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f328973a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L9;
        return false;
    L9:
        if (this.f328973a == ((p1) r100).f328973a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f328973a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "InvokeEvent(uniqueId=" + this.f328973a + ')';
    }

    public p1(long r100) {
        this.f328973a = r100;
    }
}
