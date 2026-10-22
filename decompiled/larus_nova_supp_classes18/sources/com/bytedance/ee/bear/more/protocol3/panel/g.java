package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements z {
    public final b0 a;
    public final c0 b;
    public final a0 c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DefaultMorePanelInfo(meta=" + this.a + ", permission=" + this.b + ", jsState=" + this.c + ')';
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.z
    public final c0 getPermission() {
        return this.b;
    }

    public g(b0 r2, c0 r3, a0 r4) {
        Intrinsics.checkNotNullParameter(r2, "meta");
        Intrinsics.checkNotNullParameter(r3, "permission");
        Intrinsics.checkNotNullParameter(r4, "jsState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
