package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.k;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        if (Intrinsics.areEqual(r2, "order_center_video") == false) goto L7;
        return "product_flow_page_" + r2 + "_order_homepage";
    L7:
        return "product_flow_page_".concat(r2);
    }

    public static void b(k r6, d r7, Context r8, boolean r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "contextData");
        Intrinsics.checkNotNullParameter(r11, "searchEntranceStyle");
        String r0 = r6.a;
        String r12 = r6.b;
        JSONObject r1 = new JSONObject();
        r1.put("suggest_word", r0);     // Catch: JSONException -> L5
        r1.put("suggest_word_id", r12);     // Catch: JSONException -> L5
    L7:
        String r2 = r1.toString();
        Uri.Builder r3 = UriProtector.parse("aweme://search").buildUpon().appendQueryParameter(SimilarProductParam.ENTER_FROM, r7.a).appendQueryParameter("enter_group_id", r7.g).appendQueryParameter("group_id", r7.h).appendQueryParameter("search_style", "commodity_center").appendQueryParameter("previous_page", r7.d).appendQueryParameter("transitionType", "1").appendQueryParameter("search_channel", "ecom_order_center");
        if (r10 == false) goto L10;
        String r13 = "1";
    L11:
        Uri.Builder r14 = r3.appendQueryParameter("is_search_button", r13).appendQueryParameter("author_id", r7.b).appendQueryParameter("enter_from_second", r7.e).appendQueryParameter("middleInfoExtra", r2).appendQueryParameter("need_prefetch", "1").appendQueryParameter("type", "goods").appendQueryParameter("search_entrance_style", r11).appendQueryParameter("needBack2Origin", "1").appendQueryParameter("is_direct_jump", "1").appendQueryParameter("enter_method", r7.f).appendQueryParameter("ecom_scene_id", r7.c);
        if (r9 == false) goto L14;
        r14.appendQueryParameter("keyword", r0);
        r14.appendQueryParameter("displayKeywordID", r12);
    L15:
        String r15 = r7.i;
        if (r15 == null) goto L18;
        r14.appendQueryParameter("source_btm_token", r15);
    L18:
        String r16 = r14.build().toString();
        p.a.openSchema(com.bytedance.android.ec.sdk.plugin.e.getActivity(r8), r16);
        ps3.b.a(new String[]{"url: " + r16});
        return;
    L14:
        r14.appendQueryParameter("search_hint_word", r0);
        r14.appendQueryParameter("search_hint_word_id", r12);
        goto L15
    L10:
        r13 = "0";
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }
}
