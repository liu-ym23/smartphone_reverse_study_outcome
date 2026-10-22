package com.bytedance.kmp.ecom.arch.expr.parser;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.kmp.ecom.arch.expr.error.SlcExprException;
import com.bytedance.kmp.ecom.arch.expr.lexer.SlcTokenType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import ia6.d;
import java.util.ArrayList;
import ka6.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ka6.a f252116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f252117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f252118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f252119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final la6.a f252120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<Object> f252121f;

    public final void a() {
        this.f252118c = this.f252119d;
        ka6.a r100 = this.f252116a;
    L3:
        char r101 = r100.d();
        if (r101 == 65535) goto L8;
        if (CharsKt.isWhitespace(r101) == false) goto L8;
        r100.a();
    L8:
        int r102 = r100.f502190c;
        r100.f502189b = r102;
        boolean r103 = false;
        if (r102 < r100.f502188a.length()) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        b r105 = new b(32, "");
    L180:
        this.f252119d = r105;
        return;
    L14:
        char r106 = r100.a();
        if ('a' > r106) goto L18;
        if (r106 >= '{') goto L18;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L29;
        if ('A' > r106) goto L24;
        if (r106 >= '[') goto L24;
        boolean r108 = true;
    L25:
        if (r108 == true) goto L29;
        if (r106 == '_') goto L29;
        boolean r109 = false;
    L31:
        if (r109 == false) goto L75;
    L32:
        char r110 = r100.d();
        if ('a' > r110) goto L36;
        if (r110 >= '{') goto L36;
        boolean r111 = true;
    L37:
        if (r111 == true) goto L46;
        if ('A' > r110) goto L41;
        if (r110 >= '[') goto L41;
        boolean r112 = true;
    L42:
        if (r112 == true) goto L46;
        if (r110 == '_') goto L46;
        boolean r113 = false;
    L47:
        if (r113 == true) goto L74;
        if ('0' > r110) goto L51;
        if (r110 >= ':') goto L51;
        boolean r114 = true;
    L52:
        if (r114 == true) goto L74;
        String r115 = r100.f502188a;
        int r116 = r100.f502189b;
        int r117 = r100.f502190c;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.String");
        String r118 = r115.substring(r116, r117);
        int r119 = r118.hashCode();
        if (r119 == 3392903) goto L70;
        if (r119 == 3569038) goto L66;
        if (r119 == 97196323) goto L62;
    L71:
        b r120 = new b(0, r118);
    L72:
        r105 = r120;
        goto L180
    L62:
        if (r118.equals("false") == false) goto L71;
        r105 = new b(29, "false");
        goto L180
    L66:
        if (r118.equals("true") == false) goto L71;
        r105 = new b(28, "true");
        goto L180
    L70:
        if (r118.equals("null") == false) goto L71;
        r105 = new b(30, "null");
    L51:
        r114 = false;
    L74:
        r100.a();
    L41:
        r112 = false;
    L46:
        r113 = true;
    L36:
        r111 = false;
        goto L37
    L75:
        if ('0' > r106) goto L78;
        if (r106 >= ':') goto L78;
        boolean r121 = true;
    L79:
        if (r121 == false) goto L82;
        r105 = r100.c(false);
        goto L180
    L82:
        if (r106 == '!') goto L177;
        if (r106 == '\"') goto L141;
        if (r106 != '[') goto L87;
        r105 = new b(26, "[");
        goto L180
    L87:
        if (r106 == '|') goto L137;
        if (r106 != '~') goto L91;
        r105 = new b(18, Constants.WAVE_SEPARATOR);
        goto L180
    L91:
        if (r106 != ']') goto L93;
        r105 = new b(27, "]");
        goto L180
    L93:
        if (r106 == '^') goto L133;
        switch(r106) {
            case 37: goto L119;
            case 38: goto L116;
            case 39: goto L141;
            case 40: goto L114;
            case 41: goto L113;
            case 42: goto L110;
            case 43: goto L108;
            case 44: goto L107;
            case 45: goto L106;
            case 46: goto L99;
            case 47: goto L98;
            default: goto L95;
        };
    L95:
        switch(r106) {
            case 60: goto L130;
            case 61: goto L125;
            case 62: goto L121;
            default: goto L97;
        };
    L97:
        throw new SlcExprException("lexer_invalid_token", "invalid token: " + r106);
    L121:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L123;
        r105 = new b(12, ">=");
        goto L180
    L123:
        r105 = new b(11, ">");
        goto L180
    L125:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L128;
        r105 = new b(13, "==");
        goto L180
    L128:
        throw new SlcExprException("lexer_invalid_operator", "invalid operator:=");
    L130:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L132;
        r105 = new b(10, "<=");
        goto L180
    L132:
        r105 = new b(9, "<");
        goto L180
    L98:
        r105 = new b(6, HTTP.URL_DEFAULT);
        goto L180
    L99:
        char r122 = r100.d();
        if ('0' > r122) goto L103;
        if (r122 >= ':') goto L103;
        r103 = true;
    L103:
        if (r103 == false) goto L105;
        r105 = r100.c(true);
        goto L180
    L105:
        r105 = new b(22, ".");
        goto L180
    L106:
        r105 = new b(3, "-");
        goto L180
    L107:
        r105 = new b(23, ",");
        goto L180
    L108:
        r105 = new b(4, Marker.ANY_NON_NULL_MARKER);
        goto L180
    L113:
        r105 = new b(25, ")");
        goto L180
    L114:
        r105 = new b(24, "(");
        goto L180
    L119:
        r105 = new b(7, GXTemplateKey.GAIAX_PE);
        goto L180
    L110:
        if (r100.b('*') == false) goto L112;
        r105 = new b(8, "**");
        goto L180
    L112:
        r105 = new b(5, "*");
        goto L180
    L116:
        if (r100.b(Typography.amp) == false) goto L118;
        r105 = new b(16, "&&");
        goto L180
    L118:
        r105 = new b(19, "&");
        goto L180
    L133:
        r105 = new b(21, "^");
        goto L180
    L137:
        if (r100.b('|') == false) goto L139;
        r105 = new b(17, "||");
        goto L180
    L139:
        r105 = new b(20, HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L141:
        StringBuilder r123 = new StringBuilder();
        char r124 = r100.d();
    L142:
        if (r124 == r106) goto L171;
        if (r124 == 65535) goto L170;
        if (r124 != '\\') goto L166;
        if (r103 == true) goto L149;
        r123.append(r100.f502188a, r100.f502189b + 1, r100.f502190c);
        r103 = true;
    L149:
        r100.a();
        char r125 = r100.d();
        if (r125 == 65535) goto L165;
        if (r125 != 'b') goto L154;
        r123.append('\b');
    L168:
        r100.a();
        r124 = r100.d();
        goto L142
    L154:
        if (r125 != 'n') goto L156;
        r123.append('\n');
        goto L168
    L156:
        if (r125 != 'r') goto L158;
        r123.append('\r');
        goto L168
    L158:
        if (r125 == 't') goto L160;
        r123.append(r125);
        goto L168
    L160:
        r123.append('\t');
        goto L168
    L165:
        throw new SlcExprException("lexer_invalid_string", "unexpected eof after \\");
    L166:
        if (r103 == false) goto L168;
        r123.append(r124);
        goto L168
    L170:
        throw new SlcExprException("lexer_invalid_string", "unexpected eof");
    L171:
        r100.a();
        if (r103 == false) goto L174;
        String r126 = r123.toString();
    L175:
        r120 = new b(1, r126);
        goto L72
    L174:
        String r127 = r100.f502188a;
        int r128 = r100.f502189b + 1;
        int r129 = r100.f502190c - 1;
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type kotlin.String");
        r126 = r127.substring(r128, r129);
        goto L175
    L177:
        if (r100.b(com.alipay.sdk.m.n.a.f25612h) == false) goto L179;
        r105 = new b(14, "!=");
        goto L180
    L179:
        r105 = new b(15, "!");
    L78:
        r121 = false;
    L24:
        r108 = false;
    L29:
        r109 = true;
    L18:
        r107 = false;
        goto L20
    L11:
        r104 = false;
        goto L12
    }

    public final int c(byte r100) {
        this.f252120e.a(r100);
        byte r101 = (byte) 0;
        this.f252120e.a(r101);
        this.f252120e.a(r101);
        return this.f252120e.f508203b - 2;
    }

    public final boolean e(@SlcTokenType int r100) {
        if (this.f252119d.f502191a != r100) goto L6;
        a();
        return true;
    L6:
        return false;
    }

    public final void f(int r100) {
        la6.a r101 = this.f252120e;
        int r102 = r101.f508203b;
        int r103 = (r102 - r100) - 2;
        byte r104 = (byte) (r103 >>> 8);
        if (r100 >= r102) goto L11;
        byte[] r105 = r101.f508202a;
        r105[r100] = r104;
        int r106 = r100 + 1;
        byte r107 = (byte) (r103 & 255);
        if (r106 >= r102) goto L9;
        r105[r106] = r107;
        return;
    L9:
        throw new IndexOutOfBoundsException(r101.c("set", r106));
    L11:
        throw new IndexOutOfBoundsException(r101.c("set", r100));
    }

    public a(ka6.a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "lexer");
        this.f252116a = r100;
        this.f252117b = r101;
        this.f252118c = new b(32, "");
        this.f252119d = new b(32, "");
        this.f252120e = new la6.a();
        this.f252121f = new ArrayList();
    }

    public final void b(@SlcTokenType int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        if (this.f252119d.f502191a != r100) goto L7;
        a();
        return;
    L7:
        throw new SlcExprException("parser_syntax_error", r100 + ':' + this.f252119d.f502192b + ',' + r101);
    }

    public final void d(byte r100, byte r101, Object r102) {
        Intrinsics.checkNotNullParameter(r102, "arg");
        this.f252121f.add(r102);
        int r103 = this.f252121f.size() - 1;
        if (r103 > 127) goto L5;
        this.f252120e.a(r100);
        this.f252120e.a((byte) r103);
        return;
    L5:
        this.f252120e.a(r101);
        this.f252120e.a((byte) (r103 >>> 8));
        this.f252120e.a((byte) (r103 & 255));
    }
}
