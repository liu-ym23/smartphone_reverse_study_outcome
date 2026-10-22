package com.bytedance.android.shopping.sameproduct.helper;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rd3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(SameProductPageParams r19, rd3.a r20, String r21) {
        JSONObject r1 = new JSONObject();
        if (r20 == null) goto L5;
        boolean r2 = r20.e;
    L6:
        String r3 = null;
        if (r20 == null) goto L11;
        Promotion r4 = r20.f();
        if (r4 == null) goto L11;
        PromotionProductStruct r5 = r4.getPromotionInfo();
    L12:
        r1.put("inflow_landing_page_type", "product_inflow_similar_tab");
        if (r20 == null) goto L15;
        Integer r6 = Integer.valueOf(r20.f);
    L16:
        r1.put("display_rank", r6);
        if (r2 == false) goto L42;
        r1.put("module_label", "guess_you_like_product");
        if (r20 == null) goto L23;
        g r7 = r20.d();
        if (r7 == null) goto L23;
        String r8 = r7.a();
    L24:
        r1.put("recommend_info", r8);
        if (r20 == null) goto L27;
        String r0 = r20.d;
    L28:
        r1.put("request_id", r0);
        r1.put("ecom_group_type", "product_card");
        ArrayList r10 = new ArrayList();
        if (a2.b(r21) == false) goto L37;
        if (r21 == null) goto L37;
        List r9 = StringsKt.split$default(r21, new String[]{","}, false, 0, 6, null);
        if (r9 == null) goto L37;
        Iterator r11 = r9.iterator();
    L35:
        if (r11.hasNext() == false) goto L37;
        r10.add((String) r11.next());
    L37:
        if (r19 != null) goto L39;
    L41:
        r10.add("1061");
        r1.put("ecom_scene_id", CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null));
    L47:
        r1.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        if (r19 == null) goto L50;
        r3 = r19.getAuthorId();
    L50:
        r1.put("author_id", r3);
        if (r5 == null) goto L64;
        PromotionProductExtraStruct r12 = r5.getExtraInfo();
        if (r12 == null) goto L64;
        String r13 = r12.getEntranceInfo();
        if (r13 == null) goto L64;
        JSONObject r14 = z1.g(r13);
        if (r14 == null) goto L64;
        Iterator<String> r15 = r14.keys();
        if (r15 == null) goto L64;
    L61:
        if (r15.hasNext() == false) goto L64;
        String r16 = r15.next();
        r1.put(r16, r14.get(r16));
    L64:
        return r1.toString();
    L39:
        if (r19.isFromFlowGuessULike() != true) goto L41;
        r1.put("from_product_module_label", "guess_you_like_product");
        goto L41
    L27:
        r0 = null;
    L23:
        r8 = null;
        goto L24
    L42:
        if (r19 != null) goto L44;
    L46:
        r1.put("ecom_group_type", "video");
        goto L47
    L44:
        if (r19.isFromFlowGuessULike() != true) goto L46;
        r1.put("request_id", r19.getMainProductRequestId());
        r1.put("recommend_info", r19.getMainProductRecommendInfo());
        goto L46
    L15:
        r6 = null;
    L11:
        r5 = null;
        goto L12
    L5:
        r2 = false;
        goto L6
    }
}
