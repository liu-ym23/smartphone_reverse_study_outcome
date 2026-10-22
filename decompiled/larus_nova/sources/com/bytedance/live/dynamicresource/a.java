package com.bytedance.live.dynamicresource;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f255104a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f255104a == ((a) r100).f255104a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f255104a;
    }

    public final String toString() {
        return "ConfigModel(uiLayout=" + this.f255104a + ')';
    }

    public a() {
        this.f255104a = 0;
    }
}
