package com.bytedance.android.shopping.buynow.starter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final ma3.b b;
    public final boolean c;
    public final Throwable d;
    public final Integer e;
    public final int f;
    public final boolean g;
    public final boolean h;

    public d(String r4, String r5, ma3.b r6, boolean r7, Throwable r8, Integer r9, int r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if ((r13 & 8) == 0) goto L12;
        r7 = false;
    L12:
        if ((r13 & 16) == 0) goto L15;
        r8 = null;
    L15:
        if ((r13 & 64) == 0) goto L18;
        r10 = 0;
    L18:
        if ((r13 & 128) == 0) goto L21;
        r11 = false;
    L21:
        if ((r13 & 256) == 0) goto L23;
        r12 = false;
    L23:
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
    }
}
