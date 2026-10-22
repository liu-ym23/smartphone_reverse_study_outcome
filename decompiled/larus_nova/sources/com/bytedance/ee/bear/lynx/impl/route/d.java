package com.bytedance.ee.bear.lynx.impl.route;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f229903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f229904b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, String> f229905c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, Integer> f229906d = null;

    static {
        f229903a = MapsKt.mapOf(new Pair[]{TuplesKt.to(1000, "pages/banner/template.js"), TuplesKt.to(1, "pages/bitable-groupingStatistics-view-page/template.js"), TuplesKt.to(2, "pages/bitable-autonumber/template.js"), TuplesKt.to(4, "pages/bitable-time-zone-select-page/time-zone-list/template.js"), TuplesKt.to(3, "pages/bitable-time-zone-select-page/template.js"), TuplesKt.to(5, "pages/link-share-panel/template.js"), TuplesKt.to(7, "pages/bitable-pro/template.js"), TuplesKt.to(8, "pages/bitable-pro-manager-member/template.js"), TuplesKt.to(6, "pages/base-calendar/template.js"), TuplesKt.to(9, "pages/audio-player/template.js"), TuplesKt.to(10, "pages/play-list-panel/template.js")});
        f229904b = MapsKt.mapOf(new Pair[]{TuplesKt.to(1000, 1), TuplesKt.to(1, 3), TuplesKt.to(4, 3), TuplesKt.to(3, 3), TuplesKt.to(5, 3), TuplesKt.to(7, 3), TuplesKt.to(8, 3), TuplesKt.to(2, 3), TuplesKt.to(9, 3), TuplesKt.to(10, 3)});
        f229905c = MapsKt.mapOf(new Pair[]{TuplesKt.to(1100, "pages/doc-operation-history/template.js"), TuplesKt.to(1200, "pages/public-permission-panel/template.js"), TuplesKt.to(1201, "pages/retention-label/template.js"), TuplesKt.to(1202, "pages/wiki-classification/template.js"), TuplesKt.to(1203, "pages/collaborator-manager/template.js"), TuplesKt.to(1204, "pages/collaborator-permission-picker/template.js"), TuplesKt.to(1205, "pages/public-sub-permission/template.js"), TuplesKt.to(1206, "pages/link-share-panel/template.js"), TuplesKt.to(1207, "pages/adjust-settings-panel/template.js"), TuplesKt.to(1208, "pages/link-share-panel-password-picker/template.js"), TuplesKt.to(1209, "pages/permission-source/template.js")});
        f229906d = MapsKt.mapOf(new Pair[]{TuplesKt.to(1100, 3), TuplesKt.to(3, 3), TuplesKt.to(1200, 3), TuplesKt.to(1201, 3), TuplesKt.to(1203, 3), TuplesKt.to(1204, 3), TuplesKt.to(1205, 3), TuplesKt.to(1206, 3), TuplesKt.to(1207, 3), TuplesKt.to(1208, 3), TuplesKt.to(1209, 3)});
    }

    public static boolean b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (r100.isHierarchical() == true) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getScheme()) == true) goto L13;
        if (TextUtils.isEmpty(r100.getHost()) == true) goto L13;
        if (Intrinsics.areEqual("ccm-lynx", r100.getScheme()) == false) goto L13;
        if (Intrinsics.areEqual(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW, r100.getHost()) == false) goto L13;
        return true;
    }

    public static String a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Integer r102 = null;
        int r103 = 1;
        if (StringsKt.startsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == false) goto L6;
        r100 = r100.substring(1);
    L6:
        if (eu5.c.a() == false) goto L13;
        com.bytedance.ee.bear.lynx.api.c r104 = (com.bytedance.ee.bear.lynx.api.c) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.c.class, null, null, 6);
        String r105 = r104.c();
        if (r104.d() == false) goto L13;
        if (TextUtils.isEmpty(r105) == true) goto L13;
        return "http://" + r105 + "/docs_lynx_channel/" + r100;
    L13:
        if (r101 == false) goto L24;
        Iterator<T> r106 = f229905c.entrySet().iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((Map.Entry) r107).getValue(), r100) == false) goto L16;
    L21:
        Map.Entry r108 = (Map.Entry) r107;
        if (r108 != null) goto L33;
    L34:
        if (r102 == null) goto L42;
        int r109 = r102.intValue();
        if (r101 == false) goto L38;
        Map<Integer, Integer> r110 = f229906d;
    L39:
        Integer r111 = r110.get(Integer.valueOf(r109));
        if (r111 == null) goto L42;
        r103 = r111.intValue();
        goto L42
    L38:
        r110 = f229904b;
    L42:
        StringBuilder r112 = new StringBuilder("surl=");
        r112.append(URLEncoder.encode(ie5.d.a() + '/' + r100, "UTF-8"));
        r112.append("&prefix=");
        if (eu5.c.a() == false) goto L45;
        String r113 = "internal/ccm/lynx";
    L46:
        r112.append(URLEncoder.encode(r113, "UTF-8"));
        r112.append("&dynamic=");
        r112.append(r103);
        return "ccm-lynx://lynxview/?" + r112.toString();
    L45:
        r113 = "online/ccm/lynx";
    L33:
        r102 = (Integer) r108.getKey();
        goto L34
    L20:
        r107 = null;
        goto L21
    L24:
        Iterator<T> r114 = f229903a.entrySet().iterator();
    L26:
        if (r114.hasNext() == false) goto L30;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((Map.Entry) r115).getValue(), r100) == false) goto L26;
    L31:
        r108 = (Map.Entry) r115;
        if (r108 == null) goto L34;
    L30:
        r115 = null;
        goto L31
    }
}
