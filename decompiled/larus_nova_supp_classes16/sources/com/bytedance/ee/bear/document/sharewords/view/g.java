package com.bytedance.ee.bear.document.sharewords.view;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public final ForwardTarget a;
    public final String b;
    public final String c;
    public final int d;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public final String toString() {
        return "NoteParams(target=" + h.a(this.a) + ", parentId=" + this.b + ", note=" + this.c + ", targetSize=" + this.d + ')';
    }

    public g(ForwardTarget r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "parentId");
        Intrinsics.checkNotNullParameter(r4, "note");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
