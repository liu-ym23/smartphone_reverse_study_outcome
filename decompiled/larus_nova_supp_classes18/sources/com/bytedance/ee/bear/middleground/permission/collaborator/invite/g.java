package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public final int a;
    public final String b;
    public final int c;
    public final String d;
    public final int e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        String r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.e) * 31;
        if (this.f == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InviteParam(permType=" + this.a + ", url=" + this.b + ", type=" + this.c + ", token=" + this.d + ", newPermission=" + this.e + ", notifyLark=" + this.f + ')';
    }

    public final int getType() {
        return this.c;
    }

    public g(int r2, String r3, int r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_URL);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 1;
        this.f = r6;
    }
}
