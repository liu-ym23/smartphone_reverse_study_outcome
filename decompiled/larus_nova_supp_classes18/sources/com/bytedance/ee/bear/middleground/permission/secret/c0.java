package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;

    public c0() {
        this(null, 0, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f;
    }

    public final String toString() {
        return "UpdateSecretParam(token=" + this.a + ", type=" + this.b + ", secLableId=" + this.c + ", reason=" + this.d + ", name=" + this.e + ", level=" + this.f + ')';
    }

    public final int getType() {
        return this.b;
    }

    public c0(String r10, int r11, String r12, String r13, int r14) {
        String r1 = "";
        if ((r14 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r14 & 2) == 0) goto L9;
        r11 = sbb.e.g.b;
    L9:
        int r4 = r11;
        if ((r14 & 4) == 0) goto L12;
        String r5 = "";
    L14:
        if ((r14 & 8) == 0) goto L16;
        String r6 = "";
    L18:
        if ((r14 & 16) != 0) goto L21;
        r1 = null;
    L21:
        String r7 = r1;
        if ((r14 & 32) == 0) goto L24;
        int r8 = -1;
    L25:
        this(r3, r4, r5, r6, r7, r8);
        return;
    L24:
        r8 = 0;
        goto L25
    L16:
        r6 = r13;
        goto L18
    L12:
        r5 = r12;
        goto L14
    L5:
        r3 = r10;
        goto L7
    }

    public c0(String r2, int r3, String r4, String r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "secLableId");
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r6, "name");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
