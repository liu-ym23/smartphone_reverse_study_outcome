package com.larus.kmp.voice_setting.voice.component;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements t1a.f, m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f352449a;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (this.f352449a == ((p) r100).f352449a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f352449a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoubleTabRootShellUiState(visible=" + this.f352449a + ')';
    }

    public p(int r100) {
        this.f352449a = true;
    }
}
