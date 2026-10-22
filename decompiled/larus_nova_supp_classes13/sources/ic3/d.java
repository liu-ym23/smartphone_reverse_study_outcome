package ic3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentLogParams;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import ih3.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final Map<String, String> a;
    public final Map<String, String> b;
    public final List<String> c;
    public final CommentParams d;
    public final com.bytedance.android.shopping.commentv3.data.b e;

    public d(CommentParams r14, com.bytedance.android.shopping.commentv3.data.b r15) {
        Intrinsics.checkNotNullParameter(r14, "commentParams");
        Intrinsics.checkNotNullParameter(r15, "viewModel");
        this.d = r14;
        this.e = r15;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        LinkedHashMap r16 = new LinkedHashMap();
        Map r17 = r14.getBaseLogParams();
        String r1 = "";
        String r2 = null;
        if (r17 == null) goto L45;
        Set r18 = r17.entrySet();
        if (r18 == null) goto L45;
        Iterator r19 = r18.iterator();
    L8:
        if (r19.hasNext() == false) goto L45;
        Map.Entry r3 = (Map.Entry) r19.next();
        Object r4 = r3.getValue();
        if (r4 == null) goto L8;
        String r5 = r4.toString();
        if (r5 == null) goto L8;
        if (k.c(r5) == true) goto L17;
        r5 = null;
    L17:
        if (r5 == null) goto L8;
        if (Intrinsics.areEqual((String) r3.getKey(), "entrance_info") == true) goto L20;
        r16.put(r3.getKey(), r5);
        goto L8
    L20:
        Object r6 = r3.getKey();
        Map r7 = this.d.getBaseLogParams();
        if (r7 == null) goto L42;
        JSONObject r8 = k.w(r5);
        if (r8 == null) goto L42;
        if (r7.containsKey("commodity_type") == false) goto L30;
        r8.put("commodity_type", String.valueOf(MapsKt.getValue(r7, "commodity_type")));     // Catch: JSONException -> L40
    L30:
        if (r7.containsKey(PdpOpenThirdParam.KEY_PRODUCT_ID) == false) goto L33;
        r8.put(PdpOpenThirdParam.KEY_PRODUCT_ID, String.valueOf(MapsKt.getValue(r7, PdpOpenThirdParam.KEY_PRODUCT_ID)));     // Catch: JSONException -> L40
    L33:
        if (r7.containsKey("commodity_id") == false) goto L36;
        r8.put("commodity_id", String.valueOf(MapsKt.getValue(r7, "commodity_id")));     // Catch: JSONException -> L40
    L36:
        if (r7.containsKey(PdpOpenThirdParam.KEY_SOURCE_PAGE) == false) goto L38;
        r8.put(PdpOpenThirdParam.KEY_SOURCE_PAGE, String.valueOf(MapsKt.getValue(r7, PdpOpenThirdParam.KEY_SOURCE_PAGE)));     // Catch: JSONException -> L40
    L38:
        String r9 = r8.toString();     // Catch: JSONException -> L40
    L43:
        r16.put(r6, r9);
    L40:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("CommentTracker_getEntranceInfoData").b("getEntranceInfoData", e);
        int r10 = e.a;
        e.a.a(this.e.b, EventName.ERROR.getEvent(), "", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: CommentTracker, method: getEntranceInfoData, exception: " + e.getMessage())}), null, null, 240);
    L42:
        r9 = "";
    L45:
        this.a.putAll(r16);
        CommentLogParams r110 = this.d.getLogParams();
        if (r110 == null) goto L58;
        String r111 = r110.getEntranceInfo();
        if (r111 == null) goto L58;
        JSONObject r112 = k.w(r111);
        if (r112 == null) goto L58;
        Iterator<String> r113 = r112.keys();
    L53:
        if (r113.hasNext() == false) goto L58;
        String r11 = r113.next();
        Map<String, String> r12 = this.a;
        String r13 = r112.optString(r11);
        if (r13 != null) goto L57;
        r13 = "";
    L57:
        r12.put(r11, r13);
    L58:
        CommentLogParams r114 = this.d.getLogParams();
        if (r114 == null) goto L62;
        r2 = r114.getSourcePage();
    L62:
        if (Intrinsics.areEqual(r2, "search_result_card") == false) goto L65;
        String r115 = g.b.S("ecommerce");
        if (r115 == null) goto L65;
    L66:
        this.a.put("search_id", r115);
        this.b.put(PdpOpenThirdParam.KEY_PRODUCT_ID, String.valueOf(this.d.getProductId()));
        this.b.put(PdpOpenThirdParam.KEY_PAGE_NAME, "comment_card");
        this.b.put("data_type", String.valueOf(this.d.getDataType()));
        this.b.put("business_type", String.valueOf(this.d.getBusinessType()));
        this.b.put("comment_module", o53.b.a);
        this.b.put("shop_id", String.valueOf(this.d.getShopId()));
        this.b.put("author_id", String.valueOf(this.d.getAuthorId()));
        this.b.put("top_comment_ids", String.valueOf(this.d.getTopCommentIds()));
        Map<String, String> r116 = this.b;
        CommentLogParams r117 = this.d.getLogParams();
        if (r117 == null) goto L70;
        String r118 = r117.getCommentEntrance();
        if (r118 == null) goto L70;
    L71:
        r116.put("comment_entrance", r118);
        Map<String, String> r119 = this.b;
        String r120 = this.d.getPdpSessionId();
        if (r120 != null) goto L74;
        r120 = "";
    L74:
        r119.put("pdp_session_id", r120);
        if (this.d.isFromProductDetail() == false) goto L103;
        Map<String, String> r121 = this.b;
        Map r122 = this.d.getExtraParams();
        if (r122 == null) goto L84;
        Object r123 = r122.get("comment_entrance");
        if (r123 == null) goto L84;
        String r124 = r123.toString();
        if (r124 == null) goto L84;
        r1 = r124;
    L84:
        r121.put("comment_card_click_entrance", r1);
        return;
    L103:
        return;
    L70:
        r118 = "";
    L65:
        r115 = "";
        goto L66
    }
}
