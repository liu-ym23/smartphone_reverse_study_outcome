package f2c;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;
import com.ss.android.lark.qrcode.zxing.EncodeHintType;
import com.ss.android.lark.qrcode.zxing.WriterException;
import com.ss.android.lark.qrcode.zxing.common.CharacterSetECI;
import com.ss.android.lark.qrcode.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ss.android.lark.qrcode.zxing.qrcode.decoder.Mode;
import com.ss.ttvideoengine.model.VideoRef;
import d2c.b;
import g2c.c;
import g2c.d;
import g2c.e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static b a(String r310, BarcodeFormat r311, int r312, int r410, Map r411) throws WriterException {
        int r100 = r312;
        int r101 = r410;
        if (r310.isEmpty() == true) goto L504;
        if (r311 != BarcodeFormat.QR_CODE) goto L502;
        if (r100 < 0) goto L500;
        if (r101 < 0) goto L500;
        ErrorCorrectionLevel r102 = ErrorCorrectionLevel.L;
        EncodeHintType r103 = EncodeHintType.ERROR_CORRECTION;
        EnumMap r104 = (EnumMap) r411;
        if (r104.containsKey(r103) == false) goto L11;
        r102 = ErrorCorrectionLevel.valueOf(r104.get(r103).toString());
    L11:
        EncodeHintType r105 = EncodeHintType.MARGIN;
        if (r104.containsKey(r105) == false) goto L14;
        int r106 = CastIntegerProtector.parseInt(r104.get(r105).toString());
    L15:
        EncodeHintType r107 = EncodeHintType.CHARACTER_SET;
        if (((EnumMap) r411).containsKey(r107) == false) goto L18;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
        String r109 = ((EnumMap) r411).get(r107).toString();
    L23:
        boolean r110 = "Shift_JIS".equals(r109);
        int[] r111 = c.f479775a;
        char r112 = '`';
        if (r110 == true) goto L509;
    L46:
        int r113 = 0;
        boolean r114 = false;
        boolean r115 = false;
    L48:
        if (r113 >= r310.length()) goto L62;
        char r116 = r310.charAt(r113);
        if (r116 >= '0') goto L52;
    L54:
        if (r116 >= '`') goto L56;
        int r117 = r111[r116];
    L58:
        if (r117 == (-1)) goto L61;
        r114 = true;
    L60:
        r113 = r113 + 1;
        goto L48
    L61:
        Mode r118 = Mode.BYTE;
    L67:
        d2c.a r119 = new d2c.a();
        if (r118 != Mode.BYTE) goto L75;
        if (r108 == false) goto L71;
    L72:
        CharacterSetECI r120 = CharacterSetECI.getCharacterSetECIByName(r109);
        if (r120 == null) goto L75;
        r119.b(Mode.ECI.getBits(), 4);
        r119.b(r120.getValue(), 8);
        goto L75
    L71:
        if ("ISO-8859-1".equals(r109) == false) goto L72;
    L75:
        EncodeHintType r121 = EncodeHintType.GS1_FORMAT;
        if (((EnumMap) r411).containsKey(r121) == false) goto L78;
        boolean r122 = true;
    L79:
        if (r122 == true) goto L81;
    L83:
        int r123 = 4;
    L84:
        r119.b(r118.getBits(), r123);
        d2c.a r124 = new d2c.a();
        int r125 = c.a.f479776a[r118.ordinal()];
        if (r125 == 1) goto L146;
        if (r125 != 2) goto L88;
        int r126 = r310.length();
        int r127 = 0;
    L124:
        if (r127 >= r126) goto L155;
        char r128 = r310.charAt(r127);
        if (r128 >= r112) goto L128;
        int r129 = r111[r128];
    L130:
        if (r129 == (-1)) goto L145;
        int r130 = r127 + 1;
        if (r130 >= r126) goto L142;
        char r131 = r310.charAt(r130);
        if (r131 >= r112) goto L136;
        int r132 = r111[r131];
    L138:
        if (r132 == (-1)) goto L141;
        r124.b((r129 * 45) + r132, 11);
        r127 = r127 + 2;
    L143:
        r112 = '`';
        goto L124
    L141:
        throw new WriterException();
    L136:
        r132 = -1;
        goto L138
    L142:
        r124.b(r129, 6);
        r127 = r130;
        goto L143
    L145:
        throw new WriterException();
    L128:
        r129 = -1;
    L155:
        EncodeHintType r133 = EncodeHintType.QR_VERSION;
        EnumMap r134 = (EnumMap) r411;
        if (r134.containsKey(r133) == false) goto L168;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r135 = com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(CastIntegerProtector.parseInt(r134.get(r133).toString()));
        int r136 = (r119.f466580b + r118.getCharacterCountBits(r135)) + r124.f466580b;
        int r137 = r135.f439122c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r138 = r135.f439121b[r102.ordinal()];
        int r139 = r138.f439125a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C5266a[] r140 = r138.f439126b;
        int r141 = r140.length;
        int r142 = 0;
        int r210 = 0;
    L158:
        if (r142 >= r141) goto L161;
        r210 = r210 + r140[r142].f439123a;
        r142 = r142 + 1;
        goto L158
    L161:
        if ((r137 - (r139 * r210)) < ((r136 + 7) / 8)) goto L163;
        boolean r143 = true;
    L164:
        if (r143 == false) goto L167;
    L190:
        d2c.a r144 = new d2c.a();
        int r145 = r119.f466580b;
        r144.c(r144.f466580b + r145);
        int r146 = 0;
    L191:
        if (r146 >= r145) goto L194;
        r144.a(r119.d(r146));
        r146 = r146 + 1;
        goto L191
    L194:
        if (r118 != Mode.BYTE) goto L196;
        int r147 = (r124.f466580b + 7) / 8;
    L197:
        int r148 = r118.getCharacterCountBits(r135);
        int r149 = 1 << r148;
        if (r147 >= r149) goto L492;
        r144.b(r147, r148);
        int r150 = r124.f466580b;
        r144.c(r144.f466580b + r150);
        int r151 = 0;
    L200:
        if (r151 >= r150) goto L202;
        r144.a(r124.d(r151));
        r151 = r151 + 1;
        goto L200
    L202:
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r152 = r135.f439121b[r102.ordinal()];
        int r153 = r135.f439122c;
        int r154 = r152.f439125a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C5266a[] r155 = r152.f439126b;
        int r156 = r155.length;
        int r157 = 0;
        int r158 = 0;
    L203:
        if (r157 >= r156) goto L205;
        r158 = r158 + r155[r157].f439123a;
        r157 = r157 + 1;
        goto L203
    L205:
        int r159 = r153 - (r154 * r158);
        int r160 = r159 * 8;
        if (r144.f466580b > r160) goto L490;
        int r161 = 0;
    L209:
        if (r161 >= 4) goto L213;
        if (r144.f466580b >= r160) goto L213;
        r144.a(false);
        r161 = r161 + 1;
    L213:
        boolean r162 = false;
        int r163 = r144.f466580b & 7;
        if (r163 <= 0) goto L217;
    L215:
        if (r163 >= 8) goto L217;
        r144.a(r162);
        r163 = r163 + 1;
        r162 = false;
    L217:
        int r164 = r159 - ((r144.f466580b + 7) / 8);
        int r165 = 0;
    L218:
        if (r165 >= r164) goto L225;
        if ((r165 & 1) != 0) goto L222;
        int r166 = VideoRef.VALUE_VIDEO_REF_CONST_DEPTH;
    L223:
        r144.b(r166, 8);
        r165 = r165 + 1;
        goto L218
    L222:
        r166 = 17;
        goto L223
    L225:
        if (r144.f466580b != r160) goto L488;
        int r167 = r135.f439122c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C5266a[] r168 = r152.f439126b;
        int r169 = r168.length;
        int r170 = 0;
        int r171 = 0;
    L227:
        if (r170 >= r169) goto L230;
        r171 = r171 + r168[r170].f439123a;
        r170 = r170 + 1;
        goto L227
    L230:
        if (((r144.f466580b + 7) / 8) != r159) goto L486;
        ArrayList r172 = new ArrayList(r171);
        int r173 = 0;
        int r174 = 0;
        int r175 = 0;
        int r176 = 0;
    L232:
        if (r173 >= r171) goto L327;
        int[] r177 = new int[1];
        int[] r178 = new int[1];
        if (r173 >= r171) goto L326;
        int r179 = r167 % r171;
        int r180 = r171 - r179;
        int r211 = r167 / r171;
        int r212 = r211 + 1;
        int r213 = r159 / r171;
        int r214 = r213 + 1;
        int r215 = r106;
        int r181 = r211 - r213;
        ErrorCorrectionLevel r216 = r102;
        int r182 = r212 - r214;
        if (r181 != r182) goto L324;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r217 = r135;
        if (r171 != (r180 + r179)) goto L322;
        if (r167 != (((r213 + r181) * r180) + ((r214 + r182) * r179))) goto L320;
        if (r173 >= r180) goto L243;
        char r183 = 0;
        r177[0] = r213;
        r178[0] = r181;
    L244:
        int r184 = r177[r183];
        byte[] r185 = new byte[r184];
        int r186 = r176 * 8;
        int r187 = 0;
    L245:
        if (r187 >= r184) goto L253;
        int r218 = r167;
        int r412 = r171;
        int r188 = 8;
        int r189 = 0;
        int r190 = r186;
        int r191 = 0;
    L247:
        if (r191 >= r188) goto L252;
        if (r144.d(r190) == false) goto L251;
        r189 = (1 << (7 - r191)) | r189;
    L251:
        r190 = r190 + 1;
        r191 = r191 + 1;
        r188 = 8;
        goto L247
    L252:
        r185[r187 + 0] = (byte) r189;
        r187 = r187 + 1;
        r186 = r190;
        r167 = r218;
        r171 = r412;
        goto L245
    L253:
        int r219 = r167;
        int r413 = r171;
        int r192 = r178[0];
        int r193 = r184 + r192;
        int[] r194 = new int[r193];
        int r195 = 0;
    L254:
        if (r195 >= r184) goto L256;
        r194[r195] = r185[r195] & UByte.MAX_VALUE;
        r195 = r195 + 1;
        goto L254
    L256:
        e2c.c r196 = new e2c.c(e2c.a.f470878g);
        if (r192 == 0) goto L318;
        int r197 = r193 - r192;
        if (r197 <= 0) goto L316;
        if (r192 < ((ArrayList) r196.f470888b).size()) goto L283;
        List<e2c.b> r198 = r196.f470888b;
        e2c.b r199 = (e2c.b) ListProtector.get(r198, ((ArrayList) r198).size() - 1);
        int r1100 = ((ArrayList) r196.f470888b).size();
    L263:
        if (r1100 > r192) goto L283;
        int r220 = r159;
        int r221 = r173;
        e2c.a r200 = r196.f470887a;
        int[] r222 = r177;
        int r223 = r176;
        int r224 = r174;
        e2c.b r201 = new e2c.b(r200, new int[]{1, r200.f470879a[(r1100 - 1) + r200.f470884f]});
        if (r199.f470885a.equals(r200) == false) goto L281;
        if (r199.b() == false) goto L269;
    L278:
        ArrayList r313 = r172;
        r199 = r199.f470885a.f470881c;
    L279:
        ((ArrayList) r196.f470888b).add(r199);
        r1100 = r1100 + 1;
        r159 = r220;
        r173 = r221;
        r176 = r223;
        r177 = r222;
        r174 = r224;
        r175 = r175;
        r172 = r313;
        goto L263
    L269:
        if (r201.b() == true) goto L278;
        int[] r202 = r199.f470886b;
        int r1101 = r202.length;
        int[] r203 = r201.f470886b;
        int r1102 = r203.length;
        int[] r1103 = new int[(r1101 + r1102) - 1];
        int r1104 = 0;
    L272:
        if (r1104 >= r1101) goto L277;
        int r314 = r1101;
        int r1105 = r202[r1104];
        int[] r315 = r202;
        int r204 = 0;
    L274:
        if (r204 >= r1102) goto L276;
        int r316 = r1104 + r204;
        r1103[r316] = r199.f470885a.a(r1105, r203[r204]) ^ r1103[r316];
        r204 = r204 + 1;
        r1102 = r1102;
        r172 = r172;
        goto L274
    L276:
        r1104 = r1104 + 1;
        r1101 = r314;
        r202 = r315;
        goto L272
    L277:
        r313 = r172;
        r199 = new e2c.b(r199.f470885a, r1103);
        goto L279
    L281:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    L283:
        ArrayList r317 = r172;
        int r225 = r159;
        int r226 = r173;
        int r227 = r174;
        int[] r228 = r177;
        int r318 = r175;
        int r229 = r176;
        e2c.b r205 = (e2c.b) ListProtector.get(r196.f470888b, r192);
        int[] r206 = new int[r197];
        System.arraycopy(r194, 0, r206, 0, r197);
        e2c.b r207 = new e2c.b(r196.f470887a, r206).c(r192, 1);
        if (r207.f470885a.equals(r205.f470885a) == false) goto L314;
        if (r205.b() == true) goto L312;
        e2c.a r208 = r207.f470885a;
        e2c.b r209 = r208.f470881c;
        int[] r230 = r205.f470886b;
        int r1106 = -1;
        int r231 = r230[(r230.length - 1) - (r230.length - 1)];
        if (r231 == 0) goto L309;
        int r232 = r208.f470879a[(r208.f470882d - r208.f470880b[r231]) - 1];
        e2c.b r233 = r207;
    L291:
        if ((r233.f470886b.length + r1106) < (r205.f470886b.length + r1106)) goto L302;
        if (r233.b() == true) goto L302;
        int[] r1107 = r233.f470886b;
        int r1108 = (r1107.length + r1106) - (r205.f470886b.length + r1106);
        int r1109 = r207.f470885a.a(r1107[(r1107.length + r1106) - (r1107.length + r1106)], r232);
        e2c.b r1110 = r205.c(r1108, r1109);
        e2c.a r1111 = r207.f470885a;
        r1111.getClass();
        if (r1108 < 0) goto L301;
        if (r1109 != 0) goto L298;
        e2c.b r1112 = r1111.f470881c;
    L299:
        r209 = r209.a(r1112);
        r233 = r233.a(r1110);
        r1106 = -1;
        goto L291
    L298:
        int[] r1113 = new int[r1108 + 1];
        r1113[0] = r1109;
        r1112 = new e2c.b(r1111, r1113);
        goto L299
    L301:
        throw new IllegalArgumentException();
    L302:
        int[] r234 = r233.f470886b;
        int r235 = r192 - r234.length;
        int r236 = 0;
    L303:
        if (r236 >= r235) goto L305;
        r194[r197 + r236] = 0;
        r236 = r236 + 1;
        goto L303
    L305:
        System.arraycopy(r234, 0, r194, r197 + r235, r234.length);
        byte[] r237 = new byte[r192];
        int r238 = 0;
    L306:
        if (r238 >= r192) goto L308;
        r237[r238] = (byte) r194[r184 + r238];
        r238 = r238 + 1;
        goto L306
    L308:
        r317.add(new g2c.a(r185, r237));
        r175 = Math.max(r318, r184);
        r174 = Math.max(r227, r192);
        r176 = r229 + r228[0];
        r173 = r226 + 1;
        r171 = r413;
        r172 = r317;
        r102 = r216;
        r135 = r217;
        r167 = r219;
        r159 = r225;
        r106 = r215;
        r144 = r144;
        goto L232
    L309:
        r208.getClass();
        throw new ArithmeticException();
    L312:
        throw new IllegalArgumentException("Divide by 0");
    L314:
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    L316:
        throw new IllegalArgumentException("No data bytes provided");
    L318:
        throw new IllegalArgumentException("No error correction bytes");
    L243:
        r183 = 0;
        r177[0] = r214;
        r178[0] = r182;
        goto L244
    L320:
        throw new WriterException("Total bytes mismatch");
    L322:
        throw new WriterException("RS blocks mismatch");
    L324:
        throw new WriterException("EC bytes mismatch");
    L326:
        throw new WriterException("Block ID too large");
    L327:
        ErrorCorrectionLevel r239 = r102;
        int r240 = r106;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r241 = r135;
        ArrayList r242 = r172;
        int r243 = r167;
        int r244 = r174;
        int r245 = r175;
        if (r159 != r176) goto L484;
        d2c.a r246 = new d2c.a();
        int r247 = 0;
    L330:
        if (r247 >= r245) goto L338;
        Iterator r248 = r242.iterator();
    L333:
        if (r248.hasNext() == false) goto L337;
        byte[] r249 = ((g2c.a) r248.next()).f479770a;
        if (r247 >= r249.length) goto L333;
        r246.b(r249[r247], 8);
        goto L333
    L337:
        r247 = r247 + 1;
        goto L330
    L338:
        int r250 = 0;
    L339:
        if (r250 >= r244) goto L347;
        Iterator r251 = r242.iterator();
    L342:
        if (r251.hasNext() == false) goto L346;
        byte[] r252 = ((g2c.a) r251.next()).f479771b;
        if (r250 >= r252.length) goto L342;
        r246.b(r252[r250], 8);
        goto L342
    L346:
        r250 = r250 + 1;
        goto L339
    L347:
        int r253 = 8;
        if (r243 != ((r246.f466580b + 7) / 8)) goto L482;
        int r254 = (r241.f439120a * 4) + 17;
        g2c.b r255 = new g2c.b(r254, r254);
        int r256 = Integer.MAX_VALUE;
        int r1114 = 0;
        int r1115 = -1;
    L350:
        if (r1114 >= r253) goto L452;
        ErrorCorrectionLevel r257 = r239;
        e.a(r246, r257, r241, r1114, r255);
        int r258 = d.a(r255, true) + d.a(r255, false);
        byte[][] r259 = r255.f479772a;
        int r260 = r255.f479773b;
        int r261 = r255.f479774c;
        int r262 = 0;
        int r1116 = 0;
    L353:
        if (r262 >= (r261 - 1)) goto L366;
        byte[] r1117 = r259[r262];
        int r1118 = r261;
        int r1119 = r1116;
        int r1120 = 0;
    L356:
        if (r1120 >= (r260 - 1)) goto L365;
        byte r263 = r1117[r1120];
        int r1121 = r1120 + 1;
        if (r263 != r1117[r1121]) goto L364;
        byte[] r1122 = r259[r262 + 1];
        if (r263 != r1122[r1120]) goto L364;
        if (r263 != r1122[r1121]) goto L364;
        r1119 = r1119 + 1;
    L364:
        r1120 = r1121;
        goto L356
    L365:
        r262 = r262 + 1;
        r1116 = r1119;
        r261 = r1118;
        goto L353
    L366:
        int r264 = r258 + (r1116 * 3);
        byte[][] r265 = r255.f479772a;
        int r266 = r255.f479773b;
        int r267 = r255.f479774c;
        int r268 = 0;
        int r1123 = 0;
    L367:
        if (r268 >= r267) goto L439;
        int r1124 = r1123;
        int r1125 = 0;
    L369:
        if (r1125 >= r266) goto L438;
        byte[] r1126 = r265[r268];
        int r1127 = r1125 + 6;
        if (r1127 >= r266) goto L403;
        int r1128 = r266;
        ErrorCorrectionLevel r269 = r257;
        byte r270 = 1;
        if (r1126[r1125] == 1) goto L375;
    L404:
        int r271 = r268 + 6;
        if (r271 >= r267) goto L437;
        byte r1129 = 1;
        if (r265[r268][r1125] != 1) goto L437;
        if (r265[r268 + 1][r1125] != 0) goto L437;
        if (r265[r268 + 2][r1125] != 1) goto L437;
        if (r265[r268 + 3][r1125] != 1) goto L437;
        if (r265[r268 + 4][r1125] != 1) goto L437;
        if (r265[r268 + 5][r1125] != 0) goto L437;
        if (r265[r271][r1125] != 1) goto L437;
        int r272 = Math.max(r268 - 4, 0);
        int r273 = Math.min(r268, r265.length);
    L421:
        if (r272 >= r273) goto L426;
        if (r265[r272][r1125] == r1129) goto L424;
        r272 = r272 + 1;
        r1129 = 1;
        goto L421
    L424:
        boolean r274 = false;
    L427:
        if (r274 == true) goto L436;
        int r275 = Math.max(r268 + 7, 0);
        int r276 = Math.min(r268 + 11, r265.length);
    L429:
        if (r275 >= r276) goto L434;
        if (r265[r275][r1125] == 1) goto L432;
        r275 = r275 + 1;
        goto L429
    L432:
        boolean r277 = false;
    L435:
        if (r277 == false) goto L437;
    L434:
        r277 = true;
    L436:
        r1124 = r1124 + 1;
        goto L437
    L426:
        r274 = true;
    L437:
        r1125 = r1125 + 1;
        r266 = r1128;
        r257 = r269;
        goto L369
    L375:
        if (r1126[r1125 + 1] != 0) goto L404;
        if (r1126[r1125 + 2] != 1) goto L404;
        if (r1126[r1125 + 3] != 1) goto L404;
        if (r1126[r1125 + 4] != 1) goto L404;
        if (r1126[r1125 + 5] != 0) goto L404;
        if (r1126[r1127] != 1) goto L404;
        int r278 = Math.max(r1125 - 4, 0);
        int r1130 = Math.min(r1125, r1126.length);
    L387:
        if (r278 >= r1130) goto L392;
        int r319 = r1130;
        if (r1126[r278] == r270) goto L390;
        r278 = r278 + 1;
        r1130 = r319;
        r270 = 1;
        goto L387
    L390:
        boolean r279 = false;
    L393:
        if (r279 == true) goto L402;
        int r280 = Math.max(r1125 + 7, 0);
        int r281 = Math.min(r1125 + 11, r1126.length);
    L395:
        if (r280 >= r281) goto L400;
        int r320 = r281;
        if (r1126[r280] == 1) goto L398;
        r280 = r280 + 1;
        r281 = r320;
        goto L395
    L398:
        boolean r282 = false;
    L401:
        if (r282 == false) goto L404;
    L400:
        r282 = true;
    L402:
        r1124 = r1124 + 1;
        goto L404
    L392:
        r279 = true;
        goto L393
    L403:
        r269 = r257;
        r1128 = r266;
        goto L404
    L438:
        r268 = r268 + 1;
        r1123 = r1124;
        goto L367
    L439:
        r239 = r257;
        int r283 = r264 + (r1123 * 40);
        byte[][] r284 = r255.f479772a;
        int r285 = r255.f479773b;
        int r286 = r255.f479774c;
        int r287 = 0;
        int r288 = 0;
    L440:
        if (r287 >= r286) goto L448;
        byte[] r1131 = r284[r287];
        int r1132 = 0;
    L442:
        if (r1132 >= r285) goto L447;
        if (r1131[r1132] != 1) goto L446;
        r288 = r288 + 1;
    L446:
        r1132 = r1132 + 1;
        goto L442
    L447:
        r287 = r287 + 1;
        goto L440
    L448:
        int r289 = r255.f479774c * r255.f479773b;
        int r290 = r283 + (((Math.abs((r288 * 2) - r289) * 10) / r289) * 10);
        if (r290 >= r256) goto L451;
        r256 = r290;
        r1115 = r1114;
    L451:
        r1114 = r1114 + 1;
        r253 = 8;
        goto L350
    L452:
        e.a(r246, r239, r241, r1115, r255);
        int r291 = r255.f479773b;
        int r292 = r255.f479774c;
        int r293 = r240 * 2;
        int r294 = r291 + r293;
        int r295 = r293 + r292;
        int r296 = Math.max(r312, r294);
        int r297 = Math.max(r410, r295);
        int r298 = Math.min(r296 / r294, r297 / r295);
        int r299 = (r296 - (r291 * r298)) / 2;
        int r300 = (r297 - (r292 * r298)) / 2;
        b r301 = new b(r296, r297);
        int r1133 = 0;
    L453:
        if (r1133 >= r292) goto L480;
        int r302 = r299;
        int r303 = 0;
    L455:
        if (r303 >= r291) goto L479;
        if (r255.a(r303, r1133) != 1) goto L478;
        if (r300 < 0) goto L477;
        if (r302 < 0) goto L477;
        if (r298 < 1) goto L475;
        if (r298 < 1) goto L475;
        int r304 = r298 + r302;
        int r1134 = r298 + r300;
        if (r1134 > r301.f466582b) goto L473;
        if (r304 > r301.f466581a) goto L473;
        int r1135 = r300;
    L467:
        if (r1135 >= r1134) goto L478;
        int r1136 = r301.f466583c * r1135;
        int r1137 = r302;
    L469:
        if (r1137 >= r304) goto L471;
        int[] r1138 = r301.f466584d;
        int r1139 = (r1137 / 32) + r1136;
        r1138[r1139] = r1138[r1139] | (1 << (r1137 & 31));
        r1137 = r1137 + 1;
        goto L469
    L471:
        r1135 = r1135 + 1;
    L473:
        throw new IllegalArgumentException("The region must fit inside the matrix");
    L475:
        throw new IllegalArgumentException("Height and width must be at least 1");
    L477:
        throw new IllegalArgumentException("Left and top must be nonnegative");
    L478:
        r303 = r303 + 1;
        r302 = r302 + r298;
        goto L455
    L479:
        r1133 = r1133 + 1;
        r300 = r300 + r298;
        goto L453
    L480:
        return r301;
    L482:
        throw new WriterException("Interleaving error: " + r243 + " and " + ((r246.f466580b + 7) / 8) + " differ.");
    L484:
        throw new WriterException("Data bytes does not match offset");
    L486:
        throw new WriterException("Number of bits and data bytes does not match");
    L488:
        throw new WriterException("Bits size does not equal capacity");
    L490:
        throw new WriterException("data bits cannot fit in the QR Code" + r144.f466580b + " > " + r160);
    L492:
        throw new WriterException(r147 + " is bigger than " + (r149 - 1));
    L196:
        r147 = r310.length();
        goto L197
    L167:
        throw new WriterException("Data too big for requested version");
    L163:
        r143 = false;
        goto L164
    L168:
        int r305 = (r119.f466580b + r118.getCharacterCountBits(com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(1))) + r124.f466580b;
        int r1140 = 1;
    L170:
        if (r1140 > 40) goto L498;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r1141 = com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(r1140);
        int r1142 = r1141.f439122c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r1143 = r1141.f439121b[r102.ordinal()];
        int r1144 = r1143.f439125a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C5266a[] r1145 = r1143.f439126b;
        int r1146 = r1145.length;
        int r306 = 0;
        int r2100 = 0;
    L172:
        if (r306 >= r1146) goto L175;
        r2100 = r2100 + r1145[r306].f439123a;
        r306 = r306 + 1;
        r1146 = r1146;
        goto L172
    L175:
        if ((r1142 - (r1144 * r2100)) < ((r305 + 7) / 8)) goto L177;
        boolean r307 = true;
    L178:
        if (r307 == true) goto L179;
        r1140 = r1140 + 1;
        r102 = r102;
        r100 = r100;
        r101 = r101;
        r106 = r106;
        goto L170
    L179:
        int r308 = (r119.f466580b + r118.getCharacterCountBits(r1141)) + r124.f466580b;
        int r309 = 40;
        int r1147 = 1;
    L180:
        if (r1147 > r309) goto L495;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r1148 = com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b(r1147);
        int r1149 = r1148.f439122c;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.b r1150 = r1148.f439121b[r102.ordinal()];
        int r1151 = r1150.f439125a;
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a.C5266a[] r1152 = r1150.f439126b;
        int r1153 = r1152.length;
        int r321 = 0;
        int r2101 = 0;
    L182:
        if (r321 >= r1153) goto L184;
        r2101 = r2101 + r1152[r321].f439123a;
        r321 = r321 + 1;
        r1148 = r1148;
        goto L182
    L184:
        com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r2102 = r1148;
        if ((r1149 - (r1151 * r2101)) < ((r308 + 7) / 8)) goto L187;
        boolean r322 = true;
    L188:
        if (r322 == true) goto L189;
        r1147 = r1147 + 1;
        r102 = r102;
        r100 = r100;
        r101 = r101;
        r106 = r106;
        r309 = 40;
        goto L180
    L189:
        r135 = r2102;
        goto L190
    L187:
        r322 = false;
        goto L188
    L495:
        throw new WriterException("Data too big");
    L177:
        r307 = false;
        goto L178
    L498:
        throw new WriterException("Data too big");
    L88:
        if (r125 != 3) goto L90;
        byte[] r323 = r310.getBytes(r109);     // Catch: UnsupportedEncodingException -> L120
        int r324 = r323.length;
        int r1154 = 0;
    L118:
        if (r1154 >= r324) goto L155;
        r124.b(r323[r1154], 8);
        r1154 = r1154 + 1;
    L120:
        e = move-exception;
        throw new WriterException(e);
    L90:
        if (r125 != 4) goto L115;
        byte[] r325 = r310.getBytes("Shift_JIS");     // Catch: UnsupportedEncodingException -> L111
        int r326 = r325.length;
        int r1155 = 0;
    L93:
        if (r1155 >= r326) goto L155;
        int r1156 = ((r325[r1155] & UByte.MAX_VALUE) << 8) | (r325[r1155 + 1] & UByte.MAX_VALUE);
        int r1157 = 33088;
        if (r1156 < 33088) goto L100;
        if (r1156 > 40956) goto L100;
    L104:
        int r1158 = r1156 - r1157;
    L107:
        if (r1158 == (-1)) goto L110;
        r124.b(((r1158 >> 8) * 192) + (r1158 & 255), 13);
        r1155 = r1155 + 2;
        goto L93
    L110:
        throw new WriterException("Invalid byte sequence");
    L100:
        if (r1156 >= 57408) goto L102;
    L105:
        r1158 = -1;
        goto L107
    L102:
        if (r1156 > 60351) goto L105;
        r1157 = 49472;
    L111:
        e = move-exception;
        throw new WriterException(e);
    L115:
        throw new WriterException("Invalid mode: " + r118);
    L146:
        int r327 = r310.length();
        int r328 = 0;
    L147:
        if (r328 >= r327) goto L155;
        int r1159 = r310.charAt(r328) - '0';
        int r1160 = r328 + 2;
        if (r1160 < r327) goto L150;
        r328 = r328 + 1;
        if (r328 < r327) goto L153;
        r124.b(r1159, 4);
        goto L147
    L153:
        r124.b((r1159 * 10) + (r310.charAt(r328) - '0'), 7);
        r328 = r1160;
        goto L147
    L150:
        r124.b(((r1159 * 100) + ((r310.charAt(r328 + 1) - '0') * 10)) + (r310.charAt(r1160) - '0'), 10);
        r328 = r328 + 3;
        goto L147
    L81:
        if (Boolean.valueOf(((EnumMap) r411).get(r121).toString()).booleanValue() == false) goto L83;
        r123 = 4;
        r119.b(Mode.FNC1_FIRST_POSITION.getBits(), 4);
        goto L84
    L78:
        r122 = false;
        goto L79
    L56:
        r117 = -1;
        goto L58
    L52:
        if (r116 > '9') goto L54;
        r115 = true;
        goto L60
    L62:
        if (r114 == false) goto L64;
        r118 = Mode.ALPHANUMERIC;
        goto L67
    L64:
        if (r115 == false) goto L66;
        r118 = Mode.NUMERIC;
        goto L67
    L66:
        r118 = Mode.BYTE;
        goto L67
    L509:
        byte[] r1161 = r310.getBytes("Shift_JIS");     // Catch: UnsupportedEncodingException -> L42
        int r329 = r1161.length;
        if ((r329 % 2) != 0) goto L43;
        int r330 = 0;
    L30:
        if (r330 >= r329) goto L41;
        int r331 = r1161[r330] & UByte.MAX_VALUE;
        if (r331 < 129) goto L36;
        if (r331 > 159) goto L36;
    L40:
        r330 = r330 + 2;
    L36:
        if (r331 < 224) goto L43;
        if (r331 <= 235) goto L40;
    L41:
        boolean r332 = true;
    L44:
        if (r332 == false) goto L46;
        r118 = Mode.KANJI;
    L43:
        r332 = false;
        goto L44
    L22:
        r109 = "ISO-8859-1";
        goto L23
    L18:
        r108 = false;
        goto L20
    L14:
        r106 = 4;
    L500:
        throw new IllegalArgumentException("Requested dimensions are too small: " + r100 + Permission.EXECUTE + r101);
    L502:
        throw new IllegalArgumentException("Can only encode QR_CODE, but got " + r311);
    L504:
        throw new IllegalArgumentException("Found empty contents");
    }
}
