package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: classes16.dex */
public final class t2 implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f219363a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t2) == true) goto L9;
        return false;
    L9:
        if (this.f219363a == ((t2) r100).f219363a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f219363a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "PermissionChange(comment=" + this.f219363a + ')';
    }

    public t2(boolean r100) {
        this.f219363a = r100;
    }
}
