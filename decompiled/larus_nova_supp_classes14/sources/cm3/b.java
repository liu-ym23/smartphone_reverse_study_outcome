package cm3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static int b(int r1, String r2) {
        int r3 = bm3.a.a(r2);
        return (r3 + bm3.a.b(r3)) + bm3.a.b((r1 << 3) | 0);
    }

    public static void a(bm3.a r8, int r9, String r10) {
        r8.c((r9 << 3) | 2);
        r8.c(bm3.a.a(r10));
        int r0 = 0;
    L4:
        if (r0 >= r10.length()) goto L30;
        char r1 = r10.charAt(r0);
        if (r1 < 128) goto L7;
        if (r1 < 2048) goto L10;
        if (r1 < 55296) goto L28;
        if (r1 > 57343) goto L28;
        int r5 = r0 + 1;
        if (r5 >= r10.length()) goto L19;
        char r6 = r10.charAt(r5);
    L21:
        if (r1 > 56319) goto L27;
        if (r6 < 56320) goto L27;
        if (r6 > 57343) goto L27;
        int r2 = (((r1 & (-55297)) << 10) | ((-56321) & r6)) + 65536;
        byte[] r3 = r8.a;
        int r7 = r8.b;
        int r11 = r7 + 1;
        r3[r7] = (byte) ((r2 >> 18) | 240);
        int r12 = r11 + 1;
        r3[r11] = (byte) (((r2 >> 12) & 63) | 128);
        int r13 = r12 + 1;
        r3[r12] = (byte) (((r2 >> 6) & 63) | 128);
        r8.b = r13 + 1;
        r3[r13] = (byte) ((r2 & 63) | 128);
        r0 = r0 + 2;
    L27:
        byte[] r4 = r8.a;
        int r14 = r8.b;
        r8.b = r14 + 1;
        r4[r14] = 63;
        r0 = r5;
        goto L4
    L19:
        r6 = 0;
    L28:
        byte[] r15 = r8.a;
        int r16 = r8.b;
        int r17 = r16 + 1;
        r15[r16] = (byte) ((r1 >> '\f') | 224);
        int r18 = r17 + 1;
        r15[r17] = (byte) ((63 & (r1 >> 6)) | 128);
        r8.b = r18 + 1;
        r15[r18] = (byte) ((r1 & '?') | 128);
    L29:
        r0 = r0 + 1;
        goto L4
    L10:
        byte[] r19 = r8.a;
        int r20 = r8.b;
        int r21 = r20 + 1;
        r19[r20] = (byte) ((r1 >> 6) | 192);
        r8.b = r21 + 1;
        r19[r21] = (byte) ((r1 & '?') | 128);
        goto L29
    L7:
        byte[] r22 = r8.a;
        int r23 = r8.b;
        r8.b = r23 + 1;
        r22[r23] = (byte) r1;
        goto L29
    }
}
