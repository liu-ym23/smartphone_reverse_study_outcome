package org.bouncycastle.pqc.crypto.sphincs;

import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
class Wots {
    static final int WOTS_L = 67;
    static final int WOTS_L1 = 64;
    static final int WOTS_LOGW = 4;
    static final int WOTS_LOG_L = 7;
    static final int WOTS_SIGBYTES = 2144;
    static final int WOTS_W = 16;

    public Wots() {
    }

    private static void clear(byte[] r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 == r102) goto L5;
        r100[r103 + r101] = 0;
        r103 = r103 + 1;
        goto L3
    }

    public static void expand_seed(byte[] r100, int r101, byte[] r102, int r110) {
        clear(r100, r101, WOTS_SIGBYTES);
        Seed.prg(r100, r101, 2144, r102, r110);
    }

    public static void gen_chain(HashFunctions r100, byte[] r101, int r110, byte[] r111, int r112, byte[] r113, int r114, int r115) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= 32) goto L6;
        r101[r103 + r110] = r111[r103 + r112];
        r103 = r103 + 1;
    L6:
        if (r102 >= r115) goto L10;
        if (r102 >= 16) goto L14;
        r100.hash_n_n_mask(r101, r110, r101, r110, r113, r114 + (r102 * 32));
        r102 = r102 + 1;
        goto L6
    L14:
        return;
    }

    public void wots_pkgen(HashFunctions r100, byte[] r110, int r111, byte[] r112, int r113, byte[] r114, int r115) {
        expand_seed(r110, r111, r112, r113);
        int r116 = 0;
    L4:
        if (r116 >= 67) goto L6;
        int r101 = r111 + (r116 * 32);
        gen_chain(r100, r110, r101, r110, r101, r114, r115, 15);
        r116 = r116 + 1;
        goto L4
    }

    public void wots_sign(HashFunctions r110, byte[] r111, int r112, byte[] r113, byte[] r114, byte[] r210) {
        int[] r100 = new int[67];
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= 64) goto L6;
        byte r104 = r113[r102 / 2];
        r100[r102] = r104 & 15;
        int r105 = (r104 & UByte.MAX_VALUE) >>> 4;
        r100[r102 + 1] = r105;
        r103 = (r103 + (15 - r100[r102])) + (15 - r105);
        r102 = r102 + 2;
    L6:
        if (r102 >= 67) goto L8;
        r100[r102] = r103 & 15;
        r103 = r103 >>> 4;
        r102 = r102 + 1;
        goto L6
    L8:
        expand_seed(r111, r112, r114, 0);
    L9:
        if (r101 >= 67) goto L11;
        int r115 = r112 + (r101 * 32);
        gen_chain(r110, r111, r115, r111, r115, r210, 0, r100[r101]);
        r101 = r101 + 1;
        goto L9
    }

    public void wots_verify(HashFunctions r110, byte[] r111, byte[] r112, int r113, byte[] r114, byte[] r115) {
        int[] r100 = new int[67];
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= 64) goto L6;
        byte r104 = r114[r102 / 2];
        r100[r102] = r104 & 15;
        int r105 = (r104 & UByte.MAX_VALUE) >>> 4;
        r100[r102 + 1] = r105;
        r103 = (r103 + (15 - r100[r102])) + (15 - r105);
        r102 = r102 + 2;
    L6:
        if (r102 >= 67) goto L8;
        r100[r102] = r103 & 15;
        r103 = r103 >>> 4;
        r102 = r102 + 1;
    L8:
        if (r101 >= 67) goto L10;
        int r106 = r101 * 32;
        int r107 = r100[r101];
        gen_chain(r110, r111, r106, r112, r113 + r106, r115, r107 * 32, 15 - r107);
        r101 = r101 + 1;
        goto L8
    }
}
