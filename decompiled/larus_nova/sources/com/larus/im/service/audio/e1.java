package com.larus.im.service.audio;

/* JADX INFO: loaded from: classes30.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f350739a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L9;
        return false;
    L9:
        if (this.f350739a == ((e1) r100).f350739a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f350739a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ScreenShareCloseConfig(needCheckToCallMode=" + this.f350739a + ')';
    }

    public e1(boolean r100) {
        this.f350739a = r100;
    }
}
