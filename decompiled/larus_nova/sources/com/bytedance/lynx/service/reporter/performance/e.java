package com.bytedance.lynx.service.reporter.performance;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f264926a = 0;

    static {
    }

    public static String b(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100;
    L12:
        if (StringsKt.startsWith$default(r100, "http://", false, 2, null) == false) goto L14;
    L77:
        String r103 = UriProtector.parse(r100).getPath();     // Catch: Exception -> L76
        if (r103 != null) goto L74;
        return r100;
    L74:
        return r103;
    L83:
        return r100;
    L14:
        if (StringsKt.startsWith$default(r100, "https://", false, 2, null) == true) goto L77;
        if (StringsKt.startsWith$default(r100, "local_file://", false, 2, null) == true) goto L77;
        if (StringsKt.startsWith$default(r100, "lynxview://", false, 2, null) == false) goto L21;
    L79:
        Uri r104 = UriProtector.parse(r100);     // Catch: Exception -> L75
        String r105 = UriProtector.getQueryParameter(r104, "surl");     // Catch: Exception -> L75
        if (r105 != null) goto L31;
        r105 = UriProtector.getQueryParameter(r104, "url");     // Catch: Exception -> L75
    L31:
        if (r105 != null) goto L33;
    L36:
        boolean r106 = true;
    L37:
        if (r106 == false) goto L39;
        String r107 = UriProtector.getQueryParameter(r104, "channel");     // Catch: Exception -> L75
        String r108 = UriProtector.getQueryParameter(r104, "bundle");     // Catch: Exception -> L75
        StringBuilder r109 = new StringBuilder();     // Catch: Exception -> L75
        if (r107 != null) goto L43;
    L46:
        boolean r110 = true;
    L47:
        if (r110 == true) goto L49;
        r109.append("channel=");     // Catch: Exception -> L75
        r109.append(r107);     // Catch: Exception -> L75
    L49:
        if (r108 != null) goto L51;
    L54:
        boolean r111 = true;
    L55:
        if (r111 == true) goto L64;
        if (r109.length() <= 0) goto L59;
        boolean r112 = true;
    L60:
        if (r112 == false) goto L62;
        r109.append("&");     // Catch: Exception -> L75
    L62:
        r109.append("bundle=");     // Catch: Exception -> L75
        r109.append(r108);     // Catch: Exception -> L75
        goto L64
    L59:
        r112 = false;
    L64:
        if (r109.length() > 0) goto L67;
        r101 = false;
    L67:
        if (r101 == true) goto L69;
        return r100;
    L69:
        return r109.toString();
    L51:
        if (r108.length() == 0) goto L54;
        r111 = false;
        goto L55
    L43:
        if (r107.length() == 0) goto L46;
        r110 = false;
        goto L47
    L39:
        return b(r105);
    L33:
        if (r105.length() == 0) goto L36;
        r106 = false;
        goto L37
    L81:
        return r100;
    L21:
        if (StringsKt.startsWith$default(r100, "aweme://", false, 2, null) == true) goto L79;
        if (StringsKt.startsWith$default(r100, "sslocal://", false, 2, null) == true) goto L79;
        if (StringsKt.startsWith$default(r100, "hybrid://", false, 2, null) == true) goto L79;
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static Number a(Number r100, Number r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L6;
        return -3;
    L6:
        return -1;
    L7:
        if (r101 == null) goto L9;
        double r102 = r100.doubleValue();
        double r103 = r101.doubleValue();
        if (r102 <= r103) goto L14;
        return -4;
    L14:
        return Double.valueOf(r103 - r102);
    L9:
        return -2;
    }

    public static Map c(Map r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        Intrinsics.checkNotNullParameter("Start", "startSuffix");
        Intrinsics.checkNotNullParameter("End", "endSuffix");
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashSet r112 = new LinkedHashSet();
        Iterator r113 = r110.entrySet().iterator();
    L4:
        if (r113.hasNext() == false) goto L26;
        Map.Entry r101 = (Map.Entry) r113.next();
        String r102 = (String) r101.getKey();
        Object r103 = r101.getValue();
        Map r104 = null;
        if (StringsKt.endsWith$default(r102, "Start", false, 2, null) == true) goto L7;
        if (StringsKt.endsWith$default(r102, "End", false, 2, null) == true) goto L10;
        boolean r105 = r103 instanceof Map;
        if (r105 == true) goto L13;
        r100.put(d(r111, r102), r103);
        goto L4
    L13:
        if (r105 == false) goto L15;
        r104 = (Map) r103;
    L15:
        if (r104 != null) goto L16;
        r100.put(d(r111, r102), r103);
        goto L4
    L16:
        Object r106 = r104.get("duration");
        Object r107 = r104.get("name");
        if (r106 == null) goto L23;
        if ((r107 instanceof String) == false) goto L23;
        if (Intrinsics.areEqual(r107, r102) == false) goto L23;
        r100.put(r102, r106);
    L23:
        r100.putAll(c(r104, r102));
        goto L4
    L10:
        String r108 = StringsKt.removeSuffix(r102, "End");
        e(r112, r110, r100, r111, r108, r108 + "Start", r102);
        goto L4
    L7:
        String r109 = StringsKt.removeSuffix(r102, "Start");
        e(r112, r110, r100, r111, r109, r102, r109 + "End");
        goto L4
    L26:
        return r100;
    }

    public static final String d(String r100, String r101) {
        if (r100 == null) goto L15;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        if (r101.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        String r104 = String.valueOf(r101.charAt(0)).toUpperCase(Locale.ROOT) + r101.substring(1);
    L10:
        r102.append(r104);
        String r105 = r102.toString();
        if (r105 != null) goto L14;
        return r101;
    L14:
        return r105;
    L9:
        r104 = r101;
        goto L10
    L6:
        r103 = false;
        goto L7
    L15:
        return r101;
    }

    public static final void e(Set<String> r100, Map<String, ? extends Object> r101, Map<String, Object> r102, String r103, String r104, String r105, String r106) {
        if (r100.contains(r104) == false) goto L5;
        return;
    L5:
        r100.add(r104);
        String r107 = d(r103, r104);
        Object r108 = r101.get(r105);
        Number r109 = null;
        if ((r108 instanceof Number) == false) goto L8;
        Number r110 = (Number) r108;
    L9:
        Object r111 = r101.get(r106);
        if ((r111 instanceof Number) == false) goto L12;
        r109 = (Number) r111;
    L12:
        r102.put(r107, a(r110, r109));
        return;
    L8:
        r110 = null;
        goto L9
    }
}
