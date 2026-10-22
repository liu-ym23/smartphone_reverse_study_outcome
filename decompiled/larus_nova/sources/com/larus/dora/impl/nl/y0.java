package com.larus.dora.impl.nl;

/* JADX INFO: loaded from: classes27.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f336405a;

    public y0() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L9;
        return false;
    L9:
        if (this.f336405a == ((y0) r100).f336405a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f336405a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ProactiveSettingsUiState(isPriorityEnabled=" + this.f336405a + ')';
    }

    public y0(boolean r100) {
        this.f336405a = r100;
    }
}
