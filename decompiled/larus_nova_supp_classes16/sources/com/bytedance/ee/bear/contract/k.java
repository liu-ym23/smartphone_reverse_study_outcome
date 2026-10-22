package com.bytedance.ee.bear.contract;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public final Context a;
    public final int b;
    public final String c;
    public final String d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L19:
        return r8 + r9;
    L17:
        r9 = 1237;
        goto L19
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateDocumentBean(context=" + this.a + ", type=" + this.b + ", path=" + this.c + ", tab=" + this.d + ", isSpaceV2=" + this.e + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public final int getType() {
        return this.b;
    }

    public k(Context r1, int r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = "";
        this.d = r3;
        this.e = r4;
    }
}
