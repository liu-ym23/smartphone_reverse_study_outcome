package com.bytedance.android.shopping.deepfeed.data;

import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.deepfeed.data.repo.DeepFeedAbValues;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\u0018\u00002\u00020\u00012\u00020\u0002B»\u0001\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bi\u0010jJ\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u0016R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u0007R\u0017\u0010\"\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R0\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+\"\u0004\b.\u0010/R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b0\u0010\u0007R$\u00101\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u0007R\u001c\u00104\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001c\u00106\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001dR\u001c\u00108\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010\u001dR\u001c\u0010:\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u001b\u001a\u0004\b;\u0010\u001dR\u001c\u0010<\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010\u001dR$\u0010>\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001b\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u0007R$\u0010A\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u001b\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u0007R\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0013\u0010L\u001a\u0004\u0018\u00010I8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0013\u0010N\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bM\u0010\u001dR\u0013\u0010P\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bO\u0010\u001dR\u0013\u0010R\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bQ\u0010\u001dR\u0013\u0010T\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bS\u0010\u001dR\u0013\u0010V\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bU\u0010\u001dR\u0013\u0010X\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bW\u0010\u001dR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bY\u0010\u001dR\u0013\u0010\\\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b[\u0010\u001dR\u0013\u0010^\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b]\u0010\u001dR\u0013\u0010`\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b_\u0010\u001dR\u0013\u0010b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\ba\u0010\u001dR\u0013\u0010d\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bc\u0010\u001dR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\be\u0010\u001dR\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u001d¨\u0006k"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/DeepFeedQueryParam;", "Ljava/io/Serializable;", "Lzl/b;", "", "filters", "", "fillFiltersFromMall$ec_shopping_impl_saasRelease", "(Ljava/lang/String;)V", "fillFiltersFromMall", "id", "appendFilters", "filtersToAll", "allFilters", "deepFeedFilters", "appendInnerAction", "", "getFilters", "", "generatedTime", "J", "", "recFilterList", "Ljava/util/List;", "deepFeedAllFilters", "filtersFromMall", "innerActionList", "firstCardProductId", "Ljava/lang/String;", "getFirstCardProductId", "()Ljava/lang/String;", "setFirstCardProductId", "preInflateCacheKey", "getPreInflateCacheKey", "setPreInflateCacheKey", "uid", "getUid", "()J", "eSceneId", "getESceneId", "", "tracker", "Ljava/util/Map;", "getTracker", "()Ljava/util/Map;", "requestAddition", "getRequestAddition", "setRequestAddition", "(Ljava/util/Map;)V", "setFilters", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "bizCode", "getBizCode", "sceneCode", "getSceneCode", "cardParam", "getCardParam", "passThroughParams", "getPassThroughParams", "triggers", "getTriggers", "shareElementViewId", "getShareElementViewId", "setShareElementViewId", "negFeedbackJson", "getNegFeedbackJson", "setNegFeedbackJson", "Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "abValues", "Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "getAbValues", "()Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "", "getOutflowRank", "()Ljava/lang/Integer;", "outflowRank", "getPrevPage", "prevPage", "getPageName", "pageName", "getEnterFromMerge", "enterFromMerge", "getEnterFrom", "enterFrom", "getEcomEntranceForm", "ecomEntranceForm", "getCarrierSource", "carrierSource", "getSourcePage", "sourcePage", "getProductSourcePage", "productSourcePage", "getTabId", "tabId", "getTabName", "tabName", "getRecommendInfo", "recommendInfo", "getRequestID", "requestID", "getProductActivityType", "productActivityType", "getLastAction", "lastAction", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedQueryParam implements Serializable, zl.b {

    @SerializedName("ab_values")
    private final DeepFeedAbValues abValues;

    @SerializedName("biz_code")
    private final String bizCode;

    @SerializedName("card_param")
    private final String cardParam;
    private final List<String> deepFeedAllFilters;

    @SerializedName("ecom_scene_id")
    private final String eSceneId;

    @SerializedName("filters")
    private String filters;
    private final List<String> filtersFromMall;
    private String firstCardProductId;
    private final long generatedTime;
    private final List<String> innerActionList;

    @SerializedName("neg_feedback_json")
    private String negFeedbackJson;

    @SerializedName("pass_through_params")
    private final String passThroughParams;
    private String preInflateCacheKey;
    private final List<String> recFilterList;

    @SerializedName("rec_pass_params")
    private Map<String, ? extends Object> requestAddition;

    @SerializedName("scene_code")
    private final String sceneCode;

    @SerializedName("share_element_view_id")
    private String shareElementViewId;

    @SerializedName("source_btm_token")
    private String sourceBtmToken;

    @SerializedName("tracker")
    private final Map<String, Object> tracker;

    @SerializedName("triggers")
    private final String triggers;
    private final long uid;

    public DeepFeedQueryParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public final String allFilters() {
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        r1.addAll(this.filtersFromMall);
        r1.addAll(this.deepFeedAllFilters);
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r0.append((String) r2.next());
        r0.append(",");
        goto L4
    L7:
        if (r0.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        r0.delete(r0.length() - 1, r0.length());
    L12:
        String r4 = r0.toString();
        DeepFeedFoldHelper.e();
        return r4;
    L9:
        r3 = false;
        goto L10
    }

    public final String deepFeedFilters() {
        if (this.recFilterList.isEmpty() == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.recFilterList.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r0.append((String) r1.next());
        r0.append(",");
        goto L8
    L10:
        r0.delete(r0.length() - 1, r0.length());
        return r0.toString();
    }

    public final String getCarrierSource() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("carrier_source");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getEcomEntranceForm() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("ecom_entrance_form");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getEnterFrom() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get(SimilarProductParam.ENTER_FROM);
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getEnterFromMerge() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("enter_from_merge");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    /* JADX INFO: renamed from: getFilters, reason: collision with other method in class */
    public Map<String, String> m778getFilters() {
        if (this.deepFeedAllFilters.isEmpty() == true) goto L5;
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.deepFeedAllFilters.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r0.append((String) r1.next());
        r0.append(",");
        goto L8
    L10:
        r0.delete(r0.length() - 1, r0.length());
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("filters", r0.toString());
        return r2;
    L5:
        return MapsKt.emptyMap();
    }

    public final String getLastAction() {
        Map<String, ? extends Object> r0 = this.requestAddition;
        if (r0 == null) goto L7;
        Object r1 = r0.get("last_actions");
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public final Integer getOutflowRank() {
        Map<String, Object> r0 = this.tracker;
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("outflow_order");
    L7:
        if ((r2 instanceof Integer) == false) goto L11;
        r1 = r2;
    L11:
        return (Integer) r1;
    L5:
        r2 = null;
        goto L7
    }

    public final String getPageName() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getPrevPage() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("previous_page");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getProductActivityType() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L11;
        Object r1 = r0.get("label_info");
        if (r1 == null) goto L11;
        String r2 = r1.toString();
        if (r2 == null) goto L11;
        JSONObject r3 = k.c(r2);
        if (r3 == null) goto L11;
        String r4 = r3.optString("product_activity_type");
    L12:
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L11:
        r4 = null;
        goto L12
    }

    public final String getProductSourcePage() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("product_source_page");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getRecommendInfo() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("recommend_info");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getRequestID() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("outer_reqid");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getSourcePage() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getTabId() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("tab_id");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final String getTabName() {
        Map<String, Object> r0 = this.tracker;
        if (r0 == null) goto L7;
        Object r1 = r0.get("tab_name");
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    public final DeepFeedAbValues getAbValues() {
        return this.abValues;
    }

    public final String getBizCode() {
        return this.bizCode;
    }

    public final String getCardParam() {
        return this.cardParam;
    }

    public final String getESceneId() {
        return this.eSceneId;
    }

    public final String getFirstCardProductId() {
        return this.firstCardProductId;
    }

    public final String getNegFeedbackJson() {
        return this.negFeedbackJson;
    }

    public final String getPassThroughParams() {
        return this.passThroughParams;
    }

    public final String getPreInflateCacheKey() {
        return this.preInflateCacheKey;
    }

    public final Map<String, Object> getRequestAddition() {
        return this.requestAddition;
    }

    public final String getSceneCode() {
        return this.sceneCode;
    }

    public final String getShareElementViewId() {
        return this.shareElementViewId;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final Map<String, Object> getTracker() {
        return this.tracker;
    }

    public final String getTriggers() {
        return this.triggers;
    }

    public final long getUid() {
        return this.uid;
    }

    public final String getFilters() {
        return this.filters;
    }

    public final void appendFilters(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.recFilterList.add(r2);
    }

    public final void appendInnerAction(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if (this.innerActionList.isEmpty() == false) goto L15;
        this.innerActionList.add(r4);
        return;
    L15:
        if (this.innerActionList.size() < 5) goto L17;
        ListProtector.remove(this.innerActionList, 0);
        this.innerActionList.add(r4);
        return;
    L17:
        this.innerActionList.add(r4);
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void fillFiltersFromMall$ec_shopping_impl_saasRelease(String r7) {
        this.filters = r7;
        this.filtersFromMall.clear();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        List r8 = StringsKt.split$default(r7, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L11
        if ((!r8.isEmpty()) == false) goto L9;
        this.filtersFromMall.addAll(r8);     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void filtersToAll(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.deepFeedAllFilters.add(r2);
    }

    public final void setFilters(String r1) {
        this.filters = r1;
    }

    public final void setFirstCardProductId(String r1) {
        this.firstCardProductId = r1;
    }

    public final void setNegFeedbackJson(String r1) {
        this.negFeedbackJson = r1;
    }

    public final void setPreInflateCacheKey(String r1) {
        this.preInflateCacheKey = r1;
    }

    public final void setRequestAddition(Map<String, ? extends Object> r1) {
        this.requestAddition = r1;
    }

    public final void setShareElementViewId(String r1) {
        this.shareElementViewId = r1;
    }

    public final void setSourceBtmToken(String r1) {
        this.sourceBtmToken = r1;
    }

    public DeepFeedQueryParam(String r1, Map<String, ? extends Object> r2, Map<String, ? extends Object> r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, DeepFeedAbValues r13) {
        this.eSceneId = r1;
        this.tracker = r2;
        this.requestAddition = r3;
        this.filters = r4;
        this.sourceBtmToken = r5;
        this.bizCode = r6;
        this.sceneCode = r7;
        this.cardParam = r8;
        this.passThroughParams = r9;
        this.triggers = r10;
        this.shareElementViewId = r11;
        this.negFeedbackJson = r12;
        this.abValues = r13;
        this.generatedTime = SystemClock.uptimeMillis();
        this.recFilterList = new ArrayList();
        this.deepFeedAllFilters = new ArrayList();
        ArrayList r14 = new ArrayList();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L11
        String r16 = this.filters;     // Catch: Throwable -> L11
        if (r16 != null) goto L6;
        r16 = "";
    L6:
        List r17 = StringsKt.split$default(r16, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L11
        if ((!r17.isEmpty()) == false) goto L9;
        r14.addAll(r17);     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        this.filtersFromMall = r14;
        this.innerActionList = new ArrayList();
        this.uid = this.generatedTime;
        return;
    L11:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public /* synthetic */ DeepFeedQueryParam(String r15, Map r16, Map r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, DeepFeedAbValues r27, int r28, DefaultConstructorMarker r29) {
        DeepFeedAbValues r2 = null;
        if ((r28 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r28 & 2) == 0) goto L9;
        Map r3 = null;
    L11:
        if ((r28 & 4) == 0) goto L13;
        Map r4 = null;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r2 = r27;
    L54:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2);
        return;
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
