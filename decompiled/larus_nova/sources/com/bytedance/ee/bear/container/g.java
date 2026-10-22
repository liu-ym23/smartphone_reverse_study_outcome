package com.bytedance.ee.bear.container;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f216752a;

    public g() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (this.f216752a == ((g) r100).f216752a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f216752a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ContainerTitleBarState(showTitleBar=" + this.f216752a + ')';
    }

    public g(boolean r100) {
        this.f216752a = r100;
    }
}
