package com.bytedance.android.shopping.store.search.router;

import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 ¢\u00012\u00020\u0001:\u0002£\u0001B5\u0012\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001b\u0010!\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R#\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00102\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010#\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R.\u00104\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\u000e\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u000e\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R\"\u0010F\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\u000e\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u000e\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012R$\u0010L\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u000e\u001a\u0004\bM\u0010\u0010\"\u0004\bN\u0010\u0012R$\u0010O\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u000e\u001a\u0004\bP\u0010\u0010\"\u0004\bQ\u0010\u0012R.\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010/\u001a\u0004\bS\u00101\"\u0004\bT\u0010UR$\u0010V\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010\u000e\u001a\u0004\bW\u0010\u0010\"\u0004\bX\u0010\u0012R$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010`\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u000e\u001a\u0004\ba\u0010\u0010\"\u0004\bb\u0010\u0012R$\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\u000e\u001a\u0004\bd\u0010\u0010\"\u0004\be\u0010\u0012R$\u0010f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000e\u001a\u0004\bg\u0010\u0010\"\u0004\bh\u0010\u0012R\"\u0010i\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010#\u001a\u0004\bi\u0010$\"\u0004\bj\u0010&R$\u0010k\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u000e\u001a\u0004\bl\u0010\u0010\"\u0004\bm\u0010\u0012R$\u0010n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010\u000e\u001a\u0004\bo\u0010\u0010\"\u0004\bp\u0010\u0012R\"\u0010q\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010#\u001a\u0004\bq\u0010$\"\u0004\br\u0010&R$\u0010s\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010\u000e\u001a\u0004\bt\u0010\u0010\"\u0004\bu\u0010\u0012R\"\u0010v\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010#\u001a\u0004\bw\u0010$\"\u0004\bx\u0010&R\u0017\u0010z\u001a\u00020y8\u0006¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R1\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u007f\u0018\u00010~8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u0086\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010\u000e\u001a\u0005\b\u0087\u0001\u0010\u0010\"\u0005\b\u0088\u0001\u0010\u0012R&\u0010\u0089\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010\u000e\u001a\u0005\b\u008a\u0001\u0010\u0010\"\u0005\b\u008b\u0001\u0010\u0012R.\u0010\u008c\u0001\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010#\u001a\u0005\b\u008c\u0001\u0010$\"\u0005\b\u008d\u0001\u0010&R(\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010\u000e\u001a\u0005\b\u008f\u0001\u0010\u0010\"\u0005\b\u0090\u0001\u0010\u0012R(\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010\u000e\u001a\u0005\b\u0092\u0001\u0010\u0010\"\u0005\b\u0093\u0001\u0010\u0012R&\u0010\u0094\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010#\u001a\u0005\b\u0094\u0001\u0010$\"\u0005\b\u0095\u0001\u0010&R\u001a\u0010\u0096\u0001\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u000e\u001a\u0005\b\u0097\u0001\u0010\u0010R\u001a\u0010\u0098\u0001\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u000e\u001a\u0005\b\u0099\u0001\u0010\u0010R\u001a\u0010\u009a\u0001\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u000e\u001a\u0005\b\u009b\u0001\u0010\u0010R\u001a\u0010\u009c\u0001\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u000e\u001a\u0005\b\u009d\u0001\u0010\u0010R\u0014\u0010\u009e\u0001\u001a\u00020Y8F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001¨\u0006¤\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putPassThroughParam", "T", "getPassThroughParam", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isPreview", "entranceInfo", "Ljava/lang/String;", "getEntranceInfo", "()Ljava/lang/String;", "setEntranceInfo", "(Ljava/lang/String;)V", "searchHint", "getSearchHint", "setSearchHint", "searchKeyword", "getSearchKeyword", "setSearchKeyword", "initSearchText", "getInitSearchText", "setInitSearchText", "Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "storeAccountParam$delegate", "Lkotlin/Lazy;", "getStoreAccountParam", "()Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "storeAccountParam", "isStoreHotSearch", "Z", "()Z", "setStoreHotSearch", "(Z)V", "enterMethod", "getEnterMethod", "setEnterMethod", "enterFrom", "getEnterFrom", "setEnterFrom", "", "passThroughParams", "Ljava/util/Map;", "getPassThroughParams", "()Ljava/util/Map;", "isHistory", "setHistory", "searchSource", "getSearchSource", "setSearchSource", "pageName", "getPageName", "setPageName", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "enterFromSecond", "getEnterFromSecond", "setEnterFromSecond", "searchParams", "getSearchParams", "setSearchParams", "roomId", "getRoomId", "setRoomId", "anchorId", "getAnchorId", "setAnchorId", "tabNameSecond", "getTabNameSecond", "setTabNameSecond", "tabLabel", "getTabLabel", "setTabLabel", "tabName", "getTabName", "setTabName", "uriParams", "getUriParams", "setUriParams", "(Ljava/util/Map;)V", "tempId", "getTempId", "setTempId", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeSourceMethod", "getStoreSourceMethod", "setStoreSourceMethod", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "isEcShare", "setEcShare", "shareContent", "getShareContent", "setShareContent", "shareObject", "getShareObject", "setShareObject", "isFromSug", "setFromSug", "groupId", "getGroupId", "setGroupId", "enableHideFloatLive", "getEnableHideFloatLive", "setEnableHideFloatLive", "Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "productBasicRequestParam", "Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "getProductBasicRequestParam", "()Lcom/bytedance/android/ec/store/common/param/ProductBasicRequestParam;", "", "Lcom/bytedance/android/shopping/store/repository/vo/SearchSuggestWord;", "searchSuggestWords", "Ljava/util/List;", "getSearchSuggestWords", "()Ljava/util/List;", "setSearchSuggestWords", "(Ljava/util/List;)V", "hotSearchMethod", "getHotSearchMethod", "setHotSearchMethod", "hotSearchIconType", "getHotSearchIconType", "setHotSearchIconType", "isSplitMode", "setSplitMode", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "shopInnerInfo", "getShopInnerInfo", "setShopInnerInfo", "isFromSearchActivity", "setFromSearchActivity", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "shopId", "getShopId", "secShopId", "getSecShopId", "isFromAd", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSearchParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_ENABLE_HIDE_FLOAT_LIVE = "enable_hide_float_live";
    private String anchorId;
    private final String authorId;
    private boolean enableHideFloatLive;
    private String enterFrom;
    private String enterFromSecond;
    private String enterMethod;
    private String entranceInfo;
    private String entranceLocation;
    private Integer followStatus;
    private String groupId;
    private String hotSearchIconType;
    private String hotSearchMethod;
    private String initSearchText;
    private boolean isEcShare;
    private boolean isFromSearchActivity;
    private boolean isFromSug;
    private boolean isHistory;
    private boolean isSplitMode;
    private boolean isStoreHotSearch;
    private String pageName;
    private final Map<String, Object> passThroughParams;
    private final ProductBasicRequestParam productBasicRequestParam;
    private String roomId;
    private String searchHint;
    private String searchKeyword;
    private String searchParams;
    private String searchSource;
    private List<SearchSuggestWord> searchSuggestWords;
    private final String secAuthorId;
    private final String secShopId;
    private String shareContent;
    private String shareObject;
    private final String shopId;
    private String shopInnerInfo;
    private String sourceBtmToken;
    private final Lazy storeAccountParam$delegate;
    private String storeGroupType;
    private String storeSourceMethod;
    private String storeSourcePage;
    private String tabLabel;
    private String tabName;
    private String tabNameSecond;
    private String tempId;
    private Map<String, Object> uriParams;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECShopSearchParam() {
        this(null, null, null, null, 15, null);
    }

    public final StoreAccountParam getStoreAccountParam() {
        return (StoreAccountParam) this.storeAccountParam$delegate.getValue();
    }

    public final int isFromAd() {
        JSONObject r0 = k.w(this.entranceInfo);
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.optInt("is_from_ad", 0);
    }

    public final boolean isPreview() {
        if (this.productBasicRequestParam.getTmpId() != null) goto L15;
        String r0 = this.productBasicRequestParam.getToken();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L15:
        return true;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final boolean getEnableHideFloatLive() {
        return this.enableHideFloatLive;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromSecond() {
        return this.enterFromSecond;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getHotSearchIconType() {
        return this.hotSearchIconType;
    }

    public final String getHotSearchMethod() {
        return this.hotSearchMethod;
    }

    public final String getInitSearchText() {
        return this.initSearchText;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final Map<String, Object> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final ProductBasicRequestParam getProductBasicRequestParam() {
        return this.productBasicRequestParam;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSearchSource() {
        return this.searchSource;
    }

    public final List<SearchSuggestWord> getSearchSuggestWords() {
        return this.searchSuggestWords;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final String getShareObject() {
        return this.shareObject;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShopInnerInfo() {
        return this.shopInnerInfo;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreSourceMethod() {
        return this.storeSourceMethod;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabNameSecond() {
        return this.tabNameSecond;
    }

    public final String getTempId() {
        return this.tempId;
    }

    public final Map<String, Object> getUriParams() {
        return this.uriParams;
    }

    public final boolean isEcShare() {
        return this.isEcShare;
    }

    public final boolean isFromSearchActivity() {
        return this.isFromSearchActivity;
    }

    public final boolean isFromSug() {
        return this.isFromSug;
    }

    public final boolean isHistory() {
        return this.isHistory;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    public final boolean isStoreHotSearch() {
        return this.isStoreHotSearch;
    }

    public final <T> T getPassThroughParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        T r3 = (T) this.passThroughParams.get(r2);
        if ((r3 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r3;
    }

    public final void setAnchorId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorId = r2;
    }

    public final void setEcShare(boolean r1) {
        this.isEcShare = r1;
    }

    public final void setEnableHideFloatLive(boolean r1) {
        this.enableHideFloatLive = r1;
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFrom = r2;
    }

    public final void setEnterFromSecond(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFromSecond = r2;
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setEntranceInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceInfo = r2;
    }

    public final void setEntranceLocation(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceLocation = r2;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setFromSearchActivity(boolean r1) {
        this.isFromSearchActivity = r1;
    }

    public final void setFromSug(boolean r1) {
        this.isFromSug = r1;
    }

    public final void setGroupId(String r1) {
        this.groupId = r1;
    }

    public final void setHistory(boolean r1) {
        this.isHistory = r1;
    }

    public final void setHotSearchIconType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hotSearchIconType = r2;
    }

    public final void setHotSearchMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hotSearchMethod = r2;
    }

    public final void setInitSearchText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.initSearchText = r2;
    }

    public final void setPageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageName = r2;
    }

    public final void setRoomId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomId = r2;
    }

    public final void setSearchHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchHint = r2;
    }

    public final void setSearchKeyword(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchKeyword = r2;
    }

    public final void setSearchParams(String r1) {
        this.searchParams = r1;
    }

    public final void setSearchSource(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        this.enterMethod = r2;
    L10:
        this.searchSource = r2;
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void setSearchSuggestWords(List<SearchSuggestWord> r1) {
        this.searchSuggestWords = r1;
    }

    public final void setShareContent(String r1) {
        this.shareContent = r1;
    }

    public final void setShareObject(String r1) {
        this.shareObject = r1;
    }

    public final void setShopInnerInfo(String r1) {
        this.shopInnerInfo = r1;
    }

    public final void setSourceBtmToken(String r1) {
        this.sourceBtmToken = r1;
    }

    public final void setSplitMode(boolean r1) {
        this.isSplitMode = r1;
    }

    public final void setStoreGroupType(String r1) {
        this.storeGroupType = r1;
    }

    public final void setStoreHotSearch(boolean r1) {
        this.isStoreHotSearch = r1;
    }

    public final void setStoreSourceMethod(String r1) {
        this.storeSourceMethod = r1;
    }

    public final void setStoreSourcePage(String r1) {
        this.storeSourcePage = r1;
    }

    public final void setTabLabel(String r1) {
        this.tabLabel = r1;
    }

    public final void setTabName(String r1) {
        this.tabName = r1;
    }

    public final void setTabNameSecond(String r1) {
        this.tabNameSecond = r1;
    }

    public final void setTempId(String r1) {
        this.tempId = r1;
    }

    public final void setUriParams(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uriParams = r2;
    }

    public final void putPassThroughParam(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.passThroughParams.put(r2, r3);
    }

    public ECShopSearchParam(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "authorId");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        Intrinsics.checkNotNullParameter(r4, "shopId");
        Intrinsics.checkNotNullParameter(r5, "secShopId");
        this.authorId = r2;
        this.secAuthorId = r3;
        this.shopId = r4;
        this.secShopId = r5;
        this.entranceInfo = "";
        this.searchHint = "";
        this.searchKeyword = "";
        this.initSearchText = "";
        this.storeAccountParam$delegate = LazyKt.lazy(ECShopSearchParam$storeAccountParam$2.INSTANCE);
        this.enterMethod = "";
        this.enterFrom = "";
        this.passThroughParams = new LinkedHashMap();
        this.pageName = "store_page";
        this.entranceLocation = "";
        this.enterFromSecond = "";
        this.roomId = "";
        this.anchorId = "";
        this.uriParams = new LinkedHashMap();
        this.followStatus = -1;
        this.productBasicRequestParam = new ProductBasicRequestParam();
        this.hotSearchMethod = "";
        this.hotSearchIconType = "";
        this.isFromSearchActivity = true;
    }

    public /* synthetic */ ECShopSearchParam(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
