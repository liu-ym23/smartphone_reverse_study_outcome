package hk4;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.dora.protocol.LinkWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttm.player.MediaPlayer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f485569a = null;

    static {
        f485569a = new int[]{0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, MediaPlayer.MEDIA_PLAYER_OPTION_MULTISTREAM_SHOULD_CHECK_BUFFER_STATE, TECameraUtils.CAPTURE_NORMAL, 51009, 1280, 50625, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DYNAMICFRAMEDROPPING_CHECKPERIOD, DownloadErrorCode.ERROR_MAX_BYTE_LIMIT, 52225, TECameraUtils.CAPTURE_HQ_3X, 3456, 52545, 3840, 53185, 52865, 3648, TECameraUtils.CAPTURE_HQ_2X, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, BmLocated.HALF_LEFT_TOP, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_RENDER_EXCEPTION, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};
    }

    public static byte[] a(byte[] r110) {
        byte r100 = r110[0];
        byte r101 = r110[1];
        byte r102 = r110[2];
        byte r103 = r110[3];
        if (r103 != 32) goto L5;
        byte[] r111 = {r110[4], r110[5]};
        int r112 = 6;
    L6:
        int r113 = r112 + 1;
        byte r114 = r110[r112];
        int r115 = r113 + 1;
        byte r116 = r110[r113];
        if (r114 == 0) goto L249;
        if (r114 == 1) goto L158;
        if (r114 == 2) goto L101;
        if (r114 == 4) goto L65;
        if (r114 == 32) goto L39;
        if (r114 != 43) goto L254;
        int r104 = r116 & UByte.MAX_VALUE;
        if (r104 != 4) goto L20;
    L25:
        if (r111 != null) goto L27;
        int r105 = 2;
    L28:
        byte[] r106 = new byte[r105 + r115];
        r106[0] = r100;
        int r107 = (r110.length - r115) - 2;
        byte[] r108 = new byte[r107];
        System.arraycopy(r110, r115, r108, 0, r107);
        int r109 = (r115 - 3) + r107;
        if (r111 != null) goto L31;
        int r117 = 2;
    L32:
        int r118 = r109 + r117;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r118 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r104);
        r106[1] = (byte) ((r118 & 65280) >>> 8);
        r106[2] = (byte) (r118 & 255);
        if (r111 == null) goto L35;
        r106[3] = r103;
        char r119 = 0;
        r106[4] = r111[0];
        r106[5] = r111[1];
    L36:
        r106[6] = r114;
        r106[7] = r116;
        byte[] r120 = pk4.n.u(r106, r108);
        int r121 = b(r120);
        byte[] r122 = new byte[2];
        r122[r119] = (byte) ((r121 & 65280) >>> 8);
        r122[1] = (byte) (r121 & 255);
        return pk4.n.u(r120, r122);
    L35:
        r119 = 0;
        r106[3] = 32;
        r106[4] = 0;
        r106[5] = 0;
        goto L36
    L31:
        r117 = 0;
        goto L32
    L27:
        r105 = 0;
        goto L28
    L20:
        if (r104 == 42) goto L25;
        if (r104 == 180) goto L25;
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r116 + " ,sid : " + r114);
    L254:
        if (r111 == null) goto L257;
        c(r100, r111, r114, r116);
    L257:
        return new byte[0];
    L39:
        if (r116 != 3) goto L63;
        if (r111 != null) goto L42;
        int r123 = 2;
    L43:
        byte[] r124 = new byte[r123 + r115];
        r124[0] = r100;
        int r125 = (r110.length - r115) - 2;
        byte[] r126 = new byte[r125];
        System.arraycopy(r110, r115, r126, 0, r125);
        if (r125 <= 0) goto L46;
        byte r127 = r126[0];
    L48:
        if ((r127 & UByte.MAX_VALUE) == 132) goto L53;
        if (r111 == null) goto L52;
        c(r100, r111, r114, r116);
    L52:
        return new byte[0];
    L53:
        int r128 = (r115 - 3) + r125;
        if (r111 != null) goto L56;
        int r129 = 2;
    L57:
        int r130 = r128 + r129;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r130 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r124[1] = (byte) ((r130 & 65280) >>> 8);
        r124[2] = (byte) (r130 & 255);
        if (r111 == null) goto L60;
        r124[3] = r103;
        char r131 = 0;
        r124[4] = r111[0];
        r124[5] = r111[1];
    L61:
        r124[6] = r114;
        r124[7] = r116;
        byte[] r132 = pk4.n.u(r124, r126);
        int r133 = b(r132);
        byte[] r134 = new byte[2];
        r134[r131] = (byte) ((r133 & 65280) >>> 8);
        r134[1] = (byte) (r133 & 255);
        return pk4.n.u(r132, r134);
    L60:
        r131 = 0;
        r124[3] = 32;
        r124[4] = 0;
        r124[5] = 0;
        goto L61
    L56:
        r129 = 0;
        goto L57
    L46:
        r127 = 0;
        goto L48
    L42:
        r123 = 0;
        goto L43
    L63:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r116 + " ,sid : " + r114);
        goto L254
    L65:
        if (r116 != 7) goto L99;
        if (r111 != null) goto L68;
        int r135 = 2;
    L69:
        byte[] r136 = new byte[r135 + r115];
        r136[0] = r100;
        int r137 = (r110.length - r115) - 2;
        byte[] r138 = new byte[r137];
        System.arraycopy(r110, r115, r138, 0, r137);
        if (r137 <= 0) goto L72;
        byte r139 = r138[0];
    L74:
        if (r139 != 1) goto L76;
    L83:
        boolean r140 = true;
    L84:
        if (r140 == true) goto L89;
        if (r111 == null) goto L88;
        c(r100, r111, r114, r116);
    L88:
        return new byte[0];
    L89:
        int r141 = (r115 - 3) + r137;
        if (r111 != null) goto L92;
        int r142 = 2;
    L93:
        int r143 = r141 + r142;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r143 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r136[1] = (byte) ((r143 & 65280) >>> 8);
        r136[2] = (byte) (r143 & 255);
        if (r111 == null) goto L96;
        r136[3] = r103;
        char r144 = 0;
        r136[4] = r111[0];
        r136[5] = r111[1];
    L97:
        r136[6] = r114;
        r136[7] = r116;
        byte[] r145 = pk4.n.u(r136, r138);
        int r146 = b(r145);
        byte[] r147 = new byte[2];
        r147[r144] = (byte) ((r146 & 65280) >>> 8);
        r147[1] = (byte) (r146 & 255);
        return pk4.n.u(r145, r147);
    L96:
        r144 = 0;
        r136[3] = 32;
        r136[4] = 0;
        r136[5] = 0;
        goto L97
    L92:
        r142 = 0;
        goto L93
    L76:
        if (r139 == 2) goto L83;
        if (r139 == 3) goto L83;
        if (r139 == 4) goto L83;
        r140 = false;
        goto L84
    L72:
        r139 = 0;
        goto L74
    L68:
        r135 = 0;
        goto L69
    L99:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r116 + " ,sid : " + r114);
        goto L254
    L101:
        if (r116 != 1) goto L116;
        if (r111 != null) goto L104;
        int r148 = 2;
    L105:
        byte[] r149 = new byte[r148 + r115];
        r149[0] = r100;
        byte[] r150 = {1, 0, 2, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0, 10, 0};
        int r151 = (r115 - 3) + 18;
        if (r111 != null) goto L108;
        int r152 = 2;
    L109:
        int r153 = r151 + r152;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r153 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r149[1] = (byte) ((r153 & 65280) >>> 8);
        r149[2] = (byte) (r153 & 255);
        if (r111 == null) goto L112;
        r149[3] = r103;
        char r154 = 0;
        r149[4] = r111[0];
        r149[5] = r111[1];
    L113:
        r149[6] = r114;
        r149[7] = r116;
        byte[] r155 = pk4.n.u(r149, r150);
        int r156 = b(r155);
        byte[] r157 = new byte[2];
        r157[r154] = (byte) ((r156 & 65280) >>> 8);
        r157[1] = (byte) (r156 & 255);
        return pk4.n.u(r155, r157);
    L112:
        r154 = 0;
        r149[3] = 32;
        r149[4] = 0;
        r149[5] = 0;
        goto L113
    L108:
        r152 = 0;
        goto L109
    L104:
        r148 = 0;
        goto L105
    L116:
        if (r116 != 5) goto L156;
        if (r111 != null) goto L119;
        int r158 = 2;
    L120:
        byte[] r159 = new byte[r158 + r115];
        r159[0] = r100;
        int r160 = (r110.length - r115) - 2;
        byte[] r161 = new byte[r160];
        System.arraycopy(r110, r115, r161, 0, r160);
        byte r162 = r161[0];
        if (r162 != 1) goto L124;
        String r163 = "对外 cid 0x05, type=TTS, data=" + pk4.n.e(r161);
    L141:
        pk4.j.d("ProtocolAdapter", r163);
        int r164 = (r115 - 3) + r161.length;
        if (r111 != null) goto L144;
        int r165 = 2;
    L145:
        int r166 = r164 + r165;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r166 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r159[1] = (byte) ((r166 & 65280) >>> 8);
        r159[2] = (byte) (r166 & 255);
        if (r111 == null) goto L148;
        r159[3] = r103;
        char r167 = 0;
        r159[4] = r111[0];
        r159[5] = r111[1];
    L149:
        r159[6] = r114;
        r159[7] = r116;
        byte[] r168 = pk4.n.u(r159, r161);
        int r169 = b(r168);
        byte[] r170 = new byte[2];
        r170[r167] = (byte) ((r169 & 65280) >>> 8);
        r170[1] = (byte) (r169 & 255);
        return pk4.n.u(r168, r170);
    L148:
        r167 = 0;
        r159[3] = 32;
        r159[4] = 0;
        r159[5] = 0;
        goto L149
    L144:
        r165 = 0;
        goto L145
    L124:
        if (r162 != 5) goto L127;
        r163 = "对外 cid 0x05, type=ASR, data=" + pk4.n.e(r161);
        goto L141
    L127:
        if (r162 != 3) goto L133;
        String r171 = pk4.n.e(r161);
        if (r160 <= 3) goto L131;
        r161 = new byte[]{r161[0], 1, r161[2]};
    L131:
        r163 = "对外 cid 0x05, type=VUI_STOP, src=" + r171 + ", dst=" + pk4.n.e(r161);
        goto L141
    L133:
        if (r162 != 11) goto L136;
        r163 = "对外 cid 0x05, type=KWS_RESULT, data=" + pk4.n.e(r161);
        goto L141
    L136:
        if (r162 != 45) goto L139;
        r163 = "对外 cid 0x05, type=PLAY, data=" + pk4.n.e(r161);
        goto L141
    L139:
        if (r162 != 6) goto L152;
        r163 = "对外 cid 0x05, type=VUI, data=" + pk4.n.e(r161);
        goto L141
    L152:
        if (r111 == null) goto L155;
        c(r100, r111, r114, r116);
    L155:
        return new byte[0];
    L119:
        r158 = 0;
        goto L120
    L156:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r116 + " ,sid : " + r114);
        goto L254
    L158:
        if (r116 != 2) goto L173;
        if (r111 != null) goto L161;
        int r172 = 2;
    L162:
        byte[] r173 = new byte[r172 + r115];
        r173[0] = r100;
        byte[] r174 = {1, 0, 2, 0, 3, 0, 5, 0, 7, 0, 8, 0, 10, 0, 11, 0, 17, 0, 16, 0};
        int r175 = (r115 - 3) + 20;
        if (r111 != null) goto L165;
        int r176 = 2;
    L166:
        int r177 = r175 + r176;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r177 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r173[1] = (byte) ((r177 & 65280) >>> 8);
        r173[2] = (byte) (r177 & 255);
        if (r111 == null) goto L169;
        r173[3] = r103;
        char r178 = 0;
        r173[4] = r111[0];
        r173[5] = r111[1];
    L170:
        r173[6] = r114;
        r173[7] = r116;
        byte[] r179 = pk4.n.u(r173, r174);
        int r180 = b(r179);
        byte[] r181 = new byte[2];
        r181[r178] = (byte) ((r180 & 65280) >>> 8);
        r181[1] = (byte) (r180 & 255);
        return pk4.n.u(r179, r181);
    L169:
        r178 = 0;
        r173[3] = 32;
        r173[4] = 0;
        r173[5] = 0;
        goto L170
    L165:
        r176 = 0;
        goto L166
    L161:
        r172 = 0;
        goto L162
    L173:
        if (r116 != 3) goto L188;
        if (r111 != null) goto L176;
        int r182 = 2;
    L177:
        byte[] r183 = new byte[r182 + r115];
        r183[0] = r100;
        byte[] r184 = pk4.n.u(new byte[]{1, 0, 2, 0, 3, 0, 5, 0, 8, 0, 4, 8}, pk4.n.m(System.currentTimeMillis()));
        int r185 = (r115 - 3) + r184.length;
        if (r111 != null) goto L180;
        int r186 = 2;
    L181:
        int r187 = r185 + r186;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r187 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r183[1] = (byte) ((r187 & 65280) >>> 8);
        r183[2] = (byte) (r187 & 255);
        if (r111 == null) goto L184;
        r183[3] = r103;
        char r188 = 0;
        r183[4] = r111[0];
        r183[5] = r111[1];
    L185:
        r183[6] = r114;
        r183[7] = r116;
        byte[] r189 = pk4.n.u(r183, r184);
        int r190 = b(r189);
        byte[] r191 = new byte[2];
        r191[r188] = (byte) ((r190 & 65280) >>> 8);
        r191[1] = (byte) (r190 & 255);
        return pk4.n.u(r189, r191);
    L184:
        r188 = 0;
        r183[3] = 32;
        r183[4] = 0;
        r183[5] = 0;
        goto L185
    L180:
        r186 = 0;
        goto L181
    L176:
        r182 = 0;
        goto L177
    L188:
        if (r116 != 4) goto L209;
        if (r111 != null) goto L191;
        int r192 = 2;
    L192:
        byte[] r193 = new byte[r192 + r115];
        r193[0] = r100;
        int r194 = (r110.length - r115) - 2;
        byte[] r195 = new byte[r194];
        System.arraycopy(r110, r115, r195, 0, r194);
        if (r195[0] != 32) goto L204;
        r195[0] = 32;
        int r196 = (r115 - 3) + r194;
        if (r111 != null) goto L197;
        int r197 = 2;
    L198:
        int r198 = r196 + r197;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r198 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r193[1] = (byte) ((r198 & 65280) >>> 8);
        r193[2] = (byte) (r198 & 255);
        if (r111 == null) goto L201;
        r193[3] = r103;
        char r199 = 0;
        r193[4] = r111[0];
        r193[5] = r111[1];
    L202:
        r193[6] = r114;
        r193[7] = r116;
        byte[] r200 = pk4.n.u(r193, r195);
        int r201 = b(r200);
        byte[] r202 = new byte[2];
        r202[r199] = (byte) ((r201 & 65280) >>> 8);
        r202[1] = (byte) (r201 & 255);
        return pk4.n.u(r200, r202);
    L201:
        r199 = 0;
        r193[3] = 32;
        r193[4] = 0;
        r193[5] = 0;
        goto L202
    L197:
        r197 = 0;
        goto L198
    L204:
        if (r111 == null) goto L207;
        c(r100, r111, r114, r116);
    L207:
        return new byte[0];
    L191:
        r192 = 0;
        goto L192
    L209:
        if (r116 != 6) goto L234;
        if (r111 != null) goto L212;
        int r1100 = 2;
    L213:
        byte[] r203 = new byte[r115 + r1100];
        r203[0] = r100;
        int r204 = (r110.length - r115) - 2;
        byte[] r1101 = new byte[r204];
        System.arraycopy(r110, r115, r1101, 0, r204);
        byte r205 = r1101[0];
        if (r205 != 10) goto L217;
        r1101[0] = 10;
    L219:
        int r206 = (r115 - 3) + r204;
        if (r111 != null) goto L222;
        int r207 = 2;
    L223:
        int r208 = r206 + r207;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r208 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r203[1] = (byte) ((r208 & 65280) >>> 8);
        r203[2] = (byte) (r208 & 255);
        if (r111 == null) goto L226;
        r203[3] = r103;
        char r209 = 0;
        r203[4] = r111[0];
        r203[5] = r111[1];
    L227:
        r203[6] = r114;
        r203[7] = r116;
        byte[] r210 = pk4.n.u(r203, r1101);
        int r211 = b(r210);
        byte[] r212 = new byte[2];
        r212[r209] = (byte) ((r211 & 65280) >>> 8);
        r212[1] = (byte) (r211 & 255);
        return pk4.n.u(r210, r212);
    L226:
        r209 = 0;
        r203[3] = 32;
        r203[4] = 0;
        r203[5] = 0;
        goto L227
    L222:
        r207 = 0;
        goto L223
    L217:
        if (r205 != 11) goto L229;
        r1101[0] = 11;
        goto L219
    L229:
        if (r111 == null) goto L232;
        c(r100, r111, r114, r116);
    L232:
        return new byte[0];
    L212:
        r1100 = 0;
        goto L213
    L234:
        if (r116 != 9) goto L248;
        if (r111 != null) goto L237;
        int r1102 = 2;
    L238:
        byte[] r213 = new byte[r115 + r1102];
        r213[0] = r100;
        int r214 = (r110.length - r115) - 2;
        byte[] r215 = new byte[r214];
        System.arraycopy(r110, r115, r215, 0, r214);
        int r1103 = (r115 - 3) + r214;
        if (r111 != null) goto L241;
        int r216 = 2;
    L242:
        int r1104 = r1103 + r216;
        pk4.j.d("ProtocolAdapter", "UserOperation : " + pk4.n.e(r215));
        r213[1] = (byte) ((r1104 & 65280) >>> 8);
        r213[2] = (byte) (r1104 & 255);
        if (r111 == null) goto L245;
        r213[3] = r103;
        char r217 = 0;
        r213[4] = r111[0];
        r213[5] = r111[1];
    L246:
        r213[6] = r114;
        r213[7] = r116;
        byte[] r218 = pk4.n.u(r213, r215);
        int r219 = b(r218);
        byte[] r220 = new byte[2];
        r220[r217] = (byte) ((r219 & 65280) >>> 8);
        r220[1] = (byte) (r219 & 255);
        return pk4.n.u(r218, r220);
    L245:
        r217 = 0;
        r213[3] = 32;
        r213[4] = 0;
        r213[5] = 0;
        goto L246
    L241:
        r216 = 0;
        goto L242
    L237:
        r1102 = 0;
        goto L238
    L248:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r116 + " ,sid : " + r114);
        goto L254
    L249:
        if (r116 == 1) goto L259;
        if (r116 == 2) goto L259;
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r116 + " ,sid : " + r114);
    L259:
        if (r111 != null) goto L261;
        int r1105 = 2;
    L262:
        byte[] r221 = new byte[r115 + r1105];
        r221[0] = r100;
        int r222 = (r110.length - r115) - 2;
        byte[] r223 = new byte[r222];
        System.arraycopy(r110, r115, r223, 0, r222);
        int r224 = (r115 - 3) + r222;
        if (r111 != null) goto L265;
        int r1106 = 2;
    L266:
        int r225 = r224 + r1106;
        pk4.j.d("ProtocolAdapter", "payload new length = " + r225 + " ,header length = " + r115 + " ,sid : " + r114 + " ,cid : " + r116);
        r221[1] = (byte) ((r225 & 65280) >>> 8);
        r221[2] = (byte) (r225 & 255);
        if (r111 == null) goto L269;
        r221[3] = r103;
        char r226 = 0;
        r221[4] = r111[0];
        r221[5] = r111[1];
    L270:
        r221[6] = r114;
        r221[7] = r116;
        byte[] r227 = pk4.n.u(r221, r223);
        int r228 = b(r227);
        byte[] r229 = new byte[2];
        r229[r226] = (byte) ((r228 & 65280) >>> 8);
        r229[1] = (byte) (r228 & 255);
        return pk4.n.u(r227, r229);
    L269:
        r226 = 0;
        r221[3] = 32;
        r221[4] = 0;
        r221[5] = 0;
        goto L270
    L265:
        r1106 = 0;
        goto L266
    L261:
        r1105 = 0;
        goto L262
    L5:
        r111 = null;
        r112 = 4;
        goto L6
    }

    public static int b(byte[] r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        byte r104 = r100[r102];
        int r105 = r103 >>> 8;
        r103 = f485569a[(r103 ^ r104) & 255] ^ r105;
        r102 = r102 + 1;
        goto L3
    L5:
        return r103;
    }

    public static boolean d(int r110, int r111, byte[] r112) {
        boolean r100 = false;
        if (r110 != 0) goto L5;
        if (r111 == 1) goto L94;
        if (r111 == 2) goto L94;
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r111 + " ,sid : " + r110);
        return true;
    L94:
        return false;
    L5:
        if (r110 == 1) goto L69;
        if (r110 == 2) goto L48;
        if (r110 == 4) goto L34;
        if (r110 != 32) goto L11;
        if (r111 != 3) goto L31;
        if (r112 == null) goto L31;
        if (r112.length <= 0) goto L31;
        if ((r112[0] & UByte.MAX_VALUE) == 132) goto L95;
        return true;
    L95:
        return false;
    L31:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r111 + " ,sid : " + r110);
        return true;
    L11:
        if (r110 == 43) goto L13;
        return true;
    L13:
        int r113 = r111 & 255;
        if (r113 != 4) goto L16;
    L22:
        return false;
    L16:
        if (r113 == 42) goto L22;
        if (r113 == 180) goto L22;
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r111 + " ,sid : " + r110);
        return true;
    L34:
        if (r111 != 7) goto L46;
        if (r112 == null) goto L46;
        if (r112.length <= 0) goto L46;
        byte r114 = r112[0];
        if (r114 == 1) goto L43;
        if (r114 == 2) goto L43;
        if (r114 == 3) goto L43;
        if (r114 == 4) goto L43;
    L45:
        return !r100;
    L43:
        r100 = true;
    L46:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r111 + " ,sid : " + r110);
        return true;
    L48:
        if (r111 != 1) goto L51;
        return false;
    L51:
        if (r111 != 5) goto L67;
        if (r112 == null) goto L67;
        if (r112.length <= 0) goto L67;
        byte r115 = r112[0];
        if (r115 == 1) goto L66;
        if (r115 == 5) goto L66;
        if (r115 == 6) goto L66;
        if (r115 == 11) goto L66;
        if (r115 == 45) goto L66;
        if (r115 == 3) goto L66;
        pk4.j.f("ProtocolAdapter", "isHUnSupportCommand type = " + r115 + " ,sid : " + r110 + " ,cid : " + r111);
        return true;
    L66:
        return false;
    L67:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r111 + " ,sid : " + r110);
        return true;
    L69:
        if (r111 == 2) goto L88;
        if (r111 == 3) goto L88;
        if (r111 == 9) goto L88;
        if (r111 == 4) goto L88;
        if (r111 != 6) goto L86;
        if (r112 == null) goto L86;
        if (r112.length <= 0) goto L86;
        byte r116 = r112[0];
        if (r116 == 10) goto L85;
        if (r116 == 11) goto L85;
        pk4.j.f("ProtocolAdapter", "isHUnSupportCommand type = " + r116 + " ,sid : " + r110 + " ,cid : " + r111);
        return true;
    L85:
        return false;
    L86:
        pk4.j.d("ProtocolAdapter", "external protocol not support this cid = " + r111 + " ,sid : " + r110);
        return true;
    L88:
        return false;
    }

    public static void c(byte r100, byte[] r101, byte r102, byte r110) {
        byte[] r103 = {r100, (byte) 0, (byte) 8, 32, r101[0], r101[1], r102, r110, 2, 1, 1};
        byte[] r104 = new byte[13];
        System.arraycopy(r103, 0, r104, 0, 11);
        int r105 = b(r103);
        r104[11] = (byte) ((65280 & r105) >>> 8);
        r104[12] = (byte) (r105 & 255);
        pk4.j.d("ProtocolAdapter", "external protocol fake ack cid = " + r110 + " ,sid : " + r102 + " ,data : " + pk4.n.e(r104));
        LinkWrapper.rx(r104);
    }
}
