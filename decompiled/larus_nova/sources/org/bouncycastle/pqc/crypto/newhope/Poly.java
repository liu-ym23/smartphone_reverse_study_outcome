package org.bouncycastle.pqc.crypto.newhope;

import android.R;
import kotlin.UByte;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
class Poly {
    public Poly() {
    }

    public static void add(short[] r100, short[] r101, short[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 1024) goto L6;
        r102[r103] = Reduce.barrett((short) (r100[r103] + r101[r103]));
        r103 = r103 + 1;
        goto L4
    }

    public static void fromBytes(short[] r110, byte[] r111) {
        int r100 = 0;
    L4:
        if (r100 >= 256) goto L6;
        int r101 = r100 * 7;
        int r102 = r111[r101 + 0] & UByte.MAX_VALUE;
        int r103 = r111[r101 + 1] & UByte.MAX_VALUE;
        int r104 = r111[r101 + 2] & UByte.MAX_VALUE;
        int r105 = r111[r101 + 3] & UByte.MAX_VALUE;
        int r106 = r111[r101 + 4] & UByte.MAX_VALUE;
        int r107 = r111[r101 + 5] & UByte.MAX_VALUE;
        int r108 = r111[r101 + 6] & UByte.MAX_VALUE;
        int r109 = r100 * 4;
        r110[r109 + 0] = (short) (r102 | ((r103 & 63) << 8));
        r110[r109 + 1] = (short) (((r103 >>> 6) | (r104 << 2)) | ((r105 & 15) << 10));
        r110[r109 + 2] = (short) (((r105 >>> 4) | (r106 << 4)) | ((r107 & 3) << 12));
        int r112 = r108 << 6;
        r110[r109 + 3] = (short) (r112 | (r107 >>> 2));
        r100 = r100 + 1;
        goto L4
    }

    public static void fromNTT(short[] r100) {
        NTT.bitReverse(r100);
        NTT.core(r100, Precomp.OMEGAS_INV_MONTGOMERY);
        NTT.mulCoefficients(r100, Precomp.PSIS_INV_MONTGOMERY);
    }

    public static void getNoise(short[] r100, byte[] r101, byte r102) {
        byte[] r103 = new byte[8];
        r103[0] = r102;
        byte[] r104 = new byte[4096];
        ChaCha20.process(r101, r103, r104, 0, 4096);
        int r105 = 0;
    L4:
        if (r105 >= 1024) goto L9;
        int r106 = Pack.bigEndianToInt(r104, r105 * 4);
        int r107 = 0;
        int r108 = 0;
    L6:
        if (r107 >= 8) goto L8;
        r108 = r108 + ((r106 >> r107) & R.attr.cacheColorHint);
        r107 = r107 + 1;
        goto L6
    L8:
        int r109 = ((r108 >>> 24) + (r108 >>> 0)) & 255;
        int r110 = r109 + 12289;
        r100[r105] = (short) (r110 - (((r108 >>> 16) + (r108 >>> 8)) & 255));
        r105 = r105 + 1;
        goto L4
    }

    private static short normalize(short r100) {
        short r101 = Reduce.barrett(r100);
        int r102 = r101 - 12289;
        return (short) (((r101 ^ r102) & (r102 >> 31)) ^ r102);
    }

    public static void pointWise(short[] r100, short[] r101, short[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 1024) goto L6;
        r102[r103] = Reduce.montgomery((r100[r103] & 65535) * (65535 & Reduce.montgomery((r101[r103] & 65535) * 3186)));
        r103 = r103 + 1;
        goto L4
    }

    public static void toBytes(byte[] r100, short[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= 256) goto L6;
        int r103 = r102 * 4;
        short r104 = normalize(r101[r103 + 0]);
        short r105 = normalize(r101[r103 + 1]);
        short r106 = normalize(r101[r103 + 2]);
        short r107 = normalize(r101[r103 + 3]);
        int r108 = r102 * 7;
        r100[r108 + 0] = (byte) r104;
        r100[r108 + 1] = (byte) ((r104 >> 8) | (r105 << 6));
        r100[r108 + 2] = (byte) (r105 >> 2);
        r100[r108 + 3] = (byte) ((r105 >> 10) | (r106 << 4));
        r100[r108 + 4] = (byte) (r106 >> 4);
        r100[r108 + 5] = (byte) ((r106 >> 12) | (r107 << 2));
        r100[r108 + 6] = (byte) (r107 >> 6);
        r102 = r102 + 1;
        goto L4
    }

    public static void toNTT(short[] r100) {
        NTT.mulCoefficients(r100, Precomp.PSIS_BITREV_MONTGOMERY);
        NTT.core(r100, Precomp.OMEGAS_MONTGOMERY);
    }

    public static void uniform(short[] r100, byte[] r101) {
        SHAKEDigest r102 = new SHAKEDigest(128);
        r102.update(r101, 0, r101.length);
        int r103 = 0;
    L3:
        byte[] r104 = new byte[256];
        r102.doOutput(r104, 0, 256);
        int r105 = 0;
    L4:
        if (r105 >= 256) goto L3;
        int r106 = (r104[r105] & UByte.MAX_VALUE) | ((r104[r105 + 1] & UByte.MAX_VALUE) << 8);
        if (r106 >= 61445) goto L11;
        int r107 = r103 + 1;
        r100[r103] = (short) r106;
        if (r107 == 1024) goto L9;
        r103 = r107;
        goto L11
    L9:
        return;
    L11:
        r105 = r105 + 2;
        goto L4
    }
}
