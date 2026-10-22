package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.bytedance.awemeopen.bizmodels.repo.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¶\u0001\u0010·\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R$\u0010?\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u00107\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R$\u0010B\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u00107\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R$\u0010E\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u00107\u001a\u0004\bF\u00109\"\u0004\bG\u0010;R$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0012\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R$\u0010Q\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0018\u001a\u0004\bR\u0010\u001a\"\u0004\bS\u0010\u001cR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0004\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR$\u0010W\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0018\u001a\u0004\bX\u0010\u001a\"\u0004\bY\u0010\u001cR$\u0010Z\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0018\u001a\u0004\b[\u0010\u001a\"\u0004\b\\\u0010\u001cR\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\"\u0010a\u001a\u00020`8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u00107\u001a\u0004\bh\u00109\"\u0004\bi\u0010;R$\u0010j\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u00107\u001a\u0004\bk\u00109\"\u0004\bl\u0010;R$\u0010m\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bm\u00107\u001a\u0004\bn\u00109\"\u0004\bo\u0010;R\"\u0010p\u001a\u00020`8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010b\u001a\u0004\bq\u0010d\"\u0004\br\u0010fR\u001c\u0010s\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\bs\u0010\u0018\u001a\u0004\bt\u0010\u001aR\u001c\u0010u\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\bu\u0010\u0018\u001a\u0004\bv\u0010\u001aR\u001a\u0010w\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bw\u0010\u0004\u001a\u0004\bx\u0010\u0006R\u001c\u0010z\u001a\u0004\u0018\u00010y8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006X\u0087D¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0086\u0001\u001a\u00030\u0081\u00018\u0006X\u0087D¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0083\u0001\u001a\u0006\b\u0087\u0001\u0010\u0085\u0001R\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0018\u001a\u0005\b\u0089\u0001\u0010\u001aR\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0018\u001a\u0005\b\u008b\u0001\u0010\u001aR\u001d\u0010\u008c\u0001\u001a\u00020\u00108\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0012\u001a\u0005\b\u008c\u0001\u0010\u0013R\u001f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0018\u001a\u0005\b\u008e\u0001\u0010\u001aR(\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010\u0018\u001a\u0005\b\u0090\u0001\u0010\u001a\"\u0005\b\u0091\u0001\u0010\u001cR2\u0010\u0093\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0092\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001d\u0010\u0099\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006R&\u0010\u009b\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010\u0012\u001a\u0005\b\u009b\u0001\u0010\u0013\"\u0005\b\u009c\u0001\u0010\u0015R&\u0010\u009d\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010\u0004\u001a\u0005\b\u009e\u0001\u0010\u0006\"\u0005\b\u009f\u0001\u0010\bR3\u0010¡\u0001\u001a\f\u0012\u0005\u0012\u00030 \u0001\u0018\u00010\u0092\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010\u0094\u0001\u001a\u0006\b¢\u0001\u0010\u0096\u0001\"\u0006\b£\u0001\u0010\u0098\u0001R(\u0010¤\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010\u0018\u001a\u0005\b¥\u0001\u0010\u001a\"\u0005\b¦\u0001\u0010\u001cR&\u0010§\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010\u0004\u001a\u0005\b¨\u0001\u0010\u0006\"\u0005\b©\u0001\u0010\bR,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\"\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001¨\u0006¸\u0001"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/t;", "", "", "withRecommendTag", "I", "getWithRecommendTag", "()I", "setWithRecommendTag", "(I)V", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/k;", "poiJsonStruct", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/k;", "e", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/k;", "setPoiJsonStruct", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/k;)V", "", "isWithinGeoFence", "Z", "()Z", "setWithinGeoFence", "(Z)V", "", "poiId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setPoiId", "(Ljava/lang/String;)V", "poiName", "f", "setPoiName", "typeCode", "getTypeCode", "setTypeCode", "isTopRecommend", "setTopRecommend", "userCount", "getUserCount", "setUserCount", "itemCount", "getItemCount", "setItemCount", "viewCount", "getViewCount", "setViewCount", "Lx14/a;", "shareInfo", "Lx14/a;", "getShareInfo", "()Lx14/a;", "setShareInfo", "(Lx14/a;)V", "Lt14/a;", "coverHd", "Lt14/a;", "getCoverHd", "()Lt14/a;", "setCoverHd", "(Lt14/a;)V", "coverLarge", "getCoverLarge", "setCoverLarge", "coverMedium", "getCoverMedium", "setCoverMedium", "coverThumb", "getCoverThumb", "setCoverThumb", "coverItem", "getCoverItem", "setCoverItem", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/a;", "address", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/a;", "getAddress", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/a;", "setAddress", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/a;)V", "isAdminArea", "setAdminArea", "distance", "getDistance", "setDistance", "iconType", "getIconType", "setIconType", "poiLongitude", "getPoiLongitude", "setPoiLongitude", "poiLatitude", "getPoiLatitude", "setPoiLatitude", "collectStatus", "getCollectStatus", "setCollectStatus", "", "expandType", "J", "getExpandType", "()J", "setExpandType", "(J)V", "iconOnMap", "getIconOnMap", "setIconOnMap", "iconOnEntry", "c", "setIconOnEntry", "iconOnInfo", "getIconOnInfo", "setIconOnInfo", "poiType", "getPoiType", "setPoiType", "poiVoucher", "getPoiVoucher", "poiSubTitle", "getPoiSubTitle", "poiSubTitleType", "getPoiSubTitleType", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/h;", "poiCard", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/h;", "getPoiCard", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/h;", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/g;", "poiBackendType", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/g;", "", "poiRating", "D", "getPoiRating", "()D", "poiCost", "getPoiCost", "poiRankDesc", "getPoiRankDesc", "poiBusinessAreaName", "getPoiBusinessAreaName", "isPoiIsLocalCity", "poiOptionName", "getPoiOptionName", "collectCount", "getCollectCount", "setCollectCount", "", "voucherReleaseAreas", "Ljava/util/List;", "getVoucherReleaseAreas", "()Ljava/util/List;", "setVoucherReleaseAreas", "(Ljava/util/List;)V", "showHalfCard", "getShowHalfCard", "isCandidate", "setCandidate", "hasRate", "getHasRate", "setHasRate", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/s;", "mPoiServiceFlags", "getMPoiServiceFlags", "setMPoiServiceFlags", "feedTag", "getFeedTag", "setFeedTag", "hasGuessExpect", "getHasGuessExpect", "setHasGuessExpect", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/j;", "douLandlordInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/j;", "getDouLandlordInfo", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/j;", "setDouLandlordInfo", "(Lcom/bytedance/awemeopen/bizmodels/feed/poi/j;)V", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/q;", "poiProductSimpleInfo", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/q;", "getPoiProductSimpleInfo", "()Lcom/bytedance/awemeopen/bizmodels/feed/poi/q;", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class t {

    @SerializedName("address_info")
    private a address;

    @SerializedName("collected_count")
    private String collectCount;

    @SerializedName("collect_stat")
    private int collectStatus;

    @SerializedName("cover_hd")
    private t14.a coverHd;

    @SerializedName("cover_item")
    private t14.a coverItem;

    @SerializedName("cover_large")
    private t14.a coverLarge;

    @SerializedName("cover_medium")
    private t14.a coverMedium;

    @SerializedName("cover_thumb")
    private t14.a coverThumb;

    @SerializedName("distance")
    private String distance;

    @SerializedName("dou_landlord_info")
    private j douLandlordInfo;

    @SerializedName("expand_type")
    private long expandType;

    @SerializedName("item_tag")
    private String feedTag;

    @SerializedName("guess_expect")
    private int hasGuessExpect;

    @SerializedName("has_rate")
    private int hasRate;

    @SerializedName("icon_on_entry")
    private t14.a iconOnEntry;

    @SerializedName("icon_on_info")
    private t14.a iconOnInfo;

    @SerializedName("icon_on_map")
    private t14.a iconOnMap;

    @SerializedName("icon_type")
    private int iconType;

    @SerializedName("is_admin_area")
    private boolean isAdminArea;

    @SerializedName("is_candidate")
    private boolean isCandidate;

    @SerializedName("is_local_city")
    private final boolean isPoiIsLocalCity;

    @SerializedName("is_top_recommend")
    private boolean isTopRecommend;

    @SerializedName("within_geo_fence")
    private boolean isWithinGeoFence;

    @SerializedName("item_count")
    private int itemCount;

    @SerializedName("icon_service_type_list")
    private List<s> mPoiServiceFlags;

    @SerializedName("poi_backend_type")
    private g poiBackendType;

    @SerializedName("business_area_name")
    private final String poiBusinessAreaName;

    @SerializedName("poi_card")
    private final h poiCard;

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    private final double poiCost;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("ext_json")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private k poiJsonStruct;

    @SerializedName("poi_latitude")
    private String poiLatitude;

    @SerializedName("poi_longitude")
    private String poiLongitude;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("option_name")
    private final String poiOptionName;

    @SerializedName("product_simple")
    private final q poiProductSimpleInfo;

    @SerializedName("poi_rank_desc")
    private final String poiRankDesc;

    @SerializedName("rating")
    private final double poiRating;

    @SerializedName("poi_subtitle")
    private final String poiSubTitle;

    @SerializedName("poi_subtitle_type")
    private final int poiSubTitleType;

    @SerializedName("poi_type")
    private long poiType;

    @SerializedName("poi_voucher")
    private final String poiVoucher;

    @SerializedName("share_info")
    private x14.a shareInfo;

    @SerializedName("is_show_halfcard")
    private final int showHalfCard;

    @SerializedName("type_code")
    private String typeCode;

    @SerializedName("user_count")
    private int userCount;

    @SerializedName("view_count")
    private String viewCount;

    @SerializedName("voucher_release_areas")
    private List<String> voucherReleaseAreas;

    @SerializedName("with_recommend_tag")
    private int withRecommendTag;

    public final String a() {
        g r100 = this.poiBackendType;
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String b() {
        a r100 = this.address;
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public t() {
        new LinkedHashMap();
    }

    public final t14.a c() {
        return this.iconOnEntry;
    }

    public final String d() {
        return this.poiId;
    }

    public final k e() {
        return this.poiJsonStruct;
    }

    public final String f() {
        return this.poiName;
    }
}
