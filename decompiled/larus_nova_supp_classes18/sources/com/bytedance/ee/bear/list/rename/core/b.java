package com.bytedance.ee.bear.list.rename.core;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final String a;
    public final Document b;
    public final oj5.c c;
    public final String d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "OfficeRenameCoreRequest(actionId=" + this.a + ", document=" + this.b + ", moreInfo=" + this.c + ", newName=" + this.d + ", failedTips=" + this.e + ')';
    }

    public b(String r2, Document r3, oj5.c r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "actionId");
        Intrinsics.checkNotNullParameter(r3, "document");
        Intrinsics.checkNotNullParameter(r4, "moreInfo");
        Intrinsics.checkNotNullParameter(r5, "newName");
        Intrinsics.checkNotNullParameter(r6, "failedTips");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
