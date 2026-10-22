package com.bytedance.kmp.ecom.arch.expr.parser;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.kmp.ecom.arch.expr.error.SlcExprException;
import com.bytedance.kmp.ecom.arch.expr.lexer.SlcTokenType;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import ia6.d;
import ia6.e;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import ka6.b;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class SlcExprParser {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0082\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/ecom/arch/expr/parser/SlcExprParser$Precedence;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "slice-expr-kmp_release"}, k = 1, mv = {1, 7, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Precedence {
        public static final int ARRAY = 180;
        public static final int BIT_AND = 80;
        public static final int BIT_OR = 60;
        public static final int BIT_XOR = 70;
        public static final int CALL = 180;
        public static final int COMPARISON = 100;
        public static final a Companion = null;
        public static final int EQUALITY = 90;
        public static final int FACTOR = 130;
        public static final int GROUP = 190;
        public static final int INDEX = 180;
        public static final int LOGIC_AND = 50;
        public static final int LOGIC_OR = 40;
        public static final int NONE = 0;
        public static final int POWER = 140;
        public static final int TERM = 120;
        public static final int UNARY = 150;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f252115a = null;

            static {
                f252115a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f252115a;
        }
    }

    public static final class a {
    }

    static {
    }

    public SlcExprParser() {
    }

    @Precedence
    public static int b(@SlcTokenType int r100) {
        switch(r100) {
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L11;
            case 15: goto L3;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L3;
            case 19: goto L8;
            case 20: goto L7;
            case 21: goto L6;
            case 22: goto L5;
            case 23: goto L3;
            case 24: goto L4;
            case 25: goto L3;
            case 26: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 190;
    L5:
        return 180;
    L6:
        return 70;
    L7:
        return 60;
    L8:
        return 80;
    L9:
        return 40;
    L10:
        return 50;
    L11:
        return 90;
    L12:
        return 100;
    L13:
        return 140;
    L14:
        return 130;
    L15:
        return 120;
    }

    public static ma6.a a(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "expr");
        com.bytedance.kmp.ecom.arch.expr.parser.a r102 = new com.bytedance.kmp.ecom.arch.expr.parser.a(new ka6.a(r100), r101);
        r102.a();
        d(r102, 0);
        if (r102.f252119d.f502191a != 32) goto L7;
        return new ma6.a(r102.f252120e, r102.f252121f);
    L7:
        throw c("parser_needless_token", "invalid token: " + r102.f252119d);
    }

    public static SlcExprException c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "msg");
        return new SlcExprException(r100, r101);
    }

    public static void d(com.bytedance.kmp.ecom.arch.expr.parser.a r110, @Precedence int r111) {
        r110.a();
        b r100 = r110.f252118c;
        int r101 = r100.f502191a;
        if (r101 != 32) goto L6;
        return;
    L6:
        if (r101 == 0) goto L55;
        if (r101 != 1) goto L9;
        r110.d((byte) 0, (byte) 1, r100.f502192b);
    L169:
        if (r111 >= b(r110.f252119d.f502191a)) goto L210;
        r110.a();
        b r102 = r110.f252118c;
        int r103 = r102.f502191a;
        switch(r103) {
            case 3: goto L185;
            case 4: goto L185;
            case 5: goto L185;
            case 6: goto L185;
            case 7: goto L185;
            case 8: goto L185;
            case 9: goto L185;
            case 10: goto L185;
            case 11: goto L185;
            case 12: goto L185;
            case 13: goto L185;
            case 14: goto L185;
            case 15: goto L173;
            case 16: goto L183;
            case 17: goto L181;
            case 18: goto L173;
            case 19: goto L185;
            case 20: goto L185;
            case 21: goto L185;
            case 22: goto L175;
            case 23: goto L173;
            case 24: goto L173;
            case 25: goto L173;
            case 26: goto L174;
            default: goto L173;
        };
    L185:
        int r104 = b(r103);
        if (r103 != 8) goto L188;
        boolean r105 = true;
    L189:
        if (r105 == false) goto L214;
        r104 = r104 - 1;
    L214:
        d(r110, r104);     // Catch: Throwable -> L211
        switch(r103) {
            case 3: goto L209;
            case 4: goto L208;
            case 5: goto L207;
            case 6: goto L206;
            case 7: goto L205;
            case 8: goto L204;
            case 9: goto L203;
            case 10: goto L202;
            case 11: goto L201;
            case 12: goto L200;
            case 13: goto L199;
            case 14: goto L198;
            case 15: goto L197;
            case 16: goto L169;
            case 17: goto L169;
            case 18: goto L169;
            case 19: goto L196;
            case 20: goto L195;
            case 21: goto L194;
            default: goto L169;
        };
    L197:
        r110.f252120e.a((byte) 75);
        goto L169
    L198:
        r110.f252120e.a((byte) 82);
        goto L169
    L199:
        r110.f252120e.a((byte) 81);
        goto L169
    L200:
        r110.f252120e.a((byte) 84);
        goto L169
    L201:
        r110.f252120e.a((byte) 83);
        goto L169
    L202:
        r110.f252120e.a((byte) 86);
        goto L169
    L203:
        r110.f252120e.a((byte) 85);
        goto L169
    L204:
        r110.f252120e.a((byte) 67);
        goto L169
    L205:
        r110.f252120e.a((byte) 66);
        goto L169
    L206:
        r110.f252120e.a((byte) 65);
        goto L169
    L207:
        r110.f252120e.a((byte) 64);
        goto L169
    L208:
        r110.f252120e.a((byte) 62);
        goto L169
    L209:
        r110.f252120e.a((byte) 63);
        goto L169
    L194:
        r110.f252120e.a((byte) 74);
        goto L169
    L195:
        r110.f252120e.a((byte) 73);
        goto L169
    L196:
        r110.f252120e.a((byte) 72);
    L211:
        th = move-exception;
        throw th;
    L188:
        r105 = false;
        goto L189
    L173:
        throw c("parser_internal_error", r102 + ": no infix fn");
    L174:
        d(r110, 0);
        r110.b(27, "Expect ']' after index");
        r110.f252120e.a((byte) 92);
        goto L169
    L175:
        r110.b(0, "Expect property name after '.'");
        if (r110.e(24) == true) goto L180;
        r110.d((byte) 25, (byte) 26, r110.f252118c.f502192b);
        goto L169
    L180:
        throw c("parser_syntax_error", "不支持成员方法:" + r110.f252118c.f502192b);
    L181:
        int r106 = r110.c((byte) 96);
        r110.f252120e.a((byte) 99);
        d(r110, 40);
        r110.f(r106);
        goto L169
    L183:
        int r107 = r110.c((byte) 97);
        r110.f252120e.a((byte) 99);
        d(r110, 50);
        r110.f(r107);
        goto L169
    L210:
        return;
    L9:
        if (r101 != 2) goto L11;
        r110.d((byte) 0, (byte) 1, Double.valueOf(CastDoubleProtector.parseDouble(r100.f502192b)));
        goto L169
    L11:
        if (r101 != 3) goto L13;
    L45:
        d(r110, 150);
        if (r101 == 3) goto L52;
        if (r101 == 15) goto L51;
        if (r101 != 18) goto L169;
        r110.f252120e.a((byte) 71);
        goto L169
    L51:
        r110.f252120e.a((byte) 75);
        goto L169
    L52:
        r110.f252120e.a(Base64.padSymbol);
        goto L169
    L13:
        if (r101 == 4) goto L45;
        if (r101 == 15) goto L45;
        if (r101 == 18) goto L45;
        if (r101 == 24) goto L44;
        if (r101 == 26) goto L31;
        switch(r101) {
            case 28: goto L25;
            case 29: goto L25;
            case 30: goto L25;
            case 31: goto L22;
            default: goto L20;
        };
    L25:
        switch(r101) {
            case 28: goto L30;
            case 29: goto L29;
            case 30: goto L28;
            default: goto L27;
        };
    L28:
        r110.f252120e.a((byte) 4);
        goto L169
    L29:
        r110.f252120e.a((byte) 3);
        goto L169
    L30:
        r110.f252120e.a((byte) 2);
        goto L169
    L27:
        throw c("parser_internal_error", "invalid literal:" + r110.f252118c);
    L20:
        throw c("parser_internal_error", r100 + ": no prefix fn");
    L22:
        if ("0".equals(r100.f502192b) == false) goto L24;
        r110.f252120e.a((byte) 5);
        goto L169
    L24:
        r110.d((byte) 0, (byte) 1, Long.valueOf(CastLongProtector.parseLong(r110.f252118c.f502192b)));
        goto L169
    L31:
        int r108 = 0;
    L32:
        int r109 = r110.f252119d.f502191a;
        if (r109 == 23) goto L43;
        if (r109 == 27) goto L37;
        d(r110, 0);
        r108 = r108 + 1;
        if (r110.e(23) == true) goto L32;
    L37:
        r110.b(27, "array:Expect ']' after array arguments.");
        r110.f252120e.a((byte) 91);
        if (r108 > 127) goto L41;
        r110.f252120e.a((byte) r108);
        goto L169
    L41:
        throw c("parser_invalid_array", "array的最大长度为127: " + r108);
    L43:
        throw c("parser_syntax_error", "array: Unexpected token ','");
    L44:
        d(r110, 0);
        r110.b(25, "Expect ')' after expression");
        goto L169
    L55:
        String r112 = r100.f502192b;
        if (r110.e(24) == false) goto L162;
        if (Intrinsics.areEqual(r112, "option") == false) goto L84;
        int r113 = r110.f252119d.f502191a;
        if (r113 == 23) goto L83;
        if (r113 == 25) goto L81;
        d(r110, 0);
        r110.f252120e.a((byte) 29);
        int r114 = r110.c((byte) 97);
        r110.f252120e.a((byte) 99);
        if (r110.e(23) == false) goto L79;
        if (r110.e(25) == true) goto L79;
        d(r110, 0);
        int r115 = r110.c((byte) 98);
        r110.f(r114);
        r110.f252120e.a((byte) 99);
        if (r110.e(23) == false) goto L77;
        if (r110.e(25) == true) goto L77;
        d(r110, 0);
        r110.e(23);
        if (r110.e(25) == false) goto L75;
        r110.f(r115);
        goto L169
    L75:
        throw c("parser_error_param_count", "option函数只能有三个参数:>3");
    L77:
        throw c("parser_error_param_count", "option函数必须有三个参数:2");
    L79:
        throw c("parser_error_param_count", "option函数必须有三个参数:1");
    L81:
        throw c("parser_error_param_count", "option函数必须有三个参数:0");
    L83:
        throw c("parser_error_param_count", "option函数必须有三个参数:0");
    L84:
        int r116 = 0;
    L85:
        int r117 = r110.f252119d.f502191a;
        if (r117 == 23) goto L160;
        if (r117 == 25) goto L91;
        d(r110, 0);
        r116 = r116 + 1;
        if (r110.e(23) == true) goto L85;
    L91:
        r110.b(25, "argumentList:Expect ')' after arguments.");
        switch(r112.hashCode()) {
            case -1411068134: goto L147;
            case -1289044198: goto L143;
            case -1214085344: goto L139;
            case -891992059: goto L135;
            case -501711356: goto L131;
            case 96370: goto L127;
            case 102230: goto L123;
            case 107029: goto L119;
            case 3049733: goto L115;
            case 97526796: goto L111;
            case 108704142: goto L107;
            case 110640556: goto L103;
            case 832583822: goto L99;
            case 1076958445: goto L95;
            default: goto L150;
        };
    L150:
        d r118 = r110.f252117b;
        if (r118 == null) goto L156;
        Map<String, ia6.b> r119 = r118.f488923a;
        if (r119 == null) goto L156;
        Object r120 = (ia6.b) r119.get(r112);
        if (r120 == null) goto L156;
    L157:
        r110.d((byte) 27, (byte) 28, r120);
    L158:
        r110.f252120e.a((byte) r116);
    L156:
        r120 = new e(r112);
        goto L157
    L95:
        if (r112.equals("versionCompare") == false) goto L150;
        r110.f252120e.a((byte) 35);
        goto L158
    L99:
        if (r112.equals("makeMap") == false) goto L150;
        r110.f252120e.a((byte) 33);
        goto L158
    L103:
        if (r112.equals("trunc") == false) goto L150;
        r110.f252120e.a((byte) 39);
        goto L158
    L107:
        if (r112.equals("round") == false) goto L150;
        r110.f252120e.a((byte) 38);
        goto L158
    L111:
        if (r112.equals("floor") == false) goto L150;
        r110.f252120e.a((byte) 37);
        goto L158
    L115:
        if (r112.equals("ceil") == false) goto L150;
        r110.f252120e.a((byte) 36);
        goto L158
    L119:
        if (r112.equals("len") == false) goto L150;
        r110.f252120e.a((byte) 30);
        goto L158
    L123:
        if (r112.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L150;
        r110.f252120e.a((byte) 31);
        goto L158
    L127:
        if (r112.equals("abs") == false) goto L150;
        r110.f252120e.a((byte) 40);
        goto L158
    L131:
        if (r112.equals("mergeMap") == false) goto L150;
        r110.f252120e.a((byte) 34);
        goto L158
    L135:
        if (r112.equals("strcat") == false) goto L150;
        r110.f252120e.a((byte) 32);
        goto L158
    L139:
        if (r112.equals("cssColor") == false) goto L150;
        r110.f252120e.a((byte) 41);
        goto L158
    L143:
        if (r112.equals(GXTemplateKey.GAIAX_EXTEND) == false) goto L150;
        r110.f252120e.a((byte) 43);
        goto L158
    L147:
        if (r112.equals("append") == false) goto L150;
        r110.f252120e.a((byte) 42);
        goto L158
    L160:
        throw c("parser_syntax_error", "argumentList: Unexpected token ','");
    L162:
        if (Intrinsics.areEqual(r112, "data") == false) goto L165;
        r110.f252120e.a(HTTP.CR);
        goto L169
    L165:
        if (Intrinsics.areEqual(r112, MapController.ITEM_LAYER_TAG) == false) goto L167;
        r110.f252120e.a((byte) 14);
        goto L169
    L167:
        r110.d((byte) 11, (byte) 12, r112);
        goto L169
    }
}
