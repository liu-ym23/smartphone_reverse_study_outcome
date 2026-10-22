package com.ss.android.lark.todo.impl.features.detail;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f442826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f442827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f442828c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f442826a == r101.f442826a) goto L12;
        return false;
    L12:
        if (this.f442827b == r101.f442827b) goto L15;
        return false;
    L15:
        if (this.f442828c == r101.f442828c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f442826a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f442827b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f442828c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FastCreateInitData(isCreateFromMessageToolBar=" + this.f442826a + ", isShowCreateAndSend=" + this.f442827b + ", isShowSendToChatCheckbox=" + this.f442828c + ')';
    }

    public c(boolean r100, boolean r101, boolean r102) {
        this.f442826a = r100;
        this.f442827b = r101;
        this.f442828c = r102;
    }
}
