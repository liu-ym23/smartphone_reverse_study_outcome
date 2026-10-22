package ic3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentLogParams;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.extensions.k;
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

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f489160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f489161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f489162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentParams f489163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.commentv3.data.b f489164e;

    public d(CommentParams r110, com.bytedance.android.shopping.commentv3.data.b r111) {
        Intrinsics.checkNotNullParameter(r110, "commentParams");
        Intrinsics.checkNotNullParameter(r111, "viewModel");
        this.f489163d = r110;
        this.f489164e = r111;
        this.f489160a = new LinkedHashMap();
        this.f489161b = new LinkedHashMap();
        this.f489162c = new ArrayList();
        LinkedHashMap r112 = new LinkedHashMap();
        Map<String, Object> r113 = r110.getBaseLogParams();
        String r100 = "";
        String r101 = null;
        if (r113 == null) goto L45;
        Set<Map.Entry<String, Object>> r114 = r113.entrySet();
        if (r114 == null) goto L45;
        Iterator<T> r115 = r114.iterator();
    L8:
        if (r115.hasNext() == false) goto L45;
        Map.Entry r102 = (Map.Entry) r115.next();
        Object r103 = r102.getValue();
        if (r103 == null) goto L8;
        String r104 = r103.toString();
        if (r104 == null) goto L8;
        if (k.c(r104) == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L8;
        if (Intrinsics.areEqual((String) r102.getKey(), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) == true) goto L20;
        r112.put(r102.getKey(), r104);
        goto L8
    L20:
        Object r105 = r102.getKey();
        Map<String, Object> r106 = this.f489163d.getBaseLogParams();
        if (r106 == null) goto L42;
        JSONObject r107 = k.w(r104);
        if (r107 == null) goto L42;
        if (r106.containsKey(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE) == false) goto L30;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, String.valueOf(MapsKt.getValue(r106, com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE)));     // Catch: JSONException -> L40
    L30:
        if (r106.containsKey("product_id") == false) goto L33;
        r107.put("product_id", String.valueOf(MapsKt.getValue(r106, "product_id")));     // Catch: JSONException -> L40
    L33:
        if (r106.containsKey(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID) == false) goto L36;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, String.valueOf(MapsKt.getValue(r106, com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID)));     // Catch: JSONException -> L40
    L36:
        if (r106.containsKey("source_page") == false) goto L38;
        r107.put("source_page", String.valueOf(MapsKt.getValue(r106, "source_page")));     // Catch: JSONException -> L40
    L38:
        String r108 = r107.toString();     // Catch: JSONException -> L40
    L43:
        r112.put(r105, r108);
    L40:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("CommentTracker_getEntranceInfoData").b("getEntranceInfoData", e);
        int r109 = e.f489165a;
        e.a.a(this.f489164e.f172737b, EventName.ERROR.getEvent(), "", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: CommentTracker, method: getEntranceInfoData, exception: " + e.getMessage())}), null, null, 240);
    L42:
        r108 = "";
    L45:
        this.f489160a.putAll(r112);
        CommentLogParams r116 = this.f489163d.getLogParams();
        if (r116 == null) goto L58;
        String r117 = r116.getEntranceInfo();
        if (r117 == null) goto L58;
        JSONObject r118 = k.w(r117);
        if (r118 == null) goto L58;
        Iterator<String> r119 = r118.keys();
    L53:
        if (r119.hasNext() == false) goto L58;
        String r120 = r119.next();
        Map<String, String> r121 = this.f489160a;
        String r122 = r118.optString(r120);
        if (r122 != null) goto L57;
        r122 = "";
    L57:
        r121.put(r120, r122);
    L58:
        CommentLogParams r123 = this.f489163d.getLogParams();
        if (r123 == null) goto L62;
        r101 = r123.getSourcePage();
    L62:
        if (Intrinsics.areEqual(r101, "search_result_card") == false) goto L65;
        String r124 = g.f489807b.S("ecommerce");
        if (r124 == null) goto L65;
    L66:
        this.f489160a.put("search_id", r124);
        this.f489161b.put("product_id", String.valueOf(this.f489163d.getProductId()));
        this.f489161b.put("page_name", com.bytedance.android.ec.core.event.a.VALUE_COMMENT_CARD);
        this.f489161b.put("data_type", String.valueOf(this.f489163d.getDataType()));
        this.f489161b.put("business_type", String.valueOf(this.f489163d.getBusinessType()));
        this.f489161b.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, o53.b.f522096a);
        this.f489161b.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, String.valueOf(this.f489163d.getShopId()));
        this.f489161b.put("author_id", String.valueOf(this.f489163d.getAuthorId()));
        this.f489161b.put(com.bytedance.android.ec.core.event.a.KEY_TOP_COMMENT_IDS, String.valueOf(this.f489163d.getTopCommentIds()));
        Map<String, String> r125 = this.f489161b;
        CommentLogParams r126 = this.f489163d.getLogParams();
        if (r126 == null) goto L70;
        String r127 = r126.getCommentEntrance();
        if (r127 == null) goto L70;
    L71:
        r125.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r127);
        Map<String, String> r128 = this.f489161b;
        String r129 = this.f489163d.getPdpSessionId();
        if (r129 != null) goto L74;
        r129 = "";
    L74:
        r128.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r129);
        if (this.f489163d.isFromProductDetail() == false) goto L103;
        Map<String, String> r130 = this.f489161b;
        Map<String, Object> r131 = this.f489163d.getExtraParams();
        if (r131 == null) goto L84;
        Object r132 = r131.get(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE);
        if (r132 == null) goto L84;
        String r133 = r132.toString();
        if (r133 == null) goto L84;
        r100 = r133;
    L84:
        r130.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_CARD_CLICK_ENTRANCE, r100);
        return;
    L103:
        return;
    L70:
        r127 = "";
    L65:
        r124 = "";
        goto L66
    }
}
