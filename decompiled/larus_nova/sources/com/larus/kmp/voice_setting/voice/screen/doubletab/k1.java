package com.larus.kmp.voice_setting.voice.screen.doubletab;

/* JADX INFO: loaded from: classes4.dex */
public final class k1 implements t1a.f, m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354419a;

    public k1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k1) == true) goto L9;
        return false;
    L9:
        if (this.f354419a == ((k1) r100).f354419a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f354419a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoubleTabExpandedEditAreaUiState(visible=" + this.f354419a + ')';
    }

    public k1(int r100) {
        this.f354419a = true;
    }
}
