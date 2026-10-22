package ep;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.utils.f;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f473412a = 0;

    public a() {
    }

    static {
    }

    public static void a(Context r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "shopId");
        Intrinsics.checkNotNullParameter(r110, "btm");
        m0 r103 = new m0("//aweme/scan");
        r103.b("finishAfterScan", "false");
        r103.b("scan_fragment_tags", "2");
        r103.b("enter_from", "discovery");
        r103.b("search_from", "search_store");
        r103.b(ECFindSimilarConfig.ENTER_FROM_SECOND, r101);
        r103.b("previous_page", "shop");
        r103.b("enable_goods_scan", "1");
        r103.b("scan_type", "2");
        com.bytedance.commerce.base.json.a[] r104 = new com.bytedance.commerce.base.json.a[6];
        r104[0] = JsonDslUtilKt.d(ECFindSimilarConfig.PHOTO_SEARCH_PREVIOUS_PAGE, "shop");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r104[1] = JsonDslUtilKt.d(ECFindSimilarConfig.ENTER_FROM_SECOND, r101);
        r104[2] = JsonDslUtilKt.d("search_entrance", "shop_photo_search");
        r104[3] = JsonDslUtilKt.d("search_type", "search_store");
        r104[4] = JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r102);
        r104[5] = JsonDslUtilKt.d("search_channel", "ecom_mms_goods_shop");
        r103.b(ECFindSimilarConfig.SEARCH_SCAN_PARAMS, JsonDslUtilKt.a(r104).toString());
        String r105 = r103.c();
        PageFinder r106 = PageFinder.via(r100);
        p.f48130a.openSchema(r100, f.b(r105, r110, r106));
    }
}
