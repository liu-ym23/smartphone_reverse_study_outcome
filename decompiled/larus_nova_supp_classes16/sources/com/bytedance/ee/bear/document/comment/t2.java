package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t2 implements o2 {
    public final boolean a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t2) == true) goto L9;
        return false;
    L9:
        if (this.a == ((t2) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "PermissionChange(comment=" + this.a + ')';
    }

    public t2(boolean r1) {
        this.a = r1;
    }
}
