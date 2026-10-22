package com.larus.kmp.voice_setting.voice.screen.doubletab;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354316a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (this.f354316a == ((g) r100).f354316a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f354316a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DoubleTabCollapseTransition(isVisuallyCollapsed=" + this.f354316a + ')';
    }

    public g(boolean r100) {
        this.f354316a = r100;
    }
}
