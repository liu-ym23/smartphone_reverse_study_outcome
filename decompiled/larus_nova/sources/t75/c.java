package t75;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ir5.d f544883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544884b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f544883a, r101.f544883a) == true) goto L12;
        return false;
    L12:
        if (this.f544884b == r101.f544884b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f544883a.hashCode() * 31;
        if (this.f544884b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DrivePreviewAiContainerAttachResult(host=" + this.f544883a + ", firstAttach=" + this.f544884b + ')';
    }

    public c(ir5.d r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f544883a = r100;
        this.f544884b = r101;
    }
}
