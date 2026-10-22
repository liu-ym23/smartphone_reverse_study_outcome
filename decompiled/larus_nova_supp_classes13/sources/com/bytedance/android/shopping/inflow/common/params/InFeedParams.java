package com.bytedance.android.shopping.inflow.common.params;

import android.os.SystemClock;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\bM\u0018\u0000 x2\u00020\u0001:\u0001yB\u0085\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\b\b\u0002\u0010$\u001a\u00020\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bv\u0010wJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR4\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010 \u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b&\u0010'R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010'R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010'R#\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010'R#\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,8\u0006¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00101R\u0019\u00106\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b6\u0010\u0012\u001a\u0004\b7\u0010'R\u0019\u00108\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b8\u0010\u0012\u001a\u0004\b9\u0010'R\u0019\u0010:\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b;\u0010'R\u0019\u0010<\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010'R\u0019\u0010>\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010'R\u0019\u0010@\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b@\u0010\u0012\u001a\u0004\bA\u0010'R\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bB\u0010\u0012\u001a\u0004\bC\u0010'R\u0019\u0010D\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bD\u0010\u0012\u001a\u0004\bE\u0010'R\u0019\u0010F\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bG\u0010'R\u0019\u0010H\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bH\u0010\u0012\u001a\u0004\bI\u0010'R\u0019\u0010J\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bJ\u0010\u0012\u001a\u0004\bK\u0010'R\u0013\u0010M\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\bL\u0010\u001dR\u0013\u0010O\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bN\u0010'R\u0013\u0010Q\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bP\u0010'R\u0013\u0010S\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010'R\u0013\u0010U\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bT\u0010'R\u0013\u0010W\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bV\u0010'R\u0013\u0010Y\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010'R\u0013\u0010[\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bZ\u0010'R\u0013\u0010]\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\\\u0010'R\u0013\u0010_\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b^\u0010'R\u0013\u0010a\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b`\u0010'R\u0011\u0010c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bb\u0010'R\u0011\u0010e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bd\u0010'R\u0011\u0010g\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bf\u0010'R\u0011\u0010i\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bh\u0010'R\u0011\u0010k\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bj\u0010'R\u0011\u0010m\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bl\u0010'R\u0013\u0010o\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bn\u0010'R\u0013\u0010q\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bp\u0010'R\u0013\u0010s\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\br\u0010'R\u0013\u0010u\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bt\u0010'¨\u0006z"}, d2 = {"Lcom/bytedance/android/shopping/inflow/common/params/InFeedParams;", "Ljava/io/Serializable;", "", "productId", "getUpdateProductIdLogExtra", "getOriginLogExtra", "", "ids", "", "appendRecFilters", "", "generatedTime", "J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtraObj", "Ljava/util/HashMap;", "logExtraProductId", "Ljava/lang/String;", "", "recFilterList", "Ljava/util/List;", "uid", "getUid", "()J", "", "outerCardType", "Ljava/lang/Integer;", "getOuterCardType", "()Ljava/lang/Integer;", "outerEntranceType", "getOuterEntranceType", "inFeedType", "I", "getInFeedType", "()I", "display", "getDisplay", "getProductId", "()Ljava/lang/String;", "eSceneId", "getESceneId", "bgColor", "getBgColor", "", "", "tracker", "Ljava/util/Map;", "getTracker", "()Ljava/util/Map;", "metaData", "getMetaData", "requestAddition", "getRequestAddition", "themeBg", "getThemeBg", "themeLabel", "getThemeLabel", "activityBg", "getActivityBg", "activityTitle", "getActivityTitle", "activitySubtitle", "getActivitySubtitle", "activitySubtitleColor", "getActivitySubtitleColor", "firstCardData", "getFirstCardData", "imageUrl", "getImageUrl", "transitionName", "getTransitionName", "transitionId", "getTransitionId", "sourceBtmToken", "getSourceBtmToken", "getOutflowRank", "outflowRank", "getPrevPage", "prevPage", "getPageName", "pageName", "getEnterFromMerge", "enterFromMerge", "getEnterFrom", "enterFrom", "getCarrierSource", "carrierSource", "getSourcePage", "sourcePage", "getProductSourcePage", "productSourcePage", "getTabId", "tabId", "getTabName", "tabName", "getRecommendInfo", "recommendInfo", "getSceneId", "sceneId", "getPackBlockName", "packBlockName", "getActivityBlockName", "activityBlockName", "getBlockName", "blockName", "getRecRelated", "recRelated", "getRecFilters", "recFilters", "getRecTopicId", "recTopicId", "getRecTopicText", "recTopicText", "getRecTopicSchemeType", "recTopicSchemeType", "getRecTopicTag", "recTopicTag", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedParams implements Serializable {
    public static final a Companion = null;
    public static final int ENTRANCE_TYPE_HALF_SCREEN = 0;
    public static final int ENTRANCE_TYPE_LIVE_CARD = 2;
    public static final int ENTRANCE_TYPE_PRODUCT_CARD = 1;
    public static final int ENTRANCE_TYPE_VIDEO_CARD = 3;
    public static final int IN_FEED_MXIED_TYPE = 4;
    public static final int IN_FEED_TYPE_ACTIVITY = 3;
    public static final int IN_FEED_TYPE_NORMAL = 1;
    public static final int IN_FEED_TYPE_THEME = 2;
    private static final long serialVersionUID = -1;
    private final String activityBg;
    private final String activitySubtitle;
    private final String activitySubtitleColor;
    private final String activityTitle;
    private final String bgColor;
    private final int display;
    private final String eSceneId;
    private final String firstCardData;
    private final long generatedTime;
    private final String imageUrl;
    private final int inFeedType;
    private final HashMap<String, String> logExtraObj;
    private final String logExtraProductId;
    private final String metaData;
    private final Integer outerCardType;
    private final Integer outerEntranceType;
    private final String productId;
    private final List<String> recFilterList;
    private final Map<String, Object> requestAddition;
    private final String sourceBtmToken;
    private final String themeBg;
    private final String themeLabel;
    private final Map<String, Object> tracker;
    private final String transitionId;
    private final String transitionName;
    private final long uid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getOriginLogExtra() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        if (this.logExtraObj == null) goto L15;
        String r2 = this.logExtraProductId;     // Catch: Throwable -> L18
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        this.logExtraObj.put(PdpOpenThirdParam.KEY_PRODUCT_ID, this.logExtraProductId);     // Catch: Throwable -> L18
    L14:
        String r4 = cd.a.c(this.logExtraObj).toString();     // Catch: Throwable -> L18
    L16:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r5) == true) goto L25;
        r0 = r5;
    L25:
        return (String) r0;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    L15:
        r4 = null;
    L18:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public final String getActivityBlockName() {
        Object r0 = this.requestAddition.get("activity_block_name");
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        Intrinsics.checkNotNullParameter("product_inner_activity_header", "default");
        if (r1 == null) goto L9;
        return r1;
    L9:
        return "product_inner_activity_header";
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

    public final String getProductSourcePage() {
        Object r0 = this.tracker.get("product_source_page");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRecFilters() {
        if (this.inFeedType != 1) goto L11;
        Object r0 = this.requestAddition.get("rec_filters");
        if (r0 == null) goto L7;
        String r1 = r0.toString();
    L8:
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    L7:
        r1 = null;
        goto L8
    L11:
        StringBuilder r2 = new StringBuilder();
        Iterator<T> r3 = this.recFilterList.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r2.append((String) r3.next());
        r2.append(",");
        goto L13
    L15:
        r2.delete(r2.length() - 1, r2.length());
        return r2.toString();
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

    public final String getRecTopicId() {
        Object r0 = this.requestAddition.get("topic_rec_id");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRecTopicSchemeType() {
        Object r0 = this.requestAddition.get("topic_schema_type");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRecTopicTag() {
        Object r0 = this.requestAddition.get("topic_tag");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRecTopicText() {
        Object r0 = this.requestAddition.get("topic_rec_text");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final String getRecommendInfo() {
        Object r0 = this.tracker.get("recommend_info");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
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

    public final String getActivityBg() {
        return this.activityBg;
    }

    public final String getActivitySubtitle() {
        return this.activitySubtitle;
    }

    public final String getActivitySubtitleColor() {
        return this.activitySubtitleColor;
    }

    public final String getActivityTitle() {
        return this.activityTitle;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getDisplay() {
        return this.display;
    }

    public final String getESceneId() {
        return this.eSceneId;
    }

    public final String getFirstCardData() {
        return this.firstCardData;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getInFeedType() {
        return this.inFeedType;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final Integer getOuterCardType() {
        return this.outerCardType;
    }

    public final Integer getOuterEntranceType() {
        return this.outerEntranceType;
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

    public final String getThemeBg() {
        return this.themeBg;
    }

    public final String getThemeLabel() {
        return this.themeLabel;
    }

    public final Map<String, Object> getTracker() {
        return this.tracker;
    }

    public final String getTransitionId() {
        return this.transitionId;
    }

    public final String getTransitionName() {
        return this.transitionName;
    }

    public final long getUid() {
        return this.uid;
    }

    public final void appendRecFilters(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        int r0 = this.inFeedType;
        if (r0 != 2) goto L5;
    L8:
        this.recFilterList.addAll(r3);
        return;
    L5:
        if (r0 == 3) goto L8;
        if (r0 == 4) goto L8;
    }

    public final String getUpdateProductIdLogExtra(String r4) {
        Intrinsics.checkNotNullParameter(r4, "productId");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        HashMap<String, String> r2 = this.logExtraObj;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r4);     // Catch: Throwable -> L9
        String r5 = cd.a.c(this.logExtraObj).toString();     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r0 = r6;
    L16:
        return (String) r0;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public InFeedParams(Integer r13, Integer r14, int r15, int r16, String r17, String r18, String r19, Map<String, ? extends Object> r20, String r21, Map<String, ? extends Object> r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33) {
        Intrinsics.checkNotNullParameter(r17, "productId");
        Intrinsics.checkNotNullParameter(r20, "tracker");
        Intrinsics.checkNotNullParameter(r21, "metaData");
        Intrinsics.checkNotNullParameter(r22, "requestAddition");
        this.outerCardType = r13;
        this.outerEntranceType = r14;
        this.inFeedType = r15;
        this.display = r16;
        this.productId = r17;
        this.eSceneId = r18;
        this.bgColor = r19;
        this.tracker = r20;
        this.metaData = r21;
        this.requestAddition = r22;
        this.themeBg = r23;
        this.themeLabel = r24;
        this.activityBg = r25;
        this.activityTitle = r26;
        this.activitySubtitle = r27;
        this.activitySubtitleColor = r28;
        this.firstCardData = r29;
        this.imageUrl = r30;
        this.transitionName = r31;
        this.transitionId = r32;
        this.sourceBtmToken = r33;
        this.generatedTime = SystemClock.uptimeMillis();
        Object r0 = r20.get("log_extra");
        String r4 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r2 = (String) r0;
        JSONArray r1 = k.t(r2);
        boolean r5 = true;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
    L19:
        HashMap r8 = null;
    L20:
        Object r3 = Result.constructor-impl(r8);     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r3) == false) goto L27;
        r3 = null;
    L27:
        HashMap<String, String> r6 = (HashMap) r3;
        this.logExtraObj = r6;
        if (r6 == null) goto L30;
        String r9 = r6.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
    L31:
        this.logExtraProductId = r9;
        if (r2 != null) goto L34;
    L37:
        boolean r10 = true;
    L38:
        if (r10 == true) goto L44;
        Map<String, Object> r11 = this.tracker;
        if (r11 == null) goto L43;
        ((HashMap) r11).remove("log_extra");
        goto L44
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
    L44:
        String r12 = getRecTopicId();
        if (r12 != null) goto L47;
    L50:
        boolean r34 = true;
    L51:
        if (r34 == true) goto L54;
        if (r6 == null) goto L54;
        String r35 = r6.put("topic_id", r12);
    L54:
        ArrayList r36 = new ArrayList();
        Object r37 = this.requestAddition.get("rec_filters");     // Catch: Throwable -> L70
        if (r37 == null) goto L58;
        r4 = r37.toString();     // Catch: Throwable -> L70
    L58:
        if (r4 != null) goto L60;
        r4 = "";
    L60:
        List r38 = StringsKt.split$default(r4, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L70
        List r39 = r38;     // Catch: Throwable -> L70
        if (r39 != null) goto L63;
    L66:
        if (r5 == true) goto L68;
        r36.addAll(r38);     // Catch: Throwable -> L70
    L68:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L72:
        this.recFilterList = r36;
        this.uid = this.generatedTime;
        return;
    L63:
        if (r39.isEmpty() == true) goto L66;
        r5 = false;
    L70:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L72
    L47:
        if (r12.length() == 0) goto L50;
        r34 = false;
        goto L51
    L34:
        if (r2.length() == 0) goto L37;
        r10 = false;
        goto L38
    L30:
        r9 = null;
        goto L31
    L9:
        if (r1.length() <= 0) goto L19;
        JSONObject r41 = JSONArrayProtectorUtils.getJSONObject(r1, 0);     // Catch: Throwable -> L22
        r8 = new HashMap();     // Catch: Throwable -> L22
        Iterator<String> r42 = r41.keys();     // Catch: Throwable -> L22
    L12:
        if (r42.hasNext() == false) goto L20;
        String r43 = r42.next();     // Catch: Throwable -> L22
        String r110 = r41.opt(r43).toString();     // Catch: Throwable -> L22
        if (r110.length() <= 0) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == false) goto L12;
        r8.put(r43, r110);     // Catch: Throwable -> L22
        goto L12
    L16:
        r111 = false;
    L22:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    public /* synthetic */ InFeedParams(Integer r27, Integer r28, int r29, int r30, String r31, String r32, String r33, Map r34, String r35, Map r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, int r48, DefaultConstructorMarker r49) {
        if ((r48 & 1) == 0) goto L5;
        Integer r5 = 0;
    L7:
        if ((r48 & 2) == 0) goto L9;
        Integer r6 = 0;
    L11:
        if ((r48 & 8) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r48 & 32) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r48 & 64) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r48 & 1024) == 0) goto L25;
        String r15 = null;
    L27:
        if ((r48 & 2048) == 0) goto L29;
        String r16 = null;
    L31:
        if ((r48 & 4096) == 0) goto L33;
        String r17 = null;
    L35:
        if ((r48 & 8192) == 0) goto L37;
        String r18 = null;
    L39:
        if ((r48 & 16384) == 0) goto L41;
        String r19 = null;
    L43:
        if ((32768 & r48) == 0) goto L45;
        String r20 = null;
    L47:
        if ((65536 & r48) == 0) goto L49;
        String r21 = null;
    L51:
        if ((131072 & r48) == 0) goto L53;
        String r22 = null;
    L55:
        if ((262144 & r48) == 0) goto L57;
        String r23 = null;
    L59:
        if ((524288 & r48) == 0) goto L61;
        String r24 = null;
    L63:
        if ((r48 & 1048576) == 0) goto L65;
        String r25 = null;
    L66:
        this(r5, r6, r29, r8, r31, r10, r11, r34, r35, r36, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        return;
    L65:
        r25 = r47;
        goto L66
    L61:
        r24 = r46;
        goto L63
    L57:
        r23 = r45;
        goto L59
    L53:
        r22 = r44;
        goto L55
    L49:
        r21 = r43;
        goto L51
    L45:
        r20 = r42;
        goto L47
    L41:
        r19 = r41;
        goto L43
    L37:
        r18 = r40;
        goto L39
    L33:
        r17 = r39;
        goto L35
    L29:
        r16 = r38;
        goto L31
    L25:
        r15 = r37;
        goto L27
    L21:
        r11 = r33;
        goto L23
    L17:
        r10 = r32;
        goto L19
    L13:
        r8 = r30;
        goto L15
    L9:
        r6 = r28;
        goto L11
    L5:
        r5 = r27;
        goto L7
    }
}
