package g2c;

import com.ss.android.lark.qrcode.zxing.WriterException;
import com.ss.android.lark.qrcode.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ss.ttm.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f479777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f479778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f479779c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f479780d = null;

    static {
        f479777a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        f479778b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        f479779c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
        f479780d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    public static boolean f(int r100) {
        if (r100 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static int b(int r100, int r101) {
        if (r101 == 0) goto L9;
        int r102 = 32 - Integer.numberOfLeadingZeros(r101);
        int r103 = r100 << (r102 - 1);
    L5:
        if ((32 - Integer.numberOfLeadingZeros(r103)) < r102) goto L7;
        r103 = r103 ^ (r101 << ((32 - Integer.numberOfLeadingZeros(r103)) - r102));
        goto L5
    L7:
        return r103;
    L9:
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void c(int r100, int r101, b r102) throws WriterException {
        int r103 = 0;
    L4:
        if (r103 >= 8) goto L10;
        int r104 = r100 + r103;
        if (f(r102.a(r104, r101)) == false) goto L9;
        r102.b(r104, r101, 0);
        r103 = r103 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    public static void d(int r100, int r101, b r110) {
        int r102 = 0;
    L4:
        if (r102 >= 7) goto L9;
        int[] r103 = f479777a[r102];
        int r104 = 0;
    L6:
        if (r104 >= 7) goto L8;
        r110.b(r100 + r104, r101 + r102, r103[r104]);
        r104 = r104 + 1;
        goto L6
    L8:
        r102 = r102 + 1;
        goto L4
    }

    public static void e(int r100, int r101, b r102) throws WriterException {
        int r103 = 0;
    L4:
        if (r103 >= 7) goto L10;
        int r104 = r101 + r103;
        if (f(r102.a(r100, r104)) == false) goto L9;
        r102.b(r100, r104, 0);
        r103 = r103 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    public static void a(d2c.a r210, ErrorCorrectionLevel r211, com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r212, int r213, b r214) throws WriterException {
        byte[][] r100 = r214.f479772a;
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L6;
        Arrays.fill(r100[r102], (byte) -1);
        r102 = r102 + 1;
        goto L4
    L6:
        int r103 = f479777a[0].length;
        d(0, 0, r214);
        d(r214.f479773b - r103, 0, r214);
        d(0, r214.f479773b - r103, r214);
        c(0, 7, r214);
        c(r214.f479773b - 8, 7, r214);
        c(0, r214.f479773b - 8, r214);
        e(7, 0, r214);
        e((r214.f479774c - 7) - 1, 0, r214);
        e(7, r214.f479774c - 7, r214);
        if (r214.a(8, r214.f479774c - 8) == 0) goto L129;
        r214.b(8, r214.f479774c - 8, 1);
        int r104 = r212.f439120a;
        int r110 = 5;
        if (r104 < 2) goto L29;
        int[] r105 = f479779c[r104 - 1];
        int r111 = r105.length;
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L29;
        int r113 = r105[r112];
        if (r113 < 0) goto L28;
        int r114 = r105.length;
        int r106 = 0;
    L16:
        if (r106 >= r114) goto L28;
        int r115 = r105[r106];
        if (r115 < 0) goto L27;
        if (f(r214.a(r115, r113)) == false) goto L27;
        int r116 = r115 - 2;
        int r117 = r113 - 2;
        int r107 = 0;
    L22:
        if (r107 >= r110) goto L27;
        int[] r118 = f479778b[r107];
        int r108 = 0;
    L24:
        if (r108 >= r110) goto L26;
        r214.b(r116 + r108, r117 + r107, r118[r108]);
        r108 = r108 + 1;
        r110 = 5;
        goto L24
    L26:
        r107 = r107 + 1;
        r110 = 5;
    L27:
        r106 = r106 + 1;
        r110 = 5;
    L28:
        r112 = r112 + 1;
        r110 = 5;
    L29:
        int r109 = 8;
    L31:
        if (r109 >= (r214.f479773b - 8)) goto L39;
        int r119 = r109 + 1;
        int r120 = r119 % 2;
        if (f(r214.a(r109, 6)) == false) goto L36;
        r214.b(r109, 6, r120);
    L36:
        if (f(r214.a(6, r109)) == false) goto L38;
        r214.b(6, r109, r120);
    L38:
        r109 = r119;
        goto L31
    L39:
        d2c.a r121 = new d2c.a();
        if (r213 >= 0) goto L42;
    L44:
        boolean r122 = false;
    L45:
        if (r122 == false) goto L127;
        int r123 = (r211.getBits() << 3) | r213;
        r121.b(r123, 5);
        r121.b(b(r123, MediaPlayer.MEDIA_PLAYER_OPTION_THREAD_RUN_REFACTOR), 10);
        d2c.a r124 = new d2c.a();
        r124.b(21522, 15);
        if (r121.f466580b != r124.f466580b) goto L125;
        int r125 = 0;
    L49:
        int[] r126 = r121.f466579a;
        if (r125 >= r126.length) goto L53;
        r126[r125] = r126[r125] ^ r124.f466579a[r125];
        r125 = r125 + 1;
        goto L49
    L53:
        if (r121.f466580b != 15) goto L123;
        int r127 = 0;
    L55:
        int r128 = r121.f466580b;
        if (r127 >= r128) goto L63;
        boolean r129 = r121.d((r128 - 1) - r127);
        int[] r130 = f479780d[r127];
        r214.c(r130[0], r130[1], r129);
        if (r127 >= 8) goto L60;
        r214.c((r214.f479773b - r127) - 1, 8, r129);
    L61:
        r127 = r127 + 1;
        goto L55
    L60:
        r214.c(8, (r214.f479774c - 7) + (r127 - 8), r129);
        goto L61
    L63:
        if (r212.f439120a < 7) goto L73;
        d2c.a r131 = new d2c.a();
        r131.b(r212.f439120a, 6);
        r131.b(b(r212.f439120a, 7973), 12);
        if (r131.f466580b != 18) goto L121;
        int r132 = 17;
        int r133 = 0;
    L68:
        if (r133 >= 6) goto L73;
        int r134 = 0;
    L70:
        if (r134 >= 3) goto L72;
        boolean r135 = r131.d(r132);
        r132 = r132 - 1;
        r214.c(r133, (r214.f479774c - 11) + r134, r135);
        r214.c((r214.f479774c - 11) + r134, r133, r135);
        r134 = r134 + 1;
        goto L70
    L72:
        r133 = r133 + 1;
        goto L68
    L121:
        throw new WriterException("should not happen but we got: " + r131.f466580b);
    L73:
        int r136 = r214.f479773b - 1;
        int r137 = r214.f479774c - 1;
        int r138 = 0;
        int r139 = -1;
    L74:
        if (r136 <= 0) goto L116;
        if (r136 != 6) goto L77;
        r136 = r136 - 1;
    L77:
        if (r137 < 0) goto L114;
        if (r137 >= r214.f479774c) goto L114;
        int r140 = 0;
    L81:
        if (r140 >= 2) goto L113;
        int r141 = r136 - r140;
        if (f(r214.a(r141, r137)) == true) goto L86;
    L112:
        r140 = r140 + 1;
        goto L81
    L86:
        if (r138 >= r210.f466580b) goto L88;
        boolean r142 = r210.d(r138);
        r138 = r138 + 1;
    L90:
        if (r213 == (-1)) goto L111;
        switch(r213) {
            case 0: goto L102;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            default: goto L93;
        };
    L94:
        int r143 = (r137 * r141) % 3;
        int r144 = (r137 + r141) & 1;
    L103:
        int r145 = r143 + r144;
    L104:
        int r146 = r145 & 1;
    L105:
        if (r146 != 0) goto L107;
        boolean r147 = true;
    L108:
        if (r147 == false) goto L111;
        r142 = !r142;
        goto L111
    L107:
        r147 = false;
        goto L108
    L95:
        int r148 = r137 * r141;
        r144 = r148 & 1;
        r143 = r148 % 3;
        goto L103
    L96:
        int r149 = r137 * r141;
        r146 = (r149 % 3) + (r149 & 1);
        goto L105
    L97:
        r143 = r137 / 2;
        r144 = r141 / 3;
        goto L103
    L98:
        r146 = (r137 + r141) % 3;
        goto L105
    L99:
        r146 = r141 % 3;
        goto L105
    L101:
        r145 = r137;
        goto L104
    L102:
        r143 = r137;
        r144 = r141;
        goto L103
    L93:
        throw new IllegalArgumentException("Invalid mask pattern: " + r213);
    L111:
        r214.c(r141, r137, r142);
        goto L112
    L88:
        r142 = false;
        goto L90
    L113:
        r137 = r137 + r139;
    L114:
        r139 = -r139;
        r137 = r137 + r139;
        r136 = r136 - 2;
        goto L74
    L116:
        if (r138 != r210.f466580b) goto L119;
        return;
    L119:
        throw new WriterException("Not all bits consumed: " + r138 + '/' + r210.f466580b);
    L123:
        throw new WriterException("should not happen but we got: " + r121.f466580b);
    L125:
        throw new IllegalArgumentException("Sizes don't match");
    L127:
        throw new WriterException("Invalid mask pattern");
    L42:
        if (r213 >= 8) goto L44;
        r122 = true;
        goto L45
    L129:
        throw new WriterException();
    }
}
