package com.larus.voicecall.impl;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f377184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f377185b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f377184a == r101.f377184a) goto L12;
        return false;
    L12:
        if (this.f377185b == r101.f377185b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f377184a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f377185b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DuplexControlState(muted=" + this.f377184a + ", paused=" + this.f377185b + ')';
    }

    public c(boolean r100, boolean r101) {
        this.f377184a = r100;
        this.f377185b = r101;
    }
}
