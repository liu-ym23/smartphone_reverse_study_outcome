package com.bytedance.ee.bear.search.picker.filter.type;

import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final int a;
    public final int b;
    public boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "SelectTypeItem(nameId=" + this.a + ", typeId=" + this.b + ", isSelected=" + this.c + ')';
    }

    public final void a(int[] r4) {
        boolean r1 = false;
        if (r4 != null) goto L5;
    L7:
        this.c = !r1;
        return;
    L5:
        if (ArraysKt.indexOf(r4, this.b) != (-1)) goto L7;
        r1 = true;
        goto L7
    }

    public e(int r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = false;
    }
}
