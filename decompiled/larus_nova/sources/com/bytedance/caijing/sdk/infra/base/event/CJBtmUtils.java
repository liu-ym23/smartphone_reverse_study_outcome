package com.bytedance.caijing.sdk.infra.base.event;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJPageFinder;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class CJBtmUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f202293a = null;

    public CJBtmUtils() {
    }

    static {
        f202293a = LazyKt.lazy(CJBtmUtils$btmService$2.INSTANCE);
    }

    public static CJBtmService f() {
        return (CJBtmService) f202293a.getValue();
    }

    public static void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CJBtmService r101 = f();
        if (r101 == null) goto L6;
        r101.btmViewHide(r100);
        return;
    }

    public static void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CJBtmService r101 = f();
        if (r101 == null) goto L6;
        r101.btmViewHide(r100, false);
        return;
    }

    public static void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CJBtmService r101 = f();
        if (r101 == null) goto L6;
        r101.btmViewShow(r100);
        return;
    }

    public static void k(CJPageFinder r100) {
        Map<String, ? extends Object> r101 = MapsKt.mapOf(TuplesKt.to("btm_page_id", String.valueOf(System.currentTimeMillis())));
        Intrinsics.checkNotNullParameter(r100, "finder");
        Intrinsics.checkNotNullParameter(r101, "params");
        CJBtmService r102 = f();
        if (r102 == null) goto L6;
        r102.setBcmPageEventParams(r100, r101);
        return;
    }

    public static Map d(String r100, CJPageFinder r101) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        CJBtmService r102 = f();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.createFullyReportParams(r100, r101);
    }

    public static void e(String r100, CJPageFinder r101) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        CJBtmService r102 = f();
        if (r102 == null) goto L6;
        r102.createJumpSourceBtmToken(r100, r101, null);
        return;
    }

    public static CJPageFinder g(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "pageBtm");
        CJBtmService r102 = f();
        if (r102 == null) goto L5;
        r102.registerBtmPageOnCreate(r100, r101, null);
    L5:
        CJPageFinder r103 = new CJPageFinder().via(r100);
        k(r103);
        return r103;
    }

    public static void h(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "pageBtm");
        CJBtmService r102 = f();
        if (r102 == null) goto L5;
        r102.registerBtmPageOnCreate(r100, r101, null);
    L5:
        k(new CJPageFinder().via(r100));
    }

    public static CJPageFinder i(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        CJBtmService r102 = f();
        if (r102 == null) goto L5;
        r102.registerBtmView(r100, r101);
    L5:
        CJPageFinder r103 = new CJPageFinder().via(r100);
        k(r103);
        return r103;
    }

    public static void j(CJPageFinder r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "finder");
        Intrinsics.checkNotNullParameter(r101, "params");
        CJBtmService r102 = f();
        if (r102 == null) goto L6;
        r102.setBcmPageEventParams(r100, KtSafeMethodExtensionKt.toMap(r101));
        return;
    }
}
