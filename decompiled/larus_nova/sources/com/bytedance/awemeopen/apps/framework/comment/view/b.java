package com.bytedance.awemeopen.apps.framework.comment.view;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f194195a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f194195a == ((b) r100).f194195a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f194195a;
    }

    public final String toString() {
        return "DiggTypeEvent(type=" + this.f194195a + ')';
    }

    public final int getType() {
        return this.f194195a;
    }

    public b(int r100) {
        this.f194195a = r100;
    }
}
