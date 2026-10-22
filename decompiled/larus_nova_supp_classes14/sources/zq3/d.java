package zq3;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map c(Map r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r4.next();
        Object r2 = r1.getKey();
        Object r5 = r1.getValue();
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r0.put(r2, r5);
        goto L4
    L9:
        return r0;
    }

    public static String a(ECWindowParam r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "storeParam");
        Intrinsics.checkNotNullParameter(r5, "storeParam");
        Pair[] r0 = new Pair[13];
        r0[0] = TuplesKt.to("store_source_method", r5.getStoreSourceMethod());
        r0[1] = TuplesKt.to("store_source_page", r5.getStoreSourcePage());
        r0[2] = TuplesKt.to("store_group_type", r5.getStoreGroupType());
        r0[3] = TuplesKt.to("store_type", "window");
        r0[4] = TuplesKt.to("temp_id", r5.getTempId());
        r0[5] = TuplesKt.to("search_params", r5.getSearchParams());
        r0[6] = TuplesKt.to("is_enter_preview", "0");
        r0[7] = TuplesKt.to("enter_from", r5.getEnterFrom());
        r0[8] = TuplesKt.to("enter_from_shop_id", r5.getAuthorId());
        r0[9] = TuplesKt.to("enter_from_author_id", r5.getAuthorId());
        r0[10] = TuplesKt.to("base_params", c(MapsKt.mapOf(TuplesKt.to("author_id", r5.getAuthorId()))));
        if (r6 == null) goto L5;
        HashMap r7 = xn.c.e(r6);
    L6:
        r0[11] = TuplesKt.to("entrance_info", r7);
        r0[12] = TuplesKt.to("entrance_location", r5.getEntranceLocation());
        Map r8 = MapsKt.toMutableMap(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("track_context", c(MapsKt.mutableMapOf(r0)))}));
        Context r9 = ECAppInfoService.e.getApplicationContext();
        r8.put("screenWidth", Integer.valueOf(UIUtils.px2dip(r9, UIUtils.getScreenWidth(r9))));
        r8.put("ecom_window_ssr", 1);
        return com.bytedance.android.ec.hybrid.list.util.k.d(r8);
    L5:
        r7 = null;
        goto L6
    }

    public static Map b(ECWindowViewModel r7, String r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r7, "shopViewModel");
        ECWindowParam r0 = r7.getShopParam();
        Pair[] r1 = new Pair[14];
        r1[0] = TuplesKt.to("store_source_method", r0.getStoreSourceMethod());
        r1[1] = TuplesKt.to("store_source_page", r0.getStoreSourcePage());
        r1[2] = TuplesKt.to("store_group_type", r0.getStoreGroupType());
        r1[3] = TuplesKt.to("store_type", "window");
        r1[4] = TuplesKt.to("temp_id", r0.getTempId());
        r1[5] = TuplesKt.to("search_params", r0.getSearchParams());
        String r5 = "0";
        r1[6] = TuplesKt.to("is_enter_preview", "0");
        r1[7] = TuplesKt.to("enter_from", r0.getEnterFrom());
        r1[8] = TuplesKt.to("enter_from_shop_id", r0.getAuthorId());
        r1[9] = TuplesKt.to("enter_from_author_id", r0.getAuthorId());
        if (r9 == null) goto L5;
        int r10 = r9.intValue();
    L6:
        r1[10] = TuplesKt.to("item_index", Integer.valueOf(r10));
        LinkedHashMap r11 = new LinkedHashMap();
        r11.putAll(r7.getBaseParams());
        Integer r2 = r7.getShopParam().getFollowStatus();
        if (r2 != null) goto L10;
    L12:
        r5 = CommentScene.COMMENTSCENE_NO_AWEME;
    L13:
        r11.put("follow_status", r5);
        if (r8 == null) goto L16;
        r11.put("card_style", r8);
    L16:
        r1[11] = TuplesKt.to("base_params", c(r11));
        r1[12] = TuplesKt.to("entrance_info", xn.c.e(z1.f((String) r7.getBaseParams().get("entrance_info"))));
        r1[13] = TuplesKt.to("entrance_location", r7.getBaseParams().get("entrance_location"));
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("track_context", c(MapsKt.mutableMapOf(r1)))});
    L10:
        if (r2.intValue() != 0) goto L12;
    L5:
        r10 = 0;
        goto L6
    }
}
