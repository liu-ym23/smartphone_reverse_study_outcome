package com.larus.community.impl.component;

/* JADX INFO: loaded from: classes27.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f328977a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q1) == true) goto L9;
        return false;
    L9:
        if (this.f328977a == ((q1) r100).f328977a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f328977a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "InvokeNotifyEvent(uniqueId=" + this.f328977a + ')';
    }

    public q1(long r100) {
        this.f328977a = r100;
    }
}
