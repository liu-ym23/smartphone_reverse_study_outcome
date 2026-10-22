package org.bouncycastle.pqc.crypto.newhope;

import com.obric.sva.sdk.data.ISmModel;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class ErrorCorrection {
    public ErrorCorrection() {
    }

    public static short LDDecode(int r100, int r101, int r102, int r103) {
        return (short) (((((g(r100) + g(r101)) + g(r102)) + g(r103)) - 98312) >>> 31);
    }

    public static int abs(int r100) {
        int r101 = r100 >> 31;
        return (r100 ^ r101) - r101;
    }

    public static int f(int[] r100, int r101, int r102, int r103) {
        int r104 = (r103 * 2730) >> 25;
        int r105 = r104 - ((12288 - (r103 - (r104 * 12289))) >> 31);
        r100[r101] = (r105 >> 1) + (r105 & 1);
        int r106 = r105 - 1;
        r100[r102] = (r106 >> 1) + (r106 & 1);
        return abs(r103 - ((r100[r101] * 2) * 12289));
    }

    public static int g(int r100) {
        int r101 = (r100 * 2730) >> 27;
        int r102 = r101 - ((49155 - (r100 - (49156 * r101))) >> 31);
        int r103 = r102 & 1;
        return abs((((r102 >> 1) + r103) * 98312) - r100);
    }

    public static void helpRec(short[] r110, short[] r111, byte[] r210, byte r211) {
        byte[] r100 = new byte[8];
        r100[0] = r211;
        byte[] r101 = new byte[32];
        ChaCha20.process(r210, r100, r101, 0, 32);
        int[] r102 = new int[8];
        int r103 = 0;
    L4:
        if (r103 >= 256) goto L6;
        int r104 = (r101[r103 >>> 3] >>> (r103 & 7)) & 1;
        int r105 = r103 + 0;
        int r106 = r104 * 4;
        int r112 = r103 + 256;
        int r107 = f(r102, 0, 4, (r111[r105] * 8) + r106) + f(r102, 1, 5, (r111[r112] * 8) + r106);
        int r113 = r103 + 512;
        int r108 = r107 + f(r102, 2, 6, (r111[r113] * 8) + r106);
        int r114 = r103 + ISmModel.VERSION_0300;
        int r109 = (24577 - (r108 + f(r102, 3, 7, (r111[r114] * 8) + r106))) >> 31;
        int r115 = ~r109;
        int r116 = (r115 & r102[0]) ^ (r102[4] & r109);
        int r117 = (r102[1] & r115) ^ (r102[5] & r109);
        int r118 = (r102[2] & r115) ^ (r109 & r102[6]);
        int r119 = (r115 & r102[3]) ^ (r102[7] & r109);
        r110[r105] = (short) ((r116 - r119) & 3);
        r110[r112] = (short) ((r117 - r119) & 3);
        r110[r113] = (short) ((r118 - r119) & 3);
        r110[r114] = (short) (3 & ((-r109) + (r119 * 2)));
        r103 = r103 + 1;
        goto L4
    }

    public static void rec(byte[] r100, short[] r101, short[] r110) {
        int r102 = 0;
        Arrays.fill(r100, (byte) 0);
    L4:
        if (r102 >= 256) goto L6;
        int r103 = r102 + 0;
        int r104 = (r101[r103] * 8) + 196624;
        int r105 = r110[r103] * 2;
        int r106 = r102 + ISmModel.VERSION_0300;
        short r107 = r110[r106];
        int r108 = r104 - ((r105 + r107) * 12289);
        int r109 = r102 + 256;
        int r111 = ((r101[r109] * 8) + 196624) - (((r110[r109] * 2) + r107) * 12289);
        int r112 = r102 + 512;
        int r113 = ((r101[r112] * 8) + 196624) - (((r110[r112] * 2) + r107) * 12289);
        int r114 = ((r101[r106] * 8) + 196624) - (r107 * 12289);
        int r115 = r102 >>> 3;
        byte r116 = r100[r115];
        r100[r115] = (byte) ((LDDecode(r108, r111, r113, r114) << (r102 & 7)) | r116);
        r102 = r102 + 1;
        goto L4
    }
}
