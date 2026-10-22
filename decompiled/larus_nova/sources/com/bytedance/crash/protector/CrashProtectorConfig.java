package com.bytedance.crash.protector;

import android.os.Build;
import android.util.Pair;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.p;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CrashProtectorConfig {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f203331g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f203332h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f203333i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f203334j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static JSONObject f203335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static JSONObject f203336l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f203337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f203338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<String> f203339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f203340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f203341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f203342f;

    public static final enum ElfTag extends Enum<ElfTag> {
        public static final ElfTag ELF_BUILD_ID = null;
        public static final ElfTag ELF_NAME = null;
        public static final ElfTag ELF_PATH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ElfTag[] f203343a = null;

        static {
            ElfTag r100 = new ElfTag("ELF_BUILD_ID", 0);
            ELF_BUILD_ID = r100;
            ElfTag r101 = new ElfTag("ELF_PATH", 1);
            ELF_PATH = r101;
            ElfTag r102 = new ElfTag("ELF_NAME", 2);
            ELF_NAME = r102;
            f203343a = new ElfTag[]{r100, r101, r102};
        }

        public static ElfTag[] values() {
            return (ElfTag[]) f203343a.clone();
        }

        public static ElfTag valueOf(String r100) {
            return (ElfTag) r27.a.a(ElfTag.class, r100);
        }

        public ElfTag(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SymbolTag extends Enum<SymbolTag> {
        public static final SymbolTag SYMBOL_ALL = null;
        public static final SymbolTag SYMBOL_NAME = null;
        public static final SymbolTag SYMBOL_OFFSET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SymbolTag[] f203344a = null;

        static {
            SymbolTag r100 = new SymbolTag("SYMBOL_ALL", 0);
            SYMBOL_ALL = r100;
            SymbolTag r101 = new SymbolTag("SYMBOL_OFFSET", 1);
            SYMBOL_OFFSET = r101;
            SymbolTag r102 = new SymbolTag("SYMBOL_NAME", 2);
            SYMBOL_NAME = r102;
            f203344a = new SymbolTag[]{r100, r101, r102};
        }

        public static SymbolTag[] values() {
            return (SymbolTag[]) f203344a.clone();
        }

        public static SymbolTag valueOf(String r100) {
            return (SymbolTag) r27.a.a(SymbolTag.class, r100);
        }

        public SymbolTag(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f203331g = new byte[]{80, 82, 79, 84};
        f203332h = new byte[]{48, 48, 52};
        f203333i = new byte[]{120, 86, 52, 18};
        f203334j = PatternProtector.compile("^com\\.bytedance(\\.\\w+)*$");
        f203335k = null;
        f203336l = null;
    }

    public final void d() {
        JSONObject r100 = f203335k;
        JSONObject r101 = f203336l;
        if (r100 != null) goto L5;
        boolean r102 = false;
    L19:
        if (r102 == false) goto L448;
        this.f203342f = NativeBridge.G();
        a r103 = new a();
        r103.d(f203331g, 4);
        r103.d(f203332h, 3);
        if (this.f203342f == false) goto L24;
        int r104 = 2;
    L25:
        r103.e(r104);
        r103.d(f203333i, 4);
        int r105 = r103.c();
        int r106 = r103.c();
        r103.a(8);
        int r110 = r103.f203347b;
        if (r101 != null) goto L28;
        int r310 = r105;
        int r311 = r106;
        int r312 = r110;
        int r111 = 0;
    L354:
        p.e("config count: " + r111);
        if (r111 <= 0) goto L449;
        r103.g(r311, r103.f203347b - r312);
        r103.g(r310, r111);
        int r107 = 8;
        byte[] r108 = new byte[8];
        r103.a(8);
        byte[] r109 = r103.f203346a;
        int r112 = r103.f203347b;
        int r113 = 0;
    L358:
        if (r113 >= r112) goto L363;
        int r114 = 0;
    L360:
        if (r114 >= r107) goto L362;
        r108[r114] = (byte) (r108[r114] ^ r109[r113 + r114]);
        r114 = r114 + 1;
        r107 = 8;
        goto L360
    L362:
        r113 = r113 + 8;
        r107 = 8;
        goto L358
    L363:
        r103.d(r108, r107);
        this.f203340d = r103.f203346a;
        this.f203341e = r103.f203347b;
        return;
    L449:
        return;
    L28:
        Iterator<String> r115 = r101.keys();
        r111 = 0;
    L30:
        if (r115.hasNext() == false) goto L353;
        String r116 = r115.next();
        JSONObject r117 = r101.optJSONObject(r116);
        if (r117 != null) goto L40;
        String r118 = r101.optString(r116);
        if (r118.isEmpty() == false) goto L367;
    L38:
        if (r117 != null) goto L40;
    L367:
        r117 = new JSONObject(r118);     // Catch: Throwable -> L37
    L40:
        String r119 = r117.optString("scope");
        ArrayList<String> r120 = this.f203339c;
        ArrayList<String> r121 = this.f203338b;
        if (c(r119) == false) goto L65;
        int r122 = 0;
    L45:
        if (r122 >= r120.size()) goto L54;
        if (r119.startsWith((String) ListProtector.get(r120, r122)) == false) goto L53;
        if (((String) ListProtector.get(r120, r122)).length() == r119.length()) goto L65;
        if (r119.charAt(((String) ListProtector.get(r120, r122)).length()) == '.') goto L65;
    L53:
        r122 = r122 + 1;
        goto L45
    L54:
        int r123 = 0;
    L56:
        if (r123 >= r121.size()) goto L65;
        if (r119.startsWith((String) ListProtector.get(r121, r123)) == false) goto L64;
        if (((String) ListProtector.get(r121, r123)).length() == r119.length()) goto L63;
        if (r119.charAt(((String) ListProtector.get(r121, r123)).length()) != '.') goto L64;
    L63:
        boolean r124 = true;
    L66:
        if (r124 == false) goto L347;
        int r125 = r117.optInt("min_api_level", 0);
        int r126 = r117.optInt("max_api_level", 100);
        int r127 = Build.VERSION.SDK_INT;
        if (r127 < r125) goto L347;
        if (r127 > r126) goto L347;
        JSONArray r128 = r117.optJSONArray("api_levels");
        if (r128 == null) goto L84;
        int r129 = 0;
    L76:
        if (r129 >= r128.length()) goto L81;
        if (Build.VERSION.SDK_INT == r128.optInt(r129)) goto L79;
        r129 = r129 + 1;
        goto L76
    L79:
        boolean r130 = true;
    L82:
        if (r130 == true) goto L84;
    L81:
        r130 = false;
    L84:
        String r131 = r117.optString("abi", "both");
        if (r131.equals("both") == false) goto L87;
    L95:
        JSONArray r132 = r117.optJSONArray("signals");
        if (r132 == null) goto L160;
        long r210 = 0;
        int r133 = 0;
    L99:
        if (r133 >= r132.length()) goto L161;
        String r134 = r132.optString(r133);
        if (r134 != null) goto L103;
    L156:
        char r135 = 0;
    L157:
        if (r135 == 0) goto L159;
        r210 = r210 | (1 << r135);
    L159:
        r133 = r133 + 1;
        goto L99
    L103:
        if (r134.isEmpty() == true) goto L156;
        switch(r134.hashCode()) {
            case -1849149425: goto L141;
            case -1849145750: goto L137;
            case -1849142984: goto L133;
            case -1849132964: goto L129;
            case -1489105324: goto L125;
            case -1488651809: goto L121;
            case -1488566542: goto L117;
            case -1488524450: goto L113;
            case -274378251: goto L109;
            default: goto L144;
        };
    L144:
        byte r136 = -1;
    L145:
        switch(r136) {
            case 0: goto L155;
            case 1: goto L154;
            case 2: goto L153;
            case 3: goto L152;
            case 4: goto L151;
            case 5: goto L150;
            case 6: goto L149;
            case 7: goto L148;
            case 8: goto L147;
            default: goto L156;
        };
    L147:
        r135 = 16;
        goto L157
    L148:
        r135 = 5;
        goto L157
    L149:
        r135 = 11;
        goto L157
    L150:
        r135 = '\r';
        goto L157
    L151:
        r135 = 6;
        goto L157
    L152:
        r135 = 31;
        goto L157
    L153:
        r135 = 4;
        goto L157
    L154:
        r135 = '\b';
        goto L157
    L155:
        r135 = 7;
        goto L157
    L109:
        if (r134.equals("SIGSTKFLT") == false) goto L144;
        r136 = 8;
        goto L145
    L113:
        if (r134.equals("SIGTRAP") == false) goto L144;
        r136 = 7;
        goto L145
    L117:
        if (r134.equals("SIGSEGV") == false) goto L144;
        r136 = 6;
        goto L145
    L121:
        if (r134.equals("SIGPIPE") == false) goto L144;
        r136 = 5;
        goto L145
    L125:
        if (r134.equals("SIGABRT") == false) goto L144;
        r136 = 4;
        goto L145
    L129:
        if (r134.equals("SIGSYS") == false) goto L144;
        r136 = 3;
        goto L145
    L133:
        if (r134.equals("SIGILL") == false) goto L144;
        r136 = 2;
        goto L145
    L137:
        if (r134.equals("SIGFPE") == false) goto L144;
        r136 = 1;
        goto L145
    L141:
        if (r134.equals("SIGBUS") == false) goto L144;
        r136 = 0;
    L161:
        String r137 = r117.optString("abort_message");
        int r138 = r117.optInt("max_resume_count", 3);
        int r139 = r117.optInt("interval_time_ms", 3000);
        int r140 = r117.optInt("return_frame_index");
        if (r117.optInt("dump_all") == 0) goto L164;
        int r141 = 1;
    L165:
        int r142 = r117.optInt("max_ignore_depth_before_meet_first_match");
        JSONObject r211 = r101;
        if (r142 >= 0) goto L168;
        r142 = 0;
    L170:
        JSONArray r143 = r117.optJSONArray("backtraces");
        if (r143 != null) goto L173;
        String r313 = r137;
        int r314 = r105;
        String r410 = r119;
        int r315 = r138;
        int r411 = r142;
        int r316 = r106;
        int r412 = r139;
        int r317 = r110;
        Iterator<String> r212 = r115;
        int r318 = r111;
        int r144 = r140;
        a r145 = null;
        a r146 = null;
        boolean r147 = false;
        int r148 = 0;
        int r149 = 0;
    L263:
        if (r147 == false) goto L348;
        JSONObject r150 = r117.optJSONObject("registers");
        if (r150 != null) goto L268;
        ArrayList r151 = null;
    L317:
        r103.a(8);
        int r152 = r103.f203347b;
        int r153 = r103.c();
        r103.f(r141);
        r103.e(r410.getBytes().length);
        r103.e(r148);
        r103.e(r144);
        r103.e(r411);
        r103.e(r149);
        if (r151 != null) goto L320;
        int r154 = 0;
    L321:
        r103.e(r154);
        r103.f(r315);
        r103.f(r412);
        r103.a(8);
        r103.f((int) (r210 & BodyPartID.bodyIdMax));
        r103.f((int) ((r210 >>> 32) & BodyPartID.bodyIdMax));
        int r155 = r103.c();
        int r156 = r103.c();
        int r157 = r103.c();
        int r158 = r103.c();
        int r159 = r103.c();
        int r160 = r103.c();
        r103.g(r155, r103.f203347b - r152);
        byte[] r161 = r410.getBytes();
        r103.d(r161, r161.length);
        r103.e(0);
        if (r313 == null) goto L327;
        if (r313.isEmpty() == true) goto L327;
        r103.g(r156, r103.f203347b - r152);
        byte[] r162 = r313.getBytes();
        r103.d(r162, r162.length);
        r103.e(0);
    L327:
        r103.g(r157, r103.f203347b - r152);
        r103.d(r145.f203346a, r145.f203347b);
        r103.g(r158, r103.f203347b - r152);
        r103.d(r146.f203346a, r146.f203347b);
        if (r151 == null) goto L346;
        if (r151.isEmpty() == true) goto L346;
        r103.g(r159, r103.f203347b - r152);
        int r163 = 0;
    L333:
        if (r163 >= r151.size()) goto L336;
        r103.e(((Integer) ((Pair) ListProtector.get(r151, r163)).first).intValue());
        r163 = r163 + 1;
        goto L333
    L336:
        if (this.f203342f == false) goto L341;
        r103.a(8);
        r103.g(r160, r103.f203347b - r152);
        int r164 = 0;
    L339:
        if (r164 >= r151.size()) goto L346;
        long r165 = ((Long) ((Pair) ListProtector.get(r151, r164)).second).longValue();
        r103.a(8);
        r103.f((int) (r165 & BodyPartID.bodyIdMax));
        r103.f((int) ((r165 >>> 32) & BodyPartID.bodyIdMax));
        r164 = r164 + 1;
        goto L339
    L341:
        r103.a(4);
        r103.g(r160, r103.f203347b - r152);
        int r166 = 0;
    L343:
        if (r166 >= r151.size()) goto L346;
        r103.f(((Long) ((Pair) ListProtector.get(r151, r166)).second).intValue());
        r166 = r166 + 1;
    L346:
        r103.a(8);
        r103.g(r153, r103.f203347b - r152);
        String r167 = r410;
        this.f203337a.add(r167);
        p.e("add scope: ".concat(r167));
        boolean r168 = true;
    L349:
        if (r168 == false) goto L351;
        r111 = r318 + 1;
    L352:
        r101 = r211;
        r115 = r212;
        r105 = r314;
        r106 = r316;
        r110 = r317;
        goto L30
    L351:
        r111 = r318;
        goto L352
    L320:
        r154 = r151.size();
        goto L321
    L268:
        r151 = new ArrayList();
        Iterator<String> r169 = r150.keys();
    L270:
        if (r169.hasNext() == false) goto L317;
        String r170 = r169.next();
        if (r170.length() != 2) goto L270;
        char r171 = Character.toLowerCase(r170.charAt(0));
        int r172 = r170.charAt(1) - '0';
        if (r172 < 0) goto L270;
        if (this.f203342f == true) goto L280;
        if (r172 >= 4) goto L270;
        if (r171 != 'r') goto L270;
    L298:
        Long r173 = b(r150.opt(r170));
        if (r173 == null) goto L302;
        long r319 = r173.longValue();
    L308:
        if (r171 != 'w') goto L310;
    L313:
        r319 = r319 & BodyPartID.bodyIdMax;
    L315:
        if (r319 == 0) goto L270;
        r151.add(new Pair(Integer.valueOf(r172), Long.valueOf(r319)));
        goto L270
    L310:
        if (r171 == 's') goto L313;
        if (r171 != 'r') goto L315;
    L302:
        if (r171 != 'd') goto L305;
        r319 = Double.doubleToLongBits(r150.optDouble(r170));
        goto L308
    L305:
        if (r171 != 's') goto L307;
        r319 = Float.floatToIntBits((float) r150.optDouble(r170));
        goto L308
    L307:
        r319 = r150.optLong(r170);
        goto L308
    L280:
        if (r172 >= 8) goto L270;
        if (r171 == 'x') goto L289;
        if (r171 == 'w') goto L289;
        char r174 = Directory.UNIX_ID;
        if (r171 == 'd') goto L290;
        if (r171 != 's') goto L270;
    L290:
        if (r171 == r174) goto L292;
        if (r171 != 's') goto L298;
    L292:
        r172 = r172 + 34;
    L289:
        r174 = Directory.UNIX_ID;
    L348:
        r168 = false;
        goto L349
    L173:
        r212 = r115;
        int r175 = r143.length();
        int r213 = r140;
        if (r175 <= 255) goto L176;
        r175 = 255;
    L176:
        r146 = new a();
        r314 = r105;
        r145 = new a();
        r316 = r106;
        r317 = r110;
        int r176 = 0;
        int r177 = -1;
        int r320 = 0;
    L177:
        if (r176 >= r175) goto L258;
        int r321 = r175;
        JSONObject r178 = r143.optJSONObject(r176);
        JSONArray r322 = r143;
        if (r177 == (-1)) goto L181;
    L183:
        String r179 = r178.optString("elf_build_id");
        int r323 = r177;
        String r180 = r178.optString("elf_path");
        r318 = r111;
        String r181 = r178.optString("elf_name");
        if (r179.isEmpty() == true) goto L192;
        String r182 = r179.replace(" ", "");
        int r183 = r182.length() / 2;
        byte[] r184 = new byte[r183];
        r313 = r137;
        int r185 = 0;
    L186:
        if (r185 >= r183) goto L189;
        int r324 = r183;
        int r186 = r185 * 2;
        r412 = r139;
        r184[r185] = (byte) (CastIntegerProtector.parseInt(r182.substring(r186, r186 + 2), 16) & 255);     // Catch: Throwable -> L191
        r185 = r185 + 1;     // Catch: Throwable -> L191
        r182 = r182;
        r183 = r324;
        r139 = r412;
    L256:
        r410 = r119;
        r315 = r138;
        r411 = r142;
    L257:
        r144 = r213;
        r148 = r320;
        r149 = r321;
        r147 = false;
        goto L263
    L189:
        String r214 = r182;
        r412 = r139;
        ElfTag r187 = ElfTag.ELF_BUILD_ID;     // Catch: Throwable -> L191
        String r188 = r214;
    L202:
        if (r184 == null) goto L256;
        if (r184.length >= 256) goto L256;
        byte[] r189 = r145.f203346a;
        r315 = r138;
        int r190 = 0;
    L208:
        if (r190 >= r145.f203347b) goto L225;
        byte r191 = r189[r190];
        r411 = r142;
        byte r192 = r189[r190 + 1];
        r410 = r119;
        if (r191 == r187.ordinal()) goto L212;
    L223:
        byte[] r413 = r189;
    L224:
        r190 = r190 + (r192 + 3);
        r119 = r410;
        r142 = r411;
        r189 = r413;
        goto L208
    L212:
        if (r192 != r184.length) goto L223;
        int r193 = 0;
    L215:
        if (r193 >= r184.length) goto L220;
        r413 = r189;
        if (r189[(r190 + 2) + r193] != r184[r193]) goto L218;
        r193 = r193 + 1;
        r189 = r413;
        goto L215
    L218:
        boolean r194 = false;
    L221:
        if (r194 == false) goto L224;
    L226:
        int r195 = r145.f203347b;
        if (r190 > r195) goto L257;
        if (r190 != r195) goto L231;
        r320 = r320 + 1;
        r145.e(r187.ordinal());
        r145.e(r184.length);
        r145.d(r184, r184.length);
        r145.e(0);
    L231:
        r146.h(r190);
        if (r178.optInt("redacted_match") == 0) goto L235;
        r146.e(SymbolTag.SYMBOL_ALL.ordinal());
    L255:
        r176 = r176 + 1;
        r175 = r321;
        r143 = r322;
        r177 = r323;
        r111 = r318;
        r137 = r313;
        r138 = r315;
        r139 = r412;
        r119 = r410;
        r142 = r411;
        goto L177
    L235:
        if (r178.has("offset_start") == true) goto L237;
        String r196 = r178.optString("symbol_name");
        if (r196.isEmpty() == true) goto L257;
        r146.e(SymbolTag.SYMBOL_NAME.ordinal());
        byte[] r197 = r196.getBytes();
        r146.h(r197.length);
        r146.d(r197, r197.length);
        r146.e(0);
        goto L255
    L237:
        if (r188.isEmpty() == true) goto L257;
        Long r198 = b(r178.opt("offset_start"));
        if (r198 != null) goto L242;
        r198 = Long.valueOf(r178.optLong("offset_start"));
    L242:
        Long r199 = b(r178.opt("offset_next"));
        if (r199 != null) goto L246;
        r199 = Long.valueOf(r178.optLong("offset_next"));
    L246:
        if (r198.longValue() == 0) goto L257;
        if (r199.longValue() == 0) goto L257;
        if (r198.longValue() >= r199.longValue()) goto L257;
        r146.e(SymbolTag.SYMBOL_OFFSET.ordinal());
        r146.h(r198.longValue());
        r146.h(r199.longValue());
        goto L255
    L220:
        r413 = r189;
        r194 = true;
        goto L221
    L225:
        r410 = r119;
        r411 = r142;
        goto L226
    L192:
        r313 = r137;
        r412 = r139;
        if (r180.isEmpty() == true) goto L199;
        if (r180.charAt(0) != '/') goto L256;
        ElfTag r200 = ElfTag.ELF_PATH;
        r184 = r180.getBytes();
    L201:
        r187 = r200;
        r188 = r179;
        goto L202
    L199:
        if (r181.isEmpty() == true) goto L256;
        r200 = ElfTag.ELF_NAME;
        r184 = r181.getBytes();
        goto L201
    L181:
        if (r178.optInt("return_from_current_stack") == 0) goto L183;
        r177 = r176;
        goto L183
    L258:
        r313 = r137;
        r410 = r119;
        r315 = r138;
        r411 = r142;
        r412 = r139;
        int r325 = r175;
        r318 = r111;
        if (r177 != (-1)) goto L261;
        r141 = r141 | 2;
    L262:
        r144 = r213;
        r148 = r320;
        r149 = r325;
        r147 = true;
        goto L263
    L261:
        r213 = r177;
        goto L262
    L168:
        if (r142 <= 255) goto L170;
        r142 = 255;
        goto L170
    L164:
        r141 = 0;
        goto L165
    L160:
        r210 = 0;
        goto L161
    L87:
        if (this.f203342f == false) goto L91;
        if (r131.equals("arm64-v8a") == true) goto L95;
    L91:
        if (this.f203342f == true) goto L347;
        if (r131.equals("armeabi-v7a") == true) goto L95;
    L347:
        r211 = r101;
        r314 = r105;
        r316 = r106;
        r317 = r110;
        r212 = r115;
        r318 = r111;
    L64:
        r123 = r123 + 1;
    L65:
        r124 = false;
        goto L66
    L353:
        r310 = r105;
        r311 = r106;
        r312 = r110;
        goto L354
    L24:
        r104 = 1;
        goto L25
    L448:
        return;
    L5:
        Iterator<String> r201 = r100.keys();
        this.f203338b = new ArrayList();
        this.f203339c = new ArrayList();
    L7:
        if (r201.hasNext() == false) goto L18;
        String r202 = r201.next();
        if (c(r202) == false) goto L7;
        if (r100.optInt(r202) == 0) goto L14;
        boolean r203 = true;
    L15:
        if (r203 == true) goto L16;
        this.f203339c.add(r202);
        goto L7
    L16:
        this.f203338b.add(r202);
        goto L7
    L14:
        r203 = false;
        goto L15
    L18:
        p.e("white list size: " + this.f203338b.size());
        r102 = this.f203338b.isEmpty() ^ true;
        goto L19
    }

    public CrashProtectorConfig() {
        this.f203337a = new ArrayList();
        this.f203340d = null;
        this.f203341e = 0;
        this.f203342f = true;
    }

    public static boolean a(JSONObject r100) {
        if (f203335k != null) goto L6;
        f203335k = new JSONObject();
    L6:
        if (f203336l != null) goto L20;
        f203336l = new JSONObject();
    L20:
        String r101 = r100.optString("scope");     // Catch: Exception -> L17
        if (r101.isEmpty() == false) goto L12;
    L16:
        return false;
    L12:
        if (r101.startsWith("com.bytedance.") == false) goto L16;
        f203336l.put(r101, r100);     // Catch: Exception -> L17
        f203335k.put(r101, 1);     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        p.c(e.getMessage());
        return false;
    }

    public static Long b(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == true) goto L8;
        return null;
    L8:
        String r101 = (String) r100;
        if (r101.isEmpty() == false) goto L12;
        return null;
    L12:
        if (r101.startsWith("0x") == true) goto L20;
        if (r101.startsWith("0X") == true) goto L20;
    L18:
        return null;
    L20:
        return Long.valueOf(CastLongProtector.parseLong(r101.substring(2), 16));
    }

    public static boolean c(String r100) {
        if (r100.length() < 256) goto L5;
    L7:
        return false;
    L5:
        if (f203334j.matcher(r100).matches() == false) goto L7;
        return true;
    }

    public static void e(JSONObject r100) {
        if (r100 == null) goto L4;
        JSONObject r101 = r100.optJSONObject("scope_list");
        JSONObject r102 = r100.optJSONObject("config_list");
    L5:
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        if (r102 != null) goto L23;
        r102 = new JSONObject();
    L23:
        JSONObject r103 = f203336l;     // Catch: Exception -> L19
        if (r103 == null) goto L17;
        Iterator<String> r104 = r103.keys();     // Catch: Exception -> L19
    L13:
        if (r104.hasNext() == false) goto L17;
        JSONObject r105 = f203336l.optJSONObject(r104.next());     // Catch: Exception -> L19
        if (r105 == null) goto L13;
        String r106 = r105.optString("scope");     // Catch: Exception -> L19
        r102.put(r106, r105);     // Catch: Exception -> L19
        r101.put(r106, 1);     // Catch: Exception -> L19
    L17:
        r101.put("com.bytedance.__default__", 1);     // Catch: Exception -> L19
        r102.put("__default__.unwindstack.maps", "{ \"scope\": \"com.bytedance.__default__.unwindstack.maps\",\"signals\": [\"SIGSEGV\"], \"backtraces\":[ { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack6Global19FindAndReadVariableEPNS_4MapsEPKc\", \"return_from_current_stack\": 1 }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE14ForEachSymfileIZNS3_15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPmEUlPS1_E_EEbS6_mT_\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPm\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack8Unwinder14FillInDexFrameEv\" } ] } ");     // Catch: Exception -> L19
    L21:
        f203335k = r101;
        f203336l = r102;
        p.e("update config");
        return;
    L19:
        e = move-exception;
        p.c(e.getMessage());
        goto L21
    L4:
        r101 = null;
        r102 = null;
        goto L5
    }
}
