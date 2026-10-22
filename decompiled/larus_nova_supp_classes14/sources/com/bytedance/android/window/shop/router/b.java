package com.bytedance.android.window.shop.router;

import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final Map<String, String> a = null;
    public static final Map<String, String> b = null;

    public static final class a {
        public static final int[] a = null;

        static {
            a = new int[]{2130969568};
        }
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", "open_url"), TuplesKt.to("entrance_location", "open_url"), TuplesKt.to("store_source_page", "open_url"), TuplesKt.to("store_source_method", "open_url"), TuplesKt.to("store_group_type", "open_url"), TuplesKt.to("pre_product_id", null), TuplesKt.to("pre_room_id", null), TuplesKt.to("pre_group_id", null)});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_id", ""), TuplesKt.to("cid", "")});
    }

    public static String a(com.bytedance.android.window.shop.router.a r6) {
        String r1 = r6.a("search_jump");
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = r6.a("search_params");
        JSONObject r4 = null;
        if (r3 != null) goto L9;
        return null;
    L9:
        if ((!Intrinsics.areEqual(r1, CommentScene.COMMENTSCENE_NO_AWEME)) == false) goto L11;
        return r3;
    L11:
        JSONObject r5 = k.w(r3);
        if (r5 == null) goto L19;
        String r7 = r6.a(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE);
        if (r7 == null) goto L17;
        r2 = r7;
    L17:
        r5.put("search_jump", r1);
        r5.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r2);
        r4 = r5;
    L19:
        return String.valueOf(r4);
    }
}
