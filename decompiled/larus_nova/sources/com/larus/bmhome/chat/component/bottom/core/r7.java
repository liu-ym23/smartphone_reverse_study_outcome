package com.larus.bmhome.chat.component.bottom.core;

/* JADX INFO: loaded from: classes25.dex */
public final class r7 implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f299376a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r7) == true) goto L9;
        return false;
    L9:
        if (this.f299376a == ((r7) r100).f299376a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f299376a;
    }

    public final String toString() {
        return "CoreInputConfig(initalStatus=" + this.f299376a + ')';
    }

    public r7() {
        this.f299376a = -1;
    }
}
