package com.larus.camera.impl.utils.eventbus;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f322753a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f322753a == ((e) r100).f322753a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f322753a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ChangeSuggestedActionSuppressedForInputText(suppressed=" + this.f322753a + ')';
    }

    public e(boolean r100) {
        this.f322753a = r100;
    }
}
