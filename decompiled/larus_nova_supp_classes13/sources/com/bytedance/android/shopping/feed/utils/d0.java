package com.bytedance.android.shopping.feed.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.feed.event.i2;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 {
    public static final ArrayList<String> a = null;
    public static final a b = null;

    public static final class a implements ti.j {
        public a() {
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            s0.a(new i2(z1.h(r2.optJSONArray("tag_showed_product_info"))));
        }
    }

    static {
        a = new ArrayList();
        b = new a();
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r1 = a.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L13;
        String r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r0.append(r3);
        if (r2 >= (a.size() - 1)) goto L11;
        r0.append(",");
    L11:
        r2 = r4;
        goto L4
    L13:
        return r0.toString();
    }

    public static void b(Context r7, String r8, String r9, List r10, List r11, AnchorV3Param r12) {
        Intrinsics.checkNotNullParameter(r8, "schema");
        if ((com.bytedance.android.ec.sdk.plugin.e.getActivity(r7) instanceof Activity) == true) goto L5;
        return;
    L5:
        Uri.Builder r13 = UriProtector.parse(r8).buildUpon();
        JSONObject r0 = new JSONObject();
        r0.put(SimilarProductParam.ENTER_FROM, "product_flow_page");
        r0.put("first_tag_id", r9);
        r0.put("filter_product_list", new JSONArray(r10));
        ArrayList r14 = new ArrayList();
        String r1 = null;
        if (r11 == null) goto L17;
        Iterator r2 = r11.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((TopicItemInfo) r3).getId(), r9) == false) goto L9;
    L14:
        TopicItemInfo r4 = (TopicItemInfo) r3;
        if (r4 == null) goto L17;
        r14.add(r4);
        goto L17
    L13:
        r3 = null;
    L17:
        if (r11 == null) goto L24;
        Iterator r15 = r11.iterator();
    L20:
        if (r15.hasNext() == false) goto L24;
        TopicItemInfo r5 = (TopicItemInfo) r15.next();
        if ((!Intrinsics.areEqual(r5.getId(), r9)) == false) goto L20;
        r14.add(r5);
    L24:
        r0.put("tag_info_list", new JSONArray(u0.d(r14)));
        JSONObject r16 = new JSONObject();
        r16.put("ecom_group_type", "video");
        if (r12 == null) goto L27;
        String r17 = r12.getAuthorId();
    L28:
        r16.put("author_id", r17);
        if (r12 == null) goto L31;
        Integer r18 = r12.getFollowStatus();
    L32:
        r16.put(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r18);
        if (r12 == null) goto L35;
        String r19 = r12.getVideoId();
    L36:
        r16.put("group_id", r19);
        if (r12 == null) goto L41;
        AnchorV3PromotionRequestParam r110 = r12.getRequestParam();
        if (r110 == null) goto L41;
        String r111 = r110.getSourcePage();
    L42:
        r16.put("previous_page", r111);
        if (r12 == null) goto L45;
        r1 = r12.getEComEntranceFrom();
    L45:
        r16.put("ecom_entrance_form", r1);
        r0.put("log_data", r16.toString());
        JSONObject r20 = new JSONObject();
        r20.put("ecom_product_feed_data", r0);
        r13.appendQueryParameter("mega_object", r20.toString());
        if (r7 == null) goto L57;
        ECLiveHybridUtil.k(r7, r13.toString(), false, false, false, null, 252);
        return;
    L57:
        return;
    L41:
        r111 = null;
        goto L42
    L35:
        r19 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L27:
        r17 = null;
        goto L28
    }
}
