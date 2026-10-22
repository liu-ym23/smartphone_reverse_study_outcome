package com.bytedance.ee.bear.container;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f216751a;

    public e() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f216751a == ((e) r100).f216751a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f216751a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ContainerLoadingState(showLoading=" + this.f216751a + ')';
    }

    public e(boolean r100) {
        this.f216751a = r100;
    }
}
