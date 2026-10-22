package com.bytedance.pia.core.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pia.core.setting.Settings;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f266400a = 0;

    static {
    }

    @JvmStatic
    public static final Uri a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Lazy<Settings> r101 = Settings.f266286f;
        if (Settings.a.a().v() == false) goto L16;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(r100.buildUpon().appendQueryParameter("_pia_", "1").build());     // Catch: Throwable -> L6
    L8:
        Object r104 = r100;
        if (Result.m9455isFailureimpl(r103) == true) goto L13;
        r104 = r103;
    L13:
        return (Uri) r104;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    L16:
        return r100;
    }

    @JvmStatic
    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Uri r101 = UriProtector.parse(r100);
        return StringsKt.replace$default(r101.getHost() + r101.getPath() + InvRouter.FLOW_SUFFIX, HTTP.URL_DEFAULT, ":", false, 4, null);
    }

    @JvmStatic
    public static final Uri c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Uri r101 = UriProtector.parse(r100);
        return new Uri.Builder().scheme(r101.getScheme()).authority(r101.getAuthority()).path(r101.getPath() + InvRouter.FLOW_SUFFIX).build();
    }

    @JvmStatic
    public static final String d(Uri r100) {
        String r101 = null;
        if (r100 != null) goto L5;
    L10:
        if (r101 != null) goto L13;
        return "";
    L13:
        return r101;
    L5:
        if (f(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r101 = (String) ListProtector.get(StringsKt.split$default(r100.getScheme() + ':' + r100.getEncodedSchemeSpecificPart(), new char[]{'?'}, false, 0, 6, null), 0);
        goto L10
    }

    @JvmStatic
    public static final boolean f(Uri r100) {
        List r101 = CollectionsKt.listOf(new String[]{"http", "https"});
        if (r100 == null) goto L5;
        String r102 = r100.getScheme();
    L7:
        return CollectionsKt.contains(r101, r102);
    L5:
        r102 = null;
        goto L7
    }

    @JvmStatic
    public static final String e(Map<String, String> r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<String, String> r103 = r102.next();
        if (StringsKt.equals(r101, r103.getKey(), true) == false) goto L10;
        return r103.getValue();
    L22:
        return null;
    L21:
        return null;
    }

    @JvmStatic
    public static final String g(Uri r110, List<String> r111) {
        ArrayList r100 = null;
        if (r110 != null) goto L5;
    L49:
        return null;
    L5:
        if (f(r110) == false) goto L49;
        StringBuffer r101 = new StringBuffer();
        r101.append(r110.getAuthority());
        r101.append(r110.getPath());
        LinkedHashSet r102 = new LinkedHashSet();
        String r103 = UriProtector.getQueryParameter(r110, "_pia_vary_");
        if (r103 == null) goto L20;
        List r104 = StringsKt.split$default(r103, new char[]{','}, false, 0, 6, null);
        if (r104 == null) goto L20;
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L13:
        if (r107.hasNext() == false) goto L19;
        String r108 = (String) r107.next();
        if (r108 == null) goto L18;
        r106.add(StringsKt.trim(r108).toString());
        goto L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        r102.addAll(r106);
    L20:
        if (r111 == null) goto L22;
        r102.addAll(r111);
    L22:
        List r112 = CollectionsKt.sorted(r102);
        ArrayList r109 = new ArrayList();
        Iterator r113 = r112.iterator();
    L24:
        if (r113.hasNext() == false) goto L38;
        String r114 = (String) r113.next();
        String r115 = UriProtector.getQueryParameter(r110, r114);
        if (r115 != null) goto L28;
    L31:
        boolean r116 = true;
    L32:
        if (r116 == false) goto L34;
        Pair r117 = null;
    L35:
        if (r117 == null) goto L24;
        r109.add(r117);
        goto L24
    L34:
        r117 = TuplesKt.to(r114, r115);
        goto L35
    L28:
        if (StringsKt.isBlank(r115) == true) goto L31;
        r116 = false;
        goto L32
    L38:
        if ((!r109.isEmpty()) == false) goto L40;
        r100 = r109;
    L40:
        if (r100 == null) goto L48;
        Pair r118 = (Pair) CollectionsKt.first(r100);
        r101.append("?");
        r101.append(((String) r118.getFirst()) + com.alipay.sdk.m.n.a.f25612h + ((String) r118.getSecond()));
        List r119 = CollectionsKt.drop(r100, 1);
        if (r119 == null) goto L48;
        Iterator r120 = r119.iterator();
    L45:
        if (r120.hasNext() == false) goto L48;
        Pair r121 = (Pair) r120.next();
        String r122 = (String) r121.component1();
        String r123 = (String) r121.component2();
        r101.append("&");
        r101.append(r122 + com.alipay.sdk.m.n.a.f25612h + r123);
    L48:
        return r101.toString();
    }
}
