package com.bytedance.android.shopping.api.video;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final String a;
    public final String b;
    public final int c;
    public final CodecType d;
    public final List<String> e;
    public final long f;
    public final int g;
    public final String h;
    public final int i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L24;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L37;
        return false;
    L37:
        return true;
    L24:
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
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        CodecType r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.e;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        long r13 = this.f;
        int r14 = (((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.g) * 31;
        String r15 = this.h;
        if (r15 == null) goto L22;
        r1 = r15.hashCode();
    L22:
        return ((r14 + r1) * 31) + this.i;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECPlayItem(videoKey=" + this.a + ", key=" + this.b + ", bitRate=" + this.c + ", codecType=" + this.d + ", urls=" + this.e + ", size=" + this.f + ", duration=" + this.g + ", gearName=" + this.h + ", qualityType=" + this.i + ")";
    }

    public b(String r2, String r3, int r4, CodecType r5, List<String> r6, long r7, int r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r2, "videoKey");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "codecType");
        Intrinsics.checkNotNullParameter(r6, "urls");
        Intrinsics.checkNotNullParameter(r10, "gearName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
