package com.bytedance.android.shopping.api.mall;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final boolean a;
    public final String b;
    public final ECHybridNetworkVO c;
    public final String d;
    public final boolean e;
    public final String f;
    public final Throwable g;
    public final long h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L22;
        c r6 = (c) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r6.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r6.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        String r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        ECHybridNetworkVO r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        String r11 = this.d;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.e;
        if (r14 == true) goto L21;
        r1 = r14;
    L21:
        int r15 = (r13 + r1) * 31;
        String r16 = this.f;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        Throwable r19 = this.g;
        if (r19 == null) goto L28;
        r5 = r19.hashCode();
    L28:
        long r20 = this.h;
        return ((r18 + r5) * 31) + ((int) (r20 ^ (r20 >>> 32)));
    L24:
        r17 = 0;
        goto L25
    L16:
        r12 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return com.bytedance.android.ec.hybrid.list.util.k.d(this);
    }

    public /* synthetic */ c(boolean r11, String r12, ECHybridNetworkVO r13, String r14, String r15, Throwable r16) {
        this(r11, r12, r13, r14, false, r15, r16, System.currentTimeMillis());
    }

    public c(boolean r2, String r3, ECHybridNetworkVO r4, String r5, boolean r6, String r7, Throwable r8, long r9) {
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        Intrinsics.checkNotNullParameter(r5, "requestKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
