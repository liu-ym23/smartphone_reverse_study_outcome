package com.google.zxing.qrcode.encoder;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.ss.ttvideoengine.model.VideoRef;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f275999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f276000b = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f276001a = null;

        static {
            int[] r100 = new int[Mode.values().length];
            f276001a = r100;
            r100[Mode.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f276001a[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f276001a[Mode.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f276001a[Mode.KANJI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f275999a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
        f276000b = StandardCharsets.ISO_8859_1;
    }

    public static boolean c(String r100) {
        byte[] r101 = r100.getBytes(nv7.d.f520920b);
        int r102 = r101.length;
        if ((r102 % 2) == 0) goto L5;
        return false;
    L5:
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L18;
        int r104 = r101[r103] & UByte.MAX_VALUE;
        if (r104 < 129) goto L12;
        if (r104 > 159) goto L12;
    L16:
        r103 = r103 + 2;
    L12:
        if (r104 < 224) goto L17;
        if (r104 <= 235) goto L16;
    L17:
        return false;
    L18:
        return true;
    }

    public static f b(String r310, ErrorCorrectionLevel r311, Map<EncodeHintType, ?> r312) throws WriterException {
        ErrorCorrectionLevel r100 = r311;
        Map<EncodeHintType, ?> r101 = r312;
        int r102 = 1;
        if (r101 == null) goto L9;
        EncodeHintType r103 = EncodeHintType.GS1_FORMAT;
        if (r101.containsKey(r103) == false) goto L9;
        if (Boolean.parseBoolean(r101.get(r103).toString()) == false) goto L9;
        boolean r104 = true;
    L10:
        if (r101 == null) goto L16;
        EncodeHintType r105 = EncodeHintType.QR_COMPACT;
        if (r101.containsKey(r105) == false) goto L16;
        if (Boolean.parseBoolean(r101.get(r105).toString()) == false) goto L16;
        boolean r106 = true;
    L17:
        Object r107 = f276000b;
        if (r101 != null) goto L20;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L25;
        Charset r109 = Charset.forName(r101.get(EncodeHintType.CHARACTER_SET).toString());
    L26:
        int r110 = 4;
        int r111 = 8;
        if (r106 == false) goto L55;
        Mode r112 = Mode.BYTE;
        if (r109.equals(r107) == false) goto L31;
        r109 = null;
    L31:
        MinimalEncoder r113 = new MinimalEncoder(r310, r109, r104, r100);
        int r114 = 3;
        com.google.zxing.qrcode.decoder.b[] r115 = {MinimalEncoder.e(MinimalEncoder.VersionSize.SMALL), MinimalEncoder.e(MinimalEncoder.VersionSize.MEDIUM), MinimalEncoder.e(MinimalEncoder.VersionSize.LARGE)};
        MinimalEncoder.c[] r116 = {r113.d(r115[0]), r113.d(r115[1]), r113.d(r115[2])};
        int r117 = 0;
        int r118 = Integer.MAX_VALUE;
        int r119 = -1;
    L32:
        if (r117 >= r114) goto L38;
        MinimalEncoder.c r120 = r116[r117];
        int r121 = r120.a(r120.f275987b);
        if (d(r121, r115[r117], r113.f275976d) == false) goto L37;
        if (r121 >= r118) goto L37;
        r118 = r121;
        r119 = r117;
    L37:
        r117 = r117 + 1;
        r114 = 3;
        goto L32
    L38:
        if (r119 < 0) goto L53;
        MinimalEncoder.c r122 = r116[r119];
        nv7.a r123 = new nv7.a();
        Iterator r124 = ((ArrayList) r122.f275986a).iterator();
    L41:
        if (r124.hasNext() == false) goto L51;
        MinimalEncoder.c.a r125 = (MinimalEncoder.c.a) r124.next();
        r123.b(r125.f275989a.getBits(), 4);
        if (r125.f275992d <= 0) goto L46;
        r123.b(r125.a(), r125.f275989a.getCharacterCountBits(r125.f275993e.f275987b));
    L46:
        if (r125.f275989a == Mode.ECI) goto L47;
        int r126 = r125.f275992d;
        if (r126 <= 0) goto L41;
        String r127 = r125.f275993e.f275988c.f275973a;
        int r128 = r125.f275990b;
        a(r127.substring(r128, r126 + r128), r125.f275989a, r123, r125.f275993e.f275988c.f275975c.f520917a[r125.f275991c].charset());
        goto L41
    L47:
        r123.b(CharacterSetECI.getCharacterSetECI(r125.f275993e.f275988c.f275975c.f520917a[r125.f275991c].charset()).getValue(), 8);
        goto L41
    L51:
        com.google.zxing.qrcode.decoder.b r129 = r122.f275987b;
    L119:
        com.google.zxing.qrcode.decoder.b.C3863b r130 = r129.f275967c[r311.ordinal()];
        int r131 = r129.f275968d;
        int r132 = r130.f275971a;
        com.google.zxing.qrcode.decoder.b.a[] r133 = r130.f275972b;
        int r134 = r133.length;
        int r135 = 0;
        int r136 = 0;
    L120:
        if (r135 >= r134) goto L122;
        r136 = r136 + r133[r135].f275969a;
        r135 = r135 + 1;
        goto L120
    L122:
        int r137 = r131 - (r132 * r136);
        int r138 = r137 * 8;
        if (r123.f520911b > r138) goto L387;
        int r139 = 0;
    L125:
        if (r139 >= r110) goto L129;
        if (r123.f520911b >= r138) goto L129;
        r123.a(false);
        r139 = r139 + 1;
    L129:
        boolean r140 = false;
        int r141 = r123.f520911b & 7;
        if (r141 <= 0) goto L133;
    L131:
        if (r141 >= r111) goto L133;
        r123.a(r140);
        r141 = r141 + 1;
        r140 = false;
    L133:
        int r142 = r137 - ((r123.f520911b + 7) / r111);
        int r143 = 0;
    L134:
        if (r143 >= r142) goto L141;
        if ((r143 & 1) != 0) goto L138;
        int r144 = VideoRef.VALUE_VIDEO_REF_CONST_DEPTH;
    L139:
        r123.b(r144, r111);
        r143 = r143 + 1;
        goto L134
    L138:
        r144 = 17;
        goto L139
    L141:
        if (r123.f520911b != r138) goto L385;
        int r145 = r129.f275968d;
        com.google.zxing.qrcode.decoder.b.a[] r146 = r130.f275972b;
        int r147 = r146.length;
        int r148 = 0;
        int r149 = 0;
    L143:
        if (r149 >= r147) goto L146;
        r148 = r148 + r146[r149].f275969a;
        r149 = r149 + 1;
        goto L143
    L146:
        if (((r123.f520911b + 7) / r111) != r137) goto L383;
        ArrayList r150 = new ArrayList(r148);
        int r151 = 0;
        int r152 = 0;
        int r153 = 0;
        int r154 = 0;
    L148:
        if (r151 >= r148) goto L214;
        int[] r155 = new int[r102];
        int[] r156 = new int[r102];
        if (r151 >= r148) goto L213;
        int r210 = r145 % r148;
        int r157 = r148 - r210;
        int r211 = r145 / r148;
        int r212 = r211 + 1;
        int r213 = r137 / r148;
        int r214 = r213 + 1;
        int r158 = r211 - r213;
        com.google.zxing.qrcode.decoder.b r215 = r129;
        int r159 = r212 - r214;
        if (r158 != r159) goto L211;
        Mode r216 = r112;
        if (r148 != (r157 + r210)) goto L209;
        if (r145 != (((r213 + r158) * r157) + ((r214 + r159) * r210))) goto L207;
        if (r151 >= r157) goto L159;
        char r160 = 0;
        r155[0] = r213;
        r156[0] = r158;
    L160:
        int r161 = r155[r160];
        byte[] r162 = new byte[r161];
        int r163 = r154 * 8;
        int r164 = 0;
    L161:
        if (r164 >= r161) goto L169;
        int r217 = r145;
        int r218 = r148;
        int r165 = 0;
        int r166 = 8;
        int r167 = 0;
    L163:
        if (r167 >= r166) goto L168;
        if (r123.d(r163) == false) goto L167;
        r165 = r165 | (1 << (7 - r167));
    L167:
        r163 = r163 + 1;
        r167 = r167 + 1;
        r166 = 8;
        goto L163
    L168:
        r162[r164 + 0] = (byte) r165;
        r164 = r164 + 1;
        r148 = r218;
        r145 = r217;
        goto L161
    L169:
        int r219 = r145;
        int r220 = r148;
        int r168 = r156[0];
        int r169 = r161 + r168;
        int[] r170 = new int[r169];
        int r171 = 0;
    L170:
        if (r171 >= r161) goto L172;
        r170[r171] = r162[r171] & UByte.MAX_VALUE;
        r171 = r171 + 1;
        goto L170
    L172:
        ov7.d r172 = new ov7.d(ov7.a.f526924g);
        if (r168 == 0) goto L205;
        int r173 = r169 - r168;
        if (r173 <= 0) goto L203;
        if (r168 < ((ArrayList) r172.f526936b).size()) goto L181;
        List<ov7.b> r174 = r172.f526936b;
        ov7.b r175 = (ov7.b) ListProtector.get(r174, ((ArrayList) r174).size() - 1);
        int r176 = ((ArrayList) r172.f526936b).size();
    L179:
        if (r176 > r168) goto L181;
        int r221 = r137;
        ov7.a r177 = r172.f526935a;
        r175 = r175.d(new ov7.b(r177, new int[]{1, r177.f526927a[(r176 - 1) + r177.f526932f]}));
        ((ArrayList) r172.f526936b).add(r175);
        r176 = r176 + 1;
        r154 = r154;
        r123 = r123;
        r137 = r221;
        r151 = r151;
    L181:
        nv7.a r222 = r123;
        int r223 = r137;
        int r224 = r151;
        int r178 = r154;
        ov7.b r179 = (ov7.b) ListProtector.get(r172.f526936b, r168);
        int[] r180 = new int[r173];
        System.arraycopy(r170, 0, r180, 0, r173);
        ov7.b r181 = new ov7.b(r172.f526935a, r180).e(r168, 1);
        if (r181.f526933a.equals(r179.f526933a) == false) goto L201;
        if (r179.c() == true) goto L199;
        ov7.b r182 = r181.f526933a.f526929c;
        int r183 = -1;
        int r184 = r181.f526933a.b(r179.b(r179.f526934b.length - 1));
        ov7.b r185 = r181;
    L186:
        int[] r225 = r155;
        if ((r185.f526934b.length + r183) < (r179.f526934b.length + r183)) goto L191;
        if (r185.c() == true) goto L191;
        int[] r186 = r185.f526934b;
        int r187 = (r186.length + r183) - (r179.f526934b.length + r183);
        int r188 = r181.f526933a.c(r185.b(r186.length + r183), r184);
        ov7.b r189 = r179.e(r187, r188);
        r182 = r182.a(r181.f526933a.a(r187, r188));
        r185 = r185.a(r189);
        r155 = r225;
        r153 = r153;
        r183 = -1;
    L191:
        int r226 = r153;
        int[] r190 = r185.f526934b;
        int r191 = r168 - r190.length;
        int r192 = 0;
    L192:
        if (r192 >= r191) goto L194;
        r170[r173 + r192] = 0;
        r192 = r192 + 1;
        goto L192
    L194:
        System.arraycopy(r190, 0, r170, r173 + r191, r190.length);
        byte[] r193 = new byte[r168];
        int r194 = 0;
    L195:
        if (r194 >= r168) goto L197;
        r193[r194] = (byte) r170[r161 + r194];
        r194 = r194 + 1;
        goto L195
    L197:
        r150.add(new com.google.zxing.qrcode.encoder.a(r162, r193));
        r152 = Math.max(r152, r161);
        r153 = Math.max(r226, r168);
        r154 = r178 + r225[0];
        r151 = r224 + 1;
        r148 = r220;
        r129 = r215;
        r112 = r216;
        r145 = r219;
        r123 = r222;
        r137 = r223;
        r102 = 1;
        goto L148
    L199:
        throw new IllegalArgumentException("Divide by 0");
    L201:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    L203:
        throw new IllegalArgumentException("No data bytes provided");
    L205:
        throw new IllegalArgumentException("No error correction bytes");
    L159:
        r160 = 0;
        r155[0] = r214;
        r156[0] = r159;
        goto L160
    L207:
        throw new WriterException("Total bytes mismatch");
    L209:
        throw new WriterException("RS blocks mismatch");
    L211:
        throw new WriterException("EC bytes mismatch");
    L213:
        throw new WriterException("Block ID too large");
    L214:
        com.google.zxing.qrcode.decoder.b r227 = r129;
        Mode r228 = r112;
        int r229 = r145;
        int r195 = r153;
        if (r137 != r154) goto L381;
        nv7.a r196 = new nv7.a();
        int r197 = 0;
    L217:
        if (r197 >= r152) goto L225;
        Iterator r198 = r150.iterator();
    L220:
        if (r198.hasNext() == false) goto L224;
        byte[] r199 = ((com.google.zxing.qrcode.encoder.a) r198.next()).f275994a;
        if (r197 >= r199.length) goto L220;
        r196.b(r199[r197], 8);
        goto L220
    L224:
        r197 = r197 + 1;
        goto L217
    L225:
        int r1100 = 0;
    L226:
        if (r1100 >= r195) goto L235;
        Iterator r200 = r150.iterator();
    L229:
        if (r200.hasNext() == false) goto L233;
        byte[] r201 = ((com.google.zxing.qrcode.encoder.a) r200.next()).f275995b;
        if (r1100 >= r201.length) goto L229;
        r196.b(r201[r1100], 8);
        goto L229
    L233:
        r1100 = r1100 + 1;
        goto L226
    L235:
        if (r229 != ((r196.f520911b + 7) / 8)) goto L379;
        f r202 = new f();
        r202.f276007b = r311;
        r202.f276006a = r228;
        r202.f276008c = r227;
        int r203 = (r227.f275965a * 4) + 17;
        b r204 = new b(r203, r203);
        if (r312 == null) goto L248;
        EncodeHintType r205 = EncodeHintType.QR_MASK_PATTERN;
        if (r312.containsKey(r205) == false) goto L248;
        int r206 = CastIntegerProtector.parseInt(r312.get(r205).toString());
        if (r206 >= 0) goto L243;
    L245:
        boolean r1101 = false;
    L246:
        if (r1101 == false) goto L248;
    L250:
        if (r206 != (-1)) goto L375;
        int r207 = Integer.MAX_VALUE;
        int r208 = 8;
        int r1102 = 0;
        int r1103 = -1;
    L252:
        if (r1102 >= r208) goto L374;
        e.a(r196, r311, r227, r1102, r204);
        int r209 = d.a(r204, true) + d.a(r204, false);
        byte[][] r230 = r204.f275996a;
        int r231 = r204.f275997b;
        int r232 = r204.f275998c;
        int r233 = 0;
        int r1104 = 0;
    L255:
        if (r233 >= (r232 - 1)) goto L268;
        byte[] r1105 = r230[r233];
        int r1106 = r1104;
        int r1107 = 0;
    L258:
        if (r1107 >= (r231 - 1)) goto L267;
        byte r1108 = r1105[r1107];
        int r1109 = r1107 + 1;
        if (r1108 != r1105[r1109]) goto L266;
        byte[] r1110 = r230[r233 + 1];
        if (r1108 != r1110[r1107]) goto L266;
        if (r1108 != r1110[r1109]) goto L266;
        r1106 = r1106 + 1;
    L266:
        r1107 = r1109;
        goto L258
    L267:
        r233 = r233 + 1;
        r1104 = r1106;
        goto L255
    L268:
        int r234 = r209 + (r1104 * 3);
        byte[][] r235 = r204.f275996a;
        int r236 = r204.f275997b;
        int r237 = r204.f275998c;
        int r238 = 0;
        int r1111 = 0;
    L269:
        if (r238 >= r237) goto L361;
        int r1112 = r1111;
        int r1113 = 0;
    L271:
        if (r1113 >= r236) goto L360;
        byte[] r1114 = r235[r238];
        int r1115 = r1113 + 6;
        if (r1115 >= r236) goto L315;
        int r1116 = r236;
        nv7.a r313 = r196;
        byte r239 = 1;
        if (r1114[r1113] == 1) goto L277;
    L316:
        int r240 = r238 + 6;
        if (r240 >= r237) goto L359;
        if (r235[r238][r1113] != 1) goto L359;
        if (r235[r238 + 1][r1113] != 0) goto L359;
        if (r235[r238 + 2][r1113] != 1) goto L359;
        if (r235[r238 + 3][r1113] != 1) goto L359;
        if (r235[r238 + 4][r1113] != 1) goto L359;
        if (r235[r238 + 5][r1113] != 0) goto L359;
        if (r235[r240][r1113] != 1) goto L359;
        int r241 = r238 - 4;
        if (r241 >= 0) goto L335;
    L343:
        boolean r242 = false;
    L344:
        if (r242 == true) goto L358;
        int r243 = r238 + 7;
        int r244 = r238 + 11;
        if (r243 >= 0) goto L348;
    L356:
        boolean r245 = false;
    L357:
        if (r245 == false) goto L359;
    L348:
        if (r235.length < r244) goto L356;
    L350:
        if (r243 >= r244) goto L355;
        if (r235[r243][r1113] == 1) goto L356;
        r243 = r243 + 1;
        goto L350
    L355:
        r245 = true;
    L358:
        r1112 = r1112 + 1;
        goto L359
    L335:
        if (r235.length < r238) goto L343;
    L337:
        if (r241 >= r238) goto L342;
        if (r235[r241][r1113] == 1) goto L343;
        r241 = r241 + 1;
        goto L337
    L342:
        r242 = true;
    L359:
        r1113 = r1113 + 1;
        r196 = r313;
        r236 = r1116;
        goto L271
    L277:
        if (r1114[r1113 + 1] != 0) goto L316;
        if (r1114[r1113 + 2] != 1) goto L316;
        if (r1114[r1113 + 3] != 1) goto L316;
        if (r1114[r1113 + 4] != 1) goto L316;
        if (r1114[r1113 + 5] != 0) goto L316;
        if (r1114[r1115] != 1) goto L316;
        int r246 = r1113 - 4;
        if (r246 >= 0) goto L291;
    L299:
        boolean r247 = false;
    L300:
        if (r247 == true) goto L314;
        int r248 = r1113 + 7;
        int r249 = r1113 + 11;
        if (r248 >= 0) goto L304;
    L312:
        boolean r250 = false;
    L313:
        if (r250 == false) goto L316;
    L304:
        if (r1114.length < r249) goto L312;
    L306:
        if (r248 >= r249) goto L311;
        int r314 = r249;
        if (r1114[r248] == 1) goto L312;
        r248 = r248 + 1;
        r249 = r314;
        goto L306
    L311:
        r250 = true;
    L314:
        r1112 = r1112 + 1;
        goto L316
    L291:
        if (r1114.length < r1113) goto L299;
    L293:
        if (r246 >= r1113) goto L298;
        if (r1114[r246] == r239) goto L299;
        r246 = r246 + 1;
        r239 = 1;
        goto L293
    L298:
        r247 = true;
        goto L300
    L315:
        r313 = r196;
        r1116 = r236;
        goto L316
    L360:
        r238 = r238 + 1;
        r1111 = r1112;
        goto L269
    L361:
        nv7.a r315 = r196;
        int r251 = r234 + (r1111 * 40);
        byte[][] r252 = r204.f275996a;
        int r253 = r204.f275997b;
        int r254 = r204.f275998c;
        int r255 = 0;
        int r256 = 0;
    L362:
        if (r255 >= r254) goto L370;
        byte[] r1117 = r252[r255];
        int r1118 = 0;
    L364:
        if (r1118 >= r253) goto L369;
        if (r1117[r1118] != 1) goto L368;
        r256 = r256 + 1;
    L368:
        r1118 = r1118 + 1;
        goto L364
    L369:
        r255 = r255 + 1;
        goto L362
    L370:
        int r257 = r204.f275998c * r204.f275997b;
        int r258 = r251 + (((Math.abs((r256 * 2) - r257) * 10) / r257) * 10);
        if (r258 >= r207) goto L373;
        r207 = r258;
        r1103 = r1102;
    L373:
        r1102 = r1102 + 1;
        r208 = 8;
        r196 = r315;
        goto L252
    L374:
        nv7.a r316 = r196;
        r206 = r1103;
    L376:
        r202.f276009d = r206;
        e.a(r316, r311, r227, r206, r204);
        r202.f276010e = r204;
        return r202;
    L375:
        r316 = r196;
        goto L376
    L243:
        if (r206 >= 8) goto L245;
        r1101 = true;
    L248:
        r206 = -1;
        goto L250
    L379:
        throw new WriterException("Interleaving error: " + r229 + " and " + ((r196.f520911b + 7) / 8) + " differ.");
    L381:
        throw new WriterException("Data bytes does not match offset");
    L383:
        throw new WriterException("Number of bits and data bytes does not match");
    L385:
        throw new WriterException("Bits size does not equal capacity");
    L387:
        throw new WriterException("data bits cannot fit in the QR Code" + r123.f520911b + " > " + r138);
    L53:
        throw new WriterException("Data too big for any version");
    L55:
        if (nv7.d.f520920b.equals(r109) == true) goto L57;
    L60:
        int r259 = 0;
        boolean r260 = false;
        boolean r261 = false;
    L62:
        if (r259 >= r310.length()) goto L76;
        char r1119 = r310.charAt(r259);
        if (r1119 < '0') goto L69;
        if (r1119 > '9') goto L69;
        r261 = true;
    L74:
        r259 = r259 + 1;
    L69:
        if (r1119 >= '`') goto L71;
        int r262 = f275999a[r1119];
    L72:
        if (r262 == (-1)) goto L75;
        r260 = true;
        goto L74
    L75:
        Mode r263 = Mode.BYTE;
    L59:
        r112 = r263;
        nv7.a r264 = new nv7.a();
        Mode r265 = Mode.BYTE;
        if (r112 != r265) goto L87;
        if (r108 == false) goto L87;
        CharacterSetECI r266 = CharacterSetECI.getCharacterSetECI(r109);
        if (r266 == null) goto L87;
        r264.b(Mode.ECI.getBits(), 4);
        r264.b(r266.getValue(), 8);
    L87:
        if (r104 == false) goto L89;
        r264.b(Mode.FNC1_FIRST_POSITION.getBits(), 4);
    L89:
        r264.b(r112.getBits(), 4);
        nv7.a r267 = new nv7.a();
        a(r310, r112, r267, r109);
        if (r101 == null) goto L98;
        EncodeHintType r268 = EncodeHintType.QR_VERSION;
        if (r101.containsKey(r268) == false) goto L98;
        com.google.zxing.qrcode.decoder.b r269 = com.google.zxing.qrcode.decoder.b.b(CastIntegerProtector.parseInt(r101.get(r268).toString()));
        if (d((r264.f520911b + r112.getCharacterCountBits(r269)) + r267.f520911b, r269, r100) == false) goto L97;
        com.google.zxing.qrcode.decoder.b r1120 = r269;
    L107:
        nv7.a r270 = new nv7.a();
        int r271 = r264.f520911b;
        r270.c(r270.f520911b + r271);
        int r1121 = 0;
    L108:
        if (r1121 >= r271) goto L110;
        r270.a(r264.d(r1121));
        r1121 = r1121 + 1;
        goto L108
    L110:
        if (r112 != r265) goto L112;
        int r272 = (r267.f520911b + 7) / r111;
    L113:
        int r273 = r112.getCharacterCountBits(r1120);
        int r274 = r102 << r273;
        if (r272 >= r274) goto L389;
        r270.b(r272, r273);
        int r275 = r267.f520911b;
        r270.c(r270.f520911b + r275);
        int r276 = 0;
    L116:
        if (r276 >= r275) goto L118;
        r270.a(r267.d(r276));
        r276 = r276 + 1;
        goto L116
    L118:
        r123 = r270;
        r129 = r1120;
        goto L119
    L389:
        throw new WriterException(r272 + " is bigger than " + (r274 - 1));
    L112:
        r272 = r310.length();
        goto L113
    L97:
        throw new WriterException("Data too big for requested version");
    L98:
        int r277 = (r264.f520911b + r112.getCharacterCountBits(com.google.zxing.qrcode.decoder.b.b(1))) + r267.f520911b;
        int r278 = 1;
    L100:
        if (r278 > 40) goto L395;
        com.google.zxing.qrcode.decoder.b r1122 = com.google.zxing.qrcode.decoder.b.b(r278);
        if (d(r277, r1122, r100) == true) goto L103;
        r278 = r278 + 1;
        r102 = 1;
        r110 = 4;
        r111 = 8;
        r277 = r277;
        r100 = r100;
        r101 = r101;
        goto L100
    L103:
        int r279 = (r264.f520911b + r112.getCharacterCountBits(r1122)) + r267.f520911b;
        int r280 = 1;
    L104:
        if (r280 > 40) goto L392;
        r1120 = com.google.zxing.qrcode.decoder.b.b(r280);
        if (d(r279, r1120, r100) == true) goto L107;
        r102 = 1;
        r110 = 4;
        r111 = 8;
        r280 = r280 + 1;
        r100 = r100;
        r101 = r101;
        goto L104
    L392:
        throw new WriterException("Data too big");
    L395:
        throw new WriterException("Data too big");
    L71:
        r262 = -1;
        goto L72
    L76:
        if (r260 == false) goto L78;
        r263 = Mode.ALPHANUMERIC;
        goto L59
    L78:
        if (r261 == false) goto L80;
        r263 = Mode.NUMERIC;
        goto L59
    L80:
        r263 = Mode.BYTE;
        goto L59
    L57:
        if (c(r310) == false) goto L60;
        r263 = Mode.KANJI;
        goto L59
    L25:
        r109 = r107;
        goto L26
    L20:
        if (r101.containsKey(EncodeHintType.CHARACTER_SET) == false) goto L22;
        r108 = true;
    L16:
        r106 = false;
    L9:
        r104 = false;
        goto L10
    }

    public static boolean d(int r100, com.google.zxing.qrcode.decoder.b r101, ErrorCorrectionLevel r102) {
        int r103 = r101.f275968d;
        com.google.zxing.qrcode.decoder.b.C3863b r104 = r101.f275967c[r102.ordinal()];
        int r105 = r104.f275971a;
        com.google.zxing.qrcode.decoder.b.a[] r106 = r104.f275972b;
        int r107 = r106.length;
        int r108 = 0;
        int r109 = 0;
    L3:
        if (r108 >= r107) goto L6;
        r109 = r109 + r106[r108].f275969a;
        r108 = r108 + 1;
        goto L3
    L6:
        if ((r103 - (r105 * r109)) < ((r100 + 7) / 8)) goto L10;
        return true;
    L10:
        return false;
    }

    public static void a(String r100, Mode r101, nv7.a r102, Charset r110) throws WriterException {
        int r103 = a.f276001a[r101.ordinal()];
        int r104 = 0;
        if (r103 != 1) goto L5;
        int r105 = r100.length();
    L57:
        if (r104 >= r105) goto L88;
        int r111 = r100.charAt(r104) - '0';
        int r106 = r104 + 2;
        if (r106 < r105) goto L60;
        r104 = r104 + 1;
        if (r104 < r105) goto L63;
        r102.b(r111, 4);
        goto L57
    L63:
        r102.b((r111 * 10) + (r100.charAt(r104) - '0'), 7);
        r104 = r106;
        goto L57
    L60:
        r102.b(((r111 * 100) + ((r100.charAt(r104 + 1) - '0') * 10)) + (r100.charAt(r106) - '0'), 10);
        r104 = r104 + 3;
        goto L57
    L88:
        return;
    L5:
        if (r103 != 2) goto L7;
        int r107 = r100.length();
    L37:
        if (r104 >= r107) goto L87;
        char r112 = r100.charAt(r104);
        int[] r108 = f275999a;
        if (r112 >= '`') goto L41;
        int r113 = r108[r112];
    L42:
        if (r113 == (-1)) goto L55;
        int r109 = r104 + 1;
        if (r109 < r107) goto L45;
        r102.b(r113, 6);
        r104 = r109;
        goto L37
    L45:
        char r114 = r100.charAt(r109);
        if (r114 >= '`') goto L48;
        int r115 = r108[r114];
    L49:
        if (r115 == (-1)) goto L52;
        r102.b((r113 * 45) + r115, 11);
        r104 = r104 + 2;
        goto L37
    L52:
        throw new WriterException();
    L48:
        r115 = -1;
        goto L49
    L55:
        throw new WriterException();
    L41:
        r113 = -1;
        goto L42
    L87:
        return;
    L7:
        if (r103 == 3) goto L33;
        if (r103 != 4) goto L32;
        byte[] r116 = r100.getBytes(nv7.d.f520920b);
        if ((r116.length % 2) != 0) goto L30;
        int r117 = r116.length - 1;
    L12:
        if (r104 >= r117) goto L65;
        int r118 = ((r116[r104] & UByte.MAX_VALUE) << 8) | (r116[r104 + 1] & UByte.MAX_VALUE);
        int r119 = 33088;
        if (r118 < 33088) goto L19;
        if (r118 > 40956) goto L19;
    L23:
        int r120 = r118 - r119;
    L25:
        if (r120 == (-1)) goto L28;
        r102.b(((r120 >> 8) * 192) + (r120 & 255), 13);
        r104 = r104 + 2;
        goto L12
    L28:
        throw new WriterException("Invalid byte sequence");
    L19:
        if (r118 >= 57408) goto L21;
    L24:
        r120 = -1;
        goto L25
    L21:
        if (r118 > 60351) goto L24;
        r119 = 49472;
        goto L23
    L65:
        return;
    L30:
        throw new WriterException("Kanji byte size not even");
    L32:
        throw new WriterException("Invalid mode: " + r101);
    L33:
        byte[] r121 = r100.getBytes(r110);
        int r122 = r121.length;
    L34:
        if (r104 >= r122) goto L86;
        r102.b(r121[r104], 8);
        r104 = r104 + 1;
        goto L34
    }
}
