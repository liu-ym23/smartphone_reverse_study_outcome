package io.opentelemetry.api.internal;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f492678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean[] f492679b = null;

    static {
        char[] r100 = new char[512];
        int r101 = 0;
    L4:
        if (r101 >= 256) goto L6;
        r100[r101] = "0123456789abcdef".charAt(r101 >>> 4);
        r100[r101 | 256] = "0123456789abcdef".charAt(r101 & 15);
        r101 = r101 + 1;
        goto L4
    L6:
        f492678a = r100;
        byte[] r102 = new byte[128];
        Arrays.fill(r102, (byte) -1);
        int r103 = 0;
    L8:
        if (r103 >= 16) goto L10;
        r102["0123456789abcdef".charAt(r103)] = (byte) r103;
        r103 = r103 + 1;
        goto L8
    L10:
        boolean[] r104 = new boolean[65535];
        int r105 = 0;
    L11:
        if (r105 >= 65535) goto L23;
        if (48 > r105) goto L17;
        if (r105 > 57) goto L17;
    L20:
        boolean r106 = true;
    L22:
        r104[r105] = r106;
        r105 = r105 + 1;
    L17:
        if (97 <= r105) goto L19;
    L21:
        r106 = false;
        goto L22
    L19:
        if (r105 > 102) goto L21;
    L23:
        f492679b = r104;
    }

    public static void a(byte r100, char[] r101, int r102) {
        int r103 = r100 & UByte.MAX_VALUE;
        char[] r104 = f492678a;
        r101[r102] = r104[r103];
        r101[r102 + 1] = r104[r103 | 256];
    }

    public static void b(long r100, char[] r101, int r102) {
        a((byte) ((r100 >> 56) & 255), r101, r102);
        a((byte) ((r100 >> 48) & 255), r101, r102 + 2);
        a((byte) ((r100 >> 40) & 255), r101, r102 + 4);
        a((byte) ((r100 >> 32) & 255), r101, r102 + 6);
        a((byte) ((r100 >> 24) & 255), r101, r102 + 8);
        a((byte) ((r100 >> 16) & 255), r101, r102 + 10);
        a((byte) ((r100 >> 8) & 255), r101, r102 + 12);
        a((byte) (r100 & 255), r101, r102 + 14);
    }
}
