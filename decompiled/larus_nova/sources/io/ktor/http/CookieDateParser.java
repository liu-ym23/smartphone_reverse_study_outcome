package io.ktor.http;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.ktor.util.date.Month;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class CookieDateParser {
    public static hsc.a c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        f0 r100 = new f0(r110);
        e r101 = new e();
        r100.b(CookieDateParser$parse$1.INSTANCE);
    L3:
        boolean r102 = false;
        int r103 = 0;
        if (r100.f491859b >= r100.f491858a.length()) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L69;
        if (r100.c(CookieDateParser$parse$2.INSTANCE) == false) goto L3;
        int r105 = r100.f491859b;
        r100.b(CookieDateParser$parse$token$1$1.INSTANCE);
        String r106 = r100.f491858a.substring(r105, r100.f491859b);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r106, "token");
        if (r101.f491854c != null) goto L13;
    L16:
        f0 r107 = new f0(r106);
        int r108 = r107.f491859b;
        if (r107.a(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE) == false) goto L31;
        r107.a(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
        int r109 = CastIntegerProtector.parseInt(r107.f491858a.substring(r108, r107.f491859b));
        if (r107.a(CookieUtilsKt$tryParseTime$1.INSTANCE) == false) goto L31;
        int r111 = r107.f491859b;
        if (r107.a(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE) == false) goto L31;
        r107.a(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
        int r112 = CastIntegerProtector.parseInt(r107.f491858a.substring(r111, r107.f491859b));
        if (r107.a(CookieUtilsKt$tryParseTime$3.INSTANCE) == false) goto L31;
        int r113 = r107.f491859b;
        if (r107.a(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE) == false) goto L31;
        r107.a(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
        int r114 = CastIntegerProtector.parseInt(r107.f491858a.substring(r113, r107.f491859b));
        if (r107.a(CookieUtilsKt$tryParseTime$5.INSTANCE) == false) goto L67;
        r107.b(CookieUtilsKt$tryParseTime$6.INSTANCE);
    L67:
        r101.f491854c = Integer.valueOf(r109);
        r101.f491853b = Integer.valueOf(r112);
        r101.f491852a = Integer.valueOf(r114);
    L68:
        r100.b(CookieDateParser$parse$3.INSTANCE);
    L31:
        if (r101.f491855d != null) goto L40;
        f0 r115 = new f0(r106);
        int r116 = r115.f491859b;
        if (r115.a(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE) == false) goto L40;
        r115.a(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
        int r117 = CastIntegerProtector.parseInt(r115.f491858a.substring(r116, r115.f491859b));
        if (r115.a(CookieUtilsKt$tryParseDayOfMonth$1.INSTANCE) == false) goto L38;
        r115.b(CookieUtilsKt$tryParseDayOfMonth$2.INSTANCE);
    L38:
        r101.f491855d = Integer.valueOf(r117);
    L40:
        if (r101.f491856e != null) goto L50;
        if (r106.length() < 3) goto L50;
        Month[] r118 = Month.values();
        int r119 = r118.length;
        int r120 = 0;
    L44:
        if (r120 >= r119) goto L50;
        Month r121 = r118[r120];
        if (StringsKt.startsWith(r106, r121.getValue(), true) == true) goto L47;
        r120 = r120 + 1;
        goto L44
    L47:
        r101.f491856e = r121;
    L50:
        if (r101.f491857f != null) goto L68;
        f0 r122 = new f0(r106);
        int r123 = r122.f491859b;
        int r124 = 0;
    L53:
        if (r124 >= 2) goto L58;
        if (r122.a(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE) == false) goto L68;
        r124 = r124 + 1;
    L58:
        if (r103 >= 2) goto L60;
        r122.a(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
        r103 = r103 + 1;
        goto L58
    L60:
        int r125 = CastIntegerProtector.parseInt(r122.f491858a.substring(r123, r122.f491859b));
        if (r122.a(CookieUtilsKt$tryParseYear$1.INSTANCE) == false) goto L63;
        r122.b(CookieUtilsKt$tryParseYear$2.INSTANCE);
    L63:
        r101.f491857f = Integer.valueOf(r125);
        goto L68
    L13:
        if (r101.f491853b == null) goto L16;
        if (r101.f491852a != null) goto L31;
    L69:
        Integer r126 = r101.f491857f;
        IntRange r127 = new IntRange(70, 99);
        if (r126 != null) goto L72;
    L74:
        boolean r128 = false;
    L75:
        if (r128 == false) goto L77;
        Integer r129 = r101.f491857f;
        Intrinsics.checkNotNull(r129);
        r101.f491857f = Integer.valueOf(r129.intValue() + 1900);
    L85:
        a(r110, "day-of-month", r101.f491855d);
        a(r110, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, r101.f491856e);
        a(r110, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, r101.f491857f);
        a(r110, "time", r101.f491854c);
        a(r110, "time", r101.f491853b);
        a(r110, "time", r101.f491852a);
        IntRange r130 = new IntRange(1, 31);
        Integer r131 = r101.f491855d;
        if (r131 != null) goto L88;
    L90:
        boolean r132 = false;
    L91:
        b(r110, r132, CookieDateParser$parse$4.INSTANCE);
        Integer r133 = r101.f491857f;
        Intrinsics.checkNotNull(r133);
        if (r133.intValue() < 1601) goto L94;
        boolean r134 = true;
    L95:
        b(r110, r134, CookieDateParser$parse$5.INSTANCE);
        Integer r135 = r101.f491854c;
        Intrinsics.checkNotNull(r135);
        if (r135.intValue() > 23) goto L98;
        boolean r136 = true;
    L99:
        b(r110, r136, CookieDateParser$parse$6.INSTANCE);
        Integer r137 = r101.f491853b;
        Intrinsics.checkNotNull(r137);
        if (r137.intValue() > 59) goto L102;
        boolean r138 = true;
    L103:
        b(r110, r138, CookieDateParser$parse$7.INSTANCE);
        Integer r139 = r101.f491852a;
        Intrinsics.checkNotNull(r139);
        if (r139.intValue() > 59) goto L106;
        r102 = true;
    L106:
        b(r110, r102, CookieDateParser$parse$8.INSTANCE);
        Integer r140 = r101.f491852a;
        Intrinsics.checkNotNull(r140);
        int r141 = r140.intValue();
        Integer r142 = r101.f491853b;
        Intrinsics.checkNotNull(r142);
        int r143 = r142.intValue();
        Integer r144 = r101.f491854c;
        Intrinsics.checkNotNull(r144);
        int r145 = r144.intValue();
        Integer r146 = r101.f491855d;
        Intrinsics.checkNotNull(r146);
        int r147 = r146.intValue();
        Month r148 = r101.f491856e;
        Intrinsics.checkNotNull(r148);
        Integer r149 = r101.f491857f;
        Intrinsics.checkNotNull(r149);
        return io.ktor.util.date.a.a(r141, r143, r145, r147, r148, r149.intValue());
    L102:
        r138 = false;
        goto L103
    L98:
        r136 = false;
        goto L99
    L94:
        r134 = false;
        goto L95
    L88:
        if (r130.contains(r131.intValue()) == false) goto L90;
        r132 = true;
        goto L91
    L77:
        IntRange r150 = new IntRange(0, 69);
        if (r126 != null) goto L80;
    L82:
        boolean r151 = false;
    L83:
        if (r151 == false) goto L85;
        Integer r152 = r101.f491857f;
        Intrinsics.checkNotNull(r152);
        r101.f491857f = Integer.valueOf(r152.intValue() + 2000);
        goto L85
    L80:
        if (r150.contains(r126.intValue()) == false) goto L82;
        r151 = true;
        goto L83
    L72:
        if (r127.contains(r126.intValue()) == false) goto L74;
        r128 = true;
        goto L75
    L6:
        r104 = false;
        goto L7
    }

    public static void a(String r100, String r101, Object r102) {
        if (r102 == null) goto L5;
        return;
    L5:
        throw new InvalidCookieDateException(r100, "Could not find ".concat(r101));
    }

    public static void b(String r100, boolean r101, Function0 r102) {
        if (r101 == false) goto L5;
        return;
    L5:
        throw new InvalidCookieDateException(r100, (String) r102.invoke());
    }
}
