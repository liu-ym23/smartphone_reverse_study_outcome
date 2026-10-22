package com.bytedance.android.shopping.api.mall.common.tools;

import android.net.Uri;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v {
    public static final Map<String, String> f(Uri r9) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
        HashMap r2 = new HashMap();     // Catch: Throwable -> L33
        Iterator r3 = UriProtector.getQueryParameterNames(r9).iterator();     // Catch: Throwable -> L33
    L5:
        if (r3.hasNext() == false) goto L31;
        String r4 = (String) r3.next();     // Catch: Throwable -> L33
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L5;
        List r7 = UriProtector.getQueryParameters(r9, r4);     // Catch: Throwable -> L33
        ListIterator r8 = r7.listIterator(r7.size());     // Catch: Throwable -> L33
    L16:
        if (r8.hasPrevious() == false) goto L27;
        Object r10 = r8.previous();     // Catch: Throwable -> L33
        String r11 = (String) r10;     // Catch: Throwable -> L33
        if (r11 != null) goto L20;
    L23:
        boolean r12 = true;
    L25:
        if ((!r12) == false) goto L16;
    L28:
        String r13 = (String) r10;     // Catch: Throwable -> L33
        if (r13 == null) goto L5;
        String r5 = (String) r2.put(r4, r13);     // Catch: Throwable -> L33
        goto L5
    L20:
        if (StringsKt.isBlank(r11) == true) goto L23;
        r12 = false;
        goto L25
    L27:
        r10 = null;
        goto L28
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r6 = false;
        goto L13
    L31:
        Object r14 = Result.constructor-impl(r2);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r14) == true) goto L39;
        r0 = r14;
    L39:
        HashMap r15 = (HashMap) r0;
        if (r15 == null) goto L43;
        return r15;
    L43:
        return new HashMap();
    L33:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    }

    public static final String h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "link");
        if (StringsKt.startsWith$default(r4, "http", false, 2, null) == true) goto L6;
        return r4;
    L6:
        return "aweme://webview?url=" + URLEncoder.encode(r4, "utf-8");
    }

    public static final String c(String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "uri");
        Intrinsics.checkNotNullParameter(r8, "params");
        Uri r9 = UriProtector.parse(r7);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(f(r9));
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r2 = r8.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L19;
        Map.Entry<String, String> r3 = r2.next();
        boolean r5 = true;
        if (r3.getKey().length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
    L16:
        r5 = false;
    L17:
        if (r5 == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L11:
        if (r3.getValue().length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
    L13:
        r6 = false;
        goto L14
    L8:
        r4 = false;
        goto L9
    L19:
        r0.putAll(r1);
        SetsKt.plus(r8.entrySet(), f(r9).entrySet());
        Uri.Builder r10 = r9.buildUpon().clearQuery();
        Iterator r11 = r0.entrySet().iterator();
    L21:
        if (r11.hasNext() == false) goto L24;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.appendQueryParameter((String) r12.getKey(), (String) r12.getValue());
        goto L21
    L24:
        return r10.build().toString();
    }

    public static final String d(String r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r9, "link");
        Intrinsics.checkNotNullParameter(r10, "params");
        if (StringsKt.startsWith$default(r9, "http", false, 2, null) == false) goto L9;
        Intrinsics.checkNotNullParameter(r9, "link");
        Intrinsics.checkNotNullParameter(r10, "params");
        if (StringsKt.startsWith$default(r9, "http", false, 2, null) == true) goto L8;
        return r9;
    L8:
        return c(r9, r10);
    L9:
        String r6 = g(UriProtector.parse(r9), "url");
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        if (StringsKt.isBlank(r6) == true) goto L21;
        Intrinsics.checkNotNullParameter(r6, "link");
        Intrinsics.checkNotNullParameter(r10, "params");
        if (StringsKt.startsWith$default(r6, "http", false, 2, null) == false) goto L19;
        r6 = c(r6, r10);
    L19:
        return c(r9, MapsKt.mapOf(TuplesKt.to("url", r6)));
    L21:
        return r9;
    }

    public static final String g(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getQueryParameterSafely");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (r2.isHierarchical() == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(r2, r3);
    }

    public static String a(Map r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r11, "pageName");
        String r3 = null;
        if (r9 == null) goto L7;
        Object r4 = r9.get("history_path");
        if (r4 == null) goto L7;
        String r5 = r4.toString();
    L8:
        if (r9 == null) goto L12;
        Object r12 = r9.get(SimilarProductParam.ENTER_FROM);
        if (r12 == null) goto L12;
        r3 = r12.toString();
    L12:
        String r13 = "";
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        Intrinsics.checkNotNullParameter(r11, "pageName");
        Intrinsics.checkNotNullParameter(r5, "historyPath");
        boolean r1 = false;
        if (r5.length() != 0) goto L21;
        boolean r0 = true;
    L22:
        if (r0 == true) goto L26;
        r3 = r5;
    L26:
        if (r3.length() <= 0) goto L28;
        boolean r2 = true;
    L29:
        if (r2 == true) goto L31;
    L36:
        Uri r6 = UriProtector.parse(r10);     // Catch: Exception -> L65
        HashMap r7 = (HashMap) f(r6);     // Catch: Exception -> L65
        r7.put("history_path", r11);     // Catch: Exception -> L65
        CharSequence r8 = (CharSequence) r7.get("url");     // Catch: Exception -> L65
        if (r8 != null) goto L39;
    L42:
        boolean r14 = true;
    L43:
        if (r14 == true) goto L48;
        String r15 = (String) r7.get("url");     // Catch: Exception -> L65
        if (r15 != null) goto L47;
        r15 = "";
    L47:
        r7.put("url", d(r15, MapsKt.mapOf(TuplesKt.to("history_path", r11))));     // Catch: Exception -> L65
    L48:
        CharSequence r16 = (CharSequence) r7.get("surl");     // Catch: Exception -> L65
        if (r16 != null) goto L51;
    L52:
        r1 = true;
    L53:
        if (r1 == true) goto L59;
        String r17 = (String) r7.get("surl");     // Catch: Exception -> L65
        if (r17 == null) goto L58;
        r13 = r17;
    L58:
        r7.put("surl", d(r13, MapsKt.mapOf(TuplesKt.to("history_path", r11))));     // Catch: Exception -> L65
    L59:
        Uri.Builder r18 = r6.buildUpon().clearQuery();     // Catch: Exception -> L65
        Iterator r19 = r7.entrySet().iterator();     // Catch: Exception -> L65
    L61:
        if (r19.hasNext() == false) goto L63;
        Map.Entry r20 = (Map.Entry) r19.next();     // Catch: Exception -> L65
        r18.appendQueryParameter((String) r20.getKey(), (String) r20.getValue());     // Catch: Exception -> L65
        goto L61
    L63:
        return r18.build().toString();
    L51:
        if (StringsKt.isBlank(r16) == false) goto L53;
    L39:
        if (StringsKt.isBlank(r8) == true) goto L42;
        r14 = false;
        goto L43
    L31:
        if (r11.length() <= 0) goto L33;
        boolean r21 = true;
    L34:
        if (r21 == false) goto L36;
        r11 = e(r3, r11, 3);     // Catch: Exception -> L65
        goto L36
    L33:
        r21 = false;
        goto L34
    L28:
        r2 = false;
        goto L29
    L21:
        r0 = false;
    L65:
        e = move-exception;
        b0.l("com.bytedance.android.shopping.mall.homepage.tools addHistoryPath", e);
        return r10;
    L7:
        r5 = null;
        goto L8
    }

    public static final String e(String r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "historyPath");
        Intrinsics.checkNotNullParameter(r10, "enterFrom");
        List r12 = CollectionsKt.toMutableList(StringsKt.split$default(r9, new String[]{"__"}, false, 0, 6, null));
        if (r12.size() < r11) goto L5;
        ListProtector.remove(r12, 0);
    L5:
        r12.add(r10);
        return CollectionsKt.joinToString$default(r12, "__", null, null, 0, null, null, 62, null);
    }

    public static final String b(String r11, Map<String, String> r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "link");
        boolean r5 = true;
        if (r11.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L67;
        if (r12 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L69;
        if (StringsKt.startsWith$default(r11, "http", false, 2, null) == true) goto L18;
        Uri r7 = UriProtector.parse(r11);     // Catch: Exception -> L65
        String r9 = g(r7, "url");     // Catch: Exception -> L65
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == true) goto L29;
        Map r15 = MapsKt.toMutableMap(r12);     // Catch: Exception -> L65
        r15.put("url", c(Uri.decode(r9), r12));     // Catch: Exception -> L65
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L65
        return c(r11, r15);
    L29:
        if (r13 == true) goto L31;
        String r17 = g(r7, "anchor_url");     // Catch: Exception -> L65
        if (r17 != null) goto L35;
    L38:
        boolean r3 = true;
    L39:
        if (r3 == false) goto L41;
        String r18 = g(r7, "api_url");     // Catch: Exception -> L65
        if (r18 != null) goto L45;
    L48:
        boolean r2 = true;
    L49:
        if (r2 == false) goto L51;
        String r19 = g(r7, "surl");     // Catch: Exception -> L65
        if (StringsKt.startsWith$default(r11, "sslocal://polaris/lynx", false, 2, null) == false) goto L62;
        if (r19 != null) goto L56;
    L59:
        if (r5 == true) goto L62;
        return c(r11, MapsKt.mapOf(TuplesKt.to("surl", c(r19, r12))));
    L56:
        if (r19.length() == 0) goto L59;
        r5 = false;
    L62:
        if (r14 == true) goto L64;
        return r11;
    L64:
        return c(r11, r12);
    L51:
        return c(r11, MapsKt.mapOf(TuplesKt.to("api_url", c(r18, r12))));
    L45:
        if (r18.length() == 0) goto L48;
        r2 = false;
        goto L49
    L41:
        return c(r11, MapsKt.mapOf(TuplesKt.to("anchor_url", c(r17, r12))));
    L35:
        if (r17.length() == 0) goto L38;
        r3 = false;
        goto L39
    L31:
        return c(r11, r12);
    L22:
        if (r9.length() == 0) goto L25;
        r10 = false;
        goto L26
    L18:
        return c(r11, r12);
    L70:
        return r11;
    L69:
        return r11;
    L9:
        if (r12.isEmpty() == true) goto L12;
        r6 = false;
        goto L13
    L67:
        return r11;
    L5:
        r4 = false;
        goto L6
    }
}
