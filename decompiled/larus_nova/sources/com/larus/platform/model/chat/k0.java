package com.larus.platform.model.chat;

/* JADX INFO: loaded from: classes31.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365581a;

    public k0() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L9;
        return false;
    L9:
        if (this.f365581a == ((k0) r100).f365581a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f365581a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "PreviewPageConfig(previewUpdatesEnable=" + this.f365581a + ')';
    }

    public k0(boolean r100) {
        this.f365581a = r100;
    }
}
