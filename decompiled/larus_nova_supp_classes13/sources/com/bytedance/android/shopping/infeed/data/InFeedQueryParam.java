package com.bytedance.android.shopping.infeed.data;

import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0003J\u0014\u0010Y\u001a\u00020W2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00030[R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u000eR\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u000eR\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u000eR\u0013\u0010/\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u000eR\u0013\u00101\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u000eR\u0011\u00103\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b4\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000eR\u0013\u00106\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b7\u0010\u000eR\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b:\u0010\u000eR\u0011\u0010;\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b<\u0010\u000eR\u0013\u0010=\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b>\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bB\u0010\u000eR\u0011\u0010C\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bD\u0010\u000eR\u0011\u0010E\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bF\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u000eR\u0013\u0010H\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bI\u0010\u000eR\u0013\u0010J\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bK\u0010\u000eR\u0013\u0010L\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bM\u0010\u000eR\u0011\u0010N\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bO\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\bP\u0010@R\u0011\u0010Q\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bU\u0010\u000e¨\u0006\\"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/InFeedQueryParam;", "Ljava/io/Serializable;", "productId", "", "eSceneId", "tracker", "", "", "metaData", "requestAddition", "sourceBtmToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "authorID", "getAuthorID", "()Ljava/lang/String;", "blockName", "getBlockName", "carrierSource", "getCarrierSource", "getESceneId", "ecomEntranceForm", "getEcomEntranceForm", "enterFrom", "getEnterFrom", "enterFromMerge", "getEnterFromMerge", "generatedTime", "", "innerActionList", "", "innerActions", "getInnerActions", "innerTitle", "getInnerTitle", "lastAction", "getLastAction", "mainImageAuthorId", "getMainImageAuthorId", "getMetaData", "outflowEcomType", "getOutflowEcomType", "outflowRank", "", "getOutflowRank", "()Ljava/lang/Integer;", "packBlockName", "getPackBlockName", "pageName", "getPageName", "prevPage", "getPrevPage", "productActivityType", "getProductActivityType", "getProductId", "productSourcePage", "getProductSourcePage", "recFilterList", "recFilters", "getRecFilters", "recRelated", "getRecRelated", "recommendInfo", "getRecommendInfo", "getRequestAddition", "()Ljava/util/Map;", "requestID", "getRequestID", "sceneCode", "getSceneCode", "sceneId", "getSceneId", "getSourceBtmToken", "sourcePage", "getSourcePage", "tabId", "getTabId", "tabName", "getTabName", "topicRecId", "getTopicRecId", "getTracker", "uid", "getUid", "()J", "videoId", "getVideoId", "appendInnerAction", "", "id", "appendRecFilters", "ids", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedQueryParam implements Serializable {
    private final String eSceneId;
    private final long generatedTime;
    private final List<String> innerActionList;
    private final String metaData;
    private final String productId;
    private final List<String> recFilterList;
    private final Map<String, Object> requestAddition;
    private final String sourceBtmToken;
    private final Map<String, Object> tracker;
    private final long uid;

    public final String getAuthorID() {
        Object r0 = this.requestAddition.get("author_id");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getBlockName() {
        Object r0 = this.requestAddition.get("block_name");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getCarrierSource() {
        Object r0 = this.tracker.get("carrier_source");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getEcomEntranceForm() {
        Object r0 = this.tracker.get("ecom_entrance_form");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getEnterFrom() {
        Object r0 = this.tracker.get(SimilarProductParam.ENTER_FROM);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getEnterFromMerge() {
        Object r0 = this.tracker.get("enter_from_merge");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getInnerActions() {
        List<String> r0 = this.innerActionList;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "";
    L12:
        StringBuilder r2 = new StringBuilder();
        Iterator<T> r3 = this.innerActionList.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r2.append("1_2_" + ((String) r3.next()));
        r2.append(",");
        goto L14
    L16:
        r2.delete(r2.length() - 1, r2.length());
        return r2.toString();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final String getInnerTitle() {
        Object r0 = this.requestAddition.get("inner_title");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getLastAction() {
        Object r0 = this.requestAddition.get("last_actions");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getMainImageAuthorId() {
        Object r0 = this.requestAddition.get("main_image_author_id");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final Integer getOutflowRank() {
        Object r0 = this.tracker.get("outflow_order");
        if ((r0 instanceof Integer) == true) goto L6;
        r0 = null;
    L6:
        return (Integer) r0;
    }

    public final String getPackBlockName() {
        Object r0 = this.requestAddition.get("pack_block_name");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        Intrinsics.checkNotNullParameter("product_inner_head", "default");
        if (r1 == null) goto L9;
        return r1;
    L9:
        return "product_inner_head";
    L5:
        r1 = null;
        goto L6
    }

    public final String getPageName() {
        Object r0 = this.tracker.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getPrevPage() {
        Object r0 = this.tracker.get("previous_page");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getProductActivityType() {
        Object r0 = this.tracker.get("label_info");
        if (r0 == null) goto L9;
        String r1 = r0.toString();
        if (r1 == null) goto L9;
        JSONObject r2 = k.c(r1);
        if (r2 == null) goto L9;
        String r3 = r2.optString("product_activity_type");
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final String getProductSourcePage() {
        Object r0 = this.tracker.get("product_source_page");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRecFilters() {
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.recFilterList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.append((String) r1.next());
        r0.append(",");
        goto L4
    L6:
        r0.delete(r0.length() - 1, r0.length());
        return r0.toString();
    }

    public final String getRecRelated() {
        Object r0 = this.requestAddition.get("rec_related");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getRecommendInfo() {
        Object r0 = this.tracker.get("recommend_info");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRequestID() {
        Object r0 = this.tracker.get("outer_reqid");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getSceneCode() {
        Object r0 = this.requestAddition.get("scene_code");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getSceneId() {
        Object r0 = this.requestAddition.get("scene_id");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getSourcePage() {
        Object r0 = this.tracker.get(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getTabId() {
        Object r0 = this.tracker.get("tab_id");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getTabName() {
        Object r0 = this.tracker.get("tab_name");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getTopicRecId() {
        Object r0 = this.requestAddition.get("topic_rec_id");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getVideoId() {
        Object r0 = this.requestAddition.get("video_id");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getOutflowEcomType() {
        if (com.bytedance.android.shopping.extensions.k.c(getInnerTitle()) == false) goto L6;
        return "product";
    L6:
        if (Intrinsics.areEqual(getProductActivityType(), "2") == false) goto L8;
        return "topic_activity2";
    L8:
        return "topic_activity3";
    }

    public final String getESceneId() {
        return this.eSceneId;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Map<String, Object> getRequestAddition() {
        return this.requestAddition;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final Map<String, Object> getTracker() {
        return this.tracker;
    }

    public final long getUid() {
        return this.uid;
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

    public final void appendRecFilters(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        this.recFilterList.addAll(r2);
    }

    public InFeedQueryParam(String r7, String r8, Map<String, ? extends Object> r9, String r10, Map<String, ? extends Object> r11, String r12) {
        Intrinsics.checkNotNullParameter(r7, "productId");
        Intrinsics.checkNotNullParameter(r9, "tracker");
        Intrinsics.checkNotNullParameter(r10, "metaData");
        Intrinsics.checkNotNullParameter(r11, "requestAddition");
        this.productId = r7;
        this.eSceneId = r8;
        this.tracker = r9;
        this.metaData = r10;
        this.requestAddition = r11;
        this.sourceBtmToken = r12;
        this.generatedTime = SystemClock.uptimeMillis();
        ArrayList r13 = new ArrayList();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        Object r15 = r11.get("rec_filters");     // Catch: Throwable -> L20
        if (r15 == null) goto L6;
        String r16 = r15.toString();     // Catch: Throwable -> L20
    L7:
        if (r16 != null) goto L9;
        r16 = "";
    L9:
        List r17 = StringsKt.split$default(r16, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L20
        List r18 = r17;     // Catch: Throwable -> L20
        if (r18 != null) goto L12;
    L15:
        boolean r19 = true;
    L16:
        if (r19 == true) goto L18;
        r13.addAll(r17);     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.recFilterList = r13;
        this.innerActionList = new ArrayList();
        this.uid = this.generatedTime;
        return;
    L12:
        if (r18.isEmpty() == true) goto L15;
        r19 = false;
        goto L16
    L6:
        r16 = null;
    L20:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public /* synthetic */ InFeedQueryParam(String r10, String r11, Map r12, String r13, Map r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        String r8 = null;
    L10:
        this(r10, r4, r12, r13, r14, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r4 = r11;
        goto L7
    }
}
