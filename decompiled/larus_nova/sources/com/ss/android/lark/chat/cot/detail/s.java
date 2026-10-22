package com.ss.android.lark.chat.cot.detail;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f415004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f415005b;

    public s() {
        int r100 = 0;
        this(r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f415004a == r101.f415004a) goto L12;
        return false;
    L12:
        if (this.f415005b == r101.f415005b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f415004a * 31;
        if (this.f415005b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CotGroupDetailExtra(toolCallCount=" + this.f415004a + ", isGroupExpanded=" + this.f415005b + ')';
    }

    public /* synthetic */ s(int r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, false);
    }

    public s(int r100, boolean r101) {
        this.f415004a = r100;
        this.f415005b = r101;
    }
}
