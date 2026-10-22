package com.bytedance.ee.bear.container;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final boolean a;

    public e() {
        this(true);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.a == ((e) r4).a) goto L11;
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
        return "ContainerLoadingState(showLoading=" + this.a + ')';
    }

    public e(boolean r1) {
        this.a = r1;
    }
}
