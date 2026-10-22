package com.bytedance.locallife.pdp.container.view.lynx;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f261329a;

    public j() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (this.f261329a == ((j) r100).f261329a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f261329a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "LoaderConfig(usingNewMergeUpdateApi=" + this.f261329a + ')';
    }

    public j(boolean r100) {
        this.f261329a = r100;
    }
}
