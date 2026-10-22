package io.ktor.http;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public final class q {
    public static final List<j> a(String r110) {
        if (r110 == null) goto L115;
        Lazy r100 = LazyKt.lazy(LazyThreadSafetyMode.NONE, HttpHeaderValueParserKt$parseHeaderValue$items$1.INSTANCE);
        int r101 = 0;
    L7:
        if (r101 > StringsKt.getLastIndex(r110)) goto L92;
        Lazy r102 = LazyKt.lazy(LazyThreadSafetyMode.NONE, HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.INSTANCE);
        Integer r103 = null;
        int r104 = r101;
    L10:
        if (r104 > StringsKt.getLastIndex(r110)) goto L85;
        char r105 = r110.charAt(r104);
        if (r105 == ',') goto L13;
        if (r105 == ';') goto L20;
        r104 = r104 + 1;
        goto L10
    L20:
        if (r103 != null) goto L22;
        r103 = Integer.valueOf(r104);
    L22:
        int r106 = r104 + 1;
        int r107 = r106;
    L24:
        if (r107 > StringsKt.getLastIndex(r110)) goto L82;
        char r111 = r110.charAt(r107);
        boolean r112 = true;
        if (r111 == '=') goto L27;
        if (r111 == ';') goto L79;
        if (r111 == ',') goto L79;
        r112 = false;
    L79:
        if (r112 == true) goto L80;
        r107 = r107 + 1;
        goto L24
    L80:
        b(r102, r110, r106, r107, "");
    L83:
        r104 = r107;
        goto L10
    L27:
        int r113 = r107 + 1;
        if (r110.length() != r113) goto L30;
        Pair r108 = TuplesKt.to(Integer.valueOf(r113), "");
    L73:
        int r109 = ((Number) r108.component1()).intValue();
        b(r102, r110, r106, r107, (String) r108.component2());
        r104 = r109;
        goto L10
    L30:
        char r114 = r110.charAt(r113);
        char r115 = Typography.quote;
        if (r114 != '\"') goto L60;
        int r116 = r113 + 1;
        StringBuilder r117 = new StringBuilder();
    L34:
        if (r116 > StringsKt.getLastIndex(r110)) goto L59;
        char r118 = r110.charAt(r116);
        if (r118 != r115) goto L53;
        int r119 = r116 + 1;
        int r120 = r119;
    L39:
        if (r120 >= r110.length()) goto L44;
        if (r110.charAt(r120) != ' ') goto L44;
        r120 = r120 + 1;
    L44:
        if (r120 != r110.length()) goto L46;
    L49:
        boolean r121 = true;
    L50:
        if (r121 == false) goto L53;
        r108 = TuplesKt.to(Integer.valueOf(r119), r117.toString());
        goto L73
    L46:
        if (r110.charAt(r120) == ';') goto L49;
        r121 = false;
    L53:
        if (r118 == '\\') goto L55;
    L57:
        r117.append(r118);
        r116 = r116 + 1;
    L58:
        r115 = Typography.quote;
        goto L34
    L55:
        if (r116 >= (StringsKt.getLastIndex(r110) - 2)) goto L57;
        r117.append(r110.charAt(r116 + 1));
        r116 = r116 + 2;
        goto L58
    L59:
        r108 = TuplesKt.to(Integer.valueOf(r116), "\"" + r117.toString());
        goto L73
    L60:
        int r122 = r113;
    L62:
        if (r122 > StringsKt.getLastIndex(r110)) goto L72;
        char r123 = r110.charAt(r122);
        if (r123 == ';') goto L67;
        if (r123 == ',') goto L67;
        boolean r124 = false;
    L69:
        if (r124 == true) goto L70;
        r122 = r122 + 1;
        goto L62
    L70:
        r108 = TuplesKt.to(Integer.valueOf(r122), c(r110, r113, r122));
    L67:
        r124 = true;
        goto L69
    L72:
        r108 = TuplesKt.to(Integer.valueOf(r122), c(r110, r113, r122));
        goto L73
    L82:
        b(r102, r110, r106, r107, "");
        goto L83
    L13:
        ArrayList r125 = (ArrayList) r100.getValue();
        if (r103 == null) goto L16;
        int r126 = r103.intValue();
    L17:
        r125.add(new j(c(r110, r101, r126), d(r102)));
        r104 = r104 + 1;
    L90:
        r101 = r104;
        goto L7
    L16:
        r126 = r104;
        goto L17
    L85:
        ArrayList r127 = (ArrayList) r100.getValue();
        if (r103 == null) goto L88;
        int r128 = r103.intValue();
    L89:
        r127.add(new j(c(r110, r101, r128), d(r102)));
        goto L90
    L88:
        r128 = r104;
        goto L89
    L92:
        return d(r100);
    L115:
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> d(Lazy<? extends List<? extends T>> r100) {
        if (r100.isInitialized() == false) goto L6;
        return r100.getValue();
    L6:
        return CollectionsKt.emptyList();
    }

    public static final String c(String r100, int r101, int r102) {
        return StringsKt.trim(r100.substring(r101, r102)).toString();
    }

    public static final void b(Lazy<? extends ArrayList<k>> r100, String r101, int r102, int r103, String r104) {
        String r105 = c(r101, r102, r103);
        if (r105.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
        return;
    L8:
        r100.getValue().add(new k(r105, r104));
        return;
    L5:
        r106 = false;
        goto L6
    }
}
