package com.bytedance.applet.debugger;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public final List<q> a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "AppletDebuggerSaveTokenRequest(batchData=" + this.a + ", feedbackSource=" + this.b + ')';
    }

    public r(List r2) {
        Intrinsics.checkNotNullParameter(r2, "batchData");
        this.a = r2;
        this.b = 2;
    }
}
