package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final String a;
    public final String b;
    public final double c;
    public final String d;
    public final Map<String, Object> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L16;
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Double.compare(this.c, r6.c) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = Double.doubleToLongBits(this.c);
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        Map<String, Object> r12 = this.e;
        if (r12 == null) goto L18;
        r1 = r12.hashCode();
    L18:
        return r11 + r1;
    L13:
        r10 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SessionStageData(stageName=" + this.a + ", scheme=" + this.b + ", timestamp=" + this.c + ", triggerSource=" + this.d + ", extraData=" + this.e + ")";
    }

    public c(String r2, String r3, double r4, String r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r2, "stageName");
        Intrinsics.checkNotNullParameter(r3, "scheme");
        Intrinsics.checkNotNullParameter(r6, "triggerSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
