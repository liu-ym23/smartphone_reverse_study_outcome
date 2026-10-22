package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u00102\u001a\u00020\u000f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001f\u0012\u0016\b\u0002\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010!\u0012\b\b\u0002\u0010?\u001a\u00020\u000f\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010%\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010E\u001a\u00020\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010-¢\u0006\u0004\b}\u0010~J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0002HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010!HÆ\u0003J\t\u0010#\u001a\u00020\u000fHÆ\u0003J\t\u0010$\u001a\u00020\u0002HÆ\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010%HÆ\u0003J\u0012\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b*\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b+\u0010)J\t\u0010,\u001a\u00020\u0002HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003JÌ\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u00102\u001a\u00020\u000f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00162\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010<\u001a\u00020\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001f2\u0016\b\u0002\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010!2\b\b\u0002\u0010?\u001a\u00020\u000f2\b\b\u0002\u0010@\u001a\u00020\u00022\u0018\b\u0002\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010%2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010E\u001a\u00020\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010-HÆ\u0001¢\u0006\u0004\bG\u0010HJ\t\u0010I\u001a\u00020\u0018HÖ\u0001J\t\u0010J\u001a\u00020\u000fHÖ\u0001J\u0013\u0010M\u001a\u00020\u00022\b\u0010L\u001a\u0004\u0018\u00010KHÖ\u0003R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010N\u001a\u0004\bO\u0010\tR\u001c\u00100\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010P\u001a\u0004\bQ\u0010RR\"\u00101\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010S\u001a\u0004\bT\u0010UR\u001a\u00102\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010V\u001a\u0004\bW\u0010XR\u001c\u00103\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010Y\u001a\u0004\bZ\u0010[R\u001c\u00104\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010Y\u001a\u0004\b\\\u0010[R\u001c\u00105\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010Y\u001a\u0004\b]\u0010[R\u001c\u00106\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010Y\u001a\u0004\b^\u0010[R\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010S\u001a\u0004\b_\u0010UR\u001c\u00108\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010`\u001a\u0004\ba\u0010bR\u001c\u00109\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010`\u001a\u0004\bc\u0010bR\u001c\u0010:\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010`\u001a\u0004\bd\u0010bR\u001c\u0010;\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010e\u001a\u0004\bf\u0010gR\u001a\u0010<\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010=\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010k\u001a\u0004\bl\u0010mR(\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010n\u001a\u0004\bo\u0010pR\"\u0010?\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010V\u001a\u0004\bq\u0010X\"\u0004\br\u0010sR\u001a\u0010@\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010h\u001a\u0004\bt\u0010jR*\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010n\u001a\u0004\bu\u0010pR\u001c\u0010B\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010v\u001a\u0004\bw\u0010)R\u001c\u0010C\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010v\u001a\u0004\bx\u0010)R\u001c\u0010D\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010v\u001a\u0004\by\u0010)R\u001a\u0010E\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010h\u001a\u0004\bE\u0010jR\u001c\u0010F\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010z\u001a\u0004\b{\u0010|¨\u0006\u007f"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorInfo;", "Ljava/io/Serializable;", "", "enableExpandForLike", "enableExpandForCloseComment", "enableExpandForCollectItem", "enableExpandForShareItem", "enableExpandForFocusOnAuthor", "component1", "()Ljava/lang/Boolean;", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorTag;", "component2", "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentStruct;", "component3", "", "component4", "Lt14/a;", "component5", "component6", "component7", "component8", "", "component9", "", "component10", "component11", "component12", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiSchema;", "component13", "component14", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiDetailModalView;", "component15", "", "component16", "component17", "component18", "", "component19", "", "component20", "()Ljava/lang/Long;", "component21", "component22", "component23", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiVideoAnchorMargin;", "component24", "existRelationPoi", "suffix", "minorTags", "extendTime", "poiIconUrl", "poiIconLightUrl", "serviceIconUrl", "cityPoiLandingIconUrl", "intentionOpen", "requestId", "anchorContentJson", "poiType", "schema", "hasMpSpu", "modalView", "logExtra", "styleType", "needRequestCard", "cardParams", "reqCardTimeout", "cardDataExpireTs", "cardMinShowTime", "isCommerceIntention", "poiVideoAnchorMargin", "copy", "(Ljava/lang/Boolean;Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorTag;Ljava/util/List;ILt14/a;Lt14/a;Lt14/a;Lt14/a;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiSchema;ZLcom/bytedance/awemeopen/bizmodels/feed/poi/PoiDetailModalView;Ljava/util/Map;IZLjava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZLcom/bytedance/awemeopen/bizmodels/feed/poi/PoiVideoAnchorMargin;)Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorInfo;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/Boolean;", "getExistRelationPoi", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorTag;", "getSuffix", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorTag;", "Ljava/util/List;", "getMinorTags", "()Ljava/util/List;", "I", "getExtendTime", "()I", "Lt14/a;", "getPoiIconUrl", "()Lt14/a;", "getPoiIconLightUrl", "getServiceIconUrl", "getCityPoiLandingIconUrl", "getIntentionOpen", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "getAnchorContentJson", "getPoiType", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiSchema;", "getSchema", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiSchema;", "Z", "getHasMpSpu", "()Z", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiDetailModalView;", "getModalView", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiDetailModalView;", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "getStyleType", "setStyleType", "(I)V", "getNeedRequestCard", "getCardParams", "Ljava/lang/Long;", "getReqCardTimeout", "getCardDataExpireTs", "getCardMinShowTime", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiVideoAnchorMargin;", "getPoiVideoAnchorMargin", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiVideoAnchorMargin;", "<init>", "(Ljava/lang/Boolean;Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorTag;Ljava/util/List;ILt14/a;Lt14/a;Lt14/a;Lt14/a;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiSchema;ZLcom/bytedance/awemeopen/bizmodels/feed/poi/PoiDetailModalView;Ljava/util/Map;IZLjava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZLcom/bytedance/awemeopen/bizmodels/feed/poi/PoiVideoAnchorMargin;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class PoiItemAnchorInfo implements Serializable {

    @SerializedName("anchor_content_json")
    private final String anchorContentJson;

    @SerializedName("card_data_expire_time")
    private final Long cardDataExpireTs;

    @SerializedName("card_min_show_time")
    private final Long cardMinShowTime;

    @SerializedName("card_params")
    private final Map<String, String> cardParams;

    @SerializedName("city_poi_landing_page_icon")
    private final t14.a cityPoiLandingIconUrl;

    @SerializedName("exist_relation_poi")
    private final Boolean existRelationPoi;

    @SerializedName("minor_tag_extend_time")
    private final int extendTime;

    @SerializedName("has_mp_spu")
    private final boolean hasMpSpu;

    @SerializedName("intention_open")
    private final List<Integer> intentionOpen;

    @SerializedName("is_commerce_intention")
    private final boolean isCommerceIntention;

    @SerializedName("log_extra")
    private final Map<String, String> logExtra;

    @SerializedName("minor_tags")
    private final List<PoiAnchorContentStruct> minorTags;

    @SerializedName("poi_detail_modal_view")
    private final PoiDetailModalView modalView;

    @SerializedName("need_req_card")
    private final boolean needRequestCard;

    @SerializedName("icon_light")
    private final t14.a poiIconLightUrl;

    @SerializedName("icon")
    private final t14.a poiIconUrl;

    @SerializedName("type_name")
    private final String poiType;

    @SerializedName("video_anchor_margin")
    private final PoiVideoAnchorMargin poiVideoAnchorMargin;

    @SerializedName("req_card_timeout")
    private final Long reqCardTimeout;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("schema")
    private final PoiSchema schema;

    @SerializedName("service_icon")
    private final t14.a serviceIconUrl;

    @SerializedName("anchor_exploration_style")
    private int styleType;

    @SerializedName("suffix")
    private final PoiItemAnchorTag suffix;

    public PoiItemAnchorInfo() {
        this(null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, 0, false, null, null, null, null, false, null, 16777215, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiItemAnchorInfo copy$default(PoiItemAnchorInfo r110, Boolean r111, PoiItemAnchorTag r112, List r210, int r211, t14.a r212, t14.a r213, t14.a r214, t14.a r215, List r216, String r217, String r218, String r219, PoiSchema r310, boolean r311, PoiDetailModalView r312, Map r313, int r314, boolean r315, Map r316, Long r317, Long r318, Long r319, boolean r410, PoiVideoAnchorMargin r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        Boolean r100 = r110.existRelationPoi;
    L7:
        if ((r412 & 2) == 0) goto L9;
        PoiItemAnchorTag r101 = r110.suffix;
    L11:
        if ((r412 & 4) == 0) goto L13;
        List r102 = r110.minorTags;
    L15:
        if ((r412 & 8) == 0) goto L17;
        int r103 = r110.extendTime;
    L19:
        if ((r412 & 16) == 0) goto L21;
        t14.a r104 = r110.poiIconUrl;
    L23:
        if ((r412 & 32) == 0) goto L25;
        t14.a r105 = r110.poiIconLightUrl;
    L27:
        if ((r412 & 64) == 0) goto L29;
        t14.a r106 = r110.serviceIconUrl;
    L31:
        if ((r412 & 128) == 0) goto L33;
        t14.a r107 = r110.cityPoiLandingIconUrl;
    L35:
        if ((r412 & 256) == 0) goto L37;
        List r113 = r110.intentionOpen;
    L39:
        if ((r412 & 512) == 0) goto L41;
        String r114 = r110.requestId;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r115 = r110.anchorContentJson;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r116 = r110.poiType;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        PoiSchema r117 = r110.schema;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        boolean r118 = r110.hasMpSpu;
    L58:
        boolean r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        PoiDetailModalView r119 = r110.modalView;
    L62:
        PoiDetailModalView r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        Map r120 = r110.logExtra;
    L66:
        Map r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        int r121 = r110.styleType;
    L70:
        int r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        boolean r122 = r110.needRequestCard;
    L74:
        boolean r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        Map r123 = r110.cardParams;
    L78:
        Map r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        Long r124 = r110.reqCardTimeout;
    L82:
        Long r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        Long r125 = r110.cardDataExpireTs;
    L86:
        Long r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        Long r126 = r110.cardMinShowTime;
    L90:
        Long r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        boolean r127 = r110.isCommerceIntention;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        PoiVideoAnchorMargin r108 = r110.poiVideoAnchorMargin;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
    L97:
        r108 = r411;
        goto L99
    L93:
        r127 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Boolean component1() {
        return this.existRelationPoi;
    }

    public final String component10() {
        return this.requestId;
    }

    public final String component11() {
        return this.anchorContentJson;
    }

    public final String component12() {
        return this.poiType;
    }

    public final PoiSchema component13() {
        return this.schema;
    }

    public final boolean component14() {
        return this.hasMpSpu;
    }

    public final PoiDetailModalView component15() {
        return this.modalView;
    }

    public final Map<String, String> component16() {
        return this.logExtra;
    }

    public final int component17() {
        return this.styleType;
    }

    public final boolean component18() {
        return this.needRequestCard;
    }

    public final Map<String, String> component19() {
        return this.cardParams;
    }

    public final PoiItemAnchorTag component2() {
        return this.suffix;
    }

    public final Long component20() {
        return this.reqCardTimeout;
    }

    public final Long component21() {
        return this.cardDataExpireTs;
    }

    public final Long component22() {
        return this.cardMinShowTime;
    }

    public final boolean component23() {
        return this.isCommerceIntention;
    }

    public final PoiVideoAnchorMargin component24() {
        return this.poiVideoAnchorMargin;
    }

    public final List<PoiAnchorContentStruct> component3() {
        return this.minorTags;
    }

    public final int component4() {
        return this.extendTime;
    }

    public final t14.a component5() {
        return this.poiIconUrl;
    }

    public final t14.a component6() {
        return this.poiIconLightUrl;
    }

    public final t14.a component7() {
        return this.serviceIconUrl;
    }

    public final t14.a component8() {
        return this.cityPoiLandingIconUrl;
    }

    public final List<Integer> component9() {
        return this.intentionOpen;
    }

    public final PoiItemAnchorInfo copy(Boolean r210, PoiItemAnchorTag r211, List<PoiAnchorContentStruct> r212, int r310, t14.a r311, t14.a r312, t14.a r313, t14.a r314, List<Integer> r315, String r316, String r317, String r318, PoiSchema r319, boolean r410, PoiDetailModalView r411, Map<String, String> r412, int r413, boolean r414, Map<String, String> r415, Long r416, Long r417, Long r418, boolean r419, PoiVideoAnchorMargin r510) {
        return new PoiItemAnchorInfo(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiItemAnchorInfo) == true) goto L8;
        return false;
    L8:
        PoiItemAnchorInfo r101 = (PoiItemAnchorInfo) r100;
        if (Intrinsics.areEqual(this.existRelationPoi, r101.existRelationPoi) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.minorTags, r101.minorTags) == true) goto L18;
        return false;
    L18:
        if (this.extendTime == r101.extendTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiIconUrl, r101.poiIconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.poiIconLightUrl, r101.poiIconLightUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.serviceIconUrl, r101.serviceIconUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cityPoiLandingIconUrl, r101.cityPoiLandingIconUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.intentionOpen, r101.intentionOpen) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.anchorContentJson, r101.anchorContentJson) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.poiType, r101.poiType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L48;
        return false;
    L48:
        if (this.hasMpSpu == r101.hasMpSpu) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.modalView, r101.modalView) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L57;
        return false;
    L57:
        if (this.styleType == r101.styleType) goto L60;
        return false;
    L60:
        if (this.needRequestCard == r101.needRequestCard) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.cardParams, r101.cardParams) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.reqCardTimeout, r101.reqCardTimeout) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.cardDataExpireTs, r101.cardDataExpireTs) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.cardMinShowTime, r101.cardMinShowTime) == true) goto L75;
        return false;
    L75:
        if (this.isCommerceIntention == r101.isCommerceIntention) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.poiVideoAnchorMargin, r101.poiVideoAnchorMargin) == true) goto L80;
        return false;
    L80:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Boolean r100 = this.existRelationPoi;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiItemAnchorTag r104 = this.suffix;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<PoiAnchorContentStruct> r107 = this.minorTags;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.extendTime) * 31;
        t14.a r110 = this.poiIconUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        t14.a r113 = this.poiIconLightUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        t14.a r116 = this.serviceIconUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        t14.a r119 = this.cityPoiLandingIconUrl;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<Integer> r122 = this.intentionOpen;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.requestId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.anchorContentJson;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.poiType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        PoiSchema r134 = this.schema;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        boolean r137 = this.hasMpSpu;
        ?? r138 = 1;
        ?? r139 = r137;
        if (r137 == false) goto L53;
        r139 = 1;
    L53:
        int r140 = (r136 + r139) * 31;
        PoiDetailModalView r141 = this.modalView;
        if (r141 != null) goto L56;
        int r142 = 0;
    L57:
        int r143 = (r140 + r142) * 31;
        Map<String, String> r144 = this.logExtra;
        if (r144 != null) goto L60;
        int r145 = 0;
    L61:
        int r146 = (((r143 + r145) * 31) + this.styleType) * 31;
        boolean r147 = this.needRequestCard;
        ?? r148 = r147;
        if (r147 == false) goto L64;
        r148 = 1;
    L64:
        int r149 = (r146 + r148) * 31;
        Map<String, String> r150 = this.cardParams;
        if (r150 != null) goto L67;
        int r151 = 0;
    L68:
        int r152 = (r149 + r151) * 31;
        Long r153 = this.reqCardTimeout;
        if (r153 != null) goto L71;
        int r154 = 0;
    L72:
        int r155 = (r152 + r154) * 31;
        Long r156 = this.cardDataExpireTs;
        if (r156 != null) goto L75;
        int r157 = 0;
    L76:
        int r158 = (r155 + r157) * 31;
        Long r159 = this.cardMinShowTime;
        if (r159 != null) goto L79;
        int r160 = 0;
    L80:
        int r161 = (r158 + r160) * 31;
        boolean r162 = this.isCommerceIntention;
        if (r162 == true) goto L84;
        r138 = r162;
    L84:
        int r163 = (r161 + r138) * 31;
        PoiVideoAnchorMargin r164 = this.poiVideoAnchorMargin;
        if (r164 == null) goto L89;
        r101 = r164.hashCode();
    L89:
        return r163 + r101;
    L79:
        r160 = r159.hashCode();
        goto L80
    L75:
        r157 = r156.hashCode();
        goto L76
    L71:
        r154 = r153.hashCode();
        goto L72
    L67:
        r151 = r150.hashCode();
        goto L68
    L60:
        r145 = r144.hashCode();
        goto L61
    L56:
        r142 = r141.hashCode();
        goto L57
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiItemAnchorInfo(existRelationPoi=" + this.existRelationPoi + ", suffix=" + this.suffix + ", minorTags=" + this.minorTags + ", extendTime=" + this.extendTime + ", poiIconUrl=" + this.poiIconUrl + ", poiIconLightUrl=" + this.poiIconLightUrl + ", serviceIconUrl=" + this.serviceIconUrl + ", cityPoiLandingIconUrl=" + this.cityPoiLandingIconUrl + ", intentionOpen=" + this.intentionOpen + ", requestId=" + this.requestId + ", anchorContentJson=" + this.anchorContentJson + ", poiType=" + this.poiType + ", schema=" + this.schema + ", hasMpSpu=" + this.hasMpSpu + ", modalView=" + this.modalView + ", logExtra=" + this.logExtra + ", styleType=" + this.styleType + ", needRequestCard=" + this.needRequestCard + ", cardParams=" + this.cardParams + ", reqCardTimeout=" + this.reqCardTimeout + ", cardDataExpireTs=" + this.cardDataExpireTs + ", cardMinShowTime=" + this.cardMinShowTime + ", isCommerceIntention=" + this.isCommerceIntention + ", poiVideoAnchorMargin=" + this.poiVideoAnchorMargin + ')';
    }

    public final boolean enableExpandForCloseComment() {
        List<Integer> r100 = this.intentionOpen;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains(2);
    }

    public final boolean enableExpandForCollectItem() {
        List<Integer> r100 = this.intentionOpen;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains(3);
    }

    public final boolean enableExpandForFocusOnAuthor() {
        List<Integer> r100 = this.intentionOpen;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains(5);
    }

    public final boolean enableExpandForLike() {
        List<Integer> r100 = this.intentionOpen;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains(1);
    }

    public final boolean enableExpandForShareItem() {
        List<Integer> r100 = this.intentionOpen;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contains(4);
    }

    public final String getAnchorContentJson() {
        return this.anchorContentJson;
    }

    public final Long getCardDataExpireTs() {
        return this.cardDataExpireTs;
    }

    public final Long getCardMinShowTime() {
        return this.cardMinShowTime;
    }

    public final Map<String, String> getCardParams() {
        return this.cardParams;
    }

    public final t14.a getCityPoiLandingIconUrl() {
        return this.cityPoiLandingIconUrl;
    }

    public final Boolean getExistRelationPoi() {
        return this.existRelationPoi;
    }

    public final int getExtendTime() {
        return this.extendTime;
    }

    public final boolean getHasMpSpu() {
        return this.hasMpSpu;
    }

    public final List<Integer> getIntentionOpen() {
        return this.intentionOpen;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final List<PoiAnchorContentStruct> getMinorTags() {
        return this.minorTags;
    }

    public final PoiDetailModalView getModalView() {
        return this.modalView;
    }

    public final boolean getNeedRequestCard() {
        return this.needRequestCard;
    }

    public final t14.a getPoiIconLightUrl() {
        return this.poiIconLightUrl;
    }

    public final t14.a getPoiIconUrl() {
        return this.poiIconUrl;
    }

    public final String getPoiType() {
        return this.poiType;
    }

    public final PoiVideoAnchorMargin getPoiVideoAnchorMargin() {
        return this.poiVideoAnchorMargin;
    }

    public final Long getReqCardTimeout() {
        return this.reqCardTimeout;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final PoiSchema getSchema() {
        return this.schema;
    }

    public final t14.a getServiceIconUrl() {
        return this.serviceIconUrl;
    }

    public final int getStyleType() {
        return this.styleType;
    }

    public final PoiItemAnchorTag getSuffix() {
        return this.suffix;
    }

    public final boolean isCommerceIntention() {
        return this.isCommerceIntention;
    }

    public final void setStyleType(int r100) {
        this.styleType = r100;
    }

    public PoiItemAnchorInfo(Boolean r100, PoiItemAnchorTag r101, List<PoiAnchorContentStruct> r102, int r103, t14.a r104, t14.a r105, t14.a r106, t14.a r110, List<Integer> r111, String r112, String r113, String r114, PoiSchema r115, boolean r116, PoiDetailModalView r117, Map<String, String> r118, int r119, boolean r210, Map<String, String> r211, Long r212, Long r213, Long r214, boolean r215, PoiVideoAnchorMargin r216) {
        this.existRelationPoi = r100;
        this.suffix = r101;
        this.minorTags = r102;
        this.extendTime = r103;
        this.poiIconUrl = r104;
        this.poiIconLightUrl = r105;
        this.serviceIconUrl = r106;
        this.cityPoiLandingIconUrl = r110;
        this.intentionOpen = r111;
        this.requestId = r112;
        this.anchorContentJson = r113;
        this.poiType = r114;
        this.schema = r115;
        this.hasMpSpu = r116;
        this.modalView = r117;
        this.logExtra = r118;
        this.styleType = r119;
        this.needRequestCard = r210;
        this.cardParams = r211;
        this.reqCardTimeout = r212;
        this.cardDataExpireTs = r213;
        this.cardMinShowTime = r214;
        this.isCommerceIntention = r215;
        this.poiVideoAnchorMargin = r216;
    }

    public /* synthetic */ PoiItemAnchorInfo(Boolean r210, PoiItemAnchorTag r211, List r212, int r310, t14.a r311, t14.a r312, t14.a r313, t14.a r314, List r315, String r316, String r317, String r318, PoiSchema r319, boolean r410, PoiDetailModalView r411, Map r412, int r413, boolean r414, Map r415, Long r416, Long r417, Long r418, boolean r419, PoiVideoAnchorMargin r510, int r511, DefaultConstructorMarker r512) {
        if ((r511 & 1) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L7:
        if ((r511 & 2) == 0) goto L9;
        PoiItemAnchorTag r101 = null;
    L11:
        if ((r511 & 4) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L15:
        if ((r511 & 8) == 0) goto L17;
        int r103 = -1;
    L19:
        if ((r511 & 16) == 0) goto L21;
        t14.a r104 = null;
    L23:
        if ((r511 & 32) == 0) goto L25;
        t14.a r105 = null;
    L27:
        if ((r511 & 64) == 0) goto L29;
        t14.a r106 = null;
    L31:
        if ((r511 & 128) == 0) goto L33;
        t14.a r110 = null;
    L35:
        if ((r511 & 256) == 0) goto L37;
        List r111 = new ArrayList();
    L38:
        String r112 = "";
        if ((r511 & 512) == 0) goto L41;
        String r113 = "";
    L43:
        if ((r511 & 1024) == 0) goto L45;
        String r114 = "";
    L47:
        if ((r511 & 2048) != 0) goto L51;
        r112 = r318;
    L51:
        if ((r511 & 4096) == 0) goto L53;
        PoiSchema r115 = null;
    L54:
        boolean r116 = false;
        if ((r511 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r511 & 16384) == 0) goto L61;
        PoiDetailModalView r108 = null;
    L63:
        if ((r511 & 32768) == 0) goto L65;
        Map r117 = null;
    L67:
        if ((r511 & 65536) == 0) goto L69;
        int r118 = -1;
    L71:
        if ((r511 & 131072) == 0) goto L73;
        boolean r119 = false;
    L75:
        if ((r511 & 262144) == 0) goto L77;
        Map r213 = null;
    L79:
        if ((r511 & 524288) == 0) goto L81;
        Long r214 = 0L;
    L83:
        if ((r511 & 1048576) == 0) goto L85;
        Long r215 = 0L;
    L87:
        if ((r511 & 2097152) == 0) goto L89;
        Long r216 = 0L;
    L91:
        if ((r511 & 4194304) != 0) goto L95;
        r116 = r419;
    L95:
        if ((r511 & 8388608) == 0) goto L97;
        PoiVideoAnchorMargin r109 = null;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r113, r114, r112, r115, r107, r108, r117, r118, r119, r213, r214, r215, r216, r116, r109);
        return;
    L97:
        r109 = r510;
        goto L98
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r214 = r416;
        goto L83
    L77:
        r213 = r415;
        goto L79
    L73:
        r119 = r414;
        goto L75
    L69:
        r118 = r413;
        goto L71
    L65:
        r117 = r412;
        goto L67
    L61:
        r108 = r411;
        goto L63
    L57:
        r107 = r410;
        goto L59
    L53:
        r115 = r319;
        goto L54
    L45:
        r114 = r317;
        goto L47
    L41:
        r113 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L38
    L33:
        r110 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
