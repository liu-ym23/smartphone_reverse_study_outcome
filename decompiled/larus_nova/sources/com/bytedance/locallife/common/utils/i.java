package com.bytedance.locallife.common.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f257150a = null;

    public i() {
    }

    static {
        f257150a = CollectionsKt.listOf(new String[]{"url", "rn_schema", "fallback_url"});
    }

    public static String a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(f257150a, "secLevelParamsTarget");
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L19;
        if (r101 != null) goto L16;
        String r102 = r100;
    L12:
        return UriProtector.parse(r102).toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return r100;
    L16:
        r102 = c(r100, r101);     // Catch: Exception -> L9
        goto L12
    L19:
        return r100;
    }

    public static String c(String r100, Map r101) {
        LinkedHashSet r102 = new LinkedHashSet();
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = r103.buildUpon().clearQuery();
        Set<String> r105 = UriProtector.getQueryParameterNames(r103);
        if (r105 == null) goto L13;
        Iterator<T> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L13;
        String r107 = (String) r106.next();
        if (r101.containsKey(r107) == true) goto L9;
        r104.appendQueryParameter(r107, UriProtector.getQueryParameter(r103, r107));
        goto L6
    L9:
        String r108 = (String) r101.get(r107);
        if (j.a(r108) == false) goto L6;
        r104.appendQueryParameter(r107, r108);
        r102.add(r107);
    L13:
        Iterator r109 = r101.entrySet().iterator();
    L15:
        if (r109.hasNext() == false) goto L22;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (r102.contains(r110.getKey()) == true) goto L15;
        int r111 = j.f257151a;
        if (j.a((String) r110.getValue()) == false) goto L15;
        r104.appendQueryParameter((String) r110.getKey(), (String) r110.getValue());
        goto L15
    L22:
        return r104.build().toString();
    }

    public static String b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r103 = true;
        if (r101.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L36;
        if (r102 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L38;
        int r106 = r100.length();
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L25;
        if (r100.charAt(r107) != '?') goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L26;
        r107 = r107 + 1;
    L26:
        if (r107 > 0) goto L30;
        r103 = false;
    L30:
        if (r103 == false) goto L33;
        return r100 + Typography.amp + r101 + com.alipay.sdk.m.n.a.f25612h + r102;
    L33:
        return r100 + '?' + r101 + com.alipay.sdk.m.n.a.f25612h + r102;
    L21:
        r108 = false;
        goto L22
    L25:
        r107 = -1;
        goto L26
    L38:
        return r100;
    L9:
        if (r102.length() == 0) goto L12;
        r105 = false;
        goto L13
    L36:
        return r100;
    L5:
        r104 = false;
        goto L6
    }
}
