package com.ss.android.ugc.aweme.search.dynamic.base.model;

import com.amap.api.col.s.ce;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.ugc.aweme.discover.mixfeed.SearchCardUiInfo;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import com.ss.android.ugc.aweme.search.dynamic.api.model.IDynamicServerData;
import com.ss.android.ugc.aweme.search.model.SearchDynamicPatch;
import com.ss.android.ugc.aweme.search.model.SearchPrefetchResource;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u000e\u001a\u00020\nJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013R$\u0010#\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001018\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u0001018\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010@\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010=\u001a\u0004\bG\u0010?R$\u0010H\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010=\u001a\u0004\bI\u0010?\"\u0004\bJ\u0010KR$\u0010L\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010=\u001a\u0004\bM\u0010?\"\u0004\bN\u0010KR$\u0010O\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010=\u001a\u0004\bP\u0010?\"\u0004\bQ\u0010KR$\u0010R\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010=\u001a\u0004\bS\u0010?\"\u0004\bT\u0010KR\"\u0010X\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010A\u001a\u0004\bV\u0010C\"\u0004\bW\u0010ER$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010`\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010A\u001a\u0004\ba\u0010C\"\u0004\bb\u0010ER\"\u0010c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010A\u001a\u0004\bd\u0010C\"\u0004\be\u0010ER\"\u0010f\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010A\u001a\u0004\bg\u0010C\"\u0004\bh\u0010ER\"\u0010i\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010A\u001a\u0004\bj\u0010C\"\u0004\bk\u0010ER\"\u0010l\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010u\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010m\u001a\u0004\bs\u0010o\"\u0004\bt\u0010qR\"\u0010v\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010m\u001a\u0004\bw\u0010o\"\u0004\bx\u0010qR#\u0010\u0080\u0001\u001a\u00020y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR+\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R&\u0010\u0088\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010m\u001a\u0005\b\u0089\u0001\u0010o\"\u0005\b\u008a\u0001\u0010qR(\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010=\u001a\u0005\b\u008c\u0001\u0010?\"\u0005\b\u008d\u0001\u0010KR,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0095\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R(\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010=\u001a\u0005\b\u009b\u0001\u0010?\"\u0005\b\u009c\u0001\u0010KR1\u0010\u009d\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R(\u0010£\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010%\u001a\u0005\b¤\u0001\u0010'\"\u0005\b¥\u0001\u0010)R+\u0010¦\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010\u0096\u0001\u001a\u0006\b§\u0001\u0010\u0097\u0001\"\u0006\b¨\u0001\u0010\u0099\u0001R,\u0010©\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010\u0090\u0001\u001a\u0006\bª\u0001\u0010\u0092\u0001\"\u0006\b«\u0001\u0010\u0094\u0001R(\u0010¬\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¬\u0001\u0010=\u001a\u0005\b\u00ad\u0001\u0010?\"\u0005\b®\u0001\u0010KR1\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010\u009e\u0001\u001a\u0006\b°\u0001\u0010 \u0001\"\u0006\b±\u0001\u0010¢\u0001R&\u0010²\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010m\u001a\u0005\b³\u0001\u0010o\"\u0005\b´\u0001\u0010qR(\u0010µ\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bµ\u0001\u0010=\u001a\u0005\b¶\u0001\u0010?\"\u0005\b·\u0001\u0010KR(\u0010¸\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¸\u0001\u0010%\u001a\u0005\b¹\u0001\u0010'\"\u0005\bº\u0001\u0010)R>\u0010½\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050¼\u0001\u0018\u00010»\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b½\u0001\u00103\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R&\u0010Â\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÂ\u0001\u0010m\u001a\u0005\bÃ\u0001\u0010o\"\u0005\bÄ\u0001\u0010qR\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Æ\u0001R&\u0010Ë\u0001\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bË\u0001\u0010A\u001a\u0005\bÌ\u0001\u0010C\"\u0005\bÍ\u0001\u0010ER&\u0010Î\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÎ\u0001\u0010m\u001a\u0005\bÏ\u0001\u0010o\"\u0005\bÐ\u0001\u0010qR&\u0010Ñ\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÑ\u0001\u0010m\u001a\u0005\bÑ\u0001\u0010o\"\u0005\bÒ\u0001\u0010qR(\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÓ\u0001\u0010=\u001a\u0005\bÔ\u0001\u0010?\"\u0005\bÕ\u0001\u0010KR(\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÖ\u0001\u0010\u001e\u001a\u0005\b×\u0001\u0010 \"\u0005\bØ\u0001\u0010\"R\u001a\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÙ\u0001\u0010=R\u0018\u0010Û\u0001\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÚ\u0001\u0010?R\u0018\u0010Ý\u0001\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010?RF\u0010á\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001012\u0015\u0010Þ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bß\u0001\u0010¿\u0001\"\u0006\bà\u0001\u0010Á\u0001¨\u0006ä\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicCardData;", "Lcom/ss/android/ugc/aweme/search/model/SearchDynamicPatch;", "", "Lcom/ss/android/ugc/aweme/search/dynamic/api/model/IDynamicServerData;", "", "", "getByteSyncData", "Lcom/lynx/react/bridge/ReadableMap;", "getCommonDataMap", "data", "", "setCommonDataMap", "getLogExtraMap", "setLogExtraMap", "noDivider", "getBusinessData", "getFp", "getOps", "other", "", "equals", "", "hashCode", "requestId", "setRequestId", "getRequestId", "update", "setCardForceUpdate", "isCardForceUpdate", ce.f26391f, "Lcom/ss/android/ugc/aweme/search/model/SearchDynamicPatch;", "getDynamicPatch", "()Lcom/ss/android/ugc/aweme/search/model/SearchDynamicPatch;", "setDynamicPatch", "(Lcom/ss/android/ugc/aweme/search/model/SearchDynamicPatch;)V", "dynamicPatch", "statusHistoryLynxCard", "Ljava/lang/Integer;", "getStatusHistoryLynxCard", "()Ljava/lang/Integer;", "setStatusHistoryLynxCard", "(Ljava/lang/Integer;)V", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "uiInfo", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "getUiInfo", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "setUiInfo", "(Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;)V", "", "mServerLogData", "Ljava/util/Map;", "mSubcardCommonData", "", "providerDocId", "J", "getProviderDocId", "()J", "setProviderDocId", "(J)V", "providerDocIdStr", "Ljava/lang/String;", "getProviderDocIdStr", "()Ljava/lang/String;", "docType", "I", "getDocType", "()I", "setDocType", "(I)V", "cardId", "getCardId", "fpStr", "getFpStr", "setFpStr", "(Ljava/lang/String;)V", "cacheRawData", "getCacheRawData", "setCacheRawData", "inFeedAwemeId", "getInFeedAwemeId", "setInFeedAwemeId", "sendBack", "getSendBack", "setSendBack", RXScreenCaptureService.KEY_INDEX, "getDoubleColumnLayoutType", "setDoubleColumnLayoutType", "doubleColumnLayoutType", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "logPbBean", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPbBean", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPbBean", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "rankInSubList", "getRankInSubList", "setRankInSubList", "totalCountInParent", "getTotalCountInParent", "setTotalCountInParent", "parentRank", "getParentRank", "setParentRank", "rank", "getRank", "setRank", "needDivider", "Z", "getNeedDivider", "()Z", "setNeedDivider", "(Z)V", ce.f26395j, "getFromChunk", "setFromChunk", "fromChunk", "mNeedSkipRank", "getMNeedSkipRank", "setMNeedSkipRank", "Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicDataType;", ce.f26396k, "Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicDataType;", "getDataType", "()Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicDataType;", "setDataType", "(Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicDataType;)V", "dataType", "l", "Ljava/lang/Object;", "getJsWorkerData", "()Ljava/lang/Object;", "setJsWorkerData", "(Ljava/lang/Object;)V", "jsWorkerData", "withByteSync", "getWithByteSync", "setWithByteSync", "_conversationId", "get_conversationId", "set_conversationId", "Lcom/google/gson/JsonObject;", "realTimeReq", "Lcom/google/gson/JsonObject;", "getRealTimeReq", "()Lcom/google/gson/JsonObject;", "setRealTimeReq", "(Lcom/google/gson/JsonObject;)V", "isFold", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setFold", "(Ljava/lang/Boolean;)V", "foldId", "getFoldId", "setFoldId", "foldIdList", "Ljava/util/List;", "getFoldIdList", "()Ljava/util/List;", "setFoldIdList", "(Ljava/util/List;)V", "_needSaveHistory", "get_needSaveHistory", "set_needSaveHistory", "_use_client_style", "get_use_client_style", "set_use_client_style", "impressionServerLog", "getImpressionServerLog", "setImpressionServerLog", "preRealCardName", "getPreRealCardName", "setPreRealCardName", "bytesyncData", "getBytesyncData", "setBytesyncData", "skipBytesync", "getSkipBytesync", "setSkipBytesync", "cacheId", "getCacheId", "setCacheId", "webLoadUseHeight", "getWebLoadUseHeight", "setWebLoadUseHeight", "", "", "dirtyFields", "getDirtyFields", "()Ljava/util/Map;", "setDirtyFields", "(Ljava/util/Map;)V", "cardHeightPosted", "getCardHeightPosted", "setCardHeightPosted", "commonData", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource;", "mSearchPrefetchResource", "Lcom/ss/android/ugc/aweme/search/model/SearchPrefetchResource;", "logExtraFromHorizontal", "page", "getPage", "setPage", "top1AutoExpandIfShownFlag", "getTop1AutoExpandIfShownFlag", "setTop1AutoExpandIfShownFlag", "isTopOneExposedFlag", "setTopOneExposedFlag", "searchRecoBlendIntent", "getSearchRecoBlendIntent", "setSearchRecoBlendIntent", "questionnaireInfo", "getQuestionnaireInfo", "setQuestionnaireInfo", "mRequestId", "getUrl", "url", "getTypeName", "typeName", "value", "getServerLogData", "setServerLogData", "serverLogData", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicCardData extends SearchDynamicPatch implements IDynamicServerData {

    @SerializedName("conversation_id")
    private String _conversationId;

    @SerializedName("need_save_history")
    private Integer _needSaveHistory;

    @SerializedName("use_client_style")
    private Boolean _use_client_style;

    @SerializedName("bytesync_data")
    private List<String> bytesyncData;

    @SerializedName("cache_id")
    private String cacheId;

    @SerializedName("cache_raw_data")
    private String cacheRawData;
    private boolean cardHeightPosted;

    @SerializedName("card_id")
    private final String cardId;
    private ReadableMap commonData;

    @Expose(deserialize = false, serialize = false)
    private transient Map<Object, ? extends Set<String>> dirtyFields;

    @SerializedName("doc_type")
    private int docType;

    @SerializedName("fold_id")
    private String foldId;

    @SerializedName("fold_id_list")
    private List<String> foldIdList;

    @SerializedName("fp")
    private String fpStr;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient SearchDynamicPatch f452585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient boolean f452586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f452587i;

    @SerializedName("impression_server_log")
    private JsonObject impressionServerLog;
    private String inFeedAwemeId;

    @SerializedName("is_fold")
    private Boolean isFold;

    @SerializedName("is_top_one_exposed")
    private boolean isTopOneExposedFlag;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient boolean f452588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient DynamicDataType f452589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public transient Object f452590l;
    private ReadableMap logExtraFromHorizontal;
    private LogPbBean logPbBean;
    private boolean mNeedSkipRank;
    private String mRequestId;

    @SerializedName("prefetch_resource")
    private final SearchPrefetchResource mSearchPrefetchResource;

    @SerializedName("log_data")
    private Map<String, String> mServerLogData;

    @SerializedName("subcard_common_data")
    private Map<String, Object> mSubcardCommonData;
    private boolean needDivider;
    private int page;
    private int parentRank;

    @SerializedName("pre_real_card_name")
    private String preRealCardName;

    @SerializedName("provider_doc_id")
    private long providerDocId;

    @SerializedName("provider_doc_id_str")
    private final String providerDocIdStr;

    @SerializedName("questionnaire_info")
    private SearchDynamicPatch questionnaireInfo;
    private int rank;
    private int rankInSubList;

    @SerializedName("ai_search_real_time_req")
    private JsonObject realTimeReq;

    @SerializedName("search_reco_blend_intent")
    private String searchRecoBlendIntent;

    @SerializedName("send_back")
    private String sendBack;

    @SerializedName("skip_bytesync")
    private boolean skipBytesync;
    private Integer statusHistoryLynxCard;

    @SerializedName("top1_auto_expand_if_shown")
    private boolean top1AutoExpandIfShownFlag;
    private int totalCountInParent;

    @SerializedName("ui_info")
    private SearchCardUiInfo uiInfo;

    @SerializedName("web_load_use_height")
    private Integer webLoadUseHeight;

    @SerializedName("with_bytesync")
    private boolean withByteSync;

    @Override // com.ss.android.ugc.aweme.search.dynamic.api.model.IDynamicServerData
    public Object getBusinessData() {
        return this;
    }

    public final Object getOps() {
        return null;
    }

    public final List<String> getByteSyncData() {
        List<String> r100 = this.bytesyncData;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return null;
    }

    public String getTypeName() {
        SearchDynamicPatch r100 = this.f452585g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.cardTypeName;
    }

    @Override // com.ss.android.ugc.aweme.search.dynamic.api.model.IDynamicServerData
    public String getUrl() {
        SearchDynamicPatch r100 = this.f452585g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.schema;
    }

    public final void noDivider() {
        SearchCardUiInfo r100 = this.uiInfo;
        boolean r101 = true;
        if (r100 != null) goto L6;
        SearchCardUiInfo r102 = new SearchCardUiInfo();
        r102.setHideDivider(1);
        this.uiInfo = r102;
        return;
    L6:
        if (r100 != null) goto L8;
    L10:
        r101 = false;
    L11:
        if (r101 == true) goto L13;
        return;
    L13:
        SearchCardUiInfo r103 = this.uiInfo;
        if (r103 == null) goto L19;
        r103.setHideDivider(1);
        return;
    L19:
        return;
    L8:
        if (r100.enableHideDividerInFusionCard() != true) goto L10;
        goto L10
    }

    public DynamicCardData() {
        this.f452585g = this;
        this.statusHistoryLynxCard = -1;
        this.providerDocId = -1;
        this.fpStr = "";
        this.f452587i = -1;
        this.rankInSubList = -1;
        this.totalCountInParent = -1;
        this.parentRank = -1;
        this.rank = -1;
        this.needDivider = true;
        this.f452589k = DynamicDataType.LYNX;
        this.page = -1;
    }

    @Override // com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch
    public int hashCode() {
        int r100 = ((super.hashCode() * 31) + getAwemeIndex()) * 31;
        String r101 = getWaterfallLayoutSchema();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = getWaterfallLayoutSingleSchema();
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.fallbackLynxSchema;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((r107 + r109) * 31) + getFilteredInVideoDetail()) * 31;
        Map<String, Object> r111 = this.subcardCommonData;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        JSONObject r114 = getRawDataJson();
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        SearchCardUiInfo r117 = this.uiInfo;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        Map<String, String> r120 = this.mServerLogData;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        Map<String, Object> r123 = this.mSubcardCommonData;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        LogPbBean r126 = this.logPbBean;
        if (r126 == null) goto L37;
        int r127 = r126.hashCode();
    L38:
        int r128 = (((((((((((r125 + r127) * 31) + 0) * 31) + this.rankInSubList) * 31) + this.totalCountInParent) * 31) + this.parentRank) * 31) + this.rank) * 31;
        int r129 = 1231;
        if (this.needDivider == false) goto L41;
        int r130 = 1231;
    L42:
        int r131 = (r128 + r130) * 31;
        if (this.f452588j == false) goto L45;
        int r132 = 1231;
    L46:
        int r133 = (r131 + r132) * 31;
        ReadableMap r134 = this.commonData;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        ReadableMap r137 = this.logExtraFromHorizontal;
        if (r137 == null) goto L53;
        r102 = r137.hashCode();
    L53:
        int r138 = (r136 + r102) * 31;
        if (this.cardHeightPosted == true) goto L58;
        r129 = 1237;
    L58:
        return r138 + r129;
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 1237;
        goto L46
    L41:
        r130 = 1237;
        goto L42
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final List<String> getBytesyncData() {
        return this.bytesyncData;
    }

    public final String getCacheId() {
        return this.cacheId;
    }

    public final String getCacheRawData() {
        return this.cacheRawData;
    }

    public final boolean getCardHeightPosted() {
        return this.cardHeightPosted;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final ReadableMap getCommonDataMap() {
        return this.commonData;
    }

    public final DynamicDataType getDataType() {
        return this.f452589k;
    }

    public final Map<Object, Set<String>> getDirtyFields() {
        return this.dirtyFields;
    }

    public final int getDocType() {
        return this.docType;
    }

    public final int getDoubleColumnLayoutType() {
        return this.f452587i;
    }

    public final SearchDynamicPatch getDynamicPatch() {
        return this.f452585g;
    }

    public final String getFoldId() {
        return this.foldId;
    }

    public final List<String> getFoldIdList() {
        return this.foldIdList;
    }

    public final String getFp() {
        return this.fpStr;
    }

    public final String getFpStr() {
        return this.fpStr;
    }

    public final boolean getFromChunk() {
        return this.f452588j;
    }

    public final JsonObject getImpressionServerLog() {
        return this.impressionServerLog;
    }

    public final String getInFeedAwemeId() {
        return this.inFeedAwemeId;
    }

    public final Object getJsWorkerData() {
        return this.f452590l;
    }

    public final ReadableMap getLogExtraMap() {
        return this.logExtraFromHorizontal;
    }

    public final LogPbBean getLogPbBean() {
        return this.logPbBean;
    }

    public final boolean getMNeedSkipRank() {
        return this.mNeedSkipRank;
    }

    public final boolean getNeedDivider() {
        return this.needDivider;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getParentRank() {
        return this.parentRank;
    }

    public final String getPreRealCardName() {
        return this.preRealCardName;
    }

    public final long getProviderDocId() {
        return this.providerDocId;
    }

    public final String getProviderDocIdStr() {
        return this.providerDocIdStr;
    }

    public final SearchDynamicPatch getQuestionnaireInfo() {
        return this.questionnaireInfo;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getRankInSubList() {
        return this.rankInSubList;
    }

    public final JsonObject getRealTimeReq() {
        return this.realTimeReq;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public final String getSearchRecoBlendIntent() {
        return this.searchRecoBlendIntent;
    }

    public final String getSendBack() {
        return this.sendBack;
    }

    public final Map<String, String> getServerLogData() {
        return this.mServerLogData;
    }

    public final boolean getSkipBytesync() {
        return this.skipBytesync;
    }

    public final Integer getStatusHistoryLynxCard() {
        return this.statusHistoryLynxCard;
    }

    public final boolean getTop1AutoExpandIfShownFlag() {
        return this.top1AutoExpandIfShownFlag;
    }

    public final int getTotalCountInParent() {
        return this.totalCountInParent;
    }

    public final SearchCardUiInfo getUiInfo() {
        return this.uiInfo;
    }

    public final Integer getWebLoadUseHeight() {
        return this.webLoadUseHeight;
    }

    public final boolean getWithByteSync() {
        return this.withByteSync;
    }

    public final String get_conversationId() {
        return this._conversationId;
    }

    public final Integer get_needSaveHistory() {
        return this._needSaveHistory;
    }

    public final Boolean get_use_client_style() {
        return this._use_client_style;
    }

    public final boolean isCardForceUpdate() {
        return this.f452586h;
    }

    public final Boolean isFold() {
        return this.isFold;
    }

    public final boolean isTopOneExposedFlag() {
        return this.isTopOneExposedFlag;
    }

    @Override // com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(DynamicCardData.class, r101) == true) goto L13;
        return false;
    L13:
        if (super.equals(r100) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.ugc.aweme.search.dynamic.base.model.DynamicCardData");
        DynamicCardData r102 = (DynamicCardData) r100;
        if (getAwemeIndex() == r102.getAwemeIndex()) goto L19;
        return false;
    L19:
        if (getFilteredInVideoDetail() == r102.getFilteredInVideoDetail()) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(getWaterfallLayoutSchema(), r102.getWaterfallLayoutSchema()) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(getWaterfallLayoutSingleSchema(), r102.getWaterfallLayoutSingleSchema()) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.fallbackLynxSchema, r102.fallbackLynxSchema) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.uiInfo, r102.uiInfo) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.mServerLogData, r102.mServerLogData) == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.mSubcardCommonData, r102.mSubcardCommonData) == true) goto L40;
    L38:
        return false;
    L40:
        if (Intrinsics.areEqual(this.logPbBean, r102.logPbBean) == false) goto L38;
        if (this.rankInSubList != r102.rankInSubList) goto L38;
        if (this.totalCountInParent != r102.totalCountInParent) goto L38;
        if (this.parentRank != r102.parentRank) goto L38;
        if (Intrinsics.areEqual(null, null) == false) goto L38;
        if (this.rank != r102.rank) goto L38;
        if (this.needDivider != r102.needDivider) goto L38;
        if (this.f452588j != r102.f452588j) goto L38;
        if (Intrinsics.areEqual(this.commonData, r102.commonData) == false) goto L38;
        if (Intrinsics.areEqual(this.logExtraFromHorizontal, r102.logExtraFromHorizontal) == false) goto L38;
        if (this.cardHeightPosted != r102.cardHeightPosted) goto L38;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setBytesyncData(List<String> r100) {
        this.bytesyncData = r100;
    }

    public final void setCacheId(String r100) {
        this.cacheId = r100;
    }

    public final void setCacheRawData(String r100) {
        this.cacheRawData = r100;
    }

    public final void setCardForceUpdate(boolean r100) {
        this.f452586h = r100;
    }

    public final void setCardHeightPosted(boolean r100) {
        this.cardHeightPosted = r100;
    }

    public final void setCommonDataMap(ReadableMap r100) {
        this.commonData = r100;
    }

    public final void setDataType(DynamicDataType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f452589k = r100;
    }

    public final void setDirtyFields(Map<Object, ? extends Set<String>> r100) {
        this.dirtyFields = r100;
    }

    public final void setDocType(int r100) {
        this.docType = r100;
    }

    public final void setDoubleColumnLayoutType(int r100) {
        this.f452587i = r100;
    }

    public final void setDynamicPatch(SearchDynamicPatch r100) {
        this.f452585g = r100;
    }

    public final void setFold(Boolean r100) {
        this.isFold = r100;
    }

    public final void setFoldId(String r100) {
        this.foldId = r100;
    }

    public final void setFoldIdList(List<String> r100) {
        this.foldIdList = r100;
    }

    public final void setFpStr(String r100) {
        this.fpStr = r100;
    }

    public final void setFromChunk(boolean r100) {
        this.f452588j = r100;
    }

    public final void setImpressionServerLog(JsonObject r100) {
        this.impressionServerLog = r100;
    }

    public final void setInFeedAwemeId(String r100) {
        this.inFeedAwemeId = r100;
    }

    public final void setJsWorkerData(Object r100) {
        this.f452590l = r100;
    }

    public final void setLogExtraMap(ReadableMap r100) {
        this.logExtraFromHorizontal = r100;
    }

    public final void setLogPbBean(LogPbBean r100) {
        this.logPbBean = r100;
    }

    public final void setMNeedSkipRank(boolean r100) {
        this.mNeedSkipRank = r100;
    }

    public final void setNeedDivider(boolean r100) {
        this.needDivider = r100;
    }

    public final void setPage(int r100) {
        this.page = r100;
    }

    public final void setParentRank(int r100) {
        this.parentRank = r100;
    }

    public final void setPreRealCardName(String r100) {
        this.preRealCardName = r100;
    }

    public final void setProviderDocId(long r100) {
        this.providerDocId = r100;
    }

    public final void setQuestionnaireInfo(SearchDynamicPatch r100) {
        this.questionnaireInfo = r100;
    }

    public final void setRank(int r100) {
        this.rank = r100;
    }

    public final void setRankInSubList(int r100) {
        this.rankInSubList = r100;
    }

    public final void setRealTimeReq(JsonObject r100) {
        this.realTimeReq = r100;
    }

    public void setRequestId(String r100) {
        this.mRequestId = r100;
        SearchDynamicPatch r101 = this.f452585g;
        if (r101 == null) goto L10;
        List<Aweme> r102 = r101.getAwemeList();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        ((Aweme) r103.next()).setRequestIdP(r100);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void setSearchRecoBlendIntent(String r100) {
        this.searchRecoBlendIntent = r100;
    }

    public final void setSendBack(String r100) {
        this.sendBack = r100;
    }

    public final void setServerLogData(Map<String, String> r100) {
        this.mServerLogData = r100;
    }

    public final void setSkipBytesync(boolean r100) {
        this.skipBytesync = r100;
    }

    public final void setStatusHistoryLynxCard(Integer r100) {
        this.statusHistoryLynxCard = r100;
    }

    public final void setTop1AutoExpandIfShownFlag(boolean r100) {
        this.top1AutoExpandIfShownFlag = r100;
    }

    public final void setTopOneExposedFlag(boolean r100) {
        this.isTopOneExposedFlag = r100;
    }

    public final void setTotalCountInParent(int r100) {
        this.totalCountInParent = r100;
    }

    public final void setUiInfo(SearchCardUiInfo r100) {
        this.uiInfo = r100;
    }

    public final void setWebLoadUseHeight(Integer r100) {
        this.webLoadUseHeight = r100;
    }

    public final void setWithByteSync(boolean r100) {
        this.withByteSync = r100;
    }

    public final void set_conversationId(String r100) {
        this._conversationId = r100;
    }

    public final void set_needSaveHistory(Integer r100) {
        this._needSaveHistory = r100;
    }

    public final void set_use_client_style(Boolean r100) {
        this._use_client_style = r100;
    }
}
