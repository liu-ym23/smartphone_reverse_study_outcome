package com.larus.bot.impl.feature.edit.feature.main;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f319253a;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f319253a == ((f) r100).f319253a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f319253a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MainUIState(xx=" + this.f319253a + ')';
    }

    public f(int r100) {
        this.f319253a = false;
    }
}
