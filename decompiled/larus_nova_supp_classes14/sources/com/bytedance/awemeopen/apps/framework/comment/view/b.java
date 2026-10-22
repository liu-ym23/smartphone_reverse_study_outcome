package com.bytedance.awemeopen.apps.framework.comment.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((b) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "DiggTypeEvent(type=" + this.a + ')';
    }

    public final int getType() {
        return this.a;
    }

    public b(int r1) {
        this.a = r1;
    }
}
