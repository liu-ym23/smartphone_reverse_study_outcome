package com.bytedance.ies.argus.util;

import android.net.Uri;
import android.os.Bundle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes19.dex */
public final class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246248a = 0;

    static {
    }

    public static String a(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return r110;
    L11:
        int r101 = StringsKt.indexOf$default(r110, "?", 0, false, 6, null);
        int r102 = StringsKt.indexOf$default(r110, "#", 0, false, 6, null);
        if (r101 != (-1)) goto L16;
        if (r102 != (-1)) goto L16;
        return r110;
    L16:
        if (r101 != (-1)) goto L22;
        if (r110 == null) goto L21;
        return r110.substring(0, r102);
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L22:
        if (r102 != (-1)) goto L28;
        if (r110 == null) goto L27;
        return r110.substring(0, r101);
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L28:
        int r103 = Math.min(r101, r102);
        if (r110 == null) goto L33;
        return r110.substring(0, r103);
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100;
    L9:
        return new Regex("\\\\u([0-9a-fA-F]{4})").replace(r100, CommonUtils$decodeUnicodeEscapes$1.INSTANCE);
    L5:
        r101 = false;
        goto L6
    }

    public static String c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getScheme();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L22;
        String r104 = r100.getScheme();
        if (r104 != null) goto L12;
    L14:
        if (r102 == true) goto L22;
        String r105 = l(r100, "a_surl");
        if (r105 != null) goto L23;
        String r106 = l(r100, "surl");
        if (r106 == null) goto L25;
        return r106;
    L25:
        return l(r100, "url");
    L23:
        return r105;
    L12:
        if (StringsKt.equals(r104, "https", true) != true) goto L14;
        r102 = true;
    L22:
        return r100.toString();
    L5:
        if (StringsKt.equals(r101, "http", true) != true) goto L7;
        r103 = true;
        goto L8
    }

    public static String d(String r100) {
        if (r100 != null) goto L14;
    L11:
        return null;
    L14:
        if (r100.length() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L11;
        return UriProtector.parse((String) ListProtector.get(StringsKt.split$default(r100, new String[]{"?"}, false, 0, 6, null), 0)).getHost();
    L6:
        r101 = false;
        goto L7
    }

    public static String e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(String.valueOf(System.identityHashCode(r100)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() > 2) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(CollectionsKt.drop(r101, 1), ".", null, null, 0, null, null, 62, null);
    }

    public static String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        int r101 = StringsKt.indexOf$default(r100, '?', 0, false, 6, null);
        if (r101 != (-1)) goto L6;
        return r100;
    L6:
        return r100.substring(0, r101);
    }

    public static boolean m(Deferred r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Boolean) BuildersKt.runBlocking$default(null, new CommonUtils$safelyAwait$1(20, r100, null), 1, null)).booleanValue();
    }

    public static void n(List r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ((Boolean) BuildersKt.runBlocking$default(null, new CommonUtils$safelyAwaitAll$1(r100, null), 1, null)).booleanValue();
    }

    public static Map o(Bundle r100) {
        if (r100 == null) goto L4;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        String r103 = (String) r102.next();
        String r104 = r100.getString(r103);     // Catch: Exception -> L13
        if (r104 == null) goto L7;
        r101.put(r103, r104);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        int r105 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.b("ArgusRouteTraceHandler", "safelyToMap, convert key " + r103 + " value failed, " + e, null, 12);
        goto L7
    L16:
        return MapsKt.toMap(r101);
    L4:
        return MapsKt.emptyMap();
    }

    public static String p(String r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return ArraysKt.joinToString$default(MessageDigest.getInstance("MD5").digest(r110.getBytes(Charsets.UTF_8)), "", null, null, 0, null, CommonUtils$toMD5$1.INSTANCE, 30, null);
    L5:
        return null;
    }

    public static boolean g(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "hostList");
        List r102 = r101;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L30;
        String r104 = (String) r103.next();
        if (Intrinsics.areEqual(r104, r100) == false) goto L13;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L9;
        return true;
    L13:
        if (StringsKt.endsWith$default(r100, "." + r104, false, 2, null) == true) goto L20;
        if (StringsKt.startsWith$default(r104, ".", false, 2, null) == true) goto L17;
    L19:
        r105 = false;
        goto L21
    L17:
        if (StringsKt.endsWith$default(r100, r104, false, 2, null) == false) goto L19;
    L30:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return false;
    }

    public static boolean h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(PatternProtector.compile(r101).matcher(r100).find()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L12;
        r103 = Boolean.FALSE;
    L12:
        return ((Boolean) r103).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static boolean i(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "matchUrlList");
        if (r101.isEmpty() == false) goto L5;
        return false;
    L5:
        List r102 = r101;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L21;
        if (h(r100, (String) r103.next()) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (r102.isEmpty() == false) goto L10;
        return false;
    }

    public static String j(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "whiteHostList");
        Iterator r102 = r101.iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();
        String r105 = (String) r104;
        if (Intrinsics.areEqual(r100, r105) == true) goto L9;
        boolean r106 = false;
        if (StringsKt.endsWith$default(r100, "." + r105, false, 2, null) == true) goto L9;
    L10:
        if (r106 == false) goto L3;
        r103 = r104;
    L9:
        r106 = true;
    L13:
        return (String) r103;
    }

    public static String l(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        return UriProtector.getQueryParameter(r100, r101);
    L5:
        return null;
    }
}
