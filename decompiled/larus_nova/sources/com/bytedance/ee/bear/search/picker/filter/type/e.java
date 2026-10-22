package com.bytedance.ee.bear.search.picker.filter.type;

import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f236925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f236926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f236927c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f236925a == r101.f236925a) goto L12;
        return false;
    L12:
        if (this.f236926b == r101.f236926b) goto L15;
        return false;
    L15:
        if (this.f236927c == r101.f236927c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f236925a * 31) + this.f236926b) * 31;
        if (this.f236927c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SelectTypeItem(nameId=" + this.f236925a + ", typeId=" + this.f236926b + ", isSelected=" + this.f236927c + ')';
    }

    public final void a(int[] r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        this.f236927c = !r101;
        return;
    L5:
        if (ArraysKt.indexOf(r100, this.f236926b) != (-1)) goto L7;
        r101 = true;
        goto L7
    }

    public e(int r100, int r101) {
        this.f236925a = r100;
        this.f236926b = r101;
        this.f236927c = false;
    }
}
