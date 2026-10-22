package com.ss.android.lark.todo.impl.features.detail.viewmodel;

/* JADX INFO: loaded from: classes38.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f443906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f443907b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f443906a == r101.f443906a) goto L12;
        return false;
    L12:
        if (this.f443907b == r101.f443907b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f443906a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f443907b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SummaryInit(isCreateTodo=" + this.f443906a + ", isShouldFastCreate=" + this.f443907b + ')';
    }

    public y(boolean r100, boolean r101) {
        this.f443906a = r100;
        this.f443907b = r101;
    }
}
