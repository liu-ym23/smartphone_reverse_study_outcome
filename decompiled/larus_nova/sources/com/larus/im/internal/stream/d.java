package com.larus.im.internal.stream;

import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharCategory;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f350139a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350140a = null;

        static {
            int[] r100 = new int[CharCategory.values().length];
            r100[CharCategory.CONTROL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[CharCategory.FORMAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[CharCategory.LINE_SEPARATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[CharCategory.PARAGRAPH_SEPARATOR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[CharCategory.NON_SPACING_MARK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[CharCategory.ENCLOSING_MARK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[CharCategory.UPPERCASE_LETTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[CharCategory.LOWERCASE_LETTER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[CharCategory.TITLECASE_LETTER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[CharCategory.MODIFIER_LETTER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[CharCategory.OTHER_LETTER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f350140a = r100;
        }
    }

    static {
    }

    public static boolean e(int r100) {
        if (r100 != 169) goto L5;
        return true;
    L5:
        if (r100 != 174) goto L7;
        return true;
    L7:
        if (r100 != 8252) goto L9;
        return true;
    L9:
        if (r100 != 8265) goto L11;
        return true;
    L11:
        if (r100 != 8482) goto L13;
        return true;
    L13:
        if (r100 != 8505) goto L15;
        return true;
    L15:
        if (r100 != 9000) goto L17;
        return true;
    L17:
        if (r100 != 9167) goto L19;
        return true;
    L19:
        if (r100 != 9410) goto L21;
        return true;
    L21:
        if (r100 != 9654) goto L23;
        return true;
    L23:
        if (r100 != 9664) goto L25;
        return true;
    L25:
        if (r100 != 11088) goto L27;
        return true;
    L27:
        if (r100 != 11093) goto L29;
        return true;
    L29:
        if (r100 != 12336) goto L31;
        return true;
    L31:
        if (r100 != 12349) goto L33;
        return true;
    L33:
        if (r100 != 12951) goto L35;
        return true;
    L35:
        if (r100 != 12953) goto L38;
        return true;
    L38:
        if (8596 <= r100) goto L40;
    L42:
        boolean r101 = false;
    L43:
        if (r101 == false) goto L45;
        return true;
    L45:
        if (8617 <= r100) goto L47;
    L49:
        boolean r102 = false;
    L50:
        if (r102 == false) goto L52;
        return true;
    L52:
        if (8986 <= r100) goto L54;
    L56:
        boolean r103 = false;
    L57:
        if (r103 == false) goto L59;
        return true;
    L59:
        if (9193 <= r100) goto L61;
    L63:
        boolean r104 = false;
    L64:
        if (r104 == false) goto L66;
        return true;
    L66:
        if (9208 <= r100) goto L68;
    L70:
        boolean r105 = false;
    L71:
        if (r105 == false) goto L73;
        return true;
    L73:
        if (9642 <= r100) goto L75;
    L77:
        boolean r106 = false;
    L78:
        if (r106 == false) goto L80;
        return true;
    L80:
        if (9723 <= r100) goto L82;
    L84:
        boolean r107 = false;
    L85:
        if (r107 == false) goto L87;
        return true;
    L87:
        if (9728 <= r100) goto L89;
    L91:
        boolean r108 = false;
    L92:
        if (r108 == false) goto L94;
        return true;
    L94:
        if (10548 <= r100) goto L96;
    L98:
        boolean r109 = false;
    L99:
        if (r109 == false) goto L101;
        return true;
    L101:
        if (11013 <= r100) goto L103;
    L105:
        boolean r110 = false;
    L106:
        if (r110 == false) goto L108;
        return true;
    L108:
        if (11035 <= r100) goto L110;
    L112:
        boolean r111 = false;
    L113:
        if (r111 == false) goto L115;
        return true;
    L115:
        if (126976 <= r100) goto L117;
    L119:
        boolean r112 = false;
    L120:
        if (r112 == false) goto L122;
        return true;
    L122:
        if (130048 <= r100) goto L124;
    L126:
        boolean r113 = false;
    L127:
        if (r113 == true) goto L160;
        return false;
    L160:
        return true;
    L124:
        if (r100 >= 131070) goto L126;
        r113 = true;
        goto L127
    L117:
        if (r100 >= 129792) goto L119;
        r112 = true;
        goto L120
    L110:
        if (r100 >= 11037) goto L112;
        r111 = true;
        goto L113
    L103:
        if (r100 >= 11016) goto L105;
        r110 = true;
        goto L106
    L96:
        if (r100 >= 10550) goto L98;
        r109 = true;
        goto L99
    L89:
        if (r100 >= 10176) goto L91;
        r108 = true;
        goto L92
    L82:
        if (r100 >= 9727) goto L84;
        r107 = true;
        goto L85
    L75:
        if (r100 >= 9644) goto L77;
        r106 = true;
        goto L78
    L68:
        if (r100 >= 9211) goto L70;
        r105 = true;
        goto L71
    L61:
        if (r100 >= 9204) goto L63;
        r104 = true;
        goto L64
    L54:
        if (r100 >= 8988) goto L56;
        r103 = true;
        goto L57
    L47:
        if (r100 >= 8619) goto L49;
        r102 = true;
        goto L50
    L40:
        if (r100 >= 8602) goto L42;
        r101 = true;
        goto L43
    }

    public static boolean f(int r100) {
        if (r100 != 2381) goto L5;
    L27:
        return true;
    L5:
        if (r100 == 2509) goto L27;
        if (r100 == 2637) goto L27;
        if (r100 == 2765) goto L27;
        if (r100 == 2893) goto L27;
        if (r100 == 3021) goto L27;
        if (r100 == 3149) goto L27;
        if (r100 == 3277) goto L27;
        if (r100 == 3405) goto L27;
        if (r100 == 3530) goto L27;
        if (r100 == 3387) goto L27;
        if (r100 == 3388) goto L27;
        return false;
    }

    public static boolean g(int r100) {
        if (127462 <= r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 127488) goto L7;
        return true;
    }

    public static int b(int r100) {
        boolean r101 = true;
        if (4352 > r100) goto L6;
        if (r100 >= 4448) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
    L57:
        return 1;
    L9:
        if (43360 <= r100) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L57;
        if (4448 > r100) goto L20;
        if (r100 >= 4520) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == false) goto L23;
    L56:
        return 2;
    L23:
        if (55216 <= r100) goto L25;
    L27:
        boolean r105 = false;
    L28:
        if (r105 == true) goto L56;
        if (4520 <= r100) goto L32;
    L34:
        boolean r106 = false;
    L35:
        if (r106 == false) goto L37;
    L55:
        return 3;
    L37:
        if (55243 <= r100) goto L39;
    L41:
        boolean r107 = false;
    L42:
        if (r107 == true) goto L55;
        if (44032 <= r100) goto L47;
    L49:
        r101 = false;
    L50:
        if (r101 == true) goto L52;
        return 0;
    L52:
        if (((r100 - 44032) % 28) != 0) goto L54;
        return 4;
    L54:
        return 5;
    L47:
        if (r100 >= 55204) goto L49;
    L39:
        if (r100 >= 55292) goto L41;
        r107 = true;
        goto L42
    L32:
        if (r100 >= 4608) goto L34;
        r106 = true;
        goto L35
    L25:
        if (r100 >= 55239) goto L27;
        r105 = true;
    L20:
        r104 = false;
        goto L21
    L11:
        if (r100 >= 43389) goto L13;
        r103 = true;
    L6:
        r102 = false;
        goto L7
    }

    public static boolean c(int r100) {
        if (r100 != 8204) goto L5;
        return false;
    L5:
        if (r100 != 8205) goto L7;
        return false;
    L7:
        if (r100 > 65535) goto L9;
        CharCategory r101 = CharsKt.getCategory((char) r100);
        int r102 = a.f350140a[r101.ordinal()];
        if (r102 != 1) goto L27;
    L33:
        return true;
    L27:
        if (r102 == 2) goto L33;
        if (r102 == 3) goto L33;
        if (r102 == 4) goto L33;
        return false;
    L9:
        if (113824 <= r100) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L16;
    L22:
        return true;
    L16:
        if (917504 <= r100) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L22;
        return false;
    L18:
        if (r100 >= 917536) goto L20;
        r104 = true;
        goto L21
    L11:
        if (r100 >= 113840) goto L13;
        r103 = true;
        goto L14
    }

    public static boolean d(int r110) {
        if (r110 != 8204) goto L5;
        return true;
    L5:
        if (127995 <= r110) goto L7;
    L9:
        boolean r100 = false;
    L10:
        if (r100 == false) goto L12;
        return true;
    L12:
        if (65024 <= r110) goto L14;
    L16:
        boolean r101 = false;
    L17:
        if (r101 == false) goto L19;
        return true;
    L19:
        if (917536 <= r110) goto L21;
    L23:
        boolean r102 = false;
    L24:
        if (r102 == false) goto L26;
        return true;
    L26:
        if (917760 <= r110) goto L28;
    L30:
        boolean r103 = false;
    L31:
        if (r103 == false) goto L34;
        return true;
    L34:
        if (r110 > 65535) goto L42;
        CharCategory r111 = CharsKt.getCategory((char) r110);
        int r112 = a.f350140a[r111.ordinal()];
        if (r112 != 5) goto L38;
        return true;
    L38:
        if (r112 == 6) goto L796;
        return false;
    L796:
        return true;
    L42:
        if (r110 != 66045) goto L44;
        return true;
    L44:
        if (r110 != 66272) goto L46;
        return true;
    L46:
        if (r110 != 68159) goto L48;
        return true;
    L48:
        if (r110 != 69633) goto L50;
        return true;
    L50:
        if (r110 != 70090) goto L52;
        return true;
    L52:
        if (r110 != 70459) goto L54;
        return true;
    L54:
        if (r110 != 70460) goto L56;
        return true;
    L56:
        if (r110 != 70750) goto L58;
        return true;
    L58:
        if (r110 != 71229) goto L60;
        return true;
    L60:
        if (r110 != 71339) goto L62;
        return true;
    L62:
        if (r110 != 71340) goto L64;
        return true;
    L64:
        if (r110 != 71351) goto L66;
        return true;
    L66:
        if (r110 != 71998) goto L68;
        return true;
    L68:
        if (r110 != 72263) goto L70;
        return true;
    L70:
        if (r110 != 73018) goto L72;
        return true;
    L72:
        if (r110 != 73031) goto L74;
        return true;
    L74:
        if (r110 != 73109) goto L76;
        return true;
    L76:
        if (r110 != 73111) goto L78;
        return true;
    L78:
        if (r110 != 92912) goto L80;
        return true;
    L80:
        if (r110 != 113821) goto L82;
        return true;
    L82:
        if (r110 != 121461) goto L84;
        return true;
    L84:
        if (r110 != 121476) goto L87;
        return true;
    L87:
        if (66422 <= r110) goto L89;
    L91:
        boolean r113 = false;
    L92:
        if (r113 == false) goto L94;
        return true;
    L94:
        if (68097 <= r110) goto L96;
    L98:
        boolean r114 = false;
    L99:
        if (r114 == false) goto L101;
        return true;
    L101:
        if (68101 <= r110) goto L103;
    L105:
        boolean r115 = false;
    L106:
        if (r115 == false) goto L108;
        return true;
    L108:
        if (68108 <= r110) goto L110;
    L112:
        boolean r116 = false;
    L113:
        if (r116 == false) goto L115;
        return true;
    L115:
        if (68152 <= r110) goto L117;
    L119:
        boolean r117 = false;
    L120:
        if (r117 == false) goto L122;
        return true;
    L122:
        if (68325 <= r110) goto L124;
    L126:
        boolean r118 = false;
    L127:
        if (r118 == false) goto L129;
        return true;
    L129:
        if (68900 <= r110) goto L131;
    L133:
        boolean r119 = false;
    L134:
        if (r119 == false) goto L136;
        return true;
    L136:
        if (69291 <= r110) goto L138;
    L140:
        boolean r120 = false;
    L141:
        if (r120 == false) goto L143;
        return true;
    L143:
        if (69446 <= r110) goto L145;
    L147:
        boolean r121 = false;
    L148:
        if (r121 == false) goto L150;
        return true;
    L150:
        if (69506 <= r110) goto L152;
    L154:
        boolean r122 = false;
    L155:
        if (r122 == false) goto L157;
        return true;
    L157:
        if (69688 <= r110) goto L159;
    L161:
        boolean r123 = false;
    L162:
        if (r123 == false) goto L164;
        return true;
    L164:
        if (69744 <= r110) goto L166;
    L168:
        boolean r124 = false;
    L169:
        if (r124 == false) goto L171;
        return true;
    L171:
        if (69747 <= r110) goto L173;
    L175:
        boolean r125 = false;
    L176:
        if (r125 == false) goto L178;
        return true;
    L178:
        if (69759 <= r110) goto L180;
    L182:
        boolean r126 = false;
    L183:
        if (r126 == false) goto L185;
        return true;
    L185:
        if (69811 <= r110) goto L187;
    L189:
        boolean r127 = false;
    L190:
        if (r127 == false) goto L192;
        return true;
    L192:
        if (69817 <= r110) goto L194;
    L196:
        boolean r128 = false;
    L197:
        if (r128 == false) goto L199;
        return true;
    L199:
        if (69888 <= r110) goto L201;
    L203:
        boolean r129 = false;
    L204:
        if (r129 == false) goto L206;
        return true;
    L206:
        if (69927 <= r110) goto L208;
    L210:
        boolean r130 = false;
    L211:
        if (r130 == false) goto L213;
        return true;
    L213:
        if (69933 <= r110) goto L215;
    L217:
        boolean r131 = false;
    L218:
        if (r131 == false) goto L220;
        return true;
    L220:
        if (70003 <= r110) goto L222;
    L224:
        boolean r132 = false;
    L225:
        if (r132 == false) goto L227;
        return true;
    L227:
        if (70016 <= r110) goto L229;
    L231:
        boolean r133 = false;
    L232:
        if (r133 == false) goto L234;
        return true;
    L234:
        if (70070 <= r110) goto L236;
    L238:
        boolean r134 = false;
    L239:
        if (r134 == false) goto L241;
        return true;
    L241:
        if (70089 <= r110) goto L243;
    L245:
        boolean r135 = false;
    L246:
        if (r135 == false) goto L248;
        return true;
    L248:
        if (70191 <= r110) goto L250;
    L252:
        boolean r136 = false;
    L253:
        if (r136 == false) goto L255;
        return true;
    L255:
        if (70196 <= r110) goto L257;
    L259:
        boolean r137 = false;
    L260:
        if (r137 == false) goto L262;
        return true;
    L262:
        if (70198 <= r110) goto L264;
    L266:
        boolean r138 = false;
    L267:
        if (r138 == false) goto L269;
        return true;
    L269:
        if (70206 <= r110) goto L271;
    L273:
        boolean r139 = false;
    L274:
        if (r139 == false) goto L276;
        return true;
    L276:
        if (70367 <= r110) goto L278;
    L280:
        boolean r140 = false;
    L281:
        if (r140 == false) goto L283;
        return true;
    L283:
        if (70371 <= r110) goto L285;
    L287:
        boolean r141 = false;
    L288:
        if (r141 == false) goto L290;
        return true;
    L290:
        if (70400 <= r110) goto L292;
    L294:
        boolean r142 = false;
    L295:
        if (r142 == true) goto L851;
        if (70459 <= r110) goto L298;
    L300:
        boolean r104 = false;
    L301:
        if (r104 == false) goto L303;
        return true;
    L303:
        if (70464 <= r110) goto L305;
    L307:
        boolean r105 = false;
    L308:
        if (r105 == false) goto L310;
        return true;
    L310:
        if (70502 <= r110) goto L312;
    L314:
        boolean r106 = false;
    L315:
        if (r106 == false) goto L317;
        return true;
    L317:
        if (70512 <= r110) goto L319;
    L321:
        boolean r107 = false;
    L322:
        if (r107 == false) goto L324;
        return true;
    L324:
        if (70712 <= r110) goto L326;
    L328:
        boolean r108 = false;
    L329:
        if (r108 == false) goto L331;
        return true;
    L331:
        if (70722 <= r110) goto L333;
    L335:
        boolean r109 = false;
    L336:
        if (r109 == false) goto L338;
        return true;
    L338:
        if (70726 <= r110) goto L340;
    L342:
        boolean r143 = false;
    L343:
        if (r143 == false) goto L345;
        return true;
    L345:
        if (70835 <= r110) goto L347;
    L349:
        boolean r144 = false;
    L350:
        if (r144 == false) goto L352;
        return true;
    L352:
        if (70842 <= r110) goto L354;
    L356:
        boolean r145 = false;
    L357:
        if (r145 == false) goto L359;
        return true;
    L359:
        if (70847 <= r110) goto L361;
    L363:
        boolean r146 = false;
    L364:
        if (r146 == false) goto L366;
        return true;
    L366:
        if (70850 <= r110) goto L368;
    L370:
        boolean r147 = false;
    L371:
        if (r147 == false) goto L373;
        return true;
    L373:
        if (71090 <= r110) goto L375;
    L377:
        boolean r148 = false;
    L378:
        if (r148 == false) goto L380;
        return true;
    L380:
        if (71100 <= r110) goto L382;
    L384:
        boolean r149 = false;
    L385:
        if (r149 == false) goto L387;
        return true;
    L387:
        if (71103 <= r110) goto L389;
    L391:
        boolean r150 = false;
    L392:
        if (r150 == false) goto L394;
        return true;
    L394:
        if (71132 <= r110) goto L396;
    L398:
        boolean r151 = false;
    L399:
        if (r151 == false) goto L401;
        return true;
    L401:
        if (71219 <= r110) goto L403;
    L405:
        boolean r152 = false;
    L406:
        if (r152 == true) goto L867;
        if (71229 <= r110) goto L409;
    L411:
        boolean r153 = false;
    L412:
        if (r153 == false) goto L414;
        return true;
    L414:
        if (71231 <= r110) goto L416;
    L418:
        boolean r154 = false;
    L419:
        if (r154 == true) goto L869;
        if (71339 > r110) goto L423;
        if (r110 >= 71340) goto L423;
        boolean r155 = true;
    L424:
        if (r155 == false) goto L426;
        return true;
    L426:
        if (71341 <= r110) goto L428;
    L430:
        boolean r156 = false;
    L431:
        if (r156 == false) goto L433;
        return true;
    L433:
        if (71344 <= r110) goto L435;
    L437:
        boolean r157 = false;
    L438:
        if (r157 == false) goto L440;
        return true;
    L440:
        if (71453 <= r110) goto L442;
    L444:
        boolean r158 = false;
    L445:
        if (r158 == false) goto L447;
        return true;
    L447:
        if (71458 <= r110) goto L449;
    L451:
        boolean r159 = false;
    L452:
        if (r159 == false) goto L454;
        return true;
    L454:
        if (71463 <= r110) goto L456;
    L458:
        boolean r160 = false;
    L459:
        if (r160 == false) goto L461;
        return true;
    L461:
        if (71727 <= r110) goto L463;
    L465:
        boolean r161 = false;
    L466:
        if (r161 == false) goto L468;
        return true;
    L468:
        if (71737 <= r110) goto L470;
    L472:
        boolean r162 = false;
    L473:
        if (r162 == false) goto L475;
        return true;
    L475:
        if (71984 <= r110) goto L477;
    L479:
        boolean r163 = false;
    L480:
        if (r163 == false) goto L482;
        return true;
    L482:
        if (71995 <= r110) goto L484;
    L486:
        boolean r164 = false;
    L487:
        if (r164 == false) goto L489;
        return true;
    L489:
        if (72003 <= r110) goto L491;
    L493:
        boolean r165 = false;
    L494:
        if (r165 == false) goto L496;
        return true;
    L496:
        if (72148 <= r110) goto L498;
    L500:
        boolean r166 = false;
    L501:
        if (r166 == false) goto L503;
        return true;
    L503:
        if (72154 <= r110) goto L505;
    L507:
        boolean r167 = false;
    L508:
        if (r167 == false) goto L510;
        return true;
    L510:
        if (72160 <= r110) goto L512;
    L514:
        boolean r168 = false;
    L515:
        if (r168 == false) goto L517;
        return true;
    L517:
        if (72193 <= r110) goto L519;
    L521:
        boolean r169 = false;
    L522:
        if (r169 == false) goto L524;
        return true;
    L524:
        if (72243 <= r110) goto L526;
    L528:
        boolean r170 = false;
    L529:
        if (r170 == false) goto L531;
        return true;
    L531:
        if (72251 <= r110) goto L533;
    L535:
        boolean r171 = false;
    L536:
        if (r171 == false) goto L538;
        return true;
    L538:
        if (72273 <= r110) goto L540;
    L542:
        boolean r172 = false;
    L543:
        if (r172 == false) goto L545;
        return true;
    L545:
        if (72281 <= r110) goto L547;
    L549:
        boolean r173 = false;
    L550:
        if (r173 == false) goto L552;
        return true;
    L552:
        if (72330 <= r110) goto L554;
    L556:
        boolean r174 = false;
    L557:
        if (r174 == false) goto L559;
        return true;
    L559:
        if (72344 <= r110) goto L561;
    L563:
        boolean r175 = false;
    L564:
        if (r175 == false) goto L566;
        return true;
    L566:
        if (72752 <= r110) goto L568;
    L570:
        boolean r176 = false;
    L571:
        if (r176 == false) goto L573;
        return true;
    L573:
        if (72760 <= r110) goto L575;
    L577:
        boolean r177 = false;
    L578:
        if (r177 == false) goto L580;
        return true;
    L580:
        if (72767 <= r110) goto L582;
    L584:
        boolean r178 = false;
    L585:
        if (r178 == false) goto L587;
        return true;
    L587:
        if (72850 <= r110) goto L589;
    L591:
        boolean r179 = false;
    L592:
        if (r179 == false) goto L594;
        return true;
    L594:
        if (72874 <= r110) goto L596;
    L598:
        boolean r180 = false;
    L599:
        if (r180 == false) goto L601;
        return true;
    L601:
        if (72882 <= r110) goto L603;
    L605:
        boolean r181 = false;
    L606:
        if (r181 == false) goto L608;
        return true;
    L608:
        if (72885 <= r110) goto L610;
    L612:
        boolean r182 = false;
    L613:
        if (r182 == false) goto L615;
        return true;
    L615:
        if (73009 <= r110) goto L617;
    L619:
        boolean r183 = false;
    L620:
        if (r183 == false) goto L622;
        return true;
    L622:
        if (73020 <= r110) goto L624;
    L626:
        boolean r184 = false;
    L627:
        if (r184 == false) goto L629;
        return true;
    L629:
        if (73023 <= r110) goto L631;
    L633:
        boolean r185 = false;
    L634:
        if (r185 == false) goto L636;
        return true;
    L636:
        if (73104 <= r110) goto L638;
    L640:
        boolean r186 = false;
    L641:
        if (r186 == true) goto L901;
        if (73109 <= r110) goto L644;
    L646:
        boolean r187 = false;
    L647:
        if (r187 == true) goto L902;
        if (73111 <= r110) goto L650;
    L652:
        boolean r188 = false;
    L653:
        if (r188 == false) goto L655;
        return true;
    L655:
        if (73459 <= r110) goto L657;
    L659:
        boolean r189 = false;
    L660:
        if (r189 == false) goto L662;
        return true;
    L662:
        if (78912 <= r110) goto L664;
    L666:
        boolean r190 = false;
    L667:
        if (r190 == false) goto L669;
        return true;
    L669:
        if (78919 <= r110) goto L671;
    L673:
        boolean r191 = false;
    L674:
        if (r191 == true) goto L906;
        if (92912 <= r110) goto L677;
    L679:
        boolean r192 = false;
    L680:
        if (r192 == false) goto L682;
        return true;
    L682:
        if (92976 <= r110) goto L684;
    L686:
        boolean r193 = false;
    L687:
        if (r193 == false) goto L689;
        return true;
    L689:
        if (94031 <= r110) goto L691;
    L693:
        boolean r194 = false;
    L694:
        if (r194 == false) goto L696;
        return true;
    L696:
        if (94095 <= r110) goto L698;
    L700:
        boolean r195 = false;
    L701:
        if (r195 == false) goto L703;
        return true;
    L703:
        if (94180 <= r110) goto L705;
    L707:
        boolean r196 = false;
    L708:
        if (r196 == true) goto L911;
        if (113821 <= r110) goto L711;
    L713:
        boolean r197 = false;
    L714:
        if (r197 == false) goto L716;
        return true;
    L716:
        if (118528 <= r110) goto L718;
    L720:
        boolean r198 = false;
    L721:
        if (r198 == false) goto L723;
        return true;
    L723:
        if (118576 <= r110) goto L725;
    L727:
        boolean r199 = false;
    L728:
        if (r199 == false) goto L730;
        return true;
    L730:
        if (119143 <= r110) goto L732;
    L734:
        boolean r200 = false;
    L735:
        if (r200 == false) goto L737;
        return true;
    L737:
        if (119163 <= r110) goto L739;
    L741:
        boolean r201 = false;
    L742:
        if (r201 == false) goto L744;
        return true;
    L744:
        if (119173 <= r110) goto L746;
    L748:
        boolean r202 = false;
    L749:
        if (r202 == false) goto L751;
        return true;
    L751:
        if (119210 <= r110) goto L753;
    L755:
        boolean r203 = false;
    L756:
        if (r203 == false) goto L758;
        return true;
    L758:
        if (119362 <= r110) goto L760;
    L762:
        boolean r204 = false;
    L763:
        if (r204 == false) goto L765;
        return true;
    L765:
        if (121344 <= r110) goto L767;
    L769:
        boolean r205 = false;
    L770:
        if (r205 == false) goto L772;
        return true;
    L772:
        if (121403 <= r110) goto L774;
    L776:
        boolean r206 = false;
    L777:
        if (r206 == false) goto L779;
        return true;
    L779:
        if (121499 <= r110) goto L781;
    L783:
        boolean r207 = false;
    L784:
        if (r207 == false) goto L786;
        return true;
    L786:
        if (121505 <= r110) goto L788;
    L790:
        boolean r1100 = false;
    L791:
        if (r1100 == true) goto L925;
        return false;
    L925:
        return true;
    L788:
        if (r110 >= 121520) goto L790;
        r1100 = true;
        goto L791
    L781:
        if (r110 >= 121504) goto L783;
        r207 = true;
        goto L784
    L774:
        if (r110 >= 121453) goto L776;
        r206 = true;
        goto L777
    L767:
        if (r110 >= 121399) goto L769;
        r205 = true;
        goto L770
    L760:
        if (r110 >= 119365) goto L762;
        r204 = true;
        goto L763
    L753:
        if (r110 >= 119214) goto L755;
        r203 = true;
        goto L756
    L746:
        if (r110 >= 119180) goto L748;
        r202 = true;
        goto L749
    L739:
        if (r110 >= 119171) goto L741;
        r201 = true;
        goto L742
    L732:
        if (r110 >= 119146) goto L734;
        r200 = true;
        goto L735
    L725:
        if (r110 >= 118599) goto L727;
        r199 = true;
        goto L728
    L718:
        if (r110 >= 118574) goto L720;
        r198 = true;
        goto L721
    L711:
        if (r110 >= 113823) goto L713;
        r197 = true;
        goto L714
    L911:
        return true;
    L705:
        if (r110 >= 94181) goto L707;
        r196 = true;
        goto L708
    L698:
        if (r110 >= 94099) goto L700;
        r195 = true;
        goto L701
    L691:
        if (r110 >= 94032) goto L693;
        r194 = true;
        goto L694
    L684:
        if (r110 >= 92983) goto L686;
        r193 = true;
        goto L687
    L677:
        if (r110 >= 92917) goto L679;
        r192 = true;
        goto L680
    L906:
        return true;
    L671:
        if (r110 >= 78934) goto L673;
        r191 = true;
        goto L674
    L664:
        if (r110 >= 78913) goto L666;
        r190 = true;
        goto L667
    L657:
        if (r110 >= 73461) goto L659;
        r189 = true;
        goto L660
    L650:
        if (r110 >= 73112) goto L652;
        r188 = true;
        goto L653
    L902:
        return true;
    L644:
        if (r110 >= 73110) goto L646;
        r187 = true;
        goto L647
    L901:
        return true;
    L638:
        if (r110 >= 73106) goto L640;
        r186 = true;
        goto L641
    L631:
        if (r110 >= 73030) goto L633;
        r185 = true;
        goto L634
    L624:
        if (r110 >= 73022) goto L626;
        r184 = true;
        goto L627
    L617:
        if (r110 >= 73015) goto L619;
        r183 = true;
        goto L620
    L610:
        if (r110 >= 72887) goto L612;
        r182 = true;
        goto L613
    L603:
        if (r110 >= 72884) goto L605;
        r181 = true;
        goto L606
    L596:
        if (r110 >= 72881) goto L598;
        r180 = true;
        goto L599
    L589:
        if (r110 >= 72872) goto L591;
        r179 = true;
        goto L592
    L582:
        if (r110 >= 72768) goto L584;
        r178 = true;
        goto L585
    L575:
        if (r110 >= 72766) goto L577;
        r177 = true;
        goto L578
    L568:
        if (r110 >= 72759) goto L570;
        r176 = true;
        goto L571
    L561:
        if (r110 >= 72346) goto L563;
        r175 = true;
        goto L564
    L554:
        if (r110 >= 72343) goto L556;
        r174 = true;
        goto L557
    L547:
        if (r110 >= 72284) goto L549;
        r173 = true;
        goto L550
    L540:
        if (r110 >= 72279) goto L542;
        r172 = true;
        goto L543
    L533:
        if (r110 >= 72255) goto L535;
        r171 = true;
        goto L536
    L526:
        if (r110 >= 72249) goto L528;
        r170 = true;
        goto L529
    L519:
        if (r110 >= 72203) goto L521;
        r169 = true;
        goto L522
    L512:
        if (r110 >= 72161) goto L514;
        r168 = true;
        goto L515
    L505:
        if (r110 >= 72156) goto L507;
        r167 = true;
        goto L508
    L498:
        if (r110 >= 72152) goto L500;
        r166 = true;
        goto L501
    L491:
        if (r110 >= 72004) goto L493;
        r165 = true;
        goto L494
    L484:
        if (r110 >= 71997) goto L486;
        r164 = true;
        goto L487
    L477:
        if (r110 >= 71985) goto L479;
        r163 = true;
        goto L480
    L470:
        if (r110 >= 71739) goto L472;
        r162 = true;
        goto L473
    L463:
        if (r110 >= 71736) goto L465;
        r161 = true;
        goto L466
    L456:
        if (r110 >= 71468) goto L458;
        r160 = true;
        goto L459
    L449:
        if (r110 >= 71462) goto L451;
        r159 = true;
        goto L452
    L442:
        if (r110 >= 71456) goto L444;
        r158 = true;
        goto L445
    L435:
        if (r110 >= 71350) goto L437;
        r157 = true;
        goto L438
    L428:
        if (r110 >= 71342) goto L430;
        r156 = true;
    L423:
        r155 = false;
        goto L424
    L869:
        return true;
    L416:
        if (r110 >= 71233) goto L418;
        r154 = true;
        goto L419
    L409:
        if (r110 >= 71230) goto L411;
        r153 = true;
        goto L412
    L867:
        return true;
    L403:
        if (r110 >= 71227) goto L405;
        r152 = true;
        goto L406
    L396:
        if (r110 >= 71134) goto L398;
        r151 = true;
        goto L399
    L389:
        if (r110 >= 71105) goto L391;
        r150 = true;
        goto L392
    L382:
        if (r110 >= 71102) goto L384;
        r149 = true;
        goto L385
    L375:
        if (r110 >= 71094) goto L377;
        r148 = true;
        goto L378
    L368:
        if (r110 >= 70852) goto L370;
        r147 = true;
        goto L371
    L361:
        if (r110 >= 70849) goto L363;
        r146 = true;
        goto L364
    L354:
        if (r110 >= 70843) goto L356;
        r145 = true;
        goto L357
    L347:
        if (r110 >= 70841) goto L349;
        r144 = true;
        goto L350
    L340:
        if (r110 >= 70727) goto L342;
        r143 = true;
        goto L343
    L333:
        if (r110 >= 70725) goto L335;
        r109 = true;
        goto L336
    L326:
        if (r110 >= 70720) goto L328;
        r108 = true;
        goto L329
    L319:
        if (r110 >= 70517) goto L321;
        r107 = true;
        goto L322
    L312:
        if (r110 >= 70509) goto L314;
        r106 = true;
        goto L315
    L305:
        if (r110 >= 70465) goto L307;
        r105 = true;
        goto L308
    L298:
        if (r110 >= 70461) goto L300;
        r104 = true;
        goto L301
    L851:
        return true;
    L292:
        if (r110 >= 70402) goto L294;
        r142 = true;
        goto L295
    L285:
        if (r110 >= 70379) goto L287;
        r141 = true;
        goto L288
    L278:
        if (r110 >= 70368) goto L280;
        r140 = true;
        goto L281
    L271:
        if (r110 >= 70207) goto L273;
        r139 = true;
        goto L274
    L264:
        if (r110 >= 70200) goto L266;
        r138 = true;
        goto L267
    L257:
        if (r110 >= 70197) goto L259;
        r137 = true;
        goto L260
    L250:
        if (r110 >= 70194) goto L252;
        r136 = true;
        goto L253
    L243:
        if (r110 >= 70093) goto L245;
        r135 = true;
        goto L246
    L236:
        if (r110 >= 70079) goto L238;
        r134 = true;
        goto L239
    L229:
        if (r110 >= 70018) goto L231;
        r133 = true;
        goto L232
    L222:
        if (r110 >= 70004) goto L224;
        r132 = true;
        goto L225
    L215:
        if (r110 >= 69941) goto L217;
        r131 = true;
        goto L218
    L208:
        if (r110 >= 69932) goto L210;
        r130 = true;
        goto L211
    L201:
        if (r110 >= 69891) goto L203;
        r129 = true;
        goto L204
    L194:
        if (r110 >= 69819) goto L196;
        r128 = true;
        goto L197
    L187:
        if (r110 >= 69815) goto L189;
        r127 = true;
        goto L190
    L180:
        if (r110 >= 69762) goto L182;
        r126 = true;
        goto L183
    L173:
        if (r110 >= 69749) goto L175;
        r125 = true;
        goto L176
    L166:
        if (r110 >= 69745) goto L168;
        r124 = true;
        goto L169
    L159:
        if (r110 >= 69703) goto L161;
        r123 = true;
        goto L162
    L152:
        if (r110 >= 69510) goto L154;
        r122 = true;
        goto L155
    L145:
        if (r110 >= 69457) goto L147;
        r121 = true;
        goto L148
    L138:
        if (r110 >= 69293) goto L140;
        r120 = true;
        goto L141
    L131:
        if (r110 >= 68904) goto L133;
        r119 = true;
        goto L134
    L124:
        if (r110 >= 68327) goto L126;
        r118 = true;
        goto L127
    L117:
        if (r110 >= 68155) goto L119;
        r117 = true;
        goto L120
    L110:
        if (r110 >= 68112) goto L112;
        r116 = true;
        goto L113
    L103:
        if (r110 >= 68103) goto L105;
        r115 = true;
        goto L106
    L96:
        if (r110 >= 68100) goto L98;
        r114 = true;
        goto L99
    L89:
        if (r110 >= 66427) goto L91;
        r113 = true;
        goto L92
    L28:
        if (r110 >= 918000) goto L30;
        r103 = true;
        goto L31
    L21:
        if (r110 >= 917632) goto L23;
        r102 = true;
        goto L24
    L14:
        if (r110 >= 65040) goto L16;
        r101 = true;
        goto L17
    L7:
        if (r110 >= 128000) goto L9;
        r100 = true;
        goto L10
    }

    public static boolean h(int r100) {
        if (r100 <= 65535) goto L5;
    L7:
        return false;
    L5:
        if (CharsKt.getCategory((char) r100) != CharCategory.COMBINING_SPACING_MARK) goto L7;
        return true;
    }

    public static int a(String r100, int r101) {
        char r102 = r100.charAt(r101);
        boolean r103 = false;
        if (55296 > r102) goto L6;
        if (r102 >= 56320) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L20;
        int r105 = r101 + 1;
        if (r105 >= r100.length()) goto L20;
        char r106 = r100.charAt(r105);
        if (56320 <= r106) goto L14;
    L16:
        if (r103 == true) goto L19;
        return r102;
    L19:
        return (((r102 - 55296) << 10) + (r106 - CharCompanionObject.MIN_LOW_SURROGATE)) + 65536;
    L14:
        if (r106 >= 57344) goto L16;
        r103 = true;
    L20:
        return r102;
    L6:
        r104 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    public static int i(String r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "text");
        int r100 = 1;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r111;
    L8:
        int r102 = RangesKt.coerceIn(r111 + 1, 0, r110.length());
        if (r102 >= r110.length()) goto L11;
        int r103 = RangesKt.coerceAtLeast(r112, 1);
        int r104 = 0;
    L13:
        int r105 = a(r110, r102);
        int r106 = 2;
        if (r105 < 65536) goto L16;
        int r107 = 2;
    L17:
        int r108 = r107 + r102;
        boolean r113 = g(r105);
        boolean r114 = e(r105);
        boolean r115 = f(r105);
        boolean r116 = false;
        ?? r117 = r113;
    L19:
        if (r108 >= r110.length()) goto L183;
        int r118 = a(r110, r108);
        if (r105 != 13) goto L26;
        if (r118 != 10) goto L26;
    L147:
        boolean r109 = true;
    L150:
        if (r109 == false) goto L183;
        if (r118 < 65536) goto L154;
        int r119 = 2;
    L155:
        r108 = r108 + r119;
        if (g(r118) == false) goto L158;
        ?? r120 = r117 + 1;
    L161:
        int r121 = 8205;
        ?? r122 = r120;
    L162:
        if (r118 != r121) goto L165;
        r116 = r114;
    L171:
        if (f(r118) == false) goto L174;
        r115 = true;
    L181:
        r105 = r118;
        r100 = 1;
        r117 = r122;
        goto L19
    L174:
        if (d(r118) == true) goto L181;
        if (h(r118) == true) goto L181;
        if (r118 == 8205) goto L181;
        r115 = false;
        goto L181
    L165:
        if (d(r118) == true) goto L171;
        if (h(r118) == true) goto L171;
        r114 = e(r118);
        r116 = false;
        goto L171
    L158:
        r120 = r117;
        if (d(r118) == true) goto L161;
        r121 = 8205;
        r122 = 0;
        goto L162
    L154:
        r119 = 1;
    L26:
        if (c(r105) == true) goto L149;
        if (c(r118) == true) goto L149;
        int r123 = b(r105);
        int r124 = b(r118);
        if (r123 == r100) goto L49;
        if (r123 == r106) goto L44;
        if (r123 != 3) goto L36;
    L40:
        if (r124 != 3) goto L43;
        r106 = 2;
    L56:
        boolean r125 = true;
    L57:
        if (r125 == true) goto L147;
        if (1536 <= r105) goto L62;
    L64:
        boolean r126 = false;
    L65:
        if (r126 == false) goto L67;
    L109:
        boolean r127 = true;
    L110:
        if (r127 == true) goto L147;
        if (d(r118) == true) goto L147;
        if (h(r118) == true) goto L147;
        if (r118 == 8205) goto L147;
        if (r116 == true) goto L121;
    L123:
        if (r115 == false) goto L142;
        if (2304 <= r118) goto L127;
    L129:
        boolean r128 = false;
    L130:
        if (r128 == true) goto L132;
    L138:
        boolean r129 = false;
    L139:
        if (r129 == false) goto L142;
    L132:
        if (r118 > 65535) goto L138;
        CharCategory r130 = CharsKt.getCategory((char) r118);
        switch(a.f350140a[r130.ordinal()]) {
            case 7: goto L137;
            case 8: goto L137;
            case 9: goto L137;
            case 10: goto L137;
            case 11: goto L137;
            default: goto L138;
        };
    L137:
        r129 = true;
        goto L139
    L127:
        if (r118 >= 3584) goto L129;
        r128 = true;
    L142:
        if (g(r105) == false) goto L149;
        if (g(r118) == false) goto L149;
        if ((r117 % 2) != 1) goto L149;
    L121:
        if (e(r118) == false) goto L123;
    L67:
        if (r105 == 1757) goto L109;
        if (r105 == 1807) goto L109;
        if (2192 <= r105) goto L73;
    L75:
        boolean r131 = false;
    L76:
        if (r131 == true) goto L109;
        if (r105 == 2274) goto L109;
        if (r105 == 3406) goto L109;
        if (r105 == 69821) goto L109;
        if (r105 == 69837) goto L109;
        if (70082 <= r105) goto L88;
    L90:
        boolean r132 = false;
    L91:
        if (r132 == true) goto L109;
        if (r105 == 71999) goto L109;
        if (r105 == 72001) goto L109;
        if (r105 == 72250) goto L109;
        if (72324 <= r105) goto L101;
    L103:
        boolean r133 = false;
    L104:
        if (r133 == true) goto L109;
        if (r105 == 73030) goto L109;
        r127 = false;
        goto L110
    L101:
        if (r105 >= 72330) goto L103;
        r133 = true;
        goto L104
    L88:
        if (r105 >= 70084) goto L90;
        r132 = true;
        goto L91
    L73:
        if (r105 >= 2194) goto L75;
        r131 = true;
        goto L76
    L62:
        if (r105 >= 1542) goto L64;
        r126 = true;
    L43:
        r106 = 2;
    L55:
        r125 = false;
        goto L57
    L36:
        if (r123 == 4) goto L39;
        if (r123 == 5) goto L40;
    L39:
        r106 = 2;
    L44:
        if (r124 == r106) goto L56;
        if (r124 != 3) goto L55;
    L49:
        if (r124 == 1) goto L56;
        if (r124 == r106) goto L56;
        if (r124 == 4) goto L56;
        if (r124 != 5) goto L55;
    L149:
        r109 = false;
    L183:
        int r134 = 0;
    L184:
        if (r102 >= r108) goto L208;
        int r135 = a(r110, r102);
        if (r135 > 127) goto L189;
        int r136 = 1;
    L203:
        r134 = r134 + r136;
        if (r135 < 65536) goto L206;
        int r137 = 2;
    L207:
        r102 = r102 + r137;
        goto L184
    L206:
        r137 = 1;
        goto L207
    L189:
        if (r135 > 2047) goto L192;
        r136 = 2;
        goto L203
    L192:
        if (55296 <= r135) goto L194;
    L196:
        boolean r138 = false;
    L197:
        if (r138 == false) goto L200;
    L201:
        r136 = 3;
        goto L203
    L200:
        if (r135 <= 65535) goto L201;
        r136 = 4;
        goto L203
    L194:
        if (r135 >= 57344) goto L196;
        r138 = true;
        goto L197
    L208:
        r104 = r104 + r134;
        if (r108 >= r110.length()) goto L214;
        if (r104 >= r103) goto L214;
        r102 = r108;
        r100 = 1;
    L214:
        return r108 - 1;
    L16:
        r107 = 1;
        goto L17
    L11:
        return StringsKt.getLastIndex(r110);
    L5:
        r101 = false;
        goto L6
    }
}
