package io.ktor.http;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class h0 {
    public static final String b(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<String> r101 = r100.f491869h;
        if (r101.isEmpty() == false) goto L5;
        return "";
    L5:
        boolean r102 = true;
        if (r101.size() != 1) goto L15;
        if (((CharSequence) CollectionsKt.first(r101)).length() == 0) goto L11;
        r102 = false;
    L11:
        if (r102 == false) goto L18;
        return HTTP.URL_DEFAULT;
    L18:
        return (String) CollectionsKt.first(r101);
    L15:
        return CollectionsKt.joinToString$default(r101, HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
    }

    public static final void a(g0 r110, Appendable r111) {
        StringBuilder r112 = (StringBuilder) r111;
        r112.append(r110.f491862a.f491881a);
        String r100 = r110.f491862a.f491881a;
        boolean r113 = false;
        if (Intrinsics.areEqual(r100, "file") == false) goto L9;
        String r101 = r110.f491863b;
        String r102 = b(r110);
        r112.append("://");
        r112.append(r101);
        if (StringsKt.startsWith$default(r102, '/', false, 2, null) == true) goto L7;
        r112.append('/');
    L7:
        r112.append(r102);
        return;
    L9:
        if (Intrinsics.areEqual(r100, "mailto") == false) goto L18;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        StringBuilder r103 = new StringBuilder();
        String r104 = r110.f491866e;
        String r105 = r110.f491867f;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r104 == null) goto L17;
        r103.append(r104);
        if (r105 == null) goto L16;
        r103.append(':');
        r103.append(r105);
    L16:
        r103.append("@");
    L17:
        String r106 = r103.toString();
        String r107 = r110.f491863b;
        r112.append(":");
        r112.append(r106);
        r112.append(r107);
        return;
    L18:
        r112.append("://");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        StringBuilder r108 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r110, "<this>");
        StringBuilder r109 = new StringBuilder();
        String r114 = r110.f491866e;
        String r115 = r110.f491867f;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        if (r114 == null) goto L25;
        r109.append(r114);
        if (r115 == null) goto L24;
        r109.append(':');
        r109.append(r115);
    L24:
        r109.append("@");
    L25:
        r108.append(r109.toString());
        r108.append(r110.f491863b);
        int r116 = r110.f491864c;
        if (r116 != 0) goto L28;
    L30:
        r112.append(r108.toString());
        String r117 = b(r110);
        a0 r118 = r110.f491870i;
        boolean r119 = r110.f491865d;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Intrinsics.checkNotNullParameter(r117, "encodedPath");
        Intrinsics.checkNotNullParameter(r118, "encodedQueryParameters");
        if ((!StringsKt.isBlank(r117)) == true) goto L33;
    L35:
        r112.append(r117);
        if (r118.isEmpty() == false) goto L38;
        if (r119 == true) goto L38;
    L39:
        Set<Map.Entry<String, List<String>>> r120 = r118.entries();
        ArrayList r121 = new ArrayList();
        Iterator<T> r122 = r120.iterator();
    L41:
        if (r122.hasNext() == false) goto L51;
        Map.Entry r123 = (Map.Entry) r122.next();
        String r124 = (String) r123.getKey();
        List r125 = (List) r123.getValue();
        if (r125.isEmpty() == false) goto L45;
        List r126 = CollectionsKt.listOf(TuplesKt.to(r124, null));
    L50:
        CollectionsKt.addAll(r121, r126);
        goto L41
    L45:
        List r127 = r125;
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator r129 = r127.iterator();
    L47:
        if (r129.hasNext() == false) goto L49;
        r128.add(TuplesKt.to(r124, (String) r129.next()));
        goto L47
    L49:
        r126 = r128;
        goto L50
    L51:
        CollectionsKt.joinTo$default(r121, r111, "&", null, null, 0, null, URLUtilsKt$appendUrlFullPath$2.INSTANCE, 60, null);
        if (r110.f491868g.length() <= 0) goto L54;
        r113 = true;
    L54:
        if (r113 == false) goto L63;
        r112.append('#');
        r112.append(r110.f491868g);
        return;
    L63:
        return;
    L38:
        r112.append("?");
        goto L39
    L33:
        if (StringsKt.startsWith$default(r117, HTTP.URL_DEFAULT, false, 2, null) == true) goto L35;
        r112.append('/');
        goto L35
    L28:
        if (r116 == r110.f491862a.f491882b) goto L30;
        r108.append(":");
        r108.append(String.valueOf(r110.f491864c));
        goto L30
    }

    public static final void c(g0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (StringsKt.isBlank(r101) == false) goto L6;
        List<String> r102 = CollectionsKt.emptyList();
    L9:
        r100.d(r102);
        return;
    L6:
        if (Intrinsics.areEqual(r101, HTTP.URL_DEFAULT) == false) goto L8;
        r102 = i0.f491874a;
        goto L9
    L8:
        r102 = CollectionsKt.toMutableList(StringsKt.split$default(r101, new char[]{'/'}, false, 0, 6, null));
        goto L9
    }
}
