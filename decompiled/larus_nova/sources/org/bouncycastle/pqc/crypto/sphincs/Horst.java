package org.bouncycastle.pqc.crypto.sphincs;

import com.obric.sva.sdk.data.ISmModel;
import com.ss.ttm.player.MediaPlayer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
class Horst {
    static final int HORST_K = 32;
    static final int HORST_LOGT = 16;
    static final int HORST_SIGBYTES = 13312;
    static final int HORST_SKBYTES = 32;
    static final int HORST_T = 65536;
    static final int N_MASKS = 32;

    public Horst() {
    }

    public static void expand_seed(byte[] r100, byte[] r101) {
        Seed.prg(r100, 0, 2097152, r101, 0);
    }

    public static int horst_sign(HashFunctions r210, byte[] r211, int r212, byte[] r213, byte[] r214, byte[] r215, byte[] r216) {
        byte[] r100 = new byte[2097152];
        byte[] r101 = new byte[4194272];
        expand_seed(r100, r214);
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= 65536) goto L6;
        r210.hash_n_n(r101, (65535 + r103) * 32, r100, r103 * 32);
        r103 = r103 + 1;
        goto L4
    L6:
        int r110 = 0;
    L8:
        if (r110 >= 16) goto L13;
        int r104 = 16 - r110;
        long r111 = (1 << r104) - 1;
        int r105 = 1 << (r104 - 1);
        long r106 = r105 - 1;
        int r107 = 0;
    L10:
        if (r107 >= r105) goto L12;
        r210.hash_2n_n_mask(r101, (int) ((((long) r107) + r106) * 32), r101, (int) ((((long) (r107 * 2)) + r111) * 32), r215, (r110 * 2) * 32);
        r107 = r107 + 1;
        r105 = r105;
        r106 = r106;
        goto L10
    L12:
        r110 = r110 + 1;
        goto L8
    L13:
        int r108 = r212;
        int r109 = 2016;
    L15:
        if (r109 >= 4064) goto L17;
        r211[r108] = r101[r109];
        r109 = r109 + 1;
        r108 = r108 + 1;
        goto L15
    L17:
        int r112 = 0;
    L18:
        if (r112 >= 32) goto L34;
        int r113 = r112 * 2;
        int r114 = (r216[r113] & UByte.MAX_VALUE) + ((r216[r113 + 1] & UByte.MAX_VALUE) << 8);
        int r115 = 0;
    L20:
        if (r115 >= 32) goto L22;
        r211[r108] = r100[(r114 * 32) + r115];
        r115 = r115 + 1;
        r108 = r108 + 1;
        goto L20
    L22:
        int r116 = r114 + 65535;
        int r117 = 0;
    L24:
        if (r117 >= 10) goto L33;
        if ((r116 & 1) == 0) goto L28;
        int r118 = r116 + 1;
    L29:
        int r119 = 0;
    L30:
        if (r119 >= 32) goto L32;
        r211[r108] = r101[(r118 * 32) + r119];
        r119 = r119 + 1;
        r108 = r108 + 1;
        goto L30
    L32:
        r116 = (r118 - 1) / 2;
        r117 = r117 + 1;
        goto L24
    L28:
        r118 = r116 - 1;
        goto L29
    L33:
        r112 = r112 + 1;
    L34:
        if (r102 >= 32) goto L36;
        r213[r102] = r101[r102];
        r102 = r102 + 1;
        goto L34
    L36:
        return HORST_SIGBYTES;
    }

    public static int horst_verify(HashFunctions r110, byte[] r210, byte[] r211, int r212, byte[] r213, byte[] r214) {
        byte[] r111 = new byte[1024];
        int r100 = r212 + 2048;
        int r112 = 0;
    L4:
        if (r112 >= 32) goto L36;
        int r101 = r112 * 2;
        int r102 = (r214[r101] & UByte.MAX_VALUE) + ((r214[r101 + 1] & UByte.MAX_VALUE) << 8);
        if ((r102 & 1) != 0) goto L10;
        r110.hash_n_n(r111, 0, r211, r100);
        int r103 = 0;
    L8:
        if (r103 >= 32) goto L13;
        r111[r103 + 32] = r211[(r100 + 32) + r103];
        r103 = r103 + 1;
    L13:
        int r113 = r100 + 64;
        int r104 = 1;
    L15:
        if (r104 >= 10) goto L25;
        int r114 = r102 >>> 1;
        if ((r114 & 1) != 0) goto L21;
        int r115 = r104;
        r110.hash_2n_n_mask(r111, 0, r111, 0, r213, ((r104 - 1) * 2) * 32);
        int r105 = 0;
    L19:
        if (r105 >= 32) goto L24;
        r111[r105 + 32] = r211[r113 + r105];
        r105 = r105 + 1;
    L24:
        r113 = r113 + 32;
        r104 = r115 + 1;
        r102 = r114;
        goto L15
    L21:
        r115 = r104;
        r110.hash_2n_n_mask(r111, 32, r111, 0, r213, ((r115 - 1) * 2) * 32);
        int r106 = 0;
    L22:
        if (r106 >= 32) goto L24;
        r111[r106] = r211[r113 + r106];
        r106 = r106 + 1;
        goto L22
    L25:
        int r116 = r102 >>> 1;
        r110.hash_2n_n_mask(r111, 0, r111, 0, r213, 576);
        int r107 = 0;
    L26:
        if (r107 >= 32) goto L35;
        if (r211[((r116 * 32) + r212) + r107] != r111[r107]) goto L29;
        r107 = r107 + 1;
        goto L26
    L29:
        int r108 = 0;
    L30:
        if (r108 >= 32) goto L32;
        r210[r108] = 0;
        r108 = r108 + 1;
        goto L30
    L32:
        return -1;
    L35:
        r112 = r112 + 1;
        r100 = r113;
        goto L4
    L10:
        r110.hash_n_n(r111, 32, r211, r100);
        int r109 = 0;
    L11:
        if (r109 >= 32) goto L13;
        r111[r109] = r211[(r100 + 32) + r109];
        r109 = r109 + 1;
        goto L11
    L36:
        int r117 = 0;
    L37:
        if (r117 >= 32) goto L39;
        r110.hash_2n_n_mask(r111, r117 * 32, r211, r212 + ((r117 * 2) * 32), r213, 640);
        r117 = r117 + 1;
        goto L37
    L39:
        int r118 = 0;
    L41:
        if (r118 >= 16) goto L43;
        r110.hash_2n_n_mask(r111, r118 * 32, r111, (r118 * 2) * 32, r213, 704);
        r118 = r118 + 1;
        goto L41
    L43:
        int r119 = 0;
    L44:
        if (r119 >= 8) goto L46;
        r110.hash_2n_n_mask(r111, r119 * 32, r111, (r119 * 2) * 32, r213, ISmModel.VERSION_0300);
        r119 = r119 + 1;
        goto L44
    L46:
        int r120 = 0;
    L48:
        if (r120 >= 4) goto L50;
        r110.hash_2n_n_mask(r111, r120 * 32, r111, (r120 * 2) * 32, r213, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_PRELOADING);
        r120 = r120 + 1;
        goto L48
    L50:
        int r121 = 0;
    L51:
        if (r121 >= 2) goto L53;
        r110.hash_2n_n_mask(r111, r121 * 32, r111, (r121 * 2) * 32, r213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT);
        r121 = r121 + 1;
        goto L51
    L53:
        r110.hash_2n_n_mask(r210, 0, r111, 0, r213, 960);
        return 0;
    }
}
