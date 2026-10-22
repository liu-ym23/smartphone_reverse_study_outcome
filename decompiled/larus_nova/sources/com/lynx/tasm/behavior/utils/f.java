package com.lynx.tasm.behavior.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f383199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f383200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f383201c;

        public a() {
            this.f383199a = false;
            this.f383200b = false;
            this.f383201c = false;
        }

        public final void a(StringBuilder r100, int r101) {
            if (r100.length() != 0) goto L5;
            return;
        L5:
            boolean r102 = true;
            if (Character.isHighSurrogate(r100.charAt(r100.length() - 1)) == false) goto L9;
            this.f383201c = true;
            return;
        L9:
            int r103 = r100.length();
            if (this.f383201c == false) goto L12;
            int r104 = 2;
        L13:
            int r105 = r103 - r104;
            int r106 = r100.codePointAt(r105);
            if (r101 != 1) goto L39;
            Character.UnicodeBlock r107 = Character.UnicodeBlock.of(r106);
            if (r107 != Character.UnicodeBlock.BASIC_LATIN) goto L18;
        L35:
            if (r102 == false) goto L37;
        L38:
            r100.delete(r105, r100.length());
            r100.append(8203);
            r100.appendCodePoint(r106);
            this.f383200b = r102;
        L69:
            this.f383201c = false;
            return;
        L37:
            if (this.f383200b == false) goto L69;
        L18:
            if (r107 == Character.UnicodeBlock.LATIN_1_SUPPLEMENT) goto L35;
            if (r107 == Character.UnicodeBlock.LATIN_EXTENDED_A) goto L35;
            if (r107 == Character.UnicodeBlock.LATIN_EXTENDED_B) goto L35;
            if (r107 == Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L35;
            if (r107 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L35;
            if (r107 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L35;
            if (r107 == Character.UnicodeBlock.CURRENCY_SYMBOLS) goto L35;
            if (r107 == Character.UnicodeBlock.MATHEMATICAL_OPERATORS) goto L35;
            r102 = false;
            goto L35
        L39:
            if (r101 != 2) goto L69;
            Character.UnicodeBlock r108 = Character.UnicodeBlock.of(r106);
            if (r108 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L43;
        L62:
            boolean r109 = true;
        L63:
            if (r109 == true) goto L65;
            this.f383199a = false;
            goto L69
        L65:
            if (this.f383199a == false) goto L67;
            r100.delete(r105, r100.length());
            r100.append(8288);
            r100.appendCodePoint(r106);
            goto L69
        L67:
            this.f383199a = true;
            goto L69
        L43:
            if (r108 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L62;
            if (r108 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) goto L62;
            if (r108 == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT) goto L62;
            if (r108 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L62;
            if (r108 == Character.UnicodeBlock.KATAKANA) goto L62;
            if (r108 == Character.UnicodeBlock.HIRAGANA) goto L62;
            if (r108 == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) goto L62;
            if (r108 == Character.UnicodeBlock.HANGUL_JAMO) goto L62;
            if (r108 == Character.UnicodeBlock.HANGUL_SYLLABLES) goto L62;
            r109 = false;
            goto L63
        L12:
            r104 = 1;
            goto L13
        }
    }

    public static String a(String r110, int r111) {
        a r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        char r101 = Typography.amp;
        if (r111 == 0) goto L8;
    L10:
        int r102 = r110.length();
        StringBuilder r103 = new StringBuilder(r102);
        if (r111 == 0) goto L13;
        r100 = new a();
    L13:
        int r104 = 0;
    L14:
        if (r104 >= r102) goto L304;
        byte r105 = 35;
        int r112 = -1;
        if (r110.charAt(r104) != r101) goto L40;
        int r106 = r104 + 1;
        if (r106 >= r102) goto L40;
        if (r110.charAt(r106) != '#') goto L40;
        int r107 = r104 + 2;
        int r108 = r107;
    L22:
        if (r108 >= r102) goto L29;
        if (r108 >= ((r107 + 10) + 1)) goto L29;
        if (r110.charAt(r108) == ';') goto L30;
        r108 = r108 + 1;
    L30:
        if (r108 != (-1)) goto L305;
        r103.append(r110.charAt(r104));
    L300:
        if (r111 == 0) goto L302;
        r100.a(r103, r111);
    L302:
        r104 = r104 + 1;
        r101 = Typography.amp;
        goto L14
    L305:
        if (r110.charAt(r107) != 'x') goto L35;
        int r109 = CastIntegerProtector.parseInt(r110.subSequence(r104 + 3, r108).toString(), 16);     // Catch: Exception -> L38
    L36:
        r103.appendCodePoint(r109);     // Catch: Exception -> L38
        r104 = r108;
        goto L300
    L35:
        r109 = CastIntegerProtector.parseInt(r110.subSequence(r107, r108).toString(), 10);     // Catch: Exception -> L38
    L38:
        r103.append(r110.charAt(r104));
    L29:
        r108 = -1;
    L40:
        if (r110.charAt(r104) != r101) goto L299;
        int r113 = r104 + 1;
        if (r113 >= r102) goto L299;
        int r114 = r113;
    L44:
        if (r114 >= r102) goto L60;
        if (r114 >= ((r104 + 7) + 1)) goto L60;
        char r115 = r110.charAt(r114);
        if (r115 == ';') goto L61;
        if (r115 < 'A') goto L55;
        if (r115 > 'Z') goto L55;
    L59:
        r114 = r114 + 1;
    L55:
        if (r115 < 'a') goto L60;
        if (r115 <= 'z') goto L59;
    L61:
        if (r114 != (-1)) goto L63;
        r103.append(r110.charAt(r104));
        goto L300
    L63:
        String r116 = r110.subSequence(r113, r114).toString();
        r116.getClass();
        switch(r116.hashCode()) {
            case -1419323836: goto L246;
            case -1368034367: goto L242;
            case -1339299958: goto L238;
            case -1220935388: goto L234;
            case -1196259461: goto L230;
            case -1190290628: goto L226;
            case -1093812015: goto L222;
            case -1074341375: goto L218;
            case -991722477: goto L214;
            case -922037109: goto L210;
            case -874702154: goto L206;
            case 3294: goto L202;
            case 3309: goto L198;
            case 3449: goto L194;
            case 3464: goto L190;
            case 96708: goto L186;
            case 107431: goto L182;
            case 113011: goto L178;
            case 121037: goto L174;
            case 3035411: goto L170;
            case 3059573: goto L166;
            case 3075965: goto L162;
            case 3117317: goto L158;
            case 3118278: goto L154;
            case 3354221: goto L150;
            case 3374865: goto L146;
            case 3482377: goto L142;
            case 3752377: goto L138;
            case 77382239: goto L134;
            case 92925156: goto L130;
            case 93596489: goto L126;
            case 94431411: goto L122;
            case 96619240: goto L118;
            case 97692206: goto L114;
            case 100313324: goto L110;
            case 102831699: goto L107;
            case 103278564: goto L103;
            case 103739775: goto L99;
            case 104663296: goto L95;
            case 105832675: goto L91;
            case 106934911: goto L87;
            case 108372825: goto L83;
            case 108819690: goto L79;
            case 109236764: goto L75;
            case 110364486: goto L71;
            case 2039534506: goto L67;
            default: goto L249;
        };
    L249:
        r105 = -1;
    L250:
        switch(r105) {
            case 0: goto L296;
            case 1: goto L295;
            case 2: goto L294;
            case 3: goto L293;
            case 4: goto L292;
            case 5: goto L291;
            case 6: goto L290;
            case 7: goto L289;
            case 8: goto L288;
            case 9: goto L287;
            case 10: goto L286;
            case 11: goto L285;
            case 12: goto L284;
            case 13: goto L283;
            case 14: goto L282;
            case 15: goto L281;
            case 16: goto L280;
            case 17: goto L279;
            case 18: goto L278;
            case 19: goto L277;
            case 20: goto L276;
            case 21: goto L275;
            case 22: goto L274;
            case 23: goto L273;
            case 24: goto L293;
            case 25: goto L272;
            case 26: goto L271;
            case 27: goto L270;
            case 28: goto L269;
            case 29: goto L268;
            case 30: goto L267;
            case 31: goto L266;
            case 32: goto L265;
            case 33: goto L264;
            case 34: goto L263;
            case 35: goto L262;
            case 36: goto L261;
            case 37: goto L260;
            case 38: goto L259;
            case 39: goto L258;
            case 40: goto L257;
            case 41: goto L256;
            case 42: goto L255;
            case 43: goto L254;
            case 44: goto L253;
            case 45: goto L252;
            default: goto L297;
        };
    L252:
        r112 = AVMDLDataLoader.KeyIsEnableSpeedReport;
        goto L297
    L253:
        r112 = 215;
        goto L297
    L254:
        r112 = AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel;
        goto L297
    L255:
        r112 = AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue;
        goto L297
    L256:
        r112 = AVMDLDataLoader.KeyIsP2PConfigStr;
        goto L297
    L257:
        r112 = 8242;
        goto L297
    L258:
        r112 = 8254;
        goto L297
    L259:
        r112 = 8211;
        goto L297
    L260:
        r112 = 8212;
        goto L297
    L261:
        r112 = AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel;
        goto L297
    L262:
        r112 = AVMDLDataLoader.KeyIsEnableSpeedPredict;
        goto L297
    L263:
        r112 = 299;
        goto L297
    L264:
        r112 = 8260;
        goto L297
    L265:
        r112 = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME;
        goto L297
    L266:
        r112 = 711;
        goto L297
    L267:
        r112 = AVMDLDataLoader.KeyIsCustomUA;
        goto L297
    L268:
        r112 = 257;
        goto L297
    L269:
        r112 = 8243;
        goto L297
    L270:
        r112 = 8204;
        goto L297
    L271:
        r112 = 34;
        goto L297
    L272:
        r112 = 160;
        goto L297
    L273:
        r112 = 8194;
        goto L297
    L274:
        r112 = 8195;
        goto L297
    L275:
        r112 = 8595;
        goto L297
    L276:
        r112 = 169;
        goto L297
    L277:
        r112 = AVMDLDataLoader.KeyIsSpeedEngineSetting;
        goto L297
    L278:
        r112 = 8205;
        goto L297
    L279:
        r112 = 8207;
        goto L297
    L280:
        r112 = 8206;
        goto L297
    L281:
        r112 = 38;
        goto L297
    L282:
        r112 = 60;
        goto L297
    L283:
        r112 = 8804;
        goto L297
    L284:
        r112 = 62;
        goto L297
    L285:
        r112 = 8805;
        goto L297
    L286:
        r112 = 8201;
        goto L297
    L287:
        r112 = 8250;
        goto L297
    L288:
        r112 = 8240;
        goto L297
    L289:
        r112 = 183;
        goto L297
    L290:
        r112 = 8249;
        goto L297
    L291:
        r112 = VideoRef.VALUE_VIDEO_REF_CONST_DEPTH;
        goto L297
    L292:
        r112 = VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS;
        goto L297
    L293:
        r112 = 8230;
        goto L297
    L294:
        r112 = AVMDLDataLoader.KeyIsEnableSpeedEngine;
        goto L297
    L295:
        r112 = MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE;
        goto L297
    L296:
        r112 = 224;
    L297:
        if (r112 <= 0) goto L300;
        r103.append((char) r112);
        r104 = r114;
        goto L300
    L67:
        if (r116.equals("Dagger") == false) goto L249;
        r105 = 45;
        goto L250
    L71:
        if (r116.equals("times") == false) goto L249;
        r105 = 44;
        goto L250
    L75:
        if (r116.equals("sbquo") == false) goto L249;
        r105 = 43;
        goto L250
    L79:
        if (r116.equals("rsquo") == false) goto L249;
        r105 = 42;
        goto L250
    L83:
        if (r116.equals("rdquo") == false) goto L249;
        r105 = 41;
        goto L250
    L87:
        if (r116.equals("prime") == false) goto L249;
        r105 = 40;
        goto L250
    L91:
        if (r116.equals("oline") == false) goto L249;
        r105 = 39;
        goto L250
    L95:
        if (r116.equals("ndash") == false) goto L249;
        r105 = 38;
        goto L250
    L99:
        if (r116.equals("mdash") == false) goto L249;
        r105 = 37;
        goto L250
    L103:
        if (r116.equals("lsquo") == false) goto L249;
        r105 = 36;
        goto L250
    L107:
        if (r116.equals("ldquo") == true) goto L250;
    L110:
        if (r116.equals("imacr") == false) goto L249;
        r105 = 34;
        goto L250
    L114:
        if (r116.equals("frasl") == false) goto L249;
        r105 = 33;
        goto L250
    L118:
        if (r116.equals("emacr") == false) goto L249;
        r105 = 32;
        goto L250
    L122:
        if (r116.equals("caron") == false) goto L249;
        r105 = 31;
        goto L250
    L126:
        if (r116.equals("bdquo") == false) goto L249;
        r105 = 30;
        goto L250
    L130:
        if (r116.equals("amacr") == false) goto L249;
        r105 = 29;
        goto L250
    L134:
        if (r116.equals("Prime") == false) goto L249;
        r105 = 28;
        goto L250
    L138:
        if (r116.equals("zwnj") == false) goto L249;
        r105 = 27;
        goto L250
    L142:
        if (r116.equals("quot") == false) goto L249;
        r105 = 26;
        goto L250
    L146:
        if (r116.equals("nbsp") == false) goto L249;
        r105 = 25;
        goto L250
    L150:
        if (r116.equals("mldr") == false) goto L249;
        r105 = 24;
        goto L250
    L154:
        if (r116.equals("ensp") == false) goto L249;
        r105 = 23;
        goto L250
    L158:
        if (r116.equals("emsp") == false) goto L249;
        r105 = 22;
        goto L250
    L162:
        if (r116.equals("darr") == false) goto L249;
        r105 = 21;
        goto L250
    L166:
        if (r116.equals("copy") == false) goto L249;
        r105 = 20;
        goto L250
    L170:
        if (r116.equals("bull") == false) goto L249;
        r105 = 19;
        goto L250
    L174:
        if (r116.equals("zwj") == false) goto L249;
        r105 = 18;
        goto L250
    L178:
        if (r116.equals("rlm") == false) goto L249;
        r105 = 17;
        goto L250
    L182:
        if (r116.equals("lrm") == false) goto L249;
        r105 = 16;
        goto L250
    L186:
        if (r116.equals("amp") == false) goto L249;
        r105 = 15;
        goto L250
    L190:
        if (r116.equals("lt") == false) goto L249;
        r105 = 14;
        goto L250
    L194:
        if (r116.equals("le") == false) goto L249;
        r105 = HTTP.CR;
        goto L250
    L198:
        if (r116.equals("gt") == false) goto L249;
        r105 = 12;
        goto L250
    L202:
        if (r116.equals("ge") == false) goto L249;
        r105 = 11;
        goto L250
    L206:
        if (r116.equals("thinsp") == false) goto L249;
        r105 = 10;
        goto L250
    L210:
        if (r116.equals("rsaquo") == false) goto L249;
        r105 = 9;
        goto L250
    L214:
        if (r116.equals("permil") == false) goto L249;
        r105 = 8;
        goto L250
    L218:
        if (r116.equals("middot") == false) goto L249;
        r105 = 7;
        goto L250
    L222:
        if (r116.equals("lsaquo") == false) goto L249;
        r105 = 6;
        goto L250
    L226:
        if (r116.equals("igrave") == false) goto L249;
        r105 = 5;
        goto L250
    L230:
        if (r116.equals("iacute") == false) goto L249;
        r105 = 4;
        goto L250
    L234:
        if (r116.equals("hellip") == false) goto L249;
        r105 = 3;
        goto L250
    L238:
        if (r116.equals("dagger") == false) goto L249;
        r105 = 2;
        goto L250
    L242:
        if (r116.equals("cacute") == false) goto L249;
        r105 = 1;
        goto L250
    L246:
        if (r116.equals("agrave") == false) goto L249;
        r105 = 0;
    L60:
        r114 = -1;
    L299:
        r103.append(r110.charAt(r104));
        goto L300
    L304:
        return r103.toString();
    L8:
        if (r110.indexOf(38) >= 0) goto L10;
        return r110;
    }
}
