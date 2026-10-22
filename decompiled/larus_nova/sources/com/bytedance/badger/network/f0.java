package com.bytedance.badger.network;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199100a;

    public f0() {
        this(false);
    }

    @Override // com.bytedance.badger.network.l0
    public final boolean a() {
        return this.f199100a;
    }

    public final int hashCode() {
        boolean r100 = this.f199100a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "FirstTry(isLastAttempt=" + this.f199100a + ")";
    }

    public f0(boolean r100) {
        this.f199100a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L13:
        return true;
    L5:
        if ((r100 instanceof f0) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.f199100a != ((f0) r100).f199100a) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L9:
        r101 = false;
        goto L10
    }
}
