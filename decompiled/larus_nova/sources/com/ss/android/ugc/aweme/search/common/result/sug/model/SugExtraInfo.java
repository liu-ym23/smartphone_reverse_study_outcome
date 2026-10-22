package com.ss.android.ugc.aweme.search.common.result.sug.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.locallife.groupon.struct.bubble.model.ElementGuideBubbleStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import com.ss.android.ugc.aweme.search.common.result.sug.utils.SugUtils;
import com.ss.android.ugc.aweme.search.utils.GsonUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 ¯\u00012\u00020\u0001:\u0002¯\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R2\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R \u00100\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b7\u0010.R\u0018\u00108\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\tR \u0010>\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR\u0018\u0010A\u001a\u0004\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR \u0010E\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010D\"\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\tR\u0018\u0010K\u001a\u0004\u0018\u00010L8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bP\u0010\u0018R\u0018\u0010Q\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\tR\u0018\u0010S\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\tR\u0018\u0010U\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\tR\u0018\u0010W\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\tR \u0010Y\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000bR \u0010\\\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\t\"\u0004\b^\u0010\u000bR \u0010_\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\t\"\u0004\ba\u0010\u000bR\u0018\u0010b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\tR\u0018\u0010d\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\tR\u0018\u0010f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\tR\u0018\u0010h\u001a\u0004\u0018\u00010i8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR \u0010l\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\t\"\u0004\bn\u0010\u000bR \u0010o\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\t\"\u0004\bq\u0010\u000bR \u0010r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\t\"\u0004\bt\u0010\u000bR\u0018\u0010u\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\tR \u0010w\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\t\"\u0004\by\u0010\u000bR \u0010z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\t\"\u0004\b|\u0010\u000bR\u0018\u0010}\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\tR\u0019\u0010\u007f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\tR\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\tR\u0013\u0010\u0083\u0001\u001a\u00020\u00168F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0018R#\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\t\"\u0005\b\u0087\u0001\u0010\u000bR\u0013\u0010\u0088\u0001\u001a\u00020\u00168F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010\u0018R\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\tR\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010DR\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\tR#\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\t\"\u0005\b\u0092\u0001\u0010\u000bR#\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\t\"\u0005\b\u0095\u0001\u0010\u000bR\u001a\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010\tR\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010\tR\u001a\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010\tR\u001a\u0010 \u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010\tR\u001a\u0010¢\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b£\u0001\u0010\tR\u001a\u0010¤\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010\tR\u001a\u0010¦\u0001\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b§\u0001\u0010\tR0\u0010¨\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010©\u00018FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u0015\u0010®\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006°\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SugExtraInfo;", "Ljava/io/Serializable;", "()V", "_isRichSug", "", "_richSugType", "_richSugUserType", "accountCertInfo", "getAccountCertInfo", "()Ljava/lang/String;", "setAccountCertInfo", "(Ljava/lang/String;)V", "canUseLongTag", "", "getCanUseLongTag", "()Z", "clientServerExtra", "getClientServerExtra", "ctrScore", "getCtrScore", "setCtrScore", "deepThink", "", "getDeepThink", "()I", "dynamicIcon", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SearchSugUrlModel;", "getDynamicIcon", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SearchSugUrlModel;", "dynamicIconLong", "getDynamicIconLong", "ecSearchSliceBffData", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcSearchSliceBffData;", "getEcSearchSliceBffData", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcSearchSliceBffData;", "setEcSearchSliceBffData", "(Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcSearchSliceBffData;)V", "ecomInterveneQuerySpreadIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getEcomInterveneQuerySpreadIds", "()Ljava/util/ArrayList;", "setEcomInterveneQuerySpreadIds", "(Ljava/util/ArrayList;)V", "ecomProductSug", "getEcomProductSug", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ecomSearchLynxData", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcomSearchLynxData;", "getEcomSearchLynxData", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcomSearchLynxData;", "setEcomSearchLynxData", "(Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcomSearchLynxData;)V", "ecommerceSugType", "getEcommerceSugType", "entryType", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EntryType;", "getEntryType", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EntryType;", "experQueryTag", "getExperQueryTag", "feedsIconText", "getFeedsIconText", "setFeedsIconText", "guideImage", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getGuideImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "hotIcon", "getHotIcon", "setHotIcon", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "iconDesc", "getIconDesc", "iconText", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SugIconText;", "getIconText", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SugIconText;", "matchType", "getMatchType", "poiId", "getPoiId", "poiLocationRecallLogId", "getPoiLocationRecallLogId", "queryTab", "getQueryTab", "queryTabExp", "getQueryTabExp", "relationType", "getRelationType", "setRelationType", "richSugAvatarUri", "getRichSugAvatarUri", "setRichSugAvatarUri", "richSugCertName", "getRichSugCertName", "setRichSugCertName", "richSugHeaderImg", "getRichSugHeaderImg", "richSugHeaderType", "getRichSugHeaderType", "richSugId", "getRichSugId", "richSugInfo", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/RichSugInfo;", "getRichSugInfo", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/RichSugInfo;", "richSugMatchType", "getRichSugMatchType", "setRichSugMatchType", "richSugNickname", "getRichSugNickname", "setRichSugNickname", "richSugRemarkName", "getRichSugRemarkName", "setRichSugRemarkName", "richSugRouter", "getRichSugRouter", "richSugSecUid", "getRichSugSecUid", "setRichSugSecUid", "richSugShortId", "getRichSugShortId", "setRichSugShortId", "richSugStyle", "getRichSugStyle", "richSugSubTitle", "getRichSugSubTitle", "richSugTitle", "getRichSugTitle", "richSugType", "getRichSugType", "richSugUid", "getRichSugUid", "setRichSugUid", "richSugUserType", "getRichSugUserType", "robotLink", "getRobotLink", "safeImage", "getSafeImage", "saleType", "getSaleType", "schemaClientEngineExtra", "getSchemaClientEngineExtra", "setSchemaClientEngineExtra", "searchParams", "getSearchParams", "setSearchParams", "specialType", "getSpecialType", "sugTabOrder", "Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SugTabOrder;", "getSugTabOrder", "()Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SugTabOrder;", "tagText", "getTagText", "tagType", "getTagType", "tailType", "getTailType", "targetTab", "getTargetTab", "targetTabInfo", "getTargetTabInfo", "targetTabType", "getTargetTabType", "trackerExtra", "", "getTrackerExtra", "()Ljava/util/Map;", "setTrackerExtra", "(Ljava/util/Map;)V", "trackerExtraRaw", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SugExtraInfo implements Serializable {
    public static final int AWEME_ID_TYPE = 1;
    public static final int BLUE_VERIFY = 1;
    public static final Companion Companion = null;
    public static final int DEEP_THINK_TYPE_AI = 1;
    public static final int DEEP_THINK_TYPE_NORMAL = 0;
    public static final int EMPTY_VERIFY = -1;
    public static final int NEW_RICH_SUG = 2;
    public static final int NICKNAME_TYPE = 0;
    public static final int NORMAL_SUG = 0;
    public static final int OLD_RICH_SUG = 1;
    public static final int POI_RICH_SUG = 3;
    public static final int POI_RICH_SUG_ICON = 4;
    public static final int REMARK_NAME_TYPE = 2;
    public static final String SPECIAL_TYPE_SEARCH_TASK_V2 = "search_task_v2";
    public static final int YELLOW_VERIFY = 0;

    @SerializedName("is_rich_sug")
    private String _isRichSug;

    @SerializedName("rich_sug_type")
    private String _richSugType;

    @SerializedName("rich_sug_user_type")
    private String _richSugUserType;

    @SerializedName("account_cert_info")
    private String accountCertInfo;

    @SerializedName("can_use_long_tag")
    private final boolean canUseLongTag;

    @SerializedName("client_server_extra")
    private final String clientServerExtra;

    @SerializedName("ctr_score")
    private String ctrScore;

    @SerializedName("deep_think")
    private final int deepThink;

    @SerializedName("tag_icon")
    private final SearchSugUrlModel dynamicIcon;

    @SerializedName("tag_icon_long")
    private final SearchSugUrlModel dynamicIconLong;

    @SerializedName("ecom_search_slice_data")
    private EcSearchSliceBffData ecSearchSliceBffData;

    @SerializedName("ecom_intervene_query_spread_ids")
    private ArrayList<String> ecomInterveneQuerySpreadIds;

    @SerializedName("ecom_product_sug")
    private final Integer ecomProductSug;

    @SerializedName("ecom_search_lynx_data")
    private EcomSearchLynxData ecomSearchLynxData;

    @SerializedName("ecommerce_sug_type")
    private final Integer ecommerceSugType;

    @SerializedName("entry_type")
    private final EntryType entryType;

    @SerializedName("exper_query_tag")
    private final String experQueryTag;

    @SerializedName("feeds_icon_text")
    private String feedsIconText;

    @SerializedName("guide_image")
    private final UrlModel guideImage;

    @SerializedName("sug_tag_icon_info")
    private UrlModel hotIcon;

    @SerializedName("icon_desc")
    private final String iconDesc;

    @SerializedName(ElementGuideBubbleStruct.STYLE_ICON_TEXT_BUBBLE)
    private final SugIconText iconText;

    @SerializedName("poi_id")
    private final String poiId;

    @SerializedName("poi_location_recall_log_id")
    private final String poiLocationRecallLogId;

    @SerializedName("query_tab")
    private final String queryTab;

    @SerializedName("query_tab_exp")
    private final String queryTabExp;

    @SerializedName("rich_sug_relation_type")
    private String relationType;

    @SerializedName("rich_sug_avatar_uri")
    private String richSugAvatarUri;

    @SerializedName("rich_sug_cert_name")
    private String richSugCertName;

    @SerializedName("rich_sug_header_img")
    private final String richSugHeaderImg;

    @SerializedName("rich_sug_header_type")
    private final String richSugHeaderType;

    @SerializedName("rich_sug_id")
    private final String richSugId;

    @SerializedName("rich_poi_info")
    private final RichSugInfo richSugInfo;

    @SerializedName("rich_sug_match_type")
    private String richSugMatchType;

    @SerializedName("rich_sug_nickname")
    private String richSugNickname;

    @SerializedName("rich_sug_remarkname")
    private String richSugRemarkName;

    @SerializedName("rich_sug_router")
    private final String richSugRouter;

    @SerializedName("rich_sug_sec_uid")
    private String richSugSecUid;

    @SerializedName("rich_sug_short_id")
    private String richSugShortId;

    @SerializedName("rich_sug_style")
    private final String richSugStyle;

    @SerializedName("rich_sug_sub_title")
    private final String richSugSubTitle;

    @SerializedName("rich_sug_title")
    private final String richSugTitle;

    @SerializedName("rich_sug_user_id")
    private String richSugUid;

    @SerializedName("robot_link")
    private final String robotLink;

    @SerializedName("safe_image")
    private final UrlModel safeImage;

    @SerializedName("sale_type")
    private final String saleType;

    @SerializedName("schema_client_engine_extra")
    private String schemaClientEngineExtra;

    @SerializedName("search_params")
    private String searchParams;

    @SerializedName("special_type")
    private final String specialType;

    @SerializedName(a.KEY_TAB_ORDER)
    private final SugTabOrder sugTabOrder;

    @SerializedName("tag_text")
    private final String tagText;

    @SerializedName(a.KEY_TAG_TYPE)
    private final String tagType;

    @SerializedName("tail_type")
    private final String tailType;

    @SerializedName("target_tab")
    private final String targetTab;

    @SerializedName("target_tab_info")
    private final String targetTabInfo;

    @SerializedName("target_tab_type")
    private final String targetTabType;
    private Map<String, String> trackerExtra;

    @SerializedName("suggest_tracker_extra")
    private String trackerExtraRaw;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/SugExtraInfo$Companion;", "", "()V", "AWEME_ID_TYPE", "", "BLUE_VERIFY", "DEEP_THINK_TYPE_AI", "DEEP_THINK_TYPE_NORMAL", "EMPTY_VERIFY", "NEW_RICH_SUG", "NICKNAME_TYPE", "NORMAL_SUG", "OLD_RICH_SUG", "POI_RICH_SUG", "POI_RICH_SUG_ICON", "REMARK_NAME_TYPE", "SPECIAL_TYPE_SEARCH_TASK_V2", "", "YELLOW_VERIFY", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final int getMatchType() {
        String r100 = this.richSugMatchType;
        if (r100 != null) goto L6;
        return 0;
    L6:
        switch(r100.hashCode()) {
            case 48: goto L14;
            case 49: goto L12;
            case 50: goto L9;
            default: goto L21;
        };
    L14:
        r100.equals("0");
        return 0;
    L21:
        return 0;
    L9:
        if (r100.equals("2") == false) goto L16;
        return 2;
    L16:
        return 0;
    L12:
        if (r100.equals("1") == false) goto L18;
        return 1;
    L18:
        return 0;
    }

    public final int getRichSugType() {
        String r100 = this.richSugStyle;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L24;
        String r102 = this.richSugHeaderType;
        if (r102 == null) goto L38;
        int r103 = r102.hashCode();
        if (r103 == (-1405959847)) goto L22;
        if (r103 != 3226745) goto L38;
        if (r102.equals("icon") == false) goto L38;
        return 4;
    L22:
        if (r102.equals("avatar") == false) goto L38;
        return 3;
    L38:
        return 0;
    L24:
        String r104 = this._richSugType;
        if (r104 == null) goto L38;
        int r105 = r104.hashCode();
        if (r105 == 49) goto L36;
        if (r105 != 50) goto L38;
        if (r104.equals("2") == false) goto L38;
        return 2;
    L36:
        if (r104.equals("1") == false) goto L38;
        return 1;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final int getRichSugUserType() {
        String r100 = this._richSugUserType;
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return -1;
    }

    public final Map<String, String> getTrackerExtra() {
        if (this.trackerExtra != null) goto L23;
        SugUtils r100 = SugUtils.f451937a;
        String r101 = this.trackerExtraRaw;
        r100.getClass();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L23;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl((Map) GsonUtil.a().fromJson(this.trackerExtraRaw, new SugExtraInfo$trackerExtra$1$1().getType()));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == false) goto L18;
        r104 = null;
    L18:
        Map<String, String> r105 = (Map) r104;
        if (r105 != null) goto L21;
        r105 = new LinkedHashMap();
    L21:
        this.trackerExtra = r105;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L7:
        if (r101.length() <= 0) goto L9;
        r102 = true;
    L23:
        return this.trackerExtra;
    }

    public SugExtraInfo() {
        this._isRichSug = "";
        this._richSugType = "";
        this.searchParams = "";
        this.schemaClientEngineExtra = "";
        this.richSugAvatarUri = "";
        this.richSugNickname = "";
        this.accountCertInfo = "";
        this.richSugMatchType = "";
        this.richSugRemarkName = "";
        this.richSugShortId = "";
        this.richSugCertName = "";
        this.relationType = "";
        this.richSugUid = "";
        this.richSugSecUid = "";
        this._richSugUserType = "";
    }

    public final String getAccountCertInfo() {
        return this.accountCertInfo;
    }

    public final boolean getCanUseLongTag() {
        return this.canUseLongTag;
    }

    public final String getClientServerExtra() {
        return this.clientServerExtra;
    }

    public final String getCtrScore() {
        return this.ctrScore;
    }

    public final int getDeepThink() {
        return this.deepThink;
    }

    public final SearchSugUrlModel getDynamicIcon() {
        return this.dynamicIcon;
    }

    public final SearchSugUrlModel getDynamicIconLong() {
        return this.dynamicIconLong;
    }

    public final EcSearchSliceBffData getEcSearchSliceBffData() {
        return this.ecSearchSliceBffData;
    }

    public final ArrayList<String> getEcomInterveneQuerySpreadIds() {
        return this.ecomInterveneQuerySpreadIds;
    }

    public final Integer getEcomProductSug() {
        return this.ecomProductSug;
    }

    public final EcomSearchLynxData getEcomSearchLynxData() {
        return this.ecomSearchLynxData;
    }

    public final Integer getEcommerceSugType() {
        return this.ecommerceSugType;
    }

    public final EntryType getEntryType() {
        return this.entryType;
    }

    public final String getExperQueryTag() {
        return this.experQueryTag;
    }

    public final String getFeedsIconText() {
        return this.feedsIconText;
    }

    public final UrlModel getGuideImage() {
        return this.guideImage;
    }

    public final UrlModel getHotIcon() {
        return this.hotIcon;
    }

    public final String getIconDesc() {
        return this.iconDesc;
    }

    public final SugIconText getIconText() {
        return this.iconText;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiLocationRecallLogId() {
        return this.poiLocationRecallLogId;
    }

    public final String getQueryTab() {
        return this.queryTab;
    }

    public final String getQueryTabExp() {
        return this.queryTabExp;
    }

    public final String getRelationType() {
        return this.relationType;
    }

    public final String getRichSugAvatarUri() {
        return this.richSugAvatarUri;
    }

    public final String getRichSugCertName() {
        return this.richSugCertName;
    }

    public final String getRichSugHeaderImg() {
        return this.richSugHeaderImg;
    }

    public final String getRichSugHeaderType() {
        return this.richSugHeaderType;
    }

    public final String getRichSugId() {
        return this.richSugId;
    }

    public final RichSugInfo getRichSugInfo() {
        return this.richSugInfo;
    }

    public final String getRichSugMatchType() {
        return this.richSugMatchType;
    }

    public final String getRichSugNickname() {
        return this.richSugNickname;
    }

    public final String getRichSugRemarkName() {
        return this.richSugRemarkName;
    }

    public final String getRichSugRouter() {
        return this.richSugRouter;
    }

    public final String getRichSugSecUid() {
        return this.richSugSecUid;
    }

    public final String getRichSugShortId() {
        return this.richSugShortId;
    }

    public final String getRichSugStyle() {
        return this.richSugStyle;
    }

    public final String getRichSugSubTitle() {
        return this.richSugSubTitle;
    }

    public final String getRichSugTitle() {
        return this.richSugTitle;
    }

    public final String getRichSugUid() {
        return this.richSugUid;
    }

    public final String getRobotLink() {
        return this.robotLink;
    }

    public final UrlModel getSafeImage() {
        return this.safeImage;
    }

    public final String getSaleType() {
        return this.saleType;
    }

    public final String getSchemaClientEngineExtra() {
        return this.schemaClientEngineExtra;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSpecialType() {
        return this.specialType;
    }

    public final SugTabOrder getSugTabOrder() {
        return this.sugTabOrder;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final String getTagType() {
        return this.tagType;
    }

    public final String getTailType() {
        return this.tailType;
    }

    public final String getTargetTab() {
        return this.targetTab;
    }

    public final String getTargetTabInfo() {
        return this.targetTabInfo;
    }

    public final String getTargetTabType() {
        return this.targetTabType;
    }

    public final void setAccountCertInfo(String r100) {
        this.accountCertInfo = r100;
    }

    public final void setCtrScore(String r100) {
        this.ctrScore = r100;
    }

    public final void setEcSearchSliceBffData(EcSearchSliceBffData r100) {
        this.ecSearchSliceBffData = r100;
    }

    public final void setEcomInterveneQuerySpreadIds(ArrayList<String> r100) {
        this.ecomInterveneQuerySpreadIds = r100;
    }

    public final void setEcomSearchLynxData(EcomSearchLynxData r100) {
        this.ecomSearchLynxData = r100;
    }

    public final void setFeedsIconText(String r100) {
        this.feedsIconText = r100;
    }

    public final void setHotIcon(UrlModel r100) {
        this.hotIcon = r100;
    }

    public final void setRelationType(String r100) {
        this.relationType = r100;
    }

    public final void setRichSugAvatarUri(String r100) {
        this.richSugAvatarUri = r100;
    }

    public final void setRichSugCertName(String r100) {
        this.richSugCertName = r100;
    }

    public final void setRichSugMatchType(String r100) {
        this.richSugMatchType = r100;
    }

    public final void setRichSugNickname(String r100) {
        this.richSugNickname = r100;
    }

    public final void setRichSugRemarkName(String r100) {
        this.richSugRemarkName = r100;
    }

    public final void setRichSugSecUid(String r100) {
        this.richSugSecUid = r100;
    }

    public final void setRichSugShortId(String r100) {
        this.richSugShortId = r100;
    }

    public final void setRichSugUid(String r100) {
        this.richSugUid = r100;
    }

    public final void setSchemaClientEngineExtra(String r100) {
        this.schemaClientEngineExtra = r100;
    }

    public final void setSearchParams(String r100) {
        this.searchParams = r100;
    }

    public final void setTrackerExtra(Map<String, String> r100) {
        this.trackerExtra = r100;
    }
}
