package io.ktor.http;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f491874a = null;

    static {
        f491874a = CollectionsKt.listOf("");
    }

    public static final g0 b(g0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "urlString");
        if (StringsKt.isBlank(r101) == false) goto L10;
        return r100;
    L10:
        c(r100, r101);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw new URLParserException(r101, th);
    }

    public static final void c(final g0 r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "urlString");
        int r100 = r211.length();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L9;
        if ((!CharsKt.isWhitespace(r211.charAt(r101))) == true) goto L10;
        r101 = r101 + 1;
    L10:
        int r102 = r211.length() - 1;
        if (r102 < 0) goto L18;
    L12:
        int r103 = r102 - 1;
        if ((!CharsKt.isWhitespace(r211.charAt(r102))) == true) goto L19;
        if (r103 < 0) goto L18;
        r102 = r103;
    L19:
        int r110 = r102 + 1;
        char r104 = r211.charAt(r101);
        if ('a' > r104) goto L23;
        if (r104 >= '{') goto L23;
        boolean r105 = true;
    L25:
        if (r105 == true) goto L32;
        if ('A' > r104) goto L29;
        if (r104 >= '[') goto L29;
        boolean r106 = true;
    L30:
        if (r106 == true) goto L32;
        int r107 = r101;
        int r108 = r107;
    L34:
        if (r107 >= r110) goto L70;
        char r109 = r211.charAt(r107);
        if (r109 == ':') goto L37;
        if (r109 == '/') goto L70;
        if (r109 == '?') goto L70;
        if (r109 == '#') goto L70;
        if (r108 != (-1)) goto L69;
        if ('a' > r109) goto L49;
        if (r109 >= '{') goto L49;
        boolean r111 = true;
    L50:
        if (r111 == true) goto L69;
        if ('A' > r109) goto L54;
        if (r109 >= '[') goto L54;
        boolean r112 = true;
    L55:
        if (r112 == true) goto L69;
        if ('0' > r109) goto L60;
        if (r109 >= ':') goto L60;
        boolean r113 = true;
    L61:
        if (r113 == true) goto L69;
        if (r109 == '.') goto L69;
        if (r109 == '+') goto L69;
        if (r109 == '-') goto L69;
        r108 = r107;
    L60:
        r113 = false;
    L54:
        r112 = false;
    L49:
        r111 = false;
    L69:
        r107 = r107 + 1;
        goto L34
    L37:
        if (r108 != (-1)) goto L40;
        int r114 = r107 - r101;
    L72:
        if (r114 <= 0) goto L74;
        String r115 = r211.substring(r101, r101 + r114);
        j0 r116 = j0.f491877c;
        j0 r117 = j0.a.a(r115);
        r210.getClass();
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r210.f491862a = r117;
        r101 = r101 + (r114 + 1);
    L74:
        int r118 = 0;
    L75:
        int r119 = r101 + r118;
        if (r119 >= r110) goto L80;
        if (r211.charAt(r119) != '/') goto L80;
        r118 = r118 + 1;
    L80:
        boolean r120 = Intrinsics.areEqual(r210.f491862a.f491881a, "file");
        String r121 = HTTP.URL_DEFAULT;
        if (r120 == false) goto L95;
        if (r118 != 2) goto L84;
        int r122 = StringsKt.indexOf$default(r211, '/', r119, false, 4, null);
        if (r122 == (-1)) goto L93;
        if (r122 == r110) goto L93;
        r210.e(r211.substring(r119, r122));
        h0.c(r210, r211.substring(r122, r110));
        return;
    L93:
        r210.e(r211.substring(r119, r110));
        return;
    L84:
        if (r118 != 3) goto L87;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r210.f491863b = "";
        h0.c(r210, HTTP.URL_DEFAULT + r211.substring(r119, r110));
        return;
    L87:
        throw new IllegalArgumentException("Invalid file url: ".concat(r211));
    L95:
        Integer r123 = null;
        String r124 = null;
        if (Intrinsics.areEqual(r210.f491862a.f491881a, "mailto") == false) goto L112;
        if (r118 != 0) goto L99;
        boolean r125 = true;
    L100:
        if (r125 == false) goto L111;
        int r126 = StringsKt.indexOf$default(r211, "@", r119, false, 4, null);
        if (r126 == (-1)) goto L109;
        String r127 = CodecsKt.d(r211.substring(r119, r126));
        if (r127 == null) goto L106;
        r124 = CodecsKt.f(r127, false);
    L106:
        r210.f491866e = r124;
        r210.e(r211.substring(r126 + 1, r110));
        return;
    L109:
        throw new IllegalArgumentException("Invalid mailto url: " + r211 + ", it should contain '@'.");
    L111:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L99:
        r125 = false;
        goto L100
    L112:
        if (r118 < 2) goto L146;
    L113:
        String r128 = r121;
        Integer r129 = Integer.valueOf(StringsKt.indexOfAny$default(r211, io.ktor.util.g.a("@/\\?#"), r119, false, 4, null));
        if (r129.intValue() <= 0) goto L116;
        boolean r130 = true;
    L117:
        if (r130 == true) goto L120;
        r129 = null;
    L120:
        if (r129 == null) goto L122;
        int r131 = r129.intValue();
    L123:
        if (r131 >= r110) goto L131;
        if (r211.charAt(r131) != '@') goto L131;
        int r132 = a(r211, r119, r131);
        if (r132 == (-1)) goto L129;
        r210.f491866e = r211.substring(r119, r132);
        r210.f491867f = r211.substring(r132 + 1, r131);
    L130:
        r119 = r131 + 1;
        r121 = r128;
        goto L113
    L129:
        r210.f491866e = r211.substring(r119, r131);
    L131:
        Integer r133 = Integer.valueOf(a(r211, r119, r131));
        if (r133.intValue() <= 0) goto L134;
        boolean r134 = true;
    L135:
        if (r134 == true) goto L138;
        r133 = null;
    L138:
        if (r133 == null) goto L140;
        int r135 = r133.intValue();
    L141:
        r210.e(r211.substring(r119, r135));
        int r136 = 1;
        int r137 = r135 + 1;
        if (r137 >= r131) goto L144;
        r210.f491864c = CastIntegerProtector.parseInt(r211.substring(r137, r131));
    L145:
        r119 = r131;
    L147:
        if (r119 >= r110) goto L149;
        if (r118 != 0) goto L156;
        List<String> r138 = CollectionsKt.dropLast(r210.f491869h, r136);
    L157:
        r210.d(r138);
        Integer r139 = Integer.valueOf(StringsKt.indexOfAny$default(r211, io.ktor.util.g.a("?#"), r119, false, 4, null));
        if (r139.intValue() <= 0) goto L160;
        boolean r140 = true;
    L161:
        if (r140 == true) goto L164;
        r139 = null;
    L164:
        if (r139 == null) goto L166;
        int r141 = r139.intValue();
    L167:
        if (r141 <= r119) goto L185;
        String r142 = r211.substring(r119, r141);
        if (r210.f491869h.size() == 1) goto L171;
    L176:
        List<String> r143 = r210.f491869h;
    L178:
        if (Intrinsics.areEqual(r142, r128) == false) goto L180;
        List<String> r144 = f491874a;
        int r145 = 1;
        boolean r146 = false;
    L181:
        if (r118 != r145) goto L183;
        List<String> r147 = f491874a;
    L184:
        r210.d(CollectionsKt.plus(r143, CollectionsKt.plus(r147, r144)));
        r119 = r141;
    L186:
        if (r119 < r110) goto L188;
    L201:
        if (r119 < r110) goto L203;
        return;
    L203:
        if (r211.charAt(r119) != '#') goto L233;
        String r148 = r211.substring(r119 + 1, r110);
        Intrinsics.checkNotNullParameter(r148, "<set-?>");
        r210.f491868g = r148;
        return;
    L233:
        return;
    L188:
        if (r211.charAt(r119) != '?') goto L201;
        int r149 = r119 + 1;
        if (r149 != r110) goto L192;
        r210.f491865d = true;
        r119 = r110;
        goto L201
    L192:
        Integer r150 = Integer.valueOf(StringsKt.indexOf$default(r211, '#', r149, false, 4, null));
        if (r150.intValue() <= 0) goto L195;
        r146 = true;
    L195:
        if (r146 == false) goto L197;
        r123 = r150;
    L197:
        if (r123 == null) goto L199;
        int r151 = r123.intValue();
    L200:
        e0.b(r211.substring(r149, r151)).d(new URLParserKt$parseQuery$1(r210));
        r119 = r151;
        goto L201
    L199:
        r151 = r110;
        goto L200
    L183:
        r147 = CollectionsKt.emptyList();
        goto L184
    L180:
        r146 = false;
        r144 = StringsKt.split$default(r142, new char[]{'/'}, false, 0, 6, null);
        r145 = 1;
        goto L181
    L171:
        if (((CharSequence) CollectionsKt.first(r210.f491869h)).length() != 0) goto L173;
        boolean r152 = true;
    L174:
        if (r152 == false) goto L176;
        r143 = CollectionsKt.emptyList();
        goto L178
    L173:
        r152 = false;
        goto L174
    L185:
        r146 = false;
        goto L186
    L166:
        r141 = r110;
        goto L167
    L160:
        r140 = false;
        goto L161
    L156:
        r138 = CollectionsKt.emptyList();
        goto L157
    L149:
        if (r211.charAt(r110 - r136) != '/') goto L151;
        List<String> r153 = f491874a;
    L152:
        r210.d(r153);
        return;
    L151:
        r153 = CollectionsKt.emptyList();
        goto L152
    L144:
        r210.f491864c = 0;
        goto L145
    L140:
        r135 = r131;
        goto L141
    L134:
        r134 = false;
        goto L135
    L122:
        r131 = r110;
        goto L123
    L116:
        r130 = false;
        goto L117
    L146:
        r128 = HTTP.URL_DEFAULT;
        r136 = 1;
        goto L147
    L40:
        throw new IllegalArgumentException("Illegal character in scheme at position " + r108);
    L70:
        r114 = -1;
    L29:
        r106 = false;
    L32:
        r107 = r101;
        r108 = -1;
    L23:
        r105 = false;
    L18:
        r102 = -1;
        goto L19
    L9:
        r101 = -1;
        goto L10
    }

    public static final int a(String r100, int r101, int r102) {
        boolean r103 = false;
    L3:
        if (r101 >= r102) goto L15;
        char r104 = r100.charAt(r101);
        if (r104 != '[') goto L8;
        r103 = true;
    L14:
        r101 = r101 + 1;
        goto L3
    L8:
        if (r104 != ']') goto L11;
        r103 = false;
        goto L14
    L11:
        if (r104 != ':') goto L14;
        if (r103 == true) goto L14;
        return r101;
    L15:
        return -1;
    }
}
