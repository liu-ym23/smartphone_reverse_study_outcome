package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PageLoadReason f271256a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f271256a, ((c) r100).f271256a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        PageLoadReason r100 = this.f271256a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "Data(reason=" + this.f271256a + ")";
    }

    public c(PageLoadReason r100) {
        this.f271256a = r100;
    }
}
