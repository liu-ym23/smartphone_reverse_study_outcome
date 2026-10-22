package com.larus.kmp.voice_setting.voice.screen.doubletab;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements t1a.f, m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354341a;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (this.f354341a == ((h) r100).f354341a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f354341a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoubleTabCollapsedMixBarUiState(visible=" + this.f354341a + ')';
    }

    public h(int r100) {
        this.f354341a = true;
    }
}
