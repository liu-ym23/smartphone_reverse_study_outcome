package com.larus.bmhome.chat.deepresearch.view;

/* JADX INFO: loaded from: classes25.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f302373a;

    public f1() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L9;
        return false;
    L9:
        if (this.f302373a == ((f1) r100).f302373a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f302373a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MessageBoxConfig(useSubscribedColor=" + this.f302373a + ')';
    }

    public f1(boolean r100) {
        this.f302373a = r100;
    }
}
