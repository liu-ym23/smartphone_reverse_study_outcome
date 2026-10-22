package com.bytedance.ee.bear.contract;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j0 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final boolean d;
    public Document e;
    public final c0.b f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r6 = (j0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        String r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        if (this.d == true) goto L18;
        r1 = 1237;
    L18:
        int r9 = (r8 + r1) * 31;
        Document r10 = this.e;
        if (r10 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r9 + r11) * 31;
        c0.b r13 = this.f;
        if (r13 == null) goto L27;
        r6 = r13.hashCode();
    L27:
        return r12 + r6;
    L21:
        r11 = r10.hashCode();
        goto L22
    L13:
        r7 = r5.hashCode();
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ManualOfflineDownloadConfig(shouldMobileNetworkConfirm=" + this.a + ", isGrid=" + this.b + ", module=" + this.c + ", isNeedReport=" + this.d + ", document=" + this.e + ", callback=" + this.f + ')';
    }

    public j0(boolean r1, boolean r2, String r3, boolean r4, Document r5, c0.b r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
