package com.bytedance.sdk.xbridge.cn.platform.lynx;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f269972a;

    public c() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f269972a == ((c) r100).f269972a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f269972a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "LynxBridgeOptConfig(needAuth=" + this.f269972a + ')';
    }

    public c(boolean r100) {
        this.f269972a = r100;
    }
}
