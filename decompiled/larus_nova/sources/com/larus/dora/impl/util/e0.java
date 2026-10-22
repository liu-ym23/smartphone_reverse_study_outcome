package com.larus.dora.impl.util;

/* JADX INFO: loaded from: classes27.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f338129a;

    public e0() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (this.f338129a == ((e0) r100).f338129a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f338129a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoraSoundAmbientVolumeUserConfig(hasUserModified=" + this.f338129a + ')';
    }

    public e0(boolean r100) {
        this.f338129a = r100;
    }
}
