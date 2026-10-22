package com.larus.im.internal.core.job;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f347669a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f347669a == ((c) r100).f347669a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f347669a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "AIJobExperimentSnapshot(enabled=" + this.f347669a + ')';
    }

    public c(boolean r100) {
        this.f347669a = r100;
    }
}
