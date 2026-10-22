package com.bytedance.android.shopping.store.home;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof c0) == true) goto L6;
        return false;
    L6:
        if (this.a == ((c0) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "ShopImagePlayEvent(actionType=" + this.a + ")";
    }

    public c0() {
        this.a = 1;
    }
}
