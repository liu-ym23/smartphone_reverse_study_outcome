package com.obric.assistant.view.listening;

/* JADX INFO: loaded from: classes33.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f394327a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (this.f394327a == ((i) r100).f394327a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f394327a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "ObricLocalListeningUiTarget(generation=" + this.f394327a + ')';
    }

    public i(long r100) {
        this.f394327a = r100;
    }
}
