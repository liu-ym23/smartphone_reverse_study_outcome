package com.larus.camera.impl.utils.eventbus;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f322754a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f322754a == ((f) r100).f322754a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f322754a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ChangeSuggestedActionVisibility(visible=" + this.f322754a + ')';
    }

    public f(boolean r100) {
        this.f322754a = r100;
    }
}
