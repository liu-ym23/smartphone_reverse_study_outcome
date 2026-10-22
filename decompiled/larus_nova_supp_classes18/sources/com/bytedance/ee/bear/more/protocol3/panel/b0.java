package com.bytedance.ee.bear.more.protocol3.panel;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 {
    public final String a;
    public final int b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MorePanelMeta(token=" + this.a + ", type=" + this.b + ", subType=" + this.c + ')';
    }

    public final int getType() {
        return this.b;
    }

    public b0(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "subType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
