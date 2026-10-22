package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.ec.model.ECUrlModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public final ECUrlModel a;
    public final String b;
    public final String c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final p i;
    public final int j;
    public final Integer k;
    public final boolean l;
    public c0 m;

    public q(ECUrlModel r15, String r16, String r17, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r18, String r19, String r20, String r21, int r22, p r23, int r24, Integer r25, boolean r26, int r27) {
        if ((r27 & 1) == 0) goto L5;
        ECUrlModel r2 = null;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r27 & 8) == 0) goto L17;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r6 = null;
    L19:
        if ((r27 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r27 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r27 & 256) == 0) goto L33;
        p r10 = null;
    L34:
        boolean r12 = false;
        if ((r27 & 512) == 0) goto L37;
        int r11 = 0;
    L39:
        if ((r27 & 1024) == 0) goto L41;
        Integer r13 = null;
    L43:
        if ((r27 & 2048) != 0) goto L46;
        r12 = r26;
    L46:
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r22;
        this.i = r10;
        this.j = r11;
        this.k = r13;
        this.l = r12;
        this.m = null;
        return;
    L41:
        r13 = r25;
        goto L43
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L34
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }
}
