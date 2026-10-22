package com.bytedance.ee.bear.lynx.impl.route;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.docsdk.impl.utils.AESUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final Map<Integer, String> a = null;
    public static final Map<Integer, Integer> b = null;
    public static final Map<Integer, String> c = null;
    public static final Map<Integer, Integer> d = null;

    static {
        Integer r2 = Integer.valueOf(CCMLynxCardView.ViewType.BANNER);
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, "pages/banner/template.js"), TuplesKt.to(1, "pages/bitable-groupingStatistics-view-page/template.js"), TuplesKt.to(2, "pages/bitable-autonumber/template.js"), TuplesKt.to(4, "pages/bitable-time-zone-select-page/time-zone-list/template.js"), TuplesKt.to(3, "pages/bitable-time-zone-select-page/template.js"), TuplesKt.to(5, "pages/link-share-panel/template.js"), TuplesKt.to(7, "pages/bitable-pro/template.js"), TuplesKt.to(8, "pages/bitable-pro-manager-member/template.js"), TuplesKt.to(6, "pages/base-calendar/template.js"), TuplesKt.to(9, "pages/audio-player/template.js"), TuplesKt.to(10, "pages/play-list-panel/template.js")});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, 1), TuplesKt.to(1, 3), TuplesKt.to(4, 3), TuplesKt.to(3, 3), TuplesKt.to(5, 3), TuplesKt.to(7, 3), TuplesKt.to(8, 3), TuplesKt.to(2, 3), TuplesKt.to(9, 3), TuplesKt.to(10, 3)});
        Integer r0 = Integer.valueOf(CCMLynxPageRouter.PageType.DOC_OPERATION_HIST);
        Integer r3 = Integer.valueOf(CCMLynxPageRouter.PageType.SHARE_PUBLIC_PERM_SET);
        Integer r5 = Integer.valueOf(CCMLynxPageRouter.PageType.RETENTION_LABEL);
        Integer r6 = Integer.valueOf(CCMLynxPageRouter.PageType.COLLABORATOR_MANAGER);
        Integer r7 = Integer.valueOf(CCMLynxPageRouter.PageType.COLLABORATOR_PICKER);
        Integer r8 = Integer.valueOf(CCMLynxPageRouter.PageType.SHARE_PUBLIC_SUB_PERM_SET);
        Integer r9 = Integer.valueOf(CCMLynxPageRouter.PageType.LINK_SHARE_PERM_SET);
        Integer r11 = Integer.valueOf(CCMLynxPageRouter.PageType.ADJUST_SETTINGS_PANEL);
        Integer r13 = Integer.valueOf(CCMLynxPageRouter.PageType.PASSWORD_PICKER_PANEL);
        Integer r14 = Integer.valueOf(CCMLynxPageRouter.PageType.PERM_SOURCE_PANEL);
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(r0, "pages/doc-operation-history/template.js"), TuplesKt.to(r3, "pages/public-permission-panel/template.js"), TuplesKt.to(r5, "pages/retention-label/template.js"), TuplesKt.to(Integer.valueOf(CCMLynxPageRouter.PageType.WIKI_CLASSIFICATION), "pages/wiki-classification/template.js"), TuplesKt.to(r6, "pages/collaborator-manager/template.js"), TuplesKt.to(r7, "pages/collaborator-permission-picker/template.js"), TuplesKt.to(r8, "pages/public-sub-permission/template.js"), TuplesKt.to(r9, "pages/link-share-panel/template.js"), TuplesKt.to(r11, "pages/adjust-settings-panel/template.js"), TuplesKt.to(r13, "pages/link-share-panel-password-picker/template.js"), TuplesKt.to(r14, "pages/permission-source/template.js")});
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(r0, 3), TuplesKt.to(3, 3), TuplesKt.to(r3, 3), TuplesKt.to(r5, 3), TuplesKt.to(r6, 3), TuplesKt.to(r7, 3), TuplesKt.to(r8, 3), TuplesKt.to(r9, 3), TuplesKt.to(r11, 3), TuplesKt.to(r13, 3), TuplesKt.to(r14, 3)});
    }

    public static boolean b(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        if (r2.isHierarchical() == true) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r2.getScheme()) == true) goto L13;
        if (TextUtils.isEmpty(r2.getHost()) == true) goto L13;
        if (Intrinsics.areEqual("ccm-lynx", r2.getScheme()) == false) goto L13;
        if (Intrinsics.areEqual("lynxview", r2.getHost()) == false) goto L13;
        return true;
    }

    public static String a(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Integer r3 = null;
        int r1 = 1;
        if (StringsKt.startsWith$default(r5, "/", false, 2, null) == false) goto L6;
        r5 = r5.substring(1);
    L6:
        if (eu5.c.a() == false) goto L13;
        com.bytedance.ee.bear.lynx.api.c r0 = (com.bytedance.ee.bear.lynx.api.c) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.c.class, null, null, 6);
        String r2 = r0.c();
        if (r0.d() == false) goto L13;
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return "http://" + r2 + "/docs_lynx_channel/" + r5;
    L13:
        if (r6 == false) goto L24;
        Iterator<T> r4 = c.entrySet().iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        Object r7 = r4.next();
        if (Intrinsics.areEqual(((Map.Entry) r7).getValue(), r5) == false) goto L16;
    L21:
        Map.Entry r8 = (Map.Entry) r7;
        if (r8 != null) goto L33;
    L34:
        if (r3 == null) goto L42;
        int r9 = r3.intValue();
        if (r6 == false) goto L38;
        Map<Integer, Integer> r10 = d;
    L39:
        Integer r11 = r10.get(Integer.valueOf(r9));
        if (r11 == null) goto L42;
        r1 = r11.intValue();
        goto L42
    L38:
        r10 = b;
    L42:
        StringBuilder r12 = new StringBuilder("surl=");
        r12.append(URLEncoder.encode(ie5.d.a() + '/' + r5, AESUtils.CHARSET));
        r12.append("&prefix=");
        if (eu5.c.a() == false) goto L45;
        String r13 = "internal/ccm/lynx";
    L46:
        r12.append(URLEncoder.encode(r13, AESUtils.CHARSET));
        r12.append("&dynamic=");
        r12.append(r1);
        return "ccm-lynx://lynxview/?" + r12.toString();
    L45:
        r13 = "online/ccm/lynx";
    L33:
        r3 = (Integer) r8.getKey();
        goto L34
    L20:
        r7 = null;
        goto L21
    L24:
        Iterator<T> r14 = a.entrySet().iterator();
    L26:
        if (r14.hasNext() == false) goto L30;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Map.Entry) r15).getValue(), r5) == false) goto L26;
    L31:
        r8 = (Map.Entry) r15;
        if (r8 == null) goto L34;
    L30:
        r15 = null;
        goto L31
    }
}
