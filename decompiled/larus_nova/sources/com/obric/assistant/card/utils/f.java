package com.obric.assistant.card.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f386553a = null;

    static {
        f386553a = new f();
    }

    public f() {
    }

    public static String b(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "fullUrl");
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return r100;
    L8:
        if (r101.isEmpty() == true) goto L84;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r101.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L30;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r107 = (String) r106.getKey();
        String r108 = (String) r106.getValue();
        if (r107.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L26;
        if (r108 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == true) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L12;
        r104.put(r106.getKey(), r106.getValue());
        goto L12
    L20:
        if (r108.length() == 0) goto L23;
        r110 = false;
    L26:
        r111 = false;
        goto L27
    L16:
        r109 = false;
        goto L17
    L30:
        if (r104.isEmpty() == false) goto L69;
        return r100;
    L69:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L61
        Uri r113 = UriProtector.parse(r100);     // Catch: Throwable -> L61
        String r114 = UriProtector.getQueryParameter(r113, "data");     // Catch: Throwable -> L61
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        if (r114.length() != 0) goto L39;
        r102 = true;
    L39:
        if (r102 == false) goto L41;
        String r115 = r100;
    L59:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L61
    L63:
        Object r117 = r100;
        if (Result.m9455isFailureimpl(r116) == true) goto L68;
        r117 = r116;
    L68:
        return (String) r117;
    L41:
        Iterator r118 = r104.entrySet().iterator();     // Catch: Throwable -> L61
    L43:
        if (r118.hasNext() == false) goto L48;
        Map.Entry r119 = (Map.Entry) r118.next();     // Catch: Throwable -> L61
        String r120 = (String) r119.getKey();     // Catch: Throwable -> L61
        String r121 = (String) r119.getValue();     // Catch: Throwable -> L61
        if (r121 != null) goto L47;
        r121 = "";
    L47:
        r114 = a(r114, r120, r121);     // Catch: Throwable -> L61
        goto L43
    L48:
        Uri.Builder r122 = r113.buildUpon().clearQuery();     // Catch: Throwable -> L61
        Iterator<T> r123 = UriProtector.getQueryParameterNames(r113).iterator();     // Catch: Throwable -> L61
    L50:
        if (r123.hasNext() == false) goto L58;
        String r124 = (String) r123.next();     // Catch: Throwable -> L61
        Iterator<T> r125 = UriProtector.getQueryParameters(r113, r124).iterator();     // Catch: Throwable -> L61
    L53:
        if (r125.hasNext() == false) goto L50;
        String r126 = (String) r125.next();     // Catch: Throwable -> L61
        if (Intrinsics.areEqual(r124, "data") == false) goto L57;
        r126 = r114;
    L57:
        r122.appendQueryParameter(r124, r126);     // Catch: Throwable -> L61
        goto L53
    L58:
        String r127 = r122.build().toString();     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r127);     // Catch: Throwable -> L61
        r115 = r127;
    L61:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L84:
        return r100;
    L5:
        r103 = false;
        goto L6
    }

    public static String a(String r100, String r101, String r102) {
        boolean r103 = true;
        if (r101.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return r100;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        return r100;
    L13:
        if (StringsKt.contains$default(r100, ";end", false, 2, null) == false) goto L23;
        String r105 = Uri.encode(r102);
        String r106 = ";S." + r101 + com.alipay.sdk.m.n.a.f25612h;
        Regex r107 = new Regex(Regex.Companion.escape(r106) + "[^;]*");
        if (r107.containsMatchIn(r100) == false) goto L19;
        return r107.replace(r100, r106 + r105);
    L19:
        return StringsKt.replace$default(r100, ";end", r106 + r105 + ";end", false, 4, null);
    L23:
        return r100;
    L5:
        r104 = false;
        goto L6
    }
}
