package com.bytedance.applet.debugger;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AppletDebuggerSaveTokenItem(logId=" + this.a + ", token=" + this.b + ')';
    }

    public q(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "logId");
        Intrinsics.checkNotNullParameter(r3, "token");
        this.a = r2;
        this.b = r3;
    }
}
