package com.bytedance.android.shopping.api.video;

import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.google.gson.JsonElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final String a;
    public final long b;
    public final String c;
    public final List<b> d;
    public final List<b> e;
    public final d f;
    public final long g;
    public final float h;
    public final List<JsonElement> i;
    public final int j;
    public final int k;
    public final List<ExplainReplaySubTitle> l;
    public final da3.c m;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L32;
        e r7 = (e) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Float.compare(this.h, r7.h) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        List<b> r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        List<b> r11 = this.e;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        d r14 = this.f;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        long r17 = this.g;
        int r18 = (((r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31) + Float.floatToIntBits(this.h)) * 31;
        List<JsonElement> r19 = this.i;
        if (r19 == null) goto L25;
        int r20 = r19.hashCode();
    L26:
        int r21 = (((((r18 + r20) * 31) + this.j) * 31) + this.k) * 31;
        List<ExplainReplaySubTitle> r22 = this.l;
        if (r22 == null) goto L29;
        int r23 = r22.hashCode();
    L30:
        int r24 = (r21 + r23) * 31;
        da3.c r25 = this.m;
        if (r25 == null) goto L34;
        r1 = r25.hashCode();
    L34:
        return r24 + r1;
    L29:
        r23 = 0;
        goto L30
    L25:
        r20 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECVideoModel(key=" + this.a + ", duration=" + this.b + ", ratio=" + this.c + ", playItems=" + this.d + ", selectablePlayItems=" + this.e + ", playerOptions=" + this.f + ", cdnUrlExpired=" + this.g + ", aspectRatio=" + this.h + ", videoThumbs=" + this.i + ", height=" + this.j + ", width=" + this.k + ", subTitle=" + this.l + ", subTitleCallback=" + this.m + ")";
    }

    public e(String r6, long r7, String r9, List<b> r10, List<b> r11, d r12, long r13, float r15, List<? extends JsonElement> r16, int r17, int r18, List<ExplainReplaySubTitle> r19, da3.c r20) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r10, "playItems");
        this.a = r6;
        this.b = r7;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
    }
}
