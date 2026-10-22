package org.bouncycastle.util.encoders;

import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes42.dex */
public class UTF8 {
    private static final byte C_CR1 = 1;
    private static final byte C_CR2 = 2;
    private static final byte C_CR3 = 3;
    private static final byte C_ILL = 0;
    private static final byte C_L2A = 4;
    private static final byte C_L3A = 5;
    private static final byte C_L3B = 6;
    private static final byte C_L3C = 7;
    private static final byte C_L4A = 8;
    private static final byte C_L4B = 9;
    private static final byte C_L4C = 10;
    private static final byte S_CS1 = 0;
    private static final byte S_CS2 = 16;
    private static final byte S_CS3 = 32;
    private static final byte S_END = -1;
    private static final byte S_ERR = -2;
    private static final byte S_P3A = 48;
    private static final byte S_P3B = 64;
    private static final byte S_P4A = 80;
    private static final byte S_P4B = 96;
    private static final short[] firstUnitTable = null;
    private static final byte[] transitionTable = null;

    static {
        firstUnitTable = new short[128];
        byte[] r100 = new byte[112];
        transitionTable = r100;
        byte[] r101 = new byte[128];
        int r102 = 0;
        fill(r101, 0, 15, (byte) 1);
        fill(r101, 16, 31, (byte) 2);
        fill(r101, 32, 63, (byte) 3);
        fill(r101, 64, 65, (byte) 0);
        fill(r101, 66, 95, (byte) 4);
        fill(r101, 96, 96, (byte) 5);
        fill(r101, 97, 108, (byte) 6);
        fill(r101, 109, 109, (byte) 7);
        fill(r101, 110, 111, (byte) 6);
        fill(r101, 112, 112, (byte) 8);
        fill(r101, 113, 115, (byte) 9);
        fill(r101, 116, 116, (byte) 10);
        fill(r101, 117, 127, (byte) 0);
        fill(r100, 0, r100.length - 1, S_ERR);
        fill(r100, 8, 11, (byte) -1);
        fill(r100, 24, 27, (byte) 0);
        fill(r100, 40, 43, (byte) 16);
        fill(r100, 58, 59, (byte) 0);
        fill(r100, 72, 73, (byte) 0);
        fill(r100, 89, 91, (byte) 16);
        fill(r100, 104, 104, (byte) 16);
        byte[] r103 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] r104 = {S_ERR, S_ERR, S_ERR, S_ERR, 0, S_P3A, 16, S_P3B, S_P4A, S_CS3, S_P4B};
    L3:
        if (r102 >= 128) goto L5;
        byte r105 = r101[r102];
        int r106 = r103[r105] & r102;
        byte r107 = r104[r105];
        firstUnitTable[r102] = (short) (r107 | (r106 << 8));
        r102 = r102 + 1;
        goto L3
    }

    public UTF8() {
    }

    private static void fill(byte[] r100, int r101, int r102, byte r103) {
    L2:
        if (r101 > r102) goto L4;
        r100[r101] = r103;
        r101 = r101 + 1;
        goto L2
    }

    public static int transcodeToUTF16(byte[] r100, char[] r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length) goto L31;
        int r104 = r102 + 1;
        byte r105 = r100[r102];
        if (r105 >= 0) goto L8;
        short r106 = firstUnitTable[r105 & ByteCompanionObject.MAX_VALUE];
        int r107 = r106 >>> 8;
        byte r108 = (byte) r106;
    L12:
        if (r108 < 0) goto L18;
        if (r104 >= r100.length) goto L15;
        int r109 = r104 + 1;
        byte r110 = r100[r104];
        r107 = (r107 << 6) | (r110 & 63);
        r108 = transitionTable[r108 + ((r110 & 255) >>> 4)];
        r104 = r109;
        goto L12
    L15:
        return -1;
    L18:
        if (r108 == (-2)) goto L19;
        if (r107 > 65535) goto L27;
        if (r103 >= r101.length) goto L24;
        r101[r103] = (char) r107;
        r103 = r103 + 1;
    L30:
        r102 = r104;
        goto L4
    L24:
        return -1;
    L27:
        if (r103 >= (r101.length - 1)) goto L28;
        int r111 = r103 + 1;
        r101[r103] = (char) ((r107 >>> 10) + 55232);
        r103 = r111 + 1;
        r101[r111] = (char) ((r107 & 1023) | 56320);
        goto L30
    L28:
        return -1;
    L19:
        return -1;
    L8:
        if (r103 >= r101.length) goto L9;
        r101[r103] = (char) r105;
        r102 = r104;
        r103 = r103 + 1;
        goto L4
    L9:
        return -1;
    L31:
        return r103;
    }
}
